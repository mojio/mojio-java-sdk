package io.moj.java.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for FuelType types.
 * Created by mhorie on 2016-01-14.
 */
public enum FuelType {

    @SerializedName(value = "Query", alternate = "query")
    QUERY("Query"),

    @SerializedName(value = "Gasoline", alternate = "gasoline")
    GASOLINE("Gasoline"),

    @SerializedName(value = "Diesel", alternate = "diesel")
    DIESEL("Diesel"),

    @SerializedName(value = "Electric", alternate = "electric")
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
