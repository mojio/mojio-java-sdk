package io.moj.mobile.android.sdk.model.values;

/**
 * Model object for a BooleanState value.
 * Created by mhorie on 2016-01-14.
 */
public class BooleanState extends StateTimestamp {

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