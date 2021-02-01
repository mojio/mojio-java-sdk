package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import io.moj.java.sdk.model.enums.UnnamedRoadTranslation;

import java.io.Serializable;

/**
 * Model object for an Address value.
 * Created by mhorie on 2016-01-12.
 */
public class Address implements Serializable {

    @SerializedName(value = "HouseNumber", alternate = "houseNumber")
    private String HouseNumber;
    @SerializedName(value = "Road", alternate = "road")
    private String Road;
    @SerializedName(value = "Neighbourhood", alternate = "neighbourhood")
    private String Neighbourhood;
    @SerializedName(value = "Suburb", alternate = "suburb")
    private String Suburb;
    @SerializedName(value = "City", alternate = "city")
    private String City;
    @SerializedName(value = "County", alternate = "county")
    private String County;
    @SerializedName(value = "State", alternate = "state")
    private String State;
    @SerializedName(value = "PostCode", alternate = "postCode")
    private String PostCode;
    @SerializedName(value = "Country", alternate = "country")
    private String Country;
    @SerializedName(value = "CountryCode", alternate = "countryCode")
    private String CountryCode;
    @SerializedName(value = "FormattedAddress", alternate = "formattedAddress")
    private String FormattedAddress;

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getCounty() {
        return County;
    }

    public void setCounty(String county) {
        County = county;
    }

    public String getFormattedAddress() {
        return UnnamedRoadTranslation.replaceAnyUnnamedRoadWithLocalizedString(FormattedAddress);
    }

    public void setFormattedAddress(String formattedAddress) {
        FormattedAddress = formattedAddress;
    }

    public String getHouseNumber() {
        return HouseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        HouseNumber = houseNumber;
    }

    public String getNeighbourhood() {
        return Neighbourhood;
    }

    public void setNeighbourhood(String neighbourhood) {
        Neighbourhood = neighbourhood;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String postCode) {
        PostCode = postCode;
    }

    public String getRoad() {
        return Road;
    }

    public void setRoad(String road) {
        Road = road;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getSuburb() {
        return Suburb;
    }

    public void setSuburb(String suburb) {
        Suburb = suburb;
    }

    @Override
    public String toString() {
        return "Address{" +
                "City='" + City + '\'' +
                ", HouseNumber='" + HouseNumber + '\'' +
                ", Road='" + Road + '\'' +
                ", Neighbourhood='" + Neighbourhood + '\'' +
                ", Suburb='" + Suburb + '\'' +
                ", County='" + County + '\'' +
                ", State='" + State + '\'' +
                ", PostCode='" + PostCode + '\'' +
                ", Country='" + Country + '\'' +
                ", CountryCode='" + CountryCode + '\'' +
                ", FormattedAddress='" + FormattedAddress + '\'' +
                '}';
    }
}
