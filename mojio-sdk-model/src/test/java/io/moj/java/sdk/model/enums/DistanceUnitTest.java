package io.moj.java.sdk.model.enums;

import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import io.moj.java.sdk.math.UnitConverter;

import static com.google.common.truth.Truth.assertThat;
import static io.moj.java.sdk.model.enums.DistanceUnit.KILOMETERS;
import static io.moj.java.sdk.model.enums.DistanceUnit.MILES;

public class DistanceUnitTest extends EnumTest<DistanceUnit> {

    @Override
    public Map<String, DistanceUnit> getMapping() {
        // these are defined by the server's contract so should be safe to validate against in tests
        return new ImmutableMap.Builder<String, DistanceUnit>()
                .put("Kilometers", DistanceUnit.KILOMETERS)
                .put("Miles", DistanceUnit.MILES)
                .put("NauticalMiles", DistanceUnit.NAUTICAL_MILES)
                .put("Meters", DistanceUnit.METERS)
                .put("CentiMeter", DistanceUnit.CENTIMETERS)
                .put("MilliMeter", DistanceUnit.MILLIMETERS)
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

    @Test
    public void testTo_kmToMiles() {
        assertThat(KILOMETERS.convertTo(MILES).convert(1337)).isWithin(0.01f).of(830.7733f);
        assertThat(MILES.convertTo(KILOMETERS).convert(830.7733f)).isWithin(0.01f).of(1337f);

        // test some realistic odometer values
        assertThat(KILOMETERS.convertTo(MILES).convert(0)).isWithin(0.00000000001f).of(0);
        assertThat(KILOMETERS.convertTo(MILES).convert(500)).isWithin(0.001f).of(310.686f);
        assertThat(KILOMETERS.convertTo(MILES).convert(3000)).isWithin(0.01f).of(1864.114f);
        assertThat(KILOMETERS.convertTo(MILES).convert(10000)).isWithin(0.1f).of(6213.712f);
        assertThat(KILOMETERS.convertTo(MILES).convert(80000)).isWithin(1f).of(49709);
        assertThat(KILOMETERS.convertTo(MILES).convert(120000)).isWithin(1f).of(74564);
        assertThat(KILOMETERS.convertTo(MILES).convert(300000)).isWithin(1f).of(186411f);
    }

    @Test
    public void testAllConversionsExist() {
        for (DistanceUnit unit : DistanceUnit.values()) {
            for (DistanceUnit other : DistanceUnit.values()) {
                UnitConverter converter = unit.convertTo(other);
                assertThat(converter).isNotNull();
            }
        }
    }

    @Test
    public void testConversionToSelf() {
        for (DistanceUnit unit : DistanceUnit.values()) {
            assertThat(unit.convertTo(unit).convert(1337)).isWithin(0.00000000001f).of(1337);
        }
    }
}