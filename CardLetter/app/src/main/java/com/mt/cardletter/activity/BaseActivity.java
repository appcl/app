package com.mt.cardletter.activity;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.mt.cardletter.R;
import com.mt.cardletter.app.AppManager;
import com.mt.cardletter.utils.StatusBarUtil;
import com.mt.cardletter.utils.SystemBarUtils;
import com.mt.cardletter.utils.UIHandler;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;


/**
 * 1. initView : 初始化控件:findViewById
 * 2. initListener : 初始化监听
 * 3. initData : 初始化数据: 给控件设置显示内容
 * 4. getLayoutResId  : 获取当前activity的布局id
 *
 * 1. 处理公共逻辑
 * 2. 简化代码
 */
public abstract class BaseActivity extends SwipeBackActivity {
    protected static UIHandler handler = new UIHandler(Looper.getMainLooper());
    private Bundle savedInstanceState;
    private SwipeBackLayout mSwipeBackLayout; //侧滑退出Layout
    public Bundle getSavedInstanceState() {
        return savedInstanceState;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置信号栏字体颜色
        SystemBarUtils.myStatusBar(this,true);
//        setStatusBar();
        StatusBarUtil.setColor(this,getResources().getColor(R.color.title_bg));
        // 添加Activity到堆栈
        AppManager.getAppManager().addActivity(this);
        setContentView(getLayoutResId());
        View inflate = View.inflate(this, getLayoutResId(), null);
        System.out.println("-----"+inflate);
        this.savedInstanceState = savedInstanceState;
        //(0). 设置侧滑
        sideslip();
        //(1). 查找控件  initView
        initView();
        //(2). 设置数据  initData
        initData();
        //(3). 设置点击监听  initListener
        initListener();
        // (4) 处理公共逻辑
        dealCommon();
        //(5)处理一些界面UI
        setLayoutUI();
    }

    /**
     * 获取布局资源id
     *
     * @return
     */
    protected abstract int getLayoutResId();

    /**
     * 初始化View : 查找控件
     */
    public abstract void initView();

    /**
     * 初始化监听: 给控件设置监听
     */
    public abstract void initListener();

    /**
     * 初始化数据: 给控件设置显示的内容
     */
    protected abstract void initData();


    /**
     * 处理相同逻辑
     * 比如返回键(注意判空)
     */
    protected void dealCommon() {
        //title关闭界面的公共逻辑
        FrameLayout back_click = (FrameLayout) findViewById(R.id.com_back_click);//只有子类中有id和back_click一样的都会执行这段逻辑
        if (back_click!=null){
            back_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    backClick();
                }
            });
        }
    }
    /**
     * 点击系统返回和页面返回键时的处理
     */
    private void backClick() {
        // 定义退出动画
        finish();
//        overridePendingTransition(R.anim.out_to_right_abit,R.anim.out_to_right);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
           backClick();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 设置一些界面UI
     */
    public void setLayoutUI(){

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        try {
            super.onRestoreInstanceState(savedInstanceState);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //让子类处理消息
    protected abstract void handler(Message msg);

    private void setHandler() {
        handler.setHandler(new UIHandler.IHandler() {
            public void handleMessage(Message msg) {
                handler(msg);//有消息就提交给子类实现的方法
            }
        });
    }

    /**
     * 系统方法
     * 调用时机
     *  1,按下Home键
     *  2,按下电源键
     *  3,启动其它 Activity
     *  4,横竖屏切换
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {//保存相机文件信息
        super.onSaveInstanceState(outState);

    }

    @Override
    public void finish() {
        super.finish();
    }

    /**
     * 侧滑退出实现
     */
    private void sideslip(){
        // 可以调用该方法，设置是否允许滑动退出
        setSwipeBackEnable(true);
        mSwipeBackLayout = getSwipeBackLayout();
        // 设置滑动方向，可设置EDGE_LEFT, EDGE_RIGHT, EDGE_ALL, EDGE_BOTTOM
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        // 滑动退出的效果只能从边界滑动才有效果，如果要扩大touch的范围，可以调用这个方法
        //mSwipeBackLayout.setEdgeSize(200);
    }
}
