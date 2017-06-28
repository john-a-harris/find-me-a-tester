package com.umotif.findmeatester.requestmultiplication.domain.usecase;

import android.support.annotation.NonNull;

import com.umotif.findmeatester.UseCase;
import com.umotif.findmeatester.datasource.multiplication.MultiplicationRepository;
import com.umotif.findmeatester.util.LogUtils;

import static com.google.common.base.Preconditions.checkNotNull;

public class GetMultiplicationValue extends UseCase<GetMultiplicationValue.RequestValues, GetMultiplicationValue.ResponseValue> {

    private static final String TAG = GetMultiplicationValue.class.getSimpleName();

    private final MultiplicationRepository multiplicationRepository;

    public GetMultiplicationValue(@NonNull MultiplicationRepository multiplicationRepository) {
        this.multiplicationRepository = checkNotNull(multiplicationRepository, "multiplicationRepository can't be null!");
    }

    @Override
    protected void executeUseCase(final RequestValues values) {
        LogUtils.d(TAG, "executeUseCase >>>");

        multiplicationRepository.getMultiplicationResult(new MultiplicationRepository.requestResultCallback() {
            @Override
            public void onResultReceived(Object result) {
                ResponseValue responseValue = new ResponseValue(result);
                getUseCaseCallback().onSuccess(responseValue);
            }

            @Override
            public void onDataNotAvailable() {
                getUseCaseCallback().onError();
            }
        }, values.getInput1(), values.getInput2());

        LogUtils.d(TAG, "<<< executeUseCase");
    }

    public static final class RequestValues implements UseCase.RequestValues {
        private final Object input1;
        private final Object input2;

        public RequestValues(Object input1, Object input2) {
            this.input1 = checkNotNull(input1, "input1 can't be null!");
            this.input2 = checkNotNull(input2, "input2 can't be null!");
        }

        public Object getInput1() {
            return input1;
        }

        public Object getInput2() {
            return input2;
        }
    }

    public static final class ResponseValue implements UseCase.ResponseValue {

        private final Object result;

        public ResponseValue(@NonNull Object result) {
            this.result = checkNotNull(result, "result can't be null!");
        }

        public Object getResult() {
            return result;
        }
    }

}
