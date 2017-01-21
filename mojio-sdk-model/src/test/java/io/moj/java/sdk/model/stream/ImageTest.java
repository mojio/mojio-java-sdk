package io.moj.java.sdk.model.stream;

import org.junit.Test;

import static io.moj.java.sdk.test.TestUtils.assertAccess;
import static io.moj.java.sdk.test.TestUtils.assertToStringContainsAllFields;

/**
 * Created by Mauro on 2016-11-12.
 */
public class ImageTest {

    @Test
    public void testObject() throws IllegalAccessException {
        Image obj = new Image();
        assertToStringContainsAllFields(obj);
        assertAccess(obj);
    }
}
