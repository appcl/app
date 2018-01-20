package com.mt.cardletter.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.mt.cardletter.activity.LoginActivity;
import com.mt.cardletter.activity.RegisterActivity;
import com.mt.cardletter.entity.user.LoginEntity;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
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

    /**
     * QQ
     * @param mActivity
     */
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
                String uid = data.get("uid");
                String name = data.get("name");
                String iconurl = data.get("iconurl");
                String u_pw = "";
                if (uid!=null&&uid.equals("")){
                    u_pw = uid.substring(0,6);
                }
                SharedPreferences.getInstance().putString("nick_name",name);
                SharedPreferences.getInstance().putString("url",iconurl);
                SharedPreferences.getInstance().putBoolean("isLogin",true);

                //toRegister(mActivity,name,"",uid);//// TODO: 2018/1/20 帮用户模拟注册
                System.out.println("jk-----:"+uid);
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

                Toast.makeText(mActivity, "网络异常：" + t.getMessage(), Toast.LENGTH_LONG).show();
            }

            /**
             * @desc 授权取消的回调
             * @param platform 平台名称
             * @param action 行为序号，开发者用不上
             */
            @Override
            public void onCancel(SHARE_MEDIA platform, int action) {
                //Toast.makeText(mActivity, "取消了", Toast.LENGTH_LONG).show();
            }
        };
        mShareAPI.getPlatformInfo(mActivity, SHARE_MEDIA.QQ, umAuthListener);


    }

    /**
     *   解除QQ
     */
    public static void unLoginForQQ() {
        if (defActivity == null && umAuthListener == null){
            System.out.println("defActivity umAuthListener为空");
            return;
        }
        mShareAPI.deleteOauth(defActivity, SHARE_MEDIA.QQ, null);
    }

    /**
     * 新浪
     * @param mActivity
     */
    public static void loginForSina(final Activity mActivity) {


    }

    /**
     * 微信
     * @param mActivity
     */
    public static void loginForWinxin(final Activity mActivity) {
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
                Toast.makeText(defActivity, "开始", Toast.LENGTH_LONG).show();
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
                System.out.println("jk===================="+"AA:" + name + "  " + iconurl);
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

                Toast.makeText(mActivity, "网络异常：" + t.getMessage(), Toast.LENGTH_LONG).show();
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
        mShareAPI.getPlatformInfo(mActivity, SHARE_MEDIA.WEIXIN, umAuthListener);
    }

    public static void toRegister(final Activity mActivity,String username,String password,String ext_token){
        CardLetterRequestApi.getInstance().getUserInfo(Constant.Access_Token,username,password,ext_token,new HttpSubscriber<LoginEntity>(new SubscriberOnListener<LoginEntity>() {
            @Override
            public void onSucceed(LoginEntity data) {
                if (data.getCode() == 0){


                }else {
                    ToastUtils.makeShortText(data.getMsg(),mActivity);
                }
            }

            @Override
            public void onError(int code, String msg) {
                ToastUtils.makeShortText(msg,mActivity);
            }
        },mActivity));
    }
}
