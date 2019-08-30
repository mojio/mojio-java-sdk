package io.moj.java.sdk;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import io.moj.java.sdk.auth.AccessToken;
import io.moj.java.sdk.auth.AuthInterceptor;
import io.moj.java.sdk.auth.Authenticator;
import io.moj.java.sdk.auth.Client;
import io.moj.java.sdk.auth.DefaultAuthenticator;
import io.moj.java.sdk.auth.DeviceIdProvider;
import io.moj.java.sdk.auth.OnAccessTokenExpiredListener;
import io.moj.java.sdk.logging.LoggingInterceptor;
import io.moj.java.sdk.model.User;
import io.moj.java.sdk.model.interfaces.Base64Decoder;
import io.moj.java.sdk.model.response.AuthResponse;
import io.moj.java.sdk.model.response.RegistrationResponse;
import io.moj.java.sdk.utils.DefaultBase64Decoder;
import io.moj.java.sdk.websocket.MojioWebSocket;
import io.moj.java.sdk.websocket.MojioWebSocketApi;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Client for authenticating and making calls against the Mojio API.
 * Created by skidson on 2016-04-12.
 */
public class MojioClient {

    private static final String TAG = "Mojio";

    private final Environment environment;
    private final Executor callbackExecutor;
    private final ExecutorService requestExecutor;
    private final Gson gson;
    private final Base64Decoder base64Decoder;
    private final Client client;
    private final boolean loggingEnabled;
    private final Integer timeout;
    private final List<String> acceptedTenants;
    private final DeviceIdProvider deviceIdProvider;

    private MojioRestApi restApi;
    private MojioAuthApi authApi;
    private MojioPushApi pushApi;
    private MojioWebSocketApi wsApi;
    private MojioStorageApi storageApi;
    private Authenticator authenticator;
    private AuthInterceptor authInterceptor;
    private Interceptor clientInterceptor;

    private OkHttpClient[] httpClients;

    protected MojioClient(Environment environment, Client client, Gson gson, Base64Decoder base64Decoder, Authenticator authenticator,
                          Interceptor interceptor, ExecutorService requestExecutor, Executor callbackExecutor,
                          boolean logging, Integer timeout, List<String> acceptedTenants, String userAgent,
                          DeviceIdProvider deviceIdProvider) {
        this.environment = environment == null ? MojioEnvironment.getDefault() : environment;
        this.gson = gson == null ? new Gson() : gson;
        this.base64Decoder = base64Decoder == null ? new DefaultBase64Decoder() : base64Decoder;
        this.client = client;
        this.loggingEnabled = logging;
        this.callbackExecutor = callbackExecutor;
        this.requestExecutor = requestExecutor;
        this.timeout = timeout;
        this.acceptedTenants = acceptedTenants;
        this.clientInterceptor = interceptor;
        this.deviceIdProvider = deviceIdProvider;

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(this.gson);
        if (logging) {
            httpClientBuilder.addInterceptor(new LoggingInterceptor(TAG));
        }

        if (interceptor != null) {
            httpClientBuilder.addInterceptor(interceptor);
        }

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .addConverterFactory(gsonConverterFactory);
        if (callbackExecutor != null) {
            retrofitBuilder.callbackExecutor(callbackExecutor);
        }

        if (requestExecutor != null) {
            httpClientBuilder.dispatcher(new Dispatcher(requestExecutor));
        }

        if (timeout != null) {
            httpClientBuilder.connectTimeout(timeout, TimeUnit.MILLISECONDS);
            httpClientBuilder.readTimeout(timeout, TimeUnit.MILLISECONDS);
            httpClientBuilder.writeTimeout(timeout, TimeUnit.MILLISECONDS);
        }

        httpClientBuilder.addInterceptor(new MojioInterceptor(userAgent));

        httpClients = new OkHttpClient[2];
        httpClients[0] = httpClientBuilder.build();

        authApi = retrofitBuilder
                .baseUrl(this.environment.getAccountsUrl() + "/")
                .client(httpClients[0])
                .build()
                .create(MojioAuthApi.class);

        // configure subsequent clients with the AuthInterceptor
        if (authenticator == null) {
            authenticator = new DefaultAuthenticator(authApi, client, deviceIdProvider);
        }
        this.authenticator = authenticator;
        authInterceptor = new AuthInterceptor(authenticator);
        httpClientBuilder.addInterceptor(authInterceptor);
        httpClients[1] = httpClientBuilder.build();
        retrofitBuilder.client(httpClients[1]);

        initAuthenticatedApis(retrofitBuilder);
    }

    protected void initAuthenticatedApis(Retrofit.Builder retrofitBuilder) {
        restApi = retrofitBuilder
                .baseUrl(this.environment.getApiUrl() + "/")
                .build()
                .create(MojioRestApi.class);
        pushApi = retrofitBuilder
                .baseUrl(this.environment.getPushUrl() + "/")
                .build()
                .create(MojioPushApi.class);
        storageApi = retrofitBuilder
                .baseUrl(this.environment.getApiUrl(1) + "/")
                .build()
                .create(MojioStorageApi.class);

        wsApi = new MojioWebSocket(this.environment.getWsUrl(), authenticator);
    }

    /**
     * Authenticates a user, stores the access token in the client's configured
     * {@link io.moj.java.sdk.auth.Authenticator}, and then returns the {@link io.moj.java.sdk.model.User} entity.
     * @param username
     * @param password
     * @return
     */
    public Call<User> login(String username, String password) {
        return new LoginCall(username, password, client, acceptedTenants, null);
    }

    /**
     * Authenticates a user, stores the access token in the client's configured
     * {@link io.moj.java.sdk.auth.Authenticator}, and then returns the {@link io.moj.java.sdk.model.User} entity.
     * @param username
     * @param password
     * @return
     */
    public Call<User> login(String username, String password, String scope) {
        return new LoginCall(username, password, client, acceptedTenants, scope);
    }

    /**
     * Authenticates a user, stores the access token in the client's configured
     * {@link io.moj.java.sdk.auth.Authenticator}, and then returns the {@link io.moj.java.sdk.model.User} entity.
     * @param provider
     * @param token
     * @return
     */
    public Call<User> loginToThirdParty(String provider, String token, String firstName, String lastName, String email) {
        return new ThirdPartyLoginCall(provider, token, firstName, lastName, email, client, acceptedTenants, null);
    }

    /**
     * Authenticates a user, stores the access token in the client's configured
     * {@link io.moj.java.sdk.auth.Authenticator}, and then returns the {@link io.moj.java.sdk.model.User} entity.
     * @param provider
     * @param token
     * @return
     */
    public Call<User> loginToThirdParty(String provider, String token, String firstName, String lastName, String email, String scope) {
        return new ThirdPartyLoginCall(provider, token, firstName, lastName, email, client, acceptedTenants, scope);
    }

    /**
     * Authenticates a user, stores the access token in the client's configured
     * {@link io.moj.java.sdk.auth.Authenticator}, and then returns the {@link io.moj.java.sdk.model.User} entity.
     * @param phoneNumber
     * @param pin
     * @return
     */
    public Call<User> loginWithPin(String phoneNumber, String pin) {
        return new LoginCall(phoneNumber, pin, true, client, acceptedTenants, null);
    }

    /**
     * Returns the {@link io.moj.java.sdk.MojioAuthApi} interface for making direct calls to the Mojio AUTH API.
     * @return
     */
    public MojioAuthApi auth() {
        return authApi;
    }

    /**
     * Returns the {@link io.moj.java.sdk.MojioRestApi} interface for making direct calls to the Mojio REST API.
     * @return
     */
    public MojioRestApi rest() {
        return restApi;
    }

    /**
     * Returns the {@link io.moj.java.sdk.MojioPushApi} interface for making direct calls to the Mojio PUSH API.
     * @return
     */
    public MojioPushApi push() {
        return pushApi;
    }

    /**
     * Returns the {@link io.moj.java.sdk.MojioStorageApi} interface for making direct calls to the Mojio STORAGE API.
     * @return
     */
    public MojioStorageApi storage() {
        return storageApi;
    }

    public MojioWebSocketApi webSocket() { return wsApi; }

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
     * Returns the timeout, if set.
     * @return
     */
    public Integer getTimeout() {
        return timeout;
    }

    /**
     * Returns the {@link io.moj.java.sdk.auth.Authenticator} this client is configured with.
     * @return
     */
    protected Authenticator getAuthenticator() {
        return authenticator;
    }

    /**
     * Returns the callback executor this client is configured with.
     * @return
     */
    protected Executor getCallbackExecutor() {
        return callbackExecutor;
    }

    /**
     * Returns the request executor this client is configured with.
     * @return
     */
    protected ExecutorService getRequestExecutor() {
        return requestExecutor;
    }

    /**
     * Returns the {@link com.google.gson.Gson} this client is configured with.
     * @return
     */
    protected Gson getGson() {
        return gson;
    }

    /**
     * Returns the {@link okhttp3.Interceptor} this client is configured with.
     * @return
     */
    protected Interceptor getClientInterceptor() {
        return clientInterceptor;
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
     * Cancels all outstanding requests.
     */
    public void cancelAll() {
        for (OkHttpClient httpClient : httpClients) {
            httpClient.dispatcher().cancelAll();
        }
    }

    /**
     * Returns the number of calls pending execution (includes calls that are currently running or queued).
     * @return the number of pending calls
     */
    public int getPendingCallCount() {
        int count = 0;
        for (OkHttpClient httpClient : httpClients) {
            count += httpClient.dispatcher().runningCallsCount();
            count += httpClient.dispatcher().queuedCallsCount();
        }
        return count;
    }

    /**
     * Builder for a {@link io.moj.java.sdk.MojioClient}.
     */
    public static class Builder {
        protected Environment environment;
        protected Authenticator authenticator;
        protected Interceptor interceptor;
        protected Client client;
        protected Executor callbackExecutor;
        protected ExecutorService requestExecutor;
        protected Gson gson;
        protected Base64Decoder base64Decoder;
        protected Integer timeout;
        protected boolean logging = false;
        protected List<String> acceptedTenants = new ArrayList<>();
        protected String userAgent;
        protected DeviceIdProvider deviceIdProvider;

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
         * Configures an interceptor for each request and response. It is recommended to configure read-only
         * interceptors only as modifying outgoing requests or incoming responses may interfere with the SDK's
         * functionality.
         * @param interceptor
         * @return
         */
        public Builder interceptor(Interceptor interceptor) {
            this.interceptor = interceptor;
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

        public Builder base64Decoder(Base64Decoder base64Decoder) {
            this.base64Decoder = base64Decoder;
            return this;
        }

        /**
         * Configures the connection, read, and write timeout in milliseconds.
         * @param timeout
         * @return
         */
        public Builder timeout(Integer timeout) {
            this.timeout = timeout;
            return this;
        }

        /**
         * Configures the client to execute callbacks on the specified {@link java.util.concurrent.Executor}.
         * @param executor
         * @return
         */
        public Builder callbackExecutor(Executor executor) {
            this.callbackExecutor = executor;
            return this;
        }

        /**
         * Configures the client to execute requests on the specified {@link java.util.concurrent.ExecutorService}.
         * @param executor
         * @return
         */
        public Builder requestExecutor(ExecutorService executor) {
            this.requestExecutor = executor;
            return this;
        }

        /**
         * Configures the list of tenant IDs that are accepted by the application. If not specified, the
         * application will accept all tenant IDs.
         * @param acceptedTenants
         * @return
         */
        public Builder acceptedTenants(List<String> acceptedTenants) {
            this.acceptedTenants.clear();
            if (acceptedTenants != null) {
                this.acceptedTenants.addAll(acceptedTenants);
            }
            return this;
        }

        /**
         * @param userAgent User-Agent header to be added to the requests
         */
        public Builder userAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        public Builder deviceIdProvider(DeviceIdProvider deviceIdProvider) {
            this.deviceIdProvider = deviceIdProvider;
            return this;
        }

        /**
         * Constructs a {@link io.moj.java.sdk.MojioClient} instance with the provided configuration.
         * @return
         */
        public MojioClient build() {
            return new MojioClient(environment, client, gson, base64Decoder, authenticator, interceptor,
                    requestExecutor, callbackExecutor, logging, timeout, acceptedTenants, userAgent,
                    deviceIdProvider);
        }
    }

    /**
     * Wrapper for an authentication call that stores the access token in this client's
     * {@link io.moj.java.sdk.auth.Authenticator} and then follows with a call to get the current User.
     */
    private class LoginCall extends BaseLoginCall {
        private static final String DEFAULT_SCOPE = "full offline_access";

        private String id;
        private String password;
        private boolean usingPin;
        private List<String> acceptedTenants;
        private String scope;
        private Client client;

        public LoginCall(String id, String password, Client client, List<String> acceptedTenants, String scope) {
            this(id, password, false, client, acceptedTenants, scope);
        }

        public LoginCall(String id, String password, boolean usingPin, Client client, List<String> acceptedTenants, String scope) {
            super(acceptedTenants, usingPin
                    ? auth().loginWithPin(MojioAuthApi.GRANT_TYPE_PHONE, id, password, client.getKey(), client.getSecret(), scope == null ? DEFAULT_SCOPE : scope)
                    : auth().login(MojioAuthApi.GRANT_TYPE_PASSWORD, id, password, client.getKey(), client.getSecret(), scope == null ? DEFAULT_SCOPE : scope));
            this.id = id;
            this.password = password;
            this.usingPin = usingPin;
            this.client = client;
            this.acceptedTenants = acceptedTenants;
            this.scope = scope;
        }

        @Override
        public Call<User> clone() {
            return new LoginCall(id, password, usingPin, client, acceptedTenants, scope);
        }
    }

    /**
     * Wrapper for an authentication call that stores the access token in this client's
     * {@link io.moj.java.sdk.auth.Authenticator} and then follows with a call to get the current User.
     */
    private class ThirdPartyLoginCall extends BaseLoginCall {
        private static final String DEFAULT_SCOPE = "full offline_access";

        private String provider;
        private String token;
        private String firstName;
        private String lastName;
        private String email;
        private List<String> acceptedTenants;
        private String scope;
        private Client client;

        public ThirdPartyLoginCall(String provider, String token, String firstName, String lastName, String email, Client client, List<String> acceptedTenants, String scope) {
            super(acceptedTenants, auth().loginToThirdParty(MojioAuthApi.GRANT_TYPE_THIRD_PARTY, provider, token, client.getKey(), client.getSecret(), scope == null ? DEFAULT_SCOPE : scope, firstName, lastName, email));
            this.provider = provider;
            this.token = token;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.client = client;
            this.scope = scope;
            this.acceptedTenants = acceptedTenants;
        }

        @Override
        public Call<User> clone() {
            return new ThirdPartyLoginCall(provider, token, firstName, lastName, email, client, acceptedTenants, scope);
        }
    }

    public abstract class BaseLoginCall implements Call<User> {
        private List<String> acceptedTenants;
        private Call<User> userCall;
        private Call<AuthResponse> authCall;

        public BaseLoginCall(List<String> acceptedTenants, Call<AuthResponse> authCall) {
            this.acceptedTenants = acceptedTenants;
            this.authCall = authCall;
        }

        @Override
        public Response<User> execute() throws IOException {
            long startTime = System.currentTimeMillis();
            Response<AuthResponse> response = authCall.execute();
            if (!passesTenancyTest(response)) {
                return getInvalidTenantErrorResponse();
            }
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
                    if (!passesTenancyTest(response)) {
                        callback.onResponse(BaseLoginCall.this, getInvalidTenantErrorResponse());
                        return;
                    }
                    try {
                        if (handleResponse(startTime, response)) {
                            userCall = rest().getUser();
                            userCall.enqueue(callback);
                        } else {
                            callback.onResponse(BaseLoginCall.this, (Response) response);
                        }
                    } catch (IOException e) {
                        onFailure(call, e);
                    }
                }

                @Override
                public void onFailure(Call<AuthResponse> call, Throwable t) {
                    callback.onFailure(BaseLoginCall.this, t);
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
        public Request request() {
            return getCurrentCall().request();
        }

        @Override
        public Call<User> clone() {
            return null;
        }

        private Call getCurrentCall() {
            return userCall == null ? authCall : userCall;
        }

        private boolean passesTenancyTest(Response<AuthResponse> response) {
            if (acceptedTenants == null || acceptedTenants.isEmpty()) {
                return true;
            } else {
                if (response != null && response.isSuccessful()) {
                    AuthResponse authResponse = response.body();
                    String token = authResponse.getAccessToken();
                    String tenantId = getTenantId(token);
                    if (tenantId != null && acceptedTenants.contains(tenantId)) {
                        return true;
                    }
                }
                return false;
            }
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

        private Response<User> getInvalidTenantErrorResponse() {
            RegistrationResponse.Error error = new RegistrationResponse.Error();
            RegistrationResponse registrationResponse = new RegistrationResponse();
            registrationResponse.setErrors(Collections.singletonList(error));
            ResponseBody errorBody = ResponseBody.create(MediaType.parse("application/json"), gson.toJson(registrationResponse));
            return Response.error(403, errorBody);
        }

        private String getTenantId(String token) {
            if (token == null)
                return null;

            String[] parts = token.split("\\.");
            if (parts.length < 2)
                return null;

            String payload = parts[1];
            if (payload == null)
                return null;

            String decoded = base64Decoder.decodeBase64(payload);
            if (decoded == null)
                return null;

            try {
                Type type = new TypeToken<Map<String, Object>>() {
                }.getType();
                Map<String, Object> jwtPayload = gson.fromJson(decoded, type);
                return (String) jwtPayload.get("tenant");
            } catch (JsonSyntaxException ignored) {
                return null;
            }
        }
    }
}
