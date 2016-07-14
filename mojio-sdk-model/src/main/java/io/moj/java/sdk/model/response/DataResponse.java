package io.moj.java.sdk.model.response;

import java.util.List;

/**
 *
 * Created by Mauro on 2016-07-14.
 */
public class DataResponse<T> extends MessageResponse {

    private List<T> Data;

    public List<T> getData() {
        return Data;
    }

    public void setData(List<T> data) {
        Data = data;
    }

    @Override
    public String toString() {
        return "DataResponse{" +
                "Data=" + Data +
                "} " + super.toString();
    }
}
