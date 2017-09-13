package io.moj.java.sdk.model.enums;

import com.google.gson.annotations.SerializedName;
import io.moj.java.sdk.math.Multiplier;
import io.moj.java.sdk.math.UnitConverter;

/**
 * Enum for VoltageUnit types.
 * Created by mhorie on 2016-01-15.
 */
public enum VoltageUnit {

    @SerializedName("Volts")
    VOLTS("Volts", new float[] { 1f, 1000f }),

    @SerializedName("MilliVolts")
    MILLIVOLTS("MilliVolts", new float[] { 0.001f, 1f });

    private final String key;
    private final float[] conversions;

    VoltageUnit(String key, float[] conversions) {
        this.key = key;
        this.conversions = conversions;
    }

    public String getKey() {
        return key;
    }

    public UnitConverter convertTo(VoltageUnit unit) {
        VoltageUnit[] values = values();
        for (int i = 0; i < values.length; i++) {
            if (values[i] == unit) {
                return new Multiplier(conversions[i]);
            }
        }
        throw new IllegalArgumentException("Cannot convert " + this + " to " + unit);
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
