package com.mt.cardletter.activity;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Message;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.view.animview.AnimDialog;

/**
 * Date:2018/1/14
 * Time:19:59
 * author:demons
 */

public class BankJFWebViewActivity extends BaseActivity {
    private WebView webView;
    private WebView wv;
    private String url;
    @Override
    protected int getLayoutResId() {
        getDatas();
        return R.layout.jifen_webview;
    }

    private void getDatas() {
        Bundle b = getIntent().getExtras();
        url=b.getString("url");
    }
    @Override
    public void initView() {
        wv = (WebView) findViewById(R.id.mail_web);
        wv.loadUrl(url);

        WebSettings webSettings = wv .getSettings();
        webSettings.setJavaScriptEnabled(true); //支持js
        //webSettings.setPluginState(WebSettings.PluginState.ON);//支持插件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。 这个取决于setSupportZoom(), 若setSupportZoom(false)，则该WebView不可缩放，这个不管设置什么都不能缩放。
        webSettings.setDisplayZoomControls(true); //隐藏原生的缩放控件

        final AnimDialog dialog = AnimDialog.newInstance();
        dialog.show(BankJFWebViewActivity.this.getSupportFragmentManager());
        wv.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                System.out.println("jk-------接受信任所有网站的证书");
                handler.proceed();  // 接受信任所有网站的证书
                // handler.cancel();   // 默认操作 不处理
                // handler.handleMessage(null);  // 可做其他处理
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                wv.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                // 开始加载网页
                System.out.println("jk-------1");

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // 网页加载完成
                System.out.println("jk-------2");
                dialog.dissmissDialog();
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                // 加载网页失败
                System.out.println("jk-------加载网页失败");

            }
        });
    }
//    @Override
//    public void initView() {
//        System.out.println("url------"+url);
//        webView = (WebView) findViewById(R.id.mail_web);
////        js=new JavaScriptQQ(this);
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setDomStorageEnabled(true);
//        webSettings.setLoadWithOverviewMode(true);// 缩放至屏幕的大小
//        webSettings.setUseWideViewPort(true);//将图片调整到适合webview的大小
//        webSettings.setJavaScriptEnabled(true);
//        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
//        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
////        webView.addJavascriptInterface(js,"pt");
//        /**
//         *
//         */
//        // 设置可以支持缩放
//        //webview.getSettings().setSupportZoom(true);
//        // 设置出现缩放工具
//        webView.getSettings().setBuiltInZoomControls(true);
//        // 为图片添加放大缩小功能
//        webView.getSettings().setUseWideViewPort(true);
//        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//        webView.setWebViewClient(new WebViewClient() {
////            Dialog progressDialog = ProgressDialog.show(BankJFWebViewActivity.this, null, "正在加载...");
//            AnimDialog dialog = AnimDialog.newInstance();
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                CookieManager cookieManager = CookieManager.getInstance();
//                String CookieStr = cookieManager.getCookie(url);
//                if (CookieStr != null) {
//                    System.out.println("cookie:-----------" + CookieStr);
//                }
//                super.onPageFinished(view, url);
////                progressDialog.cancel();
//                dialog.dissmissDialog();
//                System.out.println("-----登录成功-----");
//            }
//
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                super.onPageStarted(view, url, favicon);
//                dialog.show(BankJFWebViewActivity.this.getSupportFragmentManager());
//            }
//        });
//        webView.loadUrl(url);
//    }

    @Override
    public void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void handler(Message msg) {

    }
}
