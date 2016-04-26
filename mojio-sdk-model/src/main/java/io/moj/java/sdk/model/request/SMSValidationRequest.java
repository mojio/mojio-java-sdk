package io.moj.java.sdk.model.request;

/**
 * Model object for a request to complete registration for a new account using a 4-digit PIN sent via SMS.
 * Created by skidson on 2016-04-25.
 */
public class SMSValidationRequest {

    private String MobileNumber;
    private String Pin;

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getPin() {
        return Pin;
    }

    public void setPin(String pin) {
        Pin = pin;
    }

    @Override
    public String toString() {
        return "SMSValidationRequest{" +
                "MobileNumber='" + MobileNumber + '\'' +
                ", Pin='" + Pin + '\'' +
                '}';
    }
}
