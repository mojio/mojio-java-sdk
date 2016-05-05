package io.moj.java.sdk.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Static utilities for converting to and from server-based datetime formats.
 * Created by skidson on 2016-05-05.
 */
public final class DateUtils {

    private static final Pattern PATTERN_DURATION = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})\\.(\\d+)");
    private static final long MIN_PER_HOUR = 60;
    private static final long SEC_PER_MIN = 60;
    private static final long MS_PER_SEC = 1000;

    private DateUtils() {}

    public long fromDuration(String duration) {
        long ms = 0;

        Matcher matcher = PATTERN_DURATION.matcher(duration);
        String hours = matcher.group(1);
        if (hours != null) {
            ms += Integer.parseInt(hours) * MIN_PER_HOUR * SEC_PER_MIN * MS_PER_SEC;
        }

        String minutes = matcher.group(2);
        if (minutes != null) {
            ms += Integer.parseInt(minutes) * SEC_PER_MIN * MS_PER_SEC;
        }

        String seconds = matcher.group(3);
        if (seconds != null) {
            ms += Integer.parseInt(seconds) * MS_PER_SEC;
        }

        String fraction = matcher.group(4);
        if (fraction != null) {
            int multiplier = 100;
            for (int i = 0; i < fraction.length(); i++) {
                ms += Character.getNumericValue(fraction.charAt(i)) * multiplier;
                multiplier /= 10;
            }
        }

        return ms;
    }

}
