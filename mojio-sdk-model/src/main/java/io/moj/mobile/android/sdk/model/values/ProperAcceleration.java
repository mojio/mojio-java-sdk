package io.moj.mobile.android.sdk.model.values;

import io.moj.mobile.android.sdk.model.enums.AccelerometerUnit;

/**
 * Model object for a ProperAcceleration value.
 * Created by mhorie on 2016-01-14.
 */
public class ProperAcceleration extends DeviceMeasurement {

    public AccelerometerUnit getBaseAccelerometerUnit() {
        return AccelerometerUnit.fromKey(getBaseUnit());
    }

    public void setBaseAccelerometerUnit(AccelerometerUnit baseUnit) {
        setBaseUnit(baseUnit.getKey());
    }

    public AccelerometerUnit getAccelerometerUnit() {
        return AccelerometerUnit.fromKey(getUnit());
    }

    public void setAccelerometerUnit(AccelerometerUnit unit) {
        setUnit(unit.getKey());
    }

    @Override
    public String toString() {
        return "ProperAcceleration{} " + super.toString();
    }
}
