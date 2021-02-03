package io.moj.java.sdk.model.values;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Model object for a AccessModel.
 * Created by mhorie on 2016-01-13.
 */
public class AccessModel implements Serializable {

    public static final String GROUP_ID = "GroupId";
    public static final String PERMISSIONS = "Permissions";

    private String GroupId;
    private String[] Permissions;

    public String getGroupId() {
        return GroupId;
    }

    public void setGroupId(String groupId) {
        GroupId = groupId;
    }

    public String[] getPermissions() {
        return Permissions;
    }

    public void setPermissions(String[] permissions) {
        Permissions = permissions;
    }

    @Override
    public String toString() {
        return "AccessModel{" +
                "GroupId='" + GroupId + '\'' +
                ", Permissions=" + Arrays.toString(Permissions) +
                '}';
    }
}
