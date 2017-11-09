package io.moj.java.sdk.model.values;

import io.moj.java.sdk.model.enums.CompatLevel;

/**
 * Model object for vehicle compatibility.
 * Created by alexc on 2017-03-24.
 */

public class CompatDetails {

    private CompatLevel Level;
    private String LastChecked;
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
