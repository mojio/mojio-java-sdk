package io.moj.java.sdk.model.request;

/**
 * Model object for a request to register a new account via SMS.
 * Created by skidson on 2016-04-25.
 */
public class SMSRegistrationRequest {

    private String MobileNumber;

    public SMSRegistrationRequest(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "SMSRegistrationRequest{" +
                "MobileNumber='" + MobileNumber + '\'' +
                '}';
    }

}
