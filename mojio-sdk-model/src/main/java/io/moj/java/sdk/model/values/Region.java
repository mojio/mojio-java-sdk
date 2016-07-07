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
