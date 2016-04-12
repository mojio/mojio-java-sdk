package io.moj.mobile.android.sdk.test;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.annotation.Nullable;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.powermock.api.mockito.PowerMockito.mock;

/**
 * Various static testing methods.
 * Created by skidson on 16-02-23.
 */
public final class TestUtils {

    private TestUtils() {}

    private static final Function<Method, String> FUNCTION_EXTRACT_METHOD_NAMES =
            new Function<Method, String>() {
                @Nullable
                @Override
                public String apply(@Nullable Method input) {
                    if (input == null)
                        return null;
                    return input.getName();
                }
            };

    /**
     * Assets that the POJO's toString() method returns a String that includes all fields on it and
     * it's parent classes.
     */
    public static void assertToStringContainsAllFields(Object pojo) throws IllegalAccessException {
        List<Field> fields = getAllFields(pojo);

        String toString = pojo.toString();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers()))
                continue;

            boolean accessible = field.isAccessible();
            field.setAccessible(true);
            assertThat(toString).contains(field.getName() + "=" + formatFieldValue(field, pojo));
            field.setAccessible(accessible);
        }
    }

    public static void assertAccess(Object pojo) {
        assertAccess(pojo, getAllMethods(pojo));
    }

    public static void assertAccess(Object pojo, List<Method> methods) {
        Set<String> methodNames =
                new HashSet<>(Lists.transform(methods, FUNCTION_EXTRACT_METHOD_NAMES));

        List<Field> fields = getAllFields(pojo);
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers()))
                continue;

            assertThat(Modifier.isPrivate(field.getModifiers())).isTrue();

            String fieldName = field.getName();
            if (fieldName.startsWith("_")) {
                fieldName = "local" + fieldName.substring(1, 2).toUpperCase(Locale.US) +
                        fieldName.substring(2);

            }
            String captializedFieldName = fieldName.substring(0, 1).toUpperCase(Locale.US) +
                    fieldName.substring(1);

            // we don't use "is" because all boolean should be Boolean objects and this test will
            // catch that too
            assertThat(methodNames).contains("get" + captializedFieldName);
            assertThat(methodNames).contains("set" + captializedFieldName);
        }

        for (Method method : methods) {
            if (!method.getName().startsWith("set"))
                continue;

            try {
                // call the setter and then assert the getter returns the same thing back
                Object arg = mockValue(method.getParameterTypes()[0]);
                boolean accessible = method.isAccessible();
                method.setAccessible(true);
                method.invoke(pojo, arg);
                Method getMethod = pojo.getClass().getMethod(method.getName().replace("set", "get"));
                assertWithMessage(method.getName() + "(" + arg + ") followed by " + getMethod.getName() + "()")
                        .that(getMethod.invoke(pojo)).isEqualTo(arg);
                method.setAccessible(accessible);
            } catch (IllegalArgumentException | InvocationTargetException | IllegalAccessException |
                    NoSuchMethodException e) {
                System.err.println("Could not test " + method.getName() + "(): " +
                        e.getClass().getSimpleName() + " - " + e.getMessage());
            }
        }
    }

    /**
     * Returns all fields of an object and all it's superclasses.
     * @param pojo
     * @return
     */
    public static List<Field> getAllFields(Object pojo) {
        Class pojoClass = pojo.getClass();
        List<Field> fields = Lists.newArrayList(pojoClass.getDeclaredFields());

        Class parentClass = pojoClass.getSuperclass();
        while (parentClass != Object.class) {
            fields.addAll(Lists.newArrayList(parentClass.getDeclaredFields()));
            parentClass = parentClass.getSuperclass();
        }
        return fields;
    }

    /**
     * Returns all methods of an object and all it's superclasses.
     * @param pojo
     * @return
     */
    public static List<Method> getAllMethods(Object pojo) {
        Class pojoClass = pojo.getClass();
        List<Method> methods = Lists.newArrayList(pojoClass.getDeclaredMethods());

        Class parentClass = pojoClass.getSuperclass();
        while (parentClass != Object.class) {
            methods.addAll(Lists.newArrayList(parentClass.getDeclaredMethods()));
            parentClass = parentClass.getSuperclass();
        }
        return methods;
    }

    private static String formatFieldValue(Field field, Object object) throws IllegalAccessException {
        Object value = field.get(object);
        if (field.getType() == String.class) {
            return "'" + value + "'";
        }
        return String.valueOf(value);
    }

    @SuppressWarnings("unchecked")
    public static Object mockValue(Class clazz) {
        Object arg = null;
        if (clazz.isPrimitive()) {
            throw new IllegalStateException("Found method expecting a primitive");
        } else if (clazz == String.class) {
            arg = "testString";
        } else if (clazz.isArray()) {
            arg = Array.newInstance(clazz.getComponentType(), 2);
        } else if (clazz.isEnum()) {
            try {
                Method valuesMethod = clazz.getMethod("values");
                arg = ((Object[]) valuesMethod.invoke(null))[0];
            } catch (Exception e) { }
        } else {
            arg = mock(clazz);
        }
        return arg;
    }

}
