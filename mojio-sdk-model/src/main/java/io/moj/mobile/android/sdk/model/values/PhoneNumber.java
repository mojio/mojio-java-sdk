package io.moj.mobile.android.sdk.model.values;

import io.moj.mobile.android.sdk.model.enums.PhoneType;

/**
 * Model object for a PhoneNumber value.
 * Created by mhorie on 2016-01-14.
 */
public class PhoneNumber {

    private PhoneType Type;
    private Integer CountryCode;
    private Integer AreaCode;
    private Integer Number;
    private Integer Ext;

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

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "AreaCode=" + AreaCode +
                ", Type=" + Type +
                ", CountryCode=" + CountryCode +
                ", Number=" + Number +
                ", Ext=" + Ext +
                '}';
    }
}
