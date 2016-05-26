package io.moj.java.sdk.model.push;

import io.moj.java.sdk.model.values.DeviceMeasurement;

/**
 * Model object for an observer condition. Conditions are used to limit the circumstances under which an
 * {@link io.moj.java.sdk.model.push.Observer} will fire.
 * Created by skidson on 2016-05-23.
 */
public abstract class Condition {

    private static final String VALUE = "." + DeviceMeasurement.VALUE;

    /**
     * Returns a condition that requires both this and the provided condition to be true.
     * @param condition the other condition
     * @return
     */
    public Condition and(Condition condition) {
        return new CompositeCondition(new BracedCondition(this), new BracedCondition(condition), CompositeCondition.Operator.AND);
    }

    /**
     * Returns a condition that requires either this or the provided condition evaluate to true.
     * @param condition the other condition
     * @return
     */
    public Condition or(Condition condition) {
        return new CompositeCondition(new BracedCondition(this), new BracedCondition(condition), CompositeCondition.Operator.OR);
    }

    /**
     * Returns a builder to specify the condition for the provided property that must be true in addition to this
     * condition. Equivalent to calling {@code or(Condition.when(property)...}
     * @param property the property for which the other condition should be built with
     * @return
     */
    public CompositeCondition.Builder andValue(String property) {
        return new CompositeCondition.Builder(this, CompositeCondition.Operator.AND, property + VALUE);
    }

    /**
     * Returns a builder to specify the condition for the provided property to be OR'd with this one.
     * @param property
     * @return
     */
    public CompositeCondition.Builder orValue(String property) {
        return new CompositeCondition.Builder(this, CompositeCondition.Operator.OR, property + VALUE);
    }

    public CompositeCondition.Builder and(String property) {
        return new CompositeCondition.Builder(this, CompositeCondition.Operator.AND, property);
    }

    public CompositeCondition.Builder or(String property) {
        return new CompositeCondition.Builder(this, CompositeCondition.Operator.OR, property);
    }

    public static PropertyCondition.Builder when(String property) {
        return new PropertyCondition.Builder(property);
    }

    public static PropertyCondition.Builder whenValue(String property) {
        return new PropertyCondition.Builder(property + VALUE);
    }

    public abstract String compile();

    @Override
    public String toString() {
        return compile();
    }
}
