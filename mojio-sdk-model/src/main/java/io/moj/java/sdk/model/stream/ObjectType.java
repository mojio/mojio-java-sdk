package io.moj.java.sdk.model.stream;

/**
 * Activity stream object types
 * Created by Mauro on 2016-07-01.
 */
public enum ObjectType {
    SPEED_LIMIT("SpeedLimit"),
    DTC("DiagnosticTroubleCode"),
    TELEMATIC_DEVICE("TelematicDevice"),
    BATTERY("Battery"),
    CHECK_ENGINE_LIGHT("CheckEngineLight"),
    FUEL_LEVEL("FuelLevel"),
    FUEL_LEVEL_SMART("IntelligentFuelLevel"),
    GEOFENCE("Geofence"),
    RECALL("Recall"),
    NOTE("Note"),
    TIRE_PRESSURE("TirePressure"),
    OIL_LEVEL("OilLevel"),
    OIL_PRESSURE("OilPressure"),
    BATTERY_PREDICTION("BatteryPredictiveMaintenance"),
    AIR_FILTER_PREDICTION("AirFilterPredictiveMaintenance"),
    SEATBELT("Seatbelt"),
    LOW_BRAKE_FLUID_WARNING("LowBrakeFluidWarning"),
    EMERGENCY_INCIDENT("EmergencyIncident"),
    EMERGENCY_LIGHT_INCIDENT("EmergencyLightIncident"),
    MAINTENANCE_REMINDER("MaintenanceReminder"),
    INTELLIGENT_FUEL_SAVED_AND_RECOMMENDED_FILLUP("IntelligentFuelSavedAndRecommendedFillup"),
    INTELLIGENT_FUEL_RECOMMENDED_FILLUP("IntelligentFuelRecommendedFillup"),
    INTELLIGENT_FUEL_NOT_RECOMMENDED_FILLUP("IntelligentFuelNotRecommendedFillup");

    private String key;

    ObjectType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static ObjectType fromKey(String key) {
        for (ObjectType type : values()) {
            if (type.getKey().equals(key)) {
                return type;
            }
        }
        return null;
    }
}
