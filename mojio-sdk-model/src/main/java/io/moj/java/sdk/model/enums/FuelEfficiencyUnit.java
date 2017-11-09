package io.moj.java.sdk.model.enums;

import com.google.gson.annotations.SerializedName;
import io.moj.java.sdk.math.Divider;
import io.moj.java.sdk.math.Multiplier;
import io.moj.java.sdk.math.UnitConverter;

import static io.moj.java.sdk.math.Constants.GALLONS_PER_LITRE;
import static io.moj.java.sdk.math.Constants.MILES_PER_KM;

/**
 * Enum for FuelEfficiencyUnit types.
 * Created by mhorie on 2016-01-14.
 */
public enum FuelEfficiencyUnit {

    @SerializedName("MilesPerGallon")
    MPG("MilesPerGallon", new float[] { 1f, -(100 * MILES_PER_KM / GALLONS_PER_LITRE), (GALLONS_PER_LITRE / MILES_PER_KM)}),

    @SerializedName("LitersPerHundredKilometers")
    LP100KM("LitersPerHundredKilometers", new float[] { -(100 * MILES_PER_KM / GALLONS_PER_LITRE), 1f, -100f}),

    @SerializedName("KilometerPerLiter")
    KMPL("KilometerPerLiter", new float[] { (MILES_PER_KM / GALLONS_PER_LITRE), -100f, 1f });

    private final String key;

    /**
     * An array of conversion factors from the current unit to another where the index represents the {@link #ordinal()}
     * of the unit being converted to. A negative entry in the array indicates the value should divide the [positive]
     * conversion factor whereas a positive value implies multiplication.
     */
    private final float[] conversions;

    FuelEfficiencyUnit(String key, float[] conversions) {
        this.key = key;
        this.conversions = conversions;
    }

    public String getKey() {
        return key;
    }

    public UnitConverter convertTo(FuelEfficiencyUnit unit) {
        FuelEfficiencyUnit[] values = values();
        for (int i = 0; i < values.length; i++) {
            if (values[i] == unit) {
                float conversion = conversions[i];
                return conversion < 0 ? new Divider(Math.abs(conversion)) : new Multiplier(conversion);
            }
        }
        throw new IllegalArgumentException("Cannot convert " + this + " to " + unit);
    }

    public static FuelEfficiencyUnit fromKey(String key) {
        for (FuelEfficiencyUnit unit : FuelEfficiencyUnit.values()) {
            if (unit.getKey().equals(key)) {
                return unit;
            }
        }
        return null;
    }

}
