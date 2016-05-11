package io.moj.java.sdk.logging;

import org.hamcrest.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.argThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.doAnswer;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by skidson on 16-03-04.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({HttpUrl.class, Request.class, Response.class, Buffer.class})
public class LoggingInterceptorTest {

    private static final Charset WRITE_CHARSET = Charset.forName("UTF-8");

    private Log.Logger logger;

    @Before
    public void setup() {
        logger = mock(Log.Logger.class);
        Log.clearLoggers();
        Log.append(logger);
    }

    @Test
    public void testIntercept_nullRequestBody_nullResponseBody() throws IOException {
        String expectedTag = "expectedTag";
        String expectedMethod = "expectedMethod";
        String expectedUrlPath = "/expected/url";
        String expectedMessage = "OK";
        int expectedCode = 200;

        LoggingInterceptor interceptor = new LoggingInterceptor(expectedTag);
        Mock mock = setup(expectedMethod, expectedUrlPath, null, expectedMessage, expectedCode, null);

        Response actualResponse = interceptor.intercept(mock.chain);
        verify(logger).log(eq(Level.FINE), eq(expectedTag),
                argThat(new LogMessageArgumentMatcher("Request", expectedMethod, expectedUrlPath)),
                isNull(Throwable.class));

        verify(logger).log(eq(Level.FINE), eq(expectedTag),
                argThat(new LogMessageArgumentMatcher("Response", expectedMethod, expectedUrlPath, String.valueOf(expectedCode), expectedMessage)),
                isNull(Throwable.class));

        assertThat(actualResponse).isEqualTo(mock.response);
    }

    @Test
    public void testIntercept_withRequestBody() throws IOException {
        String expectedTag = "expectedTag";
        String expectedMethod = "expectedMethod";
        String expectedUrlPath = "/expected/url";
        String expectedMessage = "OK";
        String expectedRequestBody = "expectedRequestBody";
        int expectedCode = 200;

        LoggingInterceptor interceptor = new LoggingInterceptor(expectedTag);
        Mock mock = setup(expectedMethod, expectedUrlPath, expectedRequestBody,
                expectedMessage, expectedCode, null);

        Response actualResponse = interceptor.intercept(mock.chain);
        verify(logger).log(eq(Level.FINE), eq(expectedTag),
                argThat(new LogMessageArgumentMatcher("Request", expectedMethod, expectedUrlPath,
                        expectedRequestBody)),
                isNull(Throwable.class));

        verify(logger).log(eq(Level.FINE), eq(expectedTag),
                argThat(new LogMessageArgumentMatcher("Response", expectedMethod, expectedUrlPath,
                        String.valueOf(expectedCode), expectedMessage)),
                isNull(Throwable.class));

        assertThat(actualResponse).isEqualTo(mock.response);
    }

    @Test
    public void testIntercept_withResponseBody() throws IOException {
        String expectedTag = "expectedTag";
        String expectedMethod = "expectedMethod";
        String expectedUrlPath = "/expected/url";
        String expectedMessage = "OK";
        String expectedRequestBody = "expectedRequestBody";
        String expectedResponseBody = "expectedResponseBody";
        int expectedCode = 200;

        LoggingInterceptor interceptor = new LoggingInterceptor(expectedTag);
        Mock mock = setup(expectedMethod, expectedUrlPath, expectedRequestBody,
                expectedMessage, expectedCode, expectedResponseBody);

        Response actualResponse = interceptor.intercept(mock.chain);
        verify(logger).log(eq(Level.FINE), eq(expectedTag),
                argThat(new LogMessageArgumentMatcher("Request", expectedMethod, expectedUrlPath,
                        expectedRequestBody)),
                isNull(Throwable.class));

        verify(logger).log(eq(Level.FINE), eq(expectedTag),
                argThat(new LogMessageArgumentMatcher("Response", expectedMethod, expectedUrlPath,
                        String.valueOf(expectedCode), expectedMessage, expectedResponseBody)),
                isNull(Throwable.class));

        assertThat(actualResponse).isEqualTo(mock.response);
    }

    /**
     * Verify that we never crash the app just trying to log request content.
     * @throws IOException
     */
    @Test
    public void testIntercept_requestException() throws IOException {
        String expectedTag = "expectedTag";
        String expectedMethod = "expectedMethod";
        String expectedUrlPath = "/expected/url";
        String expectedMessage = "OK";
        String expectedRequestBody = "expectedRequestBody";
        String expectedResponseBody = "expectedResponseBody";
        int expectedCode = 200;

        LoggingInterceptor interceptor = new LoggingInterceptor(expectedTag);
        Mock mock = setup(expectedMethod, expectedUrlPath, expectedRequestBody,
                expectedMessage, expectedCode, expectedResponseBody);

        RequestBody requestBody = mock.request.body();
        reset(requestBody);
        doThrow(new IOException("Don't crash now..."))
                .when(requestBody).writeTo(any(BufferedSink.class));

        Response actualResponse = interceptor.intercept(mock.chain);
        assertThat(actualResponse).isEqualTo(mock.response);
    }

    /**
     * Verify that we never crash the app just trying to log response content.
     * @throws IOException
     */
    @Test
    public void testIntercept_responseException() throws IOException {
        String expectedTag = "expectedTag";
        String expectedMethod = "expectedMethod";
        String expectedUrlPath = "/expected/url";
        String expectedMessage = "OK";
        String expectedRequestBody = "expectedRequestBody";
        String expectedResponseBody = "expectedResponseBody";
        int expectedCode = 200;

        LoggingInterceptor interceptor = new LoggingInterceptor(expectedTag);
        Mock mock = setup(expectedMethod, expectedUrlPath, expectedRequestBody,
                expectedMessage, expectedCode, expectedResponseBody);

        ResponseBody responseBody = mock.response.body();
        BufferedSource source = responseBody.source();
        doThrow(new IOException("Don't crash now...")).when(source).request(anyLong());

        Response actualResponse = interceptor.intercept(mock.chain);
        assertThat(actualResponse).isEqualTo(mock.response);
    }

    private static Mock setup(String method, String urlPath, final String requestBody,
                              String responseMessage, int responseCode, String responseBody)
            throws IOException {
        Interceptor.Chain chain = mock(Interceptor.Chain.class);

        HttpUrl httpUrl = mock(HttpUrl.class);
        when(httpUrl.encodedPath()).thenReturn(urlPath);

        Request request = mock(Request.class);
        when(chain.request()).thenReturn(request);
        when(request.method()).thenReturn(method);
        when(request.url()).thenReturn(httpUrl);
        if (requestBody != null) {
            RequestBody body = mock(RequestBody.class);
            doAnswer(new Answer<Void>() {
                @Override
                public Void answer(InvocationOnMock invocation) throws Throwable {
                    BufferedSink sink = (BufferedSink) invocation.getArguments()[0];
                    sink.writeString(requestBody, WRITE_CHARSET);
                    return null;
                }
            }).when(body).writeTo(any(BufferedSink.class));
            when(request.body()).thenReturn(body);
        }

        Response response = mock(Response.class);
        when(response.code()).thenReturn(responseCode);
        when(response.message()).thenReturn(responseMessage);
        when(chain.proceed(request)).thenReturn(response);
        if (responseBody != null) {
            ResponseBody body = mock(ResponseBody.class);
            BufferedSource source = mock(BufferedSource.class);
            Buffer buffer = mock(Buffer.class);
            when(response.body()).thenReturn(body);
            when(body.contentLength()).thenReturn(-1L);
            when(body.source()).thenReturn(source);
            when(buffer.clone()).thenReturn(buffer);
            when(buffer.readString(any(Charset.class))).thenReturn(responseBody);
            when(source.buffer()).thenReturn(buffer);
        }

        return new Mock(chain, request, response);
    }

    private static class Mock {
        private Request request;
        private Response response;
        private Interceptor.Chain chain;

        public Mock(Interceptor.Chain chain, Request request, Response response) {
            this.chain = chain;
            this.request = request;
            this.response = response;
        }
    }

    private static class LogMessageArgumentMatcher extends ArgumentMatcher<String> {
        private String prefix;
        private String[] contains;

        public LogMessageArgumentMatcher(String prefix, String...contains) {
            this.prefix = prefix;
            this.contains = contains;
        }

        @Override
        public boolean matches(Object argument) {
            try {
                validate(argument);
            } catch (IllegalArgumentException e) {
                return false;
            }
            return true;
        }

        @Override
        public void describeMismatch(Object item, Description description) {
            try {
                validate(item);
            } catch (IllegalArgumentException e) {
                description.appendText(e.getMessage());
            }
            super.describeMismatch(item, description);
        }

        private boolean validate(Object argument) throws IllegalArgumentException {
            if (!(argument instanceof String))
                throw new IllegalArgumentException("'" + argument + "' is not a String");

            String arg = (String) argument;
            if (!arg.startsWith(prefix)) {
                throw new IllegalArgumentException("'" + argument + "' does not start with '" +
                        prefix + "'");
            }

            if (contains != null) {
                for (String contain : contains) {
                    if (!arg.contains(contain)) {
                        throw new IllegalArgumentException("'" + argument + "' does not contain '" +
                                contain + "'");
                    }
                }
            }

            return true;
        }
    }

}

