package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;
import io.moj.java.sdk.model.enums.RiskSeverity;

public class HybridBatteryChargeLevel extends VehicleSimplePropertyDataModel {
    @SerializedName(value = "RiskSeverity", alternate = "riskSeverity")
    private RiskSeverity RiskSeverity;

    public RiskSeverity getRiskSeverity() {
        return RiskSeverity;
    }

    public void setRiskSeverity(RiskSeverity riskSeverity) {
        RiskSeverity = riskSeverity;
    }

    @Override
    public String toString() {
        return "HybridBatteryChargeLevel{" +
                "RiskSeverity=" + RiskSeverity +
                ", Timestamp='" + getTimestamp() + '\'' +
                ", Unit='" + getUnit() + '\'' +
                ", Value=" + getValue() +
                ", BaseUnit='" + getBaseUnit() + '\'' +
                ", BaseValue=" + getBaseValue() +
                '}';
    }
}
