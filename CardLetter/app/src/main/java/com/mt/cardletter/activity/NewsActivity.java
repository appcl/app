package com.mt.cardletter.activity;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mt.cardletter.R;
import com.mt.cardletter.entity.news.NetNews;
import com.mt.cardletter.fragment.CompleteFragment;
import com.mt.cardletter.fragment.NetNewsFragment;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.test.TestRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshBase;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends BaseActivity {
    private PullToRefreshListView listView;
    private List<NetNews.ResultBeanX.ResultBean.ListBean> list;
    private MyAdapter myAdapter;
    private static int UPDATA_DOWN = 0x1;
    private static int UPDATA_UP = 0x2;
    private static int UPDATA_DEF = 0x3;
    private String channel = "头条";
    private int start = 0;
    private String news_category;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_news;
    }

    @Override
    public void initView() {
        news_category = getIntent().getExtras().getString("news_category");
        channel = news_category;
        TextView title_name = (TextView) findViewById(R.id.title_name);
        title_name.setText(news_category);
        FrameLayout back = (FrameLayout) findViewById(R.id.com_back_click);
        back.setVisibility(View.VISIBLE);
        list = new ArrayList<>();
        listView = (PullToRefreshListView) findViewById(R.id.listView);
        myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        /**
         * 条目点击事件
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NewsActivity.this, NewsItemActivity.class);
                intent.putExtra("new",list.get(position-1));
                startActivity(intent);
            }
        });
        /**
         * 注册加载
         */

        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                start = 0;
                loadData( UPDATA_DOWN ,channel ,start);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                start = start +10;
                loadData( UPDATA_UP , channel ,start);
            }
        });
        loadData(UPDATA_DEF,channel,0);

    }
    private void loadData(final int upDataFlag ,String channel,int start) {
        TestRequestApi.getInstance().getNetNews(channel,10,start,Constant.NEWS_KEY,new HttpSubscriber<NetNews>(new SubscriberOnListener<NetNews>() {
            @Override
            public void onSucceed(NetNews data) {
                if (Integer.parseInt(data.getCode())==10000){
                    List<NetNews.ResultBeanX.ResultBean.ListBean> data1 = data.getResult().getResult().getList();
                    if (upDataFlag == UPDATA_DEF){
                        list = data1;
                    } else if(upDataFlag == UPDATA_DOWN){
                        list = data1;
                    } else if(upDataFlag == UPDATA_UP){
                        list.addAll(data1);
                    }
                    myAdapter.notifyDataSetChanged();
                    listView.onRefreshComplete();
                }
            }
            @Override
            public void onError(int code, String msg) {
                System.out.println("msg:"+msg);
                ToastUtils.showShort(NewsActivity.this,"网络故障");

            }
        },NewsActivity.this));
    }
    class MyAdapter extends BaseAdapter {

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
            NewsActivity.MyAdapter.ViewHolder holder;
            if (convertView == null) {
                holder = new NewsActivity.MyAdapter.ViewHolder();
                convertView = View.inflate(NewsActivity.this,R.layout.item_news, null);
                holder.tv_title = (TextView) convertView.findViewById(R.id.news_title);
                holder.tv_content = (TextView) convertView.findViewById(R.id.news_content);
                holder.img = (ImageView) convertView.findViewById(R.id.news_img);
                convertView.setTag(holder);
            } else {
                holder = (NewsActivity.MyAdapter.ViewHolder) convertView.getTag();
            }
            holder.tv_title.setText(list.get(position).getTitle());
            holder.tv_content.setText(list.get(position).getTime());

            Glide.with(NewsActivity.this).load(list.get(position).getPic()).error(R.drawable.default_error).into(holder.img);


            return convertView;
        }
        class ViewHolder{
            TextView tv_title;
            TextView tv_content;
            ImageView img;
        }
    }

    @Override
    public void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void handler(Message msg) {

    }
}
