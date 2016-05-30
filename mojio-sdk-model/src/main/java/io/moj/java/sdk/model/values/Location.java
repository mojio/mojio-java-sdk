package io.moj.java.sdk.model.values;

import io.moj.java.sdk.utils.TimeUtils;

/**
 * Model object for a Location.
 * Created by mhorie on 2016-01-12.
 */
public class Location {

    private Address Address;
    private String Timestamp;
    private Float Lat;
    private Float Lng;
    private String Status;
    private Float Dilution;
    private Float Altitude;
    private String GeoHash;

    public Address getAddress() {
        return Address;
    }

    public void setAddress(Address address) {
        Address = address;
    }

    public Float getAltitude() {
        return Altitude;
    }

    public void setAltitude(Float altitude) {
        Altitude = altitude;
    }

    public Float getDilution() {
        return Dilution;
    }

    public void setDilution(Float dilution) {
        Dilution = dilution;
    }

    public String getGeoHash() {
        return GeoHash;
    }

    public void setGeoHash(String geoHash) {
        GeoHash = geoHash;
    }

    public Float getLat() {
        return Lat;
    }

    public void setLat(Float lat) {
        Lat = lat;
    }

    public Float getLng() {
        return Lng;
    }

    public void setLng(Float lng) {
        Lng = lng;
    }

    public Long getTimestamp() {
        return TimeUtils.convertTimestampToMillis(Timestamp);
    }

    public void setTimestamp(Long timestamp) {
        Timestamp = TimeUtils.convertMillisToTimestamp(timestamp);
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Location{" +
                "Address=" + Address +
                ", Timestamp='" + Timestamp + '\'' +
                ", Lat=" + Lat +
                ", Lng=" + Lng +
                ", Status='" + Status + '\'' +
                ", Dilution=" + Dilution +
                ", Altitude=" + Altitude +
                ", GeoHash='" + GeoHash + '\'' +
                '}';
    }
}
