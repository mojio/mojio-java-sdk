package io.moj.java.sdk.model.push;

import io.moj.java.sdk.model.Vehicle;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class PropertyConditionTest {

    @Test
    public void testBuilder_eq() {
        assertThat(new PropertyCondition.Builder(Vehicle.IGNITION_STATE).eq(true).compile())
                .isEqualTo(Vehicle.IGNITION_STATE + " eq true");
        assertThat(new PropertyCondition.Builder(Vehicle.ACCIDENT_STATE).eq(false).compile())
                .isEqualTo(Vehicle.ACCIDENT_STATE + " eq false");
        assertThat(new PropertyCondition.Builder(Vehicle.SPEED).eq(5).compile())
                .isEqualTo(Vehicle.SPEED + " eq 5");
        assertThat(new PropertyCondition.Builder(Vehicle.ACCELERATION).eq(6.0).compile())
                .isEqualTo(Vehicle.ACCELERATION + " eq 6.0");
        assertThat(new PropertyCondition.Builder(Vehicle.DECELERATION).eq(7.0f).compile())
                .isEqualTo(Vehicle.DECELERATION + " eq 7.0");
        assertThat(new PropertyCondition.Builder(Vehicle.NAME).eq("CarryMcCarface").compile())
                .isEqualTo(Vehicle.NAME + " eq CarryMcCarface");
    }

    @Test
    public void testBuilder_gt() {
        assertThat(new PropertyCondition.Builder(Vehicle.SPEED).gt(5).compile())
                .isEqualTo(Vehicle.SPEED + " gt 5");
        assertThat(new PropertyCondition.Builder(Vehicle.ACCELERATION).gt(6.0).compile())
                .isEqualTo(Vehicle.ACCELERATION + " gt 6.0");
        assertThat(new PropertyCondition.Builder(Vehicle.DECELERATION).gt(7.0f).compile())
                .isEqualTo(Vehicle.DECELERATION + " gt 7.0");
    }

    @Test
    public void testBuilder_gte() {
        assertThat(new PropertyCondition.Builder(Vehicle.SPEED).gte(5).compile())
                .isEqualTo(Vehicle.SPEED + " gte 5");
        assertThat(new PropertyCondition.Builder(Vehicle.ACCELERATION).gte(6.0).compile())
                .isEqualTo(Vehicle.ACCELERATION + " gte 6.0");
        assertThat(new PropertyCondition.Builder(Vehicle.DECELERATION).gte(7.0f).compile())
                .isEqualTo(Vehicle.DECELERATION + " gte 7.0");
    }

    @Test
    public void testBuilder_lt() {
        assertThat(new PropertyCondition.Builder(Vehicle.SPEED).lt(5).compile())
                .isEqualTo(Vehicle.SPEED + " lt 5");
        assertThat(new PropertyCondition.Builder(Vehicle.ACCELERATION).lt(6.0).compile())
                .isEqualTo(Vehicle.ACCELERATION + " lt 6.0");
        assertThat(new PropertyCondition.Builder(Vehicle.DECELERATION).lt(7.0f).compile())
                .isEqualTo(Vehicle.DECELERATION + " lt 7.0");
    }

    @Test
    public void testBuilder_lte() {
        assertThat(new PropertyCondition.Builder(Vehicle.SPEED).lte(5).compile())
                .isEqualTo(Vehicle.SPEED + " lte 5");
        assertThat(new PropertyCondition.Builder(Vehicle.ACCELERATION).lte(6.0).compile())
                .isEqualTo(Vehicle.ACCELERATION + " lte 6.0");
        assertThat(new PropertyCondition.Builder(Vehicle.DECELERATION).lte(7.0f).compile())
                .isEqualTo(Vehicle.DECELERATION + " lte 7.0");
    }

    @Test
    public void testBuilder_contains() {
        assertThat(new PropertyCondition.Builder(Vehicle.SPEED).contains(5).compile())
                .isEqualTo(Vehicle.SPEED + " contains 5");
        assertThat(new PropertyCondition.Builder(Vehicle.ACCELERATION).contains(6.0).compile())
                .isEqualTo(Vehicle.ACCELERATION + " contains 6.0");
        assertThat(new PropertyCondition.Builder(Vehicle.DECELERATION).contains(7.0f).compile())
                .isEqualTo(Vehicle.DECELERATION + " contains 7.0");
        assertThat(new PropertyCondition.Builder(Vehicle.NAME).contains("CarryMcCarface").compile())
                .isEqualTo(Vehicle.NAME + " contains CarryMcCarface");
    }

    @Test
    public void testBuilder_unique() {
        PropertyCondition.Builder builder = new PropertyCondition.Builder(Vehicle.BATTERY);

        Condition conditionA = builder.gt(5.0);
        Condition conditionB = builder.gt(6.0);

        assertThat(conditionB).isNotSameAs(conditionA);
        assertThat(conditionA.compile()).isNotEqualTo(conditionB.compile());
    }

}