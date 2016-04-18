package io.moj.java.sdk.model.push;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

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

    public static class Request {
        private String Key;
        private String CreatedOn;
        private String LastModified;
        private String ExpiryDate;
        private String Name;
        private String Subject;
        private List<String> Fields;
        private String PropertyChanged;
        private Condition Threshold;
        private Condition Debounce;
        private Condition Throttle;
        private Transport Transport;
        private Observer.Type Type;

        public Request() {}

        private Request(String key, Observer.Type type, String subject,
                        Transport transport, String propertyChanged,
                        Condition threshold, Condition debounce, Condition throttle,
                        List<String> fields) {
            this.Key = key;
            this.Subject = subject;
            this.Type = type;
            this.Transport = transport;
            this.PropertyChanged = propertyChanged;
            this.Threshold = threshold;
            this.Debounce = debounce;
            this.Throttle = throttle;
            this.Fields = fields;
        }
    }

    public static class Builder {
        private String key;
        private String subject;
        private Observer.Type type;
        private Transport transport;
        private String propertyChanged;
        private Condition threshold;
        private Condition debounce;
        private Condition throttle;
        private List<String> fields;

        /**
         * Constructs an Observer builder.
         * @param key uniquely identifies your observer; it must be unique for the user,
         *            application and entity. It cannot be edited.
         */
        public Builder(String key) {
            this.key = key;
        }

        /**
         * The Id of the entity that is being observed. If an entity Id is not passed in when
         * creating an observer it will broadcast changes for all entities of that type that the
         * user has read permissions for. If an Id is passed in it becomes the Subject on the
         * observer. This is automatically set on creation and cannot be edited.
         * @param subject
         * @return
         */
        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        /**
         * The Type of entity that is being observed. Either {@link io.moj.java.sdk.model.push.Observer.Type#MOJIO},
         * {@link io.moj.java.sdk.model.push.Observer.Type#MOJIO}, or
         * {@link io.moj.java.sdk.model.push.Observer.Type#MOJIO}. This is automatically set on creation and cannot be
         * edited.
         * @param type
         * @return
         */
        public Builder type(Observer.Type type) {
            this.type = type;
            return this;
        }

        /**
         * How the observer should contact your application. Each observer should only have one
         * transport. If defaults have been set for a specific transport type they will
         * automatically copied over to the transport.
         * @param transport
         * @return
         */
        public Builder transport(Transport transport) {
            this.transport = transport;
            return this;
        }

        /**
         * Limits the behavior of an Observer. An Observer can have up to 4 Conditions, one of each
         * type. If none of these are set the Observer will broadcast a message anytime the entity
         * changes in any way.
         * @param condition
         * @return
         */
        public Builder condition(Condition condition) {
            switch (condition.getType()) {
                case PROPERTY_CHANGED:
                    this.propertyChanged = condition.getProperty();
                    break;
                case THRESHOLD:
                    this.threshold = condition;
                    break;
                case DEBOUNCE:
                    this.debounce = condition;
                    break;
                case THROTTLE:
                    this.throttle = condition;
                    break;
            }
            return this;
        }

        /**
         * Specifies what fields of the entity will be broadcast when a change occurs. When creating
         * or updating an Observer passing in an empty array or null will default to all fields the
         * user has permission for.
         * @param field
         * @return
         */
        public Builder field(String field) {
            if (fields == null)
                fields = new ArrayList<>();
            fields.add(field);
            return this;
        }

        /**
         * Constructs the {@link Observer}.
         * @return
         */
        public Request build() {
            if (type == null)
                throw new IllegalStateException("Type must not be null");
            return new Request(key, type, subject, transport, propertyChanged,
                    threshold, debounce, throttle, fields == null ? null : new ArrayList<>(fields));
        }
    }

}
