package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;
import io.moj.java.sdk.model.enums.FuelLevelUnit;
import io.moj.java.sdk.model.enums.RiskSeverity;

/**
 * Model object for a FuelLevel value.
 * Created by mhorie on 2016-01-14.
 */
public class FuelCapacity extends Volume {

    @SerializedName(value = "Timestamp", alternate = "timestamp")
    private String Timestamp;

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "FuelCapacity{" +
                "Timestamp=" + Timestamp +
                "} " + super.toString();
    }
}
