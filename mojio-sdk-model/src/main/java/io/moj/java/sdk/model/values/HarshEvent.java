package io.moj.java.sdk.model.values;

/**
 * Harsh event object found in the Trip object
 * Created by Mauro on 2017-06-26.
 */
public class HarshEvent {
    private HarshEventState HarshEventState;
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
