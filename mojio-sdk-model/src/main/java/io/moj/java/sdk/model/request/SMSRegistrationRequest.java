package io.moj.java.sdk.model.request;

/**
 * Model object for a request to register a new account via SMS.
 * Created by skidson on 2016-04-25.
 */
public class SMSRegistrationRequest {

    private String MobileNumber;
    private String Email;
    private String Pin;
    private String Password;

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
        return "SMSRegistrationRequest{" +
                "MobileNumber='" + MobileNumber + '\'' +
                ", Email='" + Email + '\'' +
                ", Pin='" + Pin + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
