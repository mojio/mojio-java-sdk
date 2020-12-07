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
    AIR_FILTER_PREDICTION("AirFilterPredictiveMaintenance");


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
