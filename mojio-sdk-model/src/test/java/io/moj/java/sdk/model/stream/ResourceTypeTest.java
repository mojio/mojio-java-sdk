package io.moj.java.sdk.model.stream;

import com.google.common.collect.ImmutableMap;
import io.moj.java.sdk.model.enums.EnumTest;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by skidson on 2016-07-08.
 */
public class ResourceTypeTest extends EnumTest<ResourceType> {

    @Override
    public Map<String, ResourceType> getMapping() {
        return new ImmutableMap.Builder<String, ResourceType>()
                .put("Vehicle", ResourceType.VEHICLE)
                .put("User", ResourceType.USER)
                .put("Mojio", ResourceType.MOJIO)
                .put("Trip", ResourceType.TRIP)
                .put("VehicleState", ResourceType.VEHICLE_STATE)
                .put("ParkingStartingSoon", ResourceType.PARKING_STARTING_SOON)
                .put("ParkingStarted", ResourceType.PARKING_STARTED)
                .put("ParkingEndingSoon", ResourceType.PARKING_ENDING_SOON)
                .put("ParkingEnded", ResourceType.PARKING_ENDED)
                .build();
    }

    @Test
    @Override
    public void testFromKey() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testFromKey();
    }

    @Test
    @Override
    public void testFromKey_invalid() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testFromKey_invalid();
    }

    @Test
    @Override
    public void testGetKey() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testGetKey();
    }

    @Test
    @Override
    public void testValues() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testValues();
    }
}
