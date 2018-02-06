package com.mt.cardletter.activity.showimg;

import android.os.Message;
import android.view.WindowManager;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;

/**
 * 图片查看器 
 */
public class ImagePagerActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_image_pager;
    }

    @Override
    public void initView() {
        // 设置为全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

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