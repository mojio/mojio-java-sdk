package io.moj.java.sdk.model.stream;

import java.util.Arrays;

import io.moj.java.sdk.model.values.Speed;

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
    public static final String DISTURBANCE_THRESHOLD = "DisturbanceThreshold";
    public static final String ENABLE_ACCIDENT = "EnableAccidentActivity";
    public static final String ENABLE_DEVICE_UNPLUGGED = "EnableDeviceUnpluggedActivity";
    public static final String ENABLE_VEHICLE_CONNECTED = "EnableVehicleConnectedActivity";
    public static final String ENABLE_GEOFENCE = "EnableGeofenceActivity";
    public static final String GEOFENCES = "Geofences";

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
    private String DisturbanceThreshold;
    private Boolean EnableAccidentActivity;
    private Boolean EnableDeviceUnpluggedActivity;
    private Boolean EnableVehicleConnectedActivity;
    private Boolean EnableGeofenceActivity;
    private Geofence[] Geofences;

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

    public DisturbanceSensitivity getDisturbanceThreshold() {
        return DisturbanceSensitivity.fromKey(DisturbanceThreshold);
    }

    public void setDisturbanceThreshold(DisturbanceSensitivity disturbanceThreshold) {
        DisturbanceThreshold = disturbanceThreshold == null ? null : disturbanceThreshold.getKey();
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

    public Boolean getEnableVehicleConnectedActivity() {
        return EnableVehicleConnectedActivity;
    }

    public void setEnableVehicleConnectedActivity(Boolean enableVehicleConnectedActivity) {
        EnableVehicleConnectedActivity = enableVehicleConnectedActivity;
    }

    public Geofence[] getGeofences() {
        return Geofences;
    }

    public void setGeofences(Geofence[] geofences) {
        Geofences = geofences;
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
                ", DisturbanceThreshold='" + DisturbanceThreshold + '\'' +
                ", EnableAccidentActivity=" + EnableAccidentActivity +
                ", EnableDeviceUnpluggedActivity=" + EnableDeviceUnpluggedActivity +
                ", EnableVehicleConnectedActivity=" + EnableVehicleConnectedActivity +
                ", EnableGeofenceActivity=" + EnableGeofenceActivity +
                ", Geofences=" + Arrays.toString(Geofences) +
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

    public enum DisturbanceSensitivity {
        LOW("Low"),
        MEDIUM("Medium"),
        HIGH("High");

        private String key;

        DisturbanceSensitivity(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public static DisturbanceSensitivity fromKey(String key) {
            for (DisturbanceSensitivity disturbanceSensitivity : values()) {
                if (disturbanceSensitivity.getKey().equals(key)) {
                    return disturbanceSensitivity;
                }
            }
            return null;
        }
    }
}
