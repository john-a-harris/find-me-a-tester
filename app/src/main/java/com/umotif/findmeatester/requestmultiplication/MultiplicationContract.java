package com.umotif.findmeatester.requestmultiplication;

import com.umotif.findmeatester.BasePresenter;
import com.umotif.findmeatester.BaseView;

import java.util.List;

public class MultiplicationContract {

    public interface View extends BaseView<Presenter> {

        void showResult(Object result);

    }

    public interface Presenter extends BasePresenter {

        void makeRequest(Object input1, Object input2);

    }

}
