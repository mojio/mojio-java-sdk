## Disclaimer ##
**UNDER ACTIVE DEVELOPMENT**

This SDK is built against the v2 APIs which are still in development and not ready for general consumption.

* Methods may change without notice
* Currently provided "AS IS"

![](static/banner_mojio.png)
# Mojio Java SDK #
![](http://ci.moj.io/app/rest/builds/buildType:(id:Mobile_MojioSDK_Java_Development)/statusIcon)

Java SDK for integrating with the Mojio platform.

For more information please see the [developer website](http://developer.moj.io/).

## Download ##
```gradle
// for full SDK:
compile 'io.moj.java:mojio-sdk-rest:0.0.180'

// model objects only:
compile 'io.moj.java:mojio-sdk-model:0.0.180'
```

The latest version can be found in [Bintray](https://bintray.com/mojio/maven/io.moj.java%3Amojio-sdk-rest)

## In Gradle ##
```gradle
// in build.gradle
...
allprojects {
    repositories {
        ...
        maven { url 'https://dl.bintray.com/mojio/maven' }
        ...
    }
}
...

// in app/build.gradle
...
dependencies {
    compile "io.moj.java:mojio-sdk-rest:0.0.180"
}
...
```

## Structure ##
The SDK is broken into modules - you may choose to use some or all of them for your application.
See each module's subdirectory for more detailed instructions.

As much as possible we have tried to reduce the number of dependencies our SDK brings into your app.
Some models, unfortunately, require distinct serialization behaviour (in particular enums) and we
have opted to annotate these classes using [GSON](https://github.com/google/gson).

### [mojio-sdk-model](https://github.com/mojio/mojio-java-sdk/tree/develop/mojio-sdk-model) ###
  Model classes for use with the Mojio REST API. These objects are annotated for serialization with
  GSON. The Model SDK can be plugged into your existing REST-client framework.

### [mojio-sdk-rest](https://github.com/mojio/mojio-java-sdk/tree/develop/mojio-sdk-rest) ###
  Client for getting up and running making calls to the Mojio API quickly. The client is highly-configurable
  and handles basic authentication.

### [mojio-sdk-test](https://github.com/mojio/mojio-java-sdk/tree/develop/mojio-sdk-test) ###
  A module purely for common functionality used for each module's tests. You probably only care
  about this module if you are forking or building from scratch.

## License ##
    Copyright 2018 Mojio, Inc

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
