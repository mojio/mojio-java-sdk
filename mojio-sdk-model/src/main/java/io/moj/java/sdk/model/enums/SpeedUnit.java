package io.moj.java.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

import io.moj.java.sdk.math.Multiplier;
import io.moj.java.sdk.math.UnitConverter;

/**
 * Enum for SpeedUnit types.
 * Created by mhorie on 2016-01-14.
 */
public enum SpeedUnit {

    @SerializedName("MilesPerHour")
    MILES_PER_HOUR("MilesPerHour", new float[] { 1f, 1.60934f }),

    @SerializedName("KilometersPerHour")
    KILOMETERS_PER_HOUR("KilometersPerHour", new float[] { 0.621371f, 1f });

    private String key;
    private float[] conversions;

    SpeedUnit(String key, float[] conversions) {
        this.key = key;
        this.conversions = conversions;
    }

    public String getKey() {
        return key;
    }

    public UnitConverter convertTo(SpeedUnit unit) {
        SpeedUnit[] values = values();
        for (int i = 0; i < values.length; i++) {
            if (values[i] == unit) {
                return new Multiplier(conversions[i]);
            }
        }
        throw new IllegalArgumentException("Cannot convert " + this + " to " + unit);
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

