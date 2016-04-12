package io.moj.mobile.android.sdk.model.values;

import io.moj.mobile.android.sdk.model.enums.FuelType;

/**
 * Model object for vehicle details based on VIN.
 * Created by mhorie on 2016-01-14.
 */
public class VehicleDetails {

    private String Vin;
    private String Timestamp;
    private Integer Year;
    private String Make;
    private String Model;
    private String Engine;
    private Integer Cyclinders;
    private FuelCapacity TotalFuelCapacity;
    private FuelType FuelType;
    private Double CityFuelEfficiency;
    private Double HighwayFuelEfficiency;
    private Double CombinedFuelEfficiency;
    private String Transmission;

    public Double getCityFuelEfficiency() {
        return CityFuelEfficiency;
    }

    public void setCityFuelEfficiency(Double cityFuelEfficiency) {
        CityFuelEfficiency = cityFuelEfficiency;
    }

    public Double getCombinedFuelEfficiency() {
        return CombinedFuelEfficiency;
    }

    public void setCombinedFuelEfficiency(Double combinedFuelEfficiency) {
        CombinedFuelEfficiency = combinedFuelEfficiency;
    }

    public Integer getCyclinders() {
        return Cyclinders;
    }

    public void setCyclinders(Integer cyclinders) {
        Cyclinders = cyclinders;
    }

    public String getEngine() {
        return Engine;
    }

    public void setEngine(String engine) {
        Engine = engine;
    }

    public FuelType getFuelType() {
        return FuelType;
    }

    public void setFuelType(FuelType fuelType) {
        FuelType = fuelType;
    }

    public Double getHighwayFuelEfficiency() {
        return HighwayFuelEfficiency;
    }

    public void setHighwayFuelEfficiency(Double highwayFuelEfficiency) {
        HighwayFuelEfficiency = highwayFuelEfficiency;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public FuelCapacity getTotalFuelCapacity() {
        return TotalFuelCapacity;
    }

    public void setTotalFuelCapacity(FuelCapacity totalFuelCapacity) {
        TotalFuelCapacity = totalFuelCapacity;
    }

    public String getTransmission() {
        return Transmission;
    }

    public void setTransmission(String transmission) {
        Transmission = transmission;
    }

    public String getVin() {
        return Vin;
    }

    public void setVin(String vin) {
        Vin = vin;
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        Year = year;
    }

    @Override
    public String toString() {
        return "VehicleDetails{" +
                "CityFuelEfficiency=" + CityFuelEfficiency +
                ", Vin='" + Vin + '\'' +
                ", Timestamp='" + Timestamp + '\'' +
                ", Year=" + Year +
                ", Make='" + Make + '\'' +
                ", Model='" + Model + '\'' +
                ", Engine='" + Engine + '\'' +
                ", Cyclinders=" + Cyclinders +
                ", TotalFuelCapacity=" + TotalFuelCapacity +
                ", FuelType=" + FuelType +
                ", HighwayFuelEfficiency=" + HighwayFuelEfficiency +
                ", CombinedFuelEfficiency=" + CombinedFuelEfficiency +
                ", Transmission='" + Transmission + '\'' +
                '}';
    }
}
