package io.moj.java.sdk.model.stream;

import io.moj.java.sdk.model.values.Speed;

/**
 * Activity stream settings model.
 * Created by Mauro on 2016-06-23.
 */
public class Settings {
    public static final String ENABLE_GEOFENCE = "EnableGeofenceActivity";
    public static final String ENABLE_TRIP_START = "EnableTripStartActivity";
    public static final String ENABLE_TRIP_COMPLETED = "EnableTripCompletedActivity";
    public static final String ENABLE_LOW_FUEL = "EnableLowFuelActivity";
    public static final String ENABLE_LOW_BATTERY = "EnableLowBatteryActivity";
    public static final String ENABLE_SPEED = "EnableSpeedActivity";
    public static final String SPEED_THRESHOLD = "SpeedThreshold";
    public static final String ENABLE_DTC = "EnableDtcActivity";
    public static final String ENABLE_CHECK_ENGINE = "EnableCheckEngineActivity";
    public static final String ENABLE_TOW = "EnableTowActivity";
    public static final String ENABLE_RECALL = "EnableRecallActivity";
    public static final String ENABLE_SERVICE_BULLETIN = "EnableServiceBulletinActivity";

    private Boolean EnableGeofenceActivity;
    private Boolean EnableTripStartActivity;
    private Boolean EnableTripCompletedActivity;
    private Boolean EnableLowFuelActivity;
    private Boolean EnableLowBatteryActivity;
    private Boolean EnableSpeedActivity;
    private Speed SpeedThreshold;
    private Boolean EnableDtcActivity;
    private Boolean EnableCheckEngineActivity;
    private Boolean EnableTowActivity;
    private Boolean EnableRecallActivity;
    private Boolean EnableServiceBulletinActivity;

    public Boolean getEnableGeofenceActivity() {
        return EnableGeofenceActivity;
    }

    public void setEnableGeofenceActivity(Boolean enableGeofenceActivity) {
        EnableGeofenceActivity = enableGeofenceActivity;
    }

    public Boolean getEnableTripStartActivity() {
        return EnableTripStartActivity;
    }

    public void setEnableTripStartActivity(Boolean enableTripStartActivity) {
        EnableTripStartActivity = enableTripStartActivity;
    }

    public Boolean getEnableTripCompletedActivity() {
        return EnableTripCompletedActivity;
    }

    public void setEnableTripCompletedActivity(Boolean enableTripCompletedActivity) {
        EnableTripCompletedActivity = enableTripCompletedActivity;
    }

    public Boolean getEnableLowFuelActivity() {
        return EnableLowFuelActivity;
    }

    public void setEnableLowFuelActivity(Boolean enableLowFuelActivity) {
        EnableLowFuelActivity = enableLowFuelActivity;
    }

    public Boolean getEnableLowBatteryActivity() {
        return EnableLowBatteryActivity;
    }

    public void setEnableLowBatteryActivity(Boolean enableLowBatteryActivity) {
        EnableLowBatteryActivity = enableLowBatteryActivity;
    }

    public Boolean getEnableSpeedActivity() {
        return EnableSpeedActivity;
    }

    public void setEnableSpeedActivity(Boolean enableSpeedActivity) {
        EnableSpeedActivity = enableSpeedActivity;
    }

    public Speed getSpeedThreshold() {
        return SpeedThreshold;
    }

    public void setSpeedThreshold(Speed speedThreshold) {
        SpeedThreshold = speedThreshold;
    }

    public Boolean getEnableDtcActivity() {
        return EnableDtcActivity;
    }

    public void setEnableDtcActivity(Boolean enableDtcActivity) {
        EnableDtcActivity = enableDtcActivity;
    }

    public Boolean getEnableCheckEngineActivity() {
        return EnableCheckEngineActivity;
    }

    public void setEnableCheckEngineActivity(Boolean enableCheckEngineActivity) {
        EnableCheckEngineActivity = enableCheckEngineActivity;
    }

    public Boolean getEnableTowActivity() {
        return EnableTowActivity;
    }

    public void setEnableTowActivity(Boolean enableTowActivity) {
        EnableTowActivity = enableTowActivity;
    }

    public Boolean getEnableRecallActivity() {
        return EnableRecallActivity;
    }

    public void setEnableRecallActivity(Boolean enableRecallActivity) {
        EnableRecallActivity = enableRecallActivity;
    }

    public Boolean getEnableServiceBulletinActivity() {
        return EnableServiceBulletinActivity;
    }

    public void setEnableServiceBulletinActivity(Boolean enableServiceBulletinActivity) {
        EnableServiceBulletinActivity = enableServiceBulletinActivity;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "EnableGeofenceActivity=" + EnableGeofenceActivity +
                ", EnableTripStartActivity=" + EnableTripStartActivity +
                ", EnableTripCompletedActivity=" + EnableTripCompletedActivity +
                ", EnableLowFuelActivity=" + EnableLowFuelActivity +
                ", EnableLowBatteryActivity=" + EnableLowBatteryActivity +
                ", EnableSpeedActivity=" + EnableSpeedActivity +
                ", SpeedThreshold=" + SpeedThreshold +
                ", EnableDtcActivity=" + EnableDtcActivity +
                ", EnableCheckEngineActivity=" + EnableCheckEngineActivity +
                ", EnableTowActivity=" + EnableTowActivity +
                ", EnableRecallActivity=" + EnableRecallActivity +
                ", EnableServiceBulletinActivity=" + EnableServiceBulletinActivity +
                '}';
    }
}