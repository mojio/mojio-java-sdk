package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import io.moj.java.sdk.model.enums.RiskSeverity;
import io.moj.java.sdk.utils.TimeUtils;

/**
 * Model object for a Battery.
 * Created by mhorie on 2016-01-12.
 */
public class Battery extends Voltage {

    @SerializedName(value = "Connected", alternate = "connected")
    private Boolean Connected;
    @SerializedName(value = "RiskSeverity", alternate = "riskSeverity")
    private RiskSeverity RiskSeverity;
    @SerializedName(value = "LowVoltageDuration", alternate = "lowVoltageDuration")
    private Duration LowVoltageDuration;
    @SerializedName(value = "HighVoltageDuration", alternate = "highVoltageDuration")
    private Duration HighVoltageDuration;
    @SerializedName(value = "Timestamp", alternate = "timestamp")
    private String Timestamp;

    public Boolean getConnected() {
        return Connected;
    }

    public void setConnected(Boolean connected) {
        Connected = connected;
    }

    public Duration getHighVoltageDuration() {
        return HighVoltageDuration;
    }

    public void setHighVoltageDuration(Duration highVoltageDuration) {
        HighVoltageDuration = highVoltageDuration;
    }

    public Duration getLowVoltageDuration() {
        return LowVoltageDuration;
    }

    public void setLowVoltageDuration(Duration lowVoltageDuration) {
        LowVoltageDuration = lowVoltageDuration;
    }

    public RiskSeverity getRiskSeverity() {
        return RiskSeverity;
    }

    public void setRiskSeverity(RiskSeverity riskSeverity) {
        RiskSeverity = riskSeverity;
    }

    public Long getTimestamp() {
        return TimeUtils.convertTimestampToMillis(Timestamp);
    }

    public void setTimestamp(Long startTimestamp) {
        Timestamp = TimeUtils.convertMillisToTimestamp(startTimestamp);
    }

    @Override
    public String toString() {
        return "Battery{" +
                "Connected=" + Connected +
                ", RiskSeverity=" + RiskSeverity +
                ", LowVoltageDuration=" + LowVoltageDuration +
                ", HighVoltageDuration=" + HighVoltageDuration +
                ", Timestamp='" + Timestamp + '\'' +
                "} " + super.toString();
    }
}
