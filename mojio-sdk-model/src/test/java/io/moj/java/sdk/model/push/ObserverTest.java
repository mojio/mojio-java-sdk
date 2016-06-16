package io.moj.java.sdk.model.push;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import io.moj.java.sdk.model.Vehicle;
import io.moj.java.sdk.test.TestUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.Assert.*;

public class ObserverTest {

    @Test
    public void testSetTransports() {
        Observer o = new Observer("key");
        Transport transport1 = Transport.forAndroid("gcmRegId");
        Transport transport2 = Transport.forSignalR("clientId", "hubName");

        o.setTransports(Lists.newArrayList(transport1, transport2));
        assertNotNull(o.getTransports());
        assertEquals(2, o.getTransports().size());
        assertEquals(transport1, o.getTransports().get(0));
        assertEquals(transport2, o.getTransports().get(1));
    }

    @Test
    public void testTypeFromKey() {
        for (Observer.Type type : Observer.Type.values()) {
            Observer.Type typeFromKey = Observer.Type.fromKey(type.getKey());
            assertEquals(type, typeFromKey);
        }
        assertNull(Observer.Type.fromKey("NotARealKey"));
    }

    @Test
    public void testToString() throws IllegalAccessException {
        Observer o = new Gson().fromJson(TestJson.OBSERVER, Observer.class);
        TestUtils.assertToStringContainsAllFields(o);
    }

    @Test
    public void testGettersAndSetters() throws IllegalAccessException {
        Observer o = new Gson().fromJson(TestJson.OBSERVER, Observer.class);

        // TODO on some JVM's Method.invoke() is not working for setTransport()
        List<Method> methods = TestUtils.getAllMethods(o);
        Iterator<Method> methodIterator = methods.iterator();
        while (methodIterator.hasNext()) {
            Method method = methodIterator.next();

            if (method.getName().endsWith(Observer.CONDITIONS)) {
                methodIterator.remove();
            }
        }

        List<Field> fields = TestUtils.getAllFields(o);
        Iterator<Field> fieldIterator = fields.iterator();
        while (fieldIterator.hasNext()) {
            Field field = fieldIterator.next();

            if (field.getName().endsWith(Observer.CONDITIONS)) {
                fieldIterator.remove();
            }
        }
        TestUtils.assertAccess(o, methods, fields, true);

        Condition conditions = Condition.whenValue(Vehicle.SPEED).gt(50f);
        o.setConditions(conditions);
        assertThat(o.getConditions()).isEqualTo(conditions.compile());

        o.setConditions(null);
        assertThat(o.getConditions()).isNull();
    }

    @Test
    public void testSerialization() {
        String key = "key";
        Observer.Type type = Observer.Type.MOJIO;
        Transport transport = Transport.forAndroid("gcmRegId");
        String[] fields = new String[] { "LastContactTime", "LastContactTime" };

        Observer o = new Observer.Builder(key)
                .type(type)
                .transport(transport)
                .conditions(Condition.whenValue(Vehicle.SPEED).gt(50f))
                .field(fields[0])
                .field(fields[1])
                .build();

        String json = new Gson().toJson(o, Observer.class);
        assertEquals(TestJson.OBSERVER, json);
    }

    @Test
    public void testRequestSerialization_minimal() {
        String key = "key";
        Observer.Type type = Observer.Type.MOJIO;

        Observer o = new Observer.Builder(key).type(type).build();
        assertThat(o).isNotNull();

        String json = new Gson().toJson(o, Observer.class);
        assertThat(json).isEqualTo("{\"Key\":\"key\",\"Type\":\"mojio\"}");
    }

    @Test
    public void testBuild_unique() {
        String key = "key";
        Observer.Type type = Observer.Type.MOJIO;
        Transport transport = Transport.forAndroid("gcmRegId");
        String[] fields = new String[] { "LastContactTime", "LastContactTime" };

        Observer.Builder builder = new Observer.Builder(key)
                .type(type)
                .transport(transport)
                .conditions(Condition.whenValue(Vehicle.SPEED).gt(50f))
                .field(fields[0])
                .field(fields[1]);

        Observer a = builder.build();
        Observer b = builder.build();
        assertThat(a).isNotSameAs(b);
    }

    @Test(expected = IllegalStateException.class)
    public void testBuild_empty() {
        String key = "key";
        new Observer.Builder(key).build();
    }

}