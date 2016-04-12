package io.moj.mobile.android.sdk.model;

import java.util.Arrays;

import io.moj.mobile.android.sdk.model.values.Acceleration;
import io.moj.mobile.android.sdk.model.values.FuelEfficiency;
import io.moj.mobile.android.sdk.model.values.FuelLevel;
import io.moj.mobile.android.sdk.model.values.Location;
import io.moj.mobile.android.sdk.model.values.Odometer;
import io.moj.mobile.android.sdk.model.values.Rpm;
import io.moj.mobile.android.sdk.model.values.Speed;

/**
 * Model object for a Trip.
 * Created by mhorie on 2016-01-13.
 */
public class Trip extends AbstractMojioObject {

    public static final String VEHICLE_ID = "VehicleId";
    public static final String NAME = "Name";
    public static final String TAGS = "Tags";
    public static final String MOJIO_ID = "MojioId";
    public static final String COMPLETED = "Completed";
    public static final String DURATION = "Duration";
    public static final String START_TIMESTAMP = "StartTimestamp";
    public static final String END_TIMESTAMP = "EndTimestamp";
    public static final String START_ODOMETER = "StartOdometer";
    public static final String END_ODOMETER = "EndOdometer";
    public static final String START_LOCATION = "StartLocation";
    public static final String END_LOCATION = "EndLocation";
    public static final String MAX_SPEED = "MaxSpeed";
    public static final String MAX_RPM = "MaxRPM";
    public static final String MAX_ACCELERATION = "MaxAcceleration";
    public static final String MAX_DECELERATION = "MaxDeceleration";
    public static final String FUEL_EFFICIENCY = "FuelEfficiency";
    public static final String START_FUEL_LEVEL = "StartFuelLevel";
    public static final String END_FUEL_LEVEL = "EndFuelLevel";

    private String VehicleId;
    private String Name;
    private String[] Tags;
    private String MojioId;
    private Boolean Completed;
    private String Duration;
    private String StartTimestamp;
    private String EndTimestamp;
    private Odometer StartOdometer;
    private Odometer EndOdometer;
    private Location StartLocation;
    private Location EndLocation;
    private Speed MaxSpeed;
    private Rpm MaxRPM;
    private Acceleration MaxAcceleration;
    private Acceleration MaxDeceleration;
    private FuelEfficiency FuelEfficiency;
    private FuelLevel StartFuelLevel;
    private FuelLevel EndFuelLevel;

    public Boolean getCompleted() {
        return Completed;
    }

    public void setCompleted(Boolean completed) {
        Completed = completed;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public FuelLevel getEndFuelLevel() {
        return EndFuelLevel;
    }

    public void setEndFuelLevel(FuelLevel endFuelLevel) {
        EndFuelLevel = endFuelLevel;
    }

    public Location getEndLocation() {
        return EndLocation;
    }

    public void setEndLocation(Location endLocation) {
        EndLocation = endLocation;
    }

    public Odometer getEndOdometer() {
        return EndOdometer;
    }

    public void setEndOdometer(Odometer endOdometer) {
        EndOdometer = endOdometer;
    }

    public String getEndTimestamp() {
        return EndTimestamp;
    }

    public void setEndTimestamp(String endTimestamp) {
        EndTimestamp = endTimestamp;
    }

    public FuelEfficiency getFuelEfficiency() {
        return FuelEfficiency;
    }

    public void setFuelEfficiency(FuelEfficiency fuelEfficiency) {
        FuelEfficiency = fuelEfficiency;
    }

    public Acceleration getMaxAcceleration() {
        return MaxAcceleration;
    }

    public void setMaxAcceleration(Acceleration maxAcceleration) {
        MaxAcceleration = maxAcceleration;
    }

    public Acceleration getMaxDeceleration() {
        return MaxDeceleration;
    }

    public void setMaxDeceleration(Acceleration maxDeceleration) {
        MaxDeceleration = maxDeceleration;
    }

    public Rpm getMaxRPM() {
        return MaxRPM;
    }

    public void setMaxRPM(Rpm maxRPM) {
        MaxRPM = maxRPM;
    }

    public Speed getMaxSpeed() {
        return MaxSpeed;
    }

    public void setMaxSpeed(Speed maxSpeed) {
        MaxSpeed = maxSpeed;
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

    public FuelLevel getStartFuelLevel() {
        return StartFuelLevel;
    }

    public void setStartFuelLevel(FuelLevel startFuelLevel) {
        StartFuelLevel = startFuelLevel;
    }

    public Location getStartLocation() {
        return StartLocation;
    }

    public void setStartLocation(Location startLocation) {
        StartLocation = startLocation;
    }

    public Odometer getStartOdometer() {
        return StartOdometer;
    }

    public void setStartOdometer(Odometer startOdometer) {
        StartOdometer = startOdometer;
    }

    public String getStartTimestamp() {
        return StartTimestamp;
    }

    public void setStartTimestamp(String startTimestamp) {
        StartTimestamp = startTimestamp;
    }

    public String[] getTags() {
        return Tags;
    }

    public void setTags(String[] tags) {
        Tags = tags;
    }

    public String getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(String vehicleId) {
        VehicleId = vehicleId;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "Completed=" + Completed +
                ", VehicleId='" + VehicleId + '\'' +
                ", Name='" + Name + '\'' +
                ", Tags=" + Arrays.toString(Tags) +
                ", MojioId='" + MojioId + '\'' +
                ", Duration='" + Duration + '\'' +
                ", StartTimestamp='" + StartTimestamp + '\'' +
                ", EndTimestamp='" + EndTimestamp + '\'' +
                ", StartOdometer=" + StartOdometer +
                ", EndOdometer=" + EndOdometer +
                ", StartLocation=" + StartLocation +
                ", EndLocation=" + EndLocation +
                ", MaxSpeed=" + MaxSpeed +
                ", MaxRPM=" + MaxRPM +
                ", MaxAcceleration=" + MaxAcceleration +
                ", MaxDeceleration=" + MaxDeceleration +
                ", FuelEfficiency=" + FuelEfficiency +
                ", StartFuelLevel=" + StartFuelLevel +
                ", EndFuelLevel=" + EndFuelLevel +
                "} " + super.toString();
    }
}
