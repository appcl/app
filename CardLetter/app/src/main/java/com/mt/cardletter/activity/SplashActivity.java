package com.mt.cardletter.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.mt.cardletter.R;
import com.mt.cardletter.fragment.HomeFragment;
import com.mt.cardletter.fragment.SplashItemFragment;
import com.mt.cardletter.utils.SharedPreferences;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.indicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import static com.mt.cardletter.R.id.pager;


/**
 * Date:2017/12/13
 * Time:16:56
 * author:demons
 */

public class SplashActivity extends BaseActivity {
    private ViewPager viewPager;
    private CirclePageIndicator circlePageIndicator;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {

        viewPager = (ViewPager) findViewById(R.id.pager);
        circlePageIndicator = (CirclePageIndicator) findViewById(R.id.indicator);

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        SplashAdapter adapter = new SplashActivity.SplashAdapter(supportFragmentManager);
        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
        viewPager.setPageMargin(pageMargin);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);

    }

    private class SplashAdapter extends FragmentPagerAdapter{

        public SplashAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return  position+"";
        }
        @Override
        public Fragment getItem(int position) {
            SplashItemFragment splashItemFragment = new SplashItemFragment(viewPager);
            Bundle bundle = new Bundle();
            bundle.putInt("splash_index",position);
            splashItemFragment.setArguments(bundle);
            return splashItemFragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
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
