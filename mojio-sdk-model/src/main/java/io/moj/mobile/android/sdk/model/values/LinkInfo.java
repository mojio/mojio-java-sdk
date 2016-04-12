package io.moj.mobile.android.sdk.model.values;

/**
 * Model object for Links.
 * Created by mhorie on 2016-01-13.
 */
public class LinkInfo {

    private String Self;
    private String First;
    private String Next;
    private String Vehicle;
    private String Mojio;
    private String Permissions;
    private String Permission;
    private String States;
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
                "First='" + First + '\'' +
                ", Self='" + Self + '\'' +
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
