package io.moj.java.sdk.model;

import java.util.Arrays;

import io.moj.java.sdk.model.values.Location;
import io.moj.java.sdk.model.values.WifiRadio;
import io.moj.java.sdk.utils.TimeUtils;

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
    public static final String WIFI_RADIO = "WifiRadio";
    public static final String MSISDN_PROP = "MSISDN";
    public static final String HARDWARE_VERSION = "HardwareVersion";
    public static final String FIRMWARE_VERSION = "FirmwareVersion";
    public static final String VENDOR = "Vendor";
    public static final String DELETED = "Deleted";

    private String Name;
    private String IMEI;
    private String VehicleId;
    private String LastContactTime;
    private String GatewayTime;
    private Location Location;
    private String[] Tags;
    private WifiRadio WifiRadio;
    private String MSISDN;
    private String HardwareVersion;
    private String Vendor;
    private String FirmwareVersion;
    private Boolean Deleted;

    public Mojio() {}

    public Mojio(String imei) {
        this.IMEI = imei;
    }

    /**
     * @return the time the server received the message from the device
     */
    public Long getGatewayTime() {
        return TimeUtils.convertTimestampToMillis(GatewayTime);
    }

    public void setGatewayTime(Long gatewayTime) {
        GatewayTime = TimeUtils.convertMillisToTimestamp(gatewayTime);
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

    public Long getLastContactTime() {
        return TimeUtils.convertTimestampToMillis(LastContactTime);
    }

    public void setLastContactTime(Long lastContactTime) {
        LastContactTime = TimeUtils.convertMillisToTimestamp(lastContactTime);
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

    public WifiRadio getWifiRadio() {
        return WifiRadio;
    }

    public void setWifiRadio(WifiRadio wifiRadio) {
        WifiRadio = wifiRadio;
    }

    public String getMSISDN() {
        return MSISDN;
    }

    public void setMSISDN(String msisdn) {
        this.MSISDN = msisdn;
    }

    public String getHardwareVersion() {
        return HardwareVersion;
    }

    public void setHardwareVersion(String hardwareVersion) {
        HardwareVersion = hardwareVersion;
    }

    public String getVendor() {
        return Vendor;
    }

    public void setVendor(String vendor) {
        Vendor = vendor;
    }

    public String getFirmwareVersion() {
        return FirmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        FirmwareVersion = firmwareVersion;
    }

    public Boolean getDeleted() {
        return Deleted;
    }

    public void setDeleted(Boolean deleted) {
        Deleted = deleted;
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
                ", WifiRadio=" + WifiRadio +
                ", MSISDN='" + MSISDN + '\'' +
                ", HardwareVersion='" + HardwareVersion + '\'' +
                ", Vendor='" + Vendor + '\'' +
                ", FirmwareVersion='" + FirmwareVersion + '\'' +
                ", Deleted=" + Deleted +
                "} " + super.toString();
    }
}
