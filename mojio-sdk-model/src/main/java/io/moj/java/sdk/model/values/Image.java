package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

/**
 * Model object for an Image.
 * Created by mhorie on 2016-01-12.
 */
public class Image {

    public static final String SRC = "Src";
    public static final String NORMAL = "Normal";
    public static final String THUMBNAIL = "Thumbnail";

    @SerializedName(value = "Src", alternate = "src")
    private String Src;
    @SerializedName(value = "Normal", alternate = "normal")
    private String Normal;
    @SerializedName(value = "Thumbnail", alternate = "thumbnail")
    private String Thumbnail;

    public String getNormal() {
        return Normal;
    }

    public void setNormal(String normal) {
        Normal = normal;
    }

    public String getSrc() {
        return Src;
    }

    public void setSrc(String src) {
        Src = src;
    }

    public String getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        Thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Image{" +
                "Normal='" + Normal + '\'' +
                ", Src='" + Src + '\'' +
                ", Thumbnail='" + Thumbnail + '\'' +
                '}';
    }
}
