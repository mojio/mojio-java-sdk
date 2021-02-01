package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TirePressure implements Serializable {

    public static final String TIMESTAMP = "Timestamp";
    public static final String TIRE_PRESSURE_WARNING = "TirePressureWarning";
    public static final String RIGHT_FRONT_TIRE_PRESSURE_STATUS = "RightFrontTirePressureStatus";
    public static final String RIGHT_REAR_TIRE_PRESSURE_STATUS = "RightRearTirePressureStatus";
    public static final String RIGHT_REAR_OUTER_TIRE_PRESSURE_STATUS = "RightRearOuterTirePressureStatus";
    public static final String LEFT_FRONT_TIRE_PRESSURE_STATUS = "LeftFrontTirePressureStatus";
    public static final String LEFT_REAR_TIRE_PRESSURE_STATUS = "LeftRearTirePressureStatus";
    public static final String LEFT_REAR_OUTER_TIRE_PRESSURE_STATUS = "LeftRearOuterTirePressureStatus";

    @SerializedName(value = "Timestamp", alternate = "timestamp")
    private String Timestamp;
    @SerializedName(value = "TirePressureWarning", alternate = "tirePressureWarning")
    private Boolean TirePressureWarning;
    @SerializedName(value = "RightFrontTirePressureStatus", alternate = "rightFrontTirePressureStatus")
    private TirePressureStatus RightFrontTirePressureStatus;
    @SerializedName(value = "RightRearTirePressureStatus", alternate = "rightRearTirePressureStatus")
    private TirePressureStatus RightRearTirePressureStatus;
    @SerializedName(value = "RightRearOuterTirePressureStatus", alternate = "rightRearOuterTirePressureStatus")
    private TirePressureStatus RightRearOuterTirePressureStatus;
    @SerializedName(value = "LeftFrontTirePressureStatus", alternate = "leftFrontTirePressureStatus")
    private TirePressureStatus LeftFrontTirePressureStatus;
    @SerializedName(value = "LeftRearTirePressureStatus", alternate = "leftRearTirePressureStatus")
    private TirePressureStatus LeftRearTirePressureStatus;
    @SerializedName(value = "LeftRearOuterTirePressureStatus", alternate = "leftRearOuterTirePressureStatus")
    private TirePressureStatus LeftRearOuterTirePressureStatus;

    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public Boolean getTirePressureWarning() {
        return TirePressureWarning;
    }

    public void setTirePressureWarning(Boolean tirePressureWarning) {
        TirePressureWarning = tirePressureWarning;
    }

    public TirePressureStatus getRightFrontTirePressureStatus() {
        return RightFrontTirePressureStatus;
    }

    public void setRightFrontTirePressureStatus(TirePressureStatus rightFrontTirePressureStatus) {
        RightFrontTirePressureStatus = rightFrontTirePressureStatus;
    }

    public TirePressureStatus getRightRearTirePressureStatus() {
        return RightRearTirePressureStatus;
    }

    public void setRightRearTirePressureStatus(TirePressureStatus rightRearTirePressureStatus) {
        RightRearTirePressureStatus = rightRearTirePressureStatus;
    }

    public TirePressureStatus getRightRearOuterTirePressureStatus() {
        return RightRearOuterTirePressureStatus;
    }

    public void setRightRearOuterTirePressureStatus(TirePressureStatus rightRearOuterTirePressureStatus) {
        RightRearOuterTirePressureStatus = rightRearOuterTirePressureStatus;
    }

    public TirePressureStatus getLeftFrontTirePressureStatus() {
        return LeftFrontTirePressureStatus;
    }

    public void setLeftFrontTirePressureStatus(TirePressureStatus leftFrontTirePressureStatus) {
        LeftFrontTirePressureStatus = leftFrontTirePressureStatus;
    }

    public TirePressureStatus getLeftRearTirePressureStatus() {
        return LeftRearTirePressureStatus;
    }

    public void setLeftRearTirePressureStatus(TirePressureStatus leftRearTirePressureStatus) {
        LeftRearTirePressureStatus = leftRearTirePressureStatus;
    }

    public TirePressureStatus getLeftRearOuterTirePressureStatus() {
        return LeftRearOuterTirePressureStatus;
    }

    public void setLeftRearOuterTirePressureStatus(TirePressureStatus leftRearOuterTirePressureStatus) {
        LeftRearOuterTirePressureStatus = leftRearOuterTirePressureStatus;
    }

    @Override
    public String toString() {
        return "TirePressure{" +
                "Timestamp='" + Timestamp + '\'' +
                ", TirePressureWarning='" + TirePressureWarning +
                ", RightFrontTirePressureStatus='" + RightFrontTirePressureStatus +
                ", RightRearTirePressureStatus='" + RightRearTirePressureStatus +
                ", RightRearOuterTirePressureStatus='" + RightRearOuterTirePressureStatus +
                ", LeftFrontTirePressureStatus='" + LeftFrontTirePressureStatus +
                ", LeftRearTirePressureStatus='" + LeftRearTirePressureStatus +
                ", LeftRearOuterTirePressureStatus='" + LeftRearOuterTirePressureStatus +
                '}';
    }
}
