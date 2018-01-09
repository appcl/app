package com.mt.cardletter.activity;

import android.os.Bundle;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.adapter.SellerAdapter;
import com.mt.cardletter.entity.seller.SellerEntity;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.view.RefreshRecyclerView.PullToRefreshRecyclerView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Date:2018/1/9
 * Time:15:28
 * author:demons
 */

public class ClassifyActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener,PullToRefreshRecyclerView.PagingableListener{
    private TextView title_name;
    private FrameLayout back;

    private String c_name;
    private int c_id;

    private PullToRefreshRecyclerView recyclerView;

    private int page = 1; //当前页
    private int list_rows =5;//每页数

    private List<SellerEntity.DataBeanX.DataBean> sellerlist = new ArrayList<>();
    private LinkedList<SellerEntity.DataBeanX.DataBean> mListItems = new LinkedList<SellerEntity.DataBeanX.DataBean>();;

    private SellerAdapter adapter;
    @Override
    protected int getLayoutResId() {
        getIntentDatas();
        return R.layout.activity_seller;
    }

    private void getIntentDatas() {
        Bundle bundle = getIntent().getExtras();
        c_name=bundle.getString("c_name");
        c_id = bundle.getInt("c_id");
    }

    @Override
    public void initView() {

        title_name = (TextView) findViewById(R.id.title_name);
        title_name.setText(c_name);
        back = (FrameLayout) findViewById(R.id.com_back_click);
        back.setVisibility(View.VISIBLE);


        recyclerView = (PullToRefreshRecyclerView) findViewById(R.id.recycler_view);
        recyclerView.initRefreshView(this,new LinearLayoutManager(this));
        recyclerView.setOnRefreshListener(this);
        recyclerView.setPagingableListener(this);
        adapter = new SellerAdapter(this);
        recyclerView.setAdapter(adapter);
        getSellerDatas(page);
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

    public void getSellerDatas(int page){
        CardLetterRequestApi.getInstance().getSeller(Constant.Access_Token,list_rows,page,c_id,
                new HttpSubscriber<SellerEntity>(new SubscriberOnListener<SellerEntity>() {
                    @Override
                    public void onSucceed(SellerEntity data) {
                        if (data.getCode()==0){
                                if (data.getData().getTotal()>0) {
                                    sellerlist = data.getData().getData();
                                    adapter.addData(sellerlist);
                                    recyclerView.setOnRefreshComplete();
                                    recyclerView.onFinishLoading(true,false);
                                }else {
                                    recyclerView.setOnLoadMoreComplete();
                                    ToastUtils.makeShortText("已没有更多",ClassifyActivity.this);
                                }
                        }else {
                            ToastUtils.makeShortText(data.getMsg(),ClassifyActivity.this);
                        }
                    }

                    @Override
                    public void onError(int code, String msg) {
                    }
                },this));
    }

    @Override
    public void onRefresh() {
        page=1;
//        adapter.clearData();
        getSellerDatas(page);
    }

    @Override
    public void onLoadMoreItems() {
        page++;
        getSellerDatas(page);
    }
}
