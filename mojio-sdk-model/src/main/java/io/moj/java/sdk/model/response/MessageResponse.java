package io.moj.java.sdk.model.response;

/**
 * Model object for a response that only contains a message string.
 * Created by skidson on 2016-04-13.
 */
public class MessageResponse {

    private String Message;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    @Override
    public String toString() {
        return "MessageResponse{" +
                "Message='" + Message + '\'' +
                '}';
    }
}
