package io.moj.java.sdk.model.response;

import java.util.Map;

/**
 * Model object for a response that only contains a message string. The Mojio API usually returns this for DELETE
 * operations or error scenarios.
 * Created by skidson on 2016-04-13.
 */
public class MessageResponse {

    private String Message;
    private Map<String, String[]> ModelState;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Map<String, String[]> getModelState() {
        return ModelState;
    }

    public void setModelState(Map<String, String[]> modelState) {
        ModelState = modelState;
    }

    @Override
    public String toString() {
        return "MessageResponse{" +
                "Message='" + Message + '\'' +
                ", ModelState=" + ModelState +
                '}';
    }
}
