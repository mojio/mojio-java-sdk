package io.moj.java.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Enum for FuelEfficiencyCalculationMethod types.
 * Created by mhorie on 2016-01-14.
 */
public enum FuelEfficiencyCalculationMethod implements Serializable {

    @SerializedName(value = "Query", alternate = "query")
    QUERY("Query"),

    @SerializedName(value = "EngineFuelRate", alternate = "engineFuelRate")
    ENGINE_FUEL_RATE("EngineFuelRate"),

    @SerializedName(value = "MassAirFlow", alternate = "massAirFlow")
    MASS_AIR_FLOW("MassAirFlow"),

    @SerializedName(value = "Calculated", alternate = "calculated")
    CALCULATED("Calculated"),

    @SerializedName(value = "None", alternate = "none")
    NONE("None");

    private String key;

    FuelEfficiencyCalculationMethod(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static FuelEfficiencyCalculationMethod fromKey(String key) {
        for (FuelEfficiencyCalculationMethod unit : FuelEfficiencyCalculationMethod.values()) {
            if (unit.getKey().equals(key)) {
                return unit;
            }
        }
        return null;
    }
}
