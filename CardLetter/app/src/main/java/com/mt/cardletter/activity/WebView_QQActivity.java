package com.mt.cardletter.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.https.JavaScriptQQ;
import com.mt.cardletter.utils.Constant;

import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Date:2018/1/10
 * Time:13:44
 * author:demons
 */

public class WebView_QQActivity extends BaseActivity {

    private WebView webView;
    private JavaScriptQQ js;
    private String CookieStr,sid;
    ExecutorService mThreadPool = Executors.newSingleThreadExecutor();

    @Override
    protected int getLayoutResId() {
        return R.layout.web_login_layout;
    }

    @Override
    public void initView() {
        webView = (WebView) findViewById(R.id.mail_web);
//        js=new JavaScriptQQ(this);
        WebSettings webSettings = webView.getSettings();
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);// 缩放至屏幕的大小
        webSettings.setUseWideViewPort(true);//将图片调整到适合webview的大小
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
//        webView.addJavascriptInterface(js,"pt");
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient(){
            Dialog progressDialog= ProgressDialog.show(WebView_QQActivity.this,null,"正在加载...");
            @Override
            public void onPageFinished(WebView view, String url) {
                CookieManager cookieManager = CookieManager.getInstance();
                CookieStr = cookieManager.getCookie(url);
                if (CookieStr != null) {
                    System.out.println("cookie:-----------"+CookieStr);
//                    getString(CookieStr);
                    getBillDatas(sid,CookieStr);
//                    Message msg =Message.obtain();
//                    msg.what=2;   //标志消息的标志
//                    handler.sendMessage(msg);
                }
                super.onPageFinished(view, url);
                progressDialog.cancel();
                System.out.println("-----登录成功-----");
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressDialog.show();
            }

            /**
             * url重定向会执行此方法以及点击页面某些链接也会执行此方法
             * @param view
             * @param url
             *             即将重定向的url
             * @return
             *          表示当前url已经加载完成，即使url还会重定向都不会再进行加载 false 表示此url默认由系统处理，该重定向还是重定向，直到加载完成
             */
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                System.out.println("-----shouldOverrideUrlLoading-----"+url);
                if (!TextUtils.isEmpty(url)&&url.contains("https://w.mail.qq.com/cgi-bin/mobile?sid=")||
                        !TextUtils.isEmpty(url)&&url.contains("https://w.mail.qq.com/cgi-bin/today?sid=")) {
                    sid = url.substring(url.indexOf("sid=")+4,url.lastIndexOf(".&")+1);
                    System.out.println("----aaaaaa------"+sid);
//                    getDatas(sid);
                    return true;
                } else {
                    return false;
                }
            }
        });

        webView.loadUrl(Constant.QQ_MAIN);
    }

    public static void getString(String str) {
        String filePath = null;
        boolean hasSDCard = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if (hasSDCard) {
            filePath =Environment.getExternalStorageDirectory().toString() + File.separator +"cookie.txt";
        } else
            filePath =Environment.getDownloadCacheDirectory().toString() + File.separator +"cookie.txt";

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                File dir = new File(file.getParent());
                dir.mkdirs();
                file.createNewFile();
            }
            FileOutputStream outStream = new FileOutputStream(file);
            outStream.write(str.getBytes());
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void initListener() {

    }

    @Override
    protected void initData() {
    }

    @Override
    protected void handler(Message msg) {

    }

    private void getBillDatas(String sid, String cookieStr){
        Intent i = new Intent(WebView_QQActivity.this, BillActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("sid",sid);
        bundle.putString("cookieStr",cookieStr);
        i.putExtras(bundle);
        startActivity(i);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {      //判断标志位
                case 1:
                    break;
                case 2:
                    break;
            }
        }
    };
    /*
        * 将时间戳转换为时间
        */
    public static String  dateToUTC(){
        return String.valueOf((int)(System.currentTimeMillis()/1000));
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();// 返回前一个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
