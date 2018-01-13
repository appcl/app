package com.mt.cardletter.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.mt.cardletter.R;
import com.mt.cardletter.activity.NetNewsActivity;
import com.mt.cardletter.activity.SetailsActivity;
import com.mt.cardletter.app.AppContext;
import com.mt.cardletter.entity.news.NetNews;
import com.mt.cardletter.entity.news.NetNewsForMap;
import com.mt.cardletter.entity.news.News;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.https.test.TestRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.CustomListView;
import com.mt.cardletter.view.Scroll.MyViewPager;
import com.mt.cardletter.view.Scroll.TopScrollView;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

/**
 * Created by jk on 2017/12/11.
 */

public class NetNewsFragment extends Fragment {
    private MyAdapter myAdapter;
    private ListView listView;
    private int page_index = 1;
    private  List<NetNews.ResultBeanX.ResultBean.ListBean> data1 = new ArrayList<>();
    private int last_index;
    private int total_index;
    private View loadmoreView;
    private boolean updata_top = true;
    private boolean updata_bottom = true;
    private String news_category;
    private int start=0; //查询新闻的开始
    private TopScrollView top;
    private MyViewPager myViewPager;
    private View view;

    public NetNewsFragment(TopScrollView myScrollView, MyViewPager pager1) {
        top = myScrollView;
        myViewPager = pager1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_fragment_layout, container, false);
        listView = (ListView) view.findViewById(R.id.list_view);
        loadmoreView = View.inflate(getContext(),R.layout.load_more,null);//上拉加载更多布局
        loadmoreView.setVisibility(View.VISIBLE);//设置刷新视图默认情况下是不可见的
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        news_category = (String) getArguments().get("news_category");
        if (news_category!=null){
            if (news_category.equals("本地")){
                System.out.println("===========  "+news_category);
                String city = AppContext.getInstance().getCity();
                System.out.println("===========  "+city);
                loadDataForMap("南京");
            }else{
                loadData(1,news_category,0);
            }
        }
    }

    /**
     * 本地新闻
     * @param news_category
     */
    private void loadDataForMap(String news_category) {
        TestRequestApi.getInstance().getLocalityNews(news_category,Constant.NEWS_KEY,new HttpSubscriber<NetNews>(new SubscriberOnListener<NetNews>() {
            @Override
            public void onSucceed(NetNews data) {
                if (Integer.parseInt(data.getCode())==10000){
                    List<NetNews.ResultBeanX.ResultBean.ListBean> list = data.getResult().getResult().getList();
                    myAdapter.addData(list.subList(0,10));
                }
            }
            @Override
            public void onError(int code, String msg) {
                System.out.println("msg:"+msg);
                ToastUtils.showShort(getContext(),"网络故障");
                updata_bottom = true;
            }
        },getContext()));
    }

    private void loadData(final int upDataFlag ,String channel,int start) {
        /*
         * 获取商家列表 System.out.println("======刷新加载");
         */
        TestRequestApi.getInstance().getNetNews(channel,10,start,Constant.NEWS_KEY,new HttpSubscriber<NetNews>(new SubscriberOnListener<NetNews>() {
            @Override
            public void onSucceed(NetNews data) {
                if (Integer.parseInt(data.getCode())==10000){
                    List<NetNews.ResultBeanX.ResultBean.ListBean> list = data.getResult().getResult().getList();
                    if (upDataFlag==1) {
                        updata_bottom = true;
                        myAdapter.addData(list);
                    }else if(upDataFlag==2){
                        updata_bottom = true;
                        myAdapter.addData(list);
                    }
                }
            }
            @Override
            public void onError(int code, String msg) {
                System.out.println("msg:"+msg);
                ToastUtils.showShort(getContext(),"网络故障");
                updata_bottom = true;
            }
        },getContext()));
    }

    private void initView() {
        listView.addFooterView(loadmoreView,null,false);

        /**
         *  条目点击事件
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), NetNewsActivity.class);
                intent.putExtra("net_url",data1.get(position).getUrl());
                UIHelper.showDetails(getContext(), intent);
            }
        });

        top.setOnScrollBottomListener(new TopScrollView.OnScrollBottomListener() {
            @Override
            public void onScroll() {

            }
        });
        top.setOnScrollTopListener(new TopScrollView.OnScrollTopListener() {
            @Override
            public void onScroll() {

            }
        });
        listView.setAdapter(myAdapter = new MyAdapter(data1));

    }
    class MyAdapter extends BaseAdapter{
        private List<NetNews.ResultBeanX.ResultBean.ListBean> list;
        public MyAdapter(List<NetNews.ResultBeanX.ResultBean.ListBean> list){
            this.list = new ArrayList<>();
            this.list = list;
        }

        public void addData(List<NetNews.ResultBeanX.ResultBean.ListBean> list){
            this.list.addAll(list);
            setListViewHeightBasedOnChildren(listView);
            notifyDataSetChanged();
        }
        public void clearData(){
            this.list.clear();
            notifyDataSetChanged();
        }
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
            System.out.println("getView===  "+position+"   数据"+this.list.get(position).getTitle());
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
                holder.tv_title.setText(data1.get(position).getTitle());
                holder.tv_content.setText(data1.get(position).getTime());
                if (data1.get(position).getPic() != null){
                    Glide.with(NetNewsFragment.this).load(data1.get(position).getPic()).error(R.drawable.default_error).into(holder.img);
                }
            return convertView;
        }
        class ViewHolder{
            TextView tv_title;
            TextView tv_content;
            ImageView img;
        }
    }
    /**
     * 动态设置ListView的高度
     * @param listView
     */
    public void setListViewHeightBasedOnChildren(ListView listView) {
        if(listView == null) return;
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
