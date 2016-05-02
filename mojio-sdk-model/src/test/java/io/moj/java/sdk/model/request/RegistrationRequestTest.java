package io.moj.java.sdk.model.request;

import io.moj.java.sdk.test.TestUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static io.moj.java.sdk.test.TestUtils.assertAccess;
import static io.moj.java.sdk.test.TestUtils.assertToStringContainsAllFields;
import static io.moj.java.sdk.test.TestUtils.getAllMethods;

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
                .email(email)
                .password(password)
                .phone(phone)
                .username(username)
                .build();

        assertThat(request.getEmail()).isEqualTo(email);
        assertThat(request.getPassword()).isEqualTo(password);
        assertThat(request.getPhoneNumber()).isEqualTo(phone);
        assertThat(request.getUsername()).isEqualTo(username);
    }

    @Test(expected = IllegalStateException.class)
    public void testBuilder_noEmail() {
        RegistrationRequest request = new RegistrationRequest.Builder()
                .password("password")
                .phone("5555555555")
                .username("username")
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void testBuilder_noPassword() {
        RegistrationRequest request = new RegistrationRequest.Builder()
                .email("test@moj.io")
                .phone("5555555555")
                .username("username")
                .build();
    }

    @Test
    public void testBuild_unique() {
        RegistrationRequest.Builder builder = new RegistrationRequest.Builder()
                .email("test@moj.io")
                .password("password")
                .phone("5555555555")
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
                .email(email)
                .password(password)
                .phone(phone)
                .username(username);

        assertToStringContainsAllFields(builder.build());

        RegistrationRequest request = builder.build();

        // TODO don't fail just because we don't want to expose the ConfirmPassword getter/setter
        List<Field> fields = TestUtils.getAllFields(request);
        Iterator<Field> i = fields.iterator();
        while (i.hasNext()) {
            Field field = i.next();
            if (field.getName().contains("ConfirmPassword")) {
                i.remove();
            }
        }

        assertAccess(request, getAllMethods(request), fields, true);
    }

}
