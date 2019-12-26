package io.moj.java.sdk.test.utils;

import okhttp3.mockwebserver.MockResponse;
import okio.Buffer;

import java.io.IOException;

public class MockWebServerUtils {
    public static MockResponse successFromFile(String fileName) throws IOException {
        Buffer buffer = new Buffer().readFrom(
                ClassLoader.getSystemClassLoader().getResourceAsStream(fileName)
        );
        return new MockResponse().setBody(buffer);
    }
}
