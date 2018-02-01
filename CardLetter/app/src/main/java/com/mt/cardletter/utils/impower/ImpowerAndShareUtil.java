package com.mt.cardletter.utils.impower;

import android.app.Activity;
import android.app.Dialog;
import android.widget.LinearLayout;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.LoginActivity;
import com.mt.cardletter.entity.user.LoginEntity;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.SharedPreferences;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.view.dialog.loadingdialog.view.LoadingDialog;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
/**
 * Created by jk on 2018/1/27.
 * 第三方分享与授权登录帮助类
 */

public class ImpowerAndShareUtil {
    private static Dialog mLoadingDialog;
    /**
     *
     * @param activity finish
     * @param mode  Wechat.NAME  QQ.NAME  SinaWeibo.NAME
     * @param a 授权反授权标志位
     */
    public static void impower(final Activity activity, final String mode, int a){
        System.out.println("jk========"+"进入授权");

        Platform platform = ShareSDK.getPlatform(mode);
        SharedPreferences.getInstance().putString("impower_mode",mode);
        platform.SSOSetting(false);  //设置false表示使用SSO授权方式
        if (a == 0){
            //回调信息，可以在这里获取基本的授权返回的信息，但是注意如果做提示和UI操作要传到主线程handler里去执行
            platform.setPlatformActionListener(new PlatformActionListener() {
                @Override
                public void onError(Platform arg0, int arg1, Throwable arg2) {
                    ToastUtils.makeShortText("请下载新版本QQ软件",activity);
                    arg2.printStackTrace();
                }

                @Override
                public void onComplete(Platform platform, int action, HashMap<String, Object> res) {
                    // TODO Auto-generated method stub
                    //输出所有授权信息
                    System.out.println("jk=====授权成功");
                    //用户资源都保存到res
                    //通过打印res数据看看有哪些数据是你想要的
                    if (action == Platform.ACTION_USER_INFOR) {
                        PlatformDb platDB = platform.getDb();//获取数平台数据DB
                        //通过DB获取各种数据
                        String token = platDB.getToken();
                        String userGender = platDB.getUserGender();
                        String userIcon = platDB.getUserIcon();
                        String userId = platDB.getUserId();
                        String userName = platDB.getUserName();
                        System.out.println("jk===="+token+"--"+userGender+"---"+userIcon+"---"+userId+"---"+userName);
                        //设置第三方名字,头像,第三方id
                        SharedPreferences.getInstance().putString("nick_name",userName);
                        SharedPreferences.getInstance().putString("url",userIcon);
                        SharedPreferences.getInstance().putString("ext_token", userId);
                        SharedPreferences.getInstance().putBoolean("isLogin",true);
                        System.out.println("jk----"+userName+"-------"+userId);
                        //toLogin(activity,userName,userId.substring(0,6),userId);
                        activity.finish();
                    }
                }

                @Override
                public void onCancel(Platform arg0, int arg1) {
                    // TODO Auto-generated method stub

                }
            });
            //weibo.authorize();单独授权,OnComplete返回的hashmap是空的
            platform.showUser(null);//授权并获取用户信息
        } else if (a == 1){
            if (SharedPreferences.getInstance().getString("impower_mode","").equals("")){
                System.out.println("jk===解除授权失败");
            }else{
                //移除授权
                platform.removeAccount(true);
            }

        }
    }
    /**
     * 静默注册
     */
    private static void toLogin(final Activity activity, final String username, final String password, final String ext_token) {
        CardLetterRequestApi.getInstance().getUserInfo(Constant.Access_Token, username, password,ext_token, new HttpSubscriber<LoginEntity>(new SubscriberOnListener<LoginEntity>() {
            @Override
            public void onSucceed(LoginEntity data) {
                System.out.println("jk------"+"进入0"+data.getMsg()+"---getMemberId-"+data.getData().getMemberId());
                if (data.getCode() == 0) {
                    System.out.println("jk------"+"进入1");
                    String memberId = data.getData().getMemberId();
                    String user_token = data.getData().getUserToken();
                    SharedPreferences.getInstance().putString("account", username);
                    SharedPreferences.getInstance().putString("password", password);
                    SharedPreferences.getInstance().putString("user_token", user_token);
                    SharedPreferences.getInstance().putString("member_id", memberId);
                    System.out.println("jk------"+"进入2");
//                    activity.finish();
                } else {
                    ToastUtils.makeShortText("网络故障", activity);
                }
            }

            @Override
            public void onError(int code, String msg) {
                //ToastUtils.makeShortText("网络故障", activity);
            }
        }, activity));
    }
}


