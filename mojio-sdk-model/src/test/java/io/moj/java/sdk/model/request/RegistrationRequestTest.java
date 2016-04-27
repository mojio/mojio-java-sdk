package io.moj.java.sdk.model.request;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static io.moj.java.sdk.test.TestUtils.assertAccess;
import static io.moj.java.sdk.test.TestUtils.assertToStringContainsAllFields;

/**
 * Created by skidson on 2016-04-14.
 */
public class RegistrationRequestTest {

    @Test
    public void testBuilder() {
        String email = "test@moj.io";
        String password = "password";
        String phone = "5555555555";
        String username = "username";

        RegistrationRequest request = new RegistrationRequest.Builder()
                .emailAddress(email)
                .password(password)
                .phoneNumber(phone)
                .username(username)
                .build();

        assertThat(request.getEmailAddress()).isEqualTo(email);
        assertThat(request.getPassword()).isEqualTo(password);
        assertThat(request.getPhoneNumber()).isEqualTo(phone);
        assertThat(request.getUsername()).isEqualTo(username);
    }

    @Test(expected = IllegalStateException.class)
    public void testBuilder_noEmail() {
        RegistrationRequest request = new RegistrationRequest.Builder()
                .password("password")
                .phoneNumber("5555555555")
                .username("username")
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void testBuilder_noPassword() {
        RegistrationRequest request = new RegistrationRequest.Builder()
                .emailAddress("test@moj.io")
                .phoneNumber("5555555555")
                .username("username")
                .build();
    }

    @Test
    public void testBuild_unique() {
        RegistrationRequest.Builder builder = new RegistrationRequest.Builder()
                .emailAddress("test@moj.io")
                .password("password")
                .phoneNumber("5555555555")
                .username("username");
        RegistrationRequest a = builder.build();
        RegistrationRequest b = builder.build();
        assertThat(a).isNotSameAs(b);
    }

    @Test
    public void testRegistrationRequest() throws IllegalAccessException {
        String email = "test@moj.io";
        String password = "password";
        String phone = "5555555555";
        String username = "username";

        RegistrationRequest.Builder builder = new RegistrationRequest.Builder()
                .emailAddress(email)
                .password(password)
                .phoneNumber(phone)
                .username(username);

        assertToStringContainsAllFields(builder.build());
        assertAccess(builder.build());
    }

}
