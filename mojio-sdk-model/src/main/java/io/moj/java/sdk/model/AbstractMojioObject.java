package io.moj.java.sdk.model;

import io.moj.java.sdk.model.values.LinkInfo;
import io.moj.java.sdk.utils.TimeUtils;

/**
 * Base model for objects returned by the server.
 * Note: field names are the same as used by the backend so that if reflection is used for
 * serialization or persistence to database, then the column name will be the same.
 * Created by mhorie on 2016-01-13.
 */
public abstract class AbstractMojioObject implements MojioObject {

    public static final String LOCAL_ID = "_id";
    public static final String CREATED_ON = "CreatedOn";
    public static final String LAST_MODIFIED = "LastModified";
    public static final String LINKS = "Links";

    private String Id;
    private Long _id;
    private String CreatedOn;
    private String LastModified;
    private LinkInfo Links;

    public Long getCreatedOn() {
        return TimeUtils.convertTimestampToMillis(CreatedOn);
    }

    public void setCreatedOn(Long createdOn) {
        CreatedOn = TimeUtils.convertMillisToTimestamp(createdOn);
    }

    @Override
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Long getLastModified() {
        return TimeUtils.convertTimestampToMillis(LastModified);
    }

    public void setLastModified(Long lastModified) {
        LastModified = TimeUtils.convertMillisToTimestamp(lastModified);
    }

    public Long getLocalId() {
        return _id;
    }

    public void setLocalId(Long id) {
        this._id = id;
    }

    public LinkInfo getLinks() {
        return Links;
    }

    public void setLinks(LinkInfo links) {
        Links = links;
    }

    @Override
    public String toString() {
        return "AbstractMojioObject{" +
                "_id=" + _id +
                ", Id='" + Id + '\'' +
                ", CreatedOn='" + CreatedOn + '\'' +
                ", LastModified='" + LastModified + '\'' +
                ", Links=" + Links +
                '}';
    }
}
