package io.moj.java.sdk.model.push;

import java.util.Locale;

/**
 * Model object for an observer condition that is composed of two other conditions and an operator.
 * Created by skidson on 2016-05-23.
 */
public class CompositeCondition extends Condition {

    private static final String FORMAT = "%s %s %s";

    private final Condition left;
    private final Condition right;
    private final Operator operator;

    public CompositeCondition(Condition left, Condition right, Operator operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public String compile() {
        return String.format(Locale.US, FORMAT, left.compile(), operator.getValue(), right.compile());
    }

    public enum Operator {
        AND("and"),
        OR("or");

        private final String value;

        Operator(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * Builder for a {@link io.moj.java.sdk.model.push.CompositeCondition} whose right-hand condition has yet to be
     * built.
     */
    public static class Builder extends PropertyCondition.Builder {
        private final Condition left;
        private final Operator operator;

        public Builder(Condition left, Operator operator, String property) {
            super(property);
            this.left = left;
            this.operator = operator;
        }

        @Override
        protected Condition build(String operator, String value) {
            return new CompositeCondition(left, super.build(operator, value), this.operator);
        }
    }

}
