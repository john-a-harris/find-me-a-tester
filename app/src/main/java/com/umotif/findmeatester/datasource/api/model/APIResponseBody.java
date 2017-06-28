package com.umotif.findmeatester.datasource.api.model;

import com.google.gson.annotations.SerializedName;

public class APIResponseBody {

    @SerializedName("result")
    private Object result;

    public Object getResult() {
        return result;
    }

}
