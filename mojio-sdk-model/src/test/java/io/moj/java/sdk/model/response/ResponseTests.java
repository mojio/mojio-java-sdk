package io.moj.java.sdk.model.response;

import org.junit.Test;

import static io.moj.java.sdk.test.TestUtils.assertAccess;
import static io.moj.java.sdk.test.TestUtils.assertToStringContainsAllFields;

/**
 * Created by skidson on 2016-04-14.
 */
public class ResponseTests {

    @Test
    public void testAuthResponse() throws IllegalAccessException {
        assertToStringContainsAllFields(new AuthResponse());
        assertAccess(new AuthResponse());
    }

    @Test
    public void testListResponse() throws IllegalAccessException {
        assertToStringContainsAllFields(new ListResponse<>());
        assertAccess(new ListResponse<>());
    }

    @Test
    public void testMessageResponse() throws IllegalAccessException {
        assertToStringContainsAllFields(new MessageResponse());
        assertAccess(new MessageResponse());
    }

}
