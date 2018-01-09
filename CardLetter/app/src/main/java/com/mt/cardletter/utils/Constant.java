package com.mt.cardletter.utils;

/**
 * Created by Lanye on 2017/2/22.
 */

public class Constant {
    public static String ERRMESSAGE;
    public static int RESPONSECODE;
    public static String TOKEN;
    public static int CANCLE_ORDER = 0;
    //请求相机
    public static final int REQUEST_CAPTURE = 200;
    //请求相册
    public static final int REQUEST_PICK = 201;
    //请求截图
    public static final int REQUEST_CROP_PHOTO = 202;
    //请求访问外部存储
    public static final int READ_EXTERNAL_STORAGE_REQUEST_CODE = 203;
    //请求写入外部存储
    public static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 204;
    //请求相机权限
    public static final int CAMERA_ACCESSIBILITY = 209;
    public static boolean is_login =false;

    /******************** 时间相关常量 ********************/
    /**
     * 毫秒与毫秒的倍数
     */
    public static final int MSEC = 1;
    /**
     * 秒与毫秒的倍数
     */
    public static final int SEC  = 1000;
    /**
     * 分与毫秒的倍数
     */
    public static final int MIN  = 60000;
    /**
     * 时与毫秒的倍数
     */
    public static final int HOUR = 3600000;
    /**
     * 天与毫秒的倍数
     */
    public static final int DAY  = 86400000;

    public enum TimeUnit {
        MSEC,
        SEC,
        MIN,
        HOUR,
        DAY
    }

    public static final String Access_Token = "d071ee06d1f4a5f3d102c6483d248142";//测试ak
    public static final String BASE_URL = "http://51kalaxin.free.ngrok.cc";      //测试url
    public static final String BASIC = "NTFrYWxheGluOjYya2F4aW4=";               //测试basic
    public static final String JH_KEY = "e46870fe3129e14dfe9818b31609bc1a";      //聚合的Key

    public static final String JH_CAR = "8e54776ff5c43672a1e8380c988af6bc";      //聚合违章查询Key
//    public static final String JH_KEY = "9a66765e53c4bf57f1e614d3fefe02d1";     //聚合快递查询Key

    public static final String PIC_URL = "http://51kalaxin.free.ngrok.cc";//图片的路径

}
