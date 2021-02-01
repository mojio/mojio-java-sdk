package io.moj.java.sdk.model.values;

import io.moj.java.sdk.model.enums.PhoneType;

import java.io.Serializable;

/**
 * Model object for a PhoneNumber value.
 * Created by mhorie on 2016-01-14.
 */
public class PhoneNumber implements Serializable {

    private PhoneType Type;
    private Integer CountryCode;
    private Integer AreaCode;
    private Integer Number;
    private Integer Ext;
    private String PhoneNumber;
    private Boolean Verified;

    public Integer getAreaCode() {
        return AreaCode;
    }

    public void setAreaCode(Integer areaCode) {
        AreaCode = areaCode;
    }

    public Integer getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(Integer countryCode) {
        CountryCode = countryCode;
    }

    public Integer getExt() {
        return Ext;
    }

    public void setExt(Integer ext) {
        Ext = ext;
    }

    public Integer getNumber() {
        return Number;
    }

    public void setNumber(Integer number) {
        Number = number;
    }

    public PhoneType getType() {
        return Type;
    }

    public void setType(PhoneType type) {
        Type = type;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public Boolean getVerified() {
        return Verified;
    }

    public void setVerified(Boolean verified) {
        Verified = verified;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "Type=" + Type +
                ", CountryCode=" + CountryCode +
                ", AreaCode=" + AreaCode +
                ", Number=" + Number +
                ", Ext=" + Ext +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Verified=" + Verified +
                '}';
    }
}
