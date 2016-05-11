package io.moj.java.sdk.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Static utilities for converting to and from server-based datetime formats.
 * Created by skidson on 2016-05-05.
 */
public final class TimeUtils {

    private static final String FORMAT_TIMESPAN = "%02d.%02d:%02d:%02d.%s";
    private static final Pattern PATTERN_TIMESPAN = Pattern.compile("(\\d+)?\\.?(\\d{2}):(\\d{2}):(\\d{2})\\.(\\d+)");
    private static final ThreadLocal<DateFormat> DATE_FORMAT = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return dateFormat;
        }
    };

    private static final int GROUP_DAYS = 1;
    private static final int GROUP_HOURS = 2;
    private static final int GROUP_MINS = 3;
    private static final int GROUP_SECS = 4;
    private static final int GROUP_MS = 5;

    private static final long HOUR_PER_DAY = 24;
    private static final long MIN_PER_HOUR = 60;
    private static final long SEC_PER_MIN = 60;
    private static final long MS_PER_SEC = 1000;

    private TimeUtils() {}

    /**
     * Formats an ASP.NET TimeSpan into a long representing the number of milliseconds.
     * @param duration
     * @return
     * @see <a href="https://msdn.microsoft.com/en-us/library/ee372286(v=vs.110).aspx">
     *     https://msdn.microsoft.com/en-us/library/ee372286(v=vs.110).aspx</a>
     */
    public static Long convertTimespanToMillis(String duration) {
        if (duration == null || duration.length() == 0)
            return null;

        long ms = 0;
        Matcher matcher = PATTERN_TIMESPAN.matcher(duration);
        if (!matcher.matches())
            return ms;

        String days = matcher.group(GROUP_DAYS);
        if (days != null) {
            ms += Integer.parseInt(days) * HOUR_PER_DAY * MIN_PER_HOUR * SEC_PER_MIN * MS_PER_SEC;
        }

        String hours = matcher.group(GROUP_HOURS);
        if (hours != null) {
            ms += Integer.parseInt(hours) * MIN_PER_HOUR * SEC_PER_MIN * MS_PER_SEC;
        }

        String minutes = matcher.group(GROUP_MINS);
        if (minutes != null) {
            ms += Integer.parseInt(minutes) * SEC_PER_MIN * MS_PER_SEC;
        }

        String seconds = matcher.group(GROUP_SECS);
        if (seconds != null) {
            ms += Integer.parseInt(seconds) * MS_PER_SEC;
        }

        String fraction = matcher.group(GROUP_MS);
        if (fraction != null) {
            int multiplier = 100;
            for (int i = 0; i < fraction.length() && multiplier > 0; i++) {
                ms += Character.getNumericValue(fraction.charAt(i)) * multiplier;
                multiplier /= 10;
            }
        }

        return ms;
    }

    /**
     * Formats a long representing a number of milliseconds to an ASP.NET TimeSpan in "General long format".
     * @param ms
     * @return
     * @see <a href="https://msdn.microsoft.com/en-us/library/ee372286(v=vs.110).aspx">
     *     https://msdn.microsoft.com/en-us/library/ee372286(v=vs.110).aspx</a>
     */
    public static String convertMillisToTimespan(Long ms) {
        if (ms == null)
            return null;

        ms = Math.abs(ms);

        long days = ms / (HOUR_PER_DAY * MIN_PER_HOUR * SEC_PER_MIN * MS_PER_SEC);
        ms -= days * (HOUR_PER_DAY * MIN_PER_HOUR * SEC_PER_MIN * MS_PER_SEC);

        long hours = ms / (MIN_PER_HOUR * SEC_PER_MIN * MS_PER_SEC);
        ms -= hours * (MIN_PER_HOUR * SEC_PER_MIN * MS_PER_SEC);

        long minutes = ms / (SEC_PER_MIN * MS_PER_SEC);
        ms -= minutes * (SEC_PER_MIN * MS_PER_SEC);

        long seconds = ms / MS_PER_SEC;
        ms -= seconds * MS_PER_SEC;

        StringBuilder formattedMs = new StringBuilder();
        int divisor = 100;
        while (divisor > 0) {
            long digit = ms / divisor;
            formattedMs.append(digit);
            ms -= digit * divisor;
            divisor /= 10;
        }
        formattedMs.append("0000");

        return String.format(Locale.US, FORMAT_TIMESPAN, days, hours, minutes, seconds, formattedMs.toString())
                .replace(' ', '0');
    }

    /**
     * Converts an ISO-8601 timestamp to a long representing the number of milliseconds since epoch. This implementation
     * assumes timezone is always UTC.
     * @param timestamp
     * @return
     */
    public static Long convertTimestampToMillis(String timestamp) {
        if (timestamp == null || timestamp.length() == 0)
            return null;

        timestamp = timestamp.replaceFirst("\\+.*", "Z");

        try {
            return DATE_FORMAT.get().parse(timestamp).getTime();
        } catch (ParseException e) {
            return 0L;
        }
    }

    /**
     * Formats a long representing the number of milliseconds since epoch into an ISO-8601 UTC timestamp.
     * @param timestamp
     * @return
     */
    public static String convertMillisToTimestamp(Long timestamp) {
        if (timestamp == null)
            return null;

        return DATE_FORMAT.get().format(new Date(timestamp));
    }

}
