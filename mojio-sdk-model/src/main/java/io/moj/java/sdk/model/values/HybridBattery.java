package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HybridBattery implements Serializable {
    @SerializedName(value = "Timestamp", alternate = {"timestamp", "TimeStamp", "_ts"})
    private String Timestamp;
    @SerializedName(value = "HybridBatteryVoltage", alternate = {"hybridBatteryVoltage", "hybridbatteryvoltage", "hbat_vlt"})
    private VehicleSimplePropertyDataModel HybridBatteryVoltage;
    @SerializedName(value = "HybridBatteryCurrent", alternate = {"hybridBatteryCurrent", "hybridbatterycurrent", "hbat_cur"})
    private VehicleSimplePropertyDataModel HybridBatteryCurrent;
    @SerializedName(value = "HybridBatteryChargeLevel", alternate = {"hybridBatteryChargeLevel", "hybridbatterychargelevel", "hbat_clvl"})
    private HybridBatteryChargeLevel HybridBatteryChargeLevel;
    @SerializedName(value = "HybridBatteryChargingStatus", alternate = {"hybridBatteryChargingStatus", "hybridbatterychargingstatus", "hbat_csta"})
    private String HybridBatteryChargingStatus;

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public VehicleSimplePropertyDataModel getHybridBatteryVoltage() {
        return HybridBatteryVoltage;
    }

    public void setHybridBatteryVoltage(VehicleSimplePropertyDataModel hybridBatteryVoltage) {
        HybridBatteryVoltage = hybridBatteryVoltage;
    }

    public VehicleSimplePropertyDataModel getHybridBatteryCurrent() {
        return HybridBatteryCurrent;
    }

    public void setHybridBatteryCurrent(VehicleSimplePropertyDataModel hybridBatteryCurrent) {
        HybridBatteryCurrent = hybridBatteryCurrent;
    }

    public io.moj.java.sdk.model.values.HybridBatteryChargeLevel getHybridBatteryChargeLevel() {
        return HybridBatteryChargeLevel;
    }

    public void setHybridBatteryChargeLevel(io.moj.java.sdk.model.values.HybridBatteryChargeLevel hybridBatteryChargeLevel) {
        HybridBatteryChargeLevel = hybridBatteryChargeLevel;
    }

    public String getHybridBatteryChargingStatus() {
        return HybridBatteryChargingStatus;
    }

    public void setHybridBatteryChargingStatus(String hybridBatteryChargingStatus) {
        HybridBatteryChargingStatus = hybridBatteryChargingStatus;
    }

    @Override
    public String toString() {
        return "HybridBattery{" +
                "Timestamp='" + Timestamp + '\'' +
                ", HybridBatteryVoltage=" + HybridBatteryVoltage +
                ", HybridBatteryCurrent=" + HybridBatteryCurrent +
                ", HybridBatteryChargeLevel=" + HybridBatteryChargeLevel +
                ", HybridBatteryChargingStatus='" + HybridBatteryChargingStatus + '\'' +
                '}';
    }
}
