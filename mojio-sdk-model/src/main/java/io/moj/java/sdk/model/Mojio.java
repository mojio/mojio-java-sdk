package io.moj.java.sdk.model;

import io.moj.java.sdk.model.values.Location;

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
    public static final String LOCATION = "Location";
    public static final String TAGS = "Tags";

    private String Name;
    private String IMEI;
    private String VehicleId;
    private String LastContactTime;
    private String GatewayTime;
    private Location Location;
    private String[] Tags;

    public Mojio() {}

    public Mojio(String imei) {
        this.IMEI = imei;
    }

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

    public Location getLocation() {
        return Location;
    }

    public void setLocation(Location location) {
        Location = location;
    }

    @Override
    public String toString() {
        return "Mojio{" +
                "Name='" + Name + '\'' +
                ", IMEI='" + IMEI + '\'' +
                ", VehicleId='" + VehicleId + '\'' +
                ", LastContactTime='" + LastContactTime + '\'' +
                ", GatewayTime='" + GatewayTime + '\'' +
                ", Location=" + Location +
                ", Tags=" + Arrays.toString(Tags) +
                "} " + super.toString();
    }
}
