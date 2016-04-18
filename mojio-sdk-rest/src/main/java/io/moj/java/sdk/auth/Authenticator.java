package io.moj.java.sdk.auth;

/**
 * Interface responsible for storing, retrieving, and refreshing of access tokens.
 * Created by skidson on 2016-04-13.
 */
public interface Authenticator {

    /**
     * Authenticates the user with the given username and password
     * @param token
     * @return
     */
    void setAccessToken(AccessToken token);

    /**
     * Returns the stored {@link io.moj.java.sdk.auth.AccessToken}. If this token is expired, this method should
     * synchronously refresh it and return the refreshed token.
     * @return the current access token or null if no user is authenticated.
     */
    AccessToken getAccessToken();

    /**
     * Indicates that this access token should be invalidated. This is usually called when a request using this access
     * token encountered an authentication error (e.g. {@link java.net.HttpURLConnection#HTTP_UNAUTHORIZED}).
     * Subsequent calls to {@link #getAccessToken()} should return a refreshed access token.
     * @param accessToken
     */
    void invalidateAccessToken(AccessToken accessToken);

}
