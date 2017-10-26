package io.moj.java.sdk;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Blanket interceptor for all Mojio platform requests.
 * Created by Mauro on 2017-10-26.
 */
public class MojioInterceptor implements Interceptor {

    private String userAgent;

    public MojioInterceptor(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (userAgent != null) {
            Request.Builder requestBuilder = request.newBuilder();

            String userAgentHeader = request.header("User-Agent");
            userAgentHeader = userAgentHeader == null || userAgentHeader.equals("")
                    ? userAgent
                    : userAgent + " " + userAgentHeader;
            requestBuilder.header("User-Agent", userAgentHeader);

            request = requestBuilder.build();
        }
        return chain.proceed(request);
    }
}
