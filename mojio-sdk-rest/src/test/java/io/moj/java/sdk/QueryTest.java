package io.moj.java.sdk;

import org.junit.Test;

import java.util.Map;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by skidson on 2016-04-15.
 */
public class QueryTest {

    @Test
    public void testBuild() {
        int top = 1234;
        int skip = 5678;
        String filter = "filter";
        String select = "select";
        String orderBy = "orderby";
        Map<String, String> query = new Query()
                .top(top)
                .skip(skip)
                .filter(filter)
                .select(select)
                .orderBy(orderBy)
                .build();

        assertThat(query.size()).isEqualTo(5);
        assertThat(query.get(Query.TOP)).isEqualTo(String.valueOf(top));
        assertThat(query.get(Query.SKIP)).isEqualTo(String.valueOf(skip));
        assertThat(query.get(Query.FILTER)).isEqualTo(filter);
        assertThat(query.get(Query.SELECT)).isEqualTo(select);
        assertThat(query.get(Query.ORDER_BY)).isEqualTo(orderBy);
    }

    @Test
    public void testBuild_empty() {
        Map<String, String> query = new Query().build();
        assertThat(query).isEmpty();
    }

    /**
     * Verify subsequent invocations of {@link io.moj.java.sdk.Query#build()} create two unique objects. Further
     * modification of one should not modify the other).
     */
    @Test
    public void testBuild_unique() {
        String expectedSelect = "select";
        Query query = new Query().select(expectedSelect);
        Map<String, String> queryMapA = query.build();
        Map<String, String> queryMapB = query.build();
        assertThat(queryMapA).isNotSameAs(queryMapB);

        queryMapA.put(Query.SELECT, "modified");
        assertThat(queryMapB.get(Query.SELECT)).isEqualTo(expectedSelect);
    }

}
