package com.mt.cardletter.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.mt.cardletter.view.CustomListView;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshBase;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshListFragment;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshListView;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/12/11.
 */

public class FristTagFragment extends PullToRefreshListFragment {

    private PullToRefreshListView mPullRefreshListView;


    private String[] mStrings = {"Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler", "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler"};

    private LinkedList<String> mListItems;
    private ArrayAdapter<String> mAdapter;


    public static FristTagFragment newInstance(String content) {
        FristTagFragment fragment = new FristTagFragment();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Get PullToRefreshListView from Fragment
        mPullRefreshListView = getPullToRefreshListView();

        mPullRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                // Do work to refresh the list here.
                new GetDataTask().execute();
            }
        });

        ListView actualListView = mPullRefreshListView.getRefreshableView();

        mListItems = new LinkedList<String>();
        mListItems.addAll(Arrays.asList(mStrings));
        mAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mListItems);

        // You can also just use setListAdapter(mAdapter) or
        // mPullRefreshListView.setAdapter(mAdapter)
        actualListView.setAdapter(mAdapter);
        setListShown(true);
    }

    private class GetDataTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            // Simulates a background job.
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
            }
            return mStrings;
        }

        @Override
        protected void onPostExecute(String[] result) {
            mListItems.addFirst("Added after refresh...");
            mAdapter.notifyDataSetChanged();

            // Call onRefreshComplete when the list has been refreshed.
            mPullRefreshListView.onRefreshComplete();

            super.onPostExecute(result);
        }
    }
}
