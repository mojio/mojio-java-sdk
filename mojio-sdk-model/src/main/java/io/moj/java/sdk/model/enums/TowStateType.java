package io.moj.java.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

public enum TowStateType {
    @SerializedName("TiltDetected")
    TILT_DETECTED("TiltDetected"),

    @SerializedName("TowStart")
    TOW_START("TowStart"),

    @SerializedName("TowMoving")
    TOW_MOVING("TowMoving"),

    @SerializedName("TowEnd")
    TOW_END("TowEnd");

    private String key;

    TowStateType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static TowStateType fromKey(String key) {
        for (TowStateType unit : TowStateType.values()) {
            if (unit.getKey().equals(key)) {
                return unit;
            }
        }
        return null;
    }
}
