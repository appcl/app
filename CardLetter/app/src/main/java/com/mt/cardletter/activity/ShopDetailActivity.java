package com.mt.cardletter.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mt.cardletter.R;
import com.mt.cardletter.view.exchange.ViewUtils;

/**
 * Date:2018/3/13
 * Time:11:34
 * author:demons
 */

public class ShopDetailActivity extends GoodsBaseActivity implements View.OnClickListener{

    private SimpleDraweeView iv_shop;

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iv_shop = (SimpleDraweeView) findViewById(R.id.iv_shop);
        ViewUtils.getBlurFresco(mContext, (SimpleDraweeView) findViewById(R.id.iv_shop_bg), "res:///" + R.drawable.icon_shop);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_shop_detail;
    }
}
