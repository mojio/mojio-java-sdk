package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

/**
 * Model object for an StateTimestamp value.
 * Created by mhorie on 2016-01-14.
 */
public abstract class StateTimestamp {

    @SerializedName(value = "Timestamp", alternate = "timestamp")
    private String Timestamp;

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "StateTimestamp{" +
                "Timestamp='" + Timestamp + '\'' +
                '}';
    }
}
