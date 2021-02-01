package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Seats implements Serializable {
    @SerializedName(value = "Timestamp", alternate = {"timestamp", "TimeStamp"})
    private String Timestamp;
    @SerializedName(value = "DriverSeatOccupiedStatus", alternate = {"driverSeatOccupiedStatus", "driverseatoccupiedstatus"})
    private String DriverSeatOccupiedStatus;
    @SerializedName(value = "PassengerSeatOccupiedStatus", alternate = {"passengerSeatOccupiedStatus", "passengerseatoccupiedstatus"})
    private String PassengerSeatOccupiedStatus;

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public String getDriverSeatOccupiedStatus() {
        return DriverSeatOccupiedStatus;
    }

    public void setDriverSeatOccupiedStatus(String driverSeatOccupiedStatus) {
        DriverSeatOccupiedStatus = driverSeatOccupiedStatus;
    }

    public String getPassengerSeatOccupiedStatus() {
        return PassengerSeatOccupiedStatus;
    }

    public void setPassengerSeatOccupiedStatus(String passengerSeatOccupiedStatus) {
        PassengerSeatOccupiedStatus = passengerSeatOccupiedStatus;
    }

    @Override
    public String toString() {
        return "Seats{" +
                "Timestamp='" + Timestamp + '\'' +
                ", DriverSeatOccupiedStatus='" + DriverSeatOccupiedStatus + '\'' +
                ", PassengerSeatOccupiedStatus='" + PassengerSeatOccupiedStatus + '\'' +
                '}';
    }
}
