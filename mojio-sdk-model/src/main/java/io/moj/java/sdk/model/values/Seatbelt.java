package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Seatbelt implements Serializable {
    @SerializedName(value = "Timestamp", alternate = {"timestamp", "TimeStamp"})
    private String Timestamp;
    @SerializedName(value = "SeatbeltStatusDriver", alternate = {"seatbeltStatusDriver", "seatbeltstatusdriver"})
    private Boolean SeatbeltStatusDriver;
    @SerializedName(value = "SeatbeltStatusPassenger", alternate = {"seatbeltStatusPassenger", "seatbeltstatuspassenger"})
    private Boolean SeatbeltStatusPassenger;
    @SerializedName(value = "SeatbeltStatusWarning", alternate = {"seatbeltStatusWarning", "seatbeltstatuswarning"})
    private Boolean SeatbeltStatusWarning;

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public Boolean getSeatbeltStatusDriver() {
        return SeatbeltStatusDriver;
    }

    public void setSeatbeltStatusDriver(Boolean seatbeltStatusDriver) {
        SeatbeltStatusDriver = seatbeltStatusDriver;
    }

    public Boolean getSeatbeltStatusPassenger() {
        return SeatbeltStatusPassenger;
    }

    public void setSeatbeltStatusPassenger(Boolean seatbeltStatusPassenger) {
        SeatbeltStatusPassenger = seatbeltStatusPassenger;
    }

    public Boolean getSeatbeltStatusWarning() {
        return SeatbeltStatusWarning;
    }

    public void setSeatbeltStatusWarning(Boolean seatbeltStatusWarning) {
        SeatbeltStatusWarning = seatbeltStatusWarning;
    }

    @Override
    public String toString() {
        return "Seatbelt{" +
                "Timestamp='" + Timestamp + '\'' +
                ", SeatbeltStatusDriver=" + SeatbeltStatusDriver +
                ", SeatbeltStatusPassenger=" + SeatbeltStatusPassenger +
                ", SeatbeltStatusWarning=" + SeatbeltStatusWarning +
                '}';
    }
}
