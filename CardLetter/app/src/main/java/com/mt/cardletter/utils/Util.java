package com.mt.cardletter.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import com.google.gson.Gson;
import com.mt.cardletter.R;
import com.mt.cardletter.view.dialog.CommonDialog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Util {

    static CommonDialog dialog;
    public static void showCommonDialog(final Activity context ,int image_id){
        dialog=new CommonDialog(context, image_id,R.style.Dialog,new CommonDialog.OnCloseListener(){
            @Override
            public void onClick(Dialog dialog, boolean confirm) {
                dialog.dismiss();
            }
        });

        dialog.show();

        setDialogAttr(context,dialog);
    }

    private static void setDialogAttr(Activity context, CommonDialog dialog){
        Window dialogWindow = dialog.getWindow();
        WindowManager m = context.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高度
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.height = (int) (d.getHeight() * 0.7); // 高度设置为屏幕的0.6，根据实际情况调整
        p.width = (int) (d.getWidth() * 0.9); // 宽度设置为屏幕的0.65，根据实际情况调整
        dialogWindow.setAttributes(p);
    }
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

    /**
     * 读取assets文件
     * @param context
     * @param fileName
     * @return
     */
    public static String getJson(String fileName,Context context) {
        //将json数据变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager assetManager = context.getAssets();
            //通过管理器打开文件并读取
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * 将字符串转换为 对象
     * @param json
     * @param type
     * @return
     */
    public  static <T> T JsonToObject(String json, Class<T> type) {
        Gson gson =new Gson();
        return gson.fromJson(json, type);
    }
}
