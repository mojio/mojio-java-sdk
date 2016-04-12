package io.moj.mobile.android.sdk.model.enums;

import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class AccelerationUnitTest extends EnumTest<AccelerationUnit> {

    @Override
    public Map<String, AccelerationUnit> getMapping() {
        // these are defined by the server's contract so should be safe to validate against in tests
        return new ImmutableMap.Builder<String, AccelerationUnit>()
                .put("MetersPerSecondPerSecond", AccelerationUnit.METERS_PER_SECOND_PER_SECOND)
                .put("KilometersPerHourPerSecond", AccelerationUnit.KILOMETERS_PER_HOUR_PER_SECOND)
                .put("MilesPerHourPerSecond", AccelerationUnit.MILES_PER_HOUR_PER_SECOND)
                .build();
    }

    @Test
    @Override
    public void testSerialization() {
        super.testSerialization();
    }

    @Test
    public void testDeserialization() {
        super.testDeserialization();
    }

    @Test
    @Override
    public void testFromKey() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        super.testFromKey();
    }

    @Test
    @Override
    public void testFromKey_invalid() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
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