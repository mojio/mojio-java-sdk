package io.moj.java.sdk.model.values;

import io.moj.java.sdk.utils.TimeUtils;

/**
 * Model class for a data aggregate. This is essentially a "bucket" of data for a given
 * {@link io.moj.java.sdk.model.values.DeviceMeasurement} over time.
 * Created by skidson on 2016-09-06.
 */
public class Aggregate {

    public static final String AVERAGE = "Average";
    public static final String MAX = "Max";
    public static final String MIN = "Min";
    public static final String TOTAL = "Total";
    public static final String UNITS = "Units";
    public static final String DATE = "Date";
    public static final String END_DATE = "EndDate";
    public static final String COUNT = "Count";
    public static final String TRIP_COUNT = "TripCount";

    private Float Average;
    private Float Max;
    private Float Min;
    private Float Total;
    private String Units;
    private String Date;
    private String EndDate;
    private Integer Count;
    private Integer TripCount;

    public Float getAverage() {
        return Average;
    }

    public void setAverage(Float average) {
        Average = average;
    }

    public Float getMax() {
        return Max;
    }

    public void setMax(Float max) {
        Max = max;
    }

    public Float getMin() {
        return Min;
    }

    public void setMin(Float min) {
        Min = min;
    }

    public Float getTotal() {
        return Total;
    }

    public void setTotal(Float total) {
        Total = total;
    }

    public String getUnits() {
        return Units;
    }

    public void setUnits(String units) {
        Units = units;
    }

    public Long getEndDate() {
        return TimeUtils.convertTimestampToMillis(EndDate);
    }

    public void setEndDate(Long date) {
        EndDate = TimeUtils.convertMillisToTimestamp(date);
    }

    public Long getDate() {
        return TimeUtils.convertTimestampToMillis(Date);
    }

    public void setDate(Long date) {
        Date = TimeUtils.convertMillisToTimestamp(date);
    }

    public Integer getCount() {
        return Count;
    }

    public void setCount(Integer count) {
        Count = count;
    }

    public Integer getTripCount() {
        return TripCount;
    }

    public void setTripCount(Integer tripCount) {
        TripCount = tripCount;
    }

    @Override
    public String toString() {
        return "Aggregate{" +
                "Average=" + Average +
                ", Max=" + Max +
                ", Min=" + Min +
                ", Total=" + Total +
                ", Units='" + Units + '\'' +
                ", Date='" + Date + '\'' +
                ", EndDate='" + EndDate + '\'' +
                ", Count=" + Count +
                ", TripCount=" + TripCount +
                '}';
    }
}
