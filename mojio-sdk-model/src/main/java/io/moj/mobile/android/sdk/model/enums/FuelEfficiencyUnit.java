package io.moj.mobile.android.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for FuelEfficiencyUnit types.
 * Created by mhorie on 2016-01-14.
 */
public enum FuelEfficiencyUnit {

    @SerializedName("MilesPerGallon")
    MPG("MilesPerGallon"),

    @SerializedName("LitersPerHundredKilometers")
    L100KM("LitersPerHundredKilometers"),

    @SerializedName("KilometerPerLiter")
    KM_PER_LITER("KilometerPerLiter");

    private String key;

    FuelEfficiencyUnit(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
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
