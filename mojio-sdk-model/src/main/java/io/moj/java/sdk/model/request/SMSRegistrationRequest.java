package io.moj.java.sdk.model.request;

/**
 * Model object for a request to register a new account via SMS.
 * Created by skidson on 2016-04-25.
 */
public class SMSRegistrationRequest {

    private String MobileNumber;
    private String EmailAddress;
    private String Password;

    public SMSRegistrationRequest(String mobileNumber, String emailAddress, String password) {
        MobileNumber = mobileNumber;
        EmailAddress = emailAddress;
        Password = password;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
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
                ", EmailAddress='" + EmailAddress + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
