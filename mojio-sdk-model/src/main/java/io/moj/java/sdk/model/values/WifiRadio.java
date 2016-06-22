package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;
import io.moj.java.sdk.utils.TimeUtils;

/**
 * Model class for a {@link io.moj.java.sdk.model.Mojio}'s WiFi actuator.
 * Created by skidson on 2016-06-21.
 */
public class WifiRadio {

    private String SSID;
    private String Password;
    private WifiRadio.Status Status;
    private Boolean AllowRoaming;
    private String Timestamp;

    public String getSSID() {
        return SSID;
    }

    public void setSSID(String SSID) {
        this.SSID = SSID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public WifiRadio.Status getStatus() {
        return Status;
    }

    public void setStatus(WifiRadio.Status status) {
        Status = status;
    }

    public Boolean getAllowRoaming() {
        return AllowRoaming;
    }

    public void setAllowRoaming(Boolean allowRoaming) {
        AllowRoaming = allowRoaming;
    }

    public Long getTimestamp() {
        return TimeUtils.convertTimestampToMillis(Timestamp);
    }

    public void setTimestamp(Long timestamp) {
        Timestamp = TimeUtils.convertMillisToTimestamp(timestamp);
    }

    @Override
    public String toString() {
        return "WifiRadio{" +
                "SSID='" + SSID + '\'' +
                ", Password='" + Password + '\'' +
                ", Status=" + Status +
                ", AllowRoaming=" + AllowRoaming +
                ", Timestamp='" + Timestamp + '\'' +
                '}';
    }

    public enum Status {
        @SerializedName("Connected")
        CONNECTED("Connected"),

        @SerializedName("Roaming")
        ROAMING("Roaming"),

        @SerializedName("Disconnected")
        DISCONNECTED("Disconnected");

        private String key;

        Status(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public static WifiRadio.Status fromKey(String key) {
            for (WifiRadio.Status value : values()) {
                if (value.getKey().equals(key)) {
                    return value;
                }
            }
            return null;
        }
    }
}