package io.moj.java.sdk.model.values;

import java.util.List;

import io.moj.java.sdk.utils.TimeUtils;

/**
 * Model object for a vehicle's VIN record.
 * Created by mhorie on 2016-01-14.
 */
public class VinDetails {

    private String VIN;
    private String Timestamp;
    private String Market;
    private Integer Year;
    private String Make;
    private String Model;
    private String VehicleType;
    private String BodyType;
    private String DriveType;
    private Double FuelTankSize;
    private String EPAFuelEfficiency;
    private Engine Engine;
    private Transmission Transmission;
    private List<Warranty> Warranties;
    private List<Recall> Recalls;
    private List<ServiceBulletin> ServiceBulletins;

    public String getBodyType() {
        return BodyType;
    }

    public void setBodyType(String bodyType) {
        BodyType = bodyType;
    }

    public String getDriveType() {
        return DriveType;
    }

    public void setDriveType(String driveType) {
        DriveType = driveType;
    }

    public Engine getEngine() {
        return Engine;
    }

    public void setEngine(Engine engine) {
        Engine = engine;
    }

    public String getEPAFuelEfficiency() {
        return EPAFuelEfficiency;
    }

    public void setEPAFuelEfficiency(String EPAFuelEfficiency) {
        this.EPAFuelEfficiency = EPAFuelEfficiency;
    }

    public Double getFuelTankSize() {
        return FuelTankSize;
    }

    public void setFuelTankSize(Double fuelTankSize) {
        FuelTankSize = fuelTankSize;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getMarket() {
        return Market;
    }

    public void setMarket(String market) {
        Market = market;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public List<Recall> getRecalls() {
        return Recalls;
    }

    public void setRecalls(List<Recall> recalls) {
        Recalls = recalls;
    }

    public List<ServiceBulletin> getServiceBulletins() {
        return ServiceBulletins;
    }

    public void setServiceBulletins(List<ServiceBulletin> serviceBulletins) {
        ServiceBulletins = serviceBulletins;
    }

    public Long getTimestamp() {
        return TimeUtils.convertTimestampToMillis(Timestamp);
    }

    public void setTimestamp(Long timestamp) {
        Timestamp = TimeUtils.convertMillisToTimestamp(timestamp);
    }

    public Transmission getTransmission() {
        return Transmission;
    }

    public void setTransmission(Transmission transmission) {
        Transmission = transmission;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public List<Warranty> getWarranties() {
        return Warranties;
    }

    public void setWarranties(List<Warranty> warranties) {
        Warranties = warranties;
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        Year = year;
    }

    @Override
    public String toString() {
        return "VinDetails{" +
                "VIN='" + VIN + '\'' +
                ", Timestamp='" + Timestamp + '\'' +
                ", Market='" + Market + '\'' +
                ", Year=" + Year +
                ", Make='" + Make + '\'' +
                ", Model='" + Model + '\'' +
                ", VehicleType='" + VehicleType + '\'' +
                ", BodyType='" + BodyType + '\'' +
                ", DriveType='" + DriveType + '\'' +
                ", FuelTankSize=" + FuelTankSize +
                ", EPAFuelEfficiency='" + EPAFuelEfficiency + '\'' +
                ", Engine=" + Engine +
                ", Transmission=" + Transmission +
                ", Warranties=" + Warranties +
                ", Recalls=" + Recalls +
                ", ServiceBulletins=" + ServiceBulletins +
                '}';
    }
}
