package io.moj.java.sdk.model.values;

public class CellularRadio {
    private String Timestamp;
    private double ReceiveSignalBars;

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public double getReceiveSignalBars() { return ReceiveSignalBars; }

    public void setReceiveSignalBars(double receiveSignalBars) { ReceiveSignalBars = receiveSignalBars; }

    @Override
    public String toString() {
        return "CellularRadio{" +
                "Timestamp='" + Timestamp + '\'' +
                ", ReceiveSignalBars=" + ReceiveSignalBars +
                '}';
    }

    public enum SignalStatus {
        NO_CONNECTION, MODERATE, GOOD, FULL, UNKNOWN
    }
}