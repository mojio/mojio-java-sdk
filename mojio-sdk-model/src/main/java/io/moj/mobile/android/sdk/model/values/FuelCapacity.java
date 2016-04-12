package io.moj.mobile.android.sdk.model.values;

import io.moj.mobile.android.sdk.model.enums.FuelCapacityUnit;

/**
 * Model object for a FuelCapacity value.
 * Created by mhorie on 2016-01-14.
 */
public class FuelCapacity extends DeviceMeasurement {

    public FuelCapacityUnit getBaseFuelCapacityUnit() {
        return FuelCapacityUnit.fromKey(getBaseUnit());
    }

    public void setBaseFuelCapacityUnit(FuelCapacityUnit baseUnit) {
        setBaseUnit(baseUnit.getKey());
    }

    public FuelCapacityUnit getFuelCapacityUnit() {
        return FuelCapacityUnit.fromKey(getUnit());
    }

    public void setFuelCapacityUnit(FuelCapacityUnit unit) {
        setUnit(unit.getKey());
    }

    @Override
    public String toString() {
        return "FuelCapacity{} " + super.toString();
    }
}
