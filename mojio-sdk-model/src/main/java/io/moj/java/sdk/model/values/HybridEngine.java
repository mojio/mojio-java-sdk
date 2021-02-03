package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HybridEngine implements Serializable {
    @SerializedName(value = "Timestamp", alternate = {"timestamp", "TimeStamp", "_ts"})
    private String Timestamp;
    @SerializedName(value = "HybridEngineMode", alternate = {"hybridEngineMode", "hybridenginemode", "mode"})
    private String HybridEngineMode;
    @SerializedName(value = "HybridModeCombustionDuration", alternate = {"hybridModeCombustionDuration", "hybridmodecombustionduration", "c_dur"})
    private VehicleSimplePropertyDataModel HybridModeCombustionDuration;
    @SerializedName(value = "HybridModeElectricDuration", alternate = {"hybridModeElectricDuration", "hybridmodeelectricduration", "e_dur"})
    private VehicleSimplePropertyDataModel HybridModeElectricDuration;

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public String getHybridEngineMode() {
        return HybridEngineMode;
    }

    public void setHybridEngineMode(String hybridEngineMode) {
        HybridEngineMode = hybridEngineMode;
    }

    public VehicleSimplePropertyDataModel getHybridModeCombustionDuration() {
        return HybridModeCombustionDuration;
    }

    public void setHybridModeCombustionDuration(VehicleSimplePropertyDataModel hybridModeCombustionDuration) {
        HybridModeCombustionDuration = hybridModeCombustionDuration;
    }

    public VehicleSimplePropertyDataModel getHybridModeElectricDuration() {
        return HybridModeElectricDuration;
    }

    public void setHybridModeElectricDuration(VehicleSimplePropertyDataModel hybridModeElectricDuration) {
        HybridModeElectricDuration = hybridModeElectricDuration;
    }

    @Override
    public String toString() {
        return "HybridEngine{" +
                "Timestamp='" + Timestamp + '\'' +
                ", HybridEngineMode='" + HybridEngineMode + '\'' +
                ", HybridModeCombustionDuration=" + HybridModeCombustionDuration +
                ", HybridModeElectricDuration=" + HybridModeElectricDuration +
                '}';
    }
}
