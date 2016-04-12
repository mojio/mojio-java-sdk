package io.moj.mobile.android.sdk.model.values;

import io.moj.mobile.android.sdk.model.enums.DistanceUnit;

/**
 * Model object for a Distance value.
 * Created by mhorie on 2016-01-14.
 */
public class Distance extends DeviceMeasurement {

    public DistanceUnit getBaseDistanceUnit() {
        return DistanceUnit.fromKey(getBaseUnit());
    }

    public void setBaseDistanceUnit(DistanceUnit baseUnit) {
        setBaseUnit(baseUnit.getKey());
    }

    public DistanceUnit getDistanceUnit() {
        return DistanceUnit.fromKey(getUnit());
    }

    public void setDistanceUnit(DistanceUnit unit) {
        setUnit(unit.getKey());
    }

    @Override
    public String toString() {
        return "Distance{} " + super.toString();
    }
}