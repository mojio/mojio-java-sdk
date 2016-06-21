package io.moj.java.sdk.model.values;

import java.util.Arrays;

/**
 * Model object for summary of service schedule items.
 * Created by skidson on 16-03-10.
 */
public class NextServiceSchedule {

    private String TimeStamp;
    private Double Odometer;
    private Integer AgeInMonths;
    private String TimeUnits;
    private Double TimeValue;
    private String DistanceUnits;
    private Double DistanceValue;
    private ServiceSchedule[] Items;

    public Integer getAgeInMonths() {
        return AgeInMonths;
    }

    public void setAgeInMonths(Integer ageInMonths) {
        AgeInMonths = ageInMonths;
    }

    public String getDistanceUnits() {
        return DistanceUnits;
    }

    public void setDistanceUnits(String distanceUnits) {
        DistanceUnits = distanceUnits;
    }

    public Double getDistanceValue() {
        return DistanceValue;
    }

    public void setDistanceValue(Double distanceValue) {
        DistanceValue = distanceValue;
    }

    public Double getOdometer() {
        return Odometer;
    }

    public void setOdometer(Double odometer) {
        Odometer = odometer;
    }

    public ServiceSchedule[] getItems() {
        return Items;
    }

    public void setItems(ServiceSchedule[] items) {
        Items = items;
    }

    public String getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        TimeStamp = timeStamp;
    }

    public String getTimeUnits() {
        return TimeUnits;
    }

    public void setTimeUnits(String timeUnits) {
        TimeUnits = timeUnits;
    }

    public Double getTimeValue() {
        return TimeValue;
    }

    public void setTimeValue(Double timeValue) {
        TimeValue = timeValue;
    }

    @Override
    public String toString() {
        return "NextServiceSchedule{" +
                "TimeStamp='" + TimeStamp + '\'' +
                ", Odometer=" + Odometer +
                ", AgeInMonths=" + AgeInMonths +
                ", TimeUnits='" + TimeUnits + '\'' +
                ", TimeValue=" + TimeValue +
                ", DistanceUnits='" + DistanceUnits + '\'' +
                ", DistanceValue=" + DistanceValue +
                ", Items=" + Arrays.toString(Items) +
                '}';
    }
}
