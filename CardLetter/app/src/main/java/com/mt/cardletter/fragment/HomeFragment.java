package com.mt.cardletter.fragment;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.app.hubert.guide.NewbieGuide;
import com.app.hubert.guide.core.Controller;
import com.app.hubert.guide.listener.OnGuideChangedListener;
import com.app.hubert.guide.listener.OnLayoutInflatedListener;
import com.app.hubert.guide.listener.OnPageChangedListener;
import com.app.hubert.guide.model.GuidePage;
import com.app.hubert.guide.model.HighLight;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mob.analysdk.AnalySDK;
import com.mt.cardletter.MainActivity;
import com.mt.cardletter.R;
import com.mt.cardletter.activity.CityPickerActivity;
import com.mt.cardletter.activity.MoreTabActivity;
import com.mt.cardletter.activity.comment.CreditWebActivity;
import com.mt.cardletter.entity.article.ArticleBean;
import com.mt.cardletter.entity.data.HeWeather;
import com.mt.cardletter.entity.news.NetNewsCategory;
import com.mt.cardletter.entity.picture.PictureEntity;
import com.mt.cardletter.https.HttpRequestApi;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.https.test.TestRequestApi;
import com.mt.cardletter.utils.AnalySDKUtil;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.GalleyTransFormer;
import com.mt.cardletter.view.Scroll.MyViewPager;
import com.mt.cardletter.view.Scroll.TopScrollView;
import com.mt.cardletter.view.dialog.CustomDialog;
import com.mt.cardletter.view.rollviewpager.OnItemClickListener;
import com.mt.cardletter.view.rollviewpager.RollPagerView;
import com.mt.cardletter.view.rollviewpager.adapter.StaticPagerAdapter;
import com.mt.cardletter.view.tabstrip.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static com.app.hubert.guide.NewbieGuide.TAG;


/**
 * Created by demons on 2017/11/13.
 */

public class HomeFragment extends Fragment implements View.OnClickListener,TopScrollView.OnScrollListener{
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
    LinearLayout search01,search02,search03;
    RelativeLayout rlayout;
    private View view;
    private boolean isOk = false;
    private int checkYD = 0;//首页有
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
    private RelativeLayout search_et_input;
    private RelativeLayout part_2,part_4;
    private TextView district;

    private ViewPager viewPager;
    private int[] arr = new int[]{R.drawable.main_banner, R.drawable.icon_shop, R.drawable.food0};

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.test,container,false);
        getDatas(view);
        //========
        pager = (MyViewPager) view.findViewById(R.id.pager);
        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        part_2 = (RelativeLayout)view.findViewById(R.id.part_2);
        part_4 = (RelativeLayout)view.findViewById(R.id.part_4);
        part_2.setOnClickListener(this);
        part_4.setOnClickListener(this);
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

        //搜索框
        search_et_input= (RelativeLayout) view.findViewById(R.id.search_main_et_input);
        search_et_input.setFocusable(false);//让EditText失去焦点，然后获取点击事件
        search_et_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.showSearchActivity(getContext());
            }
        });


        viewPager = (ViewPager) view.findViewById(R.id.gallery_1_viewpager);
        viewPager.setPageTransformer(true, new GalleyTransFormer());
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return arr.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageResource(arr[position]);
                container.addView(imageView);
                return imageView;
            }
        });
        viewPager.setCurrentItem(1);
        /*设置点击ViewPager之外的部位，ViewPager跟着滑动*/
        RelativeLayout parent = (RelativeLayout) viewPager.getParent();
        parent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return viewPager.dispatchTouchEvent(event);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //loadData();//加载新闻
    }


    //======================================
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void init() {
        search_edit = (PagerSlidingTabStrip)view.findViewById(R.id.tabs);
        myScrollView = (TopScrollView)view.findViewById(R.id.myScrollView);
        myScrollView.scrollTo(0,0);

        search01 = (LinearLayout)view.findViewById(R.id.search01);
        search02 = (LinearLayout)view.findViewById(R.id.search02);
        search03 = (LinearLayout)view.findViewById(R.id.search03);
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
//                System.out.println(AppContext.getInstance().getDistrict());
//                if (AppContext.getInstance().getDistrict()!=null){
                getDatas(fragment_home_top_text_address.getText().toString(),"5ee8321670ca46aab8e7555d3b3c074b");
//                }else {
//                    getDatas(AppContext.getInstance().getCity(),"5ee8321670ca46aab8e7555d3b3c074b");
//                }
                break;
            case R.id.search_integral://查积分
//                UIHelper.showSearchIntegralActivity(getContext());
                UIHelper.showViolateActivity(getContext());
                break;
            case R.id.search_seckill://TODO活动精选
//                UIHelper.showSeckillActivity(getContext());
//                UIHelper.showSeckillActivity(getContext());
                ToastUtils.makeShortText("功能待开放",getContext());
                break;
            case R.id.my_order://订单
//                toLogin(Constant.Access_Token,"test","123123");
//                Util.showCommonDialog(getActivity(),R.drawable.error_500);
                UIHelper.showExpressActivity(getContext());
                break;
            case R.id.locatio_address://定位城市
                startActivityForResult(new Intent(getContext(), CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
                break;
            case R.id.part_2: //跳转卡积分
                ((MainActivity) getActivity()).showJFFragment();
                break;
            case R.id.part_4: //跳转
                AnalySDKUtil.registEvrnt("apply","申请信用卡");
                startActivity(new Intent(getContext(), CreditWebActivity.class));
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
                FragmentPagerAdapter adapter = new NewsAdapter(getChildFragmentManager(),tabDatas);
                pager.setAdapter(adapter);
                final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
                pager.setPageMargin(pageMargin);
                // pager.setOffscreenPageLimit(tabDatas.size());
                pager.setOffscreenPageLimit(1);
                tabs.setViewPager(pager);
                checkShowYD();//1
            }
            @Override
            public void onError(int code, String msg) {
                ToastUtils.showShort(getContext(),"网络故障");
            }
        },getContext()));
    }

    //城市发生变化弹出的dialog
    private void showToast(String city) {
        CustomDialog.Builder builder = new CustomDialog.Builder(getContext());
        builder.setTitle("当前定位到"+"南京"+"是否要切换城市？");
        builder.setPositiveButton("切换", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //设置你的操作事项
                dialog.dismiss();
                startActivityForResult(new Intent(getContext(), CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
            }
        });

        builder.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        builder.create().show();
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
            //Authorization 请求头信息
            Glide.with(context)
                    .load(Constant.PIC_URL+this.dataBeanList.get(position).getThumb())
                    .error(R.drawable.default_error)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(view);
//            Glide.with(context)
//                    .load(R.drawable.img_test)
//                    .error(R.drawable.default_error)
//                    .diskCacheStrategy(DiskCacheStrategy.ALL)
//                    .into(view);
            view.setScaleType(ImageView.ScaleType.FIT_XY);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getCount() {
            return dataBeanList.size();
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
                fragments[position] =  new NetNewsFragment(myScrollView,pager,search03);
                Bundle bundle=new Bundle();
                bundle.putString("news_category",tabDatas.get(position));
                bundle.putInt("pager_id",position);
                fragments[position].setArguments(bundle);
            }
//            NetNewsFragment netNewsFragment = new NetNewsFragment(myScrollView, pager, search03);
//                Bundle bundle=new Bundle();
//                bundle.putString("news_category",tabDatas.get(position));
//                bundle.putInt("pager_id",position);
//                netNewsFragment.setArguments(bundle);
            return  fragments[position];
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
                String id = data.getStringExtra("cityID");
                System.out.println("---cityID-------"+id);
                Constant.CITY_ID = id;
                fragment_home_top_text_address.setText(city);
                Constant.LOACTION_CITY = fragment_home_top_text_address.getText().toString();
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
                    System.out.println(city+"");
                    UIHelper.showWeather(getContext(),city,weather6Bean);
                }else {
                    weather6Bean=new HeWeather.HeWeather6Bean();
                    ToastUtils.makeShortText("小信加载数据出错啦，请稍后再试",getContext());
                }
                checkShowYD();//2
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
                    checkShowYD();//3
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
//                            System.out.println("点击了---"+Constant.PIC_URL+dataBeanList.get(position).getThumb());
                            Intent intent = new Intent(getContext(), MoreTabActivity.class);
                            startActivity(intent);
                        }
                    });
                    checkShowYD();//4
                }else {
                    ToastUtils.makeShortText(data.getMsg(),getContext());
                }
            }

            @Override
            public void onError(int code, String msg) {

            }
        },getContext()));
    }

    /**
     * 须成功完成3次数据加载
     * 才会进行引导层的显示  checkYD == 3
     */
    private void checkShowYD(){
        ++checkYD;
        if (checkYD == 3){
            showYD();
        }
    }
    /**
     * 显示引导层
     */
    private void showYD(){
        NewbieGuide.with(this)
                .setLabel("page")//设置引导层标示区分不同引导层，必传！否则报错
                .setOnGuideChangedListener(new OnGuideChangedListener() {
                    @Override
                    public void onShowed(Controller controller) {

                    }
                    @Override
                    public void onRemoved(Controller controller) {

                    }
                })
                .setOnPageChangedListener(new OnPageChangedListener() {
                    @Override
                    public void onPageChanged(int page) {
                        Log.e(TAG, "NewbieGuide  onPageChanged: " + page);
                        //引导页切换，page为当前页位置，从0开始
                    }
                })
                .alwaysShow(true)//是否每次都显示引导层，默认false，只显示一次
                .addGuidePage(//添加一页引导页
                        GuidePage.newInstance()//创建一个实例
                                //.addHighLight(button)//添加高亮的view
                                .addHighLight(part_2, HighLight.Shape.ROUND_RECTANGLE,10,10)
                                .setLayoutRes(R.layout.view_guide,R.id.textView3)//设置引导页布局
                                .setEverywhereCancelable(false)//是否点击任意地方跳转下一页或者消失引导层，默认true
                                .setOnLayoutInflatedListener(new OnLayoutInflatedListener() {
                                    @Override
                                    public void onLayoutInflated(View view) {
                                        //引导页布局填充后回调，用于初始化
//                                        TextView tv = view.findViewById(R.id.textView2);
//                                        tv.setText("我是动态设置的文本");
                                    }
                                })
                                //.setEnterAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.add_new_out))//进入动画
                               //.setExitAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.activity_close_enter))//退出动画
                )
                .addGuidePage(
                        GuidePage.newInstance()
                                .addHighLight(part_4, HighLight.Shape.RECTANGLE,20)
                                .setLayoutRes(R.layout.view_guide2, R.id.textView3)//引导页布局，点击跳转下一页或者消失引导层的控件id
                                .setEverywhereCancelable(false)//是否点击任意地方跳转下一页或者消失引导层，默认true
                        //.setBackgroundColor(getResources().getColor(R.color.testColor))//设置背景色，建议使用有透明度的颜色
                        //.setEnterAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.add_new_in))//进入动画
                        .setExitAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.add_new_out))//退出动画
                )
                .show();//显示引导层(至少需要一页引导页才能显示)
    }
}
