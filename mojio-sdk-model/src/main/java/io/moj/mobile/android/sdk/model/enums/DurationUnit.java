package io.moj.mobile.android.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for DurationUnit types.
 * Created by mhorie on 2016-01-14.
 */
public enum DurationUnit {

    @SerializedName("Weeks")
    WEEKS("Weeks"),

    @SerializedName("Days")
    DAYS("Days"),

    @SerializedName("Hours")
    HOURS("Hours"),

    @SerializedName("Minutes")
    MINUTES("Minutes"),

    @SerializedName("Seconds")
    SECONDS("Seconds"),

    @SerializedName("Milliseconds")
    MILLISECONDS("Milliseconds"),

    @SerializedName("Ticks")
    TICKS("Ticks");

    private String key;

    DurationUnit(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static DurationUnit fromKey(String key) {
        for (DurationUnit unit : DurationUnit.values()) {
            if (unit.getKey().equals(key)) {
                return unit;
            }
        }
        return null;
    }
}
