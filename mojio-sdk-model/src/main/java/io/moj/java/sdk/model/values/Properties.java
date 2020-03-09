package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

public class Properties {
    @SerializedName(value = "details", alternate = "Details")
    private Details Details;

    public Details getDetails() {
        return Details;
    }

    public void setDetails(Details details) {
        this.Details = details;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "details=" + Details +
                '}';
    }
}
