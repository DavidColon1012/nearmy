package com.example.nearmy;

import android.content.Context;

import androidx.multidex.MultiDexApplication;

public class MainApplication extends MultiDexApplication {
    public static final boolean DEVELOPER_MODE = false;

    private static MainApplication instance;

    public MainApplication() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Context getContext() {
        return instance.getApplicationContext();
    }
}
