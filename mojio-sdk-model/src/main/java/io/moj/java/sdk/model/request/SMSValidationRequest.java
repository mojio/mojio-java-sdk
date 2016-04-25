package io.moj.java.sdk.model.request;

/**
 * Model object for a request to complete registration for a new account using a 4-digit PIN sent via SMS.
 * Created by skidson on 2016-04-25.
 */
public class SMSValidationRequest {

    private String MobileNumber;
    private String Email;
    private String Pin;
    private String Password;

    public SMSValidationRequest(String mobileNumber, String pin, String email, String password) {
        MobileNumber = mobileNumber;
        Pin = pin;
        Email = email;
        Password = password;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPin() {
        return Pin;
    }

    public void setPin(String pin) {
        Pin = pin;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "SMSValidationRequest{" +
                "MobileNumber='" + MobileNumber + '\'' +
                ", Email='" + Email + '\'' +
                ", Pin='" + Pin + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
