package com.umotif.findmeatester;

import android.app.Application;

import com.umotif.findmeatester.datasource.api.FindMeATesterAPI;
import com.umotif.findmeatester.util.LogUtils;

public class FindMeATesterApp extends Application {

    private static final String TAG = FindMeATesterApp.class.getSimpleName();

    @Override
    public void onCreate() {
        LogUtils.d(TAG, "onCreate >>>");

        super.onCreate();

        FindMeATesterAPI.create();

        LogUtils.d(TAG, "<<< onCreate");
    }

}
