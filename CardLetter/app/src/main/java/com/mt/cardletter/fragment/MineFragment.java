package com.mt.cardletter.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.utils.SharedPreferences;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.badge.BadgeView;
import com.mt.cardletter.view.pulltozoomview.PullToZoomScrollViewEx;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by demons on 2017/11/13.
 */

public class MineFragment extends Fragment{

    private Activity context;
    private View root;
    private PullToZoomScrollViewEx scrollView;

    private TextView user_name;
    private CircleImageView avatar;
    private boolean isLogin;

    private BadgeView mBadge;

//    @Override
//    protected int setLayoutResouceId() {
//        return R.layout.fragment_mine;
//    }
//
//    @Override
//    public void initData() {
//
//    }

    private void getData() {
    }

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
//        ImageView imageView = (ImageView) headView.findViewById(R.id.message);
//        mBadge = new BadgeView(getActivity(),imageView);
//        System.out.println("-----data-----"+AppContext.push_data.size());
//        if (AppContext.push_data.size()>0){
//            mBadge.setText(String.valueOf(AppContext.push_data.size()));
//            mBadge.show();
//        }

        headView.findViewById(R.id.avatar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLogin) {
                    UIHelper.showLoginActivity(getActivity());
                    return;
                }
//                UIHelper.showLoginActivity(getActivity());
            }
        });

        headView.findViewById(R.id.message).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLogin) {
                    UIHelper.showLoginActivity(getActivity());
                    return;
                }
//                UIHelper.showLoginActivity(getActivity());
//                UIHelper.showMessageActivity(getActivity());
            }
        });


        headView.findViewById(R.id.question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLogin) {
                    UIHelper.showLoginActivity(getActivity());
                    return;
                }
//                UIHelper.showLoginActivity(getActivity());
            }
        });


        scrollView.getPullRootView().findViewById(R.id.collection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLogin) {
                    UIHelper.showLoginActivity(getActivity());
                    return;
                }
            }
        });
        scrollView.getPullRootView().findViewById(R.id.location).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLogin) {
                    UIHelper.showLoginActivity(getActivity());
                    return;
                }
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
            }
        });
        scrollView.getPullRootView().findViewById(R.id.setting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLogin) {
                    UIHelper.showLoginActivity(getActivity());
                    return;
                }
                UIHelper.showSetting(getContext());
            }
        });

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
        if (isLogin) {
            String name = SharedPreferences.getInstance().getString("nick_name","");
//            Glide.with(context).load().diskCacheStrategy(DiskCacheStrategy.ALL).into(avatar);
            if (null!=name){
                user_name.setText(name);
            }
        }else {
            avatar.setImageResource(R.mipmap.icon_default);
            user_name.setText("未登录");
        }
    }
}
