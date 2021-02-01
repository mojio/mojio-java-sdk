package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Model object for vehicle EngineOilTemperature.
 * Created by oleksii borys on 2019-08-22.
 */
public class EngineOilTemperature implements Serializable {

    public static final String BASEUNIT = "BaseUnit";
    public static final String TIMESTAMP = "Timestamp";
    public static final String BASEVALUE = "BaseValue";
    public static final String UNIT = "Unit";
    public static final String VALUE = "Value";

    @SerializedName(value = "BaseUnit", alternate = {"baseunit", "baseUnit"})
    private String BaseUnit;
    @SerializedName(value = "TimeStamp", alternate = {"timestamp", "Timestamp"})
    private String Timestamp;
    @SerializedName(value = "BaseValue", alternate = {"basevalue", "baseValue"})
    private Float BaseValue;
    @SerializedName(value = "Unit", alternate = "unit")
    private String Unit;
    @SerializedName(value = "Value", alternate = "value")
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
