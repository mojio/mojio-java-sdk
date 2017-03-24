package io.moj.java.sdk.model.enums;

import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Unit test for CompatLevel enum.
 * Created by alexc on 2017-03-24.
 */
public class CompatLevelTest extends EnumTest<CompatLevel> {
    @Override
    public Map<String, CompatLevel> getMapping() {
        // these are defined by the server's contract so should be safe to validate against in tests
        return new ImmutableMap.Builder<String, CompatLevel>()
                .put("Full", CompatLevel.FULL)
                .put("Partial", CompatLevel.PARTIAL)
                .put("Minimum", CompatLevel.MINIMUM)
                .put("NotCompatible", CompatLevel.NOTCOMPATIBLE)
                .put("Unknown", CompatLevel.UNKNOWN)
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