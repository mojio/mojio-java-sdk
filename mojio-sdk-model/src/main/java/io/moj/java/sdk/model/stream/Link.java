package io.moj.java.sdk.model.stream;

/**
 * Link object in activity streams.
 * Created by Mauro on 2016-06-23.
 */
public class Link {
    public static final String ID = "Id";
    public static final String HREF = "HRef";
    public static final String TYPE = "Type";

    private String Id;
    private String HRef;
    private String Type;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getHRef() {
        return HRef;
    }

    public void setHRef(String HRef) {
        this.HRef = HRef;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Link{" +
                "Id='" + Id + '\'' +
                ", HRef='" + HRef + '\'' +
                ", Type='" + Type + '\'' +
                '}';
    }
}
