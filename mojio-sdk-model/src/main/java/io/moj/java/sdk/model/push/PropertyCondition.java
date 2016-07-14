package io.moj.java.sdk.model.push;

import java.util.Locale;

/**
 * Model object for an observer condition on a property.
 * Created by skidson on 2016-04-28.
 */
public class PropertyCondition extends Condition {

    private static final String FORMAT = "%s %s %s";
    private static final String EQ = "eq";
    private static final String GT = "gt";
    private static final String GTE = "gte";
    private static final String LT = "lt";
    private static final String LTE = "lte";
    private static final String CONTAINS = "contains";

    private final String string;

    private PropertyCondition(String property, String operator, String value) {
        this.string = String.format(Locale.US, FORMAT, property, operator, value);
    }

    @Override
    public String compile() {
        return string;
    }

    public static class Builder {
        private String property;

        public Builder(String property) {
            this.property = property;
        }

        public Condition eq(String value) {
            return build(EQ, value);
        }

        public Condition eq(boolean value) {
            return build(EQ, String.valueOf(value));
        }

        public Condition eq(int value) {
            return build(EQ, String.valueOf(value));
        }

        public Condition eq(float value) {
            return build(EQ, String.valueOf(value));
        }

        public Condition eq(double value) {
            return build(EQ, String.valueOf(value));
        }

        public Condition gt(int value) {
            return build(GT, String.valueOf(value));
        }

        public Condition gt(float value) {
            return build(GT, String.valueOf(value));
        }

        public Condition gt(double value) {
            return build(GT, String.valueOf(value));
        }

        public Condition gte(int value) {
            return build(GTE, String.valueOf(value));
        }

        public Condition gte(float value) {
            return build(GTE, String.valueOf(value));
        }

        public Condition gte(double value) {
            return build(GTE, String.valueOf(value));
        }

        public Condition lt(int value) {
            return build(LT, String.valueOf(value));
        }

        public Condition lt(float value) {
            return build(LT, String.valueOf(value));
        }

        public Condition lt(double value) {
            return build(LT, String.valueOf(value));
        }

        public Condition lte(int value) {
            return build(LTE, String.valueOf(value));
        }

        public Condition lte(float value) {
            return build(LTE, String.valueOf(value));
        }

        public Condition lte(double value) {
            return build(LTE, String.valueOf(value));
        }

        public Condition contains(String value) {
            return build(CONTAINS, value);
        }

        public Condition contains(float value) {
            return build(CONTAINS, String.valueOf(value));
        }

        public Condition contains(double value) {
            return build(CONTAINS, String.valueOf(value));
        }

        public Condition contains(int value) {
            return build(CONTAINS, String.valueOf(value));
        }

        protected Condition build(String operator, String value) {
            return new PropertyCondition(property, operator, value);
        }

    }

}
