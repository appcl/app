package com.mt.cardletter.activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.common.api.GoogleApiClient;
import com.mt.cardletter.R;
import com.mt.cardletter.activity.collect.CollectActivity;
import com.mt.cardletter.db.tables.BankTable;
import com.mt.cardletter.entity.collect.Collect;
import com.mt.cardletter.entity.collect.CollectList;
import com.mt.cardletter.entity.merchant.Good;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.SharedPreferences;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;


import org.litepal.crud.DataSupport;

import java.util.HashMap;
import java.util.List;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.onekeyshare.ShareContentCustomizeCallback;

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
    private GoogleApiClient client;

    private ImageView collect_img;
    private TextView collect_text;
    private Good.DataBean good;
    private String cardfind_id;
    private String title;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_setails;
    }

    @Override
    public void initView() {
        title_name = (TextView) findViewById(R.id.title_name);
        title_name.setText("商家详情");
        com_back_click = (FrameLayout) findViewById(R.id.com_back_click);
        com_back_click.setVisibility(View.VISIBLE);
        next = (TextView) findViewById(R.id.commonal_tv);
        next.setVisibility(View.VISIBLE);
        next.setText("分享");
        next.setTextColor(getResources().getColor(R.color.color_text_black_31));
        next.setOnClickListener(new OnMultiClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onMultiClick(View v) {
                showShare();
                //jurisdiction();//权限申请  分享入口
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
        cardfind_id = getIntent().getStringExtra("cardfind_id");
        if (cardfind_id != null) {
            loadDataForGood(cardfind_id);
        }
        collect = (RelativeLayout) findViewById(R.id.collection);
        collect_img = (ImageView) findViewById(R.id.pic_one);
        collect_text = (TextView) findViewById(R.id.pic_tow);
        collect.setOnClickListener(this);
    }
    private void loadDataForGood(String cardfind_id) {
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
//            if (good.getName() != null && good.getDeadline() != null
//                    && good.getTel() != null && good.getAddress() != null
//                    && good.getContent() != null && good.getDescribe() != null) {
                title = good.getName();
                setails_title.setText(title);
                setails_time.setText(good.getDeadline());
                setails_tel.setText(good.getTel());
                setails_address.setText(good.getAddress());
                setails_centent.setText(good.getContent());
                setails_discounts.setText(good.getDescribe());
                if (good.getThumb()!=null){
                    Glide.with(this).load(Constant.BASE_URL+good.getThumb()).error(R.drawable.default_error).into(bigImg);
                }

                //data for db
                List<BankTable> bankTable = DataSupport.where("bank_id = ?",good.getBankcard()).find(BankTable.class);//查询数据库
                setails_obj.setText(bankTable.get(0).getName());
                Glide.with(this).load(Constant.BASE_URL+bankTable.get(0).getCardThumb()).error(R.drawable.default_error).into(item_bank);
            }
//        } else {
//            ToastUtils.showShort(SetailsActivity.this, "数据异常");
//        }
    }

    @Override
    protected void initData() {

    }
    private boolean isSelect = false;
    @Override
    public void onClick(View v) {
        boolean isLogin = SharedPreferences.getInstance().getBoolean("isLogin", false);
        String member_id = SharedPreferences.getInstance().getString("member_id", "");
        switch (v.getId()) {
            case R.id.collection:
                if (!isLogin){
                    UIHelper.showLoginActivity(this);
                } else {
                    if (!isSelect) {
                        // TODO: 2018/1/16 收藏
                        String fvalue = "http://www.51kaxin.xyz/api.php/cardfind/cardfindinfo/access_token/" + Constant.Access_Token + "/cardfind_id/" + cardfind_id;
                        System.out.println("jk-----" + title + "---" + member_id + "-----" + cardfind_id + "------" + fvalue);
                        addFavorite(title, member_id, cardfind_id, fvalue);
                    } else {
                        // TODO: 2018/1/16 取消收藏
                        delFavorite(cardfind_id, member_id);
                    }
                }
                break;
//            case R.id.setails_back:
//
//                break;
        }
    }

    /**
     * 添加收藏
     * 
     */
    // TODO: 2018/1/24 等待接口
    private void addFavorite(String title_name ,String member_id,String name_id,String fvalue){
        CardLetterRequestApi.getInstance().addFavorite(title_name,member_id,name_id,fvalue, new HttpSubscriber<Collect>(new SubscriberOnListener<Collect>() {
            @Override
            public void onSucceed(Collect data) {
                if (data.getCode() == 0) {
                    collect_img.setImageResource(R.drawable.collected_select);
                    collect_text.setText("已收藏");
                    ToastUtils.makeShortText("已收藏",SetailsActivity.this);
                    isSelect = true;
                }
            }
            @Override
            public void onError(int code, String msg) {
                System.out.println("jk----Collect--"+msg);
                ToastUtils.showShort(SetailsActivity.this, "网络故障");
            }
        }, SetailsActivity.this));
    }
    /**
     * 删除收藏
     *
     */
    private void delFavorite(String name_id,String member_id){
        CardLetterRequestApi.getInstance().delFavorite( name_id, member_id, new HttpSubscriber<Collect>(new SubscriberOnListener<Collect>() {
            @Override
            public void onSucceed(Collect data) {
                if (data.getCode() == 0) {
                    collect_img.setImageResource(R.mipmap.collect);
                    collect_text.setText("收藏");
                    ToastUtils.makeShortText("已取消收藏",SetailsActivity.this);
                    isSelect = false;
                }
            }
            @Override
            public void onError(int code, String msg) {
                ToastUtils.showShort(SetailsActivity.this, "网络故障");
            }
        }, SetailsActivity.this));
    }
    @Override
    public void initListener() {

    }


    @Override
    protected void handler(Message msg) {

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        oks.setShareContentCustomizeCallback(new ShareContentCustomizeCallback() {
            @Override
            public void onShare(Platform platform, cn.sharesdk.framework.Platform.ShareParams paramsToShare) {
                if("SinaWeibo".equals(platform.getName())){
                    paramsToShare.setText(good.getName());
                    paramsToShare.setImageUrl("https://hmls.hfbank.com.cn/hfapp-api/9.png");
                }
                if ("Wechat".equals(platform.getName())) {
                    paramsToShare.setTitle(good.getName());
                    paramsToShare.setUrl("http://sharesdk.cn");
                    paramsToShare.setText(good.getDescribe());
                    paramsToShare.setImageUrl("https://hmls.hfbank.com.cn/hfapp-api/9.png");
                    paramsToShare.setShareType(Platform.SHARE_WEBPAGE);
                }
                if ("WechatMoments".equals(platform.getName())) {
                    paramsToShare.setTitle(good.getName());
                    paramsToShare.setUrl("http://sharesdk.cn");
                    paramsToShare.setText(good.getDescribe());
                    paramsToShare.setImageUrl("https://hmls.hfbank.com.cn/hfapp-api/9.png");
                    paramsToShare.setShareType(Platform.SHARE_WEBPAGE);
                }
                if ("QQ".equals(platform.getName())) {
                    paramsToShare.setTitle(good.getName());
                    paramsToShare.setTitleUrl("http://sharesdk.cn");
                    paramsToShare.setText(good.getDescribe());
                    paramsToShare.setImageUrl("https://hmls.hfbank.com.cn/hfapp-api/9.png");
                }
                if("QZone".equals(platform.getName())){
                    paramsToShare.setTitle(good.getName());
                    paramsToShare.setTitleUrl("http://sharesdk.cn");
                    paramsToShare.setText(good.getDescribe());
                    paramsToShare.setImageUrl("https://hmls.hfbank.com.cn/hfapp-api/9.png");
                }
            }
        });

        oks.setCallback(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Log.d("ShareLogin", "onComplete ---->  分享成功");
                platform.getName();
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                Log.d("ShareLogin", "onError ---->  失败" + throwable.getStackTrace().toString());
                Log.d("ShareLogin", "onError ---->  失败" + throwable.getMessage());
            }

            @Override
            public void onCancel(Platform platform, int i) {
                Log.d("ShareLogin", "onCancel ---->  分享取消");
            }
        });
        // 启动分享GUI
        oks.show(this);
    }
}
