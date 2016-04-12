package io.moj.mobile.android.sdk.model.values;

/**
 * Model object for a Email value.
 * Created by mhorie on 2016-01-14.
 */
public class Email {

    private Boolean Verified;
    private String Address;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public boolean getVerified() {
        return Verified;
    }

    public void setVerified(Boolean verified) {
        Verified = verified;
    }

    @Override
    public String toString() {
        return "Email{" +
                "Address='" + Address + '\'' +
                ", Verified=" + Verified +
                '}';
    }
}
