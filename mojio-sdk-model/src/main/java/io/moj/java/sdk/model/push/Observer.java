package io.moj.java.sdk.model.push;

import com.google.gson.annotations.SerializedName;
import io.moj.java.sdk.utils.TimeUtils;

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
    public static final String CONDITIONS = "Conditions";
    public static final String TYPE = "Type";
    public static final String TIMING = "Timing";
    public static final String FIELDS = "Fields";
    public static final String TRANSPORTS = "Transports";
    public static final String DEBOUNCE = "Debounce";
    public static final String THROTTLE = "Throttle";
    public static final String TIME_TO_LIVE = "TimeToLive";

    // local _id for storage in SQLite databases
    private Long _id;

    private String Key;
    private String CreatedOn;
    private String LastModified;
    private String ExpiryDate;
    private String Name;
    private String Subject;
    private String Conditions;
    private Type Type;
    private Timing Timing;
    private List<String> Fields;
    private List<Transport> Transports;
    private Integer Debounce;
    private String Throttle;
    private String TimeToLive;

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

    public Timing getTiming() {
        return Timing;
    }

    public void setTiming(Timing timing) {
        Timing = timing;
    }

    public Integer getDebounce() {
        return Debounce;
    }

    public void setDebounce(Integer debounce) {
        Debounce = debounce;
    }

    public Long getThrottle() {
        return TimeUtils.convertTimestampToMillis(Throttle);
    }

    public void setThrottle(Long throttle) {
        Throttle = TimeUtils.convertMillisToTimestamp(throttle);
    }

    public Long getTimeToLive() {
        return TimeUtils.convertTimestampToMillis(TimeToLive);
    }

    public void setTimeToLive(Long timeToLive) {
        TimeToLive = TimeUtils.convertMillisToTimestamp(timeToLive);
    }

    public List<Transport> getTransports() {
        return Transports;
    }

    public void setTransports(List<Transport> transports) {
        Transports = transports;
    }

    public String getConditions() {
        return Conditions;
    }

    public void setConditions(Condition condition) {
        this.Conditions = condition == null ? null : condition.compile();
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
                ", Conditions='" + Conditions + '\'' +
                ", Type=" + Type +
                ", Timing=" + Timing +
                ", Fields=" + Fields +
                ", Transports=" + Transports +
                ", Debounce=" + Debounce +
                ", Throttle='" + Throttle + '\'' +
                ", TimeToLive='" + TimeToLive + '\'' +
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

    public static class Builder {
        private String key;
        private String subject;
        private Observer.Type type;
        private Timing timing;
        private List<Transport> transports;
        private List<String> fields;
        private Condition condition;
        private Integer debounce;
        private Long throttle;
        private Long timeToLive;

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
            if (transport == null) {
                this.transports = null;
                return this;
            }

            if (this.transports == null) {
                this.transports = new ArrayList<>();
            } else {
                this.transports.clear();
            }
            this.transports.add(transport);
            return this;
        }

        /**
         * Limits the behavior of an Observer. An Observer can have up to 4 Conditions, one of each
         * type. If none of these are set the Observer will broadcast a message anytime the entity
         * changes in any way.
         * @param conditions
         * @return
         */
        public Builder conditions(Condition conditions) {
            this.condition = conditions;
            return this;
        }

        /**
         * Limits the behavior of an Observer. An Observer can have up to 4 Conditions, one of each
         * type. If none of these are set the Observer will broadcast a message anytime the entity
         * changes in any way.
         * @param conditions
         * @return
         */
        public Builder conditions(String conditions) {
            this.condition = new RawCondition(conditions);
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
         * Sets the timing to be used, based on the evaluation of the conditions, to determine if a notification should
         * be sent.
         * @param timing
         * @return
         */
        public Builder timing(Timing timing) {
            this.timing = timing;
            return this;
        }

        /**
         * Sets the number of consecutive data points, where the condition and timing is met, that are required before
         * a notification will be sent.
         * @param debounce
         * @return
         */
        public Builder debounce(Integer debounce) {
            this.debounce = debounce;
            return this;
        }

        /**
         * Sets the amount of time after one notification before another one should be fired.
         * @param days the number of days the condition must be maintained for before it can be broadcast. Added with
         *             the other time properties.
         * @param hours the number of hours the condition must be maintained for before it can be broadcast. Added with
         *              the other time properties.
         * @param minutes the number of minutes the condition must be maintained for before it can be broadcast. Added
         *                with the other time properties.
         * @param seconds the number of seconds the condition must be maintained for before it can be broadcast. Added
         *                with the other time properties.
         * @return
         */
        public Builder throttle(int days, int hours, int minutes, int seconds) {
            this.throttle = TimeUtils.convertToMillis(days, hours, minutes, seconds);
            return this;
        }

        /**
         * Sets the amount of time after one notification before another one should be fired.
         * @param millis the number of milliseconds the condition must be maintained for before it can be broadcast.
         * @return
         */
        public Builder throttle(Long millis) {
            this.throttle = millis;
            return this;
        }

        /**
         * Sets how long between when a condition occurred and when it was processed before a notification will be
         * dropped. This should be used to ensure only notifications that make sense at the specific time they occurred
         * don't get triggered if the message was delayed (e.g. the vehicle was in an area of poor connectivity).
         * @param days the number of days. Added with the other time properties.
         * @param hours the number of hours. Added with the other time properties.
         * @param minutes the number of minutes. Added with the other time properties.
         * @param seconds the number of seconds. Added with the other time properties.
         * @return
         */
        public Builder timeToLive(int days, int hours, int minutes, int seconds) {
            this.timeToLive = TimeUtils.convertToMillis(days, hours, minutes, seconds);
            return this;
        }

        /**
         * Sets how long between when a condition occurred and when it was processed before a notification will be
         * dropped. This should be used to ensure only notifications that make sense at the specific time they occurred
         * don't get triggered if the message was delayed (e.g. the vehicle was in an area of poor connectivity).
         * @param millis the number of milliseconds
         * @return
         */
        public Builder timeToLive(Long millis) {
            this.timeToLive = millis;
            return this;
        }

        /**
         * Constructs the {@link Observer}.
         * @return
         */
        public Observer build() {
            if (type == null)
                throw new IllegalStateException("Type must not be null");

            Observer observer = new Observer(key);
            observer.setType(type);
            observer.setSubject(subject);
            observer.setTransports(transports == null ? null : new ArrayList<>(transports));
            observer.setFields(fields == null ? null : new ArrayList<>(fields));
            observer.setTiming(timing);
            observer.setDebounce(debounce);
            observer.setThrottle(throttle);
            observer.setTimeToLive(timeToLive);
            observer.setConditions(condition);
            return observer;
        }
    }

}
