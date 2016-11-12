package io.moj.java.sdk.model.stream;

/**
 * Activity object image
 * Created by Mauro on 2016-11-12.
 */
public class Image {
    public static final String NAME = "Name";

    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Image{" +
                "Name='" + Name + '\'' +
                '}';
    }
}
