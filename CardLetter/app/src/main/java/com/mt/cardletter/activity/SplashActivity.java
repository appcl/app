package com.mt.cardletter.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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
import com.mt.cardletter.entity.merchant.MyBankBack;
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
    /*权限数组*/
    private String[] permissionArray = new String[]{
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_PHONE_STATE
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        viewPager = (ViewPager) findViewById(R.id.pager);
        circlePageIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        imageView = (ImageView) findViewById(R.id.splash_img);
        int splash_is_open = SharedPreferences.getInstance().getInt("splash_is_open", SPLASH_OPEN);
        if (splash_is_open == SPLASH_OPEN){
            //首次进入APP

            /**
             *   创建数据库
             */
            Connector.getDatabase();
            toLoginForBank();//写入数据库 银行信息
            /**
             * 申请软件所需权限
             */
            PermissionUtils.checkPermissionArray(this, permissionArray, 0x10);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            SplashAdapter adapter = new SplashActivity.SplashAdapter(supportFragmentManager);
            final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
            viewPager.setPageMargin(pageMargin);
            viewPager.setOffscreenPageLimit(page_size); // 引导页个数
            viewPager.setAdapter(adapter);
            circlePageIndicator.setVisibility(View.VISIBLE);
            circlePageIndicator.setViewPager(viewPager);
        }else{
            //非首次进入APP
            imageView.setVisibility(View.VISIBLE);
            getMybank();//获取用户数据
            circlePageIndicator.setVisibility(View.GONE);
            viewPager.setVisibility(View.GONE);
            toLoginForBank();//写入数据库 银行信息
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    UIHelper.showMainActivity(SplashActivity.this);
                    finish();
                }
            }, 1*1000);//1秒延时
        }
    }
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
