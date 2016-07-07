package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;
import io.moj.java.sdk.model.enums.DistanceUnit;

/**
 * Model object for a region.
 * Created by skidson on 2016-07-07.
 */
public class Region {

    private Type Type;
    private Float Lat;
    private Float Lng;
    private DistanceUnit Radius;

    public Region.Type getType() {
        return Type;
    }

    public void setType(Region.Type type) {
        Type = type;
    }

    public Float getLat() {
        return Lat;
    }

    public void setLat(Float lat) {
        Lat = lat;
    }

    public Float getLng() {
        return Lng;
    }

    public void setLng(Float lng) {
        Lng = lng;
    }

    public DistanceUnit getRadius() {
        return Radius;
    }

    public void setRadius(DistanceUnit radius) {
        Radius = radius;
    }

    @Override
    public String toString() {
        return "Region{" +
                "Type=" + Type +
                ", Lat=" + Lat +
                ", Lng=" + Lng +
                ", Radius=" + Radius +
                '}';
    }

    public enum Type {
        @SerializedName("Circle")
        CIRCLE("Circle");

        private final String key;

        Type(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public static Type fromKey(String key) {
            for (Type type : values()) {
                if (type.getKey().equals(key))
                    return type;
            }
            return null;
        }
    }

}
