package io.moj.mobile.android.sdk.model.values;

import java.util.Arrays;

/**
 * Model object for a Permission.
 * Created by mhorie on 2016-01-13.
 */
public class Permission {

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
        return "Permission{" +
                "GroupId='" + GroupId + '\'' +
                ", Permissions=" + Arrays.toString(Permissions) +
                '}';
    }
}
