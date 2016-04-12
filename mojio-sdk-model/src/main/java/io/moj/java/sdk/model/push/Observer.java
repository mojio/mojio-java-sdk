package io.moj.java.sdk.model.push;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Model object for an observer.
 * Created by skidson on 16-02-16.
 */
public class Observer {

    public static final String LOCAL_ID = "_id";
    public static final String KEY = "Key";
    public static final String CREATED_ON = "CreatedOn";
    public static final String LAST_MODIFIED = "LastModified";
    public static final String EXPIRY_DATE = "ExpiryDate";
    public static final String NAME = "Name";
    public static final String SUBJECT = "Subject";
    public static final String TYPE = "Type";
    public static final String FIELDS = "Fields";
    public static final String TRANSPORTS = "Transports";
    public static final String CONDITIONS = "Conditions";

    // local _id for storage in SQLite databases
    private Long _id;

    private String Key;
    private String CreatedOn;
    private String LastModified;
    private String ExpiryDate;
    private String Name;
    private String Subject;
    private Type Type;
    private List<String> Fields;
    private List<Transport> Transports;
    private List<Condition> Conditions;

    public Observer() {}

    public Observer(String key) {
        this.Key = key;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public String getExpiryDate() {
        return ExpiryDate;
    }

    public List<String> getFields() {
        return Fields;
    }

    public String getKey() {
        return Key;
    }

    public String getLastModified() {
        return LastModified;
    }

    public String getName() {
        return Name;
    }

    public String getSubject() {
        return Subject;
    }


    public void setCreatedOn(String createdOn) {
        CreatedOn = createdOn;
    }

    public void setExpiryDate(String expiryDate) {
        ExpiryDate = expiryDate;
    }

    public void setKey(String key) {
        Key = key;
    }

    public void setLastModified(String lastModified) {
        LastModified = lastModified;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public void setFields(List<String> fields) {
        Fields = fields;
    }

    public Long getLocalId() {
        return _id;
    }

    public void setLocalId(Long id) {
        this._id = id;
    }

    public Transport getTransport() {
        if (Transports != null && !Transports.isEmpty())
            return Transports.get(0);
        return null;
    }

    public List<Transport> getTransports() {
        return Transports;
    }

    public void setTransport(Transport transport) {
        if (transport == null) {
            this.Transports = null;
            return;
        }

        if (this.Transports == null) {
            this.Transports = new ArrayList<>();
        } else {
            this.Transports.clear();
        }
        this.Transports.add(transport);
    }

    public void setTransports(List<Transport> transports) {
        Transports = transports;
    }

    public List<Condition> getConditions() {
        return Conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.Conditions = conditions;
    }

    public Observer.Type getType() {
        return Type;
    }

    public void setType(Observer.Type type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Observer{" +
                "_id=" + _id +
                ", Key='" + Key + '\'' +
                ", CreatedOn='" + CreatedOn + '\'' +
                ", LastModified='" + LastModified + '\'' +
                ", ExpiryDate='" + ExpiryDate + '\'' +
                ", Name='" + Name + '\'' +
                ", Subject='" + Subject + '\'' +
                ", Type=" + Type +
                ", Fields=" + Fields +
                ", Transports=" + Transports +
                ", Conditions=" + Conditions +
                '}';
    }

    /**
     * Enumeration of observer types. These are the types of entities an observer can watch for
     * changes on.
     */
    public enum Type {
        @SerializedName("mojio")
        MOJIO("mojio"),

        @SerializedName("vehicle")
        VEHICLE("vehicle"),

        @SerializedName("user")
        USER("user");

        private final String key;

        Type(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public static Type fromKey(String key) {
            for (Type type : values()) {
                if (type.getKey().equals(key))
                    return type;
            }
            return null;
        }
    }

}
