package io.moj.java.sdk.auth;

/**
 * Listener for authentication failure events. Useful for handling authentication issues on a cross-cutting basis such
 * as prompting the user to log in again.
 * Created by skidson on 2016-04-13.
 */
public interface OnAccessTokenExpiredListener {

    void onAccessTokenExpired();

}
