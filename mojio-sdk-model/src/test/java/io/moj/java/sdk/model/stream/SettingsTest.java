package io.moj.java.sdk.model.stream;

import org.junit.Test;

import static io.moj.java.sdk.test.TestUtils.assertAccess;
import static io.moj.java.sdk.test.TestUtils.assertToStringContainsAllFields;

/**
 * Created by Mauro on 2016-06-24.
 */
public class SettingsTest {
    @Test
    public void testObject() throws IllegalAccessException {
        Settings obj = new Settings();
        assertToStringContainsAllFields(obj);
        assertAccess(obj);
    }
}
