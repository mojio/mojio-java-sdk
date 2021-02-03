package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VehicleSimplePropertyDataModel implements Serializable {
    @SerializedName(value = "Timestamp", alternate = {"timestamp", "TimeStamp"})
    private String Timestamp;
    @SerializedName(value = "Unit", alternate = "unit")
    private String Unit;
    @SerializedName(value = "Value", alternate = "value")
    private Float Value;
    @SerializedName(value = "BaseUnit", alternate = {"baseUnit", "baseunit"})
    private String BaseUnit;
    @SerializedName(value = "BaseValue", alternate = {"baseValue", "basevalue"})
    private Float BaseValue;

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public Float getValue() {
        return Value;
    }

    public void setValue(Float value) {
        Value = value;
    }

    public String getBaseUnit() {
        return BaseUnit;
    }

    public void setBaseUnit(String baseUnit) {
        BaseUnit = baseUnit;
    }

    public Float getBaseValue() {
        return BaseValue;
    }

    public void setBaseValue(Float baseValue) {
        BaseValue = baseValue;
    }

    @Override
    public String toString() {
        return "VehicleSimplePropertyDataModel{" +
                "Timestamp='" + Timestamp + '\'' +
                ", Unit='" + Unit + '\'' +
                ", Value=" + Value +
                ", BaseUnit='" + BaseUnit + '\'' +
                ", BaseValue=" + BaseValue +
                '}';
    }
}
