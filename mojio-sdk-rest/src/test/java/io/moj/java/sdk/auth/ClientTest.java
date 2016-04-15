package io.moj.java.sdk.auth;

import io.moj.java.sdk.test.TestUtils;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by skidson on 2016-04-13.
 */
public class ClientTest {

    @Test
    public void testImmutable() throws Exception {
        Client client = new Client("key", "secret");
        TestUtils.assertAccess(client, false);
    }

    @Test
    public void testToString() throws Exception {
        Client client = new Client("key", "secret");
        TestUtils.assertToStringContainsAllFields(client);
    }

    @Test
    public void testEqualsAndHashCode() throws Exception {
        Client a = new Client("key", "secret");
        Client b = new Client("key", "secret");
        assertThat(a.equals(b)).isTrue();
        assertThat(a.hashCode()).isEqualTo(b.hashCode());

        a = new Client("key", "secret");
        b = new Client("key", "different");
        assertThat(a.equals(b)).isFalse();
        assertThat(a.hashCode()).isNotEqualTo(b.hashCode());

        a = new Client("key", "secret");
        b = new Client("different", "secret");
        assertThat(a.equals(b)).isFalse();
        assertThat(a.hashCode()).isNotEqualTo(b.hashCode());

        a = new Client("key", "secret");
        b = new Client("different", "different");
        assertThat(a.equals(b)).isFalse();
        assertThat(a.hashCode()).isNotEqualTo(b.hashCode());
    }

}
