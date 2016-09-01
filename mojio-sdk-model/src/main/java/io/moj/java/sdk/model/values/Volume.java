package io.moj.java.sdk.model.values;

import io.moj.java.sdk.model.enums.VolumeUnit;

/**
 * Model object for a Volume value.
 * Created by mhorie on 2016-01-14.
 */
public class Volume extends DeviceMeasurement {

    public VolumeUnit getBaseVolumeUnit() {
        return VolumeUnit.fromKey(getBaseUnit());
    }

    public void setBaseVolumeUnit(VolumeUnit baseUnit) {
        setBaseUnit(baseUnit.getKey());
    }

    public VolumeUnit getVolumeUnit() {
        return VolumeUnit.fromKey(getUnit());
    }

    public void setVolumeUnit(VolumeUnit unit) {
        setUnit(unit.getKey());
    }

    @Override
    public String toString() {
        return "Volume{} " + super.toString();
    }
}
