package io.moj.mobile.android.sdk.model.values;

/**
 * Model object for a vehicle warranty.
 * Created by skidson on 16-03-10.
 */
public class Warranty {

    private String Name;
    private String Type;
    private String Months;
    private Double Km;

    public Double getKm() {
        return Km;
    }

    public void setKm(Double km) {
        Km = km;
    }

    public String getMonths() {
        return Months;
    }

    public void setMonths(String months) {
        Months = months;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Warranty{" +
                "Km=" + Km +
                ", Name='" + Name + '\'' +
                ", Type='" + Type + '\'' +
                ", Months='" + Months + '\'' +
                '}';
    }
}
