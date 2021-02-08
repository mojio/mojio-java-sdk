package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

public class CompletedOdometer extends Odometer {
    @SerializedName(value = "timestamp", alternate = "Timestamp")
    private String Timestamp;

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Odometer{" +
                "Timestamp= " + Timestamp +
                "} " + super.toString();
    }
}