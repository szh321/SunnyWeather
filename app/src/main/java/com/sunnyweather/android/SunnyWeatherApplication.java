package com.sunnyweather.android;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.media.session.MediaSession;

public class SunnyWeatherApplication extends Application {
    public static final String TOKEN="g5pBYdGI4eWeCSPQ";
    @SuppressLint("StaticFieldLeak")
    public    static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
         context=getApplicationContext();
    }

}
