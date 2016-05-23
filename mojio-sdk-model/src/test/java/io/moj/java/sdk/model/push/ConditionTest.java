package io.moj.java.sdk.model.push;

import io.moj.java.sdk.model.Vehicle;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by skidson on 2016-05-23.
 */
public class ConditionTest {

    @Test
    public void testAnd() {
        Condition left = Condition.whenValue(Vehicle.SPEED).gt(80);
        Condition right = Condition.when(Vehicle.TAGS).contains("speedwatch");
        assertThat(left.and(right).compile()).isEqualTo("(Speed.Value gt 80) and (Tags contains speedwatch)");
    }

    @Test
    public void testAndOr_nested() {
        Condition condition = Condition.whenValue(Vehicle.SPEED).gt(80)
                .and(Condition.when(Vehicle.TAGS).contains("speedwatch"))
                .or(Condition.whenValue(Vehicle.SPEED).gt(120));
        assertThat(condition.compile())
                .isEqualTo("((Speed.Value gt 80) and (Tags contains speedwatch)) or (Speed.Value gt 120)");
    }

    @Test
    public void testAndValue() {
        Condition condition = Condition.when(Vehicle.TAGS).contains("nascar").andValue(Vehicle.SPEED).lte(80);
        assertThat(condition.compile())
                .isEqualTo("Tags contains nascar and Speed.Value lte 80");
    }

    @Test
    public void testOrValue_nested() {
        Condition condition = Condition.whenValue(Vehicle.FUEL_LEVEL).lte(30.0).or(
                Condition.whenValue(Vehicle.FUEL_LEVEL).lte(50f).andValue(Vehicle.FUEL_EFFICIENCY).lt(28));
        assertThat(condition.compile())
                .isEqualTo("(FuelLevel.Value lte 30.0) or (FuelLevel.Value lte 50.0 and FuelEfficiency.Value lt 28)");

        Condition harshAcceleration = Condition.whenValue(Vehicle.ACCELERATION).gte(6f)
                .or(Condition.whenValue(Vehicle.ACCELERATION).gt(3f).andValue(Vehicle.HARSH_EVENT_STATE).eq(true));
        Condition harshDeceleration = Condition.whenValue(Vehicle.DECELERATION).gte(6f)
                .or(Condition.whenValue(Vehicle.DECELERATION).gt(3f).andValue(Vehicle.HARSH_EVENT_STATE).eq(true));
        Condition accident = Condition.whenValue(Vehicle.ACCIDENT_STATE).eq(true);
        condition = Condition.whenValue(Vehicle.IGNITION_STATE).eq(true)
                .and(harshAcceleration.or(harshDeceleration).or(accident));
        assertThat(condition.compile())
                .isEqualTo("(IgnitionState.Value eq true) and " +
                        "((((Acceleration.Value gte 6.0) or (Acceleration.Value gt 3.0 and HarshEventState.Value eq true)) or " +
                         "((Deceleration.Value gte 6.0) or (Deceleration.Value gt 3.0 and HarshEventState.Value eq true))) " +
                        "or (AccidentState.Value eq true))");
    }

    @Test
    public void testToString() {
        Condition left = Condition.whenValue(Vehicle.SPEED).gt(80);
        Condition right = Condition.when(Vehicle.TAGS).contains("speedwatch");
        Condition condition = left.and(right);
        assertThat(condition.toString()).isEqualTo(condition.compile());
    }

}
