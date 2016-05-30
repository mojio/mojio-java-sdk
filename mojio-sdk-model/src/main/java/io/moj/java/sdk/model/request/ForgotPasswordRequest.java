package io.moj.java.sdk.model.request;

/**
 * Model object to request a password request token.
 * Created by Mauro on 2016-05-25.
 */
public class ForgotPasswordRequest {

    private String UserNameEmailOrPhone;

    public ForgotPasswordRequest(String userNameEmailOrPhone) {
        UserNameEmailOrPhone = userNameEmailOrPhone;
    }

    public String getUserNameEmailOrPhone() {
        return UserNameEmailOrPhone;
    }

    public void setUserNameEmailOrPhone(String userNameEmailOrPhone) {
        UserNameEmailOrPhone = userNameEmailOrPhone;
    }

    @Override
    public String toString() {
        return "ForgotPasswordRequest{" +
                "UserNameEmailOrPhone='" + UserNameEmailOrPhone + '\'' +
                '}';
    }
}
