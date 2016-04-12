package io.moj.mobile.android.sdk.model.values;

import io.moj.mobile.android.sdk.model.enums.SpeedUnit;

/**
 * Model object for a Speed object.
 * Created by mhorie on 2016-01-14.
 */
public class Speed extends DeviceMeasurement {

    private Integer SpeedBandId;
    private Duration SpeedBandDuration;

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
                "SpeedBandDuration=" + SpeedBandDuration +
                ", SpeedBandId=" + SpeedBandId +
                "} " + super.toString();
    }
}