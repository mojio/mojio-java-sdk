package io.moj.java.sdk.model.values;

import io.moj.java.sdk.utils.TimeUtils;

/**
 * Idle state object found in the Idle event object.
 * Created by Mauro on 2017-06-26.
 */
public class IdleEventState {
    private String StartTime;
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
