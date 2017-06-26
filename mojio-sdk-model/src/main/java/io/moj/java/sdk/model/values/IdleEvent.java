package io.moj.java.sdk.model.values;

/**
 * Idle event object found in the Trip object.
 * Created by Mauro on 2017-06-26.
 */
public class IdleEvent {
    private IdleEventState IdleState;
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
