package io.moj.java.sdk.model.stream;

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
    public static final String PUBLISHED = "Published";
    public static final String UPDATED = "Updated";

    private BaseActivityObject Actor;
    private BaseActivityObject Target;
    private BaseActivityObject Result;
    private BaseActivityObject Object;
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
                ", Published='" + Published + '\'' +
                ", Updated='" + Updated + '\'' +
                "} " + super.toString();
    }
}
