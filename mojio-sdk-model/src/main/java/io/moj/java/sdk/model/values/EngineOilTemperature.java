package io.moj.java.sdk.model.values;

/**
 * Model object for vehicle EngineOilTemperature.
 * Created by oleksii borys on 2019-08-22.
 */
public class EngineOilTemperature {

    public static final String BASEUNIT = "BaseUnit";
    public static final String TIMESTAMP = "Timestamp";
    public static final String BASEVALUE = "BaseValue";
    public static final String UNIT = "Unit";
    public static final String VALUE = "Value";

    private String BaseUnit;
    private String Timestamp;
    private Float BaseValue;
    private String Unit;
    private Float Value;

    public String getBaseUnit() { return BaseUnit; }

    public void setBaseUnit(String baseUnit) { BaseUnit = baseUnit; }

    public String getTimestamp() { return Timestamp; }

    public void setTimestamp(String timestamp) { Timestamp = timestamp; }

    public Float getBaseValue() { return BaseValue; }

    public void setBaseValue(Float baseValue) { BaseValue = baseValue; }

    public String getUnit() { return Unit; }

    public void setUnit(String unit) { Unit = unit; }

    public Float getValue() { return Value; }

    public void setValue(Float value) { Value = value; }

    @Override
    public String toString() {
        return "EngineOilTemperature{" +
                "BaseUnit='" + BaseUnit + '\'' +
                ", Timestamp='" + Timestamp + '\'' +
                ", BaseValue=" + BaseValue +
                ", Unit='" + Unit + '\'' +
                ", Value=" + Value +
                '}';
    }
}
