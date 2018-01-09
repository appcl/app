package com.mt.cardletter.activity;

import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.merchant.Good;
import com.mt.cardletter.entity.merchant.Goods;
import com.mt.cardletter.entity.merchant.GoodsBean;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.ToastUtils;

import java.util.List;

/**
 * 商品详情
 */
public class SetailsActivity extends BaseActivity implements View.OnClickListener {
    private ImageView setails_back,setails_share;
    private TextView setails_title,setails_time,setails_tel,setails_address,setails_obj,setails_centent,setails_discounts;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_setails;
    }
    @Override
    public void initView() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setails_back = (ImageView) findViewById(R.id.setails_back);
        setails_share = (ImageView) findViewById(R.id.setails_share);

        setails_title = (TextView) findViewById(R.id.setails_title);
        setails_time = (TextView) findViewById(R.id.setails_dateline);
        setails_tel = (TextView) findViewById(R.id.setails_tel);
        setails_address = (TextView) findViewById(R.id.setails_address);
        setails_obj = (TextView) findViewById(R.id.setails_obj);
        setails_centent = (TextView) findViewById(R.id.setails_centent);
        setails_discounts = (TextView) findViewById(R.id.setails_discounts);
        setails_back.setOnClickListener(this);
        String cardfind_id = getIntent().getStringExtra("cardfind_id");
        if (cardfind_id!=null){
            loadData(cardfind_id);
        }
    }
    private void loadData(String cardfind_id){
        /*
         * 获取商家列表
         *
         */
       CardLetterRequestApi.getInstance().getGoodDetails(Constant.Access_Token,cardfind_id,new HttpSubscriber<Good>(new SubscriberOnListener<Good>() {
            @Override
            public void onSucceed(Good data) {
                if (data.getCode()==0){
                    Good.DataBean good = data.getData();
                    updataView(good);
                }
            }
            @Override
            public void onError(int code, String msg) {
                ToastUtils.showShort(SetailsActivity.this,msg);
            }
        },SetailsActivity.this));
    }

    private void updataView(Good.DataBean good){
        if (good != null) {
            if(good.getName()!=null&&good.getDeadline()!=null
                    &&good.getTel()!=null&&good.getAddress()!=null
                    &&good.getContent()!=null&&good.getDescribe()!=null){
                setails_title.setText(good.getName());
                setails_time.setText(good.getDeadline());
                setails_tel.setText(good.getTel());
                setails_address.setText(good.getAddress());
                setails_centent.setText(good.getContent());
                setails_obj.setText("银行");
                setails_discounts.setText(good.getDescribe());
            }
        } else {
            ToastUtils.showShort(getApplicationContext(),"数据异常，请检测网络");
        }
    }
    @Override
    protected void initData() {


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setails_back:
                finish();
                break;
            case R.id.setails_share:

                break;
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


}
