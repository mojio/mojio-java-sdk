package io.moj.mobile.android.sdk.model.values;

/**
 * Model object for an MeasurementStatistics.
 * Created by mhorie on 2016-01-14.
 */
public class MeasurementStatistics {

    private Float NumOfSamples;
    private Float Average;
    private Float Variance;
    private Float StdDev;
    private Float IndexOfDispersion;
    private Float CoeffOfVariation;
    private Float M2;
    private Float Min;
    private Float Max;
    private Score StandardScore;
    private Score MinMaxScore;

    public Float getAverage() {
        return Average;
    }

    public void setAverage(Float average) {
        Average = average;
    }

    public Float getCoeffOfVariation() {
        return CoeffOfVariation;
    }

    public void setCoeffOfVariation(Float coeffOfVariation) {
        CoeffOfVariation = coeffOfVariation;
    }

    public Float getIndexOfDispersion() {
        return IndexOfDispersion;
    }

    public void setIndexOfDispersion(Float indexOfDispersion) {
        IndexOfDispersion = indexOfDispersion;
    }

    public Float getM2() {
        return M2;
    }

    public void setM2(Float m2) {
        M2 = m2;
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

    public Score getMinMaxScore() {
        return MinMaxScore;
    }

    public void setMinMaxScore(Score minMaxScore) {
        MinMaxScore = minMaxScore;
    }

    public Float getNumOfSamples() {
        return NumOfSamples;
    }

    public void setNumOfSamples(Float numOfSamples) {
        NumOfSamples = numOfSamples;
    }

    public Score getStandardScore() {
        return StandardScore;
    }

    public void setStandardScore(Score standardScore) {
        StandardScore = standardScore;
    }

    public Float getStdDev() {
        return StdDev;
    }

    public void setStdDev(Float stdDev) {
        StdDev = stdDev;
    }

    public Float getVariance() {
        return Variance;
    }

    public void setVariance(Float variance) {
        Variance = variance;
    }

    @Override
    public String toString() {
        return "MeasurementStatistics{" +
                "Average=" + Average +
                ", NumOfSamples=" + NumOfSamples +
                ", Variance=" + Variance +
                ", StdDev=" + StdDev +
                ", IndexOfDispersion=" + IndexOfDispersion +
                ", CoeffOfVariation=" + CoeffOfVariation +
                ", M2=" + M2 +
                ", Min=" + Min +
                ", Max=" + Max +
                ", StandardScore=" + StandardScore +
                ", MinMaxScore=" + MinMaxScore +
                '}';
    }
}
