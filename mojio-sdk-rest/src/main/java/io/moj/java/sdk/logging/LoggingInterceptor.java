package io.moj.java.sdk.logging;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Interceptor for logging API requests and responses.
 * Created by skidson on 16-02-11.
 */
public class LoggingInterceptor implements Interceptor {

    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private String tag;
    private boolean logBody;

    public LoggingInterceptor(String tag) {
        this(tag, true);
    }

    public LoggingInterceptor(String tag, boolean logBody) {
        this.tag = tag;
        this.logBody = logBody;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        String query = request.url().encodedQuery();
        if (query == null || query.isEmpty()) {
            query = "";
        } else {
            query = "?" + query;
        }

        String endpointSignature = "[" + request.method() + " " + request.url().encodedPath() + query + "]";
        String requestMessage = "Request " + endpointSignature;
        if (request.body() != null && logBody) {
            try {
                Buffer buffer = new Buffer();
                request.body().writeTo(buffer);
                requestMessage += ": " + buffer.readString(UTF_8);
            } catch (IOException e) {
                Log.e(tag, "Error parsing request body", e);
            }
        }
        Log.d(tag, requestMessage);

        Response response = chain.proceed(request);
        String responseMessage = "Response " + endpointSignature;
        if (response != null) {
            responseMessage += " - " + response.code() + " " + response.message();
            if (response.body() != null && response.body().contentLength() != 0 && logBody) {
                try {
                    BufferedSource source = response.body().source();
                    source.request(Long.MAX_VALUE);
                    Buffer buffer = source.buffer();
                    responseMessage += ": " + buffer.clone().readString(UTF_8)
                            .replaceAll("\r\n", " ").replaceAll(" {2,}", "");
                } catch (IOException e) {
                    Log.e(tag, "Error parsing response body", e);
                }
            }
        }
        Log.d(tag, responseMessage);

        return response;
    }
}