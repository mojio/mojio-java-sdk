package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

/**
 * Model object for a Odometer object.
 * Created by mhorie on 2016-01-14.
 */
public class Odometer extends Distance {

    @SerializedName(value = "RolloverValue", alternate = "rolloverValue")
    private float RolloverValue;

    public float getRolloverValue() {
        return RolloverValue;
    }

    public void setRolloverValue(Float rolloverValue) {
        RolloverValue = rolloverValue;
    }

    @Override
    public String toString() {
        return "Odometer{" +
                "RolloverValue=" + RolloverValue +
                "} " + super.toString();
    }
}
