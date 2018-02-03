package com.mt.cardletter.activity;

import android.content.Context;
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
import com.mt.cardletter.db.dbuitls.DBCreate;
import com.mt.cardletter.db.tables.BankTable;
import com.mt.cardletter.entity.merchant.Bank;
import com.mt.cardletter.fragment.SplashItemFragment;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.PermissionUtils;
import com.mt.cardletter.utils.SharedPreferences;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.indicator.CirclePageIndicator;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;


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
        setSwipeBackEnable(false);//禁止侧滑退出
        /**
         * 申请软件所需权限
         */
        PermissionUtils.checkPermissionArray(this, permissionArray, 0x10);
        viewPager = (ViewPager) findViewById(R.id.pager);
        circlePageIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        imageView = (ImageView) findViewById(R.id.splash_img);
        int splash_is_open = SharedPreferences.getInstance().getInt("splash_is_open", SPLASH_OPEN);

        if (splash_is_open == SPLASH_OPEN){  //首次进入APP
            /**
             * 创建数据库
             */
            Connector.getDatabase();
            //toLoginForBank(); //获取银行数据

            FragmentManager supportFragmentManager = getSupportFragmentManager();
            SplashAdapter adapter = new SplashActivity.SplashAdapter(supportFragmentManager);
            final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
            viewPager.setPageMargin(pageMargin);
            viewPager.setOffscreenPageLimit(3); // 引导页 个数
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
        }else{  //非首次进入APP
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

    /**
     * 获取银行类表，完成数据表的数据添加
     */
    private void toLoginForBank() {
        CardLetterRequestApi.getInstance().getBank(Constant.Access_Token, new HttpSubscriber<Bank>(new SubscriberOnListener<Bank>() {
            @Override
            public void onSucceed(Bank data) {
                if (data.getCode() == 0) {
                    List<Bank.DataBean> data1 = data.getData();
                    if (data1!=null){
                        //数据库存储操作
                        DataSupport.deleteAll(BankTable.class);

                        for (Bank.DataBean bank: data1) {
                            DBCreate.addBankForBankTable(bank); //添加数据
                        }

                        List<BankTable> all = DataSupport.findAll(BankTable.class);  //打印数据
                        for (BankTable banktable: all) {
                            System.out.println("jk----bank   "+banktable.getId()+"----"+banktable.getName());
                        }
                    }
                }
            }
            @Override
            public void onError(int code, String msg) {
                ToastUtils.makeShortText("网络故障", SplashActivity.this);
            }
        }, SplashActivity.this));
    }
}
