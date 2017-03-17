package io.moj.java.sdk.model.values;

import io.moj.java.sdk.model.enums.RiskSeverity;
import io.moj.java.sdk.utils.TimeUtils;

/**
 * Model object for a Battery.
 * Created by mhorie on 2016-01-12.
 */
public class Battery extends Voltage {

    private Boolean Connected;
    private RiskSeverity RiskSeverity;
    private Duration LowVoltageDuration;
    private Duration HighVoltageDuration;
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
