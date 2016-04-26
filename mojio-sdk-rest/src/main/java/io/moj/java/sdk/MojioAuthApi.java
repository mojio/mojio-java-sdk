package io.moj.java.sdk;

/**
 * Created by skidson on 2016-04-13.
 */
import io.moj.java.sdk.model.request.SMSRegistrationRequest;
import io.moj.java.sdk.model.request.SMSValidationRequest;
import io.moj.java.sdk.model.response.AuthResponse;
import io.moj.java.sdk.model.response.RegistrationResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Retrofit interface for the Mojio authentication API.
 * Created by skidson on 16-02-10.
 */
public interface MojioAuthApi {

    String GRANT_TYPE_LOGIN = "password";
    String GRANT_TYPE_REFRESH = "refresh_token";

    /**
     * Endpoint for requesting an access token. Constructs the request body as follows:
     * "grant_type=password&password={password}&username={username}&client_id={client_id}&secret_key={secret_key}&scope=full",
     * see <a href="http://tools.ietf.org/html/rfc6749#section-4.3.2">RFC6749 - Section 4.3.2</a>
     * <br><br>
     * For refreshing: "grant_type=refresh_token&refresh_token={refresh_token}",
     * see <a href="http://tools.ietf.org/html/rfc6749#section-62">RFC6749 - Section 6</a>
     * @param grantType should be "password", use {@link #GRANT_TYPE_LOGIN}. Only required
     *                  because https://github.com/square/retrofit/issues/951 hasn't been implemented
     * @param username
     * @param password
     * @param clientId
     * @param clientSecret
     * @return
     */
    @POST("oauth2/token")
    @FormUrlEncoded
    Call<AuthResponse> login(@Field("grant_type") String grantType,
                             @Field("username") String username,
                             @Field("password") String password,
                             @Field("client_id") String clientId,
                             @Field("client_secret") String clientSecret);

    /**
     * Endpoint for refreshing an access token. Constructs the request body as follows:
     * "grant_type=refresh_token&refresh_token={refresh_token}",
     * see <a href="http://tools.ietf.org/html/rfc6749#section-62">RFC6749 - Section 6</a>
     * @param grantType should be "refresh_token", use {@link #GRANT_TYPE_REFRESH}. Only required
     *                  because https://github.com/square/retrofit/issues/951 hasn't been implemented
     * @param refreshToken the refresh token that was granted with the original access token
     * @param clientId
     * @param clientSecret
     * @return
     */
    @POST("oauth2/token")
    @FormUrlEncoded
    Call<AuthResponse> refresh(@Field("grant_type") String grantType,
                               @Field("refresh_token") String refreshToken,
                               @Field("client_id") String clientId,
                               @Field("client_secret") String clientSecret);

    /**
     * Endpoint for registering a user via phone number. Calling this endpoint will send a 4-digit PIN to the specified
     * phone number. This PIN should then be included in a follow-up call to
     * {@link #validate(io.moj.java.sdk.model.request.SMSValidationRequest)}.
     * @param request
     * @return
     */
    @POST("api/register")
    Call<RegistrationResponse> register(@Body SMSRegistrationRequest request);

    /**
     * Endpoint for completing registration of a user via SMS using a 4-digit PIN sent from a previous call to
     * {@link #register(io.moj.java.sdk.model.request.SMSRegistrationRequest)}
     * @param request
     * @return
     */
    @PUT("api/register")
    Call<AuthResponse> validate(@Body SMSValidationRequest request);

}
