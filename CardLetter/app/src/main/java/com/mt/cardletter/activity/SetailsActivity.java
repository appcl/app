package com.mt.cardletter.activity;

import android.os.Message;
import android.view.WindowManager;

import com.mt.cardletter.R;

/**
 * 商品详情
 */
public class SetailsActivity extends BaseActivity {


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_setails;
    }

    @Override
    public void initView() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
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
