package com.mt.cardletter.activity;

import android.os.Message;
import android.view.View;

import com.mt.cardletter.R;

/**
 * Date:2017/12/13
 * Time:17:56
 * author:demons
 */

public class LoginActivity extends BaseActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        findViewById(R.id.btnClose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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
