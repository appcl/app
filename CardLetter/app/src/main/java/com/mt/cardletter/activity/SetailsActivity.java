package com.mt.cardletter.activity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.mt.cardletter.R;
import com.mt.cardletter.activity.setting.SettingActivity;
import com.mt.cardletter.activity.share.ShareActivity;
import com.mt.cardletter.entity.merchant.Good;
import com.mt.cardletter.entity.merchant.Goods;
import com.mt.cardletter.entity.merchant.GoodsBean;
import com.mt.cardletter.fragment.CompleteFragment;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.List;

/**
 * 商品详情
 */
public class SetailsActivity extends BaseActivity implements View.OnClickListener {
    private FrameLayout com_back_click;
    private TextView title_name;
    private TextView next;
    //private ImageView setails_back,setails_share;
    private TextView setails_title, setails_time, setails_tel, setails_address, setails_obj, setails_centent, setails_discounts;
    private ImageView bigImg ,item_bank;
    private RelativeLayout collect;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private String bank;
    private ImageView collect_img;
    private TextView collect_text;
    private String bank_url;
    private Good.DataBean good;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_setails;
    }

    @Override
    public void initView() {
        title_name = (TextView) findViewById(R.id.title_name);
        title_name.setText("商品详情");
        com_back_click = (FrameLayout) findViewById(R.id.com_back_click);
        com_back_click.setVisibility(View.VISIBLE);
        next = (TextView) findViewById(R.id.commonal_tv);
        next.setVisibility(View.VISIBLE);
        next.setText("分享");
        next.setTextColor(getResources().getColor(R.color.color_text_black_31));
        next.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                jurisdiction();//权限申请  分享入口
                //startActivity(new Intent(SetailsActivity.this, ShareActivity.class));
            }
        });
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setails_title = (TextView) findViewById(R.id.setails_title);
        setails_time = (TextView) findViewById(R.id.setails_dateline);
        setails_tel = (TextView) findViewById(R.id.setails_tel);
        setails_address = (TextView) findViewById(R.id.setails_address);
        setails_obj = (TextView) findViewById(R.id.setails_obj);
        setails_centent = (TextView) findViewById(R.id.setails_centent);
        setails_discounts = (TextView) findViewById(R.id.setails_discounts);
        bigImg = (ImageView) findViewById(R.id.setails_big_img);
        item_bank = (ImageView) findViewById(R.id.item_img);
        String cardfind_id = getIntent().getStringExtra("cardfind_id");
        bank = getIntent().getStringExtra("bank");
        bank_url = getIntent().getStringExtra("bank_url");
        if (cardfind_id != null) {
            loadData(cardfind_id);
        }
        collect = (RelativeLayout) findViewById(R.id.collection);
        collect_img = (ImageView) findViewById(R.id.pic_one);
        collect_text = (TextView) findViewById(R.id.pic_tow);
        collect.setOnClickListener(this);
    }

    private void loadData(String cardfind_id) {
        /*
         * 获取商家列表
         */
        CardLetterRequestApi.getInstance().getGoodDetails(Constant.Access_Token, cardfind_id, new HttpSubscriber<Good>(new SubscriberOnListener<Good>() {
            @Override
            public void onSucceed(Good data) {
                if (data.getCode() == 0) {
                    good = data.getData();
                    updataView(good);
                }
            }
            @Override
            public void onError(int code, String msg) {
                ToastUtils.showShort(SetailsActivity.this, msg);
            }
        }, SetailsActivity.this));
    }

    private void updataView(Good.DataBean good) {
        if (good != null) {
            if (good.getName() != null && good.getDeadline() != null
                    && good.getTel() != null && good.getAddress() != null
                    && good.getContent() != null && good.getDescribe() != null) {
                setails_title.setText(good.getName());
                setails_time.setText(good.getDeadline());
                setails_tel.setText(good.getTel());
                setails_address.setText(good.getAddress());
                setails_centent.setText(good.getContent());
                setails_discounts.setText(good.getDescribe());

                if (good.getThumb()!=null){
                    Glide.with(this).load(Constant.BASE_URL+good.getThumb()).error(R.drawable.default_error).into(bigImg);
                }
                if(bank!=null){
                    setails_obj.setText(bank);
                }
                if (bank_url!=null){
                    Glide.with(this).load(Constant.BASE_URL+bank_url).error(R.drawable.default_error).into(item_bank);
                }
            }
        } else {
            ToastUtils.showShort(getApplicationContext(), "数据异常，请检测网络");
        }
    }

    @Override
    protected void initData() {


    }
    private boolean isSelect = false;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.collection:
                if (!isSelect){
                    collect_img.setImageResource(R.drawable.collected_select);
                    collect_text.setText("已收藏");
                    ToastUtils.makeShortText("已收藏",SetailsActivity.this);
                    isSelect = true;
                    // TODO: 2018/1/16 收藏
                }else {
                    collect_img.setImageResource(R.mipmap.collect);
                    collect_text.setText("收藏");
                    ToastUtils.makeShortText("已取消收藏",SetailsActivity.this);
                    isSelect = false;
                    // TODO: 2018/1/16 取消收藏
                }
                break;
//            case R.id.setails_back:
//
//                break;
        }
    }


    @Override
    public void initListener() {

    }


    @Override
    protected void handler(Message msg) {

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if(requestCode == 123){
            showMyShare();
        }
    }
    /**
     * 权限申请
     */
    private void jurisdiction(){
        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }
    }
    private void showMyShare(){
        UMImage image = new UMImage(SetailsActivity.this, R.mipmap.logo);//资源文件
        UMWeb web = new UMWeb("http://www.51kaxin.xyz/appdown.html");
        web.setTitle(good.getName());
        web.setThumb(new UMImage(this, R.drawable.share_loge));
        web.setDescription(good.getDescribe());
        new ShareAction(SetailsActivity.this)
                .withText("卡信")
                .withMedia(web)
                .setDisplayList(SHARE_MEDIA.QQ,SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE)//..XL
                .setCallback(shareListener)
                .open();
    }
    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(SetailsActivity.this,"分享成功",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(SetailsActivity.this,"网络故障"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            //Toast.makeText(SetailsActivity.this,"取消了",Toast.LENGTH_LONG).show();

        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

}
