package io.moj.java.sdk.model.push;

import com.google.common.testing.EqualsTester;
import com.google.gson.Gson;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static junit.framework.Assert.*;

public class OldConditionTest {

    /* PropertyChanged Tests - Tests for the various different builder methods for PropertyChanged conditions  */
    @Test
    public void testOnPropertyChanged() {
        String property = "Speed.Value";
        OldCondition c = OldCondition.onPropertyChanged(property);
        assertEquals(OldCondition.Type.PROPERTY_CHANGED, c.getType());
        assertEquals(property, c.getProperty());
    }

    @Test
    public void testOnThreshold() {
        String property = "Speed.Value";
        OldCondition.Position position = OldCondition.Position.ABOVE;
        double min = 0;
        double max = 123.456;

        OldCondition c = OldCondition.onThreshold(property, position, min, max);
        assertEquals(OldCondition.Type.THRESHOLD, c.getType());
        assertEquals(min, c.getMin());
        assertEquals(max, c.getMax());
    }

    /* Debounce Tests - Tests for the various different builder methods for Debounce conditions  */
    @Test
    public void testDebounce() {
        int minDataPoints = 4;
        String delay = "0.19:20:34.0000";

        OldCondition c = OldCondition.debounce(minDataPoints, delay);
        assertEquals(OldCondition.Type.DEBOUNCE, c.getType());
        assertEquals(minDataPoints, (int) c.getMinDataPoints());
        assertEquals(delay, c.getDelay());
    }

    @Test
    public void testDebounce_ints() {
        int minDataPoints = 5;
        int days = 0;
        int hours = 4;
        int minutes = 20;
        int seconds = 0;
        String expectedDelay = "0.04:20:00.0000";

        OldCondition c = OldCondition.debounce(minDataPoints, days, hours, minutes, seconds);
        assertEquals(OldCondition.Type.DEBOUNCE, c.getType());
        assertEquals(minDataPoints, (int) c.getMinDataPoints());
        assertEquals(expectedDelay, c.getDelay());
    }

    @Test
    public void testMinDataPoints() {
        int minDataPoints = 1337;

        OldCondition c = OldCondition.minDataPoints(minDataPoints);
        assertEquals(OldCondition.Type.DEBOUNCE, c.getType());
        assertEquals(minDataPoints, (int) c.getMinDataPoints());
        assertNull(c.getDelay());
    }

    @Test
    public void testDelay_string() {
        String delay = "0.05:00:00.0000";

        OldCondition c = OldCondition.delay(delay);
        assertEquals(OldCondition.Type.DEBOUNCE, c.getType());
        assertEquals(delay, c.getDelay());
        assertNull(c.getMinDataPoints());
    }

    @Test
    public void testDelay_ints() {
        int days = 2;
        int hours = 0;
        int minutes = 4;
        int seconds = 42;
        String expectedDelay = "2.00:04:42.0000";

        OldCondition c = OldCondition.delay(days, hours, minutes, seconds);
        assertEquals(OldCondition.Type.DEBOUNCE, c.getType());
        assertEquals(expectedDelay, c.getDelay());
        assertNull(c.getMinDataPoints());
    }

    /* Throttle Tests - Tests for the various different builder methods for Throttle conditions  */
    @Test
    public void testThrottle_timeProperty_window_strings() {
        String timeProperty = "LastContactTime";
        String window = "0.06:00:00.1234";

        OldCondition c = OldCondition.throttle(timeProperty, window);
        assertEquals(OldCondition.Type.THROTTLE, c.getType());
        assertEquals(timeProperty, c.getTimeProperty());
        assertEquals(window, c.getWindow());
    }

    @Test
    public void testThrottle_timeProperty_window_ints() {
        String timeProperty = "LastContactTime";
        int days = 1;
        int hours = 2;
        int minutes = 3;
        int seconds = 4;
        String expectedWindow = "1.02:03:04.0000";

        OldCondition c = OldCondition.throttle(timeProperty, days, hours, minutes, seconds);
        assertEquals(OldCondition.Type.THROTTLE, c.getType());
        assertEquals(timeProperty, c.getTimeProperty());
        assertEquals(expectedWindow, c.getWindow());
    }

    @Test
    public void testThrottle_window_ints() {
        int days = 1;
        int hours = 2;
        int minutes = 3;
        int seconds = 4;
        String expectedWindow = "1.02:03:04.0000";

        OldCondition c = OldCondition.throttle(days, hours, minutes, seconds);
        assertEquals(OldCondition.Type.THROTTLE, c.getType());
        assertEquals(expectedWindow, c.getWindow());
        assertNull(c.getTimeProperty());
    }

    @Test
    public void testTypeFromKey() {
        for (OldCondition.Type type : OldCondition.Type.values()) {
            OldCondition.Type typeFromKey = OldCondition.Type.fromKey(type.getKey());
            assertEquals(type, typeFromKey);
        }
        assertNull(OldCondition.Type.fromKey("NotARealKey"));
    }

    @Test
    public void testPositionFromKey() {
        for (OldCondition.Position position : OldCondition.Position.values()) {
            OldCondition.Position positionFromKey = OldCondition.Position.fromKey(position.getKey());
            assertEquals(position, positionFromKey);
        }
        assertNull(OldCondition.Position.fromKey("NotARealKey"));
    }

    @Test
    public void testEquality() throws IllegalAccessException {
        OldCondition c1 = buildTestCondition();
        OldCondition c2 = buildTestCondition();
        new EqualsTester().addEqualityGroup(c1, c2).testEquals();

        for (Method method : OldCondition.class.getMethods()) {
            c2 = buildTestCondition();
            if (method.getName().startsWith("set")) {
                try {
                    Class argType = method.getParameterTypes()[0];
                    method.invoke(c2, argType.isPrimitive() ? 4 : argType.newInstance());
                    assertFalse("Equality did not change after invoking " + method.getName() + "()", c1.equals(c2));
                    assertFalse("Hash code did not change after invoking " + method.getName() + "()", c1.hashCode() == c2.hashCode());

                    if (!argType.isPrimitive()) {
                        method.invoke(c2, new Object[] { null } );
                        assertFalse("Equality did not change after modifying " + method.getName() + "()", c1.equals(c2));
                        assertFalse("Hash code did not change after modifying " + method.getName() + "()", c1.hashCode() == c2.hashCode());
                    }
                } catch (IllegalArgumentException | InvocationTargetException | InstantiationException e) {
                    System.err.println("Could not invoke " + method.getName() + "(): " + e.getMessage());
                }
            }
        }
    }

    @Test
    public void testSerialization() {
        String json = new Gson().toJson(buildTestCondition());
        assertEquals(TestJson.CONDITION, json);
    }

    @Test
    public void testDeserialization() {
        OldCondition condition = new Gson().fromJson(TestJson.CONDITION, OldCondition.class);

        assertNotNull(condition);
        assertEquals("window", condition.getWindow());
        assertEquals("timeProperty", condition.getTimeProperty());
        assertEquals("delay", condition.getDelay());
        assertEquals(4, (int) condition.getMinDataPoints());
        assertEquals(120d, condition.getMin());
        assertEquals(200d, condition.getMax());
        assertEquals(OldCondition.Position.ABOVE, condition.getPosition());
        assertEquals("property", condition.getProperty());

        new EqualsTester().addEqualityGroup(condition, buildTestCondition()).testEquals();
    }

    private static OldCondition buildTestCondition() {
        OldCondition condition = new OldCondition();
        condition.setWindow("window");
        condition.setTimeProperty("timeProperty");
        condition.setDelay("delay");
        condition.setMinDataPoints(4);
        condition.setMin(120d);
        condition.setMax(200d);
        condition.setPosition(OldCondition.Position.ABOVE);
        condition.setProperty("property");
        return condition;
    }

}