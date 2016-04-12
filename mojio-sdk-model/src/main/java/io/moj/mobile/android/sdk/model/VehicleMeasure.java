package io.moj.mobile.android.sdk.model;

import io.moj.mobile.android.sdk.model.enums.FuelEfficiencyCalculationMethod;
import io.moj.mobile.android.sdk.model.enums.FuelType;
import io.moj.mobile.android.sdk.model.values.Acceleration;
import io.moj.mobile.android.sdk.model.values.Accelerometer;
import io.moj.mobile.android.sdk.model.values.Battery;
import io.moj.mobile.android.sdk.model.values.BooleanState;
import io.moj.mobile.android.sdk.model.values.DiagnosticCode;
import io.moj.mobile.android.sdk.model.values.FuelEfficiency;
import io.moj.mobile.android.sdk.model.values.FuelLevel;
import io.moj.mobile.android.sdk.model.values.Heading;
import io.moj.mobile.android.sdk.model.values.Location;
import io.moj.mobile.android.sdk.model.values.Odometer;
import io.moj.mobile.android.sdk.model.values.Rpm;
import io.moj.mobile.android.sdk.model.values.Speed;
import io.moj.mobile.android.sdk.model.values.VinDetails;

/**
 * Model object for an vehicle measurement at a given point in time.
 * Created by mhorie on 2016-01-13.
 */
public class VehicleMeasure {

    public static final String ACCELERATION = "Acceleration";
    public static final String ACCELEROMETER = "Accelerometer";
    public static final String ACCIDENT_STATE = "AccidentState";
    public static final String BATTERY = "Battery";
    public static final String CURRENT_TRIP = "CurrentTrip";
    public static final String DECELERATION = "Deceleration";
    public static final String DIAGNOSTIC_CODE = "DiagnosticCodes";
    public static final String FUEL_EFFICIENCY = "FuelEfficiency";
    public static final String FUEL_EFFICIENCY_CALCULATION_METHOD = "FuelEfficiencyCalculationMethod";
    public static final String FUEL_LEVEL = "FuelLevel";
    public static final String FUEL_TYPE = "FuelType";
    public static final String GATEWAY_TIME = "GatewayTime";
    public static final String HARSH_EVENT_STATE = "HarshEventState";
    public static final String HEADING = "Heading";
    public static final String IDLE_STATE = "IdleState";
    public static final String IGNITION_STATE = "IgnitionState";
    public static final String LOCATION = "Location";
    public static final String MIL_STATUS = "MilStatus";
    public static final String MOJIO_ID = "MojioId";
    public static final String PARKED_STATE = "ParkedState";
    public static final String RPM_VALUE = "RPM";
    public static final String SPEED = "Speed";
    public static final String TOW_STATE = "TowState";
    public static final String VIN_NUMBER = "VIN";
    public static final String VIN_DETAILS = "VinDetails";
    public static final String VIRTUAL_ODOMETER = "VirtualOdometer";
    public static final String ODOMETER = "Odometer";
    public static final String TIME = "Time";

    private Acceleration Acceleration;
    private Accelerometer Accelerometer;
    private BooleanState AccidentState;
    private Battery Battery;
    private String CurrentTrip;
    private Acceleration Deceleration;
    private DiagnosticCode DiagnosticCodes;
    private FuelEfficiency FuelEfficiency;
    private FuelEfficiencyCalculationMethod FuelEfficiencyCalculationMethod;
    private FuelLevel FuelLevel;
    private FuelType FuelType;
    private String GatewayTime;
    private BooleanState HarshEventState;
    private Heading Heading;
    private BooleanState IdleState;
    private BooleanState IgnitionState;
    private Location Location;
    private Boolean MilStatus;
    private String MojioId;
    private BooleanState ParkedState;
    private Rpm RPM;
    private Speed Speed;
    private BooleanState TowState;
    private String VIN;
    private VinDetails VinDetails;
    private Odometer VirtualOdometer;
    private Odometer Odometer;
    private String Time;

    public Acceleration getAcceleration() {
        return Acceleration;
    }

    public void setAcceleration(Acceleration acceleration) {
        Acceleration = acceleration;
    }

    public Accelerometer getAccelerometer() {
        return Accelerometer;
    }

    public void setAccelerometer(Accelerometer accelerometer) {
        Accelerometer = accelerometer;
    }

    public BooleanState getAccidentState() {
        return AccidentState;
    }

    public void setAccidentState(BooleanState accidentState) {
        AccidentState = accidentState;
    }

    public Battery getBattery() {
        return Battery;
    }

    public void setBattery(Battery battery) {
        Battery = battery;
    }

    public String getCurrentTrip() {
        return CurrentTrip;
    }

    public void setCurrentTrip(String currentTrip) {
        CurrentTrip = currentTrip;
    }

    public Acceleration getDeceleration() {
        return Deceleration;
    }

    public void setDeceleration(Acceleration deceleration) {
        Deceleration = deceleration;
    }

    public DiagnosticCode getDiagnosticCodes() {
        return DiagnosticCodes;
    }

    public void setDiagnosticCodes(DiagnosticCode diagnosticCodes) {
        DiagnosticCodes = diagnosticCodes;
    }

    public FuelEfficiency getFuelEfficiency() {
        return FuelEfficiency;
    }

    public void setFuelEfficiency(FuelEfficiency fuelEfficiency) {
        FuelEfficiency = fuelEfficiency;
    }

    public FuelEfficiencyCalculationMethod getFuelEfficiencyCalculationMethod() {
        return FuelEfficiencyCalculationMethod;
    }

    public void setFuelEfficiencyCalculationMethod(FuelEfficiencyCalculationMethod fuelEfficiencyCalculationMethod) {
        FuelEfficiencyCalculationMethod = fuelEfficiencyCalculationMethod;
    }

    public FuelLevel getFuelLevel() {
        return FuelLevel;
    }

    public void setFuelLevel(FuelLevel fuelLevel) {
        FuelLevel = fuelLevel;
    }

    public FuelType getFuelType() {
        return FuelType;
    }

    public void setFuelType(FuelType fuelType) {
        FuelType = fuelType;
    }

    /**
     * @return the time the server received the message from the device
     */
    public String getGatewayTime() {
        return GatewayTime;
    }

    public void setGatewayTime(String gatewayTime) {
        GatewayTime = gatewayTime;
    }

    public BooleanState getHarshEventState() {
        return HarshEventState;
    }

    public void setHarshEventState(BooleanState harshEventState) {
        HarshEventState = harshEventState;
    }

    public Heading getHeading() {
        return Heading;
    }

    public void setHeading(Heading heading) {
        Heading = heading;
    }

    public BooleanState getIdleState() {
        return IdleState;
    }

    public void setIdleState(BooleanState idleState) {
        IdleState = idleState;
    }

    public BooleanState getIgnitionState() {
        return IgnitionState;
    }

    public void setIgnitionState(BooleanState ignitionState) {
        IgnitionState = ignitionState;
    }

    public Location getLocation() {
        return Location;
    }

    public void setLocation(Location location) {
        Location = location;
    }

    public Boolean getMilStatus() {
        return MilStatus;
    }

    public void setMilStatus(Boolean milStatus) {
        MilStatus = milStatus;
    }

    public String getMojioId() {
        return MojioId;
    }

    public void setMojioId(String mojioId) {
        MojioId = mojioId;
    }

    public Odometer getOdometer() {
        return Odometer;
    }

    public void setOdometer(Odometer odometer) {
        Odometer = odometer;
    }

    public BooleanState getParkedState() {
        return ParkedState;
    }

    public void setParkedState(BooleanState parkedState) {
        ParkedState = parkedState;
    }

    public Rpm getRPM() {
        return RPM;
    }

    public void setRPM(Rpm RPM) {
        this.RPM = RPM;
    }

    public Speed getSpeed() {
        return Speed;
    }

    public void setSpeed(Speed speed) {
        Speed = speed;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public BooleanState getTowState() {
        return TowState;
    }

    public void setTowState(BooleanState towState) {
        TowState = towState;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public VinDetails getVinDetails() {
        return VinDetails;
    }

    public void setVinDetails(VinDetails vinDetails) {
        VinDetails = vinDetails;
    }

    public Odometer getVirtualOdometer() {
        return VirtualOdometer;
    }

    public void setVirtualOdometer(Odometer virtualOdometer) {
        VirtualOdometer = virtualOdometer;
    }

    @Override
    public String toString() {
        return "VehicleMeasure{" +
                "Acceleration=" + Acceleration +
                ", Accelerometer=" + Accelerometer +
                ", AccidentState=" + AccidentState +
                ", Battery=" + Battery +
                ", CurrentTrip='" + CurrentTrip + '\'' +
                ", Deceleration=" + Deceleration +
                ", DiagnosticCodes=" + DiagnosticCodes +
                ", FuelEfficiency=" + FuelEfficiency +
                ", FuelEfficiencyCalculationMethod=" + FuelEfficiencyCalculationMethod +
                ", FuelLevel=" + FuelLevel +
                ", FuelType=" + FuelType +
                ", GatewayTime='" + GatewayTime + '\'' +
                ", HarshEventState=" + HarshEventState +
                ", Heading=" + Heading +
                ", IdleState=" + IdleState +
                ", IgnitionState=" + IgnitionState +
                ", Location=" + Location +
                ", MilStatus=" + MilStatus +
                ", MojioId='" + MojioId + '\'' +
                ", ParkedState=" + ParkedState +
                ", RPM=" + RPM +
                ", Speed=" + Speed +
                ", TowState=" + TowState +
                ", VIN='" + VIN + '\'' +
                ", VinDetails=" + VinDetails +
                ", VirtualOdometer=" + VirtualOdometer +
                ", Odometer=" + Odometer +
                ", Time='" + Time + '\'' +
                '}';
    }
}
