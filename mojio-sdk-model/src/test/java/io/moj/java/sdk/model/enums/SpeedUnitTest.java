package io.moj.java.sdk.model.enums;

import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import io.moj.java.sdk.math.UnitConverter;
import static io.moj.java.sdk.model.enums.SpeedUnit.MILES_PER_HOUR;
import static io.moj.java.sdk.model.enums.SpeedUnit.KILOMETERS_PER_HOUR;

import static com.google.common.truth.Truth.assertThat;

public class SpeedUnitTest extends EnumTest<SpeedUnit> {

    @Override
    public Map<String, SpeedUnit> getMapping() {
        // these are defined by the server's contract so should be safe to validate against in tests
        return new ImmutableMap.Builder<String, SpeedUnit>()
                .put("MilesPerHour", SpeedUnit.MILES_PER_HOUR)
                .put("KilometersPerHour", SpeedUnit.KILOMETERS_PER_HOUR)
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
        assertThat(MILES_PER_HOUR.convertTo(KILOMETERS_PER_HOUR).convert(1337)).isWithin(0.01f).of(2151.693f);
        assertThat(KILOMETERS_PER_HOUR.convertTo(MILES_PER_HOUR).convert(2151.693f)).isWithin(0.01f).of(1337f);

        // test some realistic speed values
        assertThat(KILOMETERS_PER_HOUR.convertTo(MILES_PER_HOUR).convert(0)).isWithin(0.0001f).of(0);
        assertThat(KILOMETERS_PER_HOUR.convertTo(MILES_PER_HOUR).convert(20)).isWithin(0.0001f).of(12.4274f);
        assertThat(KILOMETERS_PER_HOUR.convertTo(MILES_PER_HOUR).convert(50)).isWithin(0.0001f).of(31.0686f);
        assertThat(KILOMETERS_PER_HOUR.convertTo(MILES_PER_HOUR).convert(80)).isWithin(0.0001f).of(49.7097f);
        assertThat(KILOMETERS_PER_HOUR.convertTo(MILES_PER_HOUR).convert(100)).isWithin(0.0001f).of(62.1371f);
        assertThat(KILOMETERS_PER_HOUR.convertTo(MILES_PER_HOUR).convert(120)).isWithin(0.0001f).of(74.5645f);
        assertThat(KILOMETERS_PER_HOUR.convertTo(MILES_PER_HOUR).convert(160)).isWithin(0.0001f).of(99.4194f);
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