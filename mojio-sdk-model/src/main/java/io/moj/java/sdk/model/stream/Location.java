package io.moj.java.sdk.model.stream;

/**
 * Location object in activity streams.
 * Created by Mauro on 2016-06-23.
 */
public class Location {
    public static final String TYPE = "Type";
    public static final String LATITUDE = "Latitude";
    public static final String LONGITUDE = "Longitude";
    public static final String RADIUS = "Radius";
    public static final String NAME = "Name";

    private String Type;
    private Double Latitude;
    private Double Longitude;
    private Double Radius;
    private String Name;

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    public Double getRadius() {
        return Radius;
    }

    public void setRadius(Double radius) {
        Radius = radius;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Location{" +
                "Type='" + Type + '\'' +
                ", Latitude=" + Latitude +
                ", Longitude=" + Longitude +
                ", Radius=" + Radius +
                ", Name='" + Name + '\'' +
                '}';
    }
}
