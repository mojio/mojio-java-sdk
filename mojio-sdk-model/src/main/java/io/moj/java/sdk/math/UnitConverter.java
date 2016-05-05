package io.moj.java.sdk.math;

/**
 * Helper class to facilitate conversion of one unit to another.
 * Created by skidson on 2016-05-05.
 */
public class UnitConverter {

    private final float conversion;

    public UnitConverter(float conversion) {
        this.conversion = conversion;
    }

    public float convert(float value) {
        return conversion * value;
    }

}
