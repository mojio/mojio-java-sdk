package io.moj.java.sdk.model.values;

import java.util.Arrays;

/**
 * Model object for a vehicle service schedule list.
 * Created by Mauro on 2016-08-31.
 */
public class ServiceScheduleList {

    public static final String VIN_NUMBER = "VIN";
    public static final String IS_DEFAULT = "IsDefault";
    public static final String ITEMS = "Items";

    private String VIN;
    private Boolean IsDefault;
    private ServiceSchedule[] Items;

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public Boolean getIsDefault() {
        return IsDefault;
    }

    public void setIsDefault(Boolean aDefault) {
        IsDefault = aDefault;
    }

    public ServiceSchedule[] getItems() {
        return Items;
    }

    public void setItems(ServiceSchedule[] items) {
        Items = items;
    }

    @Override
    public String toString() {
        return "ServiceScheduleList{" +
                "VIN='" + VIN + '\'' +
                ", IsDefault=" + IsDefault +
                ", Items=" + Arrays.toString(Items) +
                '}';
    }
}
