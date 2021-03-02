package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;
import io.moj.java.sdk.model.enums.TowStateType;

import java.util.Arrays;

public class TowState extends BooleanState{
    @SerializedName(value = "Type", alternate = "type")
    private TowStateType[] type;

    public TowStateType[] getType() {
        return type;
    }

    public void setType(TowStateType[] type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TowState{" +
                "type=" + Arrays.toString(type) +
                '}'+ super.toString();
    }
}
