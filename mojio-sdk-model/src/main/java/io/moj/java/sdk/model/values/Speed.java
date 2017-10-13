package io.moj.java.sdk.model.values;

import io.moj.java.sdk.model.enums.SpeedUnit;

/**
 * Model object for a Speed object.
 * Created by mhorie on 2016-01-14.
 */
public class Speed extends DeviceMeasurement {

    private Integer SpeedBandId;
    private Duration SpeedBandDuration;
    private String Timestamp;

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public SpeedUnit getBaseSpeedUnit() {
        return SpeedUnit.fromKey(getBaseUnit());
    }

    public void setBaseSpeedUnit(SpeedUnit baseUnit) {
        setBaseUnit(baseUnit.getKey());
    }

    public SpeedUnit getSpeedUnit() {
        return SpeedUnit.fromKey(getUnit());
    }

    public void setSpeedUnit(SpeedUnit unit) {
        setUnit(unit.getKey());
    }

    public Duration getSpeedBandDuration() {
        return SpeedBandDuration;
    }

    public void setSpeedBandDuration(Duration speedBandDuration) {
        SpeedBandDuration = speedBandDuration;
    }

    public Integer getSpeedBandId() {
        return SpeedBandId;
    }

    public void setSpeedBandId(Integer speedBandId) {
        SpeedBandId = speedBandId;
    }

    @Override
    public String toString() {
        return "Speed{" +
                "SpeedBandId=" + SpeedBandId +
                ", SpeedBandDuration=" + SpeedBandDuration +
                ", Timestamp='" + Timestamp + '\'' +
                "} " + super.toString();
    }
}