package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

public class CapabilitiesWifiRadio {
    @SerializedName(value = "ConnectionState", alternate = {"connectionState", "connectionstate"})
    private Boolean connectionState;

    @SerializedName(value = "Ssid", alternate = {"ssid"})
    private Boolean ssid;

    @SerializedName(value = "Password", alternate = {"password"})
    private Boolean password;


    public Boolean getConnectionState() {
        return connectionState;
    }

    public void setConnectionState(Boolean connectionState) {
        this.connectionState = connectionState;
    }

    public Boolean getSsid() {
        return ssid;
    }

    public void setSsid(Boolean ssid) {
        this.ssid = ssid;
    }

    public Boolean getPassword() {
        return password;
    }

    public void setPassword(Boolean password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "CapabilitiesWifiRadio{" +
                "connectionState=" + connectionState +
                ", ssid=" + ssid +
                ", password=" + password +
                '}';
    }
}
