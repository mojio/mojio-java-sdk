package io.moj.mobile.android.sdk.model.values;

import io.moj.mobile.android.sdk.model.enums.FuelLevelUnit;
import io.moj.mobile.android.sdk.model.enums.RiskSeverity;

/**
 * Model object for a FuelLevel value.
 * Created by mhorie on 2016-01-14.
 */
public class FuelLevel extends DeviceMeasurement {

    private RiskSeverity RiskSeverity;

    public FuelLevelUnit getBaseFuelLevelUnit() {
        return FuelLevelUnit.fromKey(getBaseUnit());
    }

    public void setBaseFuelLevelUnit(FuelLevelUnit baseUnit) {
        setBaseUnit(baseUnit.getKey());
    }

    public FuelLevelUnit getFuelLevelUnit() {
        return FuelLevelUnit.fromKey(getUnit());
    }

    public void setFuelLevelUnit(FuelLevelUnit unit) {
        setUnit(unit.getKey());
    }

    public RiskSeverity getRiskSeverity() {
        return RiskSeverity;
    }

    public void setRiskSeverity(RiskSeverity riskSeverity) {
        RiskSeverity = riskSeverity;
    }

    @Override
    public String toString() {
        return "FuelLevel{" +
                "RiskSeverity=" + RiskSeverity +
                "} " + super.toString();
    }
}
