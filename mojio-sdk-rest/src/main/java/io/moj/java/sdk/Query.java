package io.moj.java.sdk;

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

}
