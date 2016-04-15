package io.moj.java.sdk;

import com.google.gson.Gson;
import io.moj.java.sdk.auth.AccessToken;
import io.moj.java.sdk.auth.AuthInterceptor;
import io.moj.java.sdk.auth.Authenticator;
import io.moj.java.sdk.auth.Client;
import io.moj.java.sdk.auth.DefaultAuthenticator;
import io.moj.java.sdk.auth.OnAccessTokenExpiredListener;
import io.moj.java.sdk.logging.LoggingInterceptor;
import io.moj.java.sdk.model.User;
import io.moj.java.sdk.model.response.AuthResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/**
 * Client for authenticating and making calls against the Mojio API.
 * Created by skidson on 2016-04-12.
 */
public class MojioClient {

    private static final String TAG = "Mojio";

    private final Environment environment;
    private final Executor executor;
    private final Gson gson;
    private final Client client;
    private final boolean loggingEnabled;

    private final MojioRestApi restApi;
    private final MojioAuthApi authApi;
    private Authenticator authenticator;
    private AuthInterceptor authInterceptor;

    private MojioClient(Environment environment, Client client, Gson gson, Authenticator authenticator,
                        Executor executor, boolean logging) {
        this.environment = environment == null ? MojioEnvironment.getDefault() : environment;
        this.gson = gson == null ? new Gson() : gson;
        this.client = client;
        this.loggingEnabled = logging;
        this.executor = executor;

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(this.gson);
        if (logging) {
            httpClientBuilder.addInterceptor(new LoggingInterceptor(TAG));
        }

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .addConverterFactory(gsonConverterFactory);
        if (executor != null) {
            retrofitBuilder.callbackExecutor(executor);
        }

        authApi = retrofitBuilder
                .baseUrl(this.environment.getAccountsUrl() + "/")
                .client(httpClientBuilder.build())
                .build()
                .create(MojioAuthApi.class);

        // configure subsequent clients with the AuthInterceptor
        if (authenticator == null) {
            authenticator = new DefaultAuthenticator(authApi, client);
        }
        this.authenticator = authenticator;
        authInterceptor = new AuthInterceptor(authenticator);
        httpClientBuilder.addInterceptor(authInterceptor);

        restApi = retrofitBuilder
                .baseUrl(this.environment.getApiUrl() + "/")
                .client(httpClientBuilder.build())
                .build()
                .create(MojioRestApi.class);
    }

    /**
     * Authenticates a user, stores the access token in the client's configured
     * {@link io.moj.java.sdk.auth.Authenticator}, and then returns the {@link io.moj.java.sdk.model.User} entity.
     * @param username
     * @param password
     * @return
     */
    public Call<User> login(String username, String password) {
        return new LoginCall(username, password, client);
    }

    /**
     * Returns the {@link io.moj.java.sdk.MojioRestApi} interface for making direct calls to the Mojio REST API.
     * @return
     */
    public MojioRestApi rest() {
        return restApi;
    }

    /**
     * Returns the {@link io.moj.java.sdk.MojioAuthApi} interface for making direct calls to the Mojio AUTH API.
     * @return
     */
    public MojioAuthApi auth() {
        return authApi;
    }

    /**
     * Returns the client's configured environment.
     * @return
     */
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * Returns whether logging is enabled or not.
     * @return
     */
    public boolean isLoggingEnabled() {
        return loggingEnabled;
    }

    /**
     * Returns the {@link io.moj.java.sdk.auth.Authenticator} this client is configured with.
     * @return
     */
    protected Authenticator getAuthenticator() {
        return authenticator;
    }

    /**
     * Returns the {@link java.util.concurrent.Executor} this client is configured with.
     * @return
     */
    protected Executor getExecutor() {
        return executor;
    }

    /**
     * Returns the {@link com.google.gson.Gson} this client is configured with.
     * @return
     */
    protected Gson getGson() {
        return gson;
    }

    /**
     * Sets a listener for authentication failure events. This is useful for handling authentication issues on a
     * cross-cutting basis (e.g. prompting the user to log in again).
     * @param listener
     */
    public void setOnAccessTokenExpiredListener(OnAccessTokenExpiredListener listener) {
        authInterceptor.setOnAccessTokenExpiredListener(listener);
    }

    /**
     * Builder for a {@link io.moj.java.sdk.MojioClient}.
     */
    public static class Builder {
        private Environment environment;
        private Authenticator authenticator;
        private Client client;
        private Executor executor;
        private Gson gson;
        private boolean logging = false;

        public Builder(String clientKey, String clientSecret) {
            if (clientKey == null || clientKey.isEmpty()) {
                throw new IllegalArgumentException("Client key cannot be null or empty");
            }

            if (clientSecret == null || clientSecret.isEmpty()) {
                throw new IllegalArgumentException("Client secret cannot be null or empty");
            }
            this.client = new Client(clientKey, clientSecret);
        }

        /**
         * Configures the client to explicitly use only specified environment.
         * @param environment
         * @return
         */
        public Builder environment(Environment environment) {
            this.environment = environment;
            return this;
        }

        /**
         * Configures the client to use the specified authenticator for storing, retrieving, and refreshing access
         * tokens.
         * @param authenticator
         * @return
         */
        public Builder authenticator(Authenticator authenticator) {
            this.authenticator = authenticator;
            return this;
        }

        /**
         * Configures the client to execute callbacks on the specified {@link java.util.concurrent.Executor}.
         * @param executor
         * @return
         */
        public Builder executor(Executor executor) {
            this.executor = executor;
            return this;
        }

        /**
         * Configures whether requests and responses should be logged. Specific log destinations should be configured
         * using the {@link io.moj.java.sdk.logging.Log} class. Logging is disabled by default.
         * @param enabled
         * @return
         */
        public Builder logging(boolean enabled) {
            this.logging = enabled;
            return this;
        }

        /**
         * Configures a specific {@link com.google.gson.Gson} instance to be used for serializing requests and
         * deserializing responses. This is provided to allow an existing Gson instance to be used instead of a new one
         * being constructed. Callers should be aware, however, that specific configurations may interfere with the
         * SDK's functionality. A default {@link com.google.gson.Gson} instance will always work.
         * @param gson
         * @return
         */
        public Builder gson(Gson gson) {
            this.gson = gson;
            return this;
        }

        /**
         * Constructs a {@link io.moj.java.sdk.MojioClient} instance with the provided configuration.
         * @return
         */
        public MojioClient build() {
            return new MojioClient(environment, client, gson, authenticator, executor, logging);
        }
    }

    /**
     * Wrapper for an authentication call that stores the access token in this client's
     * {@link io.moj.java.sdk.auth.Authenticator} and then follows with a call to get the current User.
     */
    private class LoginCall implements Call<User> {
        private String username;
        private String password;
        private Client client;
        private Call<User> userCall;
        private Call<AuthResponse> authCall;

        public LoginCall(String username, String password, Client client) {
            this.username = username;
            this.password = password;
            this.client = client;
            this.authCall = auth()
                    .login(MojioAuthApi.GRANT_TYPE_LOGIN, username, password, client.getKey(), client.getSecret());
        }

        @Override
        public Response<User> execute() throws IOException {
            long startTime = System.currentTimeMillis();
            Response<AuthResponse> response = authCall.execute();
            if (handleResponse(startTime, response)) {
                userCall = rest().getUser();
                return userCall.execute();
            } else {
                return (Response) response;
            }
        }

        @Override
        public void enqueue(final Callback<User> callback) {
            final long startTime = System.currentTimeMillis();
            authCall.enqueue(new Callback<AuthResponse>() {
                @Override
                public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                    try {
                        if (handleResponse(startTime, response)) {
                            userCall = rest().getUser();
                            userCall.enqueue(callback);
                        } else {
                            callback.onResponse((Call) authCall, (Response) response);
                        }
                    } catch (IOException e) {
                        onFailure(call, e);
                    }
                }

                @Override
                public void onFailure(Call<AuthResponse> call, Throwable t) {
                    callback.onFailure((Call) call, t);
                }
            });
        }

        @Override
        public boolean isExecuted() {
            return getCurrentCall().isExecuted();
        }

        @Override
        public void cancel() {
            getCurrentCall().cancel();
        }

        @Override
        public boolean isCanceled() {
            return getCurrentCall().isCanceled();
        }

        @Override
        public Call<User> clone() {
            return new LoginCall(username, password, client);
        }

        @Override
        public Request request() {
            return getCurrentCall().request();
        }

        private Call getCurrentCall() {
            return userCall == null ? authCall : userCall;
        }

        private boolean handleResponse(long startTime, Response<AuthResponse> response) throws IOException {
            if (response.isSuccessful()) {
                AuthResponse authResponse = response.body();
                AccessToken accessToken = new AccessToken(authResponse.getAccessToken(), authResponse.getRefreshToken(),
                        startTime + TimeUnit.SECONDS.toMillis(authResponse.getExpiresIn()));
                authenticator.setAccessToken(accessToken);
                return true;
            }
            return false;
        }
    }

}
