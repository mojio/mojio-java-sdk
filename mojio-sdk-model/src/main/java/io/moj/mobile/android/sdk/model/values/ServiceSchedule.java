package io.moj.mobile.android.sdk.model.values;

/**
 * Model object for a vehicle service schedule item.
 * Created by skidson on 16-03-10.
 */
public class ServiceSchedule {

    private String MaintenanceCategory;
    private String MaintenanceName;
    private String MaintenanceNotes;
    private String OperatingParameter;
    private String OperatingParameterNotes;
    private String ScheduleDescription;
    private String ScheduleName;
    private String ServiceEvent;
    private String TransNotes;
    private String Units;
    private Double Value;
    private Double InitialValue;
    private String IntervalType;

    public Double getInitialValue() {
        return InitialValue;
    }

    public void setInitialValue(Double initialValue) {
        InitialValue = initialValue;
    }

    public String getIntervalType() {
        return IntervalType;
    }

    public void setIntervalType(String intervalType) {
        IntervalType = intervalType;
    }

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

    public String getOperatingParameter() {
        return OperatingParameter;
    }

    public void setOperatingParameter(String operatingParameter) {
        OperatingParameter = operatingParameter;
    }

    public String getOperatingParameterNotes() {
        return OperatingParameterNotes;
    }

    public void setOperatingParameterNotes(String operatingParameterNotes) {
        OperatingParameterNotes = operatingParameterNotes;
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

    public String getUnits() {
        return Units;
    }

    public void setUnits(String units) {
        Units = units;
    }

    public Double getValue() {
        return Value;
    }

    public void setValue(Double value) {
        Value = value;
    }

    @Override
    public String toString() {
        return "ServiceSchedule{" +
                "InitialValue=" + InitialValue +
                ", MaintenanceCategory='" + MaintenanceCategory + '\'' +
                ", MaintenanceName='" + MaintenanceName + '\'' +
                ", MaintenanceNotes='" + MaintenanceNotes + '\'' +
                ", OperatingParameter='" + OperatingParameter + '\'' +
                ", OperatingParameterNotes='" + OperatingParameterNotes + '\'' +
                ", ScheduleDescription='" + ScheduleDescription + '\'' +
                ", ScheduleName='" + ScheduleName + '\'' +
                ", ServiceEvent='" + ServiceEvent + '\'' +
                ", TransNotes='" + TransNotes + '\'' +
                ", Units='" + Units + '\'' +
                ", Value=" + Value +
                ", IntervalType='" + IntervalType + '\'' +
                '}';
    }
}
