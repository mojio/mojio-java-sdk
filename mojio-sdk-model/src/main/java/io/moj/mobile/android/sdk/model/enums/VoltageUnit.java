package io.moj.mobile.android.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for VoltageUnit types.
 * Created by mhorie on 2016-01-15.
 */
public enum VoltageUnit {

    @SerializedName("Volts")
    VOLTS("Volts"),

    @SerializedName("MilliVolts")
    MILLIVOLTS("MilliVolts");

    private String key;

    VoltageUnit(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static VoltageUnit fromKey(String key) {
        for (VoltageUnit unit : VoltageUnit.values()) {
            if (unit.getKey().equals(key)) {
                return unit;
            }
        }
        return null;
    }
}
