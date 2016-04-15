package io.moj.java.sdk.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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

    public static class Builder {
        private String name;
        private String description;
        private List<String> userIds;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder user(String userId) {
            if (userIds == null) {
                userIds = new LinkedList<>();
            }
            userIds.add(description);
            return this;
        }

        public Builder users(Collection<String> userIds) {
            this.userIds = null;
            if (userIds != null) {
                for (String userId : userIds) {
                    user(userId);
                }
            }
            return this;
        }

        public Request build() {
            return new Request(name, description, userIds);
        }
    }

    public static class Request {
        private String Name;
        private String Description;
        private List<String> Users;

        public Request(String name, String description, List<String> users) {
            Name = name;
            Description = description;
            Users = users;
        }
    }
}
