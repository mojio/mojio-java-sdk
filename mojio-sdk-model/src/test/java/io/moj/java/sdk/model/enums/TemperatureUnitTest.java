package io.moj.java.sdk.model.enums;

import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;


import static com.google.common.truth.Truth.assertThat;

public class TemperatureUnitTest extends EnumTest<TemperatureUnit> {

    @Override
    public Map<String, TemperatureUnit> getMapping() {
        // these are defined by the server's contract so should be safe to validate against in tests
        return new ImmutableMap.Builder<String, TemperatureUnit>()
                .put("Fahrenheit", TemperatureUnit.TEMPERATURE_FAHRENHEIT)
                .put("Celsius", TemperatureUnit.TEMPERATURE_CELSIUS)
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
    public void testConversionToCelsius() {
        TemperatureUnit unit = TemperatureUnit.TEMPERATURE_CELSIUS;
        TemperatureUnit converted = TemperatureUnit.fromKey("Celsius");
        assertThat(unit).isEqualTo(converted);
    }

    @Test
    public void testConversionToFahrenheit() {
        TemperatureUnit unit = TemperatureUnit.TEMPERATURE_FAHRENHEIT;
        TemperatureUnit converted = TemperatureUnit.fromKey("Fahrenheit");
        assertThat(unit).isEqualTo(converted);
    }

}
