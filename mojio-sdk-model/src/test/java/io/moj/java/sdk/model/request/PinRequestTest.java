package io.moj.java.sdk.model.request;

import org.junit.Test;

import static io.moj.java.sdk.test.TestUtils.assertAccess;
import static io.moj.java.sdk.test.TestUtils.assertToStringContainsAllFields;

/**
 * Created by skidson on 2016-04-14.
 */
public class PinRequestTest {

    @Test
    public void testPinRequest() throws IllegalAccessException {
        assertToStringContainsAllFields(new PinRequest("5555550674"));
        assertAccess(new PinRequest("5555550674"));
    }

}
