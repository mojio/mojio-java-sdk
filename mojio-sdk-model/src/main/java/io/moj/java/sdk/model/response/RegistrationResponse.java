package io.moj.java.sdk.model.response;

import java.util.Arrays;

/**
 * Model object for a response that includes account registration information, namely errors if registration
 * was unsuccessful.
 * Created by skidson on 2016-04-26.
 */
public class RegistrationResponse extends MessageResponse {

    private String Status;
    private String[] Errors;

    public RegistrationResponse() {
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String[] getErrors() {
        return Errors;
    }

    public void setErrors(String[] errors) {
        Errors = errors;
    }

    @Override
    public String toString() {
        return "RegistrationResponse{" +
                "Status='" + Status + '\'' +
                ", Errors=" + Arrays.toString(Errors) +
                '}';
    }

    private static class Error {
        private String Code;
        private String Message;

        public Error() {
        }

        public String getCode() {
            return Code;
        }

        public void setCode(String code) {
            Code = code;
        }

        public String getMessage() {
            return Message;
        }

        public void setMessage(String message) {
            Message = message;
        }

        @Override
        public String toString() {
            return "Error{" +
                    "Code='" + Code + '\'' +
                    ", Message='" + Message + '\'' +
                    '}';
        }
    }
}
