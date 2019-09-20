package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import io.moj.java.sdk.utils.TimeUtils;

/**
 * Idle state object found in the Idle event object.
 * Created by Mauro on 2017-06-26.
 */
public class IdleEventState {
    @SerializedName(value = "StartTime", alternate = "startTime")
    private String StartTime;
    @SerializedName(value = "Duration", alternate = "duration")
    private Duration Duration;

    public Long getStartTime() {
        return TimeUtils.convertTimestampToMillis(StartTime);
    }

    public void setStartTime(Long startTime) {
        StartTime = TimeUtils.convertMillisToTimestamp(startTime);
    }

    public Duration getDuration() {
        return Duration;
    }

    public void setDuration(Duration duration) {
        Duration = duration;
    }

    @Override
    public String toString() {
        return "IdleEventState{" +
                "StartTime='" + StartTime + '\'' +
                ", Duration=" + Duration +
                '}';
    }
}
