package io.moj.java.sdk.model.stream;

import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import io.moj.java.sdk.model.enums.EnumTest;

/**
 * Created by Mauro on 2016-11-12.
 */
public class IconTypeTest extends EnumTest<IconType> {

    @Override
    public Map<String, IconType> getMapping() {
        return new ImmutableMap.Builder<String, IconType>()
                .put("warning", IconType.WARNING)
                .put("alert", IconType.ALERT)
                .build();
    }

    @Test
    @Override
    public void testFromKey() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testFromKey();
    }

    @Test
    @Override
    public void testFromKey_invalid() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testFromKey_invalid();
    }

    @Test
    @Override
    public void testGetKey() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testGetKey();
    }

    @Test
    @Override
    public void testValues() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testValues();
    }
}
