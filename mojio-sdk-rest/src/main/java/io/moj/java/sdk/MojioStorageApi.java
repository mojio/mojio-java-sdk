package io.moj.java.sdk;

import java.util.Map;

import io.moj.java.sdk.model.App;
import io.moj.java.sdk.model.Group;
import io.moj.java.sdk.model.Mojio;
import io.moj.java.sdk.model.Trip;
import io.moj.java.sdk.model.User;
import io.moj.java.sdk.model.Vehicle;
import io.moj.java.sdk.model.response.ListResponse;
import io.moj.java.sdk.model.response.MessageResponse;
import io.moj.java.sdk.model.values.AccessModel;
import io.moj.java.sdk.model.values.Image;
import io.moj.java.sdk.model.values.Location;
import io.moj.java.sdk.model.values.PhoneNumber;
import io.moj.java.sdk.model.values.ServiceSchedule;
import io.moj.java.sdk.model.values.VehicleMeasure;
import io.moj.java.sdk.model.values.VinDetails;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Retrofit interface for the Mojio REST API.
 * Created by skidson on 16-02-09.
 */
@SuppressWarnings("unused")
public interface MojioStorageApi {


    // region Storage
    @GET("{resource}/{id}/store")
    Call<String[]> getStorage(@Path("resource") String resource, @Path("id") String id, @QueryMap Map<String, Integer> params);

    @DELETE("{resource}/{id}/store/{key}")
    Call<String[]> deleteStorage(@Path("resource") String resource, @Path("id") String id, @Path("key") String key);

    @GET("{resource}/{id}/store/{key}")
    Call<String> getStorageValue(@Path("resource") String resource, @Path("id") String id, @Path("key") String key);

    @POST("{resource}/{id}/store/{key}")
    Call<String[]> createStorage(@Path("resource") String resource, @Path("id") String id, @Path("key") String key,
                                        @Body String storageValue);

    @PUT("{resource}/{id}/store/{key}")
    Call<String[]> updateStorage(@Path("resource") String resource, @Path("id") String id, @Path("key") String key,
                                     @Body String storageValue);
    // endregion

}

