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
    public static final String UNITS = "Units";
    public static final String DATE = "Date";
    public static final String COUNT = "Count";

    private Float Average;
    private Float Max;
    private Float Min;
    private String Units;
    private String Date;
    private Integer Count;

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

    public String getUnits() {
        return Units;
    }

    public void setUnits(String units) {
        Units = units;
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

    @Override
    public String toString() {
        return "Aggregate{" +
                "Average=" + Average +
                ", Max=" + Max +
                ", Min=" + Min +
                ", Units='" + Units + '\'' +
                ", Date='" + Date + '\'' +
                ", Count=" + Count +
                '}';
    }
}
