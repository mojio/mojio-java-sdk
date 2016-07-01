package io.moj.java.sdk.model.stream;

import java.util.Map;

import io.moj.java.sdk.model.MojioObject;
import io.moj.java.sdk.utils.TimeUtils;

/**
 * Base activity stream object.
 * Created by Mauro on 2016-06-23.
 */
public class BaseActivityObject implements MojioObject {
    public static final String HREF = "HRef";
    public static final String CONTEXT = "Context";
    public static final String TYPE = "Type";
    public static final String NAME = "Name";
    public static final String LOCATION = "Location";
    public static final String START_TIME = "StartTime";
    public static final String END_TIME = "EndTime";
    public static final String DURATION = "Duration";
    public static final String ORIGIN = "Origin";
    public static final String SUMMARY_MAP = "SummaryMap";
    public static final String NAME_MAP = "NameMap";

    private String Id;
    private String HRef;
    private String Context;
    private String Type;
    private String Name;
    private Location Location;
    private String StartTime;
    private String EndTime;
    private String Duration;
    private Link Origin;
    private Map<String, String> SummaryMap;
    private Map<String, String> NameMap;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getHRef() {
        return HRef;
    }

    public void setHRef(String HRef) {
        this.HRef = HRef;
    }

    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        Context = context;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Location getLocation() {
        return Location;
    }

    public void setLocation(Location location) {
        Location = location;
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

    public Link getOrigin() {
        return Origin;
    }

    public void setOrigin(Link origin) {
        Origin = origin;
    }

    public Map<String, String> getSummaryMap() {
        return SummaryMap;
    }

    public void setSummaryMap(Map<String, String> summary) {
        SummaryMap = summary;
    }

    public Map<String, String> getNameMap() {
        return NameMap;
    }

    public void setNameMap(Map<String, String> nameMap) {
        NameMap = nameMap;
    }

    @Override
    public String toString() {
        return "BaseActivityObject{" +
                "Id='" + Id + '\'' +
                ", HRef='" + HRef + '\'' +
                ", Context='" + Context + '\'' +
                ", Type='" + Type + '\'' +
                ", Name='" + Name + '\'' +
                ", Location=" + Location +
                ", StartTime='" + StartTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", Duration='" + Duration + '\'' +
                ", Origin=" + Origin +
                ", SummaryMap=" + SummaryMap +
                ", NameMap=" + NameMap +
                '}';
    }
}
