package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

public class TripDetails {

    public static final String BUSINESS_PURPOSE = "BusinessPurpose";
    public static final String POSSIBLE_TAX_SAVINGS = "PossibleTaxSavings";

    @SerializedName(value = "businessPurpose", alternate = "BusinessPurpose")
    private String BusinessPurpose;
    @SerializedName(value = "possibleTaxSavings", alternate = "PossibleTaxSavings")
    private String PossibleTaxSavings;

    public String getBusinessPurpose() {
        return BusinessPurpose;
    }

    public void setBusinessPurpose(String businessPurpose) {
        BusinessPurpose = businessPurpose;
    }

    public String getPossibleTaxSavings() {
        return PossibleTaxSavings;
    }

    public void setPossibleTaxSavings(String possibleTaxSavings) {
        PossibleTaxSavings = possibleTaxSavings;
    }

    @Override
    public String toString() {
        return "TripDetails{" +
                "BusinessPurpose='" + BusinessPurpose + '\'' +
                ", PossibleTaxSavings='" + PossibleTaxSavings + '\'' +
                '}';
    }
}
