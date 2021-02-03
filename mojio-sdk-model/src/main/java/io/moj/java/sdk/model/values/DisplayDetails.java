package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DisplayDetails implements Serializable {

    public static final String COLOR = "Color";
    public static final String ICON = "Icon";
    public static final String SHOW_ON_MAP = "ShowOnMap";
    public static final String PROFILE_IMAGE = "ProfileImage";

    @SerializedName(value = "Color", alternate = "color")
    private String Color;
    @SerializedName(value = "Icon", alternate = "icon")
    private String Icon;
    @SerializedName(value = "ShowOnMap", alternate = "showOnMap")
    private Boolean ShowOnMap;
    @SerializedName(value = "ProfileImage", alternate = "profileImage")
    private String ProfileImage;

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getIcon() {
        return Icon;
    }

    public void setIcon(String icon) {
        Icon = icon;
    }

    public Boolean getShowOnMap() {
        return ShowOnMap;
    }

    public void setShowOnMap(Boolean showOnMap) {
        ShowOnMap = showOnMap;
    }

    public String getProfileImage() {
        return ProfileImage;
    }

    public void setProfileImage(String profileImage) {
        ProfileImage = profileImage;
    }

    @Override
    public String toString() {
        return "DisplayDetails{" +
                "Color='" + Color + '\'' +
                ", Icon='" + Icon + '\'' +
                ", ShowOnMap=" + ShowOnMap +
                ", ProfileImage='" + ProfileImage + '\'' +
                '}';
    }
}
