package io.moj.java.sdk.auth;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * OkHttp {@link Interceptor} that adds the app's access token to request headers.
 * Created by skidson on 16-02-11.
 */
public class AuthInterceptor implements Interceptor {

    private Authenticator authenticator;
    private OnAccessTokenExpiredListener listener;

    public AuthInterceptor(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return doIntercept(chain, 3);
    }

    private Response doIntercept(Chain chain, int retryCount) throws IOException {
        retryCount--;
        Request request = chain.request();

        // set the access token in the header if we have it
        AccessToken accessToken = authenticator.getAccessToken();
        Request.Builder requestBuilder = request.newBuilder();
        if (accessToken != null) {
            requestBuilder.header("Authorization", "Bearer " + accessToken.getAccessToken());
        }
        requestBuilder.addHeader("Content-Type", "application/json");
        requestBuilder.addHeader("Accept", "application/json");
        request = requestBuilder.build();

        Response response = chain.proceed(request);
        if (response.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
            // we got a 401 - Unauthorized, first try forcing the token to refresh, if that doesn't
            // work, then broadcast that this access token is no longer valid
            if (retryCount >= 0) {
                ResponseBody responseBody = response.body();
                if (responseBody != null) {
                    responseBody.close();
                }

                authenticator.invalidateAccessToken(accessToken);
                response = doIntercept(chain, retryCount);
            } else {
                if (listener != null) {
                    listener.onAccessTokenExpired();
                }
            }
        }
        return response;
    }

    public void setOnAccessTokenExpiredListener(OnAccessTokenExpiredListener listener) {
        this.listener = listener;
    }
}
