package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

public class SpeedingViolation {
    @SerializedName(value = "StartTimestamp", alternate = "startTimestamp")
    private String StartTimestamp;
    @SerializedName(value = "EndTimestamp", alternate = "endTimestamp")
    private String EndTimestamp;
    @SerializedName(value = "StartLocation", alternate = "startLocation")
    private Location StartLocation;
    @SerializedName(value = "EndLocation", alternate = "endLocation")
    private Location EndLocation;
    @SerializedName(value = "MaxSpeed", alternate = "maxSpeed")
    private Speed MaxSpeed;
    @SerializedName(value = "MinSpeed", alternate = "minSpeed")
    private Speed MinSpeed;
    @SerializedName(value = "AverageSpeed", alternate = "averageSpeed")
    private Speed AverageSpeed;
    @SerializedName(value = "SpeedingScore", alternate = "speedingScore")
    private Float SpeedingScore;
    @SerializedName(value = "Polyline", alternate = "polyline")
    private String Polyline;
    @SerializedName(value = "AverageSpeedDelta", alternate = "averageSpeedDelta")
    private Speed AverageSpeedDelta;

    public String getStartTimestamp() {
        return StartTimestamp;
    }

    public void setStartTimestamp(String startTimestamp) {
        StartTimestamp = startTimestamp;
    }

    public String getEndTimestamp() {
        return EndTimestamp;
    }

    public void setEndTimestamp(String endTimestamp) {
        EndTimestamp = endTimestamp;
    }

    public Location getStartLocation() {
        return StartLocation;
    }

    public void setStartLocation(Location startLocation) {
        StartLocation = startLocation;
    }

    public Location getEndLocation() {
        return EndLocation;
    }

    public void setEndLocation(Location endLocation) {
        EndLocation = endLocation;
    }

    public Speed getMaxSpeed() {
        return MaxSpeed;
    }

    public void setMaxSpeed(Speed maxSpeed) {
        MaxSpeed = maxSpeed;
    }

    public Speed getMinSpeed() {
        return MinSpeed;
    }

    public void setMinSpeed(Speed minSpeed) {
        MinSpeed = minSpeed;
    }

    public Speed getAverageSpeed() {
        return AverageSpeed;
    }

    public void setAverageSpeed(Speed averageSpeed) {
        AverageSpeed = averageSpeed;
    }

    public Float getSpeedingScore() {
        return SpeedingScore;
    }

    public void setSpeedingScore(Float speedingScore) {
        SpeedingScore = speedingScore;
    }

    public String getPolyline() {
        return Polyline;
    }

    public void setPolyline(String polyline) {
        Polyline = polyline;
    }

    public Speed getAverageSpeedDelta() {
        return AverageSpeedDelta;
    }

    public void setAverageSpeedDelta(Speed averageSpeedDelta) {
        AverageSpeedDelta = averageSpeedDelta;
    }

    @Override
    public String toString() {
        return "SpeedingViolation{" +
                "StartTimestamp='" + StartTimestamp + '\'' +
                ", EndTimestamp='" + EndTimestamp + '\'' +
                ", StartLocation=" + StartLocation +
                ", EndLocation=" + EndLocation +
                ", MaxSpeed=" + MaxSpeed +
                ", MinSpeed=" + MinSpeed +
                ", AverageSpeed=" + AverageSpeed +
                ", SpeedingScore=" + SpeedingScore +
                ", Polyline='" + Polyline + '\'' +
                ", AverageSpeedDelta=" + AverageSpeedDelta +
                '}';
    }
}
