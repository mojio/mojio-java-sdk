package io.moj.java.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

import io.moj.java.sdk.math.Multiplier;
import io.moj.java.sdk.math.UnitConverter;

/**
 * Enum for AccelerationUnit types.
 * Created by mhorie on 2016-01-14.
 */
public enum AccelerationUnit {

    @SerializedName("MetersPerSecondPerSecond")
    METERS_PER_SECOND_PER_SECOND("MetersPerSecondPerSecond", new float[] { 1f, 3.6f, 2.23694f }),

    @SerializedName("KilometersPerHourPerSecond")
    KILOMETERS_PER_HOUR_PER_SECOND("KilometersPerHourPerSecond", new float[] { 0.277778f, 1f, 0.621371f }),

    @SerializedName("MilesPerHourPerSecond")
    MILES_PER_HOUR_PER_SECOND("MilesPerHourPerSecond", new float[] { 0.44704f, 1.60934f, 1f });

    private String key;
    private float[] conversions;

    AccelerationUnit(String key, float[] conversions) {
        this.key = key;
        this.conversions = conversions;
    }

    public String getKey() {
        return key;
    }

    public UnitConverter convertTo(AccelerationUnit unit) {
        AccelerationUnit[] values = values();
        for (int i = 0; i < values.length; i++) {
            if (values[i] == unit) {
                return new Multiplier(conversions[i]);
            }
        }
        throw new IllegalArgumentException("Cannot convert " + this + " to " + unit);
    }

    public static AccelerationUnit fromKey(String key) {
        for (AccelerationUnit unit : AccelerationUnit.values()) {
            if (unit.getKey().equals(key)) {
                return unit;
            }
        }
        return null;
    }
}
