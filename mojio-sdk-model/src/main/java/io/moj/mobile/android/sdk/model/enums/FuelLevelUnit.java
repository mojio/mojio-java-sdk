package io.moj.mobile.android.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for FuelLevelUnit types.
 * Created by mhorie on 2016-01-14.
 */
public enum FuelLevelUnit {

    @SerializedName("Percentage")
    PERCENTAGE("Percentage");

    private String key;

    FuelLevelUnit(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static FuelLevelUnit fromKey(String key) {
        for (FuelLevelUnit unit : FuelLevelUnit.values()) {
            if (unit.getKey().equals(key)) {
                return unit;
            }
        }
        return null;
    }
}
