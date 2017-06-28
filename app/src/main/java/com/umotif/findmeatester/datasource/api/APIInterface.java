package com.umotif.findmeatester.datasource.api;

import com.umotif.findmeatester.datasource.api.model.APIResponseBody;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {

    @GET("{input1}/{input2}")
    Call<APIResponseBody> makeRequest(@Path("input1") Object input1, @Path("input2") Object input2);

}
