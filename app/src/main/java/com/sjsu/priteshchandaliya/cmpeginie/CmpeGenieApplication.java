package com.sjsu.priteshchandaliya.cmpeginie;

import android.app.Application;

/**
 * Created by Megha on 5/18/2016.
 */
public class CmpeGenieApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CmpeGenie.appInit(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}


