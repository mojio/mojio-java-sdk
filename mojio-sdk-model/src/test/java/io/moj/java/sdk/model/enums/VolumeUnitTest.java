package io.moj.java.sdk.model.enums;

import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import io.moj.java.sdk.math.UnitConverter;

import static com.google.common.truth.Truth.assertThat;
import static io.moj.java.sdk.model.enums.VolumeUnit.GALLONS;
import static io.moj.java.sdk.model.enums.VolumeUnit.LITERS;

public class VolumeUnitTest extends EnumTest<VolumeUnit> {

    @Override
    public Map<String, VolumeUnit> getMapping() {
        // these are defined by the server's contract so should be safe to validate against in tests
        return new ImmutableMap.Builder<String, VolumeUnit>()
                .put("Gallons", VolumeUnit.GALLONS)
                .put("Liters", VolumeUnit.LITERS)
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
    public void testTo_gallonsToLiters() {
        assertThat(GALLONS.convertTo(LITERS).convert(1)).isWithin(0.0001f).of(3.78541f);
        assertThat(GALLONS.convertTo(LITERS).convert(100)).isWithin(0.0001f).of(378.541f);
        assertThat(GALLONS.convertTo(LITERS).convert(1000)).isWithin(0.0001f).of(3785.41f);
    }

    @Test
    public void testTo_litersToGallons() {
        assertThat(LITERS.convertTo(GALLONS).convert(1)).isWithin(0.0001f).of(0.264172f);
        assertThat(LITERS.convertTo(GALLONS).convert(100)).isWithin(0.0001f).of(26.4172f);
        assertThat(LITERS.convertTo(GALLONS).convert(1000)).isWithin(0.0001f).of(264.172f);
    }

    @Test
    public void testAllConversionsExist() {
        for (VolumeUnit unit : VolumeUnit.values()) {
            for (VolumeUnit other : VolumeUnit.values()) {
                UnitConverter converter = unit.convertTo(other);
                assertThat(converter).isNotNull();
            }
        }
    }

    @Test
    public void testConversionToSelf() {
        for (VolumeUnit unit : VolumeUnit.values()) {
            assertThat(unit.convertTo(unit).convert(1337)).isWithin(0.00000000001f).of(1337);
        }
    }
}