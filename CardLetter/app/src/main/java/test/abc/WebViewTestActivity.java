package test.abc;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;

/**
 * Created by Administrator on 2018/1/30.
 */
/*
        String url = "https://www.baidu.com/";
        OkHttpClient okHttpClient = new OkHttpClient();

        RequestBody body = new FormBody.Builder()
                .add("键", "值")
                .add("键", "值")

        .build();

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }


    构建 Web 应用的三个重要组件

    WebView: 主要负责解析和渲染网页
    WebViewClient: 辅助WebView处理各种通知和请求事件
    WebChromeClient: 辅助WebView处理JavaScript中的对话框, 网址图标和标题等

 */
public class WebViewTestActivity extends BaseActivity {
    private WebView wv;
    @Override
    protected int getLayoutResId() {
        return R.layout.web_test;
    }

    @Override
    public void initView() {
        String url = "https://creditcards.hsbc.com.cn/mall/weiproduct/weiProductDetail.action?product.id=49731";
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
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                // 加载网页失败
                System.out.println("jk-------加载网页失败");
            }
        });
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
