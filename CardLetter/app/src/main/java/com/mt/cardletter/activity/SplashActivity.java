package com.mt.cardletter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mt.cardletter.MainActivity;
import com.mt.cardletter.R;


import com.mt.cardletter.db.dbuitls.DBCreate;
import com.mt.cardletter.db.tables.BankTable;
import com.mt.cardletter.entity.merchant.Bank;

import com.mt.cardletter.entity.merchant.MyBankBack;
import com.mt.cardletter.fragment.SplashItemFragment;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.PermissionUtils;
import com.mt.cardletter.utils.SharedPreferences;

import com.mt.cardletter.utils.ToastUtils;

import com.mt.cardletter.view.indicator.CirclePageIndicator;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;


/**
 * Date:2017/12/13
 * Time:16:56
 * author:demons
 */

public class SplashActivity extends FragmentActivity {
    private ViewPager viewPager;
    private CirclePageIndicator circlePageIndicator;
    private ImageView imageView;
    private int  page_size = 3;//引导页数量
    public static final int SPLASH_OPEN = 0X01;//引导页打开
    public static final int SPLASH_UNOPEN = 0X02;//引导页关闭
    private List<Bank.DataBean> myList = new ArrayList<>();//银行数据
    private int[] imags = new int[]{R.drawable.new01,
            R.drawable.new02,
            R.drawable.new03
    };
    /*权限数组*/
    private String[] permissionArray = new String[]{
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_PHONE_STATE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        PermissionUtils.checkPermissionArray(this, permissionArray, 0x10);
        viewPager = (ViewPager) findViewById(R.id.pager);
        circlePageIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        imageView = (ImageView) findViewById(R.id.splash_img);

        int splash_is_open = SharedPreferences.getInstance().getInt("splash_is_open", SPLASH_OPEN);

        if (splash_is_open == SPLASH_OPEN) { //首次进入APP
            /**
             *   创建数据库
             */
            Connector.getDatabase();
            toLoginForBank();         //写入数据库 银行信息
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            SplashAdapter adapter = new SplashActivity.SplashAdapter(supportFragmentManager);
            final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
            viewPager.setPageMargin(pageMargin);
            viewPager.setOffscreenPageLimit(page_size); // 引导页个数
            viewPager.setAdapter(adapter);
            circlePageIndicator.setVisibility(View.VISIBLE);
            circlePageIndicator.setViewPager(viewPager);

        } else {   //非首次进入APP

            /**
             *   创建数据库
             */
            Connector.getDatabase();
            toLoginForBank();//写入数据库 银行信息
            getMybank();//获取用户数据

            imageView.setVisibility(View.VISIBLE);
            circlePageIndicator.setVisibility(View.GONE);
             viewPager.setVisibility(View.GONE);
            viewPager.clearFocus();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    SplashActivity.this.finish();
                }
            }, 2000);
        }
    }
    /**
     * 适配器2
     */
    public class MyAdapter extends PagerAdapter {
        private List<View> mListViews;
        public MyAdapter(List<View> mListViews) {
            this.mListViews = mListViews;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object)  {
            container.removeView(mListViews.get(position));//删除页卡
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position){
            container.addView(mListViews.get(position), 0);
            return mListViews.get(position);
        }
        @Override
        public int getCount() {
            return  mListViews.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;//官方提示这样写
        }
    }
    /**
     * 适配器1
     */
    private class SplashAdapter extends FragmentPagerAdapter{
        public SplashAdapter(FragmentManager fm) {super(fm);}
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
            return page_size;
        }
    }

    /**
     * 获取银行列表
     */
    private void toLoginForBank() {
        CardLetterRequestApi.getInstance().getBank(Constant.Access_Token, new HttpSubscriber<Bank>(new SubscriberOnListener<Bank>() {
            @Override
            public void onSucceed(Bank data) {
                if (data.getCode() == 0) {
                    myList = data.getData();
                }
                //数据库存储操作
                DataSupport.deleteAll(BankTable.class);
                for (Bank.DataBean bank: myList) {
                    DBCreate.addBankForBankTable(bank);
                }
                SharedPreferences.getInstance().putInt("splash_is_open",SPLASH_UNOPEN);//取消首次打开
//                List<BankTable> all = DataSupport.findAll(BankTable.class);
//                for (BankTable banktable: all) {
//                    System.out.println("jk----bank   "+banktable.getId()+"----"+banktable.getName());
//                }
            }
            @Override
            public void onError(int code, String msg) {
                ToastUtils.makeShortText("网络故障",  SplashActivity.this);
            }
        },  SplashActivity.this));
    }

    /**
     * 获取关注银行
     */
    private void getMybank() {
        String user_token = SharedPreferences.getInstance().getString("user_token", "");
        System.out.println("jk1-----"+user_token);
        CardLetterRequestApi.getInstance().getMybank(user_token, new HttpSubscriber<MyBankBack>(new SubscriberOnListener<MyBankBack>() {
            @Override
            public void onSucceed(MyBankBack data) {
                if (data.getCode() == 1000002){
                    return;
                }
                if (data.getCode() == 0){

                    List<MyBankBack.DataBean> data1 = data.getData();
                    StringBuilder sb = new StringBuilder();
                    for (MyBankBack.DataBean bean:data1) {
                        int id = bean.getId();
                        sb.append(id+",");
                    }
                    Constant.MY_BANK = sb.toString();
                    System.out.println("jk1----"+data.getCode()+" "+data.getMsg()+"   "+ Constant.MY_BANK );
                }

            }
            @Override
            public void onError(int code, String msg) {
                ToastUtils.makeShortText("网络故障",  SplashActivity.this);
            }
        },  SplashActivity.this));
    }
}
