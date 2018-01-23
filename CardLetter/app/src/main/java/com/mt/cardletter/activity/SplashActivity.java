package com.mt.cardletter.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;

import com.mt.cardletter.R;
import com.mt.cardletter.fragment.SplashItemFragment;
import com.mt.cardletter.utils.PermissionUtils;
import com.mt.cardletter.utils.SharedPreferences;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.indicator.CirclePageIndicator;


/**
 * Date:2017/12/13
 * Time:16:56
 * author:demons
 */

public class SplashActivity extends BaseActivity {
    private ViewPager viewPager;
    private CirclePageIndicator circlePageIndicator;
    public static final int SPLASH_OPEN = 0X01;
    public static final int SPLASH_UNOPEN = 0X02;
    private ImageView imageView;

    /*权限数组*/
    private String[] permissionArray = new String[]{
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_PHONE_STATE
    };

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        /**
         * 申请软件所需权限
         */
        PermissionUtils.checkPermissionArray(this, permissionArray, 0x10);
        viewPager = (ViewPager) findViewById(R.id.pager);
        circlePageIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        imageView = (ImageView) findViewById(R.id.splash_img);
        int splash_is_open = SharedPreferences.getInstance().getInt("splash_is_open", SPLASH_OPEN);
        if (splash_is_open == SPLASH_OPEN){
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            SplashAdapter adapter = new SplashActivity.SplashAdapter(supportFragmentManager);
            final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
            viewPager.setPageMargin(pageMargin);
            viewPager.setOffscreenPageLimit(3);
            viewPager.setAdapter(adapter);

            circlePageIndicator.setVisibility(View.VISIBLE);

            circlePageIndicator.setViewPager(viewPager);

            circlePageIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override
                public void onPageSelected(int position) {

                }
                @Override
                public void onPageScrollStateChanged(int state) {
                }
            });
        }else{
            imageView.setVisibility(View.VISIBLE);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    UIHelper.showMainActivity(SplashActivity.this);
                }
            }, 1000);
        }
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
