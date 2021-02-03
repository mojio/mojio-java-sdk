package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import io.moj.java.sdk.model.enums.FuelType;

import java.io.Serializable;

/**
 * Model object for vehicle details based on VIN.
 * Created by mhorie on 2016-01-14.
 */
public class VehicleDetails implements Serializable {

    @SerializedName(value = "Vin", alternate = "vin")
    private String Vin;
    @SerializedName(value = "Timestamp", alternate = "timestamp")
    private String Timestamp;
    @SerializedName(value = "Year", alternate = "year")
    private Integer Year;
    @SerializedName(value = "Make", alternate = "make")
    private String Make;
    @SerializedName(value = "Model", alternate = "model")
    private String Model;
    @SerializedName(value = "Engine", alternate = "engine")
    private String Engine;
    @SerializedName(value = "Cyclinders", alternate = "cyclinders")
    private Integer Cyclinders;
    @SerializedName(value = "TotalFuelCapacity", alternate = "totalFuelCapacity")
    private Volume TotalFuelCapacity;
    @SerializedName(value = "FuelType", alternate = "fuelType")
    private FuelType FuelType;
    @SerializedName(value = "CityFuelEfficiency", alternate = "cityFuelEfficiency")
    private Double CityFuelEfficiency;
    @SerializedName(value = "HighwayFuelEfficiency", alternate = "highwayFuelEfficiency")
    private Double HighwayFuelEfficiency;
    @SerializedName(value = "CombinedFuelEfficiency", alternate = "combinedFuelEfficiency")
    private Double CombinedFuelEfficiency;
    @SerializedName(value = "Transmission", alternate = "transmission")
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

    public Volume getTotalFuelCapacity() {
        return TotalFuelCapacity;
    }

    public void setTotalFuelCapacity(Volume totalFuelCapacity) {
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
