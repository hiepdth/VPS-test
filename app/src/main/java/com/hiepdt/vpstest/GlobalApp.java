package com.hiepdt.vpstest;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class GlobalApp extends Application {
    private static Context context;

    public void onCreate() {
        super.onCreate();
        GlobalApp.context = getApplicationContext();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public static Context getAppContext() {
        return GlobalApp.context;
    }
}
