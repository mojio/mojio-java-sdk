package io.moj.java.sdk.model.response;

import java.util.List;

/**
 * Model object for a response that includes account registration information, namely ValidationErrors if registration
 * was unsuccessful.
 * Created by skidson on 2016-04-26.
 */
public class RegistrationResponse extends MessageResponse {

    private List<ValidationError> ValidationErrors;

    public List<ValidationError> getValidationErrors() {
        return ValidationErrors;
    }

    public void setValidationErrors(List<ValidationError> validationErrors) {
        ValidationErrors = validationErrors;
    }

    public static class ValidationError {
        private String Username;
        private String EmailAddress;
        private String PhoneNumber;
        private String Password;

        public String getUsername() {
            return Username;
        }

        public String getEmailAddress() {
            return EmailAddress;
        }

        public String getPhoneNumber() {
            return PhoneNumber;
        }

        public String getPassword() {
            return Password;
        }

        @Override
        public String toString() {
            return "ValidationError{" +
                    "Username='" + Username + '\'' +
                    ", EmailAddress='" + EmailAddress + '\'' +
                    ", PhoneNumber='" + PhoneNumber + '\'' +
                    ", Password='" + Password + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "RegistrationResponse{" +
                "ValidationErrors=" + ValidationErrors +
                "} " + super.toString();
    }
}
