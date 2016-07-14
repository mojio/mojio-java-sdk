package io.moj.java.sdk.model.response;

import java.util.Arrays;
import java.util.List;

/**
 * Model object for a response that includes account registration information, namely errors if registration
 * was unsuccessful.
 * Created by skidson on 2016-04-26.
 */
public class RegistrationResponse extends MessageResponse {

    private String Status;
    private List<Error> Errors;

    public RegistrationResponse() {
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public List<Error> getErrors() {
        return Errors;
    }

    public void setErrors(List<Error> errors) {
        Errors = errors;
    }

    @Override
    public String toString() {
        return "RegistrationResponse{" +
                "Status='" + Status + '\'' +
                ", Errors=" + Errors +
                "} " + super.toString();
    }

    public static class Error {
        private String Code;
        private String Message;

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
