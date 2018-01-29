package com.mt.cardletter.activity.setting;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.AboutActivity;
import com.mt.cardletter.activity.BaseActivity;
import com.mt.cardletter.activity.showimg.ImagePagerActivity;
import com.mt.cardletter.utils.DataCleanUtil;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;


public class SettingActivity extends BaseActivity implements View.OnClickListener{
    private TextView cacheSize;
    private FrameLayout back;
    private TextView title_name;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_setting;
    }

    @Override
    public void initView() {
        cacheSize = (TextView) findViewById(R.id.cache_size);
        title_name = (TextView) findViewById(R.id.title_name);
        title_name.setText("设置");
        back = (FrameLayout) findViewById(R.id.com_back_click);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);
        findViewById(R.id.user_msg).setOnClickListener(this);
        findViewById(R.id.setting_clear).setOnClickListener(this);
        try {
            cacheSize.setText( DataCleanUtil.getTotalCacheSize(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
        findViewById(R.id.test).setOnClickListener(this);
        findViewById(R.id.setting_help).setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting_clear :
                DataCleanUtil.clearAllCache(SettingActivity.this);
                try {
                    cacheSize.setText(DataCleanUtil.getTotalCacheSize(SettingActivity.this));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.user_msg:
                //startActivity(new Intent(SettingActivity.this, ImagePagerActivity.class));
                UIHelper.showSettingMsg(this);
                break;
            case R.id.test :
                startActivity(new Intent(this, AboutActivity.class));
                break;
            case R.id.setting_help :
                //TODO  版本更新
                ToastUtils.makeShortText("目前是最新版本 "+getVersion(),this);
                break;
        }
    }

    /**
      * 获取版本号
      * @return 当前应用的版本号
      */
    public String getVersion() {
        try {
               PackageManager manager = this.getPackageManager();
               PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
                String version = info.versionName;
               return version;
        } catch (Exception e) {
                e.printStackTrace();
                return "";
        }
    }
}
