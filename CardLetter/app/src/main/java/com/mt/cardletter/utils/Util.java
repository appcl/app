package com.mt.cardletter.utils;

import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	/** 
     * dpתpx
     * 
     */  
    public static int dip2px(Context ctx, float dpValue) {
        final float scale = ctx.getResources().getDisplayMetrics().density;  
        return (int) (dpValue * scale + 0.5f);  
    } 
 
  
    /** 
     *	pxתdp
     */  
    public static int px2dip(Context ctx, float pxValue) {
        final float scale = ctx.getResources().getDisplayMetrics().density;  
        return (int) (pxValue / scale + 0.5f);  
    }
    public static String chengDate(String date){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy.MM.dd");
        try {
            Date d = sdf1.parse(date);
            String s = sdf2.format(d);
            return s;
        } catch (ParseException e) {
            e.printStackTrace();
            return "时间转换错误";
        }
    }
}
