package com.mt.cardletter.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mt.cardletter.R;
import com.mt.cardletter.utils.ToastUtils;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class MyLoginActivity extends BaseActivity {

    private Context mContext = MyLoginActivity.this;
    private Button test , test1;
    private boolean isShouQuan;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_mylogin;
    }

    @Override
    public void initView() {
        test = (Button) findViewById(R.id.test);
        test1 = (Button) findViewById(R.id.test1);
        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
            }
        });
    }
    private void test(){
        UMShareAPI mShareAPI = UMShareAPI.get(MyLoginActivity.this);
        UMAuthListener umAuthListener = new UMAuthListener() {
            /**
             * @desc 授权开始的回调
             * @param platform 平台名称
             */
            @Override
            public void onStart(SHARE_MEDIA platform) {
                Toast.makeText(mContext, "开始", Toast.LENGTH_LONG).show();
            }

            /**
             * @desc 授权成功的回调
             * @param platform 平台名称
             * @param action 行为序号，开发者用不上
             * @param data 用户资料返回
             */
            @Override
            public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
                isShouQuan = true;
                Toast.makeText(mContext, "成功了", Toast.LENGTH_LONG).show();
                String name = data.get("name").toString();
                Toast.makeText(mContext, name, Toast.LENGTH_LONG).show();
            }
            /**
             * @desc 授权失败的回调
             * @param platform 平台名称
             * @param action 行为序号，开发者用不上
             * @param t 错误原因
             */
            @Override
            public void onError(SHARE_MEDIA platform, int action, Throwable t) {

                Toast.makeText(mContext, "失败：" + t.getMessage(),Toast.LENGTH_LONG).show();
            }

            /**
             * @desc 授权取消的回调
             * @param platform 平台名称
             * @param action 行为序号，开发者用不上
             */
            @Override
            public void onCancel(SHARE_MEDIA platform, int action) {
                Toast.makeText(mContext, "取消了", Toast.LENGTH_LONG).show();
            }
        };
//        if (isShouQuan){
//            mShareAPI.deleteOauth(MyLoginActivity.this,SHARE_MEDIA.SINA,umAuthListener);
//        }else {
            mShareAPI.getPlatformInfo(MyLoginActivity.this, SHARE_MEDIA.SINA, umAuthListener);
//        }

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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
