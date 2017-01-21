package io.moj.java.sdk.model;

import io.moj.java.sdk.model.enums.EnumTest;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by skidson on 2016-07-18.
 */
public class TransactionStateTest extends EnumTest<Transaction.State> {

    private static final Map<String, Transaction.State> MAPPING;
    static {
        Map<String, Transaction.State> mapping = new HashMap<>();
        mapping.put("Pending", Transaction.State.PENDING);
        mapping.put("Success", Transaction.State.SUCCESS);
        mapping.put("Failure", Transaction.State.FAILURE);
        MAPPING = Collections.unmodifiableMap(mapping);
    }

    @Override
    public Map<String, Transaction.State> getMapping() {
        return MAPPING;
    }

    @Test
    @Override
    public void testSerialization() {
        super.testSerialization();
    }

    @Test
    @Override
    public void testDeserialization() {
        super.testDeserialization();
    }

    @Test
    @Override
    public void testFromKey() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testFromKey();
    }

    @Test
    @Override
    public void testFromKey_invalid() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testFromKey_invalid();
    }

    @Test
    @Override
    public void testGetKey() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testGetKey();
    }

    @Test
    @Override
    public void testValues() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        super.testValues();
    }
}
