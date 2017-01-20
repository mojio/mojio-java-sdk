package io.moj.java.sdk;

import java.util.Map;

import io.moj.java.sdk.model.App;
import io.moj.java.sdk.model.Geofence;
import io.moj.java.sdk.model.Group;
import io.moj.java.sdk.model.Mojio;
import io.moj.java.sdk.model.Transaction;
import io.moj.java.sdk.model.Trip;
import io.moj.java.sdk.model.User;
import io.moj.java.sdk.model.Vehicle;
import io.moj.java.sdk.model.VehicleMeasure;
import io.moj.java.sdk.model.response.ListResponse;
import io.moj.java.sdk.model.response.MessageResponse;
import io.moj.java.sdk.model.response.TransactionResponse;
import io.moj.java.sdk.model.stream.ActivityObject;
import io.moj.java.sdk.model.stream.Settings;
import io.moj.java.sdk.model.values.AccessModel;
import io.moj.java.sdk.model.values.Aggregate;
import io.moj.java.sdk.model.values.DiagnosticCode;
import io.moj.java.sdk.model.values.DtcStatusUpdate;
import io.moj.java.sdk.model.values.Email;
import io.moj.java.sdk.model.values.Image;
import io.moj.java.sdk.model.values.Location;
import io.moj.java.sdk.model.values.NextServiceSchedule;
import io.moj.java.sdk.model.values.PhoneNumber;
import io.moj.java.sdk.model.values.ServiceScheduleList;
import io.moj.java.sdk.model.values.VehicleStatistics;
import io.moj.java.sdk.model.values.VinDetails;
import io.moj.java.sdk.model.values.WifiRadio;
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
public interface MojioRestApi {

    // region Apps
    @GET("apps")
    Call<ListResponse<App>> getApps();

    @GET("apps")
    Call<ListResponse<App>> getApps(@QueryMap Map<String, String> params);

    @GET("apps/{id}")
    Call<App> getApp(@Path("id") String appId);

    @GET("apps/{id}/secret")
    Call<String> getAppSecret(@Path("id") String appId);

    @POST("apps")
    Call<App> createApp(@Body App app);

    @PUT("apps/{id}")
    Call<App> updateApp(@Path("id") String appId, @Body App app);

    @DELETE("apps/{id}")
    Call<MessageResponse> deleteApp(@Path("id") String appId);

    @DELETE("apps/{id}/secret")
    Call<MessageResponse> deleteAppSecret(@Path("id") String appId);
    // endregion

    // region Geofences
    @GET("geofences")
    Call<ListResponse<Geofence>> getGeofences();

    @GET("geofences")
    Call<ListResponse<Geofence>> getGeofences(@QueryMap Map<String, String> params);

    @GET("geofences/{id}")
    Call<Geofence> getGeofence(@Path("id") String geofenceId);

    @POST("geofences")
    Call<Geofence> createGeofence(@Body Geofence geofence);

    @PUT("geofences/{id}")
    Call<Geofence> updateGeofence(@Path("id") String geofenceId, @Body Geofence geofence);

    @DELETE("geofences/{id}")
    Call<MessageResponse> deleteGeofence(@Path("id") String geofenceId);
    // endregion

    // region Groups
    @GET("groups")
    Call<ListResponse<Group>> getGroups();

    @GET("groups")
    Call<ListResponse<Group>> getGroups(@QueryMap Map<String, String> params);

    @GET("groups/{id}")
    Call<Group> getGroup(@Path("id") String groupId);

    @GET("groups/{id}/users")
    Call<ListResponse<User>> getGroupUsers(@Path("id") String groupId);

    @POST("groups")
    Call<Group> createGroup(@Body Group.Request group);

    @POST("groups/{id}/users")
    Call<Group> updateGroupUsers(@Path("id") String groupId, @Body String[] userIds);

    @PUT("groups/{id}/users")
    Call<Group> addGroupUser(@Path("id") String groupId, @Body String userId);

    @DELETE("groups/{id}/users")
    Call<Group> removeGroupUser(@Path("id") String groupId, @Query("removeUser") String userId);
    // endregion

    // region History
    @GET("trips/{id}/history/states")
    Call<ListResponse<VehicleMeasure>> getTripStates(@Path("id") String tripId);

    @GET("trips/{id}/history/states")
    Call<ListResponse<VehicleMeasure>> getTripStates(@Path("id") String tripId, @QueryMap Map<String, String> params);

    @GET("trips/{id}/history/states/{stateId}")
    Call<VehicleMeasure> getTripState(@Path("id") String tripId, @Path("stateId") String stateId);

    @GET("trips/{id}/history/states/{stateId}")
    Call<VehicleMeasure> getTripState(@Path("id") String tripId, @Path("stateId") String stateId, @QueryMap Map<String, String> params);

    @GET("trips/{id}/history/locations")
    Call<ListResponse<Location>> getTripLocations(@Path("id") String tripId);

    @GET("trips/{id}/history/locations")
    Call<ListResponse<Location>> getTripLocations(@Path("id") String tripId, @QueryMap Map<String, String> params);

    @GET("vehicles/{id}/history/states")
    Call<ListResponse<VehicleMeasure>> getVehicleStates(@Path("id") String vehicleId);

    @GET("vehicles/{id}/history/states")
    Call<ListResponse<VehicleMeasure>> getVehicleStates(@Path("id") String vehicleId, @QueryMap Map<String, String> params);

    @GET("vehicles/{id}/history/states/{stateId}")
    Call<VehicleMeasure> getVehicleState(@Path("id") String vehicleId, @Path("stateId") String stateId);

    @GET("vehicles/{id}/history/states/{stateId}")
    Call<VehicleMeasure> getVehicleState(@Path("id") String vehicleId, @Path("stateId") String stateId, @QueryMap Map<String, String> params);

    @GET("vehicles/{id}/history/locations")
    Call<ListResponse<Location>> getVehicleLocations(@Path("id") String vehicleId);

    @GET("vehicles/{id}/history/locations")
    Call<ListResponse<Location>> getVehicleLocations(@Path("id") String vehicleId, @QueryMap Map<String, String> params);
    // endregion

    // region Images
    @GET("apps/{id}/image")
    Call<Image> getAppImage(@Path("id") String appId);

    @GET("users/{id}/image")
    Call<Image> getUserImage(@Path("id") String userId);

    @GET("vehicles/{id}/image")
    Call<Image> getVehicleImage(@Path("id") String vehicleId);

    // TODO verify the body is supposed to be a Base64 string, write helper from File class
    @PUT("apps/{id}/image")
    Call<Image> uploadAppImage(@Path("id") String appId, @Body String imageBase64);

    @PUT("users/{id}/image")
    Call<Image> uploadUserImage(@Path("id") String userId, @Body String imageBase64);

    @PUT("vehicles/{id}/image")
    Call<Image> uploadVehicleImage(@Path("id") String vehicleId, @Body String imageBase64);

    @DELETE("apps/{id}/image")
    Call<MessageResponse> deleteAppImage(@Path("id") String appId);

    @DELETE("users/{id}/image")
    Call<MessageResponse> deleteUserImage(@Path("id") String userId);

    @DELETE("vehicles/{id}/image")
    Call<MessageResponse> deleteVehicleImage(@Path("id") String vehicleId);

    // endregion

    // region Mojios
    @GET("mojios")
    Call<ListResponse<Mojio>> getMojios();

    @GET("mojios")
    Call<ListResponse<Mojio>> getMojios(@QueryMap Map<String, String> params);

    @GET("mojios/{id}")
    Call<Mojio> getMojio(@Path("id") String mojioId);

    @POST("mojios")
    Call<Mojio> claimMojio(@Body Mojio mojio);

    @PUT("mojios/{id}")
    Call<Mojio> updateMojio(@Body Mojio mojio);

    @DELETE("mojios/{id}")
    Call<Mojio> unclaimMojio(@Path("id") String mojioId);

    @PUT("mojios/{id}/wifiradio")
    Call<TransactionResponse> updateMojioWifi(@Path("id") String mojioId, @Body WifiRadio wifiRadio);

    @GET("mojios/{id}/transactions/{transactionId}")
    Call<Transaction> getMojioTransaction(@Path("id") String mojioId, @Path("transactionId") String transactionId);
    // endregion

    // region Permissions
    @GET("{resource}/{id}/permission")
    Call<String[]> getPermissions(@Path("resource") String resource, @Path("id") String id);

    @GET("{resource}/{id}/permissions")
    Call<AccessModel[]> getAccessModels(@Path("resource") String resource, @Path("id") String id);

    @POST("{resource}/{id}/permissions")
    Call<AccessModel> updateAccessModel(@Path("resource") String resource, @Path("id") String id,
                                        @Body AccessModel accessModel);

    @PUT("{resource}/{id}/permissions")
    Call<AccessModel> addAccessModel(@Path("resource") String resource, @Path("id") String id,
                                     @Body AccessModel accessModel);

    @DELETE("{resource}/{id}/permissions")
    Call<MessageResponse> revokePermissions(@Path("resource") String resource, @Path("id") String id,
                                            @Query("groupId") String groupId);
    // endregion

    // region Tags
    @POST("{resource}/{id}/tags/{tag}")
    Call<String[]> addTag(@Path("resource") String resource, @Path("id") String id, @Path("tag") String tag);

    @DELETE("{resource}/{id}/tags/{tag}")
    Call<MessageResponse> deleteTag(@Path("resource") String resource, @Path("id") String id, @Path("tag") String tag);
    // endregion

    // region Trips
    @GET("trips")
    Call<ListResponse<Trip>> getTrips();

    @GET("trips")
    Call<ListResponse<Trip>> getTrips(@QueryMap Map<String, String> params);

    @GET("trips/{id}")
    Call<Trip> getTrip(@Path("id") String tripId);

    @PUT("trips/{id}")
    Call<MessageResponse> updateTrip(@Path("id") String tripId, @Body Trip trip);

    @DELETE("trips/{id}")
    Call<MessageResponse> deleteTrip(@Path("id") String tripId);
    // endregion

    // region Users
    @GET("users")
    Call<ListResponse<User>> getUsers();

    @GET("users")
    Call<ListResponse<User>> getUsers(@QueryMap Map<String, String> params);

    @GET("me")
    Call<User> getUser();

    @GET("users/{id}")
    Call<User> getUser(@Path("id") String userId);

    @GET("users/{id}/vehicles")
    Call<ListResponse<Vehicle>> getUserVehicles(@Path("id") String userId);

    @GET("users/{id}/vehicles")
    Call<ListResponse<Vehicle>> getUserVehicles(@Path("id") String userId, @QueryMap Map<String, String> params);

    @GET("users/{id}/mojios")
    Call<ListResponse<Mojio>> getUserMojios(@Path("id") String userId);

    @GET("users/{id}/mojios")
    Call<ListResponse<Mojio>> getUserMojios(@Path("id") String userId, @QueryMap Map<String, String> params);

    @GET("users/{id}/trips")
    Call<ListResponse<Trip>> getUserTrips(@Path("id") String userId);

    @GET("users/{id}/trips")
    Call<ListResponse<Trip>> getUserTrips(@Path("id") String userId, @QueryMap Map<String, String> params);

    @GET("users/{id}/groups")
    Call<ListResponse<Group>> getUserGroups(@Path("id") String userId);

    @GET("users/{id}/groups")
    Call<ListResponse<Group>> getUserGroups(@Path("id") String userId, @QueryMap Map<String, String> params);

    @PUT("users/{id}")
    Call<User> updateUser(@Path("id") String userId, @Body User user);

    @POST("users/{id}/emails")
    Call<Email> addUserEmail(@Path("id") String userId, @Body String email);

    @PUT("users/{id}/emails/{email}")
    Call<Email> updateEmail(@Path("id") String userId, @Path("email") String email);

    @DELETE("users/{id}/emails/{email}")
    Call<MessageResponse> deleteEmail(@Path("id") String userId, @Path("email") String email);

    @PUT("users/{id}/phonenumbers/{phone}")
    Call<PhoneNumber> addUpdatePhone(@Path("id") String userId, @Path("phone") String phoneNumber,
                                     @Query("sendverification") boolean sendCode);

    @DELETE("users/{id}/phonenumbers/{phone}")
    Call<MessageResponse> deletePhone(@Path("id") String userId, @Path("phone") String phoneNumber);

    @PUT("users/{id}/phonenumbers/{phone}")
    Call<PhoneNumber> verifyPin(@Path("id") String userId, @Path("phone") String phoneNumber,
                                @Query("pin") String pin);
    // endregion

    // region Vehicles
    @GET("vehicles")
    Call<ListResponse<Vehicle>> getVehicles();

    @GET("vehicles")
    Call<ListResponse<Vehicle>> getVehicles(@QueryMap Map<String, String> params);

    @GET("vehicles/{id}")
    Call<Vehicle> getVehicle(@Path("id") String vehicleId);

    @GET("vehicles/{id}/address")
    Call<Location> getVehicleLocation(@Path("id") String vehicleId);

    @GET("vehicles/{id}/trips")
    Call<ListResponse<Trip>> getVehicleTrips(@Path("id") String vehicleId);

    @GET("vehicles/{id}/trips")
    Call<ListResponse<Trip>> getVehicleTrips(@Path("id") String vehicleId, @QueryMap Map<String, String> params);

    @GET("vehicles/{id}/vin")
    Call<VinDetails> getVehicleVinDetails(@Path("id") String vehicleId);

    @GET("vehicles/{id}/serviceschedule")
    Call<ServiceScheduleList> getServiceSchedule(@Path("id") String vehicleId);

    @GET("vehicles/{id}/serviceschedule")
    Call<ServiceScheduleList> getServiceSchedule(@Path("id") String vehicleId, @QueryMap Map<String, String> params);

    @GET("vehicles/{id}/serviceschedule/next")
    Call<NextServiceSchedule> getNextServiceSchedule(@Path("id") String vehicleId);

    @GET("vehicles/{id}/serviceschedule/next")
    Call<NextServiceSchedule> getNextServiceSchedule(@Path("id") String vehicleId,
                                                               @Query("odometerInKm") Double odometerKm,
                                                               @Query("ageInMonths") Integer ageMonths);
    @POST("vehicles")
    Call<Vehicle> createVehicle(@Body Vehicle vehicle);

    @PUT("vehicles/{id}")
    Call<Vehicle> updateVehicle(@Path("id") String vehicleId, @Body Vehicle vehicle);

    @DELETE("vehicles/{id}")
    Call<MessageResponse> deleteVehicle(@Path("id") String vehicleId);

    @DELETE("vehicles/{id}")
    Call<MessageResponse> mergeVehicle(@Path("id") String vehicleId, @Query("actual") String mergeVehicleId);

    @PUT("vehicles/{id}/diagnosticcodes/{code}")
    Call<DiagnosticCode> updateDtc(@Path("id") String vehicleId, @Path("code") String dtcCode, @Body DtcStatusUpdate newStatus);
    // endregion

    // region Activity Streams
    @GET("users/activities")
    Call<ListResponse<ActivityObject>> getUserActivityStream();

    @GET("users/activities")
    Call<ListResponse<ActivityObject>> getUserActivityStream(@QueryMap Map<String, String> params);

    @GET("vehicles/{id}/activities/settings")
    Call<Settings> getVehicleActivitySettings(@Path("id") String vehicleId);

    @GET("vehicles/{id}/activities/settings")
    Call<Settings> getVehicleActivitySettings(@Path("id") String vehicleId, @QueryMap Map<String, String> params);

    @PUT("vehicles/{id}/activities/settings")
    Call<MessageResponse> updateVehicleActivitySettings(@Path("id") String vehicleId, @Body Settings settings);
    // endregion

    // region Aggregates & Statistics
    /**
     * Returns the values for the specified vehicle {@code measure} bucketed into a number of
     * {@link io.moj.java.sdk.model.values.Aggregate}s based on the {@link io.moj.java.sdk.Query#TOP} parameter.
     * @param vehicleId the ID of the vehicle to aggregate data for.
     * @param measure the vehicle measure to aggregate (e.g. {@link Vehicle#FUEL_EFFICIENCY}.
     * @param params the query parameter - this call requires the {@link io.moj.java.sdk.Query#top(int)} and
     *               {@link io.moj.java.sdk.Query#since(long)} parameters be specified.
     * @return
     */
    @GET("vehicles/{id}/aggregates/{measure}")
    Call<ListResponse<Aggregate>> getAggregate(@Path("id") String vehicleId, @Path("measure") String measure,
                                               @QueryMap Map<String, String> params);

    @GET("vehicles/{id}/statistics")
    Call<VehicleStatistics> getStatistics(@Path("id") String vehicleId);

    @GET("vehicles/{id}/statistics")
    Call<VehicleStatistics> getStatistics(@Path("id") String vehicleId, @QueryMap Map<String, String> params);
    // endregion

}
