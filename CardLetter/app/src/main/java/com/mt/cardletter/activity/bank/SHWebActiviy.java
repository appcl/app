package com.mt.cardletter.activity.bank;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.BaseActivity;
import com.mt.cardletter.adapter.PayAdapter;
import com.mt.cardletter.entity.bank.Jt_BankEntity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private TextView provioue_tv,current_tv,pay_tv,other_tv,total_due_tv,min_pay_tv;
    private FrameLayout back;
    private TextView title_name;
    ExecutorService mThreadPool = Executors.newSingleThreadExecutor();
    private ListView listView;
    private PayAdapter adapter;
    private TextView jf_tv;

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
        System.out.println("----"+url);
    }
    String CookieStr;
    String[] split_str;
    String[] str_arr;
    Map<String ,String> map =  new HashMap<String, String>();
    @Override
    public void initView() {
        webView = (WebView) findViewById(R.id.mail_web);
//        mail_tv= (TextView) findViewById(R.id.mail_tv);
//        js=new JavaScriptQQ(this);
        back = (FrameLayout) findViewById(R.id.com_back_click);
        back.setVisibility(View.VISIBLE);
        title_name = (TextView) findViewById(R.id.title_name);
        title_name.setText("账单详情");

        provioue_tv = (TextView) findViewById(R.id.previous_tv);
        current_tv = (TextView) findViewById(R.id.current_tv);
        pay_tv = (TextView) findViewById(R.id.pay_tv);
        other_tv = (TextView) findViewById(R.id.other_tv);
        total_due_tv = (TextView) findViewById(R.id.total_due_tv);
        min_pay_tv = (TextView) findViewById(R.id.min_pay_tv);

        jf_tv = (TextView) findViewById(R.id.jf_tv);

        listView = (ListView) findViewById(R.id.paylist);


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

        });
        System.out.println("url----------"+url);
        webView.loadUrl(url);
    }

    public static void getString(String str) {
        String filePath = null;
        boolean hasSDCard = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if (hasSDCard) {
            filePath =Environment.getExternalStorageDirectory().toString() + File.separator +"上海银行.txt";
        } else
            filePath =Environment.getDownloadCacheDirectory().toString() + File.separator +"上海银行.txt";

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
                    break;
                case 2:
                    System.out.println("------集合大小------"+jt_list.size());
                    provioue_tv.setText(jt_bankEntity.getPayMoney().getPrevious_bill_amount());
                    current_tv.setText(jt_bankEntity.getPayMoney().getCurrent_bill_amount());
                    pay_tv.setText(jt_bankEntity.getPayMoney().getPay_amount());
                    other_tv.setText(jt_bankEntity.getPayMoney().getOther_amout());
                    total_due_tv.setText(jt_bankEntity.getPayMoney().getTotal_due_amount());
                    min_pay_tv.setText(jt_bankEntity.getPayMoney().getMin_payment_amount());

                    jf_tv.setText(jifen_text);

                    adapter = new PayAdapter(SHWebActiviy.this,payRecordList);
                    listView.setAdapter(adapter);
                    break;
            }
        }
    };


    Jt_BankEntity.PayMoney payMoney ;
    Jt_BankEntity.PayRecord payRecord;
    List<Jt_BankEntity> jt_list = new ArrayList<>();
    Jt_BankEntity jt_bankEntity = new Jt_BankEntity();
    List<Jt_BankEntity.PayRecord> payRecordList = new ArrayList<>();
    private String jifen_text;
    int m = 0;
    /**
     * 解析html内容
     */
    private void formatDatas(final String str) {
        mThreadPool.execute(new Runnable() {

            @Override
            public void run() {
                //从全局池中返回一个message实例，避免多次创建message（如new Message）
//                getString(str.toString());
                Document doc = Jsoup.parse(str.toString());

//                Elements elements_style_9 = doc.select("span.STYLE9");
//                String style_9 ;
//                for (Element element:elements_style_9){
//                    style_9=element.text();
//                    System.out.println("style_9------"+style_9);
//                }
//
//                Elements elements_style7 = doc.select("span.STYLE7");
//                String style_7 ;
//                for (Element element:elements_style7){
//                    style_7=element.text();
//                    System.out.println("style_7------"+style_7);
//                }

//                Elements tr_elements = doc.select("tr");
//                for (int i = 0 ;i<tr_elements.size();i++){
//                    System.out.println(i+"----------"+tr_elements.get(i).text());
//                }

                Elements tbody =doc.getElementsByTag("tr");
                Elements td = tbody.eq(7);
                Elements elements = td.get(0).getElementsByClass("STYLE9");
                    payMoney = new Jt_BankEntity.PayMoney();
                    payMoney.setPrevious_bill_amount(elements.get(3).text());
                    payMoney.setCurrent_bill_amount(elements.get(5).text());
                    payMoney.setPay_amount(elements.get(7).text());
                    payMoney.setOther_amout(elements.get(9).text());
                    payMoney.setTotal_due_amount(elements.get(11).text());
                    payMoney.setMin_payment_amount(elements.get(13).text());
                    jt_bankEntity.setPayMoney(payMoney);
                    jt_list.add(jt_bankEntity);
                Elements details = doc.getElementsByTag("tbody");
                Elements tbody_detais = details.eq(7);
                Elements tr_elements = tbody_detais.get(0).getElementsByClass("STYLE9");
                for (int j = 1;j<tr_elements.size();j+=10){
                    payRecord = new Jt_BankEntity.PayRecord();
                    System.out.println("---"+j+"---"+tr_elements.get(j).text());
                    payRecord.setTrans_date(tr_elements.get(j).text());
                    payRecord.setPost_date(tr_elements.get(j+2).text());
                    payRecord.setDesc(tr_elements.get(j+4).text());
                    payRecord.setAmount(tr_elements.get(j+6).text());
                    payRecord.setCardNum(tr_elements.get(j+8).text());
                    payRecordList.add(payRecord);
                    jt_bankEntity.setPayRecord(payRecordList);
                }

                Elements jifen = details.eq(13);
                Elements jifen_elements = jifen.get(0).getElementsByClass("STYLE9");
                jifen_text = jifen_elements.eq(11).text();

                Message msg =Message.obtain();
                msg.what=2;   //标志消息的标志
                handler.sendMessage(msg);
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
            Message msg =Message.obtain();
            msg.obj = sb;
            msg.what=1;   //标志消息的标志
            handler.sendMessage(msg);
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
