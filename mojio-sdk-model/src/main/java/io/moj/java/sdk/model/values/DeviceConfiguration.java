package io.moj.java.sdk.model.values;

import java.util.HashMap;
import java.util.Map;

import io.moj.java.sdk.utils.TimeUtils;

/**
 * Model object for device configuration.
 * Created by mhorie on 2018-04-03.
 */
public class DeviceConfiguration {

    private static final String KEY_DISTURBANCE_THRESHOLD = "AcclWakeupThreshold";

    private Map<String, String> Configurations = new HashMap<>();
    private String TimeToLive;

    public Map<String, String> getConfigurations() {
        return Configurations;
    }

    public Long getTimeToLive() {
        return TimeUtils.convertTimespanToMillis(TimeToLive);
    }

    public void setTimeToLive(Long timeToLive) {
        TimeToLive = TimeUtils.convertMillisToTimespan(timeToLive);
    }

    public DisturbanceThreshold getDisturbanceThreshold() {
        return DisturbanceThreshold.fromKey(Configurations.get(KEY_DISTURBANCE_THRESHOLD));
    }

    public void setDisturbanceThreshold(DisturbanceThreshold threshold) {
        Configurations.put(KEY_DISTURBANCE_THRESHOLD, threshold.getKey());
    }

    @Override
    public String toString() {
        return "DeviceConfiguration{" +
                "Configurations=" + Configurations +
                ", TimeToLive='" + TimeToLive + '\'' +
                '}';
    }

    public enum DisturbanceThreshold {
        LOW("Low"),
        MEDIUM("Medium"),
        HIGH("High");

        private String key;

        DisturbanceThreshold(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public static DisturbanceThreshold fromKey(String key) {
            for (DisturbanceThreshold threshold : values()) {
                if (threshold.getKey().equals(key)) {
                    return threshold;
                }
            }
            return null;
        }
    }
}
