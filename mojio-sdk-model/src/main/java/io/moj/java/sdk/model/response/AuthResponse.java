package io.moj.java.sdk.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Model object for an auth token response.
 * Created by skidson on 16-02-10.
 */
public class AuthResponse {

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("expires_in")
    private Long expiresIn;

    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("error")
    private String error;

    @SerializedName("error_description")
    private String errorDescription;

    /**
     * Default constructor for JSON serialization, should not be used by clients.
     */
    @Deprecated
    public AuthResponse() {}

    public String getAccessToken() {
        return accessToken;
    }

    public String getError() {
        return error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", expiresIn=" + expiresIn +
                ", refreshToken='" + refreshToken + '\'' +
                ", error='" + error + '\'' +
                ", errorDescription='" + errorDescription + '\'' +
                '}';
    }
}
