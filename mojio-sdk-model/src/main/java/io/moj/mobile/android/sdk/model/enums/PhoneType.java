package io.moj.mobile.android.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for PhoneType types.
 * Created by mhorie on 2016-01-14.
 */
public enum PhoneType {

    @SerializedName("Home")
    HOME("Home"),

    @SerializedName("Work")
    WORK("Work"),

    @SerializedName("Mobile")
    MOBILE("Mobile");

    private String key;

    PhoneType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static PhoneType fromKey(String key) {
        for (PhoneType unit : PhoneType.values()) {
            if (unit.getKey().equals(key)) {
                return unit;
            }
        }
        return null;
    }
}
