package com.mt.cardletter.activity.comment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.BankJFWebViewActivity;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.view.animview.AnimDialog;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshBase;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshScrollView;

/**/
public class CreditWebActivity extends BaseActivity {
    private WebView wv;
    private String url;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_credit;
    }

    @Override
    public void initView() {
        setSwipeBackEnable(false);//禁止侧滑退出
        wv = (WebView) findViewById(R.id.credit_web);
        url = "http://banka.51kahui.com/";

        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);


        final AnimDialog dialog = AnimDialog.newInstance();
        dialog.show(this.getSupportFragmentManager());
        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                System.out.println("jk1-------接受信任所有网站的证书");
                handler.proceed();  // 接受信任所有网站的证书
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                System.out.println("jk1----" + url);
                wv.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                // 开始加载网页
                System.out.println("jk1-------1");

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                // 网页加载完成
                System.out.println("jk1-------2");
                dialog.dissmissDialog();
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                // 加载网页失败
                System.out.println("jk1-------加载网页失败");
            }
        });

        wv.loadUrl(url);

    }

    @Override
    public void initListener() {

    }

    @Override
    public boolean
    onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK&& wv.canGoBack()){
            wv.goBack();//返回上个页面
            System.out.println("jk1-----返回上一页");
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
    @Override
    protected void initData() {

    }

    @Override
    protected void handler(Message msg) {

    }
}
