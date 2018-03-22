package com.mt.cardletter.activity;

import android.content.res.AssetManager;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshBase;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshScrollView;

import java.io.IOException;
import java.io.InputStream;

public class AboutActivity extends BaseActivity {
    private TextView textView;
    private FrameLayout back;
    private TextView title_name;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_about;
    }

    @Override
    public void initView() {
        title_name = (TextView) findViewById(R.id.title_name);
        title_name.setText("关于");
        back = (FrameLayout) findViewById(R.id.com_back_click);
        back.setVisibility(View.VISIBLE);
        textView = (TextView) findViewById(R.id.tv_about);
        //textView.setText(getIntroduce());
    }

    public String getIntroduce() {
        AssetManager am = getAssets();
        InputStream is = null;
        StringBuilder sb = new StringBuilder();
        try {
            is = am.open("introduce.txt");
            int len = -1;
            byte[] buff = new byte[256];
            while ((len = is.read(buff))!=-1){
                sb.append(new String(buff,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(is!=null) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
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
