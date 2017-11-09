package io.moj.java.sdk.model;

import java.util.Arrays;

import io.moj.java.sdk.model.values.Acceleration;
import io.moj.java.sdk.model.values.Distance;
import io.moj.java.sdk.model.values.FuelEfficiency;
import io.moj.java.sdk.model.values.FuelLevel;
import io.moj.java.sdk.model.values.HarshEvent;
import io.moj.java.sdk.model.values.IdleEvent;
import io.moj.java.sdk.model.values.Location;
import io.moj.java.sdk.model.values.Odometer;
import io.moj.java.sdk.model.values.Rpm;
import io.moj.java.sdk.model.values.Speed;
import io.moj.java.sdk.utils.TimeUtils;

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
    public static final String DISTANCE = "Distance";
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
    public static final String POLYLINE = "Polyline";
    public static final String FUEL_EFFICIENCY = "FuelEfficiency";
    public static final String START_FUEL_LEVEL = "StartFuelLevel";
    public static final String END_FUEL_LEVEL = "EndFuelLevel";
    public static final String IDLING_COUNT = "IdlingCount";
    public static final String HARSH_ACCL_COUNT = "HarshAcclCount";
    public static final String HARSH_DECEL_COUNT = "HarshDecelCount";

    private String VehicleId;
    private String Name;
    private String[] Tags;
    private String MojioId;
    private Boolean Completed;
    private Distance Distance;
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
    private String Polyline;
    private FuelEfficiency FuelEfficiency;
    private FuelLevel StartFuelLevel;
    private FuelLevel EndFuelLevel;
    private Integer IdlingCount;
    private Integer HarshAcclCount;
    private Integer HarshDecelCount;
    private HarshEvent[] HarshEvents;
    private IdleEvent[] IdleEvents;

    public Boolean getCompleted() {
        return Completed;
    }

    public void setCompleted(Boolean completed) {
        Completed = completed;
    }

    public Long getDuration() {
        return TimeUtils.convertTimespanToMillis(Duration);
    }

    public void setDuration(Long duration) {
        Duration = TimeUtils.convertMillisToTimespan(duration);
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

    public Long getEndTimestamp() {
        return TimeUtils.convertTimestampToMillis(EndTimestamp);
    }

    public void setEndTimestamp(Long endTimestamp) {
        EndTimestamp = TimeUtils.convertMillisToTimestamp(endTimestamp);
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

    public String getPolyline() {
        return Polyline;
    }

    public void setPolyline(String polyline) {
        Polyline = polyline;
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

    public Long getStartTimestamp() {
        return TimeUtils.convertTimestampToMillis(StartTimestamp);
    }

    public void setStartTimestamp(Long startTimestamp) {
        StartTimestamp = TimeUtils.convertMillisToTimestamp(startTimestamp);
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

    public Distance getDistance() {
        return Distance;
    }

    public void setDistance(Distance distance) {
        Distance = distance;
    }

    public Integer getIdlingCount() {
        return IdlingCount;
    }

    public void setIdlingCount(Integer idleCount) {
        IdlingCount = idleCount;
    }

    public Integer getHarshDecelCount() {
        return HarshDecelCount;
    }

    public void setHarshDecelCount(Integer harshDecelCount) {
        HarshDecelCount = harshDecelCount;
    }

    public Integer getHarshAcclCount() {
        return HarshAcclCount;
    }

    public void setHarshAcclCount(Integer harshAcclCount) {
        HarshAcclCount = harshAcclCount;
    }

    public HarshEvent[] getHarshEvents() {
        return HarshEvents;
    }

    public void setHarshEvents(HarshEvent[] harshEvents) {
        HarshEvents = harshEvents;
    }

    public IdleEvent[] getIdleEvents() {
        return IdleEvents;
    }

    public void setIdleEvents(IdleEvent[] idleEvents) {
        IdleEvents = idleEvents;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "VehicleId='" + VehicleId + '\'' +
                ", Name='" + Name + '\'' +
                ", Tags=" + Arrays.toString(Tags) +
                ", MojioId='" + MojioId + '\'' +
                ", Completed=" + Completed +
                ", Distance=" + Distance +
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
                ", Polyline='" + Polyline + '\'' +
                ", FuelEfficiency=" + FuelEfficiency +
                ", StartFuelLevel=" + StartFuelLevel +
                ", EndFuelLevel=" + EndFuelLevel +
                ", IdlingCount=" + IdlingCount +
                ", HarshAcclCount=" + HarshAcclCount +
                ", HarshDecelCount=" + HarshDecelCount +
                ", HarshEvents=" + Arrays.toString(HarshEvents) +
                ", IdleEvents=" + Arrays.toString(IdleEvents) +
                "} " + super.toString();
    }
}
