package io.moj.java.sdk.model.enums;

import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import io.moj.java.sdk.math.UnitConverter;

import static com.google.common.truth.Truth.assertThat;
import static io.moj.java.sdk.model.enums.VoltageUnit.MILLIVOLTS;
import static io.moj.java.sdk.model.enums.VoltageUnit.VOLTS;

public class VoltageUnitTest extends EnumTest<VoltageUnit> {

    @Override
    public Map<String, VoltageUnit> getMapping() {
        // these are defined by the server's contract so should be safe to validate against in tests
        return new ImmutableMap.Builder<String, VoltageUnit>()
                .put("Volts", VoltageUnit.VOLTS)
                .put("MilliVolts", VoltageUnit.MILLIVOLTS)
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
    public void testTo_voltsToMillivolts() {
        assertThat(VOLTS.convertTo(MILLIVOLTS).convert(1337)).isWithin(0.01f).of(1337000f);
        assertThat(VOLTS.convertTo(MILLIVOLTS).convert(1)).isWithin(0.0001f).of(1000f);
        assertThat(VOLTS.convertTo(MILLIVOLTS).convert(1000)).isWithin(0.0001f).of(1000000f);
    }

    @Test
    public void testTo_millivoltsToVolts() {
        assertThat(MILLIVOLTS.convertTo(VOLTS).convert(1337000f)).isWithin(0.01f).of(1337f);
        assertThat(MILLIVOLTS.convertTo(VOLTS).convert(1)).isWithin(0.0001f).of(0.001f);
        assertThat(MILLIVOLTS.convertTo(VOLTS).convert(1000)).isWithin(0.0001f).of(1f);
    }

    @Test
    public void testAllConversionsExist() {
        for (VoltageUnit unit : VoltageUnit.values()) {
            for (VoltageUnit other : VoltageUnit.values()) {
                UnitConverter converter = unit.convertTo(other);
                assertThat(converter).isNotNull();
            }
        }
    }

    @Test
    public void testConversionToSelf() {
        for (VoltageUnit unit : VoltageUnit.values()) {
            assertThat(unit.convertTo(unit).convert(1337)).isWithin(0.00000000001f).of(1337);
        }
    }
}