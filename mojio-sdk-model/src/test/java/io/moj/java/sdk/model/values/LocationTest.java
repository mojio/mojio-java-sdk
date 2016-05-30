package io.moj.java.sdk.model.values;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import io.moj.java.sdk.model.enums.GPSStatus;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by skidson on 2016-05-30.
 */
public class LocationTest {

    @Test
    public void testGetStatus() {
        Location location = new Gson().fromJson("{ \"Status\": \"Locked, LastKnown, PreviousValidState\"}", Location.class);

        List<GPSStatus> actual = location.getStatus();
        assertThat(actual).isNotNull();
        assertThat(actual).containsExactly(GPSStatus.LOCKED, GPSStatus.LAST_KNOWN, GPSStatus.PREVIOUS_VALID_STATE);
    }

    @Test
    public void testGetStatus_empty() {
        Location location = new Gson().fromJson("{ \"Status\": \"\"}", Location.class);
        List<GPSStatus> actual = location.getStatus();
        assertThat(actual).isNull();
    }

    @Test
    public void testGetStatus_null() {
        Location location = new Gson().fromJson("{}", Location.class);
        List<GPSStatus> actual = location.getStatus();
        assertThat(actual).isNull();
    }

    @Test
    public void testSetStatus() {
        Location location = new Location();
        location.setStatus(Lists.newArrayList(GPSStatus.COMMUNICATIONS_FAILURE, GPSStatus.GPS_OFF, GPSStatus.HISTORIC));

        String json = new Gson().toJson(location);
        assertThat(json).isEqualTo("{\"Status\":\"CommunicationsFailure, GPSOff, Historic\"}");
    }

    @Test
    public void testSetStatus_empty() {
        Location location = new Location();
        location.setStatus(new ArrayList<GPSStatus>());

        String json = new Gson().toJson(location);
        assertThat(json).isEqualTo("{\"Status\":\"\"}");
    }

    @Test
    public void testSetStatus_null() {
        Location location = new Location();
        location.setStatus(null);

        String json = new Gson().toJson(location);
        assertThat(json).isEqualTo("{}");
    }

}
