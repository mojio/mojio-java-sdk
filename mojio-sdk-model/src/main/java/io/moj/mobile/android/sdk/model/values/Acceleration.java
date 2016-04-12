package io.moj.mobile.android.sdk.model.values;

import io.moj.mobile.android.sdk.model.enums.AccelerationUnit;

/**
 * Model object for an Acceleration value.
 * Created by mhorie on 2016-01-14.
 */
public class Acceleration extends DeviceMeasurement {

    public AccelerationUnit getBaseAccelerationUnit() {
        return AccelerationUnit.fromKey(getBaseUnit());
    }

    public void setBaseAccelerationUnit(AccelerationUnit baseUnit) {
        setBaseUnit(baseUnit.getKey());
    }

    public AccelerationUnit getAccelerationUnit() {
        return AccelerationUnit.fromKey(getUnit());
    }

    public void setAccelerationUnit(AccelerationUnit unit) {
        setUnit(unit.getKey());
    }

    @Override
    public String toString() {
        return "Acceleration{} " + super.toString();
    }
}