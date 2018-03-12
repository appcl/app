package com.mt.cardletter.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ScrollView;

import com.mt.cardletter.R;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshBase;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshScrollView;

/**
 * Date:2018/3/1
 * Time:10:28
 * author:demons
 *
 */

public class MoreFragment extends LazyFragment {
    private int tabIndex;
    public static final String INTENT_INT_INDEX = "intent_int_index";
    private  PullToRefreshScrollView pull_scroll;
    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);

        setContentView(R.layout.fragment_tabmain_item);
        tabIndex = getArguments().getInt(INTENT_INT_INDEX);

        pull_scroll = (PullToRefreshScrollView) findViewById(R.id.pull_scroll);
        pull_scroll.setMode(PullToRefreshBase.Mode.BOTH);
//        pull_scroll.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
//            @Override
//            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
//
//            }
//
//            @Override
//            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
//
//            }
//        });
    }

    @Override
    protected void onDestroyViewLazy() {
        super.onDestroyViewLazy();
    }

    private Handler handler;
}
