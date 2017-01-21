package io.moj.java.sdk.auth;

import io.moj.java.sdk.test.TestUtils;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by skidson on 2016-04-13.
 */
public class AccessTokenTest {

    @Test
    public void testConstructor() {
        String accessToken = "access";
        String refreshToken = "refresh";
        long expirationTimestamp = System.currentTimeMillis();

        AccessToken token = new AccessToken(accessToken, refreshToken, expirationTimestamp);
        assertThat(token.getAccessToken()).isEqualTo(accessToken);
        assertThat(token.getRefreshToken()).isEqualTo(refreshToken);
        assertThat(token.getExpirationTimestamp()).isEqualTo(expirationTimestamp);

        token = new AccessToken(accessToken, expirationTimestamp);
        assertThat(token.getAccessToken()).isEqualTo(accessToken);
        assertThat(token.getRefreshToken()).isNull();
        assertThat(token.getExpirationTimestamp()).isEqualTo(expirationTimestamp);
    }

    @Test
    public void testImmutable() throws Exception {
        AccessToken token = new AccessToken("access", "refresh", 1234L);
        TestUtils.assertAccess(token, false);
    }

    @Test
    public void testToString() throws Exception {
        AccessToken token = new AccessToken("access", "refresh", 1234L);
        TestUtils.assertToStringContainsAllFields(token);
    }

    @Test
    public void testEqualsAndHashCode() throws Exception {
        AccessToken a = new AccessToken("access", "refresh", 1234L);
        AccessToken b = new AccessToken("access", "refresh", 1234L);
        assertThat(a.equals(b)).isTrue();
        assertThat(a.hashCode()).isEqualTo(b.hashCode());

        // refresh token doesn't change equality
        a = new AccessToken("access", "refresh", 1234L);
        b = new AccessToken("access", "different", 1234L);
        assertThat(a.equals(b)).isTrue();
        assertThat(a.hashCode()).isEqualTo(b.hashCode());

        // expiration timestamp doesn't change equality
        a = new AccessToken("access", "refresh", 1234L);
        b = new AccessToken("access", "refresh", 5678L);
        assertThat(a.equals(b)).isTrue();
        assertThat(a.hashCode()).isEqualTo(b.hashCode());

        a = new AccessToken("access", "refresh", 1234L);
        b = new AccessToken("different", "refresh", 1234L);
        assertThat(a.equals(b)).isFalse();
        assertThat(a.hashCode()).isNotEqualTo(b.hashCode());
    }

}
