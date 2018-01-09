package com.mt.cardletter.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Base64;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.mt.cardletter.R;
import com.mt.cardletter.app.AppContext;
import com.mt.cardletter.entity.article.ArticleBean;
import com.mt.cardletter.entity.data.HeWeather;
import com.mt.cardletter.entity.merchant.FindCategoryList;
import com.mt.cardletter.entity.news.NewsCategory;
import com.mt.cardletter.entity.picture.PictureEntity;
import com.mt.cardletter.https.HttpRequestApi;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.SizeUtils;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.rollviewpager.OnItemClickListener;
import com.mt.cardletter.view.rollviewpager.RollPagerView;
import com.mt.cardletter.view.rollviewpager.adapter.StaticPagerAdapter;
import com.mt.cardletter.view.tabstrip.PagerSlidingTabStrip;
import com.zaaach.citypicker.CityPickerActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by demons on 2017/11/13.
 */

public class HomeFragment extends Fragment implements View.OnClickListener{

    private RollPagerView pagerView;//轮播图控件

    private ViewFlipper vf ;//为ViewFlipper添加广告条

    private static String[] TITLES;
    private static String[] URLS = new String[]{"", "", "", ""};

    private LinearLayout locatio_address;
    private TextView fragment_home_top_text_address;

    private RelativeLayout make_integral,search_integral,search_seckill,my_order;
    private LinearLayout pathContent;
    private static final int REQUEST_CODE_PICK_CITY = 123;
    private ScrollView parentScrollView;
    private LinearLayout pathContent2;
    private HeWeather.HeWeather6Bean weather6Bean;
    private Fragment[] fragments;

    private int mCurrPos;
    private Timer timer;
    private TimerTask task;
    List<String> testList = new ArrayList<>();
    private int count;
    private FragmentPagerAdapter adapter;

    private List<PictureEntity.DataBeanX.DataBean> dataBeanList = new ArrayList<>();
    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private List<NewsCategory.DataBean> tabDatas = new ArrayList<>();

    private int viewY;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        getDatas(view);
//        pagerView = (RollPagerView) view.findViewById(R.id.fragment_home_top_pagerview);
        pager = (ViewPager) view.findViewById(R.id.pager);
        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
//        vf.addView(View.inflate(getContext(), R.layout.notice_layout, null));
//        vf.addView(View.inflate(getContext(), R.layout.notice_layout, null));
//        vf.addView(View.inflate(getContext(), R.layout.notice_layout, null));
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
        countSize();
        loadData();
//        pagerView.setAdapter(new MyPagerAdapter(getContext(),dataBeanList));
//        pagerView.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//                ToastUtils.makeShortText("点击了---"+Constant.PIC_URL+dataBeanList.get(position).getThumb(),getContext());
//            }
//        });

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
            case R.id.search_seckill://TODO活动精选
                  UIHelper.showSeckillActivity(getContext());
//                UIHelper.showSeckillActivity(getContext());
            case R.id.my_order://订单
//                toLogin(Constant.Access_Token,"test","123123");
//                Util.showCommonDialog(getActivity(),R.drawable.error_500);
                UIHelper.showExpressActivity(getContext());
                break;
            case R.id.locatio_address://定位城市
                startActivityForResult(new Intent(getContext(), CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
                break;
            default:
                break;
        }
    }

    private void loadData() {
        /*
         * 获取文章分类列表
         */
        CardLetterRequestApi.getInstance().getHomeCategory(Constant.Access_Token,new HttpSubscriber<NewsCategory>(new SubscriberOnListener<NewsCategory>() {
            @Override
            public void onSucceed(NewsCategory data) {
                tabDatas = data.getData();
                FragmentPagerAdapter adapter = new NewsAdapter(getChildFragmentManager(),tabDatas);
                pager.setAdapter(adapter);
                final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
                pager.setPageMargin(pageMargin);
                tabs.setViewPager(pager);
                fragments = new Fragment[tabDatas.size()];
            }
            @Override
            public void onError(int code, String msg) {

                ToastUtils.showShort(getContext(),msg);
            }
        },getContext()));
    }
    /**
     *  指示器 的 适配器
     */

    class MyPagerAdapter extends StaticPagerAdapter{
        List<PictureEntity.DataBeanX.DataBean> dataBeanList  = new ArrayList<>();
        private Context context;
        public MyPagerAdapter(Context context,List<PictureEntity.DataBeanX.DataBean> dataBeanList) {
            this.context = context;
            this.dataBeanList = dataBeanList;
            System.out.println("----pic  size-----"+this.dataBeanList.size());
        }

        //        private int[] image = {R.drawable.new01, R.drawable.new02, R.drawable.new03, R.drawable.newer04};
        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
//            view.setImageResource(image[position]);
            System.out.println("---------pic--------"+Constant.PIC_URL+dataBeanList.get(position).getThumb());
            String credentials="51kalaxin:62kaxin";
            final String basic =
                    "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
            //Authorization 请求头信息
            LazyHeaders headers=  new LazyHeaders.Builder().addHeader("Authorization", basic).build();
            //用其它图片作为缩略图
            DrawableRequestBuilder<Integer> thumbnailRequest = Glide
                    .with(context)
                    .load(R.drawable.new03);
//            Glide.with(context)
//                    .load(Constant.PIC_URL+this.dataBeanList.get(position).getThumb())
//                    .thumbnail(thumbnailRequest)
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .into(view);
            Glide.with(context)
                    .load(new GlideUrl(Constant.PIC_URL+this.dataBeanList.get(position).getThumb(), headers))
                    .thumbnail(thumbnailRequest)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(view);;
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getCount() {
            return this.dataBeanList.size();
        }
    }


    class NewsAdapter extends FragmentPagerAdapter{
        FragmentManager childFragmentManage;
        List<NewsCategory.DataBean> tabDatas;


        public NewsAdapter(FragmentManager childFragmentManager, List<NewsCategory.DataBean> tabDatas) {
            super(childFragmentManager);
            this.childFragmentManage= childFragmentManager;
            this.tabDatas=tabDatas;
        }

        @Override
        public Fragment getItem(int position) {
            HomeCompleteFragment fragment =  new HomeCompleteFragment();
            Bundle bundle=new Bundle();
            bundle.putInt("id",tabDatas.get(position).getId());
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabDatas.get(position).getName();
        }

        @Override
        public int getCount() {
            return tabDatas.size();
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
    //计算距离
    private void countSize(){
        WindowManager wm = (WindowManager)getActivity().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        int dy = display.getHeight();
        int[] location = new int[2];
        pathContent2.getLocationOnScreen(location);
        int y = location[1];
        viewY = dy - y- SizeUtils.dip2px(getContext(),290);
        pathContent2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, viewY));
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

    private List<ArticleBean.DataBeanX.DataBean> list = new ArrayList<>();
    private void getDatas(final View view){
        CardLetterRequestApi.getInstance().getArticle(Constant.Access_Token,new HttpSubscriber<ArticleBean>(new SubscriberOnListener<ArticleBean>() {
            @Override
            public void onSucceed(ArticleBean data) {
                if (data.getCode()==0){
                    list=data.getData().getData();
                    vf = (ViewFlipper) view.findViewById(R.id.marquee_view);
                    for (int i = 0; i < list.size(); i++) {
                        final ArticleBean.DataBeanX.DataBean bean =list.get(i);
                        final View ll_content = View.inflate(getContext(),R.layout.notice_layout,null);
                        TextView text = (TextView) ll_content.findViewById(R.id.head_text);
                        text.setText(bean.getName().toString());
                        text.setOnClickListener(new OnMultiClickListener() {
                            @Override
                            public void onMultiClick(View v) {
                                UIHelper.showArticleActivity(getContext(),bean);
                            }
                        });
                        vf.addView(ll_content);
                    }
                }else {
                    ToastUtils.makeShortText(data.getMsg(),getContext());
                }
            }

            @Override
            public void onError(int code, String msg) {

            }
        },getContext()));

        CardLetterRequestApi.getInstance().getPics(Constant.Access_Token,"1","",new HttpSubscriber<PictureEntity>(new SubscriberOnListener<PictureEntity>() {
            @Override
            public void onSucceed(PictureEntity data) {
                if (data.getCode()==0){
                    pagerView = (RollPagerView) view.findViewById(R.id.fragment_home_top_pagerview);
                    dataBeanList=data.getData().get(0).getData();
                    pagerView.setAdapter(new MyPagerAdapter(getContext(),dataBeanList));
                    pagerView.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            ToastUtils.makeShortText("点击了---"+Constant.PIC_URL+dataBeanList.get(position).getThumb(),getContext());
                        }
                    });
                }else {
                    ToastUtils.makeShortText(data.getMsg(),getContext());
                }
            }

            @Override
            public void onError(int code, String msg) {

            }
        },getContext()));
    }
}
