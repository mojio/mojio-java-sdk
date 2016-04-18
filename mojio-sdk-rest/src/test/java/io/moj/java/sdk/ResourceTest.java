package io.moj.java.sdk;

import com.google.common.collect.ImmutableMap;
import io.moj.java.sdk.model.App;
import io.moj.java.sdk.model.Group;
import io.moj.java.sdk.model.Mojio;
import io.moj.java.sdk.model.MojioObject;
import io.moj.java.sdk.model.Trip;
import io.moj.java.sdk.model.User;
import io.moj.java.sdk.model.Vehicle;
import org.junit.Test;

import java.util.Map;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by skidson on 2016-04-18.
 */
public class ResourceTest {

    private Map<Resource, String> PATH_MAP = new ImmutableMap.Builder<Resource, String>()
            .put(Resource.APP, "apps")
            .put(Resource.GROUP, "groups")
            .put(Resource.MOJIO, "mojios")
            .put(Resource.TRIP, "trips")
            .put(Resource.USER, "users")
            .put(Resource.VEHICLE, "vehicles")
            .build();

    private Map<Resource, Class<? extends MojioObject>> MODEL_MAP =
            new ImmutableMap.Builder<Resource, Class<? extends MojioObject>>()
            .put(Resource.APP, App.class)
            .put(Resource.GROUP, Group.class)
            .put(Resource.MOJIO, Mojio.class)
            .put(Resource.TRIP, Trip.class)
            .put(Resource.USER, User.class)
            .put(Resource.VEHICLE, Vehicle.class)
            .build();

    /**
     * Assert that we have tests for each {@link io.moj.java.sdk.Resource} value.
     */
    @Test
    public void testValues() {
        assertThat(PATH_MAP.keySet()).containsExactly(Resource.values());
        assertThat(MODEL_MAP.keySet()).containsExactly(Resource.values());
        for (Resource resource : Resource.values()) {
            assertThat(PATH_MAP).containsKey(resource);
        }
    }

    @Test
    public void testGetPath() {
        for (Resource resource : Resource.values()) {
            assertThat(resource.getPath()).isEqualTo(PATH_MAP.get(resource));
        }
    }

    @Test
    public void testGetModel() {
        for (Resource resource : Resource.values()) {
            assertThat(resource.getModel()).isEqualTo(MODEL_MAP.get(resource));
        }
    }

}
