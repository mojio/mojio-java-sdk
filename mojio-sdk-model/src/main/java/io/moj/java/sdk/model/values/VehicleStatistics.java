package io.moj.java.sdk.model.values;

import io.moj.java.sdk.utils.TimeUtils;

/**
 * Model object for statistics about a {@link io.moj.java.sdk.model.Vehicle}.
 * Created by skidson on 2016-09-06.
 */
public class VehicleStatistics {

    public static final String ESTIMATED_FUEL_LEVEL = "EstimatedFuelLevel";
    public static final String ESTIMATED_FUEL_VOLUME = "EstimatedFuelVolume";
    public static final String AVERAGE_FUEL_EFFICIENCY = "AverageFuelEfficiency";
    public static final String TOTAL_RANGE = "TotalRange";
    public static final String CURRENT_RANGE = "CurrentRange";
    public static final String LAST_FILL_UP_DATE = "LastFillUpDate";

    private FuelLevel EstimatedFuelLevel;
    private Volume EstimatedFuelVolume;
    private FuelEfficiency AverageFuelEfficiency;
    private Distance TotalRange;
    private Distance CurrentRange;
    private String LastFillUpDate;

    public FuelLevel getEstimatedFuelLevel() {
        return EstimatedFuelLevel;
    }

    public void setEstimatedFuelLevel(FuelLevel estimatedFuelLevel) {
        EstimatedFuelLevel = estimatedFuelLevel;
    }

    public Volume getEstimatedFuelVolume() {
        return EstimatedFuelVolume;
    }

    public void setEstimatedFuelVolume(Volume estimatedFuelVolume) {
        EstimatedFuelVolume = estimatedFuelVolume;
    }

    public FuelEfficiency getAverageFuelEfficiency() {
        return AverageFuelEfficiency;
    }

    public void setAverageFuelEfficiency(FuelEfficiency averageFuelEfficiency) {
        AverageFuelEfficiency = averageFuelEfficiency;
    }

    public Distance getTotalRange() {
        return TotalRange;
    }

    public void setTotalRange(Distance totalRange) {
        TotalRange = totalRange;
    }

    public Distance getCurrentRange() {
        return CurrentRange;
    }

    public void setCurrentRange(Distance currentRange) {
        CurrentRange = currentRange;
    }

    public Long getLastFillUpDate() {
        return TimeUtils.convertTimestampToMillis(LastFillUpDate);
    }

    public void setLastFillUpDate(Long lastFillUpDate) {
        LastFillUpDate = TimeUtils.convertMillisToTimestamp(lastFillUpDate);
    }

    @Override
    public String toString() {
        return "VehicleStatistics{" +
                "EstimatedFuelLevel=" + EstimatedFuelLevel +
                ", EstimatedFuelVolume=" + EstimatedFuelVolume +
                ", AverageFuelEfficiency=" + AverageFuelEfficiency +
                ", TotalRange=" + TotalRange +
                ", CurrentRange=" + CurrentRange +
                ", LastFillUpDate='" + LastFillUpDate + '\'' +
                '}';
    }
}
