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

import com.mt.cardletter.R;
import com.mt.cardletter.entity.merchant.FindCategoryList;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.tabstrip.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by demons on 2017/11/13.
 */

public class DiscoverFragment extends Fragment {

    private static String[] TITLES;
    private static String[] URLS = new String[]{"", "", "", ""};

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private List<FindCategoryList.DataBean> tabDatas;
    private FrameLayout com_back_click;
    private TextView title_name;
    private TextView next;
    private FragmentPagerAdapter adapter;
    private Fragment[] fragments;
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

    private void loadData() {
        /*
         * 获取分类列表
         */
        CardLetterRequestApi.getInstance().getFindCategroyList(Constant.Access_Token,new HttpSubscriber<FindCategoryList>(new SubscriberOnListener<FindCategoryList>() {
            @Override
            public void onSucceed(FindCategoryList data) {
                System.out.println("分类列表请求成功");
                tabDatas = data.getData();
                adapter.notifyDataSetChanged();
                tabs.notifyDataSetChanged();
                fragments = new Fragment[tabDatas.size()];
            }
            @Override
            public void onError(int code, String msg) {
                System.out.println("分类列表网络异常");
            }
        },getContext()));
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
                UIHelper.showScreenActivity(getContext());
            }
        });
        TITLES = getResources().getStringArray(R.array.news_titles);

        tabDatas = new ArrayList<>();
        adapter = new NewsAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);
        loadData();
        /*
         * 设置 tabs
         */
        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
        pager.setPageMargin(pageMargin);
        tabs.setViewPager(pager);

    }

    /**
     *  指示器 的 适配器
     */
    class NewsAdapter extends FragmentPagerAdapter{

        public NewsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (fragments[position] == null){
                fragments[position] = new CompleteFragment();
                Bundle bundle=new Bundle();
                bundle.putInt("id",tabDatas.get(position).getId());
                fragments[position].setArguments(bundle);
            }
            return fragments[position];
        }
        @Override
        public CharSequence getPageTitle(int position) {
            String name = tabDatas.get(position).getName();
            return name;
        }

        @Override
        public int getCount() {
            return tabDatas.size();
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
//        ShareSDK.stopSDK();
    }


}
