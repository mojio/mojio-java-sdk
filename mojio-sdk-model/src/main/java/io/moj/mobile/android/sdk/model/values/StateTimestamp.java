package io.moj.mobile.android.sdk.model.values;

/**
 * Model object for an StateTimestamp value.
 * Created by mhorie on 2016-01-14.
 */
public abstract class StateTimestamp {

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
