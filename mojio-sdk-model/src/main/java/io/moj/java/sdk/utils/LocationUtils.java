package io.moj.java.sdk.utils;

import java.util.List;

import io.moj.java.sdk.model.enums.GPSStatus;
import io.moj.java.sdk.model.values.Location;

public class LocationUtils {

    /**
     * Returns true if the GPS is actually locked (because sometimes it says it is even when it
     * isn't, obviously).
     * @param location
     * @return
     */
    public static Boolean isGPSLocked(Location location) {
        List<GPSStatus> statuses = location.getStatus();
        if (statuses == null || statuses.isEmpty()) {
            return false;
        }

        boolean locked = false;
        for (GPSStatus status : statuses) {
            if (status == GPSStatus.LOCKED) {
                locked = true;
            }
        }
        return locked;
    }


}
