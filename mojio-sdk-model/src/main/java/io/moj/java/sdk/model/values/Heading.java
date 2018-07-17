package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import io.moj.java.sdk.model.enums.HeadingUnit;

/**
 * Model object for a Heading value.
 * Created by mhorie on 2016-01-14.
 */
public class Heading extends DeviceMeasurement {

    @SerializedName(value = "Direction", alternate = "direction")
    private String Direction;
    @SerializedName(value = "LeftTurn", alternate = "leftTurn")
    private Boolean LeftTurn;

    public HeadingUnit getBaseHeadingUnit() {
        return HeadingUnit.fromKey(getBaseUnit());
    }

    public void setBaseHeadingUnit(HeadingUnit baseUnit) {
        setBaseUnit(baseUnit.getKey());
    }

    public HeadingUnit getHeadingUnit() {
        return HeadingUnit.fromKey(getUnit());
    }

    public void setHeadingUnit(HeadingUnit unit) {
        setUnit(unit.getKey());
    }

    /**
     * Calculated as follows: Directions[(int)((outgoingState.Vehicle.Heading.BaseValue + 23) / 45)];
     * @return one of the following: "North", "North East", "East", "South East", "South",
     * "South West", "West", "North West", "North"
     */
    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        Direction = direction;
    }

    public Boolean getLeftTurn() {
        return LeftTurn;
    }

    public void setLeftTurn(Boolean leftTurn) {
        LeftTurn = leftTurn;
    }

    @Override
    public String toString() {
        return "Heading{" +
                "Direction='" + Direction + '\'' +
                ", LeftTurn=" + LeftTurn +
                "} " + super.toString();
    }
}
