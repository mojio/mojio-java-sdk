package io.moj.java.sdk.model.values;

import java.io.Serializable;

/**
 * Model object for PredictiveWarning value. Used for PredictiveMaintenance value
 * Created by Mykhaylo Tauzhnianskyi on 2019-11-11.
 */
public class PredictiveWarning implements Serializable {

    public static final String TIMESTAMP = "Timestamp";
    public static final String WARNING = "Warning";

    private String Timestamp;
    private Boolean Warning;

    public String getTimestamp() { return Timestamp; }

    public void setTimestamp(String timestamp) { Timestamp = timestamp; }

    public Boolean isWarning() { return Warning; }

    public void setWarning(Boolean warning) { Warning = warning; }

    @Override
    public String toString() {
        return "PredictiveWarning{" +
                "Warning='" + Warning + '\'' +
                ", Timestamp='" + Timestamp +
                '}';
    }
}
