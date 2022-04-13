package com.hiepdt.vpstest;

import android.app.Application;
import android.content.Context;

public class GlobalApp extends Application {
    private static Context context;

    public void onCreate() {
        super.onCreate();
        GlobalApp.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return GlobalApp.context;
    }
}
