package io.moj.mobile.android.sdk.model.values;

/**
 * Model object for an DeviceMeasurement value.
 * Created by mhorie on 2016-01-14.
 */
public abstract class DeviceMeasurement {

    private String BaseUnit;
    private Float BaseValue;
    private String Unit;
    private Float Value;

    public Float getBaseValue() {
        return BaseValue;
    }

    public void setBaseValue(Float baseValue) {
        BaseValue = baseValue;
    }

    public Float getValue() {
        return Value;
    }

    public void setValue(Float value) {
        Value = value;
    }

    protected String getBaseUnit() {
        return BaseUnit;
    }

    protected void setBaseUnit(String baseUnit) {
        BaseUnit = baseUnit;
    }

    protected String getUnit() {
        return Unit;
    }

    protected void setUnit(String unit) {
        Unit = unit;
    }

    @Override
    public String toString() {
        return "DeviceMeasurement{" +
                "BaseUnit='" + BaseUnit + '\'' +
                ", BaseValue=" + BaseValue +
                ", Unit='" + Unit + '\'' +
                ", Value=" + Value +
                '}';
    }
}
