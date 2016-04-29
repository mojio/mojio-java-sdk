package io.moj.java.sdk.model.push;

/**
 * Model object for an observer condition. Conditions are used to limit the circumstances under which an
 * {@link io.moj.java.sdk.model.push.Observer} will fire.
 * Created by skidson on 2016-04-28.
 */
public class Condition {

    private StringBuilder string;

    public Condition.Builder or() {
        string.insert(0, "(").append(")")
        return null;
    }

    public Condition.Builder and() {
        // TODO
        return null;
    }

    public Condition or(Condition condition) {
        // TODO
        return null;
    }

    public Condition and(Condition condition) {
        // TODO
        return null;
    }

    @Override
    public String toString() {
        return string.toString();
    }

    public static Builder when(String property) {

    }

    public static class Builder {
        private String property;

        public Builder(String property) {
            this.property = property;
        }

        public Condition eq(String value) {
            // TODO
            return null;
        }

        public Condition eq(int value) {
            // TODO
            return null;
        }

        public Condition eq(double value) {
            // TODO
            return null;
        }

        public Condition gt(double) {
            // TODO
            return null;
        }

        public Condition gte(Condition condition) {
            // TODO
            return null;
        }

        public Condition lt(Condition condition) {
            // TODO
            return null;
        }

        public Condition lte(Condition condition) {
            // TODO
            return null;
        }

    }

}
