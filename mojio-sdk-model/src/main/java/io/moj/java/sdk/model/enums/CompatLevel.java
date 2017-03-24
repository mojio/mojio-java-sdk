package io.moj.java.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for vehicle compatibility levels.
 * Created by alexc on 2017-03-24.
 */

public enum CompatLevel {

    @SerializedName("Full")
    FULL("Full"),

    @SerializedName("Partial")
    PARTIAL("Partial"),

    @SerializedName("Minimum")
    MINIMUM("Minimum"),

    @SerializedName("NotCompatible")
    NOTCOMPATIBLE("NotCompatible"),

    @SerializedName("Unknown")
    UNKNOWN("Unknown");

    private String key;

    CompatLevel(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static CompatLevel fromKey(String key) {
        for (CompatLevel level : CompatLevel.values()) {
            if (level.getKey().equals(key)) {
                return level;
            }
        }
        return null;
    }

}
