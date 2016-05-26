package io.moj.java.sdk.model.request;

import org.junit.Test;

import static io.moj.java.sdk.test.TestUtils.assertAccess;
import static io.moj.java.sdk.test.TestUtils.assertToStringContainsAllFields;

/**
 * Created by Mauro on 2016-05-26.
 */
public class ResetPasswordRequestTest {

    @Test
    public void testResetPasswordRequest() throws IllegalAccessException {
        assertToStringContainsAllFields(new ResetPasswordRequest("aaa", "aaa", "abcdef"));
        assertAccess(new ResetPasswordRequest("aaa", "aaa", "abcdef"));
    }
}
