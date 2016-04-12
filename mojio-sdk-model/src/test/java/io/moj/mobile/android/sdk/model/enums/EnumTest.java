package io.moj.mobile.android.sdk.model.enums;

import com.google.gson.Gson;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Abstract class to make testing enums easier. Tests using this structure should provide an
 * implementation for the {@link #getMapping()} method and override all test* methods to call super
 * and annotate them with @Test.
 * methods and annotate them with @Test
 * Created by skidson on 16-02-23.
 */
public abstract class EnumTest<T> {

    /**
     * Subclasses should implement this to return a map of expected JSON values to Enums.
     * @return
     */
    public abstract Map<String, T> getMapping();

    public void testSerialization() {
        Gson gson = new Gson();
        Map<String, T> mapping = getMapping();
        for (String key : mapping.keySet()) {
            String json = gson.toJson(mapping.get(key));
            assertEquals(quote(key), json);
        }
    }

    @SuppressWarnings("unchecked")
    public void testDeserialization() {
        Gson gson = new Gson();
        Map<String, T> mapping = getMapping();
        for (String key : mapping.keySet()) {
            T expected = mapping.get(key);
            T deserialized = (T) gson.fromJson(quote(key), expected.getClass());
            assertEquals(expected, deserialized);
        }
    }

    @SuppressWarnings("unchecked")
    public void testFromKey() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map<String, T> mapping = getMapping();
        for (String key : mapping.keySet()) {
            T expected = mapping.get(key);
            Method fromKeyMethod = expected.getClass().getMethod("fromKey", String.class);
            T fromKey = (T) fromKeyMethod.invoke(null, key);
            assertEquals(expected, fromKey);
        }
    }

    public void testFromKey_invalid() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method fromKeyMethod = getMapping().values().iterator().next().getClass().getMethod("fromKey", String.class);
        assertNull(fromKeyMethod.invoke(null, "NotARealKey"));
    }

    @SuppressWarnings("unchecked")
    public void testGetKey() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map<String, T> mapping = getMapping();
        for (String key : mapping.keySet()) {
            T value = mapping.get(key);
            Method getKeyMethod = value.getClass().getMethod("getKey");
            String gotKey = (String) getKeyMethod.invoke(value);
            assertEquals(key, gotKey);
        }
    }

    @SuppressWarnings("unchecked")
    public void testValues() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // ensure we are testing all expected values of the enum (this test will break if we add
        // or remove a value without updating getMapping())
        Map<String, T> mapping = getMapping();
        Method valuesMethod = getEnumClass().getMethod("values");
        T[] values = (T[]) valuesMethod.invoke(null);
        assertThat(mapping.values()).containsExactly(values);
    }

    @SuppressWarnings("unchecked")
    private Class<T> getEnumClass() {
        return (Class<T>) getMapping().values().iterator().next().getClass();
    }

    private static String quote(String text) {
        return "\"" + text + "\"";
    }

}
