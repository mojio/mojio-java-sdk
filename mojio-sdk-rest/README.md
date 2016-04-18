# Mojio Java REST SDK #

Client for getting up and running making calls to the Mojio API quickly. The client is highly-configurable
and handles basic authentication.

## Disclaimer ##
**UNDER ACTIVE DEVELOPMENT**

* Methods may change without notice
* Currently provided "AS IS"

## Download ##
```gradle
compile 'io.moj.java:mojio-sdk-rest:0.0.1'
```

## Instructions ##

The primary way of interfacing with the REST SDK is through the MojioClient class. The request/response framework
is built on [Retrofit](http://square.github.io/retrofit/) and each API call can be invoked blocking or
asynchronously at the caller's choice.

To get started with the REST SDK you first need to create an app on our [Developer Website](http://developer.moj.io/).

### 1. First instantiate your MojioClient: ###
```java
MojioClient mojioClient = new MojioClient.Builder("yourAppId", "yourAppSecret").build();
```

See *Advanced* below for advanced client configuration.

### 2. Authenticate with user credentials ###
```java
Call<User> loginCall = mojioClient.login("username", "password");
call.enqueue(new Callback<User>() {
     @Override
     public void onResponse(Call<User> call, Response<User> response) {
        if (response.isSuccessful()) {
            // Success! Log the user in!
        } else {
            // Handle the error - this means we got a response without a success code. The user probably
            // entered the wrong username or password
        }
     }

     @Override
     public void onFailure(Call<User> call, Throwable t) {
         // Handle the error - this is caused by a request failure such as loss of network connectivity
     });
```
Note you can also make API calls synchronously:
```java
try {
    Response<User> response = loginCall.execute();
    if (response.isSuccessful()) {
        // Success! Log the user in!
    } else {
        // Handle the error - this means we got a response without a success code. The user probably
        // entered the wrong username or password
    }
} catch (IOException e) {
    // Handle the error - this is caused by a request failure such as loss of network connectivity
}
```

### 3. Make API calls ###
```java
client.rest().getVehicles().enqueue(new Callback<ListResponse<Vehicle>>() {
        @Override
        public void onResponse(Call<ListResponse<Vehicle>> call, Response<ListResponse<Vehicle>> response) {
           if (response.isSuccessful()) {
               List<Vehicle> vehicles = response.body().getData();
               // Show the user their vehicles!
           } else {
               // Handle the error - this means we got a response without a success code. Are you logged in?
           }
        }

        @Override
        public void onFailure(Call<ListResponse<Vehicle>> call, Throwable t) {
            // Handle the error - this is caused by a request failure such as loss of network connectivity
        });
```

## Advanced ##
The goal of the REST SDK is to be as open and configurable as possible. Have a specific need that isn't addressed below?
Submit a [feature request](https://github.com/mojio/mojio-java-sdk/issues) and we'll take a look!

### MojioClient Configuration ###
```java
MojioClient mojioClient = new MojioClient.Builder("yourAppId", "yourAppSecret")

        // force the client to target Europe specifically
        .environment(MojioClient.EU_PROD)

        // set a custom Authenticator - this is how the SDK stores, retrieves, and refreshes access tokens. Use this,
        // for instance, to implement caching of the access tokens on disk instead of in-memory
        .authenticator(new MyCustomAuthenticator())

        // set the Gson instance to be used by the client. If you're already using Gson this lets you save memory
        // by using the same instance. Be careful, however, as certain Gson configurations may interfere the SDK's
        // ability to parse responses - the models have been developed to be parsable with a default new Gson() instance.
        .gson(myGsonInstance)

        // enable logging of requests and responses in the following format. This is disabled by default.
        // Request [POST /v1/vehicles]: { "request": "body" }
        // Response [POST /v1/vehicles] - 200 OK: { "Message": "Response" }
        .logging(true)

        // specify the executor that should be used for delivering callbacks
        .callbackExecutor(Executors.newSingleThreadExecutor())

        // specify the executor that should be used for performing network requests
        .requestExecutor(Executors.newSingleThreadExecutor())

        .build();

```

## Logging ##
The SDK uses a lightweight [Log](https://github.com/mojio/mojio-java-sdk/tree/develop/mojio-sdk-rest/src/main/java/io/moj/java/sdk/logging/Log.java)
interface to avoid tying your app to a specific logging framework. To enable logging you need to:

1. Enable logging on the client
```java
MojioClient mojioClient = new MojioClient.Builder("yourAppId", "yourAppSecret")
        .logging(true)
        .build();
```

2. Attach a logger
```java
io.moj.java.sdk.logging.Log.append(new Logger() {
    public void log(Level level, String tag, String msg, Throwable tr) {
        // feed this to whatever logging framework you are using
        System.out.println(level.getName() + ": " + tag + " - " + msg);
    }
}
```

## ProGuard ##

If you use ProGuard, add the following lines to your configuration
```
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions
```
