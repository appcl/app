package com.mt.cardletter;

import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.RadioGroup;

import com.mt.cardletter.activity.BaseActivity;
import com.mt.cardletter.fragment.CardManagerFragment;
import com.mt.cardletter.fragment.DiscoverFragment;
import com.mt.cardletter.fragment.HomeFragment;
import com.mt.cardletter.fragment.IntegralFragment;
import com.mt.cardletter.fragment.MineFragment;
import com.mt.cardletter.utils.ToastUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{

    private static final String TAG = MainActivity.class.getSimpleName();

    @Bind({R.id.activity_main_radiogroup})
    RadioGroup radioGroup;

    private HomeFragment homeFragment;
    private IntegralFragment integralFragment;
    private DiscoverFragment discoverFragment;
    private CardManagerFragment cardManagerFragment;
    private MineFragment mineFragment;
    private FragmentManager fragmentManager;
    private Fragment showFragment;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
    }

    @Override
    public void initListener() {
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    protected void initData() {
        homeFragment = new HomeFragment();
        integralFragment = new IntegralFragment();
        discoverFragment = new DiscoverFragment();
        cardManagerFragment = new CardManagerFragment();
        mineFragment = new MineFragment();

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(R.id.activity_main_layout,homeFragment);
        beginTransaction.add(R.id.activity_main_layout,integralFragment);
        beginTransaction.add(R.id.activity_main_layout,discoverFragment);
        beginTransaction.add(R.id.activity_main_layout,cardManagerFragment);
        beginTransaction.add(R.id.activity_main_layout,mineFragment);

        beginTransaction.hide(integralFragment);
        beginTransaction.hide(discoverFragment);
        beginTransaction.hide(cardManagerFragment);
        beginTransaction.hide(mineFragment);
        beginTransaction.commit();
        showFragment = homeFragment;
    }

    @Override
    protected void handler(Message msg) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.hide(showFragment);
        switch (i){
            case R.id.activity_main_radiobutton_home:
                beginTransaction.show(homeFragment);
                showFragment = homeFragment;
                break;
            case R.id.activity_main_radiobutton_integral:
                beginTransaction.show(integralFragment);
                showFragment = integralFragment;
                break;
            case R.id.activity_main_radiobutton_discover:
                beginTransaction.show(discoverFragment);
                showFragment = discoverFragment;
                break;
            case R.id.activity_main_radiobutton_card:
                beginTransaction.show(cardManagerFragment);
                showFragment = cardManagerFragment;
                break;
            case R.id.activity_main_radiobutton_user:
                beginTransaction.show(mineFragment);
                showFragment = mineFragment;
                break;
        }
        beginTransaction.commit();
    }

    /**
     * 再按一次退出程序
     */
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - exitTime > 2000) {
                ToastUtils.showShort(this, "再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
