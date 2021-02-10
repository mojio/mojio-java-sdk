package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

public class DistanceToNextService extends Distance {
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
        return "DistanceToNextService{" +
                "Timestamp='" + Timestamp +
                '}' + super.toString();
    }
}