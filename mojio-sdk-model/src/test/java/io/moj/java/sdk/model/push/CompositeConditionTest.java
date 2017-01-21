package io.moj.java.sdk.model.push;

import io.moj.java.sdk.model.Mojio;
import io.moj.java.sdk.model.Vehicle;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by skidson on 2016-05-23.
 */
public class CompositeConditionTest {

    @Test
    public void testCompile() {
        Condition left = mock(Condition.class);
        when(left.compile()).thenReturn("left");

        Condition right = mock(Condition.class);
        when(right.compile()).thenReturn("right");

        assertThat(new CompositeCondition(left, right, CompositeCondition.Operator.AND).compile())
                .isEqualTo("left and right");

        assertThat(new CompositeCondition(left, right, CompositeCondition.Operator.OR).compile())
                .isEqualTo("left or right");
    }

    @Test
    public void testBuilder() {
        Condition left = mock(Condition.class);
        when(left.compile()).thenReturn("left");

        String expectedValue = "expectedValue";
        assertThat(new CompositeCondition.Builder(left, CompositeCondition.Operator.AND, Mojio.NAME)
                .eq(expectedValue).compile()).isEqualTo("left and " + Mojio.NAME + " eq " + expectedValue);

        assertThat(new CompositeCondition.Builder(left, CompositeCondition.Operator.OR, Vehicle.MOJIO_ID)
                .eq(expectedValue).compile()).isEqualTo("left or " +Vehicle.MOJIO_ID + " eq " + expectedValue);
    }

    @Test
    public void testBuilder_unique() {
        Condition left = mock(Condition.class);
        when(left.compile()).thenReturn("left");

        CompositeCondition.Builder builder = new CompositeCondition.Builder(left, CompositeCondition.Operator.AND, Vehicle.IGNITION_STATE);

        Condition conditionA = builder.eq(false);
        Condition conditionB = builder.eq(false);

        assertThat(conditionB).isNotSameAs(conditionA);
        assertThat(conditionA.compile()).isEqualTo(conditionB.compile());
    }

}
