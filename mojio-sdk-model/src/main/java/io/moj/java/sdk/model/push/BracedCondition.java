package io.moj.java.sdk.model.push;

import java.util.Locale;

/**
 * A wrapper for a {@link Condition} whose contents should be enclosed in braces.
 * Created by skidson on 2016-05-23.
 */
public class BracedCondition extends Condition {

    private static final String FORMAT = "(%s)";

    private final Condition condition;

    public BracedCondition(Condition condition) {
        this.condition = condition;
    }

    @Override
    public String compile() {
        return String.format(Locale.US, FORMAT, condition.compile());
    }

}
