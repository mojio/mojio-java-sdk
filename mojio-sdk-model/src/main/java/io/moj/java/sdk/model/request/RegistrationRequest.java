package io.moj.java.sdk.model.request;

/**
 * Model object for a request to register a new account via SMS.
 * Created by skidson on 2016-04-25.
 */
public class RegistrationRequest {

    private String Username;
    private String PhoneNumber;
    private String EmailAddress;
    private String Password;

    public RegistrationRequest() {}

    public RegistrationRequest(String username, String phoneNumber, String emailAddress, String password) {
        Username = username;
        PhoneNumber = phoneNumber;
        EmailAddress = emailAddress;
        Password = password;
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

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "RegistrationRequest{" +
                "Username='" + Username + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", EmailAddress='" + EmailAddress + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public static class Builder {
        private String username;
        private String phoneNumber;
        private String emailAddress;
        private String password;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public RegistrationRequest build() {
            if (emailAddress == null || emailAddress.isEmpty()) {
                throw new IllegalStateException("Email address must not be empty");
            }

            if (password == null || password.isEmpty()) {
                throw new IllegalStateException("Password must not be empty");
            }

            return new RegistrationRequest(username, phoneNumber, emailAddress, password);
        }
    }

}
