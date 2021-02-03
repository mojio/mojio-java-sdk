package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Harsh event object found in the Trip object
 * Created by Mauro on 2017-06-26.
 */
public class HarshEvent implements Serializable {
    @SerializedName(value = "HarshEventState", alternate = "harshEventState")
    private HarshEventState HarshEventState;
    @SerializedName(value = "Location", alternate = "location")
    private Location Location;

    public HarshEventState getHarshEventState() {
        return HarshEventState;
    }

    public void setHarshEventState(HarshEventState harshEventState) {
        this.HarshEventState = harshEventState;
    }

    public Location getLocation() {
        return Location;
    }

    public void setLocation(Location location) {
        this.Location = location;
    }

    @Override
    public String toString() {
        return "HarshEvent{" +
                "HarshEventState=" + HarshEventState +
                ", Location=" + Location +
                '}';
    }
}
