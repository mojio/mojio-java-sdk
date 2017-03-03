package io.moj.java.sdk.model;

import com.google.gson.annotations.SerializedName;

import io.moj.java.sdk.model.values.Region;

import java.util.Arrays;

/**
 * Model object for a Geofence.
 * Created by skidson on 2016-07-07.
 */
public class Geofence extends AbstractMojioObject {

    public static final String NAME = "Name";
    public static final String DESCRIPTION = "Description";
    public static final String REGION = "Region";
    public static final String TAGS = "Tags";
    public static final String VEHICLEIDS = "VehicleIds";
    public static final String ENABLE_ACTIVITY_STREAM = "EnableActivityStream";

    private String Name;
    private String Description;
    private Region Region;
    private String[] Tags;
    private String[] VehicleIds;
    private State EnableActivityStream;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String[] getTags() {
        return Tags;
    }

    public void setTags(String[] tags) {
        Tags = tags;
    }

    public Region getRegion() {
        return Region;
    }

    public void setRegion(Region region) {
        Region = region;
    }

    public String[] getVehicleIds() {
        return VehicleIds;
    }

    public void setVehicles(String[] vehicleIds) {
        VehicleIds = vehicleIds;
    }

    public State getEnableActivityStream() {
        return EnableActivityStream;
    }

    public void setEnableActivityStream(State enableActivityStream) {
        EnableActivityStream = enableActivityStream;
    }

    @Override
    public String toString() {
        return "Geofence{" +
                "Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Region=" + Region +
                ", Tags=" + Arrays.toString(Tags) +
                ", VehicleIds=" + Arrays.toString(VehicleIds) +
                ", EnabledActivityStream=" + EnableActivityStream +
                "} " + super.toString();
    }

    public enum State {
        @SerializedName("OnEnter")
        ON_ENTER("OnEnter"),

        @SerializedName("OnExit")
        ON_EXIT("OnExit"),

        @SerializedName("Always")
        ALWAYS("Always"),

        @SerializedName("Never")
        NEVER("Never");

        private final String key;

        State(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public static State fromKey(String key) {
            for (State type : values()) {
                if (type.getKey().equals(key))
                    return type;
            }
            return null;
        }
    }

}
