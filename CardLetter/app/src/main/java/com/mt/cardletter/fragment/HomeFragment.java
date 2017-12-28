package com.mt.cardletter.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.mt.cardletter.R;
import com.mt.cardletter.app.AppContext;
import com.mt.cardletter.entity.data.HeWeather;
import com.mt.cardletter.https.HttpRequestApi;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.utils.SizeUtils;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.utils.Util;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshListView;
import com.mt.cardletter.view.rollviewpager.OnItemClickListener;
import com.mt.cardletter.view.rollviewpager.RollPagerView;
import com.mt.cardletter.view.rollviewpager.adapter.StaticPagerAdapter;
import com.mt.cardletter.view.tabstrip.PagerSlidingTabStrip;
import com.umeng.socialize.utils.Log;
import com.zaaach.citypicker.CityPickerActivity;

import butterknife.Bind;


/**
 * Created by demons on 2017/11/13.
 */

public class HomeFragment extends Fragment implements View.OnClickListener{

    private RollPagerView pagerView;//轮播图控件

    private ViewFlipper vf ;//为ViewFlipper添加广告条

    private static String[] TITLES;
    private static String[] URLS = new String[]{"", "", "", ""};

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private LinearLayout locatio_address;
    private TextView fragment_home_top_text_address;

    private RelativeLayout make_integral,search_integral,search_seckill,my_order;
    private LinearLayout pathContent;
    private static final int REQUEST_CODE_PICK_CITY = 123;
    private ScrollView parentScrollView;
    private LinearLayout pathContent2;
    private HeWeather.HeWeather6Bean weather6Bean;

    private int viewY;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        pagerView = (RollPagerView) view.findViewById(R.id.fragment_home_top_pagerview);
        pager = (ViewPager) view.findViewById(R.id.pager);
        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        vf = (ViewFlipper) view.findViewById(R.id.marquee_view);
        vf.addView(View.inflate(getContext(), R.layout.notice_layout, null));
        vf.addView(View.inflate(getContext(), R.layout.notice_layout, null));
        vf.addView(View.inflate(getContext(), R.layout.notice_layout, null));
        pathContent2 = (LinearLayout) view.findViewById(R.id.path_content2);
        make_integral = (RelativeLayout) view.findViewById(R.id.make_integral);
        search_integral = (RelativeLayout) view.findViewById(R.id.search_integral);
        search_seckill = (RelativeLayout) view.findViewById(R.id.search_seckill);
        my_order = (RelativeLayout) view.findViewById(R.id.my_order);

        locatio_address= (LinearLayout) view.findViewById(R.id.locatio_address);
        fragment_home_top_text_address= (TextView) view.findViewById(R.id.fragment_home_top_text_address);

        make_integral.setOnClickListener(this);
        search_integral.setOnClickListener(this);
        search_seckill.setOnClickListener(this);
        my_order.setOnClickListener(this);

        locatio_address.setOnClickListener(this);
        parentScrollView = (ScrollView) view.findViewById(R.id.home_scroll);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pagerView.setAdapter(new MyPagerAdapter());
        pagerView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ToastUtils.makeShortText("点击了---"+position,getContext());
            }
        });
        TITLES = getResources().getStringArray(R.array.news_titles);
        FragmentPagerAdapter adapter = new NewsAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);
        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
        pager.setPageMargin(pageMargin);
        tabs.setViewPager(pager);

        //计算距离
        WindowManager wm = (WindowManager)getActivity().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        int dx = display.getWidth();
        int dy = display.getHeight();
        int[] location = new int[2];
        pathContent2.getLocationOnScreen(location);
        int x = location[0];
        int y = location[1];
        viewY = dy - y- SizeUtils.dip2px(getContext(),290);
        pathContent2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, viewY));

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.make_integral://赚积分
                System.out.println(AppContext.getInstance().getDistrict());
                if (AppContext.getInstance().getDistrict()!=null){
                    getDatas(AppContext.getInstance().getDistrict(),"5ee8321670ca46aab8e7555d3b3c074b");
                }else {
                    getDatas(AppContext.getInstance().getCity(),"5ee8321670ca46aab8e7555d3b3c074b");
                }

                break;
            case R.id.search_integral://查积分
//                UIHelper.showSearchIntegralActivity(getContext());
                UIHelper.showViolateActivity(getContext());
                break;
            case R.id.search_seckill://银行秒杀
                //TODO  银行秒杀
                  UIHelper.showSeckillActivity(getContext());
//                UIHelper.showSeckillActivity(getContext());
            case R.id.my_order://订单
                Util.showCommonDialog(getActivity(),R.drawable.error_500);
                break;
            case R.id.locatio_address://定位城市
                startActivityForResult(new Intent(getContext(), CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
                break;
            default:
                break;
        }
    }


    class MyPagerAdapter extends StaticPagerAdapter{
        private int[] image = {R.drawable.new01, R.drawable.new02, R.drawable.new03, R.drawable.newer04};
        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(image[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getCount() {
            return image.length;
        }
    }


    class NewsAdapter extends FragmentPagerAdapter{

        public NewsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new ActiveFragment(parentScrollView,viewY);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == -1){
            if (data != null){
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                fragment_home_top_text_address.setText(city);
            }
        }
    }


    private void getDatas(final String city, String key) {
        weather6Bean=new HeWeather.HeWeather6Bean();
        HttpRequestApi.getInstance().getWeather(city,key,new HttpSubscriber<HeWeather>(new SubscriberOnListener<HeWeather>() {
            @Override
            public void onSucceed(HeWeather data) {
                String statue=data.getHeWeather6().get(0).getStatus();
                weather6Bean= data.getHeWeather6().get(0);
                if (statue.equals("ok")){
                    UIHelper.showWeather(getContext(),city,weather6Bean);
                }else {
                    weather6Bean=new HeWeather.HeWeather6Bean();
                    ToastUtils.makeShortText("小信加载数据出错啦，请稍后再试",getContext());
                }
            }

            @Override
            public void onError(int code, String msg) {
            }
        },getContext()));
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }

}
