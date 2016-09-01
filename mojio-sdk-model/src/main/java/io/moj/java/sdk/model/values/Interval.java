package io.moj.java.sdk.model.values;

/**
 * Model object for an Interval.
 * Created by Mauro on 2016-08-30.
 */
public class Interval {

    private String OperatingParameter;
    private String OperatingParameterNotes;
    private String IntervalType;
    private Double Value;
    private String Units;
    private Double InitialValue;

    public String getOperatingParameter() {
        return OperatingParameter;
    }

    public void setOperatingParameter(String operatingParameter) {
        OperatingParameter = operatingParameter;
    }

    public String getOperatingParameterNotes() {
        return OperatingParameterNotes;
    }

    public void setOperatingParameterNotes(String operatingParameterNotes) {
        OperatingParameterNotes = operatingParameterNotes;
    }

    public String getIntervalType() {
        return IntervalType;
    }

    public void setIntervalType(String intervalType) {
        IntervalType = intervalType;
    }

    public Double getValue() {
        return Value;
    }

    public void setValue(Double value) {
        Value = value;
    }

    public String getUnits() {
        return Units;
    }

    public void setUnits(String units) {
        Units = units;
    }

    public Double getInitialValue() {
        return InitialValue;
    }

    public void setInitialValue(Double initialValue) {
        InitialValue = initialValue;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "OperatingParameter='" + OperatingParameter + '\'' +
                ", OperatingParameterNotes='" + OperatingParameterNotes + '\'' +
                ", IntervalType='" + IntervalType + '\'' +
                ", Value=" + Value +
                ", Units='" + Units + '\'' +
                ", InitialValue=" + InitialValue +
                '}';
    }
}
