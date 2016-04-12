package io.moj.mobile.android.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for HeadingUnit types.
 * Created by mhorie on 2016-01-14.
 */
public enum HeadingUnit {

    @SerializedName("Degree")
    DEGREE("Degree");

    private String key;

    HeadingUnit(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static HeadingUnit fromKey(String key) {
        for (HeadingUnit unit : HeadingUnit.values()) {
            if (unit.getKey().equals(key)) {
                return unit;
            }
        }
        return null;
    }
}
