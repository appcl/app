package com.mt.cardletter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.adapter.BankSellerAdapter;
import com.mt.cardletter.entity.integral.CategoryEntity;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.view.RefreshRecyclerView.PullToRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Date:2018/1/14
 * Time:19:29
 * author:demons
 */

public class BankJFActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener,PullToRefreshRecyclerView.PagingableListener{

    private TextView title_name;
    private FrameLayout back;
    private PullToRefreshRecyclerView recyclerView;

    private int page = 1; //当前页

    private BankSellerAdapter adapter;

    List<CategoryEntity.DataBeanX.SellerListBean.DataBean> sell_list;
    List<CategoryEntity.DataBeanX.SellerListBean.DataBean> sell_lists=new ArrayList<>();
    private int is_from;
    private int c_id=0;
    private int b_id=0;
    private String channel;
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
        sell_list = (List<CategoryEntity.DataBeanX.SellerListBean.DataBean>) getIntent().getSerializableExtra("list");
    }

    @Override
    public void initView() {
        title_name = (TextView) findViewById(R.id.title_name);
        title_name.setText("积分列表");
        back = (FrameLayout) findViewById(R.id.com_back_click);
        back.setVisibility(View.VISIBLE);

        recyclerView = (PullToRefreshRecyclerView) findViewById(R.id.bankjf_view);
        recyclerView.initRefreshView(this,new LinearLayoutManager(this));
        recyclerView.setOnRefreshListener(this);
        recyclerView.setPagingableListener(this);
        adapter = new BankSellerAdapter(this,sell_list);
        recyclerView.setAdapter(adapter);


        adapter.setItemClickListener(new BankSellerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(BankJFActivity.this,BankJFWebViewActivity.class);
                Bundle b = new Bundle();
//                if (sell_lists.size()>0){
//                    b.putString("url",sell_lists.get(position).getB_url());
//                }else {
                    b.putString("url",sell_list.get(position).getB_url());
//                }
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }

    //积分兑换
    private void getChangeData(final String channel, String access_token, int page) {
        CardLetterRequestApi.getInstance().getChannel_BJ(channel,access_token,page,new HttpSubscriber<CategoryEntity>(new SubscriberOnListener<CategoryEntity>() {
            @Override
            public void onSucceed(CategoryEntity data) {
                if (data.getData().getSeller_list().getData().size()>0) {
                    sell_lists = data.getData().getSeller_list().getData();
                    adapter.addData(sell_lists);
                    recyclerView.setOnRefreshComplete();
                    recyclerView.onFinishLoading(true,false);
                }else {
                    recyclerView.setOnLoadMoreComplete();
                    ToastUtils.makeShortText("已没有更多", BankJFActivity.this);
                }
            }

            @Override
            public void onError(int code, String msg) {

            }
        },this));
    }

    //银行
    private void getBank(final int b_id, String access_token, int page) {
        CardLetterRequestApi.getInstance().getBank_JF(b_id,access_token,page,new HttpSubscriber<CategoryEntity>(new SubscriberOnListener<CategoryEntity>() {
            @Override
            public void onSucceed(CategoryEntity data) {
                if (data.getData().getSeller_list().getData().size()>0) {
                    sell_lists = data.getData().getSeller_list().getData();
                    adapter.addData(sell_lists);
                    recyclerView.setOnRefreshComplete();
                    recyclerView.onFinishLoading(true,false);
                }else {
                    recyclerView.setOnLoadMoreComplete();
                    ToastUtils.makeShortText("已没有更多", BankJFActivity.this);
                }
            }

            @Override
            public void onError(int code, String msg) {

            }
        },this));
    }
    //标签
    private void getTAGBank(final int c_id, String access_token, int page) {
        CardLetterRequestApi.getInstance().getTAG_BJ(c_id,access_token,page,new HttpSubscriber<CategoryEntity>(new SubscriberOnListener<CategoryEntity>() {
            @Override
            public void onSucceed(CategoryEntity data) {
                if (data.getData().getSeller_list().getData().size()>0) {
                    sell_lists = data.getData().getSeller_list().getData();
                    adapter.addData(sell_lists);
                    recyclerView.setOnRefreshComplete();
                    recyclerView.onFinishLoading(true,false);
                }else {
                    recyclerView.setOnLoadMoreComplete();
                    ToastUtils.makeShortText("已没有更多", BankJFActivity.this);
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

    @Override
    public void onRefresh() {
        adapter.clearData();
        page = 1;
        switch (is_from){
            case 0:
                getChangeData(channel, Constant.Access_Token,page);
                break;
            case 1:
                getBank(b_id,Constant.Access_Token,page);
                break;
            case 2:
                getTAGBank(c_id,Constant.Access_Token,page);
                break;
        }
    }

    @Override
    public void onLoadMoreItems() {
        page++;
        switch (is_from){
            case 0:
                getChangeData(channel, Constant.Access_Token,page);
                break;
            case 1:
                getBank(b_id,Constant.Access_Token,page);
                break;
            case 2:
                getTAGBank(c_id,Constant.Access_Token,page);
                break;
        }
    }
}
