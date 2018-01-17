package com.mt.cardletter.activity.bank;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.BaseActivity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Date:2018/1/14
 * Time:13:42
 * author:demons
 */

public class SHWebActiviy extends BaseActivity{

    private WebView webView;
    private String sid,item_id;
    private String url;
    private TextView mail_tv;
    ExecutorService mThreadPool = Executors.newSingleThreadExecutor();

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
    String CookieStr;
    String[] split_str;
    String[] str_arr;
    Map<String ,String> map =  new HashMap<String, String>();
    @Override
    public void initView() {
        webView = (WebView) findViewById(R.id.mail_web);
        mail_tv= (TextView) findViewById(R.id.mail_tv);
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
        webView.addJavascriptInterface(new InJavaScriptLocalObj(), "java_obj");
        webView.setWebViewClient(new WebViewClient() {
            Dialog progressDialog = ProgressDialog.show(SHWebActiviy.this, null, "正在加载...");

            @Override
            public void onPageFinished(WebView view, final String url) {
                view.loadUrl("javascript:window.java_obj.getSource(document.documentElement.outerHTML);void(1)");
//                view.loadUrl("javascript:window.java_obj.getSource('<body>'+" +
//                        "document.getElementsByTagName('html')[1].outerHTML+'</body>');");
                super.onPageFinished(view, url);
//                CookieManager cookieManager = CookieManager.getInstance();
//                CookieStr = cookieManager.getCookie(url);
//                if (CookieStr != null) {
//                    System.out.println("cookie:-----------"+CookieStr);
//                    split_str=CookieStr.split(";");
//                    for (int i=0;i<split_str.length;i++){
//                        str_arr=split_str[i].split("=");
//                        for (int k = 0;k<str_arr.length-1;k+=2){
//                            map.put(str_arr[k],str_arr[k+1]);
//                        }
//                    }
//                }
                System.out.println("-------onPageFinished-------"+url);
                progressDialog.cancel();
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressDialog.show();
            }

//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, final String url) {
//                System.out.println("-----shouldOverrideUrlLoading-----"+url);
//                if (!TextUtils.isEmpty(url)&&url.contains("search")) {
//                    if (url.contains("search")){
//                        mThreadPool.execute(new Runnable() {
//                            @Override
//                            public void run() {
//                                try {
//                                    //从一个URL加载一个Document对象。
//                                    System.out.println("URL---"+url+"\n"+"-----sid------"+map.get("sid"));
//                                    Document doc = Jsoup.connect(url).cookies(map).get();
//                                    doc.getAllElements();
//                                    //选择“span.STYLE7”所在节点
//                                    Elements notices = doc.select("span.STYLE7");
//                                    for (int i = 0;i<notices.size();i++){
//                                        Element statement_date = notices.get(i);
//                                    }
//                                }catch (Exception e){
//                                    e.printStackTrace();
//                                }
//                            }
//                        });
//                    }
//                    return true;
//                }else {
//                    return false;
//                }
//            }
        });
        System.out.println("url----------"+url);
        webView.loadUrl(url);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {      //判断标志位
                case 1:
                    /**
                     获取数据，更新UI
                     */
                    formatDatas(msg.obj.toString());
                    CharSequence charSequence;
                    String content = msg.obj.toString();
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                        charSequence = Html.fromHtml(content,Html.FROM_HTML_MODE_LEGACY);
                    } else {
                        charSequence = Html.fromHtml(content);
                    }
                    mail_tv.setText(charSequence);
                    System.out.println("jk----:"+mail_tv.getText());
                    break;
                case 2:
//                    mail_tv.setText(msg.obj.toString());
            }
        }
    };

    /**
     * 解析html内容
     */
    private void formatDatas(final String str) {
        mThreadPool.execute(new Runnable() {

            @Override
            public void run() {
                //从全局池中返回一个message实例，避免多次创建message（如new Message）
                Document doc = Jsoup.parse(str.toString());
                Elements elements = doc.select("span.STYLE9");
                String style_7 ;
                for (Element element:elements){
                    style_7=element.text();
                    System.out.println("style_7------"+style_7);
                }
//                Message msg =Message.obtain();
//                msg.obj = style_7;
//                msg.what=2;   //标志消息的标志
//                handler.sendMessage(msg);
//                for (int i = 0;i<notices.size();i++){
//                    Element statement_date = notices.get(i);
//                    BankItemEntity.NoticsData notice = new BankItemEntity.NoticsData();
//                    notice.set
//                }
            }
        });
    }


    public final class InJavaScriptLocalObj {
        //一定也要加上这个注解,否则没有用
        @JavascriptInterface
        public void getSource(String html) {
            //取出HTML中P标签的文本内容,利用正则表达式匹配.
            Pattern pattern= Pattern.compile("<table.*?>(.*?)</table>");
            Matcher matcher = pattern.matcher(html);
            StringBuffer sb=new StringBuffer();
            while (matcher.find())
            {
                sb.append(matcher.group(1));
            }
//            CharSequence charSequence;
//            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
//                charSequence = Html.fromHtml(sb.toString(),Html.FROM_HTML_MODE_LEGACY);
//            } else {
//                charSequence = Html.fromHtml(sb.toString());
//            }
            Message msg =Message.obtain();
            msg.obj = sb;
            msg.what=1;   //标志消息的标志
            handler.sendMessage(msg);
            System.out.println("---------"+sb.toString());
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
}
