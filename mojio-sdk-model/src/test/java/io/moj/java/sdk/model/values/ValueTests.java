package io.moj.java.sdk.model.values;

import org.junit.Test;

import static io.moj.java.sdk.test.TestUtils.assertAccess;
import static io.moj.java.sdk.test.TestUtils.assertToStringContainsAllFields;

/**
 * Created by skidson on 16-02-23.
 */
public class ValueTests {

    @Test
    public void testAcceleration() throws IllegalAccessException {
        assertToStringContainsAllFields(new Acceleration());
        assertAccess(new Acceleration());
    }

    @Test
    public void testAccelerometer() throws IllegalAccessException {
        assertToStringContainsAllFields(new Accelerometer());
        assertAccess(new Accelerometer());
    }

    @Test
    public void testAddress() throws IllegalAccessException {
        assertToStringContainsAllFields(new Address());
        assertAccess(new Address());
    }

    @Test
    public void testAggregate() throws IllegalAccessException {
        assertToStringContainsAllFields(new Aggregate());
        assertAccess(new Aggregate());
    }

    @Test
    public void testBattery() throws IllegalAccessException {
        assertToStringContainsAllFields(new Battery());
        assertAccess(new Battery());
    }

    @Test
    public void testBooleanState() throws IllegalAccessException {
        assertToStringContainsAllFields(new BooleanState());
        assertAccess(new BooleanState());
    }

    @Test
    public void testDiagnosticCode() throws IllegalAccessException {
        assertToStringContainsAllFields(new DiagnosticCode());
        assertAccess(new DiagnosticCode());
    }

    @Test
    public void testDistance() throws IllegalAccessException {
        assertToStringContainsAllFields(new Distance());
        assertAccess(new Distance());
    }

    @Test
    public void testDuration() throws IllegalAccessException {
        assertToStringContainsAllFields(new Duration());
        assertAccess(new Duration());
    }

    @Test
    public void testEmail() throws IllegalAccessException {
        assertToStringContainsAllFields(new Email());
        assertAccess(new Email());
    }

    @Test
    public void testEngine() throws IllegalAccessException {
        assertToStringContainsAllFields(new Engine());
        assertAccess(new Engine());
    }

    @Test
    public void testFuelEfficiency() throws IllegalAccessException {
        assertToStringContainsAllFields(new FuelEfficiency());
        assertAccess(new FuelEfficiency());
    }

    @Test
    public void testFuelLevel() throws IllegalAccessException {
        assertToStringContainsAllFields(new FuelLevel());
        assertAccess(new FuelLevel());
    }

    @Test
    public void testHarshEvent() throws IllegalAccessException {
        assertToStringContainsAllFields(new HarshEvent());
        assertAccess(new HarshEvent());
    }

    @Test
    public void testHarshEventState() throws IllegalAccessException {
        assertToStringContainsAllFields(new HarshEventState());
        assertAccess(new HarshEventState());
    }

    @Test
    public void testHeading() throws IllegalAccessException {
        assertToStringContainsAllFields(new Heading());
        assertAccess(new Heading());
    }

    @Test
    public void testIdleEvent() throws IllegalAccessException {
        assertToStringContainsAllFields(new IdleEvent());
        assertAccess(new IdleEvent());
    }

    @Test
    public void testIdleState() throws IllegalAccessException {
        assertToStringContainsAllFields(new IdleEventState());
        assertAccess(new IdleEventState());
    }

    @Test
    public void testImage() throws IllegalAccessException {
        assertToStringContainsAllFields(new Image());
        assertAccess(new Image());
    }

    @Test
    public void testLocation() throws IllegalAccessException {
        assertToStringContainsAllFields(new Location());
        assertAccess(new Location(), Location.STATUS);
    }

    @Test
    public void testLinkInfo() throws IllegalAccessException {
        assertToStringContainsAllFields(new LinkInfo());
        assertAccess(new LinkInfo());
    }

    @Test
    public void testMeasurementStatistics() throws IllegalAccessException {
        assertToStringContainsAllFields(new MeasurementStatistics());
        assertAccess(new MeasurementStatistics());
    }

    @Test
    public void testNextServiceSchedule() throws IllegalAccessException {
        assertToStringContainsAllFields(new NextServiceSchedule());
        assertAccess(new NextServiceSchedule());
    }

    @Test
    public void testOdometer() throws IllegalAccessException {
        assertToStringContainsAllFields(new Odometer());
        assertAccess(new Odometer());
    }

    @Test
    public void testPermission() throws IllegalAccessException {
        assertToStringContainsAllFields(new AccessModel());
        assertAccess(new AccessModel());
    }

    @Test
    public void testPhoneNumber() throws IllegalAccessException {
        assertToStringContainsAllFields(new PhoneNumber());
        assertAccess(new PhoneNumber());
    }

    @Test
    public void testProperAcceleration() throws IllegalAccessException {
        assertToStringContainsAllFields(new ProperAcceleration());
        assertAccess(new ProperAcceleration());
    }

    @Test
    public void testRecall() throws IllegalAccessException {
        assertToStringContainsAllFields(new Recall());
        assertAccess(new Recall());
    }

    @Test
    public void testRegion() throws IllegalAccessException {
        assertToStringContainsAllFields(new Region());
        assertAccess(new Region());
    }

    @Test
    public void testRpm() throws IllegalAccessException {
        assertToStringContainsAllFields(new Rpm());
        assertAccess(new Rpm());
    }

    @Test
    public void testScore() throws IllegalAccessException {
        assertToStringContainsAllFields(new Score());
        assertAccess(new Score());
    }

    @Test
    public void testServiceBulletin() throws IllegalAccessException {
        assertToStringContainsAllFields(new ServiceBulletin());
        assertAccess(new ServiceBulletin());
    }

    @Test
    public void testServiceSchedule() throws IllegalAccessException {
        assertToStringContainsAllFields(new ServiceSchedule());
        assertAccess(new ServiceSchedule());
    }

    @Test
    public void testSpeed() throws IllegalAccessException {
        assertToStringContainsAllFields(new Speed());
        assertAccess(new Speed());
    }

    @Test
    public void testStorageEntry() throws IllegalAccessException {
        assertToStringContainsAllFields(new StorageEntry());
        assertAccess(new StorageEntry());
    }

    @Test
    public void testTransmission() throws IllegalAccessException {
        assertToStringContainsAllFields(new Transmission());
        assertAccess(new Transmission());
    }

    @Test
    public void testVehicleDetails() throws IllegalAccessException {
        assertToStringContainsAllFields(new VehicleDetails());
        assertAccess(new VehicleDetails());
    }

    @Test
    public void testVehicleStatistics() throws IllegalAccessException {
        assertToStringContainsAllFields(new VehicleStatistics());
        assertAccess(new VehicleStatistics());
    }

    @Test
    public void testVinDetails() throws IllegalAccessException {
        assertToStringContainsAllFields(new VinDetails());
        assertAccess(new VinDetails());
    }

    @Test
    public void testVoltage() throws IllegalAccessException {
        assertToStringContainsAllFields(new Voltage());
        assertAccess(new Voltage());
    }

    @Test
    public void testVolume() throws IllegalAccessException {
        assertToStringContainsAllFields(new Volume());
        assertAccess(new Volume());
    }

    @Test
    public void testWarranty() throws IllegalAccessException {
        assertToStringContainsAllFields(new Warranty());
        assertAccess(new Warranty());
    }

    @Test
    public void testDtcStatusUpdate() throws IllegalAccessException {
        assertToStringContainsAllFields(new DtcStatusUpdate());
        assertAccess(new DtcStatusUpdate());
    }

    @Test
    public void testServiceScheduleList() throws IllegalAccessException {
        assertToStringContainsAllFields(new ServiceScheduleList());
        assertAccess(new ServiceScheduleList());
    }

    @Test
    public void testInterval() throws IllegalAccessException {
        assertToStringContainsAllFields(new Interval());
        assertAccess(new Interval());
    }

    @Test
    public void testServiceScheduleEvent() throws IllegalAccessException {
        assertToStringContainsAllFields(new ServiceScheduleEvent());
        assertAccess(new ServiceScheduleEvent());
    }

    @Test
    public void testPolyline() throws IllegalAccessException {
        assertToStringContainsAllFields(new Polyline());
        assertAccess(new Polyline());
    }

}
