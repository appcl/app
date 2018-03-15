package com.mt.cardletter.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mt.cardletter.R;
import com.mt.cardletter.entity.food.CommentBean;
import com.mt.cardletter.view.exchange.BaseUtils;
import com.mt.cardletter.view.exchange.CommentAdapter;
import com.mt.cardletter.view.exchange.CustomLoadMoreView;

import java.util.ArrayList;

/**
 * Date:2018/3/13
 * Time:11:37
 * author:demons
 */

public class SecondFragment extends LazyFragment implements BaseQuickAdapter.RequestLoadMoreListener{
    private Context mContext;
    private ArrayList<CommentBean> cList = new ArrayList<>();
    private RecyclerView recycler;
    private CommentAdapter cAdapter;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_second);
        mContext = getActivity();
        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(mContext));
        cAdapter = new CommentAdapter(BaseUtils.getComment());
        View headerView = View.inflate(mContext, R.layout.item_comment_header, null);
        cAdapter.addHeaderView(headerView);
        cAdapter.setLoadMoreView(new CustomLoadMoreView());
        cAdapter.setOnLoadMoreListener(this, recycler);
        recycler.setAdapter(cAdapter);
    }

    @Override
    public void onLoadMoreRequested() {
        recycler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (cAdapter.getItemCount() > 30) {
                    cAdapter.loadMoreEnd();
                } else {
                    cAdapter.addData(BaseUtils.getComment());
                    cAdapter.loadMoreComplete();
                }
            }
        }, 2000);
    }
}
