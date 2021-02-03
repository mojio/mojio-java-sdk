package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Details implements Serializable {
    @SerializedName(value = "purpose", alternate = "Purpose")
    private String Purpose;
    @SerializedName(value = "notes", alternate = "Notes")
    private String Notes;
    @SerializedName(value = "lastUpdatedByUserTimeStamp", alternate = "LastUpdatedByUserTimeStamp")
    private String LastUpdatedByUserTimeStamp;

    public String getPurpose() {
        return Purpose;
    }

    public void setPurpose(String purpose) {
        this.Purpose = purpose;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        this.Notes = notes;
    }

    public String getLastUpdatedByUserTimeStamp() {
        return LastUpdatedByUserTimeStamp;
    }

    public void setLastUpdatedByUserTimeStamp(String lastUpdatedByUserTimeStamp) {
        this.LastUpdatedByUserTimeStamp = lastUpdatedByUserTimeStamp;
    }

    @Override
    public String toString() {
        return "Details{" +
                "purpose='" + Purpose + '\'' +
                ", notes='" + Notes + '\'' +
                ", lastUpdatedByUserTimeStamp='" + LastUpdatedByUserTimeStamp + '\'' +
                '}';
    }
}
