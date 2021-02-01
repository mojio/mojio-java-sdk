package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Idle event object found in the Trip object.
 * Created by Mauro on 2017-06-26.
 */
public class IdleEvent implements Serializable {
    @SerializedName(value = "IdleState", alternate = "idleState")
    private IdleEventState IdleState;
    @SerializedName(value = "Location", alternate = "location")
    private Location Location;

    public IdleEventState getIdleState() {
        return IdleState;
    }

    public void setIdleState(IdleEventState idleState) {
        IdleState = idleState;
    }

    public Location getLocation() {
        return Location;
    }

    public void setLocation(Location location) {
        Location = location;
    }

    @Override
    public String toString() {
        return "IdleEvent{" +
                "IdleState=" + IdleState +
                ", Location=" + Location +
                '}';
    }
}
