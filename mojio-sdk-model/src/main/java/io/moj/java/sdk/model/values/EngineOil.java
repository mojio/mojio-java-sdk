package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

/**
 * Model object for vehicle EngineOil.
 * Created by oleksii borys on 2019-08-22.
 */
public class EngineOil {

    public static final String TIMESTAMP = "Timestamp";
    public static final String ENGINE_OIL_LEVEL_WARNING = "EngineOilLevelWarning";
    public static final String ENGINE_OIL_PRESSURE_LOW_WARNING = "EngineOilPressureLowWarning";
    public static final String ENGINE_OIL_TEMPERATURE = "EngineOilTemperature";

    @SerializedName(value = "TimeStamp", alternate = {"timestamp", "Timestamp"})
    private String TimeStamp;
    @SerializedName(value = "EngineOilLevelWarning", alternate = {"engineoillevelwarning", "engineOilLevelWarning"})
    private String EngineOilLevelWarning;
    @SerializedName(value = "EngineOilPressureLowWarning", alternate = {"engineoilpressurelowwarning", "engineOilPressureLowWarning"})
    private Boolean EngineOilPressureLowWarning;
    @SerializedName(value = "EngineOilTemperature", alternate = {"engineoiltemperature", "engineOilTemperature"})
    private EngineOilTemperature EngineOilTemperature;

    public String getTimeStamp() { return TimeStamp; }

    public void setTimeStamp(String timeStamp) { TimeStamp = timeStamp; }

    public String getEngineOilLevelWarning() { return EngineOilLevelWarning; }

    public void setEngineOilLevelWarning(String engineOilLevelWarning) {
        EngineOilLevelWarning = engineOilLevelWarning;
    }

    public Boolean getEngineOilPressureLowWarning() {
        return EngineOilPressureLowWarning;
    }

    public void setEngineOilPressureLowWarning(Boolean engineOilPressureLowWarning) {
        EngineOilPressureLowWarning = engineOilPressureLowWarning;
    }

    public EngineOilTemperature getEngineOilTemperature() {
        return EngineOilTemperature;
    }

    public void setEngineOilTemperature(EngineOilTemperature engineOilTemperature) {
        EngineOilTemperature = engineOilTemperature;
    }

    @Override
    public String toString() {
        return "EngineOil{" +
                "TimeStamp='" + TimeStamp + '\'' +
                ", EngineOilLevelWarning='" + EngineOilLevelWarning + '\'' +
                ", EngineOilPressureLowWarning=" + EngineOilPressureLowWarning +
                ", EngineOilTemperature=" + EngineOilTemperature +
                '}';
    }
}
