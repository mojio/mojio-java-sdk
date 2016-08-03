package io.moj.java.sdk.model.values;

/**
 * Model object for a Storage Key/Value
 * Created by skidson on 2016-08-03.
 */
public class StorageEntry {

    public static final String KEY = "Key";
    public static final String VALUE = "Value";

    private String Key;
    private String Value;

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    @Override
    public String toString() {
        return "StorageEntry{" +
                "Key='" + Key + '\'' +
                ", Value='" + Value + '\'' +
                '}';
    }
}
