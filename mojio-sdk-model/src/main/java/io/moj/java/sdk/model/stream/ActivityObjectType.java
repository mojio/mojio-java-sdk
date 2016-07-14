package io.moj.java.sdk.model.stream;

/**
 * Enumeration for the activity type.
 * Created by Mauro on 2016-06-24.
 */
public enum ActivityObjectType {
    LEAVE("Leave"),
    ARRIVE("Arrive"),
    UNDO("Undo"),
    OFFER("Offer"),
    ACCEPT("Accept"),
    ADD("Add"),
    BLOCK("Block"),
    CREATE("Create"),
    DELETE("Delete"),
    FOLLOW("Follow"),
    IGNORE("Ignore"),
    INVITE("Invite"),
    REJECT("Reject"),
    QUESTION("Question"),
    ANNOUNCE("Announce"),
    TRAVEL("Travel "),
    LISTEN("Listen"),
    READ("Read"),
    VIEW("View"),
    JOIN("Join"),
    REMOVE("Remove"),
    TENTATIVE_ACCEPT("TentativeAccept"),
    TENTATIVE_REJECT("TentativeReject"),
    DISLIKE("Dislike"),
    FLAG("Flag"),
    LIKE("Like"),
    MOVE("Move"),
    UPDATE("Update");

    private String key;

    ActivityObjectType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static ActivityObjectType fromKey(String key) {
        for (ActivityObjectType type : values()) {
            if (type.getKey().equals(key)) {
                return type;
            }
        }
        return null;
    }
}
