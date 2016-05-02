package io.moj.java.sdk.model.request;

/**
 * Model object for a request to register a new account via SMS.
 * Created by skidson on 2016-04-25.
 */
public class PinRequest {

    private String PhoneNumber;

    public PinRequest() {}

    public PinRequest(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PinRequest{" +
                "PhoneNumber='" + PhoneNumber + '\'' +
                '}';
    }
}
