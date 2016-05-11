package io.moj.java.sdk.math;

/**
 * Helper class to facilitate conversion of one unit to another.
 * Created by skidson on 2016-05-05.
 */
public class Divider implements UnitConverter {

    private final float conversion;

    public Divider(float conversion) {
        this.conversion = conversion;
    }

    @Override
    public float convert(float value) {
        if (value == 0f)
            return value;
        return conversion / value;
    }

}
