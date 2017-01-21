package io.moj.java.sdk.model.response;

import io.moj.java.sdk.model.values.LinkInfo;

/**
 * Model object for a response whose data is a List.
 * Created by skidson on 16-02-09.
 */
public class ListResponse<T> extends DataResponse<T> {

    private Integer Results;
    private Integer TotalCount;
    private LinkInfo Links;

    public LinkInfo getLinks() {
        return Links;
    }

    public void setLinks(LinkInfo links) {
        Links = links;
    }

    public Integer getResults() {
        return Results;
    }

    public void setResults(Integer results) {
        Results = results;
    }

    public Integer getTotalCount() {
        return TotalCount;
    }

    public void setTotalCount(Integer totalCount) {
        TotalCount = totalCount;
    }

    @Override
    public String toString() {
        return "ListResponse{" +
                "Results=" + Results +
                ", TotalCount=" + TotalCount +
                ", Links=" + Links +
                "} " + super.toString();
    }
}