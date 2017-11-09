package io.moj.java.sdk.model.enums;

import com.google.gson.annotations.SerializedName;
import io.moj.java.sdk.math.Multiplier;
import io.moj.java.sdk.math.UnitConverter;

/**
 * Enum for DistanceUnit types.
 * Created by mhorie on 2016-01-14.
 */
public enum DistanceUnit {

    @SerializedName("Kilometers")
    KILOMETERS("Kilometers", new float[] { 1f, 0.621371f, 0.539957f, 1000f, 100000f, 1000000f }),

    @SerializedName("Miles")
    MILES("Miles", new float[] { 1.60934f, 1f, 0.868976f, 1609.34f, 160934f, 1609340f }),

    @SerializedName("NauticalMiles")
    NAUTICAL_MILES("NauticalMiles", new float[] { 1.852f, 1.15078f, 1f, 1852f, 185200f, 1852000f }),

    @SerializedName("Meters")
    METERS("Meters", new float[] { 0.001f, 0.000621371f, 0.000539957f, 1f, 100f, 1000f }),

    @SerializedName("CentiMeter")
    CENTIMETERS("CentiMeter", new float[] { 0.00001f, 0.00000621371f, 0.00000539957f, 0.01f, 1f, 10f }),

    @SerializedName("MilliMeter")
    MILLIMETERS("MilliMeter", new float[] { 1000000f, 0.000000621371f, 0.000000539957f, 0.001f, 0.1f, 1f });

    private final String key;
    private final float[] conversions;

    DistanceUnit(String key, float[] conversions) {
        this.key = key;
        this.conversions = conversions;
    }

    public String getKey() {
        return key;
    }

    public UnitConverter convertTo(DistanceUnit unit) {
        DistanceUnit[] values = values();
        for (int i = 0; i < values.length; i++) {
            if (values[i] == unit) {
                return new Multiplier(conversions[i]);
            }
        }
        throw new IllegalArgumentException("Cannot convert " + this + " to " + unit);
    }

    public static DistanceUnit fromKey(String key) {
        for (DistanceUnit unit : DistanceUnit.values()) {
            if (unit.getKey().equals(key)) {
                return unit;
            }
        }
        return null;
    }

}
