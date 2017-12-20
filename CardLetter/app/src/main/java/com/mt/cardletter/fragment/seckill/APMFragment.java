package com.mt.cardletter.fragment.seckill;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.view.rollviewpager.RollPagerView;
import com.mt.cardletter.view.rollviewpager.adapter.StaticPagerAdapter;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.Bind;

/**
 * jk 拼速度
 */
public class APMFragment extends Fragment implements  View.OnClickListener {
    @Bind({R.id.title_name})
    TextView title_name;
    @Bind({R.id.com_back_click})
    FrameLayout back;
    //存放view的数组
    private ArrayList<View> Views;
    //适配器类
    private ViewPagerAdapter mAdapter;
    //存放标题的数组
    private ArrayList<String> Titles;
    //PagerTabStrip
    private PagerTabStrip PagerTab;
    //ViewPager
    private ViewPager mViewPager;

    private RollPagerView mRollPagerView;
    private ListView mListViewForApmBeingView;
    private View view;
    private List<ApmBeingBean> listForApmBeingView;
    private View apmBeingView;
    private View apmprepare;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(), R.layout.fragment_apm, null);
        initView();
        //initData();
        return view;
    }

    private void initData() {
        listForApmBeingView = new ArrayList<>();
        for (int i = 0 ; i <10 ; i++){
            ApmBeingBean apm = new ApmBeingBean();
            apm.setTime("19:00场");
            apm.setDistime("距离开始时间还有25分20秒");
            apm.setImgUrl("");
            apm.setPrice("￥36.9元");
            apm.setBtnText("即将开始");
            listForApmBeingView.add(apm);
        }


    }


    private void initView() {
        //取得ViewPager实例
        mViewPager=(ViewPager)view.findViewById(R.id.ViewPager);
        //取得ViewTabStrip实例
        PagerTab=(PagerTabStrip)view.findViewById(R.id.PagerTab);
        //设置Tab选中时的颜色
        PagerTab.setTabIndicatorColor(getResources().getColor(R.color.home_text_selected));
        //设置Tab是否显示下划线
        PagerTab.setDrawFullUnderline(false);
        //设置Tab背景色
        PagerTab.setBackgroundColor(getResources().getColor(R.color.white));
        //设置Tab间的距离
        PagerTab.setTextSpacing(100);

        //初始化Views
        Views=new ArrayList<View>();
        apmBeingView = View.inflate(getContext(), R.layout.fragment_apmbeing, null);
        apmprepare = View.inflate(getContext(), R.layout.fragment_apmprepare, null);
        Views.add(apmBeingView);
        Views.add(apmprepare);
        //初始化Titles
        Titles=new ArrayList<String>();
        Titles.add("正在抢");
        Titles.add("准备抢");

        //初始化适配器
        mAdapter=new ViewPagerAdapter(Views,Titles);
        mViewPager.setAdapter(mAdapter);

        //默认显示第1项
        SetTab(0);

        mRollPagerView = (RollPagerView) view.findViewById(R.id.fragment_eckill_top_pagerview);
        mRollPagerView.setAdapter(new MyPagerAdapter());
        title_name = (TextView) view.findViewById(R.id.title_name);
        title_name.setText("每日秒杀");
        back = (FrameLayout) view.findViewById(R.id.com_back_click);
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);


    }

    /**
     *  适配 ListView - apmBeingView
     */
    class MyListAdapyer extends BaseAdapter{
        private List list;
        public MyListAdapyer(List<ApmBeingBean> list){
            this.list = list;
        }
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = View.inflate(getContext(), R.layout.fragment_amp_being_buy_item, null);
            return itemView;
        }
    }
    /**
     * 适配两个VIEW的数据
     */

    public void SetTab(int index)
    {
        switch(index)
        {
            case 0:
                mViewPager.setCurrentItem(0);
                break;
            case 1:
                mViewPager.setCurrentItem(1);
                break;
        }

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.com_back_click:
                getActivity().finish();
                break;
        }
    }

    /**
     * 适配轮播图
     */
    class MyPagerAdapter extends StaticPagerAdapter {
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

    /**
     * 适配 ViewPager
     */
    class ViewPagerAdapter extends PagerAdapter
    {
        //存放View的数组
        private ArrayList<View> Views;
        //存放Title的数组
        private ArrayList<String> Titles;


        public ViewPagerAdapter(ArrayList<View> Views,ArrayList<String> Titles)
        {
            this.Views=Views;
            this.Titles=Titles;
        }

        //获取PageTitle
        @Override
        public CharSequence getPageTitle(int position)
        {
            return Titles.get(position);
        }

        @Override
        public void destroyItem(View container, int position, Object object)
        {
            ((ViewPager)container).removeView(Views.get(position));
        }

        @Override
        public Object instantiateItem(View container, int position)
        {


            ((ViewPager)container).addView(Views.get(position),0);
//            if(position == 0){
//                mListViewForApmBeingView = (ListView) Views.get(position).findViewById(R.id.apm_being_lv);
//                MyListAdapyer adapyer =   new MyListAdapyer(listForApmBeingView);
//                mListViewForApmBeingView.setAdapter(new MyListAdapyer(listForApmBeingView));
//                adapyer.notifyDataSetChanged();
//            }
            return Views.get(position);
    }

        @Override
        public int getCount()
        {
            if(Views!=null)
            {
                return Views.size();
            }
            return 0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object)
        {
            return (view==object);
        }

    }
    class ApmBeingBean{
        private String time;
        private String distime;
        private String title;
        private String btnText;
        private String price;
        private String imgUrl;
        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getDistime() {
            return distime;
        }

        public void setDistime(String distime) {
            this.distime = distime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getBtnText() {
            return btnText;
        }

        public void setBtnText(String btnText) {
            this.btnText = btnText;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}
