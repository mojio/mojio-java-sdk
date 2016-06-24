package io.moj.java.sdk.model.stream;

import java.util.Map;

import io.moj.java.sdk.utils.TimeUtils;

/**
 * Activity object in activity streams.
 * Created by Mauro on 2016-06-23.
 */
public class ActivityObject extends BaseActivityObject {
    public static final String ACTOR = "Actor";
    public static final String TARGET = "Target";
    public static final String RESULT = "Result";
    public static final String OBJECT = "Object";
    public static final String SUMMARY = "Summary";
    public static final String START_TIME = "StartTime";
    public static final String END_TIME = "EndTime";
    public static final String DURATION = "Duration";
    public static final String PUBLISHED = "Published";
    public static final String UPDATED = "Updated";

    private BaseActivityObject Actor;
    private BaseActivityObject Target;
    private BaseActivityObject Result;
    private BaseActivityObject Object;
    private Map<String, String> Summary;
    private String StartTime;
    private String EndTime;
    private String Duration;
    private String Published;
    private String Updated;

    public BaseActivityObject getActor() {
        return Actor;
    }

    public void setActor(BaseActivityObject actor) {
        Actor = actor;
    }

    public BaseActivityObject getTarget() {
        return Target;
    }

    public void setTarget(BaseActivityObject target) {
        Target = target;
    }

    public BaseActivityObject getResult() {
        return Result;
    }

    public void setResult(BaseActivityObject result) {
        Result = result;
    }

    public BaseActivityObject getObject() {
        return Object;
    }

    public void setObject(BaseActivityObject object) {
        Object = object;
    }

    public Map<String, String> getSummary() {
        return Summary;
    }

    public void setSummary(Map<String, String> summary) {
        Summary = summary;
    }

    public Long getStartTime() {
        return TimeUtils.convertTimestampToMillis(StartTime);
    }

    public void setStartTime(Long startTime) {
        StartTime = TimeUtils.convertMillisToTimestamp(startTime);
    }

    public Long getEndTime() {
        return TimeUtils.convertTimestampToMillis(EndTime);
    }

    public void setEndTime(Long endTime) {
        EndTime = TimeUtils.convertMillisToTimestamp(endTime);
    }

    public Long getDuration() {
        return TimeUtils.convertTimespanToMillis(Duration);
    }

    public void setDuration(Long duration) {
        Duration = TimeUtils.convertMillisToTimespan(duration);
    }

    public Long getPublished() {
        return TimeUtils.convertTimestampToMillis(Published);
    }

    public void setPublished(Long published) {
        Published = TimeUtils.convertMillisToTimestamp(published);
    }

    public Long getUpdated() {
        return TimeUtils.convertTimestampToMillis(Updated);
    }

    public void setUpdated(Long updated) {
        Updated = TimeUtils.convertMillisToTimestamp(updated);
    }

    @Override
    public String toString() {
        return "ActivityObject{" +
                "Actor=" + Actor +
                ", Target=" + Target +
                ", Result=" + Result +
                ", Object=" + Object +
                ", Summary=" + Summary +
                ", StartTime='" + StartTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", Duration='" + Duration + '\'' +
                ", Published='" + Published + '\'' +
                ", Updated='" + Updated + '\'' +
                "} " + super.toString();
    }
}
