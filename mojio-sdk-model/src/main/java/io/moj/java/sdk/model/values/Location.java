package io.moj.java.sdk.model.values;

import java.util.ArrayList;
import java.util.List;

import io.moj.java.sdk.model.enums.GPSStatus;
import io.moj.java.sdk.utils.TimeUtils;

/**
 * Model object for a Location.
 * Created by mhorie on 2016-01-12.
 */
public class Location {

    public static final String ADDRESS = "Address";
    public static final String TIMESTAMP = "Timestamp";
    public static final String LAT = "Lat";
    public static final String LNG = "Lng";
    public static final String STATUS = "Status";
    public static final String DILUTION = "Dilution";
    public static final String ALTITUDE = "Altitude";
    public static final String GEOHASH = "GeoHash";

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

    public List<GPSStatus> getStatus() {
        if (Status == null || Status.isEmpty()) {
            return null;
        }
        String[] statusList = Status.split(",");

        List<GPSStatus> statuses = new ArrayList<>();

        for (GPSStatus status : GPSStatus.values()) {
            for (String s : statusList) {
                if (s != null && s.equals(status.getKey())) {
                    statuses.add(status);
                    break;
                }
            }
        }
        return statuses;
    }

    public void setStatus(List<GPSStatus> statuses) {
        if (statuses == null) {
            Status = null;
            return;
        }

        StringBuilder statusBuilder = new StringBuilder();
        for (int i = 0; i < statuses.size(); i++) {
            statusBuilder.append(statuses.get(i).getKey());
            if (i != statuses.size() - 1) {
                statusBuilder.append(", ");
            }
        }
        Status = statusBuilder.toString();
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
