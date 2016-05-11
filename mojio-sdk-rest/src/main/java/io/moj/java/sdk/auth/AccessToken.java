package io.moj.java.sdk.auth;

/**
 * Model class to encapsulate an access token with its expiration timestamp.
 * Created by skidson on 2016-04-13.
 */
public class AccessToken {

    private String accessToken;
    private String refreshToken;
    private long expirationTimestamp;

    public AccessToken(String accessToken, long expirationTimestamp) {
        this(accessToken, null, expirationTimestamp);
    }

    public AccessToken(String accessToken, String refreshToken, long expirationTimestamp) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expirationTimestamp = expirationTimestamp;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public long getExpirationTimestamp() {
        return expirationTimestamp;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expirationTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccessToken that = (AccessToken) o;

        return accessToken != null ? accessToken.equals(that.accessToken) : that.accessToken == null;

    }

    @Override
    public int hashCode() {
        return accessToken != null ? accessToken.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", expirationTimestamp=" + expirationTimestamp +
                '}';
    }
}
