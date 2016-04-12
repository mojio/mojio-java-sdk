package io.moj.mobile.android.sdk.model.enums;

import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class DurationUnitTest extends EnumTest<DurationUnit> {

    @Override
    public Map<String, DurationUnit> getMapping() {
        // these are defined by the server's contract so should be safe to validate against in tests
        return new ImmutableMap.Builder<String, DurationUnit>()
                .put("Weeks", DurationUnit.WEEKS)
                .put("Days", DurationUnit.DAYS)
                .put("Hours", DurationUnit.HOURS)
                .put("Minutes", DurationUnit.MINUTES)
                .put("Seconds", DurationUnit.SECONDS)
                .put("Milliseconds", DurationUnit.MILLISECONDS)
                .put("Ticks", DurationUnit.TICKS)
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