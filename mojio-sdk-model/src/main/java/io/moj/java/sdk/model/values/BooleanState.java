package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

/**
 * Model object for a BooleanState value.
 * Created by mhorie on 2016-01-14.
 */
public class BooleanState extends StateTimestamp {

    @SerializedName(value = "Value", alternate = "value")
    private Boolean Value;

    public Boolean getValue() {
        return Value;
    }

    public void setValue(Boolean value) {
        Value = value;
    }

    @Override
    public String toString() {
        return "BooleanState{" +
                "Value=" + Value +
                "} " + super.toString();
    }
}