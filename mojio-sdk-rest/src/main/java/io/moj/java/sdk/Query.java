package io.moj.java.sdk;

import io.moj.java.sdk.utils.TimeUtils;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Convenience class for building query parameters.
 * Created by skidson on 2016-04-15.
 */
public class Query extends HashMap<String, String> {

    public static final String TOP = "top";
    public static final String SKIP = "skip";
    public static final String FILTER = "filter";
    public static final String SELECT = "select";
    public static final String ORDER_BY = "orderby";
    public static final String BEFORE = "before";
    public static final String SINCE = "since";
    public static final String INCLUDE_COUNT = "includeCount";
    public static final String FIELDS = "fields";

    /**
     * The maximum number of records to return.
     * @param top
     * @return
     */
    public Query top(int top) {
        put(TOP, String.valueOf(top));
        return this;
    }

    /**
     * The number of records to skip before it retrieves records in a collection.
     * @param skip
     * @return
     */
    public Query skip(int skip) {
        put(SKIP, String.valueOf(skip));
        return this;
    }

    /**
     * Specifies an expression or function that must evaluate to true for a record to be returned in the collection.
     * @param filter
     * @return
     */
    public Query filter(String filter) {
        put(FILTER, filter);
        return this;
    }

    /**
     *
     Specifies a subset of properties to return.
     * @param select
     * @return
     */
    public Query select(String select) {
        put(SELECT, select);
        return this;
    }

    /**
     * Determines what values are used to order a collection of records.
     * @param orderBy
     * @return
     */
    public Query orderBy(String orderBy) {
        put(ORDER_BY, orderBy);
        return this;
    }

    /**
     * Date to skip to, used for paging.
     * @param before the timestamp in ISO-8601 UTC timestamp format (e.g. 2016-07-01T05:02:39Z)
     * @return
     */
    public Query before(String before) {
        put(BEFORE, before);
        return this;
    }

    /**
     * Date to skip to, used for paging.
     * @param timestamp the timestamp, in milliseconds
     * @return
     */
    public Query before(long timestamp) {
        return before(TimeUtils.convertMillisToTimestamp(timestamp));
    }

    /**
     * Return only records after this date
     * @param since the timestamp in ISO-8601 UTC timestamp format (e.g. 2016-07-01T05:02:39Z)
     * @return
     */
    public Query since(String since) {
        put(SINCE, since);
        return this;
    }

    /**
     * Date to skip to, used for paging.
     * @param timestamp the timestamp, in milliseconds
     * @return
     */
    public Query since(long timestamp) {
        return since(TimeUtils.convertMillisToTimestamp(timestamp));
    }

    /**
     * Determines whether to include the total row count.
     * @param includeCount
     * @return
     */
    public Query includeCount(boolean includeCount) {
        put(INCLUDE_COUNT, String.valueOf(includeCount));
        return this;
    }

    /**
     * Determines the fields to be included in the result
     * @param fields
     * @return
     */
    public Query fields(String... fields) {
        if (fields != null) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < fields.length; i++) {
                builder.append(fields[i]);
                if (i < fields.length - 1) {
                    builder.append(",");
                }
            }
            put(FIELDS, builder.toString());
        }
        return this;
    }

}
