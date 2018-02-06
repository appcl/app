package com.mt.cardletter.activity.setting;

import android.content.DialogInterface;
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
import com.mt.cardletter.entity.checkversion.CheckOrUpdate;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.DataCleanUtil;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.utils.updater.Updater;
import com.mt.cardletter.utils.updater.UpdaterConfig;
import com.mt.cardletter.view.dialog.CustomDialog;

import java.util.ArrayList;
import java.util.List;


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
                getServiceVersion();
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

    List<CheckOrUpdate.DataBean> dataBeanList = new ArrayList<>();
    int down_versio;
    public void getServiceVersion() {
        CardLetterRequestApi.getInstance().check_update(Constant.Access_Token, "", getVersion(),
                new HttpSubscriber<CheckOrUpdate>(new SubscriberOnListener<CheckOrUpdate>() {
                    @Override
                    public void onSucceed(CheckOrUpdate data) {
                        dataBeanList=data.getData();
                        if (data.getCode()==0){
                            if (dataBeanList.size()==0){
                                ToastUtils.makeShortText("目前是最新版本 "+getVersion(),SettingActivity.this);
                            }else {
                                for (int i=0;i<dataBeanList.size();i++){
                                    //当前app版本号和服务器版本号作比较
                                    int version_num  = getVersion().compareTo(dataBeanList.get(i).getVersion());
                                    if (version_num>0){
                                        //目前是最新版本，无需下载更新
                                        ToastUtils.makeShortText("目前是最新版本 "+getVersion(),SettingActivity.this);
                                    }else {
                                        //有新版本-下载
                                        down_versio=i;
                                        String down_url = dataBeanList.get(down_versio).getDown_url();
                                        showDownloadToast(down_url);
                                    }
                                }
                            }
                        }else {
                            ToastUtils.makeShortText(data.getMsg(),SettingActivity.this);
                        }
                    }

                    @Override
                    public void onError(int code, String msg) {

                    }
                }, SettingActivity.this));
    }

    //执行下载
    public void download(String down_url) {
        UpdaterConfig config = new UpdaterConfig.Builder(this)
                .setTitle(getResources().getString(R.string.app_name))
                .setDescription(getString(R.string.system_download_description))
                .setFileUrl("http://app.mi.com/download/562671?ref=search")
                .setCanMediaScanner(true)
                .build();
        Updater.get().showLog(true).download(config);
    }

    private void showDownloadToast(final String down_url) {
        CustomDialog.Builder builder = new CustomDialog.Builder(SettingActivity.this);
        builder.setTitle("检测到当前有新版本\n 是否需要下载更新");
        builder.setPositiveButton("下载", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //设置你的操作事项
                dialog.dismiss();
                download(down_url);
            }
        });

        builder.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        builder.create().show();
    }
}
