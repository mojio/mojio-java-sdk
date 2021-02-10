package io.moj.java.sdk.model.stream;

import java.util.Arrays;

import com.google.gson.annotations.SerializedName;

import io.moj.java.sdk.model.values.Speed;

/**
 * Activity stream settings model.
 * Created by Mauro on 2016-06-23.
 */
public class Settings {

    public static final String ENABLE_TRIP_START = "EnableTripStartActivity";
    public static final String ENABLE_TRIP_COMPLETED = "EnableTripCompletedActivity";
    public static final String ENABLE_LOW_FUEL = "EnableLowFuelActivity";
    public static final String LOW_FUEL_ACTIVITY_MODE = "LowFuelActivityMode";
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
    public static final String ENABLE_ACCIDENT_E911 = "EnableAccidentE911Activity";
    public static final String ENABLE_ACCIDENT_SOS = "EnableAccidentSOSActivity";
    public static final String ENABLE_DEVICE_UPDATED = "EnableDeviceUpdatedActivity";
    public static final String ENABLE_SMS = "EnableSMSActivity";
    public static final String ENABLE_VEHICLE_COMPATIBILITY = "EnableVehicleCompatibilityActivity";
    public static final String ENABLE_MAIN_FIRMWARE_COMPATIBILITY = "EnableMainFirmwareCompatibilityActivity";
    public static final String ENABLE_HARDWARE_VERSION_COMPATIBILITY = "EnableHardwareVersionCompatibilityActivity";
    public static final String ENABLE_SERVICE_SCHEDULE = "EnableServiceScheduleActivity";
    public static final String ENABLE_TIRE_PRESSURE_WARNING = "EnableTirePressureWarningActivity";
    public static final String ENABLE_AIR_FILTER_MAINTENANCE = "EnableAirFilterMaintenanceActivity";
    public static final String ENABLE_SEATBELT_DISENGAGED_ACTIVITY = "EnableSeatbeltDisengagedActivity";
    public static final String ENABLE_SEATBELT_ENGAGED_ACTIVITY = "EnableSeatbeltEngagedActivity";
    public static final String ENABLE_DRIVER_SEATBELT_DISENGAGED_ACTIVITY = "EnableDriverSeatbeltDisengagedActivity";
    public static final String ENABLE_DRIVER_SEATBELT_ENGAGED_ACTIVITY = "EnableDriverSeatbeltEngagedActivity";
    public static final String ENABLE_PASSENGER_SEATBELT_DISENGAGED_ACTIVITY = "EnablePassengerSeatbeltDisengagedActivity";
    public static final String ENABLE_PASSENGER_SEATBELT_ENGAGED_ACTIVITY = "EnablePassengerSeatbeltEngagedActivity";
    public static final String ENABLE_ENGINE_OIL_LEVEL_WARNING_ACTIVITY = "EnableEngineOilLevelWarningActivity";
    public static final String ENABLE_ENGINE_OIL_PRESSURE_LOW_WARNING_ACTIVITY = "EnableEngineOilPressureLowWarningActivity";
    public static final String ENABLE_LOW_BRAKE_FLUID_WARNING_ACTIVITY = "EnableLowBrakeFluidWarningActivity";
    public static final String ENABLE_MAINTENANCE_REMINDER_ACTIVITY = "EnableMaintenanceReminderActivity";

    // V2 + V3 fields
    @SerializedName(value = "EnableTripStartActivity", alternate = "enableTripStartActivity")
    private Boolean EnableTripStartActivity;
    @SerializedName(value = "EnableTripCompletedActivity", alternate = "enableTripCompletedActivity")
    private Boolean EnableTripCompletedActivity;
    @SerializedName(value = "EnableLowFuelActivity", alternate = "enableLowFuelActivity")
    private Boolean EnableLowFuelActivity;
    @SerializedName(value = "lowFuelActivityMode", alternate = "LowFuelActivityMode")
    private String LowFuelActivityMode;
    @SerializedName(value = "EnableLowBatteryActivity", alternate = "enableLowBatteryActivity")
    private Boolean EnableLowBatteryActivity;
    @SerializedName(value = "EnableSpeedActivity", alternate = "enableSpeedActivity")
    private Boolean EnableSpeedActivity;
    @SerializedName(value = "SpeedThreshold", alternate = "speedThreshold")
    private Speed SpeedThreshold;
    @SerializedName(value = "EnableDtcActivity", alternate = "enableDtcActivity")
    private Boolean EnableDtcActivity;
    @SerializedName(value = "EnableCheckEngineActivity", alternate = "enableCheckEngineActivity")
    private Boolean EnableCheckEngineActivity;
    @SerializedName(value = "EnableTowActivity", alternate = "enableTowActivity")
    private Boolean EnableTowActivity;
    @SerializedName(value = "EnableMaintenanceActivity", alternate = "enableMaintenanceActivity")
    private Boolean EnableMaintenanceActivity;
    @SerializedName(value = "EnableRecallActivity", alternate = "enableRecallActivity")
    private Boolean EnableRecallActivity;
    @SerializedName(value = "EnableServiceBulletinActivity", alternate = "enableServiceBulletinActivity")
    private Boolean EnableServiceBulletinActivity;
    @SerializedName(value = "EnableDisturbanceActivity", alternate = "enableDisturbanceActivity")
    private Boolean EnableDisturbanceActivity;
    @SerializedName(value = "DisturbanceThreshold", alternate = "disturbanceThreshold")
    private String DisturbanceThreshold;
    @SerializedName(value = "EnableAccidentActivity", alternate = "enableAccidentActivity")
    private Boolean EnableAccidentActivity;
    @SerializedName(value = "EnableDeviceUnpluggedActivity", alternate = "enableDeviceUnpluggedActivity")
    private Boolean EnableDeviceUnpluggedActivity;
    @SerializedName(value = "EnableVehicleConnectedActivity", alternate = "enableVehicleConnectedActivity")
    private Boolean EnableVehicleConnectedActivity;

    // V2 only fields
    @SerializedName(value = "EnableGeofenceActivity", alternate = "enableGeofenceActivity")
    private Boolean EnableGeofenceActivity;
    @SerializedName(value = "Geofences", alternate = "geofences")
    private Geofence[] Geofences;

    // V3 only fields
    @SerializedName(value = "EnableAccidentE911Activity", alternate = "enableAccidentE911Activity")
    private Boolean EnableAccidentE911Activity;
    @SerializedName(value = "EnableAccidentSOSActivity", alternate = "enableAccidentSOSActivity")
    private Boolean EnableAccidentSOSActivity;
    @SerializedName(value = "EnableDeviceUpdatedActivity", alternate = "enableDeviceUpdatedActivity")
    private Boolean EnableDeviceUpdatedActivity;
    @SerializedName(value = "EnableSMSActivity", alternate = "enableSMSActivity")
    private Boolean EnableSMSActivity;
    @SerializedName(value = "EnableVehicleCompatibilityActivity", alternate = "enableVehicleCompatibilityActivity")
    private Boolean EnableVehicleCompatibilityActivity;
    @SerializedName(value = "EnableMainFirmwareCompatibilityActivity", alternate = "enableMainFirmwareCompatibilityActivity")
    private Boolean EnableMainFirmwareCompatibilityActivity;
    @SerializedName(value = "EnableHardwareVersionCompatibilityActivity", alternate = "enableHardwareVersionCompatibilityActivity")
    private Boolean EnableHardwareVersionCompatibilityActivity;
    @SerializedName(value = "EnableServiceScheduleActivity", alternate = "enableServiceScheduleActivity")
    private Boolean EnableServiceScheduleActivity;

    @SerializedName(value = "EnableTirePressureWarningActivity", alternate = "enableTirePressureWarningActivity")
    private Boolean EnableTirePressureWarningActivity;

    @SerializedName(value = "EnableAirFilterMaintenanceActivity", alternate = "enableAirFilterMaintenanceActivity")
    private Boolean EnableAirFilterMaintenanceActivity;

    @SerializedName(value = ENABLE_SEATBELT_DISENGAGED_ACTIVITY, alternate = "enableSeatbeltDisengagedActivity")
    private Boolean EnableSeatbeltDisengagedActivity;
    @SerializedName(value = ENABLE_SEATBELT_ENGAGED_ACTIVITY, alternate = "enableSeatbeltEngagedActivity")
    private Boolean EnableSeatbeltEngagedActivity;
    @SerializedName(value = ENABLE_DRIVER_SEATBELT_DISENGAGED_ACTIVITY, alternate = "enableDriverSeatbeltDisengagedActivity")
    private Boolean EnableDriverSeatbeltDisengagedActivity;
    @SerializedName(value = ENABLE_DRIVER_SEATBELT_ENGAGED_ACTIVITY, alternate = "enableDriverSeatbeltEngagedActivity")
    private Boolean EnableDriverSeatbeltEngagedActivity;
    @SerializedName(value = ENABLE_PASSENGER_SEATBELT_DISENGAGED_ACTIVITY, alternate = "enablePassengerSeatbeltDisengagedActivity")
    private Boolean EnablePassengerSeatbeltDisengagedActivity;
    @SerializedName(value = ENABLE_PASSENGER_SEATBELT_ENGAGED_ACTIVITY, alternate = "enablePassengerSeatbeltEngagedActivity")
    private Boolean EnablePassengerSeatbeltEngagedActivity;
    @SerializedName(value = ENABLE_ENGINE_OIL_LEVEL_WARNING_ACTIVITY, alternate = "enableEngineOilLevelWarningActivity")
    private Boolean EnableEngineOilLevelWarningActivity;
    @SerializedName(value = ENABLE_ENGINE_OIL_PRESSURE_LOW_WARNING_ACTIVITY, alternate = "enableEngineOilPressureLowWarningActivity")
    private Boolean EnableEngineOilPressureLowWarningActivity;
    @SerializedName(value = ENABLE_LOW_BRAKE_FLUID_WARNING_ACTIVITY, alternate = "enableLowBrakeFluidWarningActivity")
    private Boolean EnableLowBrakeFluidWarningActivity;
    @SerializedName(value = ENABLE_MAINTENANCE_REMINDER_ACTIVITY, alternate = "enableMaintenanceReminderActivity")
    private Boolean EnableMaintenanceReminderActivity;

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

    public LowFuelMode getLowFuelActivityMode() {
        return LowFuelMode.fromKey(LowFuelActivityMode);
    }

    public void setLowFuelActivityMode(LowFuelMode lowFuelMode) {
        LowFuelActivityMode = lowFuelMode == null ? null : lowFuelMode.getKey();
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

    public Boolean getEnableAccidentE911Activity() {
        return EnableAccidentE911Activity;
    }

    public void setEnableAccidentE911Activity(Boolean enableAccidentE911Activity) {
        EnableAccidentE911Activity = enableAccidentE911Activity;
    }

    public Boolean getEnableAccidentSOSActivity() {
        return EnableAccidentSOSActivity;
    }

    public void setEnableAccidentSOSActivity(Boolean enableAccidentSOSActivity) {
        EnableAccidentSOSActivity = enableAccidentSOSActivity;
    }

    public Boolean getEnableDeviceUpdatedActivity() {
        return EnableDeviceUpdatedActivity;
    }

    public void setEnableDeviceUpdatedActivity(Boolean enableDeviceUpdatedActivity) {
        EnableDeviceUpdatedActivity = enableDeviceUpdatedActivity;
    }

    public Boolean getEnableSMSActivity() {
        return EnableSMSActivity;
    }

    public void setEnableSMSActivity(Boolean enableSMSActivity) {
        EnableSMSActivity = enableSMSActivity;
    }

    public Boolean getEnableVehicleCompatibilityActivity() {
        return EnableVehicleCompatibilityActivity;
    }

    public void setEnableVehicleCompatibilityActivity(Boolean enableVehicleCompatibilityActivity) {
        EnableVehicleCompatibilityActivity = enableVehicleCompatibilityActivity;
    }

    public Boolean getEnableMainFirmwareCompatibilityActivity() {
        return EnableMainFirmwareCompatibilityActivity;
    }

    public void setEnableMainFirmwareCompatibilityActivity(Boolean enableMainFirmwareCompatibilityActivity) {
        EnableMainFirmwareCompatibilityActivity = enableMainFirmwareCompatibilityActivity;
    }

    public Boolean getEnableHardwareVersionCompatibilityActivity() {
        return EnableHardwareVersionCompatibilityActivity;
    }

    public void setEnableHardwareVersionCompatibilityActivity(Boolean enableHardwareVersionCompatibilityActivity) {
        EnableHardwareVersionCompatibilityActivity = enableHardwareVersionCompatibilityActivity;
    }

    public Boolean getEnableServiceScheduleActivity() {
        return EnableServiceScheduleActivity;
    }

    public void setEnableServiceScheduleActivity(Boolean enableServiceScheduleActivity) {
        EnableServiceScheduleActivity = enableServiceScheduleActivity;
    }

    public Boolean getEnableTirePressureWarningActivity() {
        return EnableTirePressureWarningActivity;
    }

    public void setEnableTirePressureWarningActivity(Boolean enableTirePressureWarningActivity) {
        EnableTirePressureWarningActivity = enableTirePressureWarningActivity;
    }

    public Boolean getEnableAirFilterMaintenanceActivity() {
        return EnableAirFilterMaintenanceActivity;
    }

    public void setEnableAirFilterMaintenanceActivity(Boolean enableAirFilterMaintenanceActivity) {
        EnableAirFilterMaintenanceActivity = enableAirFilterMaintenanceActivity;
    }

    public Boolean getEnableSeatbeltDisengagedActivity() {
        return EnableSeatbeltDisengagedActivity;
    }

    public void setEnableSeatbeltDisengagedActivity(Boolean enableSeatbeltDisengagedActivity) {
        EnableSeatbeltDisengagedActivity = enableSeatbeltDisengagedActivity;
    }

    public Boolean getEnableSeatbeltEngagedActivity() {
        return EnableSeatbeltEngagedActivity;
    }

    public void setEnableSeatbeltEngagedActivity(Boolean enableSeatbeltEngagedActivity) {
        EnableSeatbeltEngagedActivity = enableSeatbeltEngagedActivity;
    }

    public Boolean getEnableDriverSeatbeltDisengagedActivity() {
        return EnableDriverSeatbeltDisengagedActivity;
    }

    public void setEnableDriverSeatbeltDisengagedActivity(Boolean enableDriverSeatbeltDisengagedActivity) {
        EnableDriverSeatbeltDisengagedActivity = enableDriverSeatbeltDisengagedActivity;
    }

    public Boolean getEnableDriverSeatbeltEngagedActivity() {
        return EnableDriverSeatbeltEngagedActivity;
    }

    public void setEnableDriverSeatbeltEngagedActivity(Boolean enableDriverSeatbeltEngagedActivity) {
        EnableDriverSeatbeltEngagedActivity = enableDriverSeatbeltEngagedActivity;
    }

    public Boolean getEnablePassengerSeatbeltDisengagedActivity() {
        return EnablePassengerSeatbeltDisengagedActivity;
    }

    public void setEnablePassengerSeatbeltDisengagedActivity(Boolean enablePassengerSeatbeltDisengagedActivity) {
        EnablePassengerSeatbeltDisengagedActivity = enablePassengerSeatbeltDisengagedActivity;
    }

    public Boolean getEnablePassengerSeatbeltEngagedActivity() {
        return EnablePassengerSeatbeltEngagedActivity;
    }

    public void setEnablePassengerSeatbeltEngagedActivity(Boolean enablePassengerSeatbeltEngagedActivity) {
        EnablePassengerSeatbeltEngagedActivity = enablePassengerSeatbeltEngagedActivity;
    }

    public Boolean getEnableEngineOilLevelWarningActivity() {
        return EnableEngineOilLevelWarningActivity;
    }

    public void setEnableEngineOilLevelWarningActivity(Boolean enableEngineOilLevelWarningActivity) {
        EnableEngineOilLevelWarningActivity = enableEngineOilLevelWarningActivity;
    }

    public Boolean getEnableEngineOilPressureLowWarningActivity() {
        return EnableEngineOilPressureLowWarningActivity;
    }

    public void setEnableEngineOilPressureLowWarningActivity(Boolean enableEngineOilPressureLowWarningActivity) {
        EnableEngineOilPressureLowWarningActivity = enableEngineOilPressureLowWarningActivity;
    }

    public Boolean getEnableLowBrakeFluidWarningActivity() {
        return EnableLowBrakeFluidWarningActivity;
    }

    public void setEnableLowBrakeFluidWarningActivity(Boolean enableLowBrakeFluidWarningActivity) {
        EnableLowBrakeFluidWarningActivity = enableLowBrakeFluidWarningActivity;
    }

    public Boolean getEnableMaintenanceReminderActivity() {
        return EnableMaintenanceReminderActivity;
    }

    public void setEnableMaintenanceReminderActivity(Boolean enableMaintenanceReminderActivity) {
        EnableMaintenanceReminderActivity = enableMaintenanceReminderActivity;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "EnableTripStartActivity=" + EnableTripStartActivity +
                ", EnableTripCompletedActivity=" + EnableTripCompletedActivity +
                ", EnableLowFuelActivity=" + EnableLowFuelActivity +
                ", LowFuelActivityMode='" + LowFuelActivityMode + '\'' +
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
                ", EnableAccidentE911Activity=" + EnableAccidentE911Activity +
                ", EnableAccidentSOSActivity=" + EnableAccidentSOSActivity +
                ", EnableDeviceUpdatedActivity=" + EnableDeviceUpdatedActivity +
                ", EnableSMSActivity=" + EnableSMSActivity +
                ", EnableVehicleCompatibilityActivity=" + EnableVehicleCompatibilityActivity +
                ", EnableMainFirmwareCompatibilityActivity=" + EnableMainFirmwareCompatibilityActivity +
                ", EnableHardwareVersionCompatibilityActivity=" + EnableHardwareVersionCompatibilityActivity +
                ", EnableServiceScheduleActivity=" + EnableServiceScheduleActivity +
                ", EnableTirePressureWarningActivity=" + EnableTirePressureWarningActivity +
                ", EnableAirFilterMaintenanceActivity=" + EnableAirFilterMaintenanceActivity +
                ", EnableSeatbeltDisengagedActivity=" + EnableSeatbeltDisengagedActivity +
                ", EnableSeatbeltEngagedActivity=" + EnableSeatbeltEngagedActivity +
                ", EnableDriverSeatbeltDisengagedActivity=" + EnableDriverSeatbeltDisengagedActivity +
                ", EnableDriverSeatbeltEngagedActivity=" + EnableDriverSeatbeltEngagedActivity +
                ", EnablePassengerSeatbeltDisengagedActivity=" + EnablePassengerSeatbeltDisengagedActivity +
                ", EnablePassengerSeatbeltEngagedActivity=" + EnablePassengerSeatbeltEngagedActivity +
                ", EnableEngineOilLevelWarningActivity=" + EnableEngineOilLevelWarningActivity +
                ", EnableEngineOilPressureLowWarningActivity=" + EnableEngineOilPressureLowWarningActivity +
                ", EnableLowBrakeFluidWarningActivity=" + EnableLowBrakeFluidWarningActivity +
                ", EnableMaintenanceReminderActivity=" + EnableMaintenanceReminderActivity +
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

    public enum LowFuelMode {
        LOW("Low"),
        SMART("Intelligent");

        private String key;

        LowFuelMode(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public static LowFuelMode fromKey(String key) {
            for (LowFuelMode lowFuelMode : values()) {
                if (lowFuelMode.getKey().equals(key)) {
                    return lowFuelMode;
                }
            }
            return null;
        }
    }
}
