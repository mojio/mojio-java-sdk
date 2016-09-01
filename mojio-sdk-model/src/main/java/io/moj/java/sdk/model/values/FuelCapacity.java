package io.moj.java.sdk.model.values;

import io.moj.java.sdk.model.enums.VolumeUnit;

/**
 * Model object for a FuelCapacity value.
 * Created by mhorie on 2016-01-14.
 */
public class FuelCapacity extends DeviceMeasurement {

    public VolumeUnit getBaseFuelCapacityUnit() {
        return VolumeUnit.fromKey(getBaseUnit());
    }

    public void setBaseFuelCapacityUnit(VolumeUnit baseUnit) {
        setBaseUnit(baseUnit.getKey());
    }

    public VolumeUnit getFuelCapacityUnit() {
        return VolumeUnit.fromKey(getUnit());
    }

    public void setFuelCapacityUnit(VolumeUnit unit) {
        setUnit(unit.getKey());
    }

    @Override
    public String toString() {
        return "FuelCapacity{} " + super.toString();
    }
}
