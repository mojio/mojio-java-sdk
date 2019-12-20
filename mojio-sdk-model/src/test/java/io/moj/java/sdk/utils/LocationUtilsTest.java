package io.moj.java.sdk.utils;

import com.google.common.collect.Lists;

import org.junit.Test;

import java.util.ArrayList;

import io.moj.java.sdk.model.enums.GPSStatus;
import io.moj.java.sdk.model.values.Location;

import static com.google.common.truth.Truth.assertThat;

public class LocationUtilsTest {

    @Test
    public void testIsGPSLockedStatus() {
        Location location = new Location();

        location.setStatus(Lists.newArrayList(GPSStatus.LOCKED));
        assertThat(LocationUtils.isGPSLocked(location)).isTrue();

        location.setStatus(Lists.newArrayList(GPSStatus.PREVIOUS_VALID_STATE, GPSStatus.LOCKED));
        assertThat(LocationUtils.isGPSLocked(location)).isTrue();

        location.setStatus(Lists.newArrayList(GPSStatus.LOCKED, GPSStatus.PREVIOUS_VALID_STATE));
        assertThat(LocationUtils.isGPSLocked(location)).isTrue();

        location.setStatus(Lists.newArrayList(GPSStatus.LAST_KNOWN, GPSStatus.LOCKED));
        assertThat(LocationUtils.isGPSLocked(location)).isTrue();

        location.setStatus(Lists.newArrayList(GPSStatus.LOCKED, GPSStatus.LAST_KNOWN));
        assertThat(LocationUtils.isGPSLocked(location)).isTrue();

        location.setStatus(Lists.newArrayList(GPSStatus.TWO_D_FIX, GPSStatus.COMMUNICATIONS_FAILURE, GPSStatus.LOCKED, GPSStatus.INVALID_TIME));
        assertThat(LocationUtils.isGPSLocked(location)).isTrue();

    }

    @Test
    public void testIsGPSLockedNullStatus() {
        Location location = new Location();
        assertThat(LocationUtils.isGPSLocked(location)).isFalse();
    }

    @Test
    public void testIsGPSLockedEmptyStatus() {
        Location location = new Location();
        location.setStatus(new ArrayList<GPSStatus>());
        assertThat(LocationUtils.isGPSLocked(location)).isFalse();
    }

}
