package io.moj.java.sdk.model.push;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import io.moj.mobile.android.sdk.test.TestUtils;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.Assert.*;

public class ObserverTest {

    @Test
    public void testSetTransport() {
        Observer o = new Observer("key");
        Transport transport1 = Transport.forAndroid("gcmRegId");
        Transport transport2 = Transport.forSignalR("clientId", "hubName");

        o.setTransport(transport1);
        assertNotNull(o.getTransports());
        assertEquals(1, o.getTransports().size());
        assertEquals(transport1, o.getTransports().get(0));
        assertEquals(transport1, o.getTransport());

        o.setTransport(transport2);
        assertNotNull(o.getTransports());
        assertEquals(1, o.getTransports().size());
        assertEquals(transport2, o.getTransports().get(0));
        assertEquals(transport2, o.getTransport());
    }

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
        assertEquals(transport1, o.getTransport());

        o.setTransport(null);
        assertNull(o.getTransport());
        assertNull(o.getTransports());
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
    public void testSerialization() {
        Gson gson = new Gson();
        Condition condition1 = Condition.debounce(1, 2, 3, 4, 5);
        Condition condition2 = Condition.delay(6, 7, 8, 9);
        Condition condition3 = Condition.onPropertyChanged("Property");
        Condition condition4 = Condition.throttle(0, 3, 6, 9);

        List<Condition> conditions = Lists.newArrayList(
                condition1,
                condition2,
                condition3,
                condition4
        );

        Observer o = new Observer();
        o.setTransport(gson.fromJson(TestJson.TRANSPORT, Transport.class));
        o.setType(Observer.Type.VEHICLE);
        o.setFields(Lists.newArrayList("field1", "field2"));
        o.setConditions(conditions);
        o.setCreatedOn("createdOn");
        o.setExpiryDate("expiryDate");
        o.setKey("key");
        o.setLastModified("lastModified");
        o.setSubject("subject");

        String json = gson.toJson(o);
        assertEquals(TestJson.OBSERVER, json);
    }

    @Test
    public void testDeserialization() {
        Gson gson = new Gson();
        Observer o = gson.fromJson(TestJson.OBSERVER, Observer.class);
        Transport t = gson.fromJson(TestJson.TRANSPORT, Transport.class);
        Condition condition1 = Condition.debounce(1, 2, 3, 4, 5);
        Condition condition2 = Condition.delay(6, 7, 8, 9);
        Condition condition3 = Condition.onPropertyChanged("Property");
        Condition condition4 = Condition.throttle(0, 3, 6, 9);

        List<Condition> conditions = Lists.newArrayList(
                condition1,
                condition2,
                condition3,
                condition4
        );

        assertNotNull(o);
        assertEquals(t, o.getTransport());
        assertNotNull(o.getTransports());
        assertEquals(1, o.getTransports().size());
        assertEquals(t, o.getTransports().get(0));
        assertEquals(Observer.Type.VEHICLE, o.getType());
        assertEquals(Lists.newArrayList("field1", "field2"), o.getFields());
        assertEquals(conditions, o.getConditions());
        assertEquals("createdOn", o.getCreatedOn());
        assertEquals("expiryDate", o.getExpiryDate());
        assertEquals("key", o.getKey());
        assertEquals("lastModified", o.getLastModified());
        assertEquals("subject", o.getSubject());
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
        Iterator<Method> i = methods.iterator();
        while (i.hasNext()) {
            Method method = i.next();
            if (method.getName().endsWith("Transport"))
                i.remove();
        }
        TestUtils.assertAccess(o, methods);

        o.setTransport(null);
        assertNull(o.getTransport());

        o.setTransports(new ArrayList<Transport>());
        assertNull(o.getTransport());
    }

    @Test
    public void testRequestSerialization() {
        String key = "key";
        String subject = "subject";
        Observer.Type type = Observer.Type.MOJIO;
        Transport transport = Transport.forAndroid("gcmRegId");
        String[] fields = new String[] { "LastContactTime", "LastContactTime" };

        Observer.Request o = new Observer.Builder(key)
                .subject(subject)
                .type(type)
                .transport(transport)
                .condition(Condition.onPropertyChanged("Property"))
                .condition(Condition.onThreshold("Property", Condition.Position.ABOVE, 1d, 2d))
                .condition(Condition.throttle("Speed.Value", "0.00:01:00.0000"))
                .condition(Condition.debounce(1, 2, 3, 4, 5))
                .field(fields[0])
                .field(fields[1])
                .build();

        String json = new Gson().toJson(o, Observer.Request.class);
        assertEquals(TestJson.OBSERVER_REQUEST, json);
    }

    @Test
    public void testRequestSerialization_minimal() {
        String key = "key";
        Observer.Type type = Observer.Type.MOJIO;

        Observer.Request request = new Observer.Builder(key)
                .type(type).build();
        assertThat(request).isNotNull();

        String json = new Gson().toJson(request, Observer.Request.class);
        assertThat(json).isEqualTo("{\"Key\":\"key\",\"Type\":\"mojio\"}");
    }

    @Test
    public void testBuild_unique() {
        String key = "key";
        String subject = "subject";
        Observer.Type type = Observer.Type.MOJIO;
        Transport transport = Transport.forAndroid("gcmRegId");
        String[] fields = new String[] { "LastContactTime", "LastContactTime" };

        Observer.Builder builder = new Observer.Builder(key)
                .subject(subject)
                .type(type)
                .transport(transport)
                .condition(Condition.onPropertyChanged("Property"))
                .condition(Condition.onThreshold("Property", Condition.Position.ABOVE, 1d, 2d))
                .condition(Condition.throttle("Speed.Value", "0.00:01:00.0000"))
                .condition(Condition.debounce(1, 2, 3, 4, 5))
                .field(fields[0])
                .field(fields[1]);

        Observer.Request requestA = builder.build();
        Observer.Request requestB = builder.build();
        assertFalse(requestA == requestB);
    }

    @Test(expected = IllegalStateException.class)
    public void testBuild_empty() {
        String key = "key";
        new Observer.Builder(key).build();
    }

}