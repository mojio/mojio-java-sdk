package io.moj.java.sdk;

import io.moj.java.sdk.model.push.Observer;
import io.moj.java.sdk.model.push.Transport;
import io.moj.java.sdk.model.response.MessageResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

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
    Call<Observer[]> getObservers(@Path("resource") String resource);

    /**
     * Creates an observer for the specified resource(s). Note: only
     * {@link io.moj.java.sdk.Resource#MOJIO}, {@link io.moj.java.sdk.Resource#USER}, and
     * {@link io.moj.java.sdk.Resource#VEHICLE} resources can be observed.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @return
     * @see io.moj.java.sdk.Resource#getPath()
     */
    @POST("{resource}")
    Call<Observer> createObserver(@Path("resource") String resource, @Body Observer observer);

    /**
     * Returns an observer for the specified resource that are accessible to the authenticated user. Note: only
     * {@link io.moj.java.sdk.Resource#MOJIO}, {@link io.moj.java.sdk.Resource#USER}, and
     * {@link io.moj.java.sdk.Resource#VEHICLE} resources can be observed.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @param resourceId the ID of the specified resource
     * @return
     * @see io.moj.java.sdk.Resource#getPath()
     */
    @GET("{resource}/{id}")
    Call<Observer[]> getObservers(@Path("resource") String resource, @Path("id") String resourceId);

    /**
     * Creates an observer for the specified resource. Note: only
     * {@link io.moj.java.sdk.Resource#MOJIO}, {@link io.moj.java.sdk.Resource#USER}, and
     * {@link io.moj.java.sdk.Resource#VEHICLE} resources can be observed.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @param resourceId the ID of the specified resource
     * @return
     * @see io.moj.java.sdk.Resource#getPath()
     */
    @POST("{resource}/{id}")
    Call<Observer> createObserver(@Path("resource") String resource, @Path("id") String resourceId,
                                  @Body Observer observer);

    /**
     * Returns all observers for the specified resource that are accessible to the authenticated user. Note: only
     * {@link io.moj.java.sdk.Resource#MOJIO}, {@link io.moj.java.sdk.Resource#USER}, and
     * {@link io.moj.java.sdk.Resource#VEHICLE} resources can be observed.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @param key the key of the observer to get
     * @return
     * @see io.moj.java.sdk.Resource#getPath()
     */
    @GET("{resource}/{key}")
    Call<Observer> getObserver(@Path("resource") String resource, @Path("key") String key);

    /**
     * Creates or updates an observer with the specified key. Note: only {@link io.moj.java.sdk.Resource#MOJIO},
     * {@link io.moj.java.sdk.Resource#USER}, and {@link io.moj.java.sdk.Resource#VEHICLE} resources can be observed.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @param key the key of the observer to update
     * @param observer the updated {@link io.moj.java.sdk.model.push.Observer}
     * @return
     * @see io.moj.java.sdk.Resource#getPath()
     */
    @PUT("{resource}/{key}")
    Call<Observer> updateObserver(@Path("resource") String resource, @Path("key") String key, @Body Observer observer);

    /**
     * Deletes an observer.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @param key the key of the observer to update
     * @return
     */
    @DELETE("{resource}/{key}")
    Call<Void> deleteObserver(@Path("resource") String resource, @Path("key") String key);

    /**
     * Deletes an observer.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @param id the resource ID
     * @param key the key of the observer to update
     * @return
     */
    @DELETE("{resource}/{id}/{key}")
    Call<MessageResponse> deleteObserver(@Path("resource") String resource, @Path("id") String id, @Path("key") String key);

    /**
     * Returns an observer for the specified resource, id and key that are accessible to the authenticated user. Note: only
     * {@link io.moj.java.sdk.Resource#MOJIO}, {@link io.moj.java.sdk.Resource#USER}, and
     * {@link io.moj.java.sdk.Resource#VEHICLE} resources can be observed.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @param resourceId the ID of the specified resource
     * @param key the key of the specified resource
     * @return
     * @see io.moj.java.sdk.Resource#getPath()
     */
    @GET("{resource}/{id}/{key}")
    Call<Observer> getObserver(@Path("resource") String resource, @Path("id") String resourceId, @Path("key") String key);

    /**
     * Creates or Updates an observer for the specified resource and Id. Note: only
     * {@link io.moj.java.sdk.Resource#MOJIO}, {@link io.moj.java.sdk.Resource#USER}, and
     * {@link io.moj.java.sdk.Resource#VEHICLE} resources can be observed.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @param resourceId the ID of the specified resource
     * @param key the key of the specified resource
     * @return
     * @see io.moj.java.sdk.Resource#getPath()
     */
    @PUT("{resource}/{id}/{key}")
    Call<Observer> updateObserver(@Path("resource") String resource, @Path("id") String resourceId, @Path("key") String key,
                                  @Body Observer observer);

    /**
     * Gets the transports for an observer.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @param key the key of the observer
     * @return
     */
    @GET("{resource}/{key}/transports")
    Call<Transport[]> getTransports(@Path("resource") String resource, @Path("key") String key);

    /**
     * Adds or updates a transport to an observer.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @param key the key of the observer
     * @return
     */
    @PUT("{resource}/{key}/transports")
    Call<Transport> addTransport(@Path("resource") String resource, @Path("key") String key, @Body Transport transport);

    /**
     * Deletes a transport from an observer.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @param key the key of the observer to update
     * @param transportId the transport ID. This ID is a URI constructed based on the Transport type.
     * @return
     */
    @DELETE("{resource}/{key}/transports")
    Call<MessageResponse> deleteTransport(@Path("resource") String resource, @Path("key") String key,
                                          @Query("id") String transportId);

    /**
     * Deletes a transport from an observer.
     * @param resource String path for the specified resource. See {@link io.moj.java.sdk.Resource#getPath()}.
     * @param resourceId the ID of the specified resource
     * @param key the key of the observer to update
     * @param transportId the transport ID. This ID is a URI constructed based on the Transport type.
     * @return
     */
    @DELETE("{resource}/{resourceId}/{key}/transports")
    Call<MessageResponse> deleteTransport(@Path("resource") String resource, @Path("resourceId") String resourceId,
                                          @Path("key") String key, @Query("id") String transportId);

    /**
     * Deletes all instances of a transport from all observers (for this application).
     * @param transportId the transport ID. This ID is a URI constructed based on the Transport type. See
     * {@link io.moj.java.sdk.model.push.Transport.Type#getIdentifier(String...)}.
     * @return
     */
    @DELETE("transports")
    Call<MessageResponse> deleteTransports(@Query("id") String transportId);

}
