package io.moj.java.sdk.model.values;

import io.moj.java.sdk.model.enums.HarshEventType;
import io.moj.java.sdk.model.enums.TurnType;

/**
 * Model object for a harsh event state object.
 * Created by Mauro on 2016-09-21.
 */
public class HarshEventState extends BooleanState {

    private HarshEventType EventType;
    private TurnType TurnType;

    public HarshEventType getEventType() {
        return EventType;
    }

    public void setEventType(HarshEventType eventType) {
        EventType = eventType;
    }

    public TurnType getTurnType() {
        return TurnType;
    }

    public void setTurnType(TurnType turnType) {
        TurnType = turnType;
    }

    @Override
    public String toString() {
        return "HarshEventState{" +
                "EventType=" + EventType +
                ", TurnType=" + TurnType +
                "} " + super.toString();
    }
}
