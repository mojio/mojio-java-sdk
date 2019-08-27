package io.moj.java.sdk.model.values;

import com.google.gson.annotations.SerializedName;

/**
 * Model object for Links.
 * Created by mhorie on 2016-01-13.
 */
public class LinkInfo {

    @SerializedName(value = "Self", alternate = "self")
    private String Self;
    @SerializedName(value = "First", alternate = "first")
    private String First;
    @SerializedName(value = "Next", alternate = "next")
    private String Next;
    @SerializedName(value = "Vehicle", alternate = "vehicle")
    private String Vehicle;
    @SerializedName(value = "Mojio", alternate = "mojio")
    private String Mojio;
    @SerializedName(value = "Permissions", alternate = "permissions")
    private String Permissions;
    @SerializedName(value = "Permission", alternate = "permission")
    private String Permission;
    @SerializedName(value = "States", alternate = "states")
    private String States;
    @SerializedName(value = "Locations", alternate = "locations")
    private String Locations;

    public String getFirst() {
        return First;
    }

    public void setFirst(String first) {
        First = first;
    }

    public String getLocations() {
        return Locations;
    }

    public void setLocations(String locations) {
        Locations = locations;
    }

    public String getMojio() {
        return Mojio;
    }

    public void setMojio(String mojio) {
        Mojio = mojio;
    }

    public String getNext() {
        return Next;
    }

    public void setNext(String next) {
        Next = next;
    }

    public String getPermission() {
        return Permission;
    }

    public void setPermission(String permission) {
        Permission = permission;
    }

    public String getPermissions() {
        return Permissions;
    }

    public void setPermissions(String permissions) {
        Permissions = permissions;
    }

    public String getSelf() {
        return Self;
    }

    public void setSelf(String self) {
        Self = self;
    }

    public String getStates() {
        return States;
    }

    public void setStates(String states) {
        States = states;
    }

    public String getVehicle() {
        return Vehicle;
    }

    public void setVehicle(String vehicle) {
        Vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "LinkInfo{" +
                "Self='" + Self + '\'' +
                ", First='" + First + '\'' +
                ", Next='" + Next + '\'' +
                ", Vehicle='" + Vehicle + '\'' +
                ", Mojio='" + Mojio + '\'' +
                ", Permissions='" + Permissions + '\'' +
                ", Permission='" + Permission + '\'' +
                ", States='" + States + '\'' +
                ", Locations='" + Locations + '\'' +
                '}';
    }
}
