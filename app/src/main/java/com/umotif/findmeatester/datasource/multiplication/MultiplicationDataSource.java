package com.umotif.findmeatester.datasource.multiplication;

import android.support.annotation.NonNull;

public interface MultiplicationDataSource {

    interface requestResultCallback {

        void onResultReceived(Object result);

        void onDataNotAvailable();
    }

    void getMultiplicationResult(@NonNull requestResultCallback callback, Object input1, Object input2);

}
