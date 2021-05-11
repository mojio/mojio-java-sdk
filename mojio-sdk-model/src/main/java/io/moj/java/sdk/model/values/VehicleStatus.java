package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VehicleStatus implements Serializable {
    private String Timestamp;
    @SerializedName(value = "Value", alternate = "value")
    private Status Status;

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public VehicleStatus.Status getStatus() {
        return Status;
    }

    public void setStatus(VehicleStatus.Status status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "VehicleStatus{" +
                "Timestamp='" + Timestamp + '\'' +
                ", Status=" + Status +
                '}';
    }

    public enum Status {
        @SerializedName("Unplugged")
        UNPLUGGED("Unplugged"),

        @SerializedName("Stopped")
        STOPPED("Stopped`"),

        @SerializedName("Offline")
        OFFLINE("Offline"),

        @SerializedName("Moving")
        MOVING("Moving"),

        @SerializedName("Syncing")
        SYNCING("Syncing"),

        @SerializedName("Unreachable")
        UNREACHABLE("Unreachable"),

        @SerializedName("Unknown")
        UNKNOWN("Unknown");

        private String key;

        Status(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public static VehicleStatus.Status fromKey(String key) {
            for (VehicleStatus.Status value : values()) {
                if (value.getKey().equals(key)) {
                    return value;
                }
            }
            return null;
        }
    }
}