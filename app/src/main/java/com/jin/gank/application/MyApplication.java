package com.jin.gank.application;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2015/8/31.
 */
public class MyApplication extends Application {
    public static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }
}
