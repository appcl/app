package com.mt.cardletter.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mt.cardletter.R;

/**
 * Date:2018/1/14
 * Time:19:59
 * author:demons
 */

public class BankJFWebViewActivity extends BaseActivity {
    private WebView webView;
    private String url;

    @Override
    protected int getLayoutResId() {
        getDatas();
        return R.layout.mail_layout;
    }

    private void getDatas() {
        Bundle b = getIntent().getExtras();
        url=b.getString("url");
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
        webView.setWebViewClient(new WebViewClient() {
            Dialog progressDialog = ProgressDialog.show(BankJFWebViewActivity.this, null, "正在加载...");

            @Override
            public void onPageFinished(WebView view, String url) {
                CookieManager cookieManager = CookieManager.getInstance();
                String CookieStr = cookieManager.getCookie(url);
                if (CookieStr != null) {
                    System.out.println("cookie:-----------" + CookieStr);
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
        });
        webView.loadUrl(url);
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
}
