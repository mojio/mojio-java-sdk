package io.moj.java.sdk.model.push;

/**
 * Model object for an observer condition that wraps a raw condition string from the user. This approach does not
 * guarantee logical correctness but complex queries may be easiest to store and represent with just a string.
 * Created by skidson on 2016-05-24.
 */
public class RawCondition extends Condition {

    private final String condition;

    public RawCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String compile() {
        return condition;
    }

}
