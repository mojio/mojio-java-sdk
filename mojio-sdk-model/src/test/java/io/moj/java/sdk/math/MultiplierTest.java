package io.moj.java.sdk.math;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by skidson on 2016-05-05.
 */
public class MultiplierTest {

    private static final float TOLERANCE = 0.00000001f;

    @Test
    public void testConvert() {
        Multiplier converter = new Multiplier(0.01f);
        assertThat(converter.convert(0)).isWithin(TOLERANCE).of(0f);
        assertThat(converter.convert(5)).isWithin(TOLERANCE).of(0.05f);
        assertThat(converter.convert(0.05f)).isWithin(TOLERANCE).of(0.0005f);
    }

}
