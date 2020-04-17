package io.moj.java.sdk.rest;

import io.moj.java.sdk.Environment;
import io.moj.java.sdk.MojioClient;
import io.moj.java.sdk.MojioRestApi;
import io.moj.java.sdk.model.enums.SpeedUnit;
import io.moj.java.sdk.model.values.SpeedingViolation;
import io.moj.java.sdk.auth.AccessToken;
import io.moj.java.sdk.auth.Authenticator;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static io.moj.java.sdk.test.utils.MockWebServerUtils.successFromFile;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

public class GetTripSpeedingViolationTest {
    private MockWebServer mockWebServer = new MockWebServer();
    private MojioRestApi restApi;

    private final String tripId = "1";
    private final String vehicleId = "2";

    @Test
    public void get_trip_speeding_violation_test() throws IOException {
        mockWebServer.enqueue(successFromFile("get-speeding-violations-success.json"));

        Response<List<SpeedingViolation>> response = restApi.getTripSpeedingViolations(vehicleId, tripId).execute();

        assertThat(response.code()).isEqualTo(200);

        List<SpeedingViolation> items = response.body();
        assertResponseIsCorrect(items);
    }

    private void assertResponseIsCorrect(List<SpeedingViolation> items) {
        float tolerance = 0.000001f;

        assertThat(items.size()).isEqualTo(2);

        SpeedingViolation firstItem = items.get(0);

        assertThat(firstItem.getStartTimestamp()).isEqualTo("2019-11-12T19:46:13.000Z");
        assertThat(firstItem.getEndTimestamp()).isEqualTo("2019-11-12T19:47:47.000Z");

        assertThat(firstItem.getStartLocation().getLat()).isWithin(tolerance).of(33.92815f);
        assertThat(firstItem.getStartLocation().getLng()).isWithin(tolerance).of(-118.21655f);
        assertThat(firstItem.getStartLocation().getTimestamp()).isEqualTo(1573587973000L);

        assertThat(firstItem.getEndLocation().getLat()).isWithin(tolerance).of(33.92418f);
        assertThat(firstItem.getEndLocation().getLng()).isWithin(tolerance).of(-118.19166f);
        assertThat(firstItem.getEndLocation().getTimestamp()).isEqualTo(1573588067000L);

        assertThat(firstItem.getMaxSpeed().getTimestamp()).isEqualTo("2019-12-10T17:38:09.980Z");
        assertThat(firstItem.getMaxSpeed().getSpeedUnit()).isEqualTo(SpeedUnit.MILES_PER_HOUR);
        assertThat(firstItem.getMaxSpeed().getValue()).isWithin(tolerance).of(101.905f);
        assertThat(firstItem.getMaxSpeed().getBaseSpeedUnit()).isEqualTo(SpeedUnit.KILOMETERS_PER_HOUR);
        assertThat(firstItem.getMaxSpeed().getBaseValue()).isWithin(tolerance).of(163.9997927f);

        assertThat(firstItem.getMinSpeed().getTimestamp()).isEqualTo("2019-12-10T17:38:09.980Z");
        assertThat(firstItem.getMinSpeed().getSpeedUnit()).isEqualTo(SpeedUnit.MILES_PER_HOUR);
        assertThat(firstItem.getMinSpeed().getValue()).isWithin(tolerance).of(8.078f);
        assertThat(firstItem.getMinSpeed().getBaseSpeedUnit()).isEqualTo(SpeedUnit.KILOMETERS_PER_HOUR);
        assertThat(firstItem.getMinSpeed().getBaseValue()).isWithin(tolerance).of(13.00024852f);

        assertThat(firstItem.getAverageSpeed().getTimestamp()).isEqualTo("2019-12-10T17:38:09.980Z");
        assertThat(firstItem.getAverageSpeed().getSpeedUnit()).isEqualTo(SpeedUnit.MILES_PER_HOUR);
        assertThat(firstItem.getAverageSpeed().getValue()).isWithin(tolerance).of(61.46089873417723f);
        assertThat(firstItem.getAverageSpeed().getBaseSpeedUnit()).isEqualTo(SpeedUnit.KILOMETERS_PER_HOUR);
        assertThat(firstItem.getAverageSpeed().getBaseValue()).isWithin(tolerance).of(98.91148276886078f);

        assertThat(firstItem.getAverageSpeedDelta().getTimestamp()).isEqualTo("2019-12-10T17:38:09.980Z");
        assertThat(firstItem.getAverageSpeedDelta().getSpeedUnit()).isEqualTo(SpeedUnit.MILES_PER_HOUR);
        assertThat(firstItem.getAverageSpeedDelta().getValue()).isWithin(tolerance).of(3.0f);
        assertThat(firstItem.getAverageSpeedDelta().getBaseSpeedUnit()).isEqualTo(SpeedUnit.KILOMETERS_PER_HOUR);
        assertThat(firstItem.getAverageSpeedDelta().getBaseValue()).isWithin(tolerance).of(4.8f);

        assertThat(firstItem.getSpeedingScore()).isWithin(tolerance).of(3234.8435639810104f);

        assertThat(firstItem.getPolyline()).isEqualTo("_qanE~dppU_G|RxCdaA`AnUuCrsA^lPp[_lJ{g@jjBxQ~sHJhQAlf@KnQeChQnZozNuApBkVztCqF");
    }

    @Before
    public void setUp() {
        Environment environment = getMockedEnvironment();
        Authenticator mockAuthenticator = mock(Authenticator.class);
        AccessToken token = new AccessToken("expectedAuthToken", null, System.currentTimeMillis() + 120_000);
        when(mockAuthenticator.getAccessToken()).thenReturn(token);

        MojioClient client = new MojioClient.Builder("any", "any")
                .environment(environment)
                .authenticator(mockAuthenticator)
                .build();

        restApi = client.rest();
    }

    @After
    public void tearDown() throws Exception {
        mockWebServer.close();
    }

    private Environment getMockedEnvironment() {
        Environment environment = Mockito.mock(Environment.class);

        // Returns URL like: http://localhost:59650/
        HttpUrl httpUrl = mockWebServer.url("");

        when(environment.getAccountsUrl()).thenReturn(httpUrl.toString());
        when(environment.getPushUrl()).thenReturn(httpUrl.toString());
        when(environment.getApiUrl()).thenReturn(httpUrl.toString());
        when(environment.getApiUrl(1)).thenReturn(httpUrl.toString());

        return environment;
    }
}
