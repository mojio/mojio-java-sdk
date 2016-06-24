package io.moj.java.sdk.model.stream;

import io.moj.java.sdk.model.MojioObject;

/**
 * Base activity stream object.
 * Created by Mauro on 2016-06-23.
 */
public class BaseActivityObject implements MojioObject {
    public static final String CONTEXT = "Context";
    public static final String TYPE = "Type";
    public static final String NAME = "Name";
    public static final String LOCATION = "Location";
    public static final String ORIGIN = "Origin";

    private String Id;
    private String Context;
    private String Type;
    private String Name;
    private Location Location;
    private Link Origin;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        Context = context;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Location getLocation() {
        return Location;
    }

    public void setLocation(Location location) {
        Location = location;
    }

    public Link getOrigin() {
        return Origin;
    }

    public void setOrigin(Link origin) {
        Origin = origin;
    }

    @Override
    public String toString() {
        return "BaseActivityObject{" +
                "Id='" + Id + '\'' +
                ", Context='" + Context + '\'' +
                ", Type='" + Type + '\'' +
                ", Name='" + Name + '\'' +
                ", Location=" + Location +
                ", Origin=" + Origin +
                '}';
    }
}
