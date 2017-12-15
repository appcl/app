package com.mt.cardletter.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mob.MobSDK;
import com.mt.cardletter.R;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.view.tabstrip.PagerSlidingTabStrip;

import cn.sharesdk.onekeyshare.OnekeyShare;


/**
 * Created by demons on 2017/11/13.
 */

public class DiscoverFragment extends Fragment {

    private static String[] TITLES;
    private static String[] URLS = new String[]{"", "", "", ""};

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;

    private FrameLayout com_back_click;
    private TextView title_name;
    private TextView next;

    private void getData() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover,container,false);
        pager = (ViewPager) view.findViewById(R.id.view_pager);
        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.dis_tabs);

        com_back_click = (FrameLayout) view.findViewById(R.id.com_back_click);
        title_name = (TextView) view.findViewById(R.id.title_name);
        next = (TextView) view.findViewById(R.id.commonal_tv);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        com_back_click.setVisibility(View.GONE);
        title_name.setText("发现");
        next.setVisibility(View.VISIBLE);
        next.setText("筛选");
        next.setTextColor(getResources().getColor(R.color.color_text_blue_44));
        next.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                share();
            }
        });

        TITLES = getResources().getStringArray(R.array.news_titles);

        FragmentPagerAdapter adapter = new NewsAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);

        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
        pager.setPageMargin(pageMargin);

        tabs.setViewPager(pager);
    }

    class NewsAdapter extends FragmentPagerAdapter{

        public NewsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new ActiveFragment();
            }
            if (position == 1) {
                return new FristTagFragment();
            }
            if (position == 2) {
                return new FristTagFragment();
            }
            return FristTagFragment.newInstance(URLS[position % URLS.length]);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position % TITLES.length];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }
    }

    private void share() {
//        ShareSDK.initSDK(getContext());
        MobSDK.init(getContext());
        OnekeyShare oks = new OnekeyShare();
//        // 分享图文+链接
//        oks.setText("测试新浪微博"+"http://www.mob.com");
//        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
//
//        //回调方法
//        oks.setCallback(new PlatformActionListener() {
//            @Override
//            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
//                platform.getName();
//                Log.d("分享------","onComplete-------分享成功");
//                platform.isClientValid();
//            }
//
//            @Override
//            public void onError(Platform platform, int i, Throwable throwable) {
//                Log.d("分享------","onError-------分享失败"+throwable.getMessage()+"----"+throwable.getStackTrace().toString());
//                throwable.getMessage();
//                throwable.printStackTrace();
//            }
//
//            @Override
//            public void onCancel(Platform platform, int i) {
//                Log.d("分享------","onCancel-------分享取消");
//            }
//        });
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("Testing message");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        // 启动分享GUI
        oks.show(getContext());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        ShareSDK.stopSDK();
    }
}
