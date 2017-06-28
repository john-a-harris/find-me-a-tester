package com.umotif.findmeatester.requestmultiplication.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.umotif.findmeatester.R;
import com.umotif.findmeatester.requestmultiplication.MultiplicationContract;
import com.umotif.findmeatester.util.LogUtils;
import com.umotif.findmeatester.util.UiUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.google.common.base.Preconditions.checkNotNull;

public class MultiplicationFragment extends Fragment implements MultiplicationContract.View {

    private static final String TAG = MultiplicationFragment.class.getSimpleName();

    @BindView(R.id.first_input_edit_text)
    EditText input1;
    @BindView(R.id.second_input_edit_text)
    EditText input2;

    @OnClick(R.id.make_request_button)
    void makeRequest() {
        LogUtils.d(TAG, "makeRequest >>> " + input1.getText());
        mPresenter.makeRequest(input1.getText(), input2.getText());
    }

    private MultiplicationContract.Presenter mPresenter;

    public static MultiplicationFragment newInstance() {
        return new MultiplicationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LogUtils.d(TAG, "onCreateView >>>");

        View root = inflater.inflate(R.layout.fragment_multiplication, container, false);
        ButterKnife.bind(this, root);

        LogUtils.d(TAG, "<<< onCreateView");
        return root;
    }

    @Override
    public void setPresenter(MultiplicationContract.Presenter presenter) {
        LogUtils.d(TAG, "setPresenter >>>");

        mPresenter = checkNotNull(presenter);

        LogUtils.d(TAG, "<<< setPresenter");
    }

    @Override
    public void showResult(Object result) {
        UiUtils.showToast(getActivity(), result.toString());
    }

}
