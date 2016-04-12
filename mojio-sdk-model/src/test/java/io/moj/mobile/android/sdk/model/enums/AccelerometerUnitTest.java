package io.moj.mobile.android.sdk.model.enums;

import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class AccelerometerUnitTest extends EnumTest<AccelerometerUnit> {

    @Override
    public Map<String, AccelerometerUnit> getMapping() {
        // these are defined by the server's contract so should be safe to validate against in tests
        return new ImmutableMap.Builder<String, AccelerometerUnit>()
                .put("MilliGUnits", AccelerometerUnit.MILLI_G_UNITS)
                .put("NewtonsPerKilogram", AccelerometerUnit.NEWTONS_PER_KILOGRAM)
                .put("XirgoUnit", AccelerometerUnit.XIRGO_UNIT)
                .put("MetersPerSecondPerSecond", AccelerometerUnit.METERS_PER_SECOND_PER_SECOND)
                .put("CentimetersPerSecondPerSecond", AccelerometerUnit.CM_PER_SECOND_PER_SECOND)
                .put("GUnits", AccelerometerUnit.G_UNITS)
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