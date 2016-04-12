package io.moj.mobile.android.sdk.model.values;

import io.moj.mobile.android.sdk.model.enums.DurationUnit;

/**
 * Model object for a Duration object.
 * Created by mhorie on 2016-01-14.
 */
public class Duration extends DeviceMeasurement {

    public DurationUnit getBaseDurationUnit() {
        return DurationUnit.fromKey(getBaseUnit());
    }

    public void setBaseDurationUnit(DurationUnit baseUnit) {
        setBaseUnit(baseUnit.getKey());
    }

    public DurationUnit getDurationUnit() {
        return DurationUnit.fromKey(getUnit());
    }

    public void setDurationUnit(DurationUnit unit) {
        setUnit(unit.getKey());
    }

    @Override
    public String toString() {
        return "Duration{} " + super.toString();
    }
}