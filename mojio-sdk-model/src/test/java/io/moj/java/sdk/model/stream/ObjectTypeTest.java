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
                .put("CheckEngineLight", ObjectType.CHECK_ENGINE_LIGHT)
                .put("Geofence", ObjectType.GEOFENCE)
                .put("Recall", ObjectType.RECALL)
                .put("Note", ObjectType.NOTE)
                .put("OilLevel", ObjectType.OIL_LEVEL)
                .put("OilPressure", ObjectType.OIL_PRESSURE)
                .put("BatteryPredictiveMaintenance", ObjectType.BATTERY_PREDICTION)
                .put("AirFilterPredictiveMaintenance", ObjectType.AIR_FILTER_PREDICTION)
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
