package io.moj.java.sdk.model;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import io.moj.java.sdk.model.enums.EnumTest;

/**
 * Unit test for Geofence State enum (following same format as TransactionStateTest).
 * Created by alexc on 2017-03-03.
 */
public class GeofenceStateTest extends EnumTest<Geofence.State> {

    private static final Map<String, Geofence.State> MAPPING;
    static {
        Map<String, Geofence.State> mapping = new HashMap<>();
        mapping.put("OnEnter", Geofence.State.ON_ENTER);
        mapping.put("OnExit", Geofence.State.ON_EXIT);
        mapping.put("Always", Geofence.State.ALWAYS);
        mapping.put("Never", Geofence.State.NEVER);
        MAPPING = Collections.unmodifiableMap(mapping);
    }

    @Override
    public Map<String, Geofence.State> getMapping() {
        return MAPPING;
    }

    @Test
    @Override
    public void testSerialization() {
        super.testSerialization();
    }

    @Test
    @Override
    public void testDeserialization() {
        super.testDeserialization();
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