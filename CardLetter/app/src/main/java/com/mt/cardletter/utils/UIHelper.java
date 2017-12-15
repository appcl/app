package com.mt.cardletter.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.mt.cardletter.MainActivity;
import com.mt.cardletter.activity.LoginActivity;
import com.mt.cardletter.activity.MakeIntegralActivity;
import com.mt.cardletter.activity.SearchClassicActivity;
import com.mt.cardletter.activity.SearchIntegralActivity;


/**
 * 应用程序UI工具包：封装UI相关的一些操作
 */
public class UIHelper {

    public final static String TAG = "UIHelper";

    public final static int RESULT_OK = 0x00;
    public final static int REQUEST_CODE = 0x01;

    public static void ToastMessage(Context cont, String msg) {
        if (cont == null || msg == null) {
            return;
        }
        Toast.makeText(cont, msg, Toast.LENGTH_SHORT).show();
    }

    public static void ToastMessage(Context cont, int msg) {
        if (cont == null || msg <= 0) {
            return;
        }
        Toast.makeText(cont, msg, Toast.LENGTH_SHORT).show();
    }

    public static void ToastMessage(Context cont, String msg, int time) {
        if (cont == null || msg == null) {
            return;
        }
        Toast.makeText(cont, msg, time).show();
    }

    /**
     * 显示主页
     * @param context
     */
    public static void showMainActivity(Activity context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
        context.finish();
    }

    /**
     * 登录
     * @param context
     */
    public static void showLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    /**
     * 赚积分
     * @param context
     */
    public static void showMakeIntegralActivity(Context context) {
        Intent intent = new Intent(context, MakeIntegralActivity.class);
        context.startActivity(intent);
    }

    /**
     * 查积分
     * @param context
     */
    public static void showSearchIntegralActivity(Context context) {
        Intent intent = new Intent(context, SearchIntegralActivity.class);
        context.startActivity(intent);
    }

    /**
     * 分类搜索
     * @param context
     */
    public static void showSearchClassicActivity(Context context) {
        Intent intent = new Intent(context, SearchClassicActivity.class);
        context.startActivity(intent);
    }

}
