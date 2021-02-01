package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BrakeFluid implements Serializable {
    @SerializedName(value = "Timestamp", alternate = {"timestamp", "TimeStamp"})
    private String Timestamp;
    @SerializedName(value = "BrakeFluidLevelWarning", alternate = {"brakeFluidLevelWarning", "brakefluidlevelwarning"})
    private String BrakeFluidLevelWarning;

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public String getBrakeFluidLevelWarning() {
        return BrakeFluidLevelWarning;
    }

    public void setBrakeFluidLevelWarning(String brakeFluidLevelWarning) {
        BrakeFluidLevelWarning = brakeFluidLevelWarning;
    }

    @Override
    public String toString() {
        return "BrakeFluid{" +
                "Timestamp='" + Timestamp + '\'' +
                ", BrakeFluidLevelWarning='" + BrakeFluidLevelWarning + '\'' +
                '}';
    }
}
