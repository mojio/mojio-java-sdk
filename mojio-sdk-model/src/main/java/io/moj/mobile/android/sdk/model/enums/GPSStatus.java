package io.moj.mobile.android.sdk.model.enums;

import com.google.gson.annotations.SerializedName;

/**
 * Enum for GPSStatus types.
 * Created by mhorie on 2016-01-13.
 */
public enum GPSStatus {

    @SerializedName("Unknown")
    UNKNOWN("Unknown"),

    @SerializedName("Locked")
    LOCKED("Locked"),

    @SerializedName("NotLocked")
    NOT_LOCKED("NotLocked"),

    @SerializedName("Predicted")
    PREDICTED("Predicted"),

    @SerializedName("DiffCorrected")
    DIFF_CORRECTED("DiffCorrected"),

    @SerializedName("LastKnown")
    LAST_KNOWN("LastKnown"),

    @SerializedName("TwoDFix")
    TWO_D_FIX("TwoDFix"),

    @SerializedName("Historic")
    HISTORIC("Historic"),

    @SerializedName("InvalidTime")
    INVALID_TIME("InvalidTime"),

    @SerializedName("CommunicationsFailure")
    COMMUNICATIONS_FAILURE("CommunicationsFailure"),

    @SerializedName("GPSOff")
    GPS_OFF("GPSOff"),

    @SerializedName("PreviousValidState")
    PREVIOUS_VALID_STATE("PreviousValidState");

    private String key;

    GPSStatus(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static GPSStatus fromKey(String key) {
        for (GPSStatus unit : GPSStatus.values()) {
            if (unit.getKey().equals(key)) {
                return unit;
            }
        }
        return null;
    }
}
