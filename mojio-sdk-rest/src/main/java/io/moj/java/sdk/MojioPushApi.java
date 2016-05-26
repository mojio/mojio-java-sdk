package io.moj.java.sdk;

import io.moj.java.sdk.model.push.Observer;
import io.moj.java.sdk.model.response.ListResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Retrofit interface for the Mojio PUSH API.
 * Created by skidson on 2016-04-15.
 */
public interface MojioPushApi {

    /**
     * Returns all observers for the specified resource that are accessible to the authenticated user. Note: only
     * {@link io.moj.java.sdk.Resource#MOJIO}, {@link io.moj.java.sdk.Resource#USER}, and
     * {@link io.moj.java.sdk.Resource#VEHICLE} resources can be observed.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @return
     * @see io.moj.java.sdk.Resource#getPath()
     */
    @GET("{resource}")
    Call<ListResponse<Observer>> getObservers(@Path("resource") String resource);

    /**
     * Returns all observers for the specified resource that are accessible to the authenticated user. Note: only
     * {@link io.moj.java.sdk.Resource#MOJIO}, {@link io.moj.java.sdk.Resource#USER}, and
     * {@link io.moj.java.sdk.Resource#VEHICLE} resources can be observed.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @param resourceId the ID of the specified resource
     * @return
     * @see io.moj.java.sdk.Resource#getPath()
     */
    @GET("{resource}/{id}")
    Call<ListResponse<Observer>> getObservers(@Path("resource") String resource, @Path("id") String resourceId);

    /**
     * Returns the observer for the specified resource corresponding to the provided key. Note: only
     * {@link io.moj.java.sdk.Resource#MOJIO}, {@link io.moj.java.sdk.Resource#USER}, and
     * {@link io.moj.java.sdk.Resource#VEHICLE} resources can be observed.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @param resourceId the ID of the specified resource
     * @param key
     * @return
     * @see io.moj.java.sdk.Resource#getPath()
     */
    @GET("{resource}/{id}/{key}")
    Call<Observer> getObservers(@Path("resource") String resource, @Path("id") String resourceId,
                                              @Path("key") String key);

    /**
     * Creates an observer for the specified resource(s). Note: only
     * {@link io.moj.java.sdk.Resource#MOJIO}, {@link io.moj.java.sdk.Resource#USER}, and
     * {@link io.moj.java.sdk.Resource#VEHICLE} resources can be observed.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @return
     * @see io.moj.java.sdk.Resource#getPath()
     */
    @PUT("{resource}")
    Call<Observer> createObserver(@Path("resource") String resource, @Body Observer observer);

    /**
     * Creates an observer for the specified resource. Note: only
     * {@link io.moj.java.sdk.Resource#MOJIO}, {@link io.moj.java.sdk.Resource#USER}, and
     * {@link io.moj.java.sdk.Resource#VEHICLE} resources can be observed.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @param resourceId the ID of the specified resource
     * @return
     * @see io.moj.java.sdk.Resource#getPath()
     */
    @PUT("{resource}/{id}")
    Call<Observer> createObserver(@Path("resource") String resource, @Path("id") String resourceId,
                                  @Body Observer observer);

    /**
     * Updates the observer with the specified key. Note: only {@link io.moj.java.sdk.Resource#MOJIO},
     * {@link io.moj.java.sdk.Resource#USER}, and {@link io.moj.java.sdk.Resource#VEHICLE} resources can be observed.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @param key the ID of the specified resource
     * @param observer the updated {@link io.moj.java.sdk.model.push.Observer}
     * @return
     * @see io.moj.java.sdk.Resource#getPath()
     */
    @PUT("{resource}/{key}")
    Call<Observer> updateObserver(@Path("resource") String resource, @Path("key") String key, @Body Observer observer);

    /**
     * Updates the observer with the specified key for the specified resource. Note: only
     * {@link io.moj.java.sdk.Resource#MOJIO}, {@link io.moj.java.sdk.Resource#USER}, and
     * {@link io.moj.java.sdk.Resource#VEHICLE} resources can be observed.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @param resourceId the ID of the specified resource
     * @param key the ID of the specified resource
     * @param observer the updated {@link io.moj.java.sdk.model.push.Observer}
     * @return
     * @see io.moj.java.sdk.Resource#getPath()
     */
    @PUT("{resource}/{id}/{key}")
    Call<Observer> createObserver(@Path("resource") String resource, @Path("id") String resourceId,
                                  @Path("key") String key, @Body Observer observer);

}
