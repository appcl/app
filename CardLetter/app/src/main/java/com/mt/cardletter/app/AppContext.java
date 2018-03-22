package com.mt.cardletter.app;


import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Vibrator;
import android.support.multidex.MultiDex;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.mob.MobSDK;
import com.mt.cardletter.service.LocationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.jpush.android.api.JPushInterface;
import cn.sharesdk.framework.ShareSDK;
import io.realm.Realm;
import io.realm.RealmConfiguration;


public class AppContext extends Application {
    private static AppContext app;
    {
//        PlatformConfig.setWeixin("wxdc18eb813baac5f0", "7685f3096a19535a46e5cddfe91b997a");
//        PlatformConfig.setQQZone("1106542925", "57VgIL08mxb0kua8");
//        PlatformConfig.setSinaWeibo("2928292335", "8f16088f8122c87f695c2893e6595aeb", "http://app.mi.com/download/562671?ref=search");
    }
    public LocationService locationService;
    public Vibrator mVibrator;

    public static List<Map<String, Object>> push_data=new ArrayList<Map<String, Object>>();


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String city;
    public double lat;
    public double lon;
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    private String district;




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
        /**
         * 初始化社会化组件
         */
        MobSDK.init(this);
//        ShareSDK.isDebug();
        ShareSDK.closeDebug();
        registerUncaughtExceptionHandler();
        locationService = new LocationService(getApplicationContext());
        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        SDKInitializer.initialize(this);
        SDKInitializer.setCoordType(CoordType.BD09LL);

        /**
         * 初始化数据库
         */
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
        /**
         * 激光初始化
         */
        JPushInterface.setDebugMode(false);    // 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);            // 初始化 JPush


    }
    // 注册App异常崩溃处理器
    private void registerUncaughtExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler(AppException.getAppExceptionHandler());
    }
//    @Override
//    protected void attachBaseContext(Context base) {
//        super.attachBaseContext(base); MultiDex.install(this);
//    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}