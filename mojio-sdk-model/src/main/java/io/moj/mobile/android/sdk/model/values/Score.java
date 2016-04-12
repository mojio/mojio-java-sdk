package io.moj.mobile.android.sdk.model.values;

import io.moj.mobile.android.sdk.model.enums.ScoringMethod;

/**
 * Model object for a Score value.
 * Created by mhorie on 2016-01-14.
 */
public class Score {

    private ScoringMethod ScoringMethod;
    private Float Value;
    private Float Percentile;
    private Float Average;

    public Float getAverage() {
        return Average;
    }

    public void setAverage(Float average) {
        Average = average;
    }

    public float getPercentile() {
        return Percentile;
    }

    public void setPercentile(Float percentile) {
        Percentile = percentile;
    }

    public ScoringMethod getScoringMethod() {
        return ScoringMethod;
    }

    public void setScoringMethod(ScoringMethod scoringMethod) {
        ScoringMethod = scoringMethod;
    }

    public float getValue() {
        return Value;
    }

    public void setValue(Float value) {
        Value = value;
    }

    @Override
    public String toString() {
        return "Score{" +
                "Average=" + Average +
                ", ScoringMethod=" + ScoringMethod +
                ", Value=" + Value +
                ", Percentile=" + Percentile +
                '}';
    }
}
