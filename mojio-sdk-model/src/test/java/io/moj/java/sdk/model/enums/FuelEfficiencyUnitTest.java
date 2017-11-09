package io.moj.java.sdk.model.enums;

import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import io.moj.java.sdk.math.UnitConverter;

import static com.google.common.truth.Truth.assertThat;
import static io.moj.java.sdk.model.enums.FuelEfficiencyUnit.KMPL;
import static io.moj.java.sdk.model.enums.FuelEfficiencyUnit.LP100KM;
import static io.moj.java.sdk.model.enums.FuelEfficiencyUnit.MPG;

public class FuelEfficiencyUnitTest extends EnumTest<FuelEfficiencyUnit> {

    @Override
    public Map<String, FuelEfficiencyUnit> getMapping() {
        // these are defined by the server's contract so should be safe to validate against in tests
        return new ImmutableMap.Builder<String, FuelEfficiencyUnit>()
                .put("MilesPerGallon", MPG)
                .put("LitersPerHundredKilometers", LP100KM)
                .put("KilometerPerLiter", KMPL)
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
    public void testTo_mpgToLp100Km() {
        assertThat(MPG.convertTo(LP100KM).convert(0)).isWithin(0.000000001f).of(0f);
        assertThat(MPG.convertTo(LP100KM).convert(1)).isWithin(0.000001f).of(235.214583f);
        assertThat(MPG.convertTo(LP100KM).convert(10)).isWithin(0.000001f).of(23.521458f);
        assertThat(MPG.convertTo(LP100KM).convert(50)).isWithin(0.000001f).of(4.704292f);
        assertThat(MPG.convertTo(LP100KM).convert(200)).isWithin(0.000001f).of(1.176073f);
    }

    @Test
    public void testTo_mpgToKmpl() {
        assertThat(MPG.convertTo(KMPL).convert(0)).isWithin(0.000000001f).of(0f);
        assertThat(MPG.convertTo(KMPL).convert(1)).isWithin(0.0000001f).of(0.425143706f);
        assertThat(MPG.convertTo(KMPL).convert(10)).isWithin(0.000001f).of(4.25143706f);
        assertThat(MPG.convertTo(KMPL).convert(50)).isWithin(0.0000001f).of(21.2571853f);
        assertThat(MPG.convertTo(KMPL).convert(200)).isWithin(0.0000001f).of(85.0287412f);
    }

    @Test
    public void testTo_lp100kmToMpg() {
        assertThat(LP100KM.convertTo(MPG).convert(0)).isWithin(0.000000001f).of(0f);
        assertThat(LP100KM.convertTo(MPG).convert(235.214583f)).isWithin(0.000000001f).of(1f);
        assertThat(LP100KM.convertTo(MPG).convert(23.521458f)).isWithin(0.000000001f).of(10f);
        assertThat(LP100KM.convertTo(MPG).convert(4.704292f)).isWithin(0.000000001f).of(50f);
        assertThat(LP100KM.convertTo(MPG).convert(1.176073f)).isWithin(0.000000001f).of(200f);
    }

    @Test
    public void testTo_lp100kmToKmpl() {
        assertThat(LP100KM.convertTo(KMPL).convert(0)).isWithin(0.000000001f).of(0f);
        assertThat(LP100KM.convertTo(KMPL).convert(1)).isWithin(0.000000001f).of(100f);
        assertThat(LP100KM.convertTo(KMPL).convert(10)).isWithin(0.000000001f).of(10f);
        assertThat(LP100KM.convertTo(KMPL).convert(50)).isWithin(0.000000001f).of(2f);
        assertThat(LP100KM.convertTo(KMPL).convert(200)).isWithin(0.000000001f).of(0.5f);
    }

    @Test
    public void testTo_KmplToMpg() {
        assertThat(KMPL.convertTo(MPG).convert(0)).isWithin(0.000000001f).of(0f);
        assertThat(KMPL.convertTo(MPG).convert(0.425143706f)).isWithin(0.000000001f).of(1);
        assertThat(KMPL.convertTo(MPG).convert(4.25143706f)).isWithin(0.000001f).of(10f);
        assertThat(KMPL.convertTo(MPG).convert(21.2571853f)).isWithin(0.000000001f).of(50f);
        assertThat(KMPL.convertTo(MPG).convert(85.0287412f)).isWithin(0.000000001f).of(200f);
    }

    @Test
    public void testTo_KmplTolp100km() {
        assertThat(KMPL.convertTo(LP100KM).convert(0)).isWithin(0.000000001f).of(0f);
        assertThat(KMPL.convertTo(LP100KM).convert(1)).isWithin(0.000000001f).of(100f);
        assertThat(KMPL.convertTo(LP100KM).convert(10)).isWithin(0.000000001f).of(10f);
        assertThat(KMPL.convertTo(LP100KM).convert(50)).isWithin(0.000000001f).of(2f);
        assertThat(KMPL.convertTo(LP100KM).convert(200)).isWithin(0.000000001f).of(0.5f);
    }

    @Test
    public void testAllConversionsExist() {
        for (FuelEfficiencyUnit unit : FuelEfficiencyUnit.values()) {
            for (FuelEfficiencyUnit other : FuelEfficiencyUnit.values()) {
                UnitConverter converter = unit.convertTo(other);
                assertThat(converter).isNotNull();
            }
        }
    }

    @Test
    public void testConversionToSelf() {
        for (FuelEfficiencyUnit unit : FuelEfficiencyUnit.values()) {
            assertThat(unit.convertTo(unit).convert(1337)).isWithin(0.00000000001f).of(1337);
        }
    }
}