package com.mt.cardletter.fragment;


import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mt.cardletter.R;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.SharedPreferences;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.pulltozoomview.PullToZoomScrollViewEx;

import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by demons on 2017/11/13.
 */

public class MineFragment extends Fragment{
    private int[] headImgID = {R.mipmap.head1,R.mipmap.head2,R.mipmap.head3,R.mipmap.head4,R.mipmap.head5,R.mipmap.head6};
    private Activity context;
    private View root;
    private PullToZoomScrollViewEx scrollView;

    private TextView user_name;
    private CircleImageView avatar;
    private boolean isLogin;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return root = inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        initData();
        initView();
    }
    private void initView(){

        scrollView = (PullToZoomScrollViewEx) root.findViewById(R.id.picscrollView);
        View headView = LayoutInflater.from(context).inflate(R.layout.member_head_view, null, false);
        View zoomView = LayoutInflater.from(context).inflate(R.layout.member_zoom_view, null, false);
        View contentView = LayoutInflater.from(context).inflate(R.layout.member_content_view, null, false);
        scrollView.setHeaderView(headView);
        scrollView.setZoomView(zoomView);
        scrollView.setScrollContentView(contentView);

        user_name = (TextView) headView.findViewById(R.id.user_name);
        avatar = (CircleImageView) headView.findViewById(R.id.avatar);
        resetInfo();
//===================================================================================
        headView.findViewById(R.id.avatar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLogin) {
                    UIHelper.showLoginActivity(getActivity());
                    return;
                }else{
                    UIHelper.showSettingMsg(getContext());//个人设置界面
                }
            }
        });
        headView.findViewById(R.id.message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLogin) {
                    UIHelper.showLoginActivity(getActivity());
                    return;
                }
                ToastUtils.makeShortText("功能待开放",getContext());
            }
        });
        headView.findViewById(R.id.question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLogin) {
                    UIHelper.showLoginActivity(getActivity());
                    return;
                }
                ToastUtils.makeShortText("功能待开放",getContext());
            }
        });


        scrollView.getPullRootView().findViewById(R.id.collection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLogin) {
                    UIHelper.showLoginActivity(getActivity());
                    return;
                }
                ToastUtils.makeShortText("功能待开放",getContext());
            }
        });
        scrollView.getPullRootView().findViewById(R.id.location).setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                if (!isLogin) {
                    UIHelper.showLoginActivity(getActivity());
                    return;
                }
                UIHelper.showLocationActivity(getActivity());
            }
        });
        scrollView.getPullRootView().findViewById(R.id.discover).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLogin) {
                    UIHelper.showLoginActivity(getActivity());
                    return;
                }
            }
        });
        scrollView.getPullRootView().findViewById(R.id.subscribe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLogin) {
                    UIHelper.showLoginActivity(getActivity());
                    return;
                }
                ToastUtils.makeShortText("功能待开放",getContext());
            }
        });
        scrollView.getPullRootView().findViewById(R.id.setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UIHelper.showSetting(getContext());
            }
        });
//===================================================================================
    }

    private void initData() {

    }


    @Override
    public void onResume() {
        super.onResume();
        resetInfo();

    }

    public void resetInfo() {
        isLogin = SharedPreferences.getInstance().getBoolean("isLogin", false);
        //ToastUtils.showShort(getContext(),"================"+isLogin+"  "+SharedPreferences.getInstance().getString("nick_name","")+" "+ SharedPreferences.getInstance().getString("url","")+" ");
        if (isLogin) {
            String name = SharedPreferences.getInstance().getString("nick_name","");
            String url = SharedPreferences.getInstance().getString("url","");
            if ((!url.isEmpty())&&(!url.equals(""))){
                Glide.with(context).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(avatar);//设置网络头像
            }else{
                setTingHead();//设置随机头像
            }
            if (null!=name){
                user_name.setText(name);
            }
        }else {
            avatar.setImageResource(R.mipmap.icon_default);
            user_name.setText("未登录");
        }

    }
    /**
     * 弹窗选择：相机/相册
     */
    private PopupWindow mPopupWindow;
    private void showMenuPop() {
        View popView = LayoutInflater.from(getContext()).inflate(R.layout.pull_popu_head_img, null);
        mPopupWindow = new PopupWindow(popView, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        // 设置允许在外点击消失
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable());

        final Window window = getActivity().getWindow();
        final WindowManager.LayoutParams params = window.getAttributes();
        params.alpha = 0.8F;
        window.setAttributes(params);

        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                params.alpha = 1.0F;
                window.setAttributes(params);
            }
        });
        //设置动画
        // mPopupWindow.setAnimationStyle(R.style.anim_bottom_dialog);
        mPopupWindow.setAnimationStyle(android.R.style.Animation_InputMethod);
//        popView.findViewById(R.id.tv_camera_album).setOnClickListener(onClickListenerForPop);
//        popView.findViewById(R.id.tv_picasso).setOnClickListener(onClickListenerForPop);
//        popView.findViewById(R.id.tv_cancel).setOnClickListener(onClickListenerForPop);
        //参数1:根视图，整个Window界面的最顶层View  参数2:显示位置
        mPopupWindow.showAtLocation(window.getDecorView(), Gravity.BOTTOM, 0, 0);
    }

    /**
     * 设置随机设置头像
     */
    private void setTingHead(){
        Random rand = new Random();
        SharedPreferences sp = SharedPreferences.getInstance();
        int defImgIndex = sp.getInt("headImgIndex", -1);
        if (defImgIndex == -1){
            sp.putInt("headImgIndex",rand.nextInt(6));
        }
        defImgIndex = sp.getInt("headImgIndex", -1);
        avatar.setImageResource(headImgID[defImgIndex]);
    }
}
