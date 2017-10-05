package io.moj.java.sdk.auth;

import io.moj.java.sdk.logging.Log;
import io.moj.java.sdk.MojioAuthApi;
import io.moj.java.sdk.model.response.AuthResponse;
import retrofit2.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Default {@link io.moj.java.sdk.auth.Authenticator} implementation that performs basic fetching, catching, and
 * refreshing of Mojio access tokens.
 * Created by skidson on 2016-04-13.
 */
public class DefaultAuthenticator implements Authenticator {

    private static final String TAG = DefaultAuthenticator.class.getSimpleName();

    private final Object lock = new Object();

    private MojioAuthApi api;
    private Client client;
    private AccessToken accessToken;
    private boolean invalidated = false;

    public DefaultAuthenticator(MojioAuthApi api, Client client) {
        this.api = api;
        this.client = client;
    }

    @Override
    public void setAccessToken(AccessToken token) {
        synchronized (lock) {
            this.accessToken = token;
        }
    }

    @Override
    public AccessToken getAccessToken() {
        synchronized (lock) {
            if (accessToken == null) {
                return null;
            }

            if (invalidated || accessToken.isExpired()) {
                invalidated = false;
                accessToken = refreshAccessToken(accessToken);
            }

            return accessToken;
        }
    }

    @Override
    public void invalidateAccessToken(AccessToken accessToken) {
        if (accessToken == null) {
            return;
        }

        synchronized (lock) {
            if (accessToken.equals(this.accessToken)) {
                invalidated = true;
            }
        }
    }

    private AccessToken refreshAccessToken(AccessToken accessToken) {
        if (accessToken.getRefreshToken() == null || accessToken.getRefreshToken().isEmpty()) {
            return accessToken;
        }

        try {
            long requestTimestamp = System.currentTimeMillis();
            Response<AuthResponse> response = api.refresh(MojioAuthApi.GRANT_TYPE_REFRESH,
                    accessToken.getRefreshToken(), client.getKey(), client.getSecret()).execute();
            if (response.isSuccessful()) {
                AuthResponse authResponse = response.body();
                accessToken = new AccessToken(authResponse.getAccessToken(), authResponse.getRefreshToken(),
                        requestTimestamp + TimeUnit.SECONDS.toMillis(authResponse.getExpiresIn()));
            } else {
                // TODO log failure here?
                return null;
            }
        } catch (IOException e) {
            Log.e(TAG, "Error trying to refresh access token", e);
        }

        return accessToken;
    }

}
