package com.mt.cardletter.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.mt.cardletter.activity.LoginActivity;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * Created by jk on 2018/1/6.
 * 第三方登录  QQ  Sina  Winxin
 */

public class ThirdpartyLoginUtils {

    private static UMShareAPI mShareAPI;
    private static UMAuthListener umAuthListener;
    private static Activity defActivity;
    public static void loginForQQ(final Activity mActivity) {
        defActivity = mActivity;
        //boolean isShouQuan = SharedPreferences.getInstance().getBoolean("islogin",false);
        mShareAPI = UMShareAPI.get(mActivity);
        umAuthListener = new UMAuthListener() {

            /**
             * @desc 授权开始的回调
             * @param platform 平台名称
             */
            @Override
            public void onStart(SHARE_MEDIA platform) {
                //Toast.makeText(LoginActivity.this, "开始", Toast.LENGTH_LONG).show();
            }

            /**
             * @desc 授权成功的回调
             * @param platform 平台名称
             * @param action 行为序号，开发者用不上
             * @param data 用户资料返回
             */
            @Override
            public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
                String name = data.get("name").toString();
                String iconurl = data.get("iconurl");
                SharedPreferences.getInstance().putString("nick_name",name);
                SharedPreferences.getInstance().putString("url",iconurl);
                SharedPreferences.getInstance().putBoolean("isLogin",true);
                Toast.makeText(mActivity, "AA:" + name + "  " + iconurl, Toast.LENGTH_LONG).show();
                mActivity.finish();
            }

            /**
             * @desc 授权失败的回调
             * @param platform 平台名称
             * @param action 行为序号，开发者用不上
             * @param t 错误原因
             */
            @Override
            public void onError(SHARE_MEDIA platform, int action, Throwable t) {

                Toast.makeText(mActivity, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
            }

            /**
             * @desc 授权取消的回调
             * @param platform 平台名称
             * @param action 行为序号，开发者用不上
             */
            @Override
            public void onCancel(SHARE_MEDIA platform, int action) {
                Toast.makeText(mActivity, "取消了", Toast.LENGTH_LONG).show();
            }
        };
//        if (isShouQuan) {
//            mShareAPI.deleteOauth(mActivity, SHARE_MEDIA.QQ, umAuthListener);
//        } else {
            mShareAPI.getPlatformInfo(mActivity, SHARE_MEDIA.QQ, umAuthListener);
        //}

    }
    public static void unLoginForQQ() {

        if (defActivity == null && umAuthListener == null){
            System.out.println("defActivity umAuthListener为空");
            return;
        }
        System.out.println("===============kaishi==========defActivity umAuthListener为空");
        mShareAPI.deleteOauth(defActivity, SHARE_MEDIA.QQ, null);
        System.out.println("===============jieshu==========defActivity umAuthListener为空");
    }
    public static void loginForSina(final Activity mActivity) {

    }
    public static void loginForWinxin(final Activity mActivity) {

    }
}
