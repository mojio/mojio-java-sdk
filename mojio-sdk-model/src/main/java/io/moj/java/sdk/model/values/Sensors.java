package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

public class Sensors {
    @SerializedName(value = "TowState", alternate = {"towState", "towstate"})
    private TowState towState;

    public TowState getTowState() {
        return towState;
    }

    public void setTowState(TowState towState) {
        this.towState = towState;
    }

    @Override
    public String toString() {
        return "Sensors{" +
                "towState=" + towState +
                '}';
    }
}
