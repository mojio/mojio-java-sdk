package io.moj.java.sdk;

import java.util.Map;

import io.moj.java.sdk.model.response.ListResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Retrofit interface for the Mojio REST API.
 * Created by skidson on 16-02-09.
 */
@SuppressWarnings("unused")
public interface MojioStorageApi {


    // region Storage
    @GET("{resource}/{id}/store")
    Call<ListResponse<Map<String, String>>> getStorage(@Path("resource") String resource, @Path("id") String id, @QueryMap Map<String, Integer> params);

    @DELETE("{resource}/{id}/store/{key}")
    Call<String> deleteStorage(@Path("resource") String resource, @Path("id") String id, @Path("key") String key);

    @GET("{resource}/{id}/store/{key}")
    Call<String> getStorageValue(@Path("resource") String resource, @Path("id") String id, @Path("key") String key);

    @POST("{resource}/{id}/store/{key}")
    Call<String> createStorage(@Path("resource") String resource, @Path("id") String id, @Path("key") String key,
                                        @Body String storageValue);

    @PUT("{resource}/{id}/store/{key}")
    Call<String> updateStorage(@Path("resource") String resource, @Path("id") String id, @Path("key") String key,
                                     @Body String storageValue);
    // endregion

}

