package io.moj.java.sdk.utils;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by skidson on 2016-05-10.
 */
public class TimeUtilsTest {

    private static final long DAYS_TO_MS = 86400000;
    private static final long HOURS_TO_MS = 3600000;
    private static final long MINUTES_TO_MS = 60000;
    private static final long SECONDS_TO_MS = 1000;

    @Test
    public void testConvertTimespanToMillis() {
        assertThat(TimeUtils.convertTimespanToMillis("00.00:00:00.0000000")).isEqualTo(0);

        assertThat(TimeUtils.convertTimespanToMillis("01.00:00:00.0000000")).isEqualTo(DAYS_TO_MS);
        assertThat(TimeUtils.convertTimespanToMillis("00.01:00:00.0000000")).isEqualTo(HOURS_TO_MS);
        assertThat(TimeUtils.convertTimespanToMillis("00.00:01:00.0000000")).isEqualTo(MINUTES_TO_MS);
        assertThat(TimeUtils.convertTimespanToMillis("00.00:00:01.0000000")).isEqualTo(SECONDS_TO_MS);
        assertThat(TimeUtils.convertTimespanToMillis("00.00:00:00.1000000")).isEqualTo(100);
        assertThat(TimeUtils.convertTimespanToMillis("00.00:00:00.0100000")).isEqualTo(10);
        assertThat(TimeUtils.convertTimespanToMillis("00.00:00:00.0010000")).isEqualTo(1);
        assertThat(TimeUtils.convertTimespanToMillis("00.00:00:00.0001000")).isEqualTo(0);

        assertThat(TimeUtils.convertTimespanToMillis("01.02:03:04.5670000")).isEqualTo(
                DAYS_TO_MS +
                HOURS_TO_MS * 2 +
                MINUTES_TO_MS * 3 +
                SECONDS_TO_MS * 4 +
                567
        );
    }

    @Test
    public void testConvertTimespanToMillis_noDays() {
        assertThat(TimeUtils.convertTimespanToMillis("00:00:00.0000000")).isEqualTo(0);

        assertThat(TimeUtils.convertTimespanToMillis("01:00:00.0000000")).isEqualTo(HOURS_TO_MS);
        assertThat(TimeUtils.convertTimespanToMillis("00:01:00.0000000")).isEqualTo(MINUTES_TO_MS);
        assertThat(TimeUtils.convertTimespanToMillis("00:00:01.0000000")).isEqualTo(SECONDS_TO_MS);
        assertThat(TimeUtils.convertTimespanToMillis("00:00:00.1000000")).isEqualTo(100);
        assertThat(TimeUtils.convertTimespanToMillis("00:00:00.0100000")).isEqualTo(10);
        assertThat(TimeUtils.convertTimespanToMillis("00:00:00.0010000")).isEqualTo(1);
        assertThat(TimeUtils.convertTimespanToMillis("00:00:00.0001000")).isEqualTo(0);

        assertThat(TimeUtils.convertTimespanToMillis("02:03:04.5670000")).isEqualTo(
                        HOURS_TO_MS * 2 +
                        MINUTES_TO_MS * 3 +
                        SECONDS_TO_MS * 4 +
                        567
        );
    }

    /**
     * Assert a timespan is still parseable even if milliseconds are not included.
     */
    @Test
    public void testConvertTimespanToMillis_noMillis() {
        assertThat(TimeUtils.convertTimespanToMillis("00:00:00")).isEqualTo(0);

        assertThat(TimeUtils.convertTimespanToMillis("01:00:00")).isEqualTo(HOURS_TO_MS);
        assertThat(TimeUtils.convertTimespanToMillis("00:01:00")).isEqualTo(MINUTES_TO_MS);
        assertThat(TimeUtils.convertTimespanToMillis("00:00:01")).isEqualTo(SECONDS_TO_MS);

        assertThat(TimeUtils.convertTimespanToMillis("02:03:04")).isEqualTo(
                HOURS_TO_MS * 2 +
                MINUTES_TO_MS * 3 +
                SECONDS_TO_MS * 4
        );
    }

    @Test
    public void testConvertTimespanToMillis_null() {
        assertThat(TimeUtils.convertTimespanToMillis(null)).isNull();
    }

    @Test
    public void testConvertTimespanToMillis_empty() {
        assertThat(TimeUtils.convertTimespanToMillis("")).isNull();
    }

    @Test
    public void testConvertMillisToTimespan() {
        assertThat(TimeUtils.convertMillisToTimespan(0L)).isEqualTo("00.00:00:00.0000000");

        assertThat(TimeUtils.convertMillisToTimespan(DAYS_TO_MS)).isEqualTo("01.00:00:00.0000000");
        assertThat(TimeUtils.convertMillisToTimespan(HOURS_TO_MS)).isEqualTo("00.01:00:00.0000000");
        assertThat(TimeUtils.convertMillisToTimespan(MINUTES_TO_MS)).isEqualTo("00.00:01:00.0000000");
        assertThat(TimeUtils.convertMillisToTimespan(SECONDS_TO_MS)).isEqualTo("00.00:00:01.0000000");
        assertThat(TimeUtils.convertMillisToTimespan(100L)).isEqualTo("00.00:00:00.1000000");
        assertThat(TimeUtils.convertMillisToTimespan(10L)).isEqualTo("00.00:00:00.0100000");
        assertThat(TimeUtils.convertMillisToTimespan(1L)).isEqualTo("00.00:00:00.0010000");

        assertThat(TimeUtils.convertTimespanToMillis("01.02:03:04.5670000"))
                .isEqualTo(DAYS_TO_MS + (HOURS_TO_MS * 2) + (MINUTES_TO_MS * 3) + (SECONDS_TO_MS * 4) + 567);
    }

    @Test
    public void testConvertMillisToTimespan_negative() {
        assertThat(TimeUtils.convertMillisToTimespan(-123L)).isEqualTo("00.00:00:00.1230000");
    }

    @Test
    public void testConvertTimestampToMillis() {
        assertThat(TimeUtils.convertTimestampToMillis("1970-01-01T00:00:00.000Z")).isEqualTo(0L);
        assertThat(TimeUtils.convertTimestampToMillis("2016-03-19T00:35:16.264Z")).isEqualTo(1458347716264L);
    }

    @Test
    public void testConvertTimestampToMillis_noMillis() {
        assertThat(TimeUtils.convertTimestampToMillis("1970-01-01T00:00:00Z")).isEqualTo(0L);
        assertThat(TimeUtils.convertTimestampToMillis("2016-03-19T00:35:16Z")).isEqualTo(1458347716000L);
    }

    @Test
    public void testConvertTimestampToMillis_noMillis_invalidSuffix() {
        assertThat(TimeUtils.convertTimestampToMillis("2016-03-19T00:35:16+00:00")).isEqualTo(1458347716000L);
        assertThat(TimeUtils.convertTimestampToMillis("2016-03-19T00:35:16.0+00:00")).isEqualTo(1458347716000L);
    }

    @Test
    public void testConvertTimestampToMillis_null() {
        assertThat(TimeUtils.convertTimestampToMillis(null)).isNull();
    }

    @Test
    public void testConvertTimestampToMillis_empty() {
        assertThat(TimeUtils.convertTimestampToMillis("")).isNull();
    }

    @Test
    public void testConvertMillisToTimestamp() {
        assertThat(TimeUtils.convertMillisToTimestamp(0L)).isEqualTo("1970-01-01T00:00:00.000Z");
        assertThat(TimeUtils.convertMillisToTimestamp(1458347716264L)).isEqualTo("2016-03-19T00:35:16.264Z");
    }

    @Test
    public void testPrecision_extraDecimalPlaces() {
        String expectedTimestamp = "2016-07-01T19:00:48.986Z";
        String actualTimestamp = "2016-07-01T19:00:48.9867879Z";
        long millis = 1467399648986L;
        assertThat(TimeUtils.convertTimestampToMillis(actualTimestamp)).isEqualTo(millis);
        assertThat(TimeUtils.convertMillisToTimestamp(millis)).startsWith(expectedTimestamp);
    }

    @Test
    public void testPrecision_missingDecimalPlaces() {
        assertThat(TimeUtils.convertTimestampToMillis("2016-07-01T19:00:48.98Z")).isEqualTo(1467399648980L);
        assertThat(TimeUtils.convertTimestampToMillis("2016-07-01T19:00:48.9Z")).isEqualTo(1467399648900L);
        assertThat(TimeUtils.convertTimestampToMillis("2016-07-01T19:00:48.Z")).isEqualTo(1467399648000L);
        assertThat(TimeUtils.convertTimestampToMillis("2016-07-01T19:00:48Z")).isEqualTo(1467399648000L);
    }

}
