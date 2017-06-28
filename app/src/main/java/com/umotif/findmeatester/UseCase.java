package com.umotif.findmeatester;

public abstract class UseCase<Z extends UseCase.RequestValues, K extends UseCase.ResponseValue> {

    private Z mRequestValues;

    private UseCaseCallback<K> mUseCaseCallback;

    public void setRequestValues(Z requestValues) {
        mRequestValues = requestValues;
    }

    public Z getRequestValues() {
        return mRequestValues;
    }

    public UseCaseCallback<K> getUseCaseCallback() {
        return mUseCaseCallback;
    }

    public void setUseCaseCallback(UseCaseCallback<K> useCaseCallback) {
        mUseCaseCallback = useCaseCallback;
    }

    public interface UseCaseCallback<R> {
        void onSuccess(R response);

        void onError();
    }

    void run() {
        executeUseCase(mRequestValues);
    }

    protected abstract void executeUseCase(Z requestValues);

    public interface RequestValues {
    }

    public interface ResponseValue {
    }

}
