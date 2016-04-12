package io.moj.mobile.android.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for SpeedUnit types.
 * Created by mhorie on 2016-01-14.
 */
public enum SpeedUnit {

    @SerializedName("MilesPerHour")
    MILES_PER_HOUR("MilesPerHour"),

    @SerializedName("KilometersPerHour")
    KILOMETERS_PER_HOUR("KilometersPerHour");

    private String key;

    SpeedUnit(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static SpeedUnit fromKey(String key) {
        for (SpeedUnit unit : SpeedUnit.values()) {
            if (unit.getKey().equals(key)) {
                return unit;
            }
        }
        return null;
    }
}

