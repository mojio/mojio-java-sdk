package io.moj.java.sdk;

import io.moj.java.sdk.model.App;
import io.moj.java.sdk.model.Group;
import io.moj.java.sdk.model.Mojio;
import io.moj.java.sdk.model.MojioObject;
import io.moj.java.sdk.model.Trip;
import io.moj.java.sdk.model.User;
import io.moj.java.sdk.model.Vehicle;

/**
 * Enumeration of resources provided by the Mojio API.
 * Created by skidson on 2016-04-15.
 */
public enum Resource {

    APP("apps", App.class),
    GROUP("groups", Group.class),
    MOJIO("mojios", Mojio.class),
    TRIP("trips", Trip.class),
    USER("users", User.class),
    VEHICLE("vehicles", Vehicle.class);

    private final String path;
    private final Class<? extends MojioObject> model;

    Resource(String path, Class<? extends MojioObject> model) {
        this.path = path;
        this.model = model;
    }

    public String getPath() {
        return path;
    }

    public Class<? extends MojioObject> getModel() {
        return model;
    }
}
