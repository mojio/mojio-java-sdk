package io.moj.java.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for TurnType types.
 * Created by Mauro on 2016-09-21.
 */
public enum TurnType {

    @SerializedName("Left")
    LEFT("Left"),

    @SerializedName("Right")
    RIGHT("Right");

    private String key;

    TurnType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static TurnType fromKey(String key) {
        for (TurnType type : TurnType.values()) {
            if (type.getKey().equals(key)) {
                return type;
            }
        }
        return null;
    }
}
