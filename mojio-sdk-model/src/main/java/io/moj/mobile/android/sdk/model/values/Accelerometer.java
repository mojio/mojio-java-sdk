package io.moj.mobile.android.sdk.model.values;

/**
 * Model object for an Accelerometer value.
 * Created by mhorie on 2016-01-12.
 */
public class Accelerometer {

    private ProperAcceleration X;
    private ProperAcceleration Y;
    private ProperAcceleration Z;
    private ProperAcceleration Magnitude;
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
