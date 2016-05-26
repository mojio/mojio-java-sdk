package io.moj.java.sdk.model.request;

import org.junit.Test;

import static io.moj.java.sdk.test.TestUtils.assertAccess;
import static io.moj.java.sdk.test.TestUtils.assertToStringContainsAllFields;

/**
 * Created by Mauro on 2016-05-26.
 */
public class ForgotPasswordRequestTest {

    @Test
    public void testForgotPasswordRequest() throws IllegalAccessException {
        assertToStringContainsAllFields(new ForgotPasswordRequest("5555550674"));
        assertAccess(new ForgotPasswordRequest("5555550674"));
    }
}
