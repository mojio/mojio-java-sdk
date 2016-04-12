package io.moj.mobile.android.sdk.model.values;

import org.junit.Test;

import static io.moj.mobile.android.sdk.test.TestUtils.assertAccess;
import static io.moj.mobile.android.sdk.test.TestUtils.assertToStringContainsAllFields;

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
    public void testFuelCapacity() throws IllegalAccessException {
        assertToStringContainsAllFields(new FuelCapacity());
        assertAccess(new FuelCapacity());
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
    public void testHeading() throws IllegalAccessException {
        assertToStringContainsAllFields(new Heading());
        assertAccess(new Heading());
    }

    @Test
    public void testImage() throws IllegalAccessException {
        assertToStringContainsAllFields(new Image());
        assertAccess(new Image());
    }

    @Test
    public void testLocation() throws IllegalAccessException {
        assertToStringContainsAllFields(new Location());
        assertAccess(new Location());
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
        assertToStringContainsAllFields(new Permission());
        assertAccess(new Permission());
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
    public void testWarranty() throws IllegalAccessException {
        assertToStringContainsAllFields(new Warranty());
        assertAccess(new Warranty());
    }

}
