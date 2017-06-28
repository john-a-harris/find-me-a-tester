package com.umotif.findmeatester;

import android.content.Context;
import android.support.annotation.NonNull;

import com.umotif.findmeatester.datasource.multiplication.MultiplicationRepository;
import com.umotif.findmeatester.datasource.multiplication.remote.MultiplicationResultRemoteDataSource;
import com.umotif.findmeatester.requestmultiplication.domain.usecase.GetMultiplicationValue;

import static com.google.common.base.Preconditions.checkNotNull;

public class Injection {

    public static MultiplicationRepository provideMultiplicationRepository(@NonNull Context context) {
        checkNotNull(context);
        return MultiplicationRepository.getInstance(MultiplicationResultRemoteDataSource.getInstance());
    }

    public static GetMultiplicationValue provideGetMultiplicationValue(@NonNull Context context) {
        return new GetMultiplicationValue(provideMultiplicationRepository(context));
    }

    public static UseCaseHandler provideUseCaseHandler() {
        return UseCaseHandler.getInstance();
    }

}
