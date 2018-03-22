package com.mt.cardletter.activity.comment;

import android.os.Message;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;

/**
 * Author: jk - Administrator
 * Data: 2018/3/19  9:56
 * Description: TODO
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃
 * 　　┃　　　┃
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 */

public class PayActivity extends BaseActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_pay;
    }

    @Override
    public void initView() {
        TextView title_name;
        title_name = (TextView) findViewById(R.id.title_name);
        title_name.setText("支付订单");
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
