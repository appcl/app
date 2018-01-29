package com.mt.cardletter.utils.impower;

import android.app.Activity;

import com.mt.cardletter.utils.SharedPreferences;

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
                    System.out.println("jk=====授权失败");
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
                        //设置第三方名字和头像
                        SharedPreferences.getInstance().putString("nick_name",userName);
                        SharedPreferences.getInstance().putString("url",userIcon);
                    }
                    SharedPreferences.getInstance().putBoolean("isLogin",true);
                    activity.finish();
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
}
