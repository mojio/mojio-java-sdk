package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

public class Actuators {
    @SerializedName(value = "WifiRadio", alternate = {"wifiRadio", "wifiradio"})
    private CapabilitiesWifiRadio wifiRadio;

    @SerializedName(value = "StandbyMode", alternate = {"standbyMode", "standbymode"})
    private BooleanState standbyMode;

    @SerializedName(value = "SmartMaintenance", alternate = {"smartMaintenance", "smartmaintenance"})
    private BooleanState smartMaintenance;

    public CapabilitiesWifiRadio getWifiRadio() {
        return wifiRadio;
    }

    public void setWifiRadio(CapabilitiesWifiRadio wifiRadio) {
        this.wifiRadio = wifiRadio;
    }

    public BooleanState getStandbyMode() {
        return standbyMode;
    }

    public void setStandbyMode(BooleanState standbyMode) {
        this.standbyMode = standbyMode;
    }

    public BooleanState getSmartMaintenance() {
        return smartMaintenance;
    }

    public void setSmartMaintenance(BooleanState smartMaintenance) {
        this.smartMaintenance = smartMaintenance;
    }

    @Override
    public String toString() {
        return "Actuators{" +
                "wifiRadio=" + wifiRadio +
                ", standbyMode=" + standbyMode +
                ", smartMaintenance=" + smartMaintenance +
                '}';
    }
}


