package io.moj.java.sdk.model.push;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by skidson on 2016-05-24.
 */
public class RawConditionTest {

    @Test
    public void testCompile() {
        String expectedCondition = "expectedCondition";
        RawCondition condition = new RawCondition(expectedCondition);
        assertThat(condition.compile()).isEqualTo(expectedCondition);
    }

}
