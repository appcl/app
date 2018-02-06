package com.mt.cardletter.activity.seckill;

import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.fragment.seckill.APMFragment;
import com.mt.cardletter.fragment.seckill.DesenoFragment;
import com.mt.cardletter.fragment.seckill.OverflowFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

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

    @Bind({R.id.activity_seckill_1})
    RadioButton activity_seckill_1;
    @Bind({R.id.activity_seckill_2})
    RadioButton activity_seckill_2;
    @Bind({R.id.activity_seckill_3})
    RadioButton activity_seckill_3;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_seckill;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        radioGroup = (RadioGroup) findViewById(R.id.activity_seckill_radiogroup);
        radioGroup.setOnCheckedChangeListener(this);
        bottom_radiobuttonsize();
    }

    private void bottom_radiobuttonsize(){
        //定义底部标签图片大小和位置
        Drawable drawable_home = getResources().getDrawable(R.drawable.select_bottom_home);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_home.setBounds(0, 0, 100, 100);
        //设置图片在文字的哪个方向
        activity_seckill_1.setCompoundDrawables(null, drawable_home, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_integral = getResources().getDrawable(R.drawable.select_bottom_home);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_integral.setBounds(0, 0, 100, 100);
        //设置图片在文字的哪个方向
        activity_seckill_2.setCompoundDrawables(null, drawable_integral, null, null);

        //定义底部标签图片大小和位置
        Drawable drawable_find = getResources().getDrawable(R.drawable.select_bottom_home);
        //当这个图片被绘制时，给他绑定一个矩形 ltrb规定这个矩形
        drawable_find.setBounds(0, 0, 100, 100);
        //设置图片在文字的哪个方向
        activity_seckill_3.setCompoundDrawables(null, drawable_find, null, null);
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
