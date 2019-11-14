package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

/**
 * Model object for vehicle's PredictiveMaintenance value.
 * Created by Mykhaylo Tauzhnianskyi on 2019-11-11.
 */
public class PredictiveMaintenance {

    public static final String BATTERY_PREDICTIVE_MAINTENANCE = "Battery";
    public static final String AIR_FILTER_PREDICTIVE_MAINTENANCE = "AirFilter";

    @SerializedName(value = "Battery", alternate = "battery")
    private PredictiveWarning BatteryPredictiveWarning;
    @SerializedName(value = "AirFilter", alternate = "airFilter")
    private PredictiveWarning AirFilterPredictiveWarning;

    public PredictiveWarning getBatteryPredictiveWarning() {
        return BatteryPredictiveWarning;
    }

    public void setBatteryPredictiveWarning(PredictiveWarning batteryPredictiveWarning) {
        BatteryPredictiveWarning = batteryPredictiveWarning;
    }

    public PredictiveWarning getAirFilterPredictiveWarning() {
        return AirFilterPredictiveWarning;
    }

    public void setAirFilterPredictiveWarning(PredictiveWarning airFilterPredictiveWarning) {
        AirFilterPredictiveWarning = airFilterPredictiveWarning;
    }

    @Override
    public String toString() {
        return "PredictiveMaintenance{" +
                "BatteryPredictiveWarning='" + BatteryPredictiveWarning + '\'' +
                ", AirFilterPredictiveWarning='" + AirFilterPredictiveWarning +
                '}';
    }
}
