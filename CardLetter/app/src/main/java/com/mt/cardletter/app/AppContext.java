package com.mt.cardletter.app;

import android.app.Application;

import com.mob.MobSDK;


public class AppContext extends Application {
    private static AppContext app;


    public AppContext() {
        app = this;
    }

    public static synchronized AppContext getInstance() {
        if (app == null) {
            app = new AppContext();
        }
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MobSDK.init(this,"230ba2d633f9d","6611150155097717a1ca80c17e703c2b");
        registerUncaughtExceptionHandler();
    }
    // 注册App异常崩溃处理器
    private void registerUncaughtExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler(AppException.getAppExceptionHandler());
    }

}