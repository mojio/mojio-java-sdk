package io.moj.java.sdk.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by skidson on 2016-07-18.
 */
public class Transaction extends AbstractMojioObject {

    private State State;

    public Transaction.State getState() {
        return State;
    }

    public void setState(Transaction.State state) {
        State = state;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "State=" + State +
                "} " + super.toString();
    }

    public enum State {
        @SerializedName("Pending")
        PENDING("Pending"),

        @SerializedName("Success")
        SUCCESS("Success"),

        @SerializedName("Failure")
        FAILURE("Failure");

        private final String key;

        State(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public static State fromKey(String key) {
            for (State type : values()) {
                if (type.getKey().equals(key))
                    return type;
            }
            return null;
        }
    }

}
