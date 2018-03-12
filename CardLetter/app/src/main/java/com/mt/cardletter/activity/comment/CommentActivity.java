package com.mt.cardletter.activity.comment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.view.Scroll.TopScrollView;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshBase;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshListView;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshScrollView;

import java.io.IOException;
import java.io.InputStream;
/**/
public class CommentActivity extends BaseActivity {
    private String[] args = {"item1","item1","item1","item1","item1","item1","item1","item1","item1","item1","item1","item1","item1","item1","item1","item1"};
    private PullToRefreshScrollView scrollView;
    private Button com_test;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_comment;
    }

    @Override

    public void initView() {
        scrollView = (PullToRefreshScrollView) findViewById(R.id.listView);
        com_test = (Button) findViewById(R.id.com_test);
        com_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission();
            }
        });
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

    /**
     * 申请权限
     */
    private void requestPermission()
    {
        //判断Android版本是否大于23
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            int checkCallPhonePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

            if (checkCallPhonePermission != PackageManager.PERMISSION_GRANTED)
            {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},
                       100);
                return;
            }
            else
            {
                callPhone();
            }
        }
        else
        {
            callPhone();
        }
    }
    /**
     * 注册权限申请回调
     * @param requestCode 申请码
     * @param permissions 申请的权限
     * @param grantResults 结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        switch (requestCode)
        {
            case  100:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    callPhone();
                }
                else
                {
                    Toast.makeText(CommentActivity.this, "CALL_PHONE Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
    /**
     * 拨号方法
     */
    private void callPhone()
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:10086"));
        startActivity(intent);
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
