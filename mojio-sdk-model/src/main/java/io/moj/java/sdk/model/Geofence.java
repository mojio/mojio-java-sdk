package io.moj.java.sdk.model;

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

    private String Name;
    private String Description;
    private Region Region;
    private String[] Tags;

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

    @Override
    public String toString() {
        return "Geofence{" +
                "Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                ", Region=" + Region +
                ", Tags=" + Arrays.toString(Tags) +
                "} " + super.toString();
    }
}
