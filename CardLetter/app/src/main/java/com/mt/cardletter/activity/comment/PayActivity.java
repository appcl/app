package com.mt.cardletter.activity.comment;

import android.os.Message;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.ToastUtils;

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

    private String value;
    private TextView pay_pice;
    private TextView to_pay;
    private RadioGroup radio_btn;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_pay;
    }

    @Override
    public void initView() {
        TextView title_name;
        title_name = (TextView) findViewById(R.id.title_name);
        title_name.setText("支付订单");

        pay_pice = (TextView) findViewById(R.id.pay_pice);
        to_pay = (TextView) findViewById(R.id.to_pay);

        radio_btn = (RadioGroup) findViewById(R.id.radio_btn);
    }

    @Override
    public void initListener() {
        to_pay.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                ToastUtils.makeShortText("目前该功能所需材料在审核中...",PayActivity.this);
            }
        });
//        selectButton();
    }

    private void selectButton(){
        radio_btn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for(int i = 0 ;i < group.getChildCount();i++){
                    RadioButton rb = (RadioButton)group.getChildAt(i);
                }
            }
        });
    }

    @Override
    protected void initData() {
        value = getIntent().getExtras().getString("value");
        pay_pice.setText(value);
    }

    @Override
    protected void handler(Message msg) {

    }
}
