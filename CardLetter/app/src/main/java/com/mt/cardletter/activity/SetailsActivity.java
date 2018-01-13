package com.mt.cardletter.activity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.mt.cardletter.R;
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
    private ImageView bigImg;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

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
                finish();
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
        String cardfind_id = getIntent().getStringExtra("cardfind_id");
        if (cardfind_id != null) {
            loadData(cardfind_id);
        }
    }

    private void loadData(String cardfind_id) {
        /*
         * 获取商家列表
         */
        CardLetterRequestApi.getInstance().getGoodDetails(Constant.Access_Token, cardfind_id, new HttpSubscriber<Good>(new SubscriberOnListener<Good>() {
            @Override
            public void onSucceed(Good data) {
                if (data.getCode() == 0) {
                    Good.DataBean good = data.getData();
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
                setails_obj.setText("银行");
                setails_discounts.setText(good.getDescribe());
                if (good.getThumb()!=null){
                    Glide.with(this).load(Constant.BASE_URL+good.getThumb()).error(R.drawable.default_error).into(bigImg);
                }
            }
        } else {
            ToastUtils.showShort(getApplicationContext(), "数据异常，请检测网络");
        }
    }

    @Override
    protected void initData() {


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.setails_back:
//
//                break;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Setails Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
