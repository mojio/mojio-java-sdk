package io.moj.java.sdk.model;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

import io.moj.java.sdk.model.enums.FuelEfficiencyCalculationMethod;
import io.moj.java.sdk.model.enums.FuelType;
import io.moj.java.sdk.model.values.Acceleration;
import io.moj.java.sdk.model.values.Accelerometer;
import io.moj.java.sdk.model.values.Battery;
import io.moj.java.sdk.model.values.BooleanState;
import io.moj.java.sdk.model.values.CompatDetails;
import io.moj.java.sdk.model.values.DiagnosticCode;
import io.moj.java.sdk.model.values.EngineOil;
import io.moj.java.sdk.model.values.FuelEfficiency;
import io.moj.java.sdk.model.values.FuelLevel;
import io.moj.java.sdk.model.values.HarshEventState;
import io.moj.java.sdk.model.values.Heading;
import io.moj.java.sdk.model.values.Image;
import io.moj.java.sdk.model.values.Location;
import io.moj.java.sdk.model.values.Odometer;
import io.moj.java.sdk.model.values.PredictiveMaintenance;
import io.moj.java.sdk.model.values.Rpm;
import io.moj.java.sdk.model.values.Speed;
import io.moj.java.sdk.model.values.TirePressure;
import io.moj.java.sdk.model.values.VehicleDetails;
import io.moj.java.sdk.model.values.VehicleProperties;
import io.moj.java.sdk.utils.TimeUtils;

/**
 * Model object for a Vehicle.
 * Created by mhorie on 2016-01-13.
 */
public class Vehicle extends AbstractMojioObject {

    public static final String NAME = "Name";
    public static final String LICENSE_PLATE = "LicensePlate";
    public static final String VIN_NUMBER = "VIN";
    public static final String DETECTED_VIN = "DetectedVIN";
    public static final String OVERRIDE_VIN = "OverrideVIN";
    public static final String COMPAT_DETAILS = "CompatDetails";
    public static final String CURRENT_TRIP = "CurrentTrip";
    public static final String MOJIO_ID = "MojioId";
    public static final String IMAGE = "Image";
    public static final String MIL_STATUS = "MilStatus";
    public static final String LAST_CONTACT_TIME = "LastContactTime";
    public static final String DIAGNOSTIC_CODES = "DiagnosticCodes";
    public static final String ACCELEROMETER = "Accelerometer";
    public static final String ACCELERATION = "Acceleration";
    public static final String DECELERATION = "Deceleration";
    public static final String SPEED = "Speed";
    public static final String ODOMETER = "Odometer";
    public static final String VIRTUAL_ODOMETER = "VirtualOdometer";
    public static final String REAL_ODOMETER = "RealOdometer";
    public static final String RPM_VALUE = "RPM";
    public static final String FUEL_EFFICIENCY = "FuelEfficiency";
    public static final String FUEL_EFFICIENCY_CALCULATION_METHOD = "FuelEfficiencyCalculationMethod";
    public static final String FUEL_LEVEL = "FuelLevel";
    public static final String FUEL_TYPE = "FuelType";
    public static final String GATEWAY_TIME = "GatewayTime";
    public static final String HARSH_EVENT_STATE = "HarshEventState";
    public static final String IDLE_STATE = "IdleState";
    public static final String IGNITION_STATE = "IgnitionState";
    public static final String BATTERY = "Battery";
    public static final String HEADING = "Heading";
    public static final String LOCATION = "Location";
    public static final String ACCIDENT_STATE = "AccidentState";
    public static final String VIN_DETAILS = "VinDetails";
    public static final String TOW_STATE = "TowState";
    public static final String PARKED_STATE = "ParkedState";
    public static final String ENGINE_OIL = "EngineOil";
    public static final String TIRE_PRESSURE = "TirePressure";
    public static final String TAGS = "Tags";
    public static final String DELETED = "Deleted";
    public static final String PREDICTIVE_MAINTENANCE = "PredictiveMaintenance";

    @SerializedName(value = "Name", alternate = "name")
    private String Name;
    @SerializedName(value = "LicensePlate", alternate = "licensePlate")
    private String LicensePlate;
    @SerializedName(value = "VIN", alternate = "vin")
    private String VIN;
    @SerializedName(value = "DetectedVIN", alternate = "detectedVIN")
    private String DetectedVIN;
    @SerializedName(value = "OverrideVIN", alternate = "overrideVIN")
    private String OverrideVIN;
    @SerializedName(value = "CompatDetails", alternate = "compatDetails")
    private CompatDetails CompatDetails;
    @SerializedName(value = "CurrentTrip", alternate = "currentTrip")
    private String CurrentTrip;
    @SerializedName(value = "MojioId", alternate = "mojioId")
    private String MojioId;
    @SerializedName(value = "Image", alternate = "image")
    private Image Image;
    @SerializedName(value = "MilStatus", alternate = "milStatus")
    private Boolean MilStatus;
    @SerializedName(value = "LastContactTime", alternate = "lastContactTime")
    private String LastContactTime;
    @SerializedName(value = "DiagnosticCodes", alternate = "diagnosticCodes")
    private DiagnosticCode[] DiagnosticCodes;
    @SerializedName(value = "Accelerometer", alternate = "accelerometer")
    private Accelerometer Accelerometer;
    @SerializedName(value = "Acceleration", alternate = "acceleration")
    private Acceleration Acceleration;
    @SerializedName(value = "Deceleration", alternate = "deceleration")
    private Acceleration Deceleration;
    @SerializedName(value = "Speed", alternate = "speed")
    private Speed Speed;
    @SerializedName(value = "Odometer", alternate = "odometer")
    private Odometer Odometer;
    @SerializedName(value = "VirtualOdometer", alternate = "virtualOdometer")
    private Odometer VirtualOdometer;
    @SerializedName(value = "RealOdometer", alternate = "realOdometer")
    private Odometer RealOdometer;
    @SerializedName(value = "RPM", alternate = "rpm")
    private Rpm RPM;
    @SerializedName(value = "FuelEfficiency", alternate = "fuelEfficiency")
    private FuelEfficiency FuelEfficiency;
    @SerializedName(value = "FuelEfficiencyCalculationMethod", alternate = "fuelEfficiencyCalculationMethod")
    private FuelEfficiencyCalculationMethod FuelEfficiencyCalculationMethod;
    @SerializedName(value = "FuelLevel", alternate = "fuelLevel")
    private FuelLevel FuelLevel;
    @SerializedName(value = "FuelType", alternate = "fuelType")
    private FuelType FuelType;
    @SerializedName(value = "GatewayTime", alternate = "gatewayTime")
    private String GatewayTime;
    @SerializedName(value = "HarshEventState", alternate = "harshEventState")
    private HarshEventState HarshEventState;
    @SerializedName(value = "IdleState", alternate = "idleState")
    private BooleanState IdleState;
    @SerializedName(value = "IgnitionState", alternate = "ignitionState")
    private BooleanState IgnitionState;
    @SerializedName(value = "Battery", alternate = "battery")
    private Battery Battery;
    @SerializedName(value = "Heading", alternate = "heading")
    private Heading Heading;
    @SerializedName(value = "Location", alternate = "location")
    private Location Location;
    @SerializedName(value = "AccidentState", alternate = "accidentState")
    private BooleanState AccidentState;
    @SerializedName(value = "VinDetails", alternate = "vinDetails")
    private VehicleDetails VinDetails;
    @SerializedName(value = "TowState", alternate = "towState")
    private BooleanState TowState;
    @SerializedName(value = "ParkedState", alternate = "parkedState")
    private BooleanState ParkedState;
    @SerializedName(value = "Tags", alternate = "tags")
    private String[] Tags;
    @SerializedName(value = "EngineOil", alternate = "engineoil")
    private EngineOil EngineOil;
    @SerializedName(value = "TirePressure", alternate = "tirePressure")
    private TirePressure TirePressure;
    @SerializedName(value = "Deleted", alternate = "deleted")
    private Boolean Deleted;
    @SerializedName(value = "properties", alternate = "Properties")
    private VehicleProperties Properties;
    @SerializedName(value = "PredictiveMaintenance", alternate = "predictiveMaintenance")
    private PredictiveMaintenance PredictiveMaintenance;

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

    public Location getLocation() {
        return Location;
    }

    public void setLocation(Location aLocation) {
        this.Location = aLocation;
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

    public DiagnosticCode[] getDiagnosticCodes() {
        return DiagnosticCodes;
    }

    public void setDiagnosticCodes(DiagnosticCode[] diagnosticCodes) {
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
    public Long getGatewayTime() {
        return TimeUtils.convertTimestampToMillis(GatewayTime);
    }

    public void setGatewayTime(Long gatewayTime) {
        GatewayTime = TimeUtils.convertMillisToTimestamp(gatewayTime);
    }

    public HarshEventState getHarshEventState() {
        return HarshEventState;
    }

    public void setHarshEventState(HarshEventState harshEventState) {
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

    public Image getImage() {
        return Image;
    }

    public void setImage(Image image) {
        Image = image;
    }

    public Long getLastContactTime() {
        return TimeUtils.convertTimestampToMillis(LastContactTime);
    }

    public void setLastContactTime(Long lastContactTime) {
        LastContactTime = TimeUtils.convertMillisToTimestamp(lastContactTime);
    }

    public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        LicensePlate = licensePlate;
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Odometer getOdometer() {
        return Odometer;
    }

    public void setOdometer(Odometer odometer) {
        Odometer = odometer;
    }

    public Odometer getVirtualOdometer() {
        return VirtualOdometer;
    }

    public void setVirtualOdometer(Odometer virtualOdometer) {
        VirtualOdometer = virtualOdometer;
    }

    public Odometer getRealOdometer() {
        return RealOdometer;
    }

    public void setRealOdometer(Odometer realOdometer) {
        RealOdometer = realOdometer;
    }

    public BooleanState getParkedState() {
        return ParkedState;
    }

    public void setParkedState(BooleanState parkedState) {
        ParkedState = parkedState;
    }

    public EngineOil getEngineOil() { return EngineOil; }

    public void setEngineOil(EngineOil engineOil) {
        EngineOil = engineOil;
    }

    public TirePressure getTirePressure() {
        return TirePressure;
    }

    public void setTirePressure(TirePressure tirePressure) {
        TirePressure = tirePressure;
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

    public String[] getTags() {
        return Tags;
    }

    public void setTags(String[] tags) {
        Tags = tags;
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

    public String getDetectedVIN() {
        return DetectedVIN;
    }

    public void setDetectedVIN(String detectedVIN) {
        DetectedVIN = detectedVIN;
    }

    public String getOverrideVIN() {
        return OverrideVIN;
    }

    public void setOverrideVIN(String overrideVIN) {
        OverrideVIN = overrideVIN;
    }

    public VehicleDetails getVinDetails() {
        return VinDetails;
    }

    public void setVinDetails(VehicleDetails vinDetails) {
        VinDetails = vinDetails;
    }

    public CompatDetails getCompatDetails() {
        return CompatDetails;
    }

    public void setCompatDetails(CompatDetails compatDetails) {
        CompatDetails = compatDetails;
    }

    public Boolean getDeleted() {
        return Deleted;
    }

    public void setDeleted(Boolean deleted) {
        Deleted = deleted;
    }

    public VehicleProperties getProperties() {
        return Properties;
    }

    public void setProperties(VehicleProperties properties) {
        Properties = properties;
    }

    public PredictiveMaintenance getPredictiveMaintenance() { return PredictiveMaintenance; }

    public void setPredictiveMaintenance(PredictiveMaintenance predictiveMaintenance) { PredictiveMaintenance = predictiveMaintenance; }

    @Override
    public String toString() {
        return "Vehicle{" +
                "Name='" + Name + '\'' +
                ", LicensePlate='" + LicensePlate + '\'' +
                ", VIN='" + VIN + '\'' +
                ", DetectedVIN='" + DetectedVIN + '\'' +
                ", OverrideVIN='" + OverrideVIN + '\'' +
                ", CompatDetails=" + CompatDetails +
                ", CurrentTrip='" + CurrentTrip + '\'' +
                ", MojioId='" + MojioId + '\'' +
                ", Image=" + Image +
                ", MilStatus=" + MilStatus +
                ", LastContactTime='" + LastContactTime + '\'' +
                ", DiagnosticCodes=" + Arrays.toString(DiagnosticCodes) +
                ", Accelerometer=" + Accelerometer +
                ", Acceleration=" + Acceleration +
                ", Deceleration=" + Deceleration +
                ", Speed=" + Speed +
                ", Odometer=" + Odometer +
                ", VirtualOdometer=" + VirtualOdometer +
                ", RealOdometer=" + RealOdometer +
                ", RPM=" + RPM +
                ", FuelEfficiency=" + FuelEfficiency +
                ", FuelEfficiencyCalculationMethod=" + FuelEfficiencyCalculationMethod +
                ", FuelLevel=" + FuelLevel +
                ", FuelType=" + FuelType +
                ", GatewayTime='" + GatewayTime + '\'' +
                ", HarshEventState=" + HarshEventState +
                ", IdleState=" + IdleState +
                ", IgnitionState=" + IgnitionState +
                ", Battery=" + Battery +
                ", Heading=" + Heading +
                ", Location=" + Location +
                ", AccidentState=" + AccidentState +
                ", VinDetails=" + VinDetails +
                ", TowState=" + TowState +
                ", ParkedState=" + ParkedState +
                ", EngineOil=" + EngineOil +
                ", TirePressure=" + TirePressure +
                ", Tags=" + Arrays.toString(Tags) +
                ", Deleted=" + Deleted +
                ", Properties=" + Properties +
                ", PredictiveMaintenance=" + PredictiveMaintenance +
                "} " + super.toString();
    }
}
