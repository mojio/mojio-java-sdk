package io.moj.mobile.android.sdk.model.values;

import io.moj.mobile.android.sdk.model.enums.VoltageUnit;

/**
 * Model object for a Voltage object.
 * Created by mhorie on 2016-01-15.
 */
public class Voltage extends DeviceMeasurement {

    public VoltageUnit getBaseVoltageUnit() {
        return VoltageUnit.fromKey(getBaseUnit());
    }

    public void setBaseVoltageUnit(VoltageUnit baseUnit) {
        setBaseUnit(baseUnit.getKey());
    }

    public VoltageUnit getVoltageUnit() {
        return VoltageUnit.fromKey(getUnit());
    }

    public void setVoltageUnit(VoltageUnit unit) {
        setUnit(unit.getKey());
    }

    @Override
    public String toString() {
        return "Voltage{} " + super.toString();
    }
}
