package io.moj.java.sdk.math;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by skidson on 2016-05-05.
 */
public class DividerTest {

    private static final float TOLERANCE = 0.0000001f;

    @Test
    public void testConvert() {
        Divider converter = new Divider(0.01f);
        assertThat(converter.convert(0)).isWithin(TOLERANCE).of(0f);
        assertThat(converter.convert(5)).isWithin(TOLERANCE).of(0.002f);
        assertThat(converter.convert(0.05f)).isWithin(TOLERANCE).of(0.2f);
    }

}
