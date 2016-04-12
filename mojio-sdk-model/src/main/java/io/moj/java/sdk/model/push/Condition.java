package io.moj.java.sdk.model.push;

import com.google.gson.annotations.SerializedName;

import java.util.Locale;

/**
 * Used for specifying conditions for which an observer's behaviour should be limited.
 * Created by skidson on 16-02-16.
 */
public class Condition {

    /**
     * The format to be used for {@link #Delay} and {@link #Window} properties. For example
     * {@code String.format(Condition.TIME_FORMAT, days, hours, minnutes, seconds, milliseconds)}
     */
    public static final String TIME_FORMAT = "%d.%02d:%02d:%02d.%04d";

    public static final String PROPERTY = "Property";
    public static final String POSITION = "Position";
    public static final String MAX = "Max";
    public static final String MIN = "Min";
    public static final String TIME_PROPERTY = "TimeProperty";
    public static final String DELAY = "Delay";
    public static final String MIN_DATA_POINTS = "MinDataPoints";
    public static final String WINDOW = "Window";

    private transient Type type;

    // Shared
    private String Property;

    // Threshold
    private Position Position;
    private Double Max;
    private Double Min;

    // Debounce & Throttle
    private String TimeProperty;
    private String Delay;
    private Integer MinDataPoints;
    private String Window;

    public Condition() {}

    public Condition(Type type) {
        this.type = type;
    }

    public String getDelay() {
        return Delay;
    }

    public void setDelay(String delay) {
        Delay = delay;
    }

    public Double getMax() {
        return Max;
    }

    public void setMax(Double max) {
        Max = max;
    }

    public Double getMin() {
        return Min;
    }

    public void setMin(Double min) {
        Min = min;
    }

    public Integer getMinDataPoints() {
        return MinDataPoints;
    }

    public void setMinDataPoints(Integer minDataPoints) {
        MinDataPoints = minDataPoints;
    }

    public Condition.Position getPosition() {
        return Position;
    }

    public void setPosition(Condition.Position position) {
        Position = position;
    }

    public String getProperty() {
        return Property;
    }

    public void setProperty(String property) {
        Property = property;
    }

    public String getTimeProperty() {
        return TimeProperty;
    }

    public void setTimeProperty(String timeProperty) {
        TimeProperty = timeProperty;
    }

    public String getWindow() {
        return Window;
    }

    public void setWindow(String window) {
        Window = window;
    }

    protected Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "Delay='" + Delay + '\'' +
                ", type=" + type +
                ", Property='" + Property + '\'' +
                ", Position=" + Position +
                ", Max=" + Max +
                ", Min=" + Min +
                ", TimeProperty='" + TimeProperty + '\'' +
                ", MinDataPoints=" + MinDataPoints +
                ", Window='" + Window + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Condition condition = (Condition) o;

        if (Property != null ? !Property.equals(condition.Property) : condition.Property != null)
            return false;
        if (Position != condition.Position) return false;
        if (Max != null ? !Max.equals(condition.Max) : condition.Max != null) return false;
        if (Min != null ? !Min.equals(condition.Min) : condition.Min != null) return false;
        if (TimeProperty != null ? !TimeProperty.equals(condition.TimeProperty) : condition.TimeProperty != null)
            return false;
        if (Delay != null ? !Delay.equals(condition.Delay) : condition.Delay != null) return false;
        if (MinDataPoints != null ? !MinDataPoints.equals(condition.MinDataPoints) : condition.MinDataPoints != null)
            return false;
        return Window != null ? Window.equals(condition.Window) : condition.Window == null;

    }

    @Override
    public int hashCode() {
        int result = Property != null ? Property.hashCode() : 0;
        result = 31 * result + (Position != null ? Position.hashCode() : 0);
        result = 31 * result + (Max != null ? Max.hashCode() : 0);
        result = 31 * result + (Min != null ? Min.hashCode() : 0);
        result = 31 * result + (TimeProperty != null ? TimeProperty.hashCode() : 0);
        result = 31 * result + (Delay != null ? Delay.hashCode() : 0);
        result = 31 * result + (MinDataPoints != null ? MinDataPoints.hashCode() : 0);
        result = 31 * result + (Window != null ? Window.hashCode() : 0);
        return result;
    }

    /**
     * Limits the Observer to only broadcast when the specified property changes.
     * @param property the name of the property whose value must be changed on the entity being
     *                 observed. Note, only top-level properties are currently supported (e.g. on
     *                 a Vehicle observer "Location" is a valid property but not "Location.Lat".
     * @return
     */
    public static Condition onPropertyChanged(String property) {
        Condition c = new Condition(Type.PROPERTY_CHANGED);
        c.setProperty(property);
        return c;
    }

    /**
     * Limits the Observer to only broadcast when the specified property is {@link Position#ABOVE},
     * {@link Position#BELOW}, or {@link Position#BETWEEN} the given Min and Max.
     * @param property The property on the entity whose change in value is subject to this threshold
     * @param position defines how the Min and Max values are interpreted when deciding if the
     *                 observer will fire.
     * @param min The lower bound for this threshold. See {@link Position} for information on how
     *            this value is used.
     * @param max The upper bound for this threshold. See {@link Position} for information on how
     *            this value is used.
     * @see Position
     * @return
     */
    public static Condition onThreshold(String property, Position position, Double min, Double max) {
        Condition c = new Condition(Type.THRESHOLD);
        c.setProperty(property);
        c.setPosition(position);
        c.setMin(min);
        c.setMax(max);
        return c;
    }

    /**
     * Limits an observer to only broadcast when a certain number of data points have already
     * been received and/or the condition has been maintained for a certain amount of time.
     * @param minDataPoints the minimum number of times in a row the entity must satisfy all other
     *                      conditions before the observer will broadcast.
     * @param delay The amount of time that the condition must be maintained for before it can be
     *              broadcast. Delay is represented in JSON as a string of the format
     *              "0.00:00:00.0000" where "0.01:35:11.0000" Would be 1 hour 35 minutes and 11
     *              seconds. See {@link #TIME_FORMAT}.
     * @return
     * @see #TIME_FORMAT
     */
    public static Condition debounce(Integer minDataPoints, String delay) {
        Condition c = new Condition(Type.DEBOUNCE);
        c.setMinDataPoints(minDataPoints);
        c.setDelay(delay);
        return c;
    }

    /**
     * Limits an observer to only broadcast when a certain number of data points have already
     * been received and/or the condition has been maintained for a certain amount of time.
     * @param minDataPoints the minimum number of times in a row the entity must satisfy all other
     *                      conditions before the observer will broadcast.
     * @param days the number of days the condition must be maintained for before it can be
     *             broadcast. Added with the other time properties.
     * @param hours the number of horus the condition must be maintained for before it can be
     *              broadcast. Added with the other time properties.
     * @param minutes the number of minutes the condition must be maintained for before it can be
     *                broadcast. Added with the other time properties.
     * @param seconds the number of seconds the condition must be maintained for before it can be
     *                broadcast. Added with the other time properties.
     * @return
     */
    public static Condition debounce(Integer minDataPoints, int days, int hours, int minutes,
                                     int seconds) {
        return debounce(minDataPoints, formatDuration(days, hours, minutes, seconds));
    }

    /**
     * Limits an observer to only broadcast when a certain number of data points have already
     * been received.
     * @param minDataPoints the minimum number of times in a row the entity must satisfy all other
     *                      conditions before the observer will broadcast.
     * @return
     */
    public static Condition minDataPoints(Integer minDataPoints) {
        return debounce(minDataPoints, null);
    }

    /**
     * Limits an observer to only broadcast when the conditions have been maintained for a certain
     * amount of time.
     * @param delay The amount of time that the condition must be maintained for before it can be
     *              broadcast. Delay is represented in JSON as a string of the format
     *              "0.00:00:00.0000" where "0.01:35:11.0000" Would be 1 hour 35 minutes and 11
     *              seconds. See {@link #TIME_FORMAT}.
     * @return
     */
    public static Condition delay(String delay) {
        return debounce(null, delay);
    }

    /**
     * Limits an observer to only broadcast when the conditions have been maintained for a certain
     * amount of time.
     * @param days the number of days the condition must be maintained for before it can be
     *             broadcast. Added with the other time properties.
     * @param hours the number of horus the condition must be maintained for before it can be
     *              broadcast. Added with the other time properties.
     * @param minutes the number of minutes the condition must be maintained for before it can be
     *                broadcast. Added with the other time properties.
     * @param seconds the number of seconds the condition must be maintained for before it can be
     *                broadcast. Added with the other time properties.
     */
    public static Condition delay(int days, int hours, int minutes, int seconds) {
        return debounce(null, days, hours, minutes, seconds);
    }

    /**
     * Limits the observer to only broadcast if there has been a certain amount of time since the
     * last successful broadcast of the condition.
     * @param timeProperty The property to base the time off of. If nothing is specified this will
     *                     default to the current UTC time.
     * @param window The amount of time that must have passed before the Observer will broadcast
     *               again. Window is represented in JSON as a string of the format
     *               "0.00:00:00.0000" where "0.01:35:11.0000" Would be 1 hour 35 minutes and 11
     *               seconds.
     * @return
     */
    public static Condition throttle(String timeProperty, String window) {
        Condition c = new Condition(Type.THROTTLE);
        c.setTimeProperty(timeProperty);
        c.setWindow(window);
        return c;
    }

    /**
     * Limits the observer to only broadcast if there has been a certain amount of time since the
     * last successful broadcast of the condition.
     * @param timeProperty The property to base the time off of. If nothing is specified this will
     *                     default to the current UTC time.
     * @param days the number of days that must have passed before the Observer will broadcast
     *             again. Added with the other time properties.
     * @param hours the number of hours that must have passed before the Observer will broadcast
     *             again. Added with the other time properties.
     * @param minutes the number of minutes that must have passed before the Observer will broadcast
     *             again. Added with the other time properties.
     * @param seconds the number of seconds that must have passed before the Observer will broadcast
     *             again. Added with the other time properties.
     * @return
     */
    public static Condition throttle(String timeProperty, int days, int hours, int minutes, int seconds) {
        return throttle(timeProperty, formatDuration(days, hours, minutes, seconds));
    }

    /**
     * Limits the observer to only broadcast if there has been a certain amount of time since the
     * last successful broadcast of the condition.
     * @param days the number of days that must have passed before the Observer will broadcast
     *             again. Added with the other time properties.
     * @param hours the number of hours that must have passed before the Observer will broadcast
     *             again. Added with the other time properties.
     * @param minutes the number of minutes that must have passed before the Observer will broadcast
     *             again. Added with the other time properties.
     * @param seconds the number of seconds that must have passed before the Observer will broadcast
     *             again. Added with the other time properties.
     * @return
     */
    public static Condition throttle(int days, int hours, int minutes, int seconds) {
        return throttle(null, days, hours, minutes, seconds);
    }

    private static String formatDuration(int days, int hours, int minutes, int seconds) {
        return String.format(Locale.US, TIME_FORMAT, days, hours, minutes, seconds, 0);
    }

    public enum Type {
        /**
         * Limits the Observer to only broadcast when the specified property changes.
         */
        @SerializedName("PropertyChanged")
        PROPERTY_CHANGED("PropertyChanged"),

        /**
         * Limits the Observer to only broadcast when the specified property is above, below, or
         * between the given Min and Max.
         */
        @SerializedName("Threshold")
        THRESHOLD("Threshold"),

        /**
         * Limits an observer to only broadcast when a certain number of data points have already
         * been received and/or the condition has been maintained for a certain amount of time.
         */
        @SerializedName("Debounce")
        DEBOUNCE("Debounce"),

        /**
         * Limits the observer to only broadcast if there has been a certain amount of time since
         * the last successful broadcast of the condition. All changes during the window will be
         * ignored.
         */
        @SerializedName("Throttle")
        THROTTLE("Throttle");

        private final String key;

        Type(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public static Type fromKey(String key) {
            for (Type type : values()) {
                if (type.getKey().equals(key))
                    return type;
            }
            return null;
        }
    }

    public enum Position {
        /**
         * Checks if the current value is greater than the Max value, if Max is not provided will
         * check the Min.
         */
        @SerializedName("Above")
        ABOVE("Above"),

        /**
         * Checks if the current value is less than the Min value, if Min is not provided will check
         * the Max.
         */
        @SerializedName("Below")
        BELOW("Below"),

        /**
         * Checks if the current value is less between the Max and the Min value.
         */
        @SerializedName("Between")
        BETWEEN("Between");

        private final String key;

        Position(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public static Position fromKey(String key) {
            for (Position position : values()) {
                if (position.getKey().equals(key))
                    return position;
            }
            return null;
        }
    }
}
