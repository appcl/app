package com.mt.cardletter.activity.bank;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.BaseActivity;

/**
 * Date:2018/1/14
 * Time:13:42
 * author:demons
 */

public class SHWebActiviy extends BaseActivity{

    private WebView webView;
    private String sid,item_id;
    private String url;

    @Override
    protected int getLayoutResId() {
        getDatas();
        return R.layout.mail_layout;
    }

    private void getDatas() {
        Bundle bundle = getIntent().getExtras();
        sid = bundle.getString("sid");
        item_id = bundle.getString("item_id");
        url = "https://w.mail.qq.com/cgi-bin/mobile?" +
                "sid="+sid +
                "&t=phone#mail,search_%E4%BF%A1%E7%94%A8%E5%8D%A1%E7%94%B5%E5%AD%90_all%5F%5F,"+item_id;
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
            Dialog progressDialog = ProgressDialog.show(SHWebActiviy.this, null, "正在加载...");

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //编写 javaScript方法
//                String javascript =  "javascript:function hideOther() {" +
//                        "document.getElementsByTagName('body')[0].innerHTML;" +
//                        "document.getElementsByTagName('div')[0].style.display='none';" +
//                        "document.getElementsByTagName('div')[3].style.display='none';" +
//                        "document.getElementsByClassName('dropdown')[0].style.display='none';" +
//                        "document.getElementsByClassName('min')[0].remove();" +
//                        "var divs = document.getElementsByTagName('div');" +
//                        "var lastDiv = divs[divs.length-1];" +
//                        "lastDiv.remove();" +
//                        "document.getElementsByClassName('showme')[0].remove();" +
//                        "document.getElementsByClassName('nei-t3')[1].remove();}";
//                //创建方法
//                view.loadUrl(javascript);
//
//                //加载方法
//                view.loadUrl("javascript:hideOther();");
                progressDialog.cancel();
//                System.out.println("-----登录成功-----");
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressDialog.show();
            }
        });
        System.out.println("url----------"+url);
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
