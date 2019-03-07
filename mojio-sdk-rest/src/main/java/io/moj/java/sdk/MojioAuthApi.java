package io.moj.java.sdk;

/**
 * Created by skidson on 2016-04-13.
 */

import io.moj.java.sdk.model.request.ForgotPasswordRequest;
import io.moj.java.sdk.model.request.RegistrationRequest;
import io.moj.java.sdk.model.request.ResetPasswordRequest;
import io.moj.java.sdk.model.response.AuthResponse;
import io.moj.java.sdk.model.response.RegistrationResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Retrofit interface for the Mojio authentication API.
 * Created by skidson on 16-02-10.
 */
public interface MojioAuthApi {

    String GRANT_TYPE_PASSWORD = "password";
    String GRANT_TYPE_REFRESH = "refresh_token";
    String GRANT_TYPE_PHONE = "phone";
    String GRANT_TYPE_THIRD_PARTY = "ext_idp";

    /**
     * Endpoint for requesting an access token. Constructs the request body as follows:
     * "grant_type=password&password={password}&username={username}&client_id={client_id}&secret_key={secret_key}&scope=full",
     * see <a href="http://tools.ietf.org/html/rfc6749#section-4.3.2">RFC6749 - Section 4.3.2</a>
     * <br><br>
     * For refreshing: "grant_type=refresh_token&refresh_token={refresh_token}",
     * see <a href="http://tools.ietf.org/html/rfc6749#section-62">RFC6749 - Section 6</a>
     * @param grantType should be "password", use {@link #GRANT_TYPE_PASSWORD}. Only required
     *                  because https://github.com/square/retrofit/issues/951 hasn't been implemented
     * @param username
     * @param password
     * @param clientId
     * @param clientSecret
     * @param scope
     * @return
     */
    @POST("oauth2/token")
    @FormUrlEncoded
    Call<AuthResponse> login(@Field("grant_type") String grantType,
                             @Field("username") String username,
                             @Field("password") String password,
                             @Field("client_id") String clientId,
                             @Field("client_secret") String clientSecret,
                             @Field("scope") String scope);

    /**
     * Endpoint for requesting an access token. Constructs the request body as follows:
     * "grant_type=password&password={password}&username={username}&client_id={client_id}&secret_key={secret_key}&scope=full",
     * see <a href="http://tools.ietf.org/html/rfc6749#section-4.3.2">RFC6749 - Section 4.3.2</a>
     * <br><br>
     * For refreshing: "grant_type=refresh_token&refresh_token={refresh_token}",
     * see <a href="http://tools.ietf.org/html/rfc6749#section-62">RFC6749 - Section 6</a>
     * @param grantType should be "password", use {@link #GRANT_TYPE_PASSWORD}. Only required
     *                  because https://github.com/square/retrofit/issues/951 hasn't been implemented
     * @param provider
     * @param token
     * @param clientId
     * @param clientSecret
     * @param scope
     * @return
     */
    @POST("oauth2/token")
    @FormUrlEncoded
    Call<AuthResponse> loginToThirdParty(@Field("grant_type") String grantType,
                             @Field("provider") String provider,
                             @Field("token") String token,
                             @Field("client_id") String clientId,
                             @Field("client_secret") String clientSecret,
                             @Field("scope") String scope,
                             @Field("first_name") String firstName,
                             @Field("last_name") String lastName,
                             @Field("email") String email);

    /**
     * Endpoint for requesting an access token. Constructs the request body as follows:
     * "grant_type=phone&pin={pin}&phone_number={phone_number}&client_id={client_id}&secret_key={secret_key}&scope=full".
     * This is a custom extension of the OAuth spec (see
     * <a href="http://tools.ietf.org/html/rfc6749#section-62">RFC6749 - Section 6</a>)
     * <br><br>
     * For refreshing: "grant_type=refresh_token&refresh_token={refresh_token}",
     * see <a href="http://tools.ietf.org/html/rfc6749#section-62">RFC6749 - Section 6</a>
     * @param grantType should be "phone", use {@link #GRANT_TYPE_PHONE}. Only required
     *                  because https://github.com/square/retrofit/issues/951 hasn't been implemented
     * @param phoneNumber
     * @param pin
     * @param clientId
     * @param clientSecret
     * @return
     */
    @POST("oauth2/token")
    @FormUrlEncoded
    Call<AuthResponse> loginWithPin(@Field("grant_type") String grantType,
                                    @Field("phone_number") String phoneNumber,
                                    @Field("pin") String pin,
                                    @Field("client_id") String clientId,
                                    @Field("client_secret") String clientSecret,
                                    @Field("scope") String scope);

    /**
     * Endpoint for refreshing an access token. Constructs the request body as follows:
     * "grant_type=refresh_token&refresh_token={refresh_token}",
     * see <a href="http://tools.ietf.org/html/rfc6749#section-62">RFC6749 - Section 6</a>
     * @param grantType should be "refresh_token", use {@link #GRANT_TYPE_REFRESH}. Only required
     *                  because https://github.com/square/retrofit/issues/951 hasn't been implemented
     * @param refreshToken the refresh token that was granted with the original access token
     * @param clientId
     * @param clientSecret
     * @param device unique device id. It allows to implement two-factor authentication which
     *               permits certain API calls to the specific device. All attempts to use such API
     *               calls without an auth token with a device claim will lead to 403 error.
     * @return
     */
    @POST("oauth2/token")
    @FormUrlEncoded
    Call<AuthResponse> refresh(@Field("grant_type") String grantType,
                               @Field("refresh_token") String refreshToken,
                               @Field("client_id") String clientId,
                               @Field("client_secret") String clientSecret,
                               @Field("device") String device);

    /**
     * Endpoint for registering a user via phone number. Calling this endpoint will send a 4-digit PIN to the specified
     * phone number. This PIN should then be included in a follow-up call to
     * {@link #login(String, String, String, String, String)} with username = phone number, password = pin
     * @param auth String in the format 'Basic {Base64-Encoded "client_id:client_secret"}'
     * @param request
     * @return
     */
    @POST("account/register")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    Call<RegistrationResponse> register(@Header("Authorization") String auth, @Body RegistrationRequest request);

    /**
     * Endpoint for requesting a password reset token.
     * @param request
     * @return
     */
    @POST("account/forgot-password")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    Call<RegistrationResponse> forgotPassword(@Body ForgotPasswordRequest request);

    /**
     * Endpoint for resetting the password
     * @param auth String in the format 'Basic {Base64-Encoded "client_id:client_secret"}'
     * @param request
     * @return
     */
    @POST("account/reset-password")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json"
    })
    Call<RegistrationResponse> resetPassword(@Header("Authorization") String auth, @Body ResetPasswordRequest request);
}
