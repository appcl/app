package com.mt.cardletter.activity;

import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Date:2017/12/13
 * Time:10:24
 * author:demons
 */

public class MakeIntegralActivity extends BaseActivity {

    @Bind({R.id.title_name})
    TextView title_name;
    @Bind({R.id.com_back_click})
    FrameLayout com_back_click;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_make_integral;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_name.setText("赚积分攻略");
        com_back_click.setVisibility(View.VISIBLE);
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
