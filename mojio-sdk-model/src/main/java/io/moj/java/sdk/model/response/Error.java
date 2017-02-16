package io.moj.java.sdk.model.response;

/**
 * Model object for an error that contains a code and a message.
 * Created by Mauro on 2017-02-15.
 */
public class Error {
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
