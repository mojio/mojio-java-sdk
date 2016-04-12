package io.moj.mobile.android.sdk.model.values;

/**
 * Model object for a Transmission.
 * Created by skidson on 16-03-10.
 */
public class Transmission {

    private String Name;
    private String Type;
    private String DetailType;
    private String Gears;

    public String getDetailType() {
        return DetailType;
    }

    public void setDetailType(String detailType) {
        DetailType = detailType;
    }

    public String getGears() {
        return Gears;
    }

    public void setGears(String gears) {
        Gears = gears;
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
        return "Transmission{" +
                "DetailType='" + DetailType + '\'' +
                ", Name='" + Name + '\'' +
                ", Type='" + Type + '\'' +
                ", Gears='" + Gears + '\'' +
                '}';
    }
}
