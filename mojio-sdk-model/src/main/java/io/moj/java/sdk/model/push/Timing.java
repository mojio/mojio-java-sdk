package io.moj.java.sdk.model.push;

import com.google.gson.annotations.SerializedName;

/**
 * An enumeration of timing restrictions that can be applied to an {@link io.moj.java.sdk.model.push.Observer}.
 * Created by skidson on 2016-04-28.
 */
public enum Timing {

    /**
     * The observer will trigger every time the condition is met (this is the default behaviour).
     */
    @SerializedName("High")
    HIGH("High"),

    /**
     * The observer will fire when the condition evaluation changes (true to false, false to true).
     */
    @SerializedName("Change")
    CHANGE("Change"),

    /**
     * The observer will only fire when the condition changes from false to true.
     */
    @SerializedName("Enter")
    ENTER("Enter"),

    /**
     * The observer will only fire when the condition changes from true to false.
     */
    @SerializedName("Exit")
    EXIT("Exit");

    private final String key;

    Timing(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static Timing fromKey(String key) {
        for (Timing value : values()) {
            if (value.getKey().equals(key)) {
                return value;
            }
        }
        return null;
    }
}
