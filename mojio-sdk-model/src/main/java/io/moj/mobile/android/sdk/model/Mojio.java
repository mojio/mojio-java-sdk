package io.moj.mobile.android.sdk.model;

import java.util.Arrays;

/**
 * Model object for an Mojio.
 * Created by mhorie on 2016-01-13.
 */
public class Mojio extends AbstractMojioObject {

    public static final String NAME = "Name";
    public static final String DEVICE_IMEI = "IMEI";
    public static final String VEHICLE_ID = "VehicleId";
    public static final String LAST_CONTACT_TIME = "LastContactTime";
    public static final String GATEWAY_TIME = "GatewayTime";
    public static final String TAGS = "Tags";

    private String Name;
    private String IMEI;
    private String VehicleId;
    private String LastContactTime;
    private String GatewayTime;
    private String[] Tags;

    /**
     * @return the time the server received the message from the device
     */
    public String getGatewayTime() {
        return GatewayTime;
    }

    public void setGatewayTime(String gatewayTime) {
        GatewayTime = gatewayTime;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(String vehicleId) {
        VehicleId = vehicleId;
    }

    public String getLastContactTime() {
        return LastContactTime;
    }

    public void setLastContactTime(String lastContactTime) {
        LastContactTime = lastContactTime;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String[] getTags() {
        return Tags;
    }

    public void setTags(String[] tags) {
        Tags = tags;
    }

    @Override
    public String toString() {
        return "Mojio{" +
                "VehicleId='" + VehicleId + '\'' +
                ", GatewayTime='" + GatewayTime + '\'' +
                ", IMEI='" + IMEI + '\'' +
                ", LastContactTime='" + LastContactTime + '\'' +
                ", Name='" + Name + '\'' +
                ", Tags=" + Arrays.toString(Tags) +
                "} " + super.toString();
    }
}
