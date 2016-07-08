package io.moj.java.sdk.model.stream;

import io.moj.java.sdk.model.values.Speed;

import java.util.Arrays;

/**
 * Activity stream settings model.
 * Created by Mauro on 2016-06-23.
 */
public class Settings {

    public static final String ENABLE_TRIP_START = "EnableTripStartActivity";
    public static final String ENABLE_TRIP_COMPLETED = "EnableTripCompletedActivity";
    public static final String ENABLE_LOW_FUEL = "EnableLowFuelActivity";
    public static final String ENABLE_LOW_BATTERY = "EnableLowBatteryActivity";
    public static final String ENABLE_SPEED = "EnableSpeedActivity";
    public static final String SPEED_THRESHOLD = "SpeedThreshold";
    public static final String ENABLE_DTC = "EnableDtcActivity";
    public static final String ENABLE_CHECK_ENGINE = "EnableCheckEngineActivity";
    public static final String ENABLE_TOW = "EnableTowActivity";
    public static final String ENABLE_MAINTENANCE = "EnableMaintenanceActivity";
    public static final String ENABLE_RECALL = "EnableRecallActivity";
    public static final String ENABLE_SERVICE_BULLETIN = "EnableServiceBulletinActivity";
    public static final String ENABLE_DISTURBANCE = "EnableDisturbanceActivity";
    public static final String ENABLE_ACCIDENT = "EnableAccidentActivity";
    public static final String ENABLE_DEVICE_UNPLUGGED = "EnableDeviceUnpluggedActivity";
    public static final String ENABLE_GEOFENCE = "EnableGeofenceActivity";
    public static final String ENABLED_GEOFENCES = "EnabledGeofences";

    private Boolean EnableTripStartActivity;
    private Boolean EnableTripCompletedActivity;
    private Boolean EnableLowFuelActivity;
    private Boolean EnableLowBatteryActivity;
    private Boolean EnableSpeedActivity;
    private Speed SpeedThreshold;
    private Boolean EnableDtcActivity;
    private Boolean EnableCheckEngineActivity;
    private Boolean EnableTowActivity;
    private Boolean EnableMaintenanceActivity;
    private Boolean EnableRecallActivity;
    private Boolean EnableServiceBulletinActivity;
    private Boolean EnableDisturbanceActivity;
    private Boolean EnableAccidentActivity;
    private Boolean EnableDeviceUnpluggedActivity;
    private Boolean EnableGeofenceActivity;
    private Geofence[] EnabledGeofences;

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

    public Boolean getEnableMaintenanceActivity() {
        return EnableMaintenanceActivity;
    }

    public void setEnableMaintenanceActivity(Boolean enableMaintenanceActivity) {
        EnableMaintenanceActivity = enableMaintenanceActivity;
    }

    public Boolean getEnableDisturbanceActivity() {
        return EnableDisturbanceActivity;
    }

    public void setEnableDisturbanceActivity(Boolean enableDisturbanceActivity) {
        EnableDisturbanceActivity = enableDisturbanceActivity;
    }

    public Boolean getEnableAccidentActivity() {
        return EnableAccidentActivity;
    }

    public void setEnableAccidentActivity(Boolean enableAccidentActivity) {
        EnableAccidentActivity = enableAccidentActivity;
    }

    public Boolean getEnableDeviceUnpluggedActivity() {
        return EnableDeviceUnpluggedActivity;
    }

    public void setEnableDeviceUnpluggedActivity(Boolean enableDeviceUnpluggedActivity) {
        EnableDeviceUnpluggedActivity = enableDeviceUnpluggedActivity;
    }

    public Geofence[] getEnabledGeofences() {
        return EnabledGeofences;
    }

    public void setEnabledGeofences(Geofence[] enabledGeofences) {
        EnabledGeofences = enabledGeofences;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "EnableTripStartActivity=" + EnableTripStartActivity +
                ", EnableTripCompletedActivity=" + EnableTripCompletedActivity +
                ", EnableLowFuelActivity=" + EnableLowFuelActivity +
                ", EnableLowBatteryActivity=" + EnableLowBatteryActivity +
                ", EnableSpeedActivity=" + EnableSpeedActivity +
                ", SpeedThreshold=" + SpeedThreshold +
                ", EnableDtcActivity=" + EnableDtcActivity +
                ", EnableCheckEngineActivity=" + EnableCheckEngineActivity +
                ", EnableTowActivity=" + EnableTowActivity +
                ", EnableMaintenanceActivity=" + EnableMaintenanceActivity +
                ", EnableRecallActivity=" + EnableRecallActivity +
                ", EnableServiceBulletinActivity=" + EnableServiceBulletinActivity +
                ", EnableDisturbanceActivity=" + EnableDisturbanceActivity +
                ", EnableAccidentActivity=" + EnableAccidentActivity +
                ", EnableDeviceUnpluggedActivity=" + EnableDeviceUnpluggedActivity +
                ", EnableGeofenceActivity=" + EnableGeofenceActivity +
                ", EnabledGeofences=" + Arrays.toString(EnabledGeofences) +
                '}';
    }

    public static class Geofence {
        private String Id;
        private Boolean EnableEnterActivity;
        private Boolean EnableExitActivity;

        public Geofence() {}

        public Geofence(String id) {
            this.Id = id;
        }

        public String getId() {
            return Id;
        }

        public void setId(String id) {
            Id = id;
        }

        public Boolean getEnableEnterActivity() {
            return EnableEnterActivity;
        }

        public void setEnableEnterActivity(Boolean enableEnterActivity) {
            EnableEnterActivity = enableEnterActivity;
        }

        public Boolean getEnableExitActivity() {
            return EnableExitActivity;
        }

        public void setEnableExitActivity(Boolean enableExitActivity) {
            EnableExitActivity = enableExitActivity;
        }

        @Override
        public String toString() {
            return "Geofence{" +
                    "Id='" + Id + '\'' +
                    ", EnableEnterActivity=" + EnableEnterActivity +
                    ", EnableExitActivity=" + EnableExitActivity +
                    '}';
        }
    }
}
