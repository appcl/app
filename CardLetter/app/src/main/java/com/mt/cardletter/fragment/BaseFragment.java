package com.mt.cardletter.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by demons on 2017/9/6.
 */

public abstract class BaseFragment extends Fragment {
    /**
     * 贴附的activity
     */
    protected FragmentActivity mActivity;

    /**
     * 根view
     */
    protected View mRootView;

    /**
     * 是否对用户可见
     */
    protected boolean mIsVisible;
    /**
     * 是否加载完成
     * 当执行完oncreatview,View的初始化方法后方法后即为true
     */
    protected boolean mIsPrepare;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mActivity = getActivity();
    }

    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(setLayoutResouceId(), container, false);
            initView();
            simpleUI();
            receiveData(getArguments());
            mIsPrepare = true;
            onLazyLoad();
            setListener();
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if (parent != null) {
            parent.removeView(mRootView);
        }
        return mRootView;
    }

    /*
    * 可写一些简单的UI，根据需要可重写
    * */
    protected void simpleUI() {

    }

    /*
         * 当Activity初始化之后可以在这里进行一些数据的初始化操作
         */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initEvent();
    }

    /**
     * 子类可以复写此方法初始化事件
     */
    protected void initEvent() {

    }

    /**
     * @param arguments 接收到的从其他地方传递过来的参数
     * @author dingxujun
     * @date
     */
    protected void receiveData(Bundle arguments) {

    }

    /**
     * 初始化View
     *
     * @author dingxujun
     * @date
     */
    protected void initView() {

    }

    /**
     * 设置监听事件
     *
     * @author dingxujun
     * @date
     */
    protected void setListener() {

    }

    /*
    * fragment隐藏与可见执行的操作  （viewPage嵌套fragment预加载使用）
    * */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        this.mIsVisible = isVisibleToUser;

        if (isVisibleToUser) {
            onVisibleToUser();
        }
    }

    /**
     * 用户可见时执行的操作
     *
     * @author dingxujun
     * @date 2016-5-26 下午4:09:39
     */
    protected void onVisibleToUser() {
        if (mIsPrepare && mIsVisible) {
            onLazyLoad();
        }
    }

    /**
     * 懒加载，仅当用户可见切view初始化结束后才会执行
     *
     * @author dingxujun
     * @date
     */
    protected void onLazyLoad() {

    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T findViewById(int id) {
        if (mRootView == null) {
            return null;
        }

        return (T) mRootView.findViewById(id);
    }

    /**
     * 设置根布局资源id
     *
     * @return
     * @author dingxujun
     * @date
     */
    protected abstract int setLayoutResouceId();

    /**
     * 子类在此方法中实现数据的初始化
     */
    public abstract void initData();
}
