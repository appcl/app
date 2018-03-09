package com.mt.cardletter.activity.comment;

import android.content.res.AssetManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.view.Scroll.TopScrollView;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshBase;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshListView;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshScrollView;

import java.io.IOException;
import java.io.InputStream;

public class CommentActivity extends BaseActivity {
    private String[] args = {"item1","item1","item1","item1","item1","item1","item1","item1","item1","item1","item1","item1","item1","item1","item1","item1"};
    private PullToRefreshScrollView scrollView;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_comment;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void initView() {
        scrollView = (PullToRefreshScrollView) findViewById(R.id.listView);

        scrollView.setMode(PullToRefreshBase.Mode.BOTH);


        scrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                System.out.println("kk-------onPullDownToRefresh");
                scrollView.onRefreshComplete();
            }

            @Override
             public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                try {
                    new Thread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("kk-------onPullUpToRefresh");
                scrollView.onRefreshComplete();
             }
      });
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
