package io.moj.java.sdk.model;

import io.moj.java.sdk.model.values.Region;

/**
 * Model object for a Geofence.
 * Created by skidson on 2016-07-07.
 */
public class Geofence extends AbstractMojioObject {

    public static final String NAME = "Name";
    public static final String DESCRIPTION = "Description";
    public static final String REGION = "Region";
    public static final String ENABLED = "Enabled";
    public static final String TAGS = "Tags";

    private String Name;
    private String Description;
    private Region Region;
    private Boolean Enabled;
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

    public Boolean getEnabled() {
        return Enabled;
    }

    public void setEnabled(Boolean enabled) {
        Enabled = enabled;
    }

    public String[] getTags() {
        return Tags;
    }

    public void setTags(String[] tags) {
        Tags = tags;
    }
}
