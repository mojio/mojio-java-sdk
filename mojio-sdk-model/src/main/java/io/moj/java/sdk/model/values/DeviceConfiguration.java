package io.moj.java.sdk.model.values;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.moj.java.sdk.utils.TimeUtils;

/**
 * Model object for device configuration.
 * Created by mhorie on 2018-04-03.
 */
public class DeviceConfiguration implements Serializable {

    private static final String KEY_DISTURBANCE_THRESHOLD = "AcclWakeupThreshold";

    private Map<String, List<String>> Configurations = new HashMap<>();
    private String TimeToLive;

    public Map<String, List<String>> getConfigurations() {
        return Configurations;
    }

    public void setConfigurations(Map<String, List<String>> configurations) {
        Configurations = configurations;
    }

    public Long getTimeToLive() {
        return TimeUtils.convertTimespanToMillis(TimeToLive);
    }

    public void setTimeToLive(Long timeToLive) {
        TimeToLive = TimeUtils.convertMillisToTimespan(timeToLive);
    }

    public DisturbanceThreshold getDisturbanceThreshold() {
        List<String> values = Configurations.get(KEY_DISTURBANCE_THRESHOLD);
        if (values != null && !values.isEmpty()) {
            return DisturbanceThreshold.fromKey(values.get(0));
        }
        return null;
    }

    public void setDisturbanceThreshold(DisturbanceThreshold threshold) {
        List<String> values = Configurations.get(KEY_DISTURBANCE_THRESHOLD);
        values = values == null ? new ArrayList<String>() : values;
        values.clear();
        if (threshold != null) {
            values.add(threshold.getKey());
        }
        Configurations.put(KEY_DISTURBANCE_THRESHOLD, values);
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
