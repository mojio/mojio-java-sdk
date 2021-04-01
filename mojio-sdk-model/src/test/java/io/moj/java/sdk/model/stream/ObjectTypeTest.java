package io.moj.java.sdk.model.stream;

import com.google.common.collect.ImmutableMap;
import io.moj.java.sdk.model.enums.EnumTest;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by skidson on 2016-07-08.
 */
public class ObjectTypeTest extends EnumTest<ObjectType> {

    @Override
    public Map<String, ObjectType> getMapping() {
        return new ImmutableMap.Builder<String, ObjectType>()
                .put("SpeedLimit", ObjectType.SPEED_LIMIT)
                .put("DiagnosticTroubleCode", ObjectType.DTC)
                .put("TelematicDevice", ObjectType.TELEMATIC_DEVICE)
                .put("Battery", ObjectType.BATTERY)
                .put("FuelLevel", ObjectType.FUEL_LEVEL)
                .put("IntelligentFuelLevel", ObjectType.FUEL_LEVEL_SMART)
                .put("CheckEngineLight", ObjectType.CHECK_ENGINE_LIGHT)
                .put("Geofence", ObjectType.GEOFENCE)
                .put("Recall", ObjectType.RECALL)
                .put("Note", ObjectType.NOTE)
                .put("TirePressure", ObjectType.TIRE_PRESSURE)
                .put("OilLevel", ObjectType.OIL_LEVEL)
                .put("OilPressure", ObjectType.OIL_PRESSURE)
                .put("BatteryPredictiveMaintenance", ObjectType.BATTERY_PREDICTION)
                .put("AirFilterPredictiveMaintenance", ObjectType.AIR_FILTER_PREDICTION)
                .put("Seatbelt", ObjectType.SEATBELT)
                .put("LowBrakeFluidWarning", ObjectType.LOW_BRAKE_FLUID_WARNING)
                .put("EmergencyIncident", ObjectType.EMERGENCY_INCIDENT)
                .put("MaintenanceReminder", ObjectType.MAINTENANCE_REMINDER)
                .put("IntelligentFuelSavedAndRecommendedFillup", ObjectType.INTELLIGENT_FUEL_SAVED_AND_RECOMMENDED_FILLUP)
                .put("IntelligentFuelRecommendedFillup", ObjectType.INTELLIGENT_FUEL_RECOMMENDED_FILLUP)
                .put("IntelligentFuelNotRecommendedFillup", ObjectType.INTELLIGENT_FUEL_NOT_RECOMMENDED_FILLUP)
                .build();
    }

    @Test
    @Override
    public void testFromKey() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testFromKey();
    }

    @Test
    @Override
    public void testFromKey_invalid() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testFromKey_invalid();
    }

    @Test
    @Override
    public void testGetKey() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testGetKey();
    }

    @Test
    @Override
    public void testValues() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testValues();
    }
}
