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

    public static final String Access_Token = "8d9d5a4878691c85e43b2564780cb1a4";//测试ak
    public static final String BASE_URL = "http://www.51kaxin.xyz";      //测试url
    public static final String BASIC = "NTFrYWxheGluOjYya2F4aW4=";               //测试basic
    public static final String JH_KEY = "e46870fe3129e14dfe9818b31609bc1a";      //聚合的Key

    public static final String JH_CAR = "8e54776ff5c43672a1e8380c988af6bc";         //聚合违章查询Key
//    public static final String JH_KEY = "9a66765e53c4bf57f1e614d3fefe02d1";       //聚合快递查询Key

    public static final String PIC_URL = "http://www.51kaxin.xyz";//图片的路径


    public static final String NEWS_KEY = "9a025356104a37cd0c690368a0461f41";       //网络新闻KEY


    //Access Key:sNjAD1rszzfVcWHK
    //Secret Key:2b83fcb0144c4079aabe2de3cd9a3b6b
    public static final String QQ_MAIN = "https://ui.ptlogin2.qq.com/cgi-bin/login?style=9&appid=522005705&daid=4&s_url=https%3A%2F%2Fw.mail.qq.com%2Fcgi-bin%2Flogin%3Fvt%3Dpassport%26vm%3Dwsk%26delegate_url%3D%26f%3Dxhtml%26target%3D&hln_css=http%3A%2F%2Fmail.qq.com%2Fzh_CN%2Fhtmledition%2Fimages%2Flogo%2Fqqmail%2Fqqmail_logo_default_200h.png&low_login=1&hln_autologin=%E8%AE%B0%E4%BD%8F%E7%99%BB%E5%BD%95%E7%8A%B6%E6%80%81&pt_no_onekey=1";
    public static final String QQ_MAIN_WEB ="https://mail.qq.com/cgi-bin/loginpage";
}
