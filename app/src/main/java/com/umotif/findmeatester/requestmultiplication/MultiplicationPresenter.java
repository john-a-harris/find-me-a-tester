package com.umotif.findmeatester.requestmultiplication;

import android.support.annotation.NonNull;

import com.umotif.findmeatester.UseCase;
import com.umotif.findmeatester.UseCaseHandler;
import com.umotif.findmeatester.requestmultiplication.domain.usecase.GetMultiplicationValue;

import static com.google.common.base.Preconditions.checkNotNull;

public class MultiplicationPresenter implements MultiplicationContract.Presenter {

    private static final String TAG = MultiplicationPresenter.class.getSimpleName();

    private final MultiplicationContract.View multiplicationView;

    private final UseCaseHandler useCaseHandler;

    private final GetMultiplicationValue getMultiplicationValue;

    public MultiplicationPresenter(@NonNull UseCaseHandler useCaseHandler,
                                   @NonNull MultiplicationContract.View multiplicationView,
                                   @NonNull GetMultiplicationValue getMultiplicationValue) {
        this.useCaseHandler = checkNotNull(useCaseHandler, "useCaseHandler can't be null");
        this.multiplicationView = checkNotNull(multiplicationView, "multiplicationView can't be null!");
        this.getMultiplicationValue = checkNotNull(getMultiplicationValue, "getMultiplicationValue can't be null!");

        multiplicationView.setPresenter(this);
    }

    @Override
    public void start() {
        // nothing to do
    }

    @Override
    public void makeRequest(Object input1, Object input2) {
        useCaseHandler.execute(getMultiplicationValue, new GetMultiplicationValue.RequestValues(input1, input2),
                new UseCase.UseCaseCallback<GetMultiplicationValue.ResponseValue>() {
                    @Override
                    public void onSuccess(GetMultiplicationValue.ResponseValue response) {
                        if (response != null && response.getResult() != null) {
                            processResponse(response.getResult());
                        }
                    }

                    @Override
                    public void onError() {
                        processResponse("Error!");
                    }
                });
    }

    private void processResponse(Object theResponse) {
        multiplicationView.showResult(theResponse);
    }

}
