package io.moj.java.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

public enum BrakeFluidLevelWarningType {
    @SerializedName(value = "noWarning", alternate = "NoWarning")
    NO_WARNING("NoWarning"),

    @SerializedName(value = "low", alternate = {"LOW", "Low"})
    LOW("Low");

    private String key;

    BrakeFluidLevelWarningType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static BrakeFluidLevelWarningType fromKey(String key) {
        for (BrakeFluidLevelWarningType unit : BrakeFluidLevelWarningType.values()) {
            if (unit.getKey().equals(key)) {
                return unit;
            }
        }
        return null;
    }
}