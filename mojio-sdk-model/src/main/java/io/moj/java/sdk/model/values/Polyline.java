package io.moj.java.sdk.model.values;

import java.io.Serializable;

/**
 * Model object for a Polyline.
 * Created by Mauro on 2017-03-20.
 */
public class Polyline implements Serializable {
    private String Polyline;

    public String getPolyline() {
        return Polyline;
    }

    public void setPolyline(String polyline) {
        Polyline = polyline;
    }

    @Override
    public String toString() {
        return "Polyline{" +
                "Polyline='" + Polyline + '\'' +
                '}';
    }
}
