package io.moj.java.sdk.auth;

import io.moj.java.sdk.MojioAuthApi;
import io.moj.java.sdk.model.response.AuthResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import retrofit2.Call;
import retrofit2.Response;

import java.util.concurrent.TimeUnit;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mock;

/**
 * Created by skidson on 2016-04-13.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Response.class)
public class DefaultAuthenticatorTest {

    private DefaultAuthenticator authenticator;
    private MojioAuthApi authApi;
    private Client client;

    @Before
    public void setup() {
        client = new Client("clientKey", "clientSecret");
        authApi = mock(MojioAuthApi.class);
        authenticator = new DefaultAuthenticator(authApi, client, null);
    }

    @Test
    public void testGetAccessToken() {
        AccessToken expectedToken = mockAccessToken(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(2));
        assertThat(authenticator.getAccessToken()).isEqualTo(expectedToken);
    }

    @Test
    public void testGetAccessToken_null() {
        assertThat(authenticator.getAccessToken()).isNull();
    }

    @Test
    public void testInvalidateAccessToken_null() {
        AccessToken token = mockAccessToken(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(2));
        assertThat(authenticator.getAccessToken()).isEqualTo(token);

        String expectedRefreshedAccessToken = "expectedRefreshedAccessToken";
        String expectedRefreshedRefreshToken = "expectedRefreshedRefreshToken";
        long expectedExpiresIn = TimeUnit.MINUTES.toSeconds(10);

        // invalidating with a null token should do nothing
        authenticator.invalidateAccessToken(null);
        AccessToken refreshedToken = authenticator.getAccessToken();
        verify(authApi, never()).refresh(MojioAuthApi.GRANT_TYPE_REFRESH, expectedRefreshedRefreshToken,
                client.getKey(), client.getSecret(), null);
        assertThat(refreshedToken).isEqualTo(token);

        // invalidating with a different token should do nothing (e.g. caller was using an old token that was already
        // invalidated & refreshed)
        authenticator.invalidateAccessToken(new AccessToken("different", 1234L));
        refreshedToken = authenticator.getAccessToken();
        verify(authApi, never()).refresh(MojioAuthApi.GRANT_TYPE_REFRESH, expectedRefreshedRefreshToken,
                client.getKey(), client.getSecret(), null);
        assertThat(refreshedToken).isEqualTo(token);
    }

    @Test
    public void testGetAccessToken_invalidated() throws Exception {
        AccessToken oldToken = mockAccessToken(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(2));
        assertThat(authenticator.getAccessToken()).isEqualTo(oldToken);

        String expectedRefreshedAccessToken = "expectedRefreshedAccessToken";
        String expectedRefreshedRefreshToken = "expectedRefreshedRefreshToken";
        long expectedExpiresIn = TimeUnit.MINUTES.toSeconds(10);
        mockRefreshToken(expectedRefreshedAccessToken, expectedRefreshedRefreshToken, expectedExpiresIn);

        authenticator.invalidateAccessToken(oldToken);
        long expectedExpirationTimestamp = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(expectedExpiresIn);
        AccessToken refreshedToken = authenticator.getAccessToken();
        verify(authApi).refresh(MojioAuthApi.GRANT_TYPE_REFRESH, oldToken.getRefreshToken(), client.getKey(),
                client.getSecret(), null);
        assertAccessToken(refreshedToken, expectedRefreshedAccessToken, expectedRefreshedRefreshToken,
                expectedExpirationTimestamp);

        // verify the next call doesn't refresh (not still invalidated)
        refreshedToken = authenticator.getAccessToken();
        verify(authApi, never()).refresh(MojioAuthApi.GRANT_TYPE_REFRESH, expectedRefreshedRefreshToken,
                client.getKey(), client.getSecret(), null);
        assertAccessToken(refreshedToken, expectedRefreshedAccessToken, expectedRefreshedRefreshToken,
                expectedExpirationTimestamp);
    }

    @Test
    public void testGetAccessToken_expired() throws Exception {
        String expectedRefreshedAccessToken = "expectedRefreshedAccessToken";
        String expectedRefreshedRefreshToken = "expectedRefreshedRefreshToken";
        long expectedExpiresIn = TimeUnit.MINUTES.toSeconds(10);
        mockRefreshToken(expectedRefreshedAccessToken, expectedRefreshedRefreshToken, expectedExpiresIn);

        // expired 2 minutes ago
        AccessToken oldToken = mockAccessToken(System.currentTimeMillis() - TimeUnit.MINUTES.toMillis(2));

        long expectedExpirationTimestamp = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(expectedExpiresIn);
        AccessToken refreshedToken = authenticator.getAccessToken();
        verify(authApi).refresh(MojioAuthApi.GRANT_TYPE_REFRESH, oldToken.getRefreshToken(), client.getKey(),
                client.getSecret(), null);
        assertAccessToken(refreshedToken, expectedRefreshedAccessToken, expectedRefreshedRefreshToken,
                expectedExpirationTimestamp);
    }

    private void assertAccessToken(AccessToken actualToken, String expectedAccessToken, String expectedRefreshToken,
                                   long expectedExpirationTimestamp) {
        assertThat(actualToken.getAccessToken()).isEqualTo(expectedAccessToken);
        assertThat(actualToken.getRefreshToken()).isEqualTo(expectedRefreshToken);

        // since server returns expiresIn from when it generates the token, accept a variance of +/- 5ms
        assertThat(actualToken.getExpirationTimestamp()).isAtMost(expectedExpirationTimestamp + 5);
        assertThat(actualToken.getExpirationTimestamp()).isAtLeast(expectedExpirationTimestamp - 5);
    }

    private AccessToken mockAccessToken(long expirationTimestamp) {
        AccessToken expectedToken = new AccessToken("access", "refresh", expirationTimestamp);
        authenticator.setAccessToken(expectedToken);
        return expectedToken;
    }

    private void mockRefreshToken(String accessToken, String refreshToken, long expiresIn) throws Exception {
        Call<AuthResponse> refreshCall = mock(Call.class);
        Response<AuthResponse> refreshResponse = mock(Response.class);
        AuthResponse refreshAuthResponse = mock(AuthResponse.class);
        when(authApi.refresh(anyString(), anyString(), anyString(), anyString(), anyString())).thenReturn(refreshCall);
        when(refreshCall.execute()).thenReturn(refreshResponse);
        when(refreshResponse.isSuccessful()).thenReturn(true);
        when(refreshResponse.body()).thenReturn(refreshAuthResponse);
        when(refreshAuthResponse.getAccessToken()).thenReturn(accessToken);
        when(refreshAuthResponse.getRefreshToken()).thenReturn(refreshToken);
        when(refreshAuthResponse.getExpiresIn()).thenReturn(expiresIn);
    }

}
