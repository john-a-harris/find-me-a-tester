package com.umotif.findmeatester.requestmultiplication.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.umotif.findmeatester.Injection;
import com.umotif.findmeatester.R;
import com.umotif.findmeatester.requestmultiplication.MultiplicationPresenter;
import com.umotif.findmeatester.requestmultiplication.ui.fragment.MultiplicationFragment;
import com.umotif.findmeatester.util.LogUtils;
import com.umotif.findmeatester.util.UiUtils;

public class MultiplicationActivity extends AppCompatActivity {

    private static final String TAG = "MultiplicationActivity";

    private MultiplicationPresenter multiplicationPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtils.d(TAG, "onCreate >>>");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic);

        MultiplicationFragment multiplicationFragment =
                (MultiplicationFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.content_frame);

        if (multiplicationFragment == null) {
            // Create our fragment
            multiplicationFragment = MultiplicationFragment.newInstance();

            UiUtils.addFragmentToActivity(
                    getSupportFragmentManager(),
                    multiplicationFragment,
                    R.id.content_frame);
        }

        // Create the presenter
        multiplicationPresenter = new MultiplicationPresenter(
                Injection.provideUseCaseHandler(),
                multiplicationFragment,
                Injection.provideGetMultiplicationValue(getApplicationContext()));

        LogUtils.d(TAG, "<<< onCreate");
    }

}
