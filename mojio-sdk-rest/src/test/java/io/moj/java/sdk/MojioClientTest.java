package io.moj.java.sdk;

import com.google.gson.Gson;
import io.moj.java.sdk.auth.AccessToken;
import io.moj.java.sdk.auth.Authenticator;
import io.moj.java.sdk.model.User;
import io.moj.java.sdk.model.response.AuthResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import retrofit2.Call;
import retrofit2.Response;

import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by skidson on 2016-04-14.
 */
public class MojioClientTest {

    @Test
    public void testBuilder_defaults() {
        String expectedClientKey = "expectedClientKey";
        String expectedClientSecret = "expectedClientSecret";
        MojioClient client = new MojioClient.Builder(expectedClientKey, expectedClientSecret).build();

        assertThat(client.rest()).isNotNull();
        assertThat(client.rest().getClass()).isAssignableTo(MojioRestApi.class);

        assertThat(client.auth()).isNotNull();
        assertThat(client.auth().getClass()).isAssignableTo(MojioAuthApi.class);

        assertThat(client.push()).isNotNull();
        assertThat(client.push().getClass()).isAssignableTo(MojioPushApi.class);

        assertThat(client.getEnvironment()).isEqualTo(MojioEnvironment.getDefault());
    }

    @Test
    public void testBuilder() {
        String expectedClientKey = "expectedClientKey";
        String expectedClientSecret = "expectedClientSecret";
        Authenticator expectedAuthenticator = mock(Authenticator.class);
        Executor expectedExecutor = mock(Executor.class);
        ExecutorService expectedRequestExecutor = mock(ExecutorService.class);
        Gson expectedGson = new Gson();
        boolean expectedLoggingEnabled = true;
        Environment expectedEnvironment = MojioEnvironment.STAGING;

        MojioClient client = new MojioClient.Builder(expectedClientKey, expectedClientSecret)
                .authenticator(expectedAuthenticator)
                .environment(expectedEnvironment)
                .gson(expectedGson)
                .logging(expectedLoggingEnabled)
                .callbackExecutor(expectedExecutor)
                .build();

        assertThat(client.rest()).isNotNull();
        assertThat(client.rest().getClass()).isAssignableTo(MojioRestApi.class);
        assertThat(client.auth()).isNotNull();
        assertThat(client.auth().getClass()).isAssignableTo(MojioAuthApi.class);
        assertThat(client.push()).isNotNull();
        assertThat(client.push().getClass()).isAssignableTo(MojioPushApi.class);

        assertThat(client.getAuthenticator()).isEqualTo(expectedAuthenticator);
        assertThat(client.getEnvironment()).isEqualTo(expectedEnvironment);
        assertThat(client.getGson()).isEqualTo(expectedGson);
        assertThat(client.getCallbackExecutor()).isEqualTo(expectedExecutor);
        assertThat(client.isLoggingEnabled()).isEqualTo(expectedLoggingEnabled);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuilder_nullClientKey() {
        new MojioClient.Builder(null, "secret");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuilder_emptyClientKey() {
        new MojioClient.Builder("", "secret");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuilder_nullClientSecret() {
        new MojioClient.Builder("key", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuilder_emptyClientSecret() {
        new MojioClient.Builder("key", "");
    }

    @Test
    public void testLogin_blocking() throws Exception {
        MockWebServer mockServer = new MockWebServer();
        mockServer.start();

        Authenticator mockAuthenticator = mock(Authenticator.class);
        Environment environment = mock(Environment.class);
        String serverUrl = mockServer.url("").toString();
        when(environment.getApiUrl()).thenReturn(serverUrl);
        when(environment.getApiUrl(1)).thenReturn(serverUrl);
        when(environment.getPushUrl()).thenReturn(serverUrl);
        when(environment.getAccountsUrl()).thenReturn(serverUrl);

        String expectedClientKey = "expectedClientKey";
        String expectedClientSecret = "expectedClientSecret";
        MojioClient client = new MojioClient.Builder(expectedClientKey, expectedClientSecret)
                .environment(environment)
                .authenticator(mockAuthenticator)
                .build();

        String username = "username";
        String password = "password";

        Call<User> call = client.login(username, password);
        assertThat(call).isNotNull();

        String accessToken = "accessToken";
        String refreshToken = "refreshToken";
        long expiresIn = TimeUnit.MINUTES.toSeconds(10);
        long expectedExpirationTimestamp = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(expiresIn);

        // first response is a successful login
        AuthResponse authResponse = new AuthResponse();
        authResponse.setAccessToken(accessToken);
        authResponse.setRefreshToken(refreshToken);
        authResponse.setExpiresIn(expiresIn);
        mockServer.enqueue(new MockResponse().setResponseCode(200).setBody(client.getGson().toJson(authResponse)));

        // second response is the User record
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        mockServer.enqueue(new MockResponse().setResponseCode(200).setBody(client.getGson().toJson(user)));

        // verify the response has the correct user
        Response<User> response = call.execute();
        assertThat(response.body().getId()).isEqualTo(user.getId());

        // verify the login call stored the correct access token
        ArgumentCaptor<AccessToken> argument = ArgumentCaptor.forClass(AccessToken.class);
        verify(mockAuthenticator).setAccessToken(argument.capture());
        assertThat(argument.getValue().getAccessToken()).isEqualTo(accessToken);
        assertThat(argument.getValue().getRefreshToken()).isEqualTo(refreshToken);

        // since server returns expiresIn from when it generates the token, accept a variance
        assertThat(argument.getValue().getExpirationTimestamp()).isAtMost(expectedExpirationTimestamp + 1000);
        assertThat(argument.getValue().getExpirationTimestamp()).isAtLeast(expectedExpirationTimestamp - 1000);

        assertThat(call.isExecuted()).isTrue();
    }

}
