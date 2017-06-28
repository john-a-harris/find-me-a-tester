package com.umotif.findmeatester.datasource.multiplication;

import android.support.annotation.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;

public class MultiplicationRepository implements MultiplicationDataSource {

    private static final String TAG = MultiplicationRepository.class.getSimpleName();

    private static MultiplicationRepository INSTANCE = null;

    private final MultiplicationDataSource multiplicationRemoteDataSource;

    // Prevent direct instantiation.
    private MultiplicationRepository(@NonNull MultiplicationDataSource multiplicationRemoteDataSource) {
        this.multiplicationRemoteDataSource = checkNotNull(multiplicationRemoteDataSource);
    }

    public static MultiplicationRepository getInstance(MultiplicationDataSource multiplicationRemoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new MultiplicationRepository(multiplicationRemoteDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void getMultiplicationResult(final @NonNull requestResultCallback callback, Object input1, Object input2) {
        multiplicationRemoteDataSource.getMultiplicationResult(new requestResultCallback() {
            @Override
            public void onResultReceived(Object result) {
                callback.onResultReceived(result);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        }, input1, input2);
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}
