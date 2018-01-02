package com.mt.cardletter.activity;

import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.data.GoodsBean;
import com.mt.cardletter.utils.ToastUtils;

import java.io.Serializable;

/**
 * 商品详情
 */
public class SetailsActivity extends BaseActivity implements View.OnClickListener {
    private ImageView setails_back,setails_share;
    private TextView setails_title,setails_time,setails_tel,setails_address,setails_obj,setails_centent,setails_discounts;
    private GoodsBean.ResultBean goods;
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
    }
    private void loadData() {
        //goods = (GoodsBean.ResultBean)getIntent().getSerializableExtra("goods");
    }
    @Override
    protected void initData() {
        loadData();
        if (goods != null) {
            setails_title.setText(goods.getShopName());
            setails_time.setText(goods.getShopDeadline());
            setails_tel.setText(goods.getShopTel());
            setails_address.setText(goods.getShopAddress());
            setails_centent.setText(goods.getShopContent());
            setails_obj.setText(goods.getShopCard());
            setails_discounts.setText(goods.getShopDiscounts());
        } else {
            ToastUtils.showShort(getApplicationContext(),"数据异常，请检测网络");
        }

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
