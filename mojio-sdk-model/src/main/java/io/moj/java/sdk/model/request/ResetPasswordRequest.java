package io.moj.java.sdk.model.request;

/**
 * Model object for resetting the user's password.
 * Created by Mauro on 2016-05-25.
 */
public class ResetPasswordRequest {

    private String Password;
    private String ConfirmPassword;
    private String ResetToken;

    public ResetPasswordRequest(String password, String confirmPassword, String resetToken) {
        Password = password;
        ConfirmPassword = confirmPassword;
        ResetToken = resetToken;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }

    public String getResetToken() {
        return ResetToken;
    }

    public void setResetToken(String resetToken) {
        ResetToken = resetToken;
    }

    @Override
    public String toString() {
        return "ResetPasswordRequest{" +
                "Password='" + Password + '\'' +
                ", ConfirmPassword='" + ConfirmPassword + '\'' +
                ", ResetToken='" + ResetToken + '\'' +
                '}';
    }
}
