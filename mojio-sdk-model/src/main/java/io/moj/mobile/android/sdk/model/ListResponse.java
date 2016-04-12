package io.moj.mobile.android.sdk.model;

import java.util.List;

import io.moj.mobile.android.sdk.model.values.LinkInfo;

/**
 * Model object for a response whose data is a List.
 * Created by skidson on 16-02-09.
 */
public class ListResponse<T> {

    private List<T> Data;
    private Integer Results;
    private LinkInfo Links;

    public List<T> getData() {
        return Data;
    }

    public void setData(List<T> data) {
        Data = data;
    }

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

    @Override
    public String toString() {
        return "ListResponse{" +
                "Data=" + Data +
                ", Results=" + Results +
                ", Links=" + Links +
                '}';
    }
}
