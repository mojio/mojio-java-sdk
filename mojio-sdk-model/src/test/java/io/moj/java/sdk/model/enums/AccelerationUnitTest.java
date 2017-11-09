package io.moj.java.sdk.model.enums;

import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import io.moj.java.sdk.math.UnitConverter;

import static com.google.common.truth.Truth.assertThat;
import static io.moj.java.sdk.model.enums.AccelerationUnit.METERS_PER_SECOND_PER_SECOND;
import static io.moj.java.sdk.model.enums.AccelerationUnit.KILOMETERS_PER_HOUR_PER_SECOND;
import static io.moj.java.sdk.model.enums.AccelerationUnit.MILES_PER_HOUR_PER_SECOND;

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

    @Test
    public void testTo_kmToMiles() {
        assertThat(METERS_PER_SECOND_PER_SECOND.convertTo(KILOMETERS_PER_HOUR_PER_SECOND).convert(1337)).isWithin(0.01f).of(4813.2f);
        assertThat(METERS_PER_SECOND_PER_SECOND.convertTo(MILES_PER_HOUR_PER_SECOND).convert(1337)).isWithin(0.01f).of(2990.784f);
        assertThat(KILOMETERS_PER_HOUR_PER_SECOND.convertTo(METERS_PER_SECOND_PER_SECOND).convert(1337)).isWithin(0.01f).of(371.3889f);
        assertThat(KILOMETERS_PER_HOUR_PER_SECOND.convertTo(MILES_PER_HOUR_PER_SECOND).convert(1337)).isWithin(0.01f).of(830.7733f);
        assertThat(MILES_PER_HOUR_PER_SECOND.convertTo(METERS_PER_SECOND_PER_SECOND).convert(1337)).isWithin(0.01f).of(597.6925f);
        assertThat(MILES_PER_HOUR_PER_SECOND.convertTo(KILOMETERS_PER_HOUR_PER_SECOND).convert(1337)).isWithin(0.01f).of(2151.693f);
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