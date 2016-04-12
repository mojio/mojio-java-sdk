package io.moj.mobile.android.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for ScoringMethod types.
 * Created by mhorie on 2016-01-14.
 */
public enum ScoringMethod {

    @SerializedName("ZScore")
    ZSCORE("ZScore"),

    @SerializedName("MinMaxScore")
    MIN_MAX_SCORE("MinMaxScore");

    private String key;

    ScoringMethod(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static ScoringMethod fromKey(String key) {
        for (ScoringMethod unit : ScoringMethod.values()) {
            if (unit.getKey().equals(key)) {
                return unit;
            }
        }
        return null;
    }
}
