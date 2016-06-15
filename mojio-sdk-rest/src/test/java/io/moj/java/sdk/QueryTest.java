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
        boolean includeCount = true;
        String[] fields = new String[] { "abc", "def", "ghi" };
        Map<String, String> query = new Query()
                .top(top)
                .skip(skip)
                .filter(filter)
                .select(select)
                .orderBy(orderBy)
                .includeCount(includeCount)
                .fields(fields);

        assertThat(query.size()).isEqualTo(7);
        assertThat(query.get(Query.TOP)).isEqualTo(String.valueOf(top));
        assertThat(query.get(Query.SKIP)).isEqualTo(String.valueOf(skip));
        assertThat(query.get(Query.FILTER)).isEqualTo(filter);
        assertThat(query.get(Query.SELECT)).isEqualTo(select);
        assertThat(query.get(Query.ORDER_BY)).isEqualTo(orderBy);
        assertThat(query.get(Query.INCLUDE_COUNT)).isEqualTo(String.valueOf(includeCount));
        assertThat(query.get(Query.FIELDS)).isEqualTo("abc,def,ghi");
    }

    @Test
    public void testBuild_empty() {
        Map<String, String> query = new Query();
        assertThat(query).isEmpty();
    }

}
