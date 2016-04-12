package io.moj.mobile.android.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for FuelCapacityUnit types.
 * Created by mhorie on 2016-01-14.
 */
public enum FuelCapacityUnit {

    @SerializedName("Gallons")
    GALLONS("Gallons"),

    @SerializedName("Liters")
    LITERS("Liters");

    private String key;

    FuelCapacityUnit(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static FuelCapacityUnit fromKey(String key) {
        for (FuelCapacityUnit unit : FuelCapacityUnit.values()) {
            if (unit.getKey().equals(key)) {
                return unit;
            }
        }
        return null;
    }
}
