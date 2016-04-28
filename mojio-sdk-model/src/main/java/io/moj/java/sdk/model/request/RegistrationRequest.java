package io.moj.java.sdk.model.request;

/**
 * Model object for a request to register a new account via SMS.
 * Created by skidson on 2016-04-25.
 */
public class RegistrationRequest {

    private String Username;
    private String PhoneNumber;
    private String Email;
    private String Password;
    @Deprecated
    private String ConfirmPassword;

    public RegistrationRequest() {}

    public RegistrationRequest(String username, String phoneNumber, String email, String password) {
        Username = username;
        PhoneNumber = phoneNumber;
        Email = email;
        Password = password;
        ConfirmPassword = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
        ConfirmPassword = password;
    }

    @Override
    public String toString() {
        return "RegistrationRequest{" +
                "Username='" + Username + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", ConfirmPassword='" + ConfirmPassword + '\'' +
                '}';
    }

    public static class Builder {
        private String username;
        private String phone;
        private String email;
        private String password;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public RegistrationRequest build() {
            if (email == null || email.isEmpty()) {
                throw new IllegalStateException("Email must not be empty");
            }

            if (password == null || password.isEmpty()) {
                throw new IllegalStateException("Password must not be empty");
            }

            return new RegistrationRequest(username, phone, email, password);
        }
    }

}
