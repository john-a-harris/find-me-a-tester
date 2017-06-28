package com.umotif.findmeatester.util;

import android.util.Log;

import com.umotif.findmeatester.BuildConfig;

public final class LogUtils {

    private LogUtils() {
    }

    @SuppressWarnings("unused")
    public static void d(final String tag, final String message) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message);
        }
    }

    @SuppressWarnings("unused")
    public static void d(final String tag, final String message, final Throwable cause) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message, cause);
        }
    }

    @SuppressWarnings("unused")
    public static void v(final String tag, final String message) {
        if (BuildConfig.DEBUG) {
            Log.v(tag, message);
        }
    }

    @SuppressWarnings("unused")
    public static void v(final String tag, final String message, final Throwable cause) {
        if (BuildConfig.DEBUG) {
            Log.v(tag, message, cause);
        }
    }

    @SuppressWarnings("unused")
    public static void i(final String tag, final String message) {
        Log.i(tag, message);
    }

    @SuppressWarnings("unused")
    public static void i(final String tag, final String message, final Throwable cause) {
        Log.i(tag, message, cause);
    }

    @SuppressWarnings("unused")
    public static void w(final String tag, final String message) {
        Log.w(tag, message);
    }

    @SuppressWarnings("unused")
    public static void w(final String tag, final String message, final Throwable cause) {
        Log.w(tag, message, cause);
    }

    @SuppressWarnings("unused")
    public static void e(final String tag, final String message) {
        Log.e(tag, message);
    }

    @SuppressWarnings("unused")
    public static void e(final String tag, final String message, final Throwable cause) {
        Log.e(tag, message, cause);
    }

}
