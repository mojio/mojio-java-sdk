package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

public enum TemperatureUnit {

    @SerializedName("Fahrenheit")
    TEMPERATURE_FAHRENHEIT("Fahrenheit"),

    @SerializedName("Celsius")
    TEMPERATURE_CELSIUS("Celsius");

    private String key;
    private float[] conversions;

    TemperatureUnit(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static TemperatureUnit fromKey(String key) {
        for (TemperatureUnit unit : TemperatureUnit.values()) {
            if (unit.getKey().equals(key)) {
                return unit;
            }
        }
        return null;
    }
}


