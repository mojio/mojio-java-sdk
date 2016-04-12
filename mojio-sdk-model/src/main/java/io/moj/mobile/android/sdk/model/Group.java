package io.moj.mobile.android.sdk.model;

import java.util.Arrays;

/**
 * Model object for a Group.
 * Created by mhorie on 2016-01-12.
 */
public class Group extends AbstractMojioObject {

    public static final String NAME = "Name";
    public static final String DESCRIPTION = "Description";
    public static final String USERS = "Users";
    public static final String TAGS = "Tags";

    private String Name;
    private String Description;
    private String[] Users;
    private String[] Tags;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String[] getUsers() {
        return Users;
    }

    public void setUsers(String[] users) {
        Users = users;
    }

    public String[] getTags() {
        return Tags;
    }

    public void setTags(String[] tags) {
        Tags = tags;
    }

    @Override
    public String toString() {
        return "Group{" +
                "Description='" + Description + '\'' +
                ", Name='" + Name + '\'' +
                ", Users=" + Arrays.toString(Users) +
                ", Tags=" + Arrays.toString(Tags) +
                "} " + super.toString();
    }
}
