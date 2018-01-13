package com.mt.cardletter.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.mt.cardletter.R;
import com.mt.cardletter.activity.ScreenActivity;
import com.mt.cardletter.activity.SetailsActivity;
import com.mt.cardletter.entity.merchant.Goods;
import com.mt.cardletter.entity.news.News;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.CustomListView;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jk on 2017/12/11.
 */

public class ActiveFragment extends Fragment {
    private int cartgory_id ; //分类ID
    private List<String> list;
    private MyAdapter myAdapter;
    private CustomListView listView;
    private ScrollView parentScrollView;
    private int page_index = 1;
    private int viewY;
    private List<News.DataBeanX.DataBean> data1 = new ArrayList<>();

    private int last_index;
    private int total_index;

    private View loadmoreView;
    private boolean updata_flag = true;
    public ActiveFragment(ScrollView parentScrollView,int viewY) {
        this.parentScrollView = parentScrollView;
        this.viewY = viewY;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_layout, container, false);
        listView = (CustomListView) view.findViewById(R.id.list_view);
        loadmoreView = View.inflate(getContext(),R.layout.load_more,null);//上拉加载更多布局
        loadmoreView.setVisibility(View.VISIBLE);//设置刷新视图默认情况下是不可见的
        cartgory_id= (int) getArguments().get("id");
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        touchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));
        initData();
        initView();
        loadData(1,10,page_index,cartgory_id);
    }
    private void loadData(final int upDataFlag , int list_rows, final int page, int category_id) {
        /*
         * 获取商家列表
         */
        CardLetterRequestApi.getInstance().getNews(Constant.Access_Token,list_rows,page,category_id,new HttpSubscriber<News>(new SubscriberOnListener<News>() {
            @Override
            public void onSucceed(News data) {
                if (data.getCode()==0){
                    System.out.println("data.getData().getCurrentPage():"+data.getData().getCurrentPage());
                    loadmoreView.setVisibility(View.GONE);//设置刷新界面不可见
                    if (data.getData().getLastPage()<=1){
                        data1.addAll(data.getData().getData());
                        updata_flag = false;
                    }else if(data.getData().getLastPage()>1){
                        updata_flag = true;
                        System.out.println("===updata_flag===="+updata_flag);
                        data1.addAll(data.getData().getData());
                    }
                    if (data.getData().getLastPage() == data.getData().getCurrentPage()){
                        updata_flag = false;
                    }
                    myAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onError(int code, String msg) {
                loadmoreView.setVisibility(View.GONE);//设置刷新界面不可见
                System.out.println("msg:"+msg);
                ToastUtils.showShort(getContext(),"网络故障");
            }
        },getContext()));
    }
    private void initData() {
        list = new ArrayList<>();
        for (int i = 0 ; i <= 20 ; i ++ ){
            list.add("item"+i);
        }
    }

    private int mLastFirstPostion;
    private int mLastFirstTop;
    private int touchSlop;
    private void initView() {
        listView.setParentScrollView(parentScrollView);
        listView.addFooterView(loadmoreView,null,false);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), SetailsActivity.class);
                intent.putExtra("goods",list.get(position));
                UIHelper.showDetails(getContext(), intent);
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if(last_index == total_index && (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE))
                {
                    System.out.println("================="+updata_flag+"======");
                    if (updata_flag){
                        System.out.println("=======================");
                        loadmoreView.setVisibility(View.VISIBLE);
                        page_index = page_index+1;
                        loadData(1,10,page_index,cartgory_id);
                    }else{
                        ToastUtils.showShort(getContext(),"已经到底了");
                    }

                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                last_index = firstVisibleItem+visibleItemCount;
                total_index = totalItemCount;
                System.out.println("last:  "+last_index);
                System.out.println("total:  "+total_index);

                int currentTop;
                View firstChildView = listView.getChildAt(0);
                if (firstChildView != null) {
                    currentTop = listView.getChildAt(0).getTop();
                } else {
                    //ListView初始化的时候会回调onScroll方法，此时getChildAt(0)仍是为空的
                    return;
                }
                if (firstVisibleItem != mLastFirstPostion) {
                    //不是同一个位置
                    if (firstVisibleItem < mLastFirstPostion) {
                        if (firstVisibleItem == 0){
                            //TODO do down

                        }
                    }
                    mLastFirstTop = currentTop;
                }
                mLastFirstPostion = firstVisibleItem;
            }
        });
        listView.setAdapter(myAdapter = new MyAdapter());

    }


    class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return data1.size();
        }

        @Override
        public Object getItem(int position) {
            return data1.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(getContext(),R.layout.item_news, null);
                holder.tv_title = (TextView) convertView.findViewById(R.id.news_title);
                holder.tv_content = (TextView) convertView.findViewById(R.id.news_content);
                holder.img = (ImageView) convertView.findViewById(R.id.news_img);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
                holder.tv_title.setText(data1.get(position).getName());
                holder.tv_content.setText(data1.get(position).getDescribe());
                //构造请求头
                String credentials="51kalaxin:62kaxin";
                final String basic = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
                LazyHeaders headers=  new LazyHeaders.Builder().addHeader("Authorization", basic).build();
                Glide.with(ActiveFragment.this).load(new GlideUrl(Constant.BASE_URL+data1.get(position).getThumb(), headers)).error(R.drawable.default_error).into(holder.img);
            return convertView;
        }
        class ViewHolder{
            TextView tv_title;
            TextView tv_content;
            ImageView img;
        }
    }


}
