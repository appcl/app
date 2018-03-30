package com.mt.cardletter.utils;

import com.mob.analysdk.AnalySDK;

import java.util.HashMap;

/**
 * Author: jk - Administrator
 * Data: 2018/3/30  15:22
 * Description: //统计
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃
 * 　　┃　　　┃
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 */

public class AnalySDKUtil {

    public static void  registEvrnt(String eventName,String state){
        HashMap<String, Object> eventParams = new HashMap<String, Object>();
        eventParams.put("page", state);
        AnalySDK.trackEvent(eventName, eventParams);
    }
}
