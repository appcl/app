package com.mt.cardletter.activity;

import android.os.Message;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;

public class NetNewsActivity extends BaseActivity {
    private WebView webView;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_net_news;
    }

    @Override
    public void initView() {
        webView = (WebView) findViewById(R.id.news_web);
        System.out.println("jk======================"+webView.getId());
        //String net_url = getIntent().getStringExtra("net_url");
        //if (net_url!=null){
            //loadData(net_url);
       // }
        loadData("-");
    }

    private void loadData(String net_url) {
        //加载访问地址   https://news.sina.cn/gj/2018-01-11/detail-ifyqptqv7656340.d
        webView.loadUrl("https://www.toutiao.com/i6510727274914906627/");
        // 支持JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
        //设置webView支持缩放
        webView.getSettings().setBuiltInZoomControls(true);
        //支持保存数据
        webView.getSettings().setSaveFormData(true);
        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        webView.getSettings().setSupportZoom(true);//是否可以缩放，默认true
        webView.getSettings().setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
        webView.getSettings().setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        webView.getSettings().setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        webView.getSettings().setAppCacheEnabled(true);//是否使用缓存
        webView.getSettings().setDomStorageEnabled(true);//DOM Storage
         //displayWebview.getSettings().setUserAgentString("User-Agent:Android");//设置用户代理，一般不用
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
