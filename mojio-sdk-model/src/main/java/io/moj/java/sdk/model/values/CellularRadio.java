package io.moj.java.sdk.model.values;

public class CellularRadio {
    private String Timestamp;
    private Double ReceiveSignalBars;

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public Double getReceiveSignalBars() { return ReceiveSignalBars; }

    public void setReceiveSignalBars(Double receiveSignalBars) { ReceiveSignalBars = receiveSignalBars; }

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