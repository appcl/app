package com.mt.cardletter.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.mt.cardletter.MainActivity;
import com.mt.cardletter.activity.AboutActivity;
import com.mt.cardletter.activity.ArticleActivity;
import com.mt.cardletter.activity.ExpressActivity;
import com.mt.cardletter.activity.ExpressDetailActivity;
import com.mt.cardletter.activity.LoactionActivity;
import com.mt.cardletter.activity.LoginActivity;
import com.mt.cardletter.activity.MakeIntegralActivity;
import com.mt.cardletter.activity.MessageActivity;
import com.mt.cardletter.activity.RegisterActivity;
import com.mt.cardletter.activity.ScreenActivity;
import com.mt.cardletter.activity.SearchActivity;
import com.mt.cardletter.activity.SearchClassicActivity;
import com.mt.cardletter.activity.SearchIntegralActivity;
import com.mt.cardletter.activity.ViolateActivity;
import com.mt.cardletter.activity.ViolateDetailActivity;
import com.mt.cardletter.activity.WeatherActivity;
import com.mt.cardletter.activity.WebView_QQActivity;
import com.mt.cardletter.activity.bank.SHActivity;
import com.mt.cardletter.activity.seckill.SeckillActivity;
import com.mt.cardletter.activity.setting.SettingActivity;
import com.mt.cardletter.activity.setting.SettingMsgActivity;
import com.mt.cardletter.entity.article.ArticleBean;
import com.mt.cardletter.entity.bank.BankEntity;
import com.mt.cardletter.entity.data.HeWeather;
import com.mt.cardletter.entity.data.ViolateData;
import com.mt.cardletter.entity.express.Express_Content;

import java.io.Serializable;
import java.util.List;


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

//    /**
//     * 查积分
//     * @param context
//     */
//    public static void showSearchIntegralActivity(Context context) {
//        Intent intent = new Intent(context, SearchIntegralActivity.class);
//        context.startActivity(intent);
//    }
    public static void showViolateActivity(Context context){
        Intent intent = new Intent(context, ViolateActivity.class);
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
    /**
     * 分类搜索
     * @param context
     */
    public static void showSeckillActivity(Context context) {
        Intent intent = new Intent(context, SeckillActivity.class);
        context.startActivity(intent);
    }

    /**
     * 天气
     * @param activity
     * @param weatherbean
     */
    public static void showWeather(Context activity,String city, HeWeather.HeWeather6Bean weatherbean){
        Intent intent = new Intent(activity, WeatherActivity.class);
        intent.putExtra("city",city);
        intent.putExtra("weatherbean",  weatherbean);
        activity.startActivity(intent);
    }

    /**
     * 设置
     * @param context
     */
    public static void showSetting(Context context){
        Intent intent = new Intent(context, SettingActivity.class);
        context.startActivity(intent);
    }

    /**
     * 修改个人设置
     * @param context
     */
    public static void showSettingMsg(Context context) {
        Intent intent = new Intent(context, SettingMsgActivity.class);
        context.startActivity(intent);
    }

    /**
     * 筛选
     * @param context
     */
    public static void showScreenActivity(Context context) {
        Intent intent = new Intent(context, ScreenActivity.class);
        context.startActivity(intent);
    }

    /**
     * 违章详情
     * @param context
     * @param violate_list
     */
    public static void showViolateDetailActivity(Context context, List<ViolateData.ResultBean.ListsBean> violate_list){
        Intent intent = new Intent(context, ViolateDetailActivity.class);
        intent.putExtra("list", (Serializable) violate_list);
        context.startActivity(intent);
    }
    /**
     * 商品详情
     * @param context
     * @param intent
     */
    public static void showDetails(Context context,Intent intent) {
        context.startActivity(intent);
    }

    /**
     * 关于
     * @param context
     */
    public static void showAboutActivity(Context context) {
        Intent intent = new Intent(context, AboutActivity.class);
        context.startActivity(intent);
    }

    /**
     * 消息
     * @param context
     */
    public static void showMessageActivity(Context context) {
        Intent intent = new Intent(context, MessageActivity.class);
        context.startActivity(intent);
    }

    /**
     * 注册
     * @param context
     */
    public static void showRegisterActivity(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);

    }

    /**
     * 头条
     * @param context
     * @param bean
     */
    public static void showArticleActivity(Context context, ArticleBean.DataBeanX.DataBean bean){
        Intent intent = new Intent(context, ArticleActivity.class);
        intent.putExtra("bean", (Serializable) bean);
        context.startActivity(intent);
    }

    /**
     * 订单
     * @param context
     */
    public static void showExpressActivity(Context context){
        Intent intent = new Intent(context, ExpressActivity.class);
        context.startActivity(intent);
    }

    public static void showExpressDetailActivity(Activity context, Express_Content.ResultBean resultBean){
        Intent intent = new Intent(context, ExpressDetailActivity.class);
        intent.putExtra("resultBean", (Serializable) resultBean);
        context.startActivity(intent);
    }

    /**
     * 地理位置
     */
    public static void showLocationActivity(Context context){
        Intent intent = new Intent(context, LoactionActivity.class);
        context.startActivity(intent);
    }

    /**
     * QQ邮箱H5页面
     * @param context
     */
    public static void showQQH5(Context context){
        Intent intent = new Intent(context, WebView_QQActivity.class);
        context.startActivity(intent);
    }

    public static void showSearchActivity(Context context){
        Intent intent = new Intent(context, SearchActivity.class);
        context.startActivity(intent);
    }

    public static void showSHActivity(Context context, String sid,List<BankEntity.BankBean.ShListBean> sh_list)
    {
        Intent intent = new Intent(context, SHActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("sid",sid);
        intent.putExtras(bundle);
        intent.putExtra("sh_list", (Serializable) sh_list);
        context.startActivity(intent);
    }



    public static void showSearchIntegralActivity(Context context){
        Intent intent = new Intent(context, SearchIntegralActivity.class);
        context.startActivity(intent);
    }
}
