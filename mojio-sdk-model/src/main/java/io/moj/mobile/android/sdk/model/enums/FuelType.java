package io.moj.mobile.android.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for FuelType types.
 * Created by mhorie on 2016-01-14.
 */
public enum FuelType {

    @SerializedName("Query")
    QUERY("Query"),

    @SerializedName("Gasoline")
    GASOLINE("Gasoline"),

    @SerializedName("Diesel")
    DIESEL("Diesel"),

    @SerializedName("Electric")
    ELECTRIC("Electric");

    private String key;

    FuelType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static FuelType fromKey(String key) {
        for (FuelType unit : FuelType.values()) {
            if (unit.getKey().equals(key)) {
                return unit;
            }
        }
        return null;
    }
}
