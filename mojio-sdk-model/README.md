## Disclaimer ##
**UNDER ACTIVE DEVELOPMENT**

This SDK is built against the v2 APIs which are still in development and not ready for general consumption.

* Methods may change without notice
* Currently provided "AS IS"

# Mojio Java Model SDK #

Model classes for use with the Mojio REST API. These objects are annotated for serialization with GSON. The Model SDK
can be plugged into your existing REST-client framework.

## Download ##
```gradle
compile 'io.moj.java:mojio-sdk-model:0.0.124'
```

## Instructions ##

The Model SDK is a collection of POJOs matching the entities in the Mojio API. If you're starting from scratch, consider
using the [mojio-sdk-rest](https://github.com/mojio/mojio-java-sdk/tree/develop/mojio-sdk-rest) module for both the
model objects and a basic client. If you have existing an REST-client framework or need finer control, however, this
module can stand on its own.

Below is an example of integrating the mojio-sdk-model with [Retrofit](http://square.github.io/retrofit/)

```java
package io.moj.example;

import io.moj.mobile.android.sdk.model.ListResponse;
import io.moj.mobile.android.sdk.model.User;
import io.moj.mobile.android.sdk.model.Vehicle;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Retrofit interface for the Mojio REST API.
 */
public interface MojioApi {

    @GET("vehicles")
    Call<ListResponse<Vehicle>> getVehicles();

    @GET("vehicles/{id}")
    Call<Vehicle> getVehicle(@Path("id") id);

    @PUT("vehicles/{id}")
    Call<Vehicle> updateVehicle(@Path("id") id, @Body Vehicle vehicle);

    @GET("vehicles/{id}/history/states")
    Call<ListResponse<VehicleMeasure>> getTripHistory(@Path("id") id);

    @GET("vehicles/{id}/history/states")
    Call<ListResponse<VehicleMeasure>> getTripHistory(@Path("id") id, @Query("skip") int skip, @Query("take") int take);

}
```

Here's an example of how to embed access tokens in requests that require authentication using an
OkHttp Interceptor:

```java
OkHttpClient httpClient = new OkHttpClient.Builder()
        .addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                // set the access token in the header if we have it
                if (!TextUtils.isEmpty(accessToken)) {
                    request = request.newBuilder()
                            .header("Authorization", "Bearer " + accessToken)
                            .build();
                }
                return chain.proceed(request);
            }
        })
        .build();
MojioApi mojioApi = new Retrofit.Builder()
        .baseUrl(MojioEnvironment.getDefault().getApiUrl())
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build().create(MojioApi.class);
```

Even if you're not using Retrofit, the mojio-sdk-model module can be plugged into your existing
architecture. Currently, however, we have a dependency on [Gson](https://github.com/google/gson). If
this is an issue for you, let us know with a [feature request](https://github.com/mojio/mojio-java-sdk/issues)!

### Persisting model objects ###
Each Mojio entity (not including enums or units) such as Vehicle, Mojio, and User extends
MojioObject which includes a Long "_id" field to facilitate usage of Android's Cursor framework.

The private fields inside model objects also follow non-standard cases for Java to match the
entities exactly as returned by the API. We've abstracted this detail away with getters and setters
and the benefit is that your SQLite tables, when generated from these model objects with an ORM such
as [Cupboard](https://bitbucket.org/littlerobots/cupboard), will exactly mirror the API.

To help build queries with whatever framework you're using, each model class defines static
constants for each of it's fields:

```java
SQLiteQueryBuilder query = new SQLiteQueryBuilder();
query.setTables(Vehicle.class.getSimpleName());
query.appendWhere(Vehicle.ID + "=");
Cursor cursor = qBuilder.query(db, projection, selection, selectionArgs, null, null, orderBy);
```

## License ##
    Copyright 2016 Mojio, Inc

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
