package io.moj.java.sdk.model.values;

/**
 * Model used to update a DTC status to the server.
 * Created by Mauro on 2016-09-01.
 */
public class DtcStatusUpdate {

    private Boolean Ignored;

    public Boolean getIgnored() {
        return Ignored;
    }

    public void setIgnored(Boolean ignored) {
        Ignored = ignored;
    }

    @Override
    public String toString() {
        return "DtcStatusUpdate{" +
                "Ignored=" + Ignored +
                '}';
    }
}
