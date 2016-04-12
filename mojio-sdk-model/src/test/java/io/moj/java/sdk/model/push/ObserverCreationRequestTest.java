package io.moj.java.sdk.model.push;

import com.google.gson.Gson;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

/**
 * Created by skidson on 16-02-18.
 */
public class ObserverCreationRequestTest {

    @Test
    public void testSerialization() {
        String key = "key";
        String subject = "subject";
        Observer.Type type = Observer.Type.MOJIO;
        Transport transport = Transport.forAndroid("gcmRegId");
        String[] fields = new String[] { "LastContactTime", "LastContactTime" };

        ObserverCreationRequest o = new ObserverCreationRequest.Builder(key)
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

        String json = new Gson().toJson(o, ObserverCreationRequest.class);
        assertEquals(TestJson.OBSERVER_REQUEST, json);
    }

    @Test
    public void testBuild_unique() {
        String key = "key";
        String subject = "subject";
        Observer.Type type = Observer.Type.MOJIO;
        Transport transport = Transport.forAndroid("gcmRegId");
        String[] fields = new String[] { "LastContactTime", "LastContactTime" };

        ObserverCreationRequest.Builder builder = new ObserverCreationRequest.Builder(key)
                .subject(subject)
                .type(type)
                .transport(transport)
                .condition(Condition.onPropertyChanged("Property"))
                .condition(Condition.onThreshold("Property", Condition.Position.ABOVE, 1d, 2d))
                .condition(Condition.throttle("Speed.Value", "0.00:01:00.0000"))
                .condition(Condition.debounce(1, 2, 3, 4, 5))
                .field(fields[0])
                .field(fields[1]);

        ObserverCreationRequest requestA = builder.build();
        ObserverCreationRequest requestB = builder.build();
        assertFalse(requestA == requestB);
    }

    @Test(expected = IllegalStateException.class)
    public void testBuild_empty() {
        String key = "key";
        new ObserverCreationRequest.Builder(key).build();
    }

    @Test
    public void testSerialization_minimal() {
        String key = "key";
        Observer.Type type = Observer.Type.MOJIO;

        ObserverCreationRequest request = new ObserverCreationRequest.Builder(key)
                .type(type).build();
        assertThat(request).isNotNull();

        String json = new Gson().toJson(request, ObserverCreationRequest.class);
        assertThat(json).isEqualTo("{\"Key\":\"key\",\"Type\":\"mojio\"}");
    }

}
