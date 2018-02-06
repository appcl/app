package com.mt.cardletter.activity.collect;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
/**
 * 我的--收藏列表
 */

import com.bumptech.glide.Glide;
import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.activity.SetailsActivity;
import com.mt.cardletter.entity.collect.CollectList;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.SharedPreferences;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshBase;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class CollectActivity extends BaseActivity {
    private PullToRefreshListView listView;
    private CollectActivity.MyAdapter myAdapter;
    private static int UPDATA_DOWN = 0x1;
    private static int UPDATA_UP = 0x2;
    private static int UPDATA_DEF = 0x3;
    private int page = 1;
    private  String member_id;
    private List<CollectList.DataBeanX.DataBean> myList;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_collect;
    }



    @Override
    public void initView() {
        myList = new ArrayList<>();
        TextView title_name = (TextView) findViewById(R.id.title_name);
        title_name.setText("我的收藏");
        FrameLayout back = (FrameLayout) findViewById(R.id.com_back_click);
        back.setVisibility(View.VISIBLE);
        listView = (PullToRefreshListView) findViewById(R.id.listView);
        myAdapter = new CollectActivity.MyAdapter();
        listView.setAdapter(myAdapter);
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        /**
         * 条目点击事件
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CollectActivity.this, SetailsActivity.class);
                int id1 = myList.get(position-1).getId();
                intent.putExtra("cardfind_id",id1+"");
                startActivity(intent);
            }
        });
        /**
         * 注册加载
         */

        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page = 1;
                favoriteList(UPDATA_DOWN,10,page,member_id);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page = page +1;
                favoriteList(UPDATA_UP,10,page,member_id);
            }
        });
        member_id = SharedPreferences.getInstance().getString("member_id", "");
        System.out.println("jk-----"+page+"-----"+member_id);
        favoriteList(UPDATA_DEF,10,page,member_id);

    }
    /**
     * 收藏列表
     *
     */
    private void favoriteList(final int upDataFlag ,int list_rows, int page, String member_id){
        CardLetterRequestApi.getInstance().favoriteList(list_rows,page,member_id, new HttpSubscriber<CollectList>(new SubscriberOnListener<CollectList>() {
            @Override
            public void onSucceed(CollectList data) {
                if (data.getCode() == 0) {
                    List<CollectList.DataBeanX.DataBean> data1 =  data.getData().getData();
                    if (data1.size()==0){
                        ToastUtils.makeShortText("已没有更多",CollectActivity.this);
                        listView.onRefreshComplete();
                        return;
                    }
                    if (upDataFlag == UPDATA_DEF){
//                        if (data.getData().getCardfindList().getTotal()==0){
//                            tv_noll.setVisibility(View.VISIBLE);
//                        }
                        myList = data1;
                    }else if(upDataFlag == UPDATA_UP){
                        myList.addAll(data1);
                    }else if(upDataFlag == UPDATA_DOWN){
                        ToastUtils.makeShortText("已是加载最新",CollectActivity.this);
                        myList = data1;
                    }
                    myAdapter.notifyDataSetChanged();
                    listView.onRefreshComplete();
                }
            }
            @Override
            public void onError(int code, String msg) {
                System.out.println("jk----code--"+code+"------"+msg);
                ToastUtils.showShort(CollectActivity.this, "网络故障");
            }
        }, CollectActivity.this));
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return myList.size();
        }

        @Override
        public Object getItem(int position) {
            return myList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CollectActivity.MyAdapter.ViewHolder holder;
            if (convertView == null) {
                holder = new CollectActivity.MyAdapter.ViewHolder();
                convertView = View.inflate(CollectActivity.this,R.layout.item_news, null);
                holder.tv_title = (TextView) convertView.findViewById(R.id.news_title);
                holder.tv_content = (TextView) convertView.findViewById(R.id.news_content);
                holder.img = (ImageView) convertView.findViewById(R.id.news_img);
                convertView.setTag(holder);
            } else {
                holder = (CollectActivity.MyAdapter.ViewHolder) convertView.getTag();
            }
            holder.tv_title.setText(myList.get(position).getName());
            holder.tv_content.setText(myList.get(position).getDescribe());

            Glide.with(CollectActivity.this).load(Constant.BASE_URL+myList.get(position).getThumb()).error(R.drawable.default_error).into(holder.img);
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
