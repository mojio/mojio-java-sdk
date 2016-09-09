package io.moj.java.sdk.model.values;

/**
 * Service schedule event
 * Created by Mauro on 2016-09-09.
 */
public class ServiceScheduleEvent {
    public static final String COMPUTER_CODE = "ComputerCode";
    public static final String EVENT = "Event";

    private String ComputerCode;
    private String Event;

    public String getComputerCode() {
        return ComputerCode;
    }

    public void setComputerCode(String computerCode) {
        ComputerCode = computerCode;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    @Override
    public String toString() {
        return "ServiceScheduleEvent{" +
                "ComputerCode='" + ComputerCode + '\'' +
                ", Event='" + Event + '\'' +
                '}';
    }
}
