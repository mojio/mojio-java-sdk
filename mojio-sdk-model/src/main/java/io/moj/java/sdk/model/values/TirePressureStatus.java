package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

public class TirePressureStatus {

    public static final String TIMESTAMP = "Timestamp";
    public static final String TIRE_PRESSURE_STATUS_VAL = "TirePressureStatusVal";

    public enum Status {Unknown, Normal, Low, Fault, Alert}

    @SerializedName(value = "_Ts", alternate = "_ts")
    private String Timestamp;
    @SerializedName(value = "Val", alternate = "val")
    private Status StatusVal;

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public Status getStatusVal() {
        return StatusVal;
    }

    public void setStatusVal(Status statusVal) {
        StatusVal = statusVal;
    }

    @Override
    public String toString() {
        return "TirePressureStatus{" +
                "Timestamp='" + Timestamp + '\'' +
                ", StatusVal='" + StatusVal +
                '}';
    }
}
