package com.mt.cardletter.fragment;


import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.mt.cardletter.R;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.rollviewpager.OnItemClickListener;
import com.mt.cardletter.view.rollviewpager.RollPagerView;
import com.mt.cardletter.view.rollviewpager.adapter.StaticPagerAdapter;
import com.mt.cardletter.view.tabstrip.PagerSlidingTabStrip;
import com.zaaach.citypicker.CityPickerActivity;


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

    private static final int REQUEST_CODE_PICK_CITY = 123;

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
    }

    //    @Override
//    protected int setLayoutResouceId() {
//        return R.layout.fragment_home;
//    }

//    @Override
//    public void initData() {
//        pagerView = findViewById(R.id.fragment_home_top_pagerview);
//        pagerView.setAdapter(new MyPagerAdapter());
//        pagerView.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//
//            }
//        });
//    }

    private void getData() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.make_integral://赚积分
                UIHelper.showMakeIntegralActivity(getContext());
                break;
            case R.id.search_integral://查积分
                UIHelper.showSearchIntegralActivity(getContext());
                break;
            case R.id.search_seckill://银行秒杀
                //TODO  银行秒杀
                UIHelper.showSeckillActivity(getContext());
                break;
            case R.id.my_order://订单
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
        private int[] image = {R.drawable.newer01, R.drawable.newer02, R.drawable.newer03, R.drawable.newer04};
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
}
