package io.moj.java.sdk.model.push;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by skidson on 2016-05-23.
 */
public class BracedConditionTest {

    @Test
    public void testCompile() {
        Condition mockCondition = mock(Condition.class);
        when(mockCondition.compile()).thenReturn("test");
        assertThat(new BracedCondition(mockCondition).compile()).isEqualTo("(test)");
    }

}
