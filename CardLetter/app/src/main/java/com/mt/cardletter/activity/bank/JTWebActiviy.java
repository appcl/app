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
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.adapter.PayAdapter;
import com.mt.cardletter.entity.bank.Bank_JT;

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

public class JTWebActiviy extends BaseActivity{

    private WebView webView;
    private String sid,item_id;
    private String url;
    private TextView mail_tv;
    private TextView hk_tv,current_tv,pay_tv,xy_tv,cash_tv;
    private FrameLayout back;
    private TextView title_name;
    ExecutorService mThreadPool = Executors.newSingleThreadExecutor();
    private ListView listView;
    private PayAdapter adapter;
    private TextView jf_tv;

    @Override
    protected int getLayoutResId() {
        getDatas();
        return R.layout.jt_layout;
    }

    private void getDatas() {
        Bundle bundle = getIntent().getExtras();
        sid = bundle.getString("sid");
        item_id = bundle.getString("jt_item_id");
        url = "https://w.mail.qq.com/cgi-bin/mobile?" +
                "sid="+sid +
                "&t=phone#mail,search_%E4%BF%A1%E7%94%A8%E5%8D%A1%E7%94%B5%E5%AD%90_all%5F%5F,"+item_id;
        System.out.println("----item_id----"+item_id+"\n"+sid);
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

        hk_tv = (TextView) findViewById(R.id.hk_tv);
        current_tv = (TextView) findViewById(R.id.current_tv);
        pay_tv = (TextView) findViewById(R.id.pay_tv);
        xy_tv = (TextView) findViewById(R.id.xy_tv);
        cash_tv = (TextView) findViewById(R.id.cash_tv);

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
            Dialog progressDialog = ProgressDialog.show(JTWebActiviy.this, null, "正在加载...");

            @Override
            public void onPageFinished(WebView view, final String url) {
                view.loadUrl("javascript:window.java_obj.getSource(document.documentElement.outerHTML);void(1)");
                super.onPageFinished(view, url);
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
            filePath =Environment.getExternalStorageDirectory().toString() + File.separator +"交通银行.txt";
        } else
            filePath =Environment.getDownloadCacheDirectory().toString() + File.separator +"交通银行.txt";

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
                    hk_tv.setText(bank_jt.getPayMoney().getDate_line());
                    current_tv.setText(bank_jt.getPayMoney().getTotal_due_amount());
                    pay_tv.setText(bank_jt.getPayMoney().getMin_payment_amount());
                    xy_tv.setText(bank_jt.getPayMoney().getCredit_line());
                    cash_tv.setText(bank_jt.getPayMoney().getCash_line());
//                    System.out.println("------集合大小------"+jt_list.size());
//                    provioue_tv.setText(jt_bankEntity.getPayMoney().getPrevious_bill_amount());
//                    current_tv.setText(jt_bankEntity.getPayMoney().getCurrent_bill_amount());
//                    pay_tv.setText(jt_bankEntity.getPayMoney().getPay_amount());
//                    other_tv.setText(jt_bankEntity.getPayMoney().getOther_amout());
//                    total_due_tv.setText(jt_bankEntity.getPayMoney().getTotal_due_amount());
//                    min_pay_tv.setText(jt_bankEntity.getPayMoney().getMin_payment_amount());
//
//                    jf_tv.setText(jifen_text);
//
//                    adapter = new PayAdapter(JTWebActiviy.this,payRecordList);
//                    listView.setAdapter(adapter);
                    break;
            }
        }
    };


//    Jt_BankEntity.PayMoney payMoney ;
//    Jt_BankEntity.PayRecord payRecord;
//    List<Jt_BankEntity> jt_list = new ArrayList<>();
//    Jt_BankEntity jt_bankEntity = new Jt_BankEntity();
//    List<Jt_BankEntity.PayRecord> payRecordList = new ArrayList<>();
//    private String jifen_text;
//    int m = 0;
//    /**
//     * 解析html内容
//     */
    Bank_JT.PayMoney payMoney ;
    Bank_JT bank_jt =new Bank_JT();
    Bank_JT.PayRecord payRecord;
    List<Bank_JT.PayRecord> payRecordList = new ArrayList<>();
    private void formatDatas(final String str) {
        mThreadPool.execute(new Runnable() {

            @Override
            public void run() {
                //从全局池中返回一个message实例，避免多次创建message（如new Message）
//                getString(str.toString());
                Document doc = Jsoup.parse(str.toString());
                Elements tbody = doc.select("tbody");
                System.out.println("一共有"+tbody.size());
                payMoney = new Bank_JT.PayMoney();
                Elements tr = tbody.get(2).select("tr");
                String td_0 = tr.get(0).select("td").get(0).text();
                String td_1 = tr.get(1).select("td").get(0).text();
                String td_2 = tr.get(2).select("td").get(0).text();
                String td_3 = tr.get(3).select("td").get(0).text();
                String td_4 = tr.get(4).select("td").get(0).text();
                System.out.println(td_0+"\n"+td_1+"\n"+td_2+"\n"+td_4);
                payMoney.setDate_line(td_0);
                payMoney.setTotal_due_amount(td_1);
                payMoney.setMin_payment_amount(td_2);
                payMoney.setCredit_line(td_3);
                payMoney.setCash_line(td_4);
                bank_jt.setPayMoney(payMoney);

                for (int i = 6 ;i<tbody.size()-5;i++){
                    System.out.println("---"+tbody.get(i).html());
                    payRecord = new Bank_JT.PayRecord();
                    Elements record_tr = tbody.get(i).select("tr");
                    for (int j = 0;j<record_tr.size();j++){
                        if (j==0){
                            Elements record_td = record_tr.get(1).select("td");
                            String jy_date = record_td.get(0).text();
                            String jz_date = record_td.get(1).text();
                            String jy_desc = record_td.get(2).text();
                            String jy_amout = record_td.get(3).text();
                            payRecord.setTrans_date(jy_date);
                            payRecord.setPost_date(jz_date);
                            payRecord.setDesc(jy_desc);
                            payRecord.setAmount(jy_amout);
                            System.out.println("第一条数据-----"+jy_date+"----"+jy_amout);
                            payRecordList.add(payRecord);
                        }else {
                            Elements record_td = record_tr.get(j).select("td");
                            String jy_date = record_td.get(0).text();
                            String jz_date = record_td.get(1).text();
                            String jy_desc = record_td.get(2).text();
                            String jy_amout = record_td.get(3).text();
                            payRecord.setTrans_date(jy_date);
                            payRecord.setPost_date(jz_date);
                            payRecord.setDesc(jy_desc);
                            payRecord.setAmount(jy_amout);
                            System.out.println("其他条数据-----"+jy_date+"----"+jy_amout);
                            payRecordList.add(payRecord);
                        }
                        System.out.println("一共----"+payRecordList.size());
                    }
                }
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
            System.out.println("----sb-----"+sb);
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
