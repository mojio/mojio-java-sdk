package io.moj.java.sdk.model.stream;

/**
 * Icon type enumeration.
 * Created by Mauro on 2016-11-12.
 */
public enum IconType {

    WARNING("warning"),
    ALERT("alert");

    private String key;

    IconType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static IconType fromKey(String type) {
        if (type == null)
            return null;
        for (IconType iconType : values()) {
            if (iconType.getKey().equals(type)) {
                return iconType;
            }
        }
        return null;
    }
}