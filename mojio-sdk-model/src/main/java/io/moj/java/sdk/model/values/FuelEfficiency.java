package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import io.moj.java.sdk.model.enums.FuelEfficiencyUnit;

/**
 * Model object for a FuelEfficiency value.
 * Created by mhorie on 2016-01-12.
 */
public class FuelEfficiency extends DeviceMeasurement {

    @SerializedName(value = "Statistics", alternate = "statistics")
    private MeasurementStatistics Statistics;
    @SerializedName(value = "BenchmarkTime", alternate = "benchmarkTime")
    private String BenchmarkTime;
    @SerializedName(value = "BenchmarkStatistics", alternate = "benchmarkStatistics")
    private MeasurementStatistics BenchmarkStatistics;

    public FuelEfficiencyUnit getBaseFuelEfficiencyUnit() {
        return FuelEfficiencyUnit.fromKey(getBaseUnit());
    }

    public void setBaseFuelEfficiencyUnit(FuelEfficiencyUnit baseUnit) {
        setBaseUnit(baseUnit.getKey());
    }

    public FuelEfficiencyUnit getFuelEfficiencyUnit() {
        return FuelEfficiencyUnit.fromKey(getUnit());
    }

    public void setFuelEfficiencyUnit(FuelEfficiencyUnit unit) {
        setUnit(unit.getKey());
    }

    public MeasurementStatistics getBenchmarkStatistics() {
        return BenchmarkStatistics;
    }

    public void setBenchmarkStatistics(MeasurementStatistics benchmarkStatistics) {
        BenchmarkStatistics = benchmarkStatistics;
    }

    public String getBenchmarkTime() {
        return BenchmarkTime;
    }

    public void setBenchmarkTime(String benchmarkTime) {
        BenchmarkTime = benchmarkTime;
    }

    public MeasurementStatistics getStatistics() {
        return Statistics;
    }

    public void setStatistics(MeasurementStatistics statistics) {
        Statistics = statistics;
    }

    @Override
    public String toString() {
        return "FuelEfficiency{" +
                "BenchmarkStatistics=" + BenchmarkStatistics +
                ", Statistics=" + Statistics +
                ", BenchmarkTime='" + BenchmarkTime + '\'' +
                "} " + super.toString();
    }
}
