package io.moj.mobile.android.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for AccelerometerUnit types.
 * Created by mhorie on 2016-01-14.
 */
public enum AccelerometerUnit {

    @SerializedName("MilliGUnits")
    MILLI_G_UNITS("MilliGUnits"),

    @SerializedName("NewtonsPerKilogram")
    NEWTONS_PER_KILOGRAM("NewtonsPerKilogram"),

    @SerializedName("XirgoUnit")
    XIRGO_UNIT("XirgoUnit"),

    @SerializedName("MetersPerSecondPerSecond")
    METERS_PER_SECOND_PER_SECOND("MetersPerSecondPerSecond"),

    @SerializedName("CentimetersPerSecondPerSecond")
    CM_PER_SECOND_PER_SECOND("CentimetersPerSecondPerSecond"),

    @SerializedName("GUnits")
    G_UNITS("GUnits");

    private String key;

    AccelerometerUnit(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static AccelerometerUnit fromKey(String key) {
        for (AccelerometerUnit unit : AccelerometerUnit.values()) {
            if (unit.getKey().equals(key)) {
                return unit;
            }
        }
        return null;
    }
}
