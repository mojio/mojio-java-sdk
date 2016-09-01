package io.moj.java.sdk.model.values;

import java.util.Arrays;

/**
 * Model object for a vehicle service schedule item.
 * Created by skidson on 16-03-10.
 */
public class ServiceSchedule {

    private String MaintenanceCategory;
    private String MaintenanceName;
    private String MaintenanceNotes;
    private String ScheduleDescription;
    private String ScheduleName;
    private String ServiceEvent;
    private String TransNotes;
    private Interval[] Intervals;

    public String getMaintenanceCategory() {
        return MaintenanceCategory;
    }

    public void setMaintenanceCategory(String maintenanceCategory) {
        MaintenanceCategory = maintenanceCategory;
    }

    public String getMaintenanceName() {
        return MaintenanceName;
    }

    public void setMaintenanceName(String maintenanceName) {
        MaintenanceName = maintenanceName;
    }

    public String getMaintenanceNotes() {
        return MaintenanceNotes;
    }

    public void setMaintenanceNotes(String maintenanceNotes) {
        MaintenanceNotes = maintenanceNotes;
    }

    public String getScheduleDescription() {
        return ScheduleDescription;
    }

    public void setScheduleDescription(String scheduleDescription) {
        ScheduleDescription = scheduleDescription;
    }

    public String getScheduleName() {
        return ScheduleName;
    }

    public void setScheduleName(String scheduleName) {
        ScheduleName = scheduleName;
    }

    public String getServiceEvent() {
        return ServiceEvent;
    }

    public void setServiceEvent(String serviceEvent) {
        ServiceEvent = serviceEvent;
    }

    public String getTransNotes() {
        return TransNotes;
    }

    public void setTransNotes(String transNotes) {
        TransNotes = transNotes;
    }

    public Interval[] getIntervals() {
        return Intervals;
    }

    public void setIntervals(Interval[] intervals) {
        Intervals = intervals;
    }

    @Override
    public String toString() {
        return "ServiceSchedule{" +
                "MaintenanceCategory='" + MaintenanceCategory + '\'' +
                ", MaintenanceName='" + MaintenanceName + '\'' +
                ", MaintenanceNotes='" + MaintenanceNotes + '\'' +
                ", ScheduleDescription='" + ScheduleDescription + '\'' +
                ", ScheduleName='" + ScheduleName + '\'' +
                ", ServiceEvent='" + ServiceEvent + '\'' +
                ", TransNotes='" + TransNotes + '\'' +
                ", Intervals=" + Arrays.toString(Intervals) +
                '}';
    }
}
