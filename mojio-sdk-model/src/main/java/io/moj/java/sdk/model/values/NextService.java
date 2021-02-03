package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class NextService implements Serializable {
    @SerializedName(value = "Timestamp", alternate = {"timestamp", "TimeStamp"})
    private String Timestamp;
    @SerializedName(value = "DistanceToNextService", alternate = {"distanceToNextService", "distancetonextservice"})
    private VehicleSimplePropertyDataModel DistanceToNextService;
    @SerializedName(value = "TimeToNextService", alternate = {"timeToNextService", "timetonextservice"})
    private VehicleSimplePropertyDataModel TimeToNextService;


    public String getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(String timestamp) {
        Timestamp = timestamp;
    }

    public VehicleSimplePropertyDataModel getDistanceToNextService() {
        return DistanceToNextService;
    }

    public void setDistanceToNextService(VehicleSimplePropertyDataModel distanceToNextService) {
        DistanceToNextService = distanceToNextService;
    }

    public VehicleSimplePropertyDataModel getTimeToNextService() {
        return TimeToNextService;
    }

    public void setTimeToNextService(VehicleSimplePropertyDataModel timeToNextService) {
        TimeToNextService = timeToNextService;
    }

    @Override
    public String toString() {
        return "NextService{" +
                "Timestamp='" + Timestamp + '\'' +
                ", DistanceToNextService=" + DistanceToNextService +
                ", TimeToNextService=" + TimeToNextService +
                '}';
    }
}
