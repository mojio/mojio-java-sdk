package io.moj.java.sdk.model.push;

import com.google.common.testing.EqualsTester;
import com.google.gson.Gson;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static junit.framework.Assert.*;

public class ConditionTest {

    /* PropertyChanged Tests - Tests for the various different builder methods for PropertyChanged conditions  */
    @Test
    public void testOnPropertyChanged() {
        String property = "Speed.Value";
        Condition c = Condition.onPropertyChanged(property);
        assertEquals(Condition.Type.PROPERTY_CHANGED, c.getType());
        assertEquals(property, c.getProperty());
    }

    @Test
    public void testOnThreshold() {
        String property = "Speed.Value";
        Condition.Position position = Condition.Position.ABOVE;
        double min = 0;
        double max = 123.456;

        Condition c = Condition.onThreshold(property, position, min, max);
        assertEquals(Condition.Type.THRESHOLD, c.getType());
        assertEquals(min, c.getMin());
        assertEquals(max, c.getMax());
    }

    /* Debounce Tests - Tests for the various different builder methods for Debounce conditions  */
    @Test
    public void testDebounce() {
        int minDataPoints = 4;
        String delay = "0.19:20:34.0000";

        Condition c = Condition.debounce(minDataPoints, delay);
        assertEquals(Condition.Type.DEBOUNCE, c.getType());
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

        Condition c = Condition.debounce(minDataPoints, days, hours, minutes, seconds);
        assertEquals(Condition.Type.DEBOUNCE, c.getType());
        assertEquals(minDataPoints, (int) c.getMinDataPoints());
        assertEquals(expectedDelay, c.getDelay());
    }

    @Test
    public void testMinDataPoints() {
        int minDataPoints = 1337;

        Condition c = Condition.minDataPoints(minDataPoints);
        assertEquals(Condition.Type.DEBOUNCE, c.getType());
        assertEquals(minDataPoints, (int) c.getMinDataPoints());
        assertNull(c.getDelay());
    }

    @Test
    public void testDelay_string() {
        String delay = "0.05:00:00.0000";

        Condition c = Condition.delay(delay);
        assertEquals(Condition.Type.DEBOUNCE, c.getType());
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

        Condition c = Condition.delay(days, hours, minutes, seconds);
        assertEquals(Condition.Type.DEBOUNCE, c.getType());
        assertEquals(expectedDelay, c.getDelay());
        assertNull(c.getMinDataPoints());
    }

    /* Throttle Tests - Tests for the various different builder methods for Throttle conditions  */
    @Test
    public void testThrottle_timeProperty_window_strings() {
        String timeProperty = "LastContactTime";
        String window = "0.06:00:00.1234";

        Condition c = Condition.throttle(timeProperty, window);
        assertEquals(Condition.Type.THROTTLE, c.getType());
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

        Condition c = Condition.throttle(timeProperty, days, hours, minutes, seconds);
        assertEquals(Condition.Type.THROTTLE, c.getType());
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

        Condition c = Condition.throttle(days, hours, minutes, seconds);
        assertEquals(Condition.Type.THROTTLE, c.getType());
        assertEquals(expectedWindow, c.getWindow());
        assertNull(c.getTimeProperty());
    }

    @Test
    public void testTypeFromKey() {
        for (Condition.Type type : Condition.Type.values()) {
            Condition.Type typeFromKey = Condition.Type.fromKey(type.getKey());
            assertEquals(type, typeFromKey);
        }
        assertNull(Condition.Type.fromKey("NotARealKey"));
    }

    @Test
    public void testPositionFromKey() {
        for (Condition.Position position : Condition.Position.values()) {
            Condition.Position positionFromKey = Condition.Position.fromKey(position.getKey());
            assertEquals(position, positionFromKey);
        }
        assertNull(Condition.Position.fromKey("NotARealKey"));
    }

    @Test
    public void testEquality() throws IllegalAccessException {
        Condition c1 = buildTestCondition();
        Condition c2 = buildTestCondition();
        new EqualsTester().addEqualityGroup(c1, c2).testEquals();

        for (Method method : Condition.class.getMethods()) {
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
        Condition condition = new Gson().fromJson(TestJson.CONDITION, Condition.class);

        assertNotNull(condition);
        assertEquals("window", condition.getWindow());
        assertEquals("timeProperty", condition.getTimeProperty());
        assertEquals("delay", condition.getDelay());
        assertEquals(4, (int) condition.getMinDataPoints());
        assertEquals(120d, condition.getMin());
        assertEquals(200d, condition.getMax());
        assertEquals(Condition.Position.ABOVE, condition.getPosition());
        assertEquals("property", condition.getProperty());

        new EqualsTester().addEqualityGroup(condition, buildTestCondition()).testEquals();
    }

    private static Condition buildTestCondition() {
        Condition condition = new Condition();
        condition.setWindow("window");
        condition.setTimeProperty("timeProperty");
        condition.setDelay("delay");
        condition.setMinDataPoints(4);
        condition.setMin(120d);
        condition.setMax(200d);
        condition.setPosition(Condition.Position.ABOVE);
        condition.setProperty("property");
        return condition;
    }

}