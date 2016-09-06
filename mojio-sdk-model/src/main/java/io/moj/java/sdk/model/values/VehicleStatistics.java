package io.moj.java.sdk.model.values;

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

    private FuelLevel EstimatedFuelLevel;
    private Volume EstimatedFuelVolume;
    private FuelEfficiency AverageFuelEfficiency;
    private Distance TotalRange;
    private Distance CurrentRange;

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

    @Override
    public String toString() {
        return "VehicleStatistics{" +
                "EstimatedFuelLevel=" + EstimatedFuelLevel +
                ", EstimatedFuelVolume=" + EstimatedFuelVolume +
                ", AverageFuelEfficiency=" + AverageFuelEfficiency +
                ", TotalRange=" + TotalRange +
                ", CurrentRange=" + CurrentRange +
                '}';
    }
}
