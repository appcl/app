package com.mt.cardletter.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mt.cardletter.R;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshListView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/12/11.
 */

public class ActiveFragment extends Fragment {

    private PullToRefreshListView mPullRefreshListView;
    private Activity context;

    @Bind(R.id.listView)
    PullToRefreshListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
//        initData();
//        initView();
//        loadData();
    }
}
