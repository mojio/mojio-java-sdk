package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

public class MojioCapability {
    @SerializedName(value = "Actuators", alternate = {"actuators"})
    private Actuators actuators;

    @SerializedName(value = "Sensors", alternate = {"sensors"})
    private Sensors sensors;

    public Actuators getActuators() {
        return actuators;
    }

    public void setActuators(Actuators actuators) {
        this.actuators = actuators;
    }

    public Sensors getSensors() {
        return sensors;
    }

    public void setSensors(Sensors sensors) {
        this.sensors = sensors;
    }

    @Override
    public String toString() {
        return "MojioCapability{" +
                "actuators=" + actuators +
                ", sensors=" + sensors +
                '}';
    }
}
