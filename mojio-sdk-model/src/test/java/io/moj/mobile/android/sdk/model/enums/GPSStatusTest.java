package io.moj.mobile.android.sdk.model.enums;

import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class GPSStatusTest extends EnumTest<GPSStatus> {

    @Override
    public Map<String, GPSStatus> getMapping() {
        // these are defined by the server's contract so should be safe to validate against in tests
        return new ImmutableMap.Builder<String, GPSStatus>()
                .put("Unknown", GPSStatus.UNKNOWN)
                .put("Locked", GPSStatus.LOCKED)
                .put("NotLocked", GPSStatus.NOT_LOCKED)
                .put("Predicted", GPSStatus.PREDICTED)
                .put("DiffCorrected", GPSStatus.DIFF_CORRECTED)
                .put("LastKnown", GPSStatus.LAST_KNOWN)
                .put("TwoDFix", GPSStatus.TWO_D_FIX)
                .put("Historic", GPSStatus.HISTORIC)
                .put("InvalidTime", GPSStatus.INVALID_TIME)
                .put("CommunicationsFailure", GPSStatus.COMMUNICATIONS_FAILURE)
                .put("GPSOff", GPSStatus.GPS_OFF)
                .put("PreviousValidState", GPSStatus.PREVIOUS_VALID_STATE)
                .build();
    }

    @Test
    @Override
    public void testSerialization() {
        super.testSerialization();
    }

    @Test
    public void testDeserialization() {
        super.testDeserialization();
    }

    @Test
    @Override
    public void testFromKey() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        super.testFromKey();
    }

    @Test
    @Override
    public void testFromKey_invalid() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
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