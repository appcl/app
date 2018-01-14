package com.mt.cardletter.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Base64;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.mt.cardletter.activity.CityPickerActivity;
import com.mt.cardletter.app.AppContext;
import com.mt.cardletter.entity.article.ArticleBean;
import com.mt.cardletter.entity.data.HeWeather;
import com.mt.cardletter.entity.news.NetNewsCategory;
import com.mt.cardletter.entity.picture.PictureEntity;
import com.mt.cardletter.https.HttpRequestApi;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.https.test.TestRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.Scroll.MyViewPager;
import com.mt.cardletter.view.Scroll.TopScrollView;
import com.mt.cardletter.view.rollviewpager.OnItemClickListener;
import com.mt.cardletter.view.rollviewpager.RollPagerView;
import com.mt.cardletter.view.rollviewpager.adapter.StaticPagerAdapter;
import com.mt.cardletter.view.tabstrip.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by demons on 2017/11/13.
 */

public class CardHomeFragment extends Fragment implements View.OnClickListener,TopScrollView.OnScrollListener{
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
    //======================================
    private PagerSlidingTabStrip search_edit;
    private TopScrollView myScrollView;
    private int searchLayoutTop;
    LinearLayout search01,search02;
    RelativeLayout rlayout;
    private View view;
    private boolean isOk = false;

    //======================================
    private int mCurrPos;
    private Timer timer;
    private TimerTask task;
    List<String> testList = new ArrayList<>();
    private int count;
    private FragmentPagerAdapter adapter;

    private List<PictureEntity.DataBeanX.DataBean> dataBeanList = new ArrayList<>();
    private PagerSlidingTabStrip tabs;
    private MyViewPager pager;
    private List<String>  tabDatas = new ArrayList<>();

    private int viewY;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test,container,false);
        getDatas(view);

        //========
        pager = (MyViewPager) view.findViewById(R.id.pager);
        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);

        tabs.setFocusable(true);
        tabs.setFocusableInTouchMode(true);
        tabs.requestFocus();
        pager.setFocusable(false);

        init();
        //========
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
        loadData();
    }
    //======================================
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void init() {
        search_edit = (PagerSlidingTabStrip)view.findViewById(R.id.tabs);
        myScrollView = (TopScrollView)view.findViewById(R.id.myScrollView);
        myScrollView.scrollTo(0,0);

        search01 = (LinearLayout)view.findViewById(R.id.search01);
        search02 = (LinearLayout)view.findViewById(R.id.search02);
        rlayout = (RelativeLayout)view.findViewById(R.id.rlayout);
        myScrollView.setOnScrollListener(this);

        myScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY!=oldScrollY){
                    isOk = true;
                    searchLayoutTop = rlayout.getBottom();//获取searchLayout的顶部位置
                }
            }
        });

    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){

        } else {

        }
    }
    //监听滚动Y值变化，通过addView和removeView来实现悬停效果
    @Override
    public void onScroll(int scrollY) {
        if(isOk){
            if(scrollY >= searchLayoutTop){
                if (search_edit.getParent()!=search01) {
                    search02.removeView(search_edit);
                    search01.addView(search_edit);
                }
            }else{
                if (search_edit.getParent()!=search02) {
                    search01.removeView(search_edit);
                    search02.addView(search_edit);
                }
            }
        }

    }

    //========================================
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
        TestRequestApi.getInstance().getNetNewsCategory(Constant.NEWS_KEY,new HttpSubscriber<NetNewsCategory>(new SubscriberOnListener<NetNewsCategory>() {
            @Override
            public void onSucceed(NetNewsCategory data) {
                tabDatas = data.getResult().getResult();
                fragments = new Fragment[tabDatas.size()];
                FragmentPagerAdapter adapter = new CardHomeFragment.NewsAdapter(getChildFragmentManager(),tabDatas);
                pager.setAdapter(adapter);
                final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
                pager.setPageMargin(pageMargin);
                //pager1.setOffscreenPageLimit(tabDatas.size());
                pager.setOffscreenPageLimit(1);
                tabs.setViewPager(pager);
            }
            @Override
            public void onError(int code, String msg) {
                System.out.println("msg======"+msg);
                ToastUtils.showShort(getContext(),"网络故障");
            }
        },getContext()));
    }
    /**
     *   适配器
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
                    .into(view);
            view.setScaleType(ImageView.ScaleType.CENTER);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getCount() {
            return this.dataBeanList.size();
        }
    }

    /**
     *  指示器 的 适配器
     */
    class NewsAdapter extends FragmentPagerAdapter{
        FragmentManager childFragmentManage;
        List<String> tabDatas;
        public NewsAdapter(FragmentManager childFragmentManager,List<String> tabDatas) {
            super(childFragmentManager);
            this.childFragmentManage= childFragmentManager;
            this.tabDatas = tabDatas;
        }
        @Override
        public Fragment getItem(int position) {
            if (fragments[position] == null){
                fragments[position] =  new NetNewsFragment(myScrollView,pager);
                Bundle bundle=new Bundle();
                bundle.putString("news_category",tabDatas.get(position));
                bundle.putInt("pager_id",position);
                //bundle.putSerializable("myScrollView",myScrollView);
                fragments[position].setArguments(bundle);
            }
            return fragments[position];
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return tabDatas.get(position).toString();
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
