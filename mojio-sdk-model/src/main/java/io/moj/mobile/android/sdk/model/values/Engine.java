package io.moj.mobile.android.sdk.model.values;

/**
 * Model object for an Engine.
 * Created by skidson on 16-03-10.
 */
public class Engine {

    private String Name;
    private String Cylinders;
    private Double Displacement;
    private String FuelInduction;
    private String FuelQuality;
    private String FuelType;
    private String MaxHp;
    private String MaxHpAt;

    public String getCylinders() {
        return Cylinders;
    }

    public void setCylinders(String cylinders) {
        Cylinders = cylinders;
    }

    public Double getDisplacement() {
        return Displacement;
    }

    public void setDisplacement(Double displacement) {
        Displacement = displacement;
    }

    public String getFuelInduction() {
        return FuelInduction;
    }

    public void setFuelInduction(String fuelInduction) {
        FuelInduction = fuelInduction;
    }

    public String getFuelQuality() {
        return FuelQuality;
    }

    public void setFuelQuality(String fuelQuality) {
        FuelQuality = fuelQuality;
    }

    public String getFuelType() {
        return FuelType;
    }

    public void setFuelType(String fuelType) {
        FuelType = fuelType;
    }

    public String getMaxHp() {
        return MaxHp;
    }

    public void setMaxHp(String maxHp) {
        MaxHp = maxHp;
    }

    public String getMaxHpAt() {
        return MaxHpAt;
    }

    public void setMaxHpAt(String maxHpAt) {
        MaxHpAt = maxHpAt;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "Cylinders='" + Cylinders + '\'' +
                ", Name='" + Name + '\'' +
                ", Displacement=" + Displacement +
                ", FuelInduction='" + FuelInduction + '\'' +
                ", FuelQuality='" + FuelQuality + '\'' +
                ", FuelType='" + FuelType + '\'' +
                ", MaxHp='" + MaxHp + '\'' +
                ", MaxHpAt='" + MaxHpAt + '\'' +
                '}';
    }
}
