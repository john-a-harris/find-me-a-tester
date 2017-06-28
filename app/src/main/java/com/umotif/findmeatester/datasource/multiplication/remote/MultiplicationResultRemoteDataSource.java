package com.umotif.findmeatester.datasource.multiplication.remote;

import android.support.annotation.NonNull;
import android.util.Log;

import com.umotif.findmeatester.datasource.api.FindMeATesterAPI;
import com.umotif.findmeatester.datasource.api.model.APIResponseBody;
import com.umotif.findmeatester.datasource.multiplication.MultiplicationDataSource;
import com.umotif.findmeatester.util.LogUtils;

import retrofit2.Call;
import retrofit2.Callback;

public class MultiplicationResultRemoteDataSource implements MultiplicationDataSource {

    private static final String TAG = MultiplicationResultRemoteDataSource.class.getSimpleName();

    private static MultiplicationResultRemoteDataSource INSTANCE;

    public static MultiplicationResultRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MultiplicationResultRemoteDataSource();
        }
        return INSTANCE;
    }

    // Prevent direct instantiation.
    private MultiplicationResultRemoteDataSource() {
    }

    @Override
    public void getMultiplicationResult(final @NonNull requestResultCallback callback, Object input1, Object input2) {
        LogUtils.d(TAG, "getMultiplicationResult >>> ");

        Call<APIResponseBody> call = FindMeATesterAPI.getInstance().getApiService().makeRequest(input1, input2);

        call.enqueue(new Callback<APIResponseBody>() {
            @Override
            public void onResponse(Call<APIResponseBody> call, retrofit2.Response<APIResponseBody> response) {
                APIResponseBody body = response.body();
                if (body != null) {
                    callback.onResultReceived(body.getResult());
                }
            }

            @Override
            public void onFailure(Call<APIResponseBody> call, Throwable t) {
                Log.d(TAG, "synchronizeForms onFailure: " + call.request().url());
                callback.onDataNotAvailable();
            }
        });

    }

}
