package com.mt.cardletter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.entity.integral.CategoryEntity;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshBase;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Date:2018/1/14
 * Time:19:29
 * author:demons
 */

public class BankJFActivity extends BaseActivity {

    private static final int UPDATA_UP = 0X01; // 上拉加载
    private static final int UPDATA_DOWN = 0X02; //下拉刷新
    private static final int UPDATA_DEF = 0X03; //默认加载
    private TextView title_name;
    private FrameLayout back;
    private PullToRefreshListView recyclerView;

    private int page = 1; //当前页

    private MyAllAdapter adapter;

    List<CategoryEntity.DataBeanX.SellerListBean.DataBean> sell_lists=new ArrayList<>();
    private int is_from;
    private int c_id=0;
    private int b_id=0;
    private String channel;
    private TextView tv_noll;
    @Override
    protected int getLayoutResId() {
        getIntentDatas();
        return R.layout.activity_bankjf;
    }

    private void getIntentDatas() {
        Bundle b = getIntent().getExtras();
        is_from = b.getInt("is_from");
        if (is_from==0){
            channel= b.getString("channel");
        }else if (is_from==1){
            b_id=b.getInt("b_id");
        }else {
            c_id = b.getInt("c_id");
        }
        System.out.println("----页面传值-----"+channel+"\n"+"----点击银行id-----"+b_id+"\n"+"----点击标签id-----"+c_id);
    }

    @Override
    public void initView() {
        title_name = (TextView) findViewById(R.id.title_name);
        title_name.setText("积分列表");
        back = (FrameLayout) findViewById(R.id.com_back_click);
        back.setVisibility(View.VISIBLE);

        tv_noll = (TextView) findViewById(R.id.tv_noll);
        recyclerView = (PullToRefreshListView) findViewById(R.id.bankjf_view);
        switch (is_from){
            case 0:
                getChangeData(UPDATA_DEF,channel, Constant.Access_Token,page);
                break;
            case 1:
                getBank(UPDATA_DEF,b_id,Constant.Access_Token,page);
                break;
            case 2:
                getTAGBank(UPDATA_DEF,c_id,Constant.Access_Token,page);
                break;
        }

        recyclerView.setAdapter(adapter = new MyAllAdapter());
        recyclerView.setMode(PullToRefreshBase.Mode.BOTH);
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (sell_lists.get(position-1).getB_url()==null||sell_lists.get(position-1).getB_url().equals("")){
                    ToastUtils.makeShortText("商品已下架，请等待更新",BankJFActivity.this);
                }else {
                    Intent intent = new Intent(BankJFActivity.this,BankJFWebViewActivity.class);
                    Bundle b = new Bundle();
                    b.putString("url",sell_lists.get(position-1).getB_url());
                    intent.putExtras(b);
                    startActivity(intent);
                }
            }
        });

        recyclerView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page=1;
                switch (is_from){
                    case 0:
                        getChangeData(UPDATA_DOWN,channel, Constant.Access_Token,page);
                        break;
                    case 1:
                        getBank(UPDATA_DOWN,b_id,Constant.Access_Token,page);
                        break;
                    case 2:
                        getTAGBank(UPDATA_DOWN,c_id,Constant.Access_Token,page);
                        break;
                }
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                switch (is_from){
                    case 0:
                        getChangeData(UPDATA_UP,channel, Constant.Access_Token,page);
                        break;
                    case 1:
                        getBank(UPDATA_UP,b_id,Constant.Access_Token,page);
                        break;
                    case 2:
                        getTAGBank(UPDATA_UP,c_id,Constant.Access_Token,page);
                        break;
                }
            }
        });
    }

    //积分兑换
    private void getChangeData(final int upDataFlag ,final String channel, String access_token, int page) {
        CardLetterRequestApi.getInstance().getChannel_BJ(channel,access_token,page,new HttpSubscriber<CategoryEntity>(new SubscriberOnListener<CategoryEntity>() {
            @Override
            public void onSucceed(CategoryEntity data) {
                if (data.getCode()==0){
                    List<CategoryEntity.DataBeanX.SellerListBean.DataBean> data1
                            = data.getData().getSeller_list().getData();
                    if (upDataFlag == UPDATA_DEF){
                        if (sell_lists.size()==0){
                            tv_noll.setVisibility(View.GONE);
                        }else {
                            tv_noll.setVisibility(View.VISIBLE);
                        }
                        sell_lists = data1;
                    }else if(upDataFlag == UPDATA_UP){
                        if (sell_lists.size()>0){
                            tv_noll.setVisibility(View.GONE);
                        }else {
                            tv_noll.setVisibility(View.VISIBLE);
                        }
                        sell_lists.addAll(data1);
                    }else if(upDataFlag == UPDATA_DOWN){
                        if (sell_lists.size()>0){
                            tv_noll.setVisibility(View.GONE);
                        }else {
                            tv_noll.setVisibility(View.VISIBLE);
                        }
                        sell_lists = data1;
                    }
                    adapter.notifyDataSetChanged();
                    recyclerView.onRefreshComplete();
                }
            }

            @Override
            public void onError(int code, String msg) {

            }
        },this));
    }

    //银行
    private void getBank(final int upDataFlag ,final int b_id, String access_token, int page) {
        CardLetterRequestApi.getInstance().getBank_JF(b_id,access_token,page,new HttpSubscriber<CategoryEntity>(new SubscriberOnListener<CategoryEntity>() {
            @Override
            public void onSucceed(CategoryEntity data) {
                if (data.getCode()==0){
                    List<CategoryEntity.DataBeanX.SellerListBean.DataBean> data1
                            = data.getData().getSeller_list().getData();
                    if (upDataFlag == UPDATA_DEF){
                        if (sell_lists.size()==0){
                            tv_noll.setVisibility(View.GONE);
                        }else {
                            tv_noll.setVisibility(View.VISIBLE);
                        }
                        sell_lists = data1;
                    }else if(upDataFlag == UPDATA_UP){
                        if (sell_lists.size()>0){
                            tv_noll.setVisibility(View.GONE);
                        }else {
                            tv_noll.setVisibility(View.VISIBLE);
                        }
                        sell_lists.addAll(data1);
                    }else if(upDataFlag == UPDATA_DOWN){
                        if (sell_lists.size()>0){
                            tv_noll.setVisibility(View.GONE);
                        }else {
                            tv_noll.setVisibility(View.VISIBLE);
                        }
                        sell_lists = data1;
                    }
                    adapter.notifyDataSetChanged();
                    recyclerView.onRefreshComplete();
                }
            }

            @Override
            public void onError(int code, String msg) {

            }
        },this));
    }
    //标签
    private void getTAGBank(final int upDataFlag ,final int c_id, String access_token, int page) {
        CardLetterRequestApi.getInstance().getTAG_BJ(c_id,access_token,page,new HttpSubscriber<CategoryEntity>(new SubscriberOnListener<CategoryEntity>() {
            @Override
            public void onSucceed(CategoryEntity data) {
                if (data.getCode()==0){
                    List<CategoryEntity.DataBeanX.SellerListBean.DataBean> data1
                            = data.getData().getSeller_list().getData();
                    if (upDataFlag == UPDATA_DEF){
                        if (sell_lists.size()==0){
                            tv_noll.setVisibility(View.GONE);
                        }else {
                            tv_noll.setVisibility(View.VISIBLE);
                        }
                        sell_lists = data1;
                    }else if(upDataFlag == UPDATA_UP){
                        if (sell_lists.size()>0){
                            tv_noll.setVisibility(View.GONE);
                        }else {
                            tv_noll.setVisibility(View.VISIBLE);
                        }
                        sell_lists.addAll(data1);
                    }else if(upDataFlag == UPDATA_DOWN){
                        if (sell_lists.size()>0){
                            tv_noll.setVisibility(View.GONE);
                        }else {
                            tv_noll.setVisibility(View.VISIBLE);
                        }
                        sell_lists = data1;
                    }
                    adapter.notifyDataSetChanged();
                    recyclerView.onRefreshComplete();
                }
            }

            @Override
            public void onError(int code, String msg) {

            }
        },this));
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


    class MyAllAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return sell_lists.size();
        }

        @Override
        public Object getItem(int position) {
            return sell_lists.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            CategoryEntity.DataBeanX.SellerListBean.DataBean bean = sell_lists.get(position);
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(BankJFActivity.this,R.layout.item_b_seller, null);
                holder.tv_name = (TextView) convertView.findViewById(R.id.bjf_name);
                holder.bjf_jf = (TextView) convertView.findViewById(R.id.bjf_jf);
                holder.img_bfj = (ImageView) convertView.findViewById(R.id.bjf_img);
                holder.bjf_time = (TextView) convertView.findViewById(R.id.bjf_time);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tv_name.setText(bean.getName());
            holder.bjf_jf.setText("消费积分: "+String.valueOf(bean.getNeed_score()));
            holder.bjf_time.setText(bean.getCreate_time());
            Glide.with(BankJFActivity.this)
                    .load(Constant.PIC_URL+bean.getThumb())
                    .error(R.drawable.default_error)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img_bfj);
            return convertView;
        }

        class ViewHolder{
            private TextView tv_name,bjf_jf,bjf_time;
            private ImageView img_bfj;
        }
    }
}
