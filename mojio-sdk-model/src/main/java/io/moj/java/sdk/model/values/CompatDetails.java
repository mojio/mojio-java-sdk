package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import io.moj.java.sdk.model.enums.CompatLevel;

import java.io.Serializable;

/**
 * Model object for vehicle compatibility.
 * Created by alexc on 2017-03-24.
 */

public class CompatDetails implements Serializable {

    @SerializedName(value = "Level", alternate = "level")
    private CompatLevel Level;
    @SerializedName(value = "LastChecked", alternate = "lastChecked")
    private String LastChecked;
    @SerializedName(value = "Changed", alternate = "changed")
    private boolean Changed;

    public CompatLevel getLevel() {
        return Level;
    }

    public void setLevel(CompatLevel level) {
        Level = level;
    }

    public String getLastChecked() {
        return LastChecked;
    }

    public void setLastChecked(String lastChecked) {
        LastChecked = lastChecked;
    }

    public boolean getChanged() {
        return Changed;
    }

    public void setChanged(boolean changed) {
        Changed = changed;
    }

    @Override
    public String toString() {
        return "CompatDetails{" +
                "Level=" + Level +
                ", LastChecked='" + LastChecked + '\'' +
                ", Changed=" + Changed +
                '}';
    }
}
