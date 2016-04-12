package io.moj.mobile.android.sdk.model;

import org.junit.Test;

import static io.moj.mobile.android.sdk.test.TestUtils.assertAccess;
import static io.moj.mobile.android.sdk.test.TestUtils.assertToStringContainsAllFields;

/**
 * Created by skidson on 16-02-23.
 */
public class EntityTests {

    @Test
    public void testApp() throws IllegalAccessException {
        App app = new App();
        assertToStringContainsAllFields(app);
        assertAccess(app);
    }

    @Test
    public void testGroup() throws IllegalAccessException {
        Group group = new Group();
        assertToStringContainsAllFields(group);
        assertAccess(group);
    }

    @Test
    public void testListResponse() throws IllegalAccessException {
        ListResponse response = new ListResponse();
        assertToStringContainsAllFields(response);
        assertAccess(response);
    }

    @Test
    public void testMojio() throws IllegalAccessException {
        Mojio mojio = new Mojio();
        assertToStringContainsAllFields(mojio);
        assertAccess(mojio);
    }

    @Test
    public void testTrip() throws IllegalAccessException {
        Trip trip = new Trip();
        assertToStringContainsAllFields(trip);
        assertAccess(trip);
    }

    @Test
    public void testUser() throws IllegalAccessException {
        User user = new User();
        assertToStringContainsAllFields(user);
        assertAccess(user);
    }

    @Test
    public void testVehicle() throws IllegalAccessException {
        Vehicle vehicle = new Vehicle();
        assertToStringContainsAllFields(vehicle);
        assertAccess(vehicle);
    }

    @Test
    public void testVehicleMeasure() throws IllegalAccessException {
        VehicleMeasure vehicleMeasure = new VehicleMeasure();
        assertToStringContainsAllFields(vehicleMeasure);
        assertAccess(vehicleMeasure);
    }

}
