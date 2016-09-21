package io.moj.java.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for HarshEventType types.
 * Created by Mauro on 2016-09-21.
 */
public enum HarshEventType {

    @SerializedName("Acceleration")
    ACCELERATION("Acceleration"),

    @SerializedName("Deceleration")
    DECELERATION("Deceleration"),

    @SerializedName("Turning")
    TURNING("Turning"),

    @SerializedName("Upward")
    UPWARD("Upward"),

    @SerializedName("Downward")
    DOWNWARD("Downward"),

    @SerializedName("Accident")
    ACCIDENT("Accident"),

    @SerializedName("PostAccident")
    POST_ACCIDENT("PostAccident");

    private String key;

    HarshEventType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static HarshEventType fromKey(String key) {
        for (HarshEventType type : HarshEventType.values()) {
            if (type.getKey().equals(key)) {
                return type;
            }
        }
        return null;
    }
}
