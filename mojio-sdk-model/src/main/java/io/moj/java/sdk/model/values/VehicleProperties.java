package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

public class VehicleProperties {

    public static final String DISPLAY_DETAILS = "DisplayDetails";

    @SerializedName(value = "displayDetails", alternate = "DisplayDetails")
    private DisplayDetails DisplayDetails;

    public io.moj.java.sdk.model.values.DisplayDetails getDisplayDetails() {
        return DisplayDetails;
    }

    public void setDisplayDetails(io.moj.java.sdk.model.values.DisplayDetails displayDetails) {
        DisplayDetails = displayDetails;
    }

    @Override
    public String toString() {
        return "VehicleProperties{" +
                "DisplayDetails=" + DisplayDetails +
                '}';
    }
}
