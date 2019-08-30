package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

/**
 * Model object for an Accelerometer value.
 * Created by mhorie on 2016-01-12.
 */
public class Accelerometer {

    @SerializedName(value = "X", alternate = "x")
    private ProperAcceleration X;
    @SerializedName(value = "Y", alternate = "y")
    private ProperAcceleration Y;
    @SerializedName(value = "Z", alternate = "z")
    private ProperAcceleration Z;
    @SerializedName(value = "Magnitude", alternate = "magnitude")
    private ProperAcceleration Magnitude;
    @SerializedName(value = "SamplingInterval", alternate = "samplingInterval")
    private Duration SamplingInterval;

    public ProperAcceleration getMagnitude() {
        return Magnitude;
    }

    public void setMagnitude(ProperAcceleration magnitude) {
        Magnitude = magnitude;
    }

    public Duration getSamplingInterval() {
        return SamplingInterval;
    }

    public void setSamplingInterval(Duration samplingInterval) {
        SamplingInterval = samplingInterval;
    }

    public ProperAcceleration getX() {
        return X;
    }

    public void setX(ProperAcceleration x) {
        X = x;
    }

    public ProperAcceleration getY() {
        return Y;
    }

    public void setY(ProperAcceleration y) {
        Y = y;
    }

    public ProperAcceleration getZ() {
        return Z;
    }

    public void setZ(ProperAcceleration z) {
        Z = z;
    }

    @Override
    public String toString() {
        return "Accelerometer{" +
                "Magnitude=" + Magnitude +
                ", X=" + X +
                ", Y=" + Y +
                ", Z=" + Z +
                ", SamplingInterval=" + SamplingInterval +
                '}';
    }
}
