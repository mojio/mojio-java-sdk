package io.moj.java.sdk.model.enums;

import com.google.gson.annotations.SerializedName;
import io.moj.java.sdk.math.Multiplier;
import io.moj.java.sdk.math.UnitConverter;

/**
 * Enum for units of volume.
 * Created by mhorie on 2016-01-14.
 */
public enum VolumeUnit {

    @SerializedName("Gallons")
    GALLONS("Gallons", new float[] { 1f, 3.78541f }),

    @SerializedName("Liters")
    LITERS("Liters", new float[] { 0.264172f, 1f });

    private final String key;
    private final float[] conversions;

    VolumeUnit(String key, float[] conversions) {
        this.key = key;
        this.conversions = conversions;
    }

    public String getKey() {
        return key;
    }

    public UnitConverter convertTo(VolumeUnit unit) {
        VolumeUnit[] values = values();
        for (int i = 0; i < values.length; i++) {
            if (values[i] == unit) {
                return new Multiplier(conversions[i]);
            }
        }
        throw new IllegalArgumentException("Cannot convert " + this + " to " + unit);
    }

    public static VolumeUnit fromKey(String key) {
        for (VolumeUnit unit : VolumeUnit.values()) {
            if (unit.getKey().equals(key)) {
                return unit;
            }
        }
        return null;
    }
}
