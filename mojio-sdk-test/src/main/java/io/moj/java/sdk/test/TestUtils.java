package io.moj.java.sdk.test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import javax.annotation.Nullable;
import java.lang.reflect.*;
import java.util.*;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.powermock.api.mockito.PowerMockito.mock;

/**
 * Various static testing methods.
 * Created by skidson on 16-02-23.
 */
public final class TestUtils {

    private TestUtils() {
    }

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

    public static void assertAccess(Object pojo, String... excludes) {
        List<Method> methods = TestUtils.getAllMethods(pojo);
        Iterator<Method> methodIterator = methods.iterator();
        while (methodIterator.hasNext()) {
            Method method = methodIterator.next();
            for (String exclusion : excludes) {
                if (method.getName().endsWith(exclusion)) {
                    methodIterator.remove();
                }
            }
        }

        List<Field> fields = TestUtils.getAllFields(pojo);
        Iterator<Field> fieldIterator = fields.iterator();
        while (fieldIterator.hasNext()) {
            Field field = fieldIterator.next();
            for (String exclusion : excludes) {
                if (field.getName().equals(exclusion)) {
                    fieldIterator.remove();
                }
            }
        }
        assertAccess(pojo, methods, fields, true);
    }

    public static void assertAccess(Object pojo, boolean mutable) {
        assertAccess(pojo, getAllMethods(pojo), mutable);
    }

    public static void assertAccess(Object pojo, List<Method> methods) {
        assertAccess(pojo, methods, true);
    }

    public static void assertAccess(Object pojo, List<Method> methods, boolean mutable) {
        assertAccess(pojo, methods, getAllFields(pojo), mutable);
    }

    public static void assertAccess(Object pojo, List<Method> methods, List<Field> fields, boolean mutable) {
        Set<String> methodNames =
                new HashSet<>(Lists.transform(methods, FUNCTION_EXTRACT_METHOD_NAMES));

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

            String setterName = "set" + captializedFieldName;
            if (mutable) {
                assertThat(methodNames).contains(setterName);
            } else {
                assertThat(methodNames).doesNotContain(setterName);
            }
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
     *
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
     * Returns fields on the object that match the given class.
     *
     * @param object
     * @param type
     * @return
     */
    public static List<Field> getFieldsByType(final Object object, final Class<?> type) {
        return Lists.newArrayList(Iterables.filter(TestUtils.getAllFields(object), new Predicate<Field>() {
            @Override
            public boolean apply(@Nullable Field input) {
                return input != null && input.getType().equals(type);
            }
        }));
    }

    /**
     * Returns all methods of an object and all it's superclasses.
     *
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
            } catch (Exception e) {
            }
        } else {
            arg = mock(clazz);
        }
        return arg;
    }

}
