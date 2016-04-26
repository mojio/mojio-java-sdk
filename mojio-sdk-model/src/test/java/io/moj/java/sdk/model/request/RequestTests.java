package io.moj.java.sdk.model.request;

import org.junit.Test;

import static io.moj.java.sdk.test.TestUtils.assertAccess;
import static io.moj.java.sdk.test.TestUtils.assertToStringContainsAllFields;

/**
 * Created by skidson on 2016-04-14.
 */
public class RequestTests {

    @Test
    public void testSMSRegistrationRequest() throws IllegalAccessException {
        assertToStringContainsAllFields(new SMSRegistrationRequest("5550674", "test@moj.io", "pAssw0rd"));
        assertAccess(new SMSRegistrationRequest("5550674", "test@moj.io", "pAssw0rd"));
    }

    @Test
    public void testSMSValidationRequest() throws IllegalAccessException {
        assertToStringContainsAllFields(new SMSValidationRequest("5550674", "1234"));
        assertAccess(new SMSValidationRequest("5550674", "1234"));
    }

}
