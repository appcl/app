package com.mt.cardletter.app;

import android.app.Application;
import android.app.Service;
import android.os.Vibrator;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.mt.cardletter.service.LocationService;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.jpush.android.api.JPushInterface;


public class AppContext extends Application {
    private static AppContext app;
    //友盟分享  微信，微博，QQ空间的分享配置

    /**
     * 1.新浪微博
     *      App Key：2928292335
            App Secret：8f16088f8122c87f695c2893e6595aeb
       2.腾讯
            APP ID  1106542925
            APP KEY 57VgIL08mxb0kua8
     */
    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("1106542925", "57VgIL08mxb0kua8");
        PlatformConfig.setSinaWeibo("2928292335", "8f16088f8122c87f695c2893e6595aeb", "http://sns.whalecloud.com");
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
        //友盟分享  微信，微博，QQ空间的分享配置
        UMShareAPI.get(this);
        Config.DEBUG = true;
        //MobSDK.init(this,"230ba2d633f9d","6611150155097717a1ca80c17e703c2b");

        registerUncaughtExceptionHandler();

        locationService = new LocationService(getApplicationContext());
        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        SDKInitializer.initialize(this);
        SDKInitializer.setCoordType(CoordType.BD09LL);

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


}