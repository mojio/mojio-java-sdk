package io.moj.java.sdk.model.values;

public class GpsRadio {
    private String Timestamp;
    private Location Location;
    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public Location getLocation() {
        return Location;
    }

    public void setLocation(Location location) {
        Location = location;
    }

    @Override
    public String toString() {
        return "GpsRadio{" +
                "Timestamp='" + Timestamp + '\'' +
                ", Location=" + Location +
                '}';
    }
}