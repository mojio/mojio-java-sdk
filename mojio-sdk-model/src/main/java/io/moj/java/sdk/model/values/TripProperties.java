package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

public class TripProperties {

    public static final String DETAILS = "Details";

    @SerializedName(value = "details", alternate = "Details")
    private TripDetails Details;

    public TripDetails getDetails() {
        return Details;
    }

    public void setDetails(TripDetails details) {
        Details = details;
    }

    @Override
    public String toString() {
        return "TripProperties{" +
                "Details=" + Details +
                '}';
    }
}
