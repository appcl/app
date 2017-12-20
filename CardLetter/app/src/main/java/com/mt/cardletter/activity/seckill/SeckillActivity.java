package com.mt.cardletter.activity.seckill;

import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.BaseActivity;
import com.mt.cardletter.fragment.seckill.APMFragment;
import com.mt.cardletter.fragment.seckill.DesenoFragment;
import com.mt.cardletter.fragment.seckill.OverflowFragment;

/**
 *  jk 银行秒杀首页
 */
public class SeckillActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{

    private APMFragment apmFragment;
    private DesenoFragment desenoFragment;
    private OverflowFragment overflowFragment;
    private RadioGroup radioGroup;
    private FragmentManager fragmentManager;
    private Fragment mFragment;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_seckill;
    }

    @Override
    public void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.activity_seckill_radiogroup);
        radioGroup.setOnCheckedChangeListener(this);
    }
    @Override
    protected void initData() {
        apmFragment = new APMFragment();
        desenoFragment = new DesenoFragment();
        overflowFragment = new OverflowFragment();
        fragmentManager = getSupportFragmentManager();

        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(R.id.activity_seckill_layout,apmFragment);
        beginTransaction.add(R.id.activity_seckill_layout,desenoFragment);
        beginTransaction.add(R.id.activity_seckill_layout,overflowFragment);


        beginTransaction.hide(desenoFragment);
        beginTransaction.hide(overflowFragment);
        beginTransaction.commit();
        mFragment = apmFragment;
    }

    @Override
    public void initListener() {

    }



    @Override
    protected void handler(Message msg) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.hide(mFragment);
        switch (checkedId){
            case R.id.activity_seckill_1:
                beginTransaction.show(apmFragment);
                mFragment = apmFragment;
                break;
            case R.id.activity_seckill_2:
                beginTransaction.show(desenoFragment);
                mFragment = desenoFragment;
                break;
            case R.id.activity_seckill_3:
                beginTransaction.show(overflowFragment);
                mFragment = overflowFragment;
                break;
        }
        beginTransaction.commit();

    }
}
