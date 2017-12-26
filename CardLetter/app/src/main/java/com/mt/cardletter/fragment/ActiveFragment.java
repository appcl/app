package com.mt.cardletter.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.SetailsActivity;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshBase;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jk on 2017/12/11.
 */

public class ActiveFragment extends Fragment {

    private Activity context;
    private List<String> list;
    private MyAdapter myAdapter;
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
        initData();
        initView();
        //loadData();
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0 ; i <= 20 ; i ++ ){
            list.add("item"+i);
        }
    }

    private void initView() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), SetailsActivity.class);
                intent.putExtra("goods",list.get(position));
                UIHelper.showDetails(getContext(), intent);
            }
        });
        listView.setAdapter(myAdapter = new MyAdapter());
        listView.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {
            @Override
            public void onLastItemVisible() {
                ToastUtils.makeShortText("刷新",getContext());
            }
        });
        /**
         * 刷新
         */
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                // Do work to refresh the list here.
                new ActiveFragment.GetDataTask().execute();
            }
        });

    }
    private class GetDataTask extends AsyncTask<Void, Void, List<String>> {

        @Override
        protected List<String> doInBackground(Void... params) {
            // Simulates a background job.
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            return list;
        }

        @Override
        protected void onPostExecute(List<String> new_list) {
            list.add(0,"Added after refresh...");
            myAdapter.notifyDataSetChanged();

            // Call onRefreshComplete when the list has been refreshed.
            listView.onRefreshComplete();

            super.onPostExecute(new_list);
        }
    }
    class MyAdapter extends BaseAdapter{

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
            View view = null;
//            if (convertView == null){
                view = View.inflate(getContext(), R.layout.item_goods, null);
          //  }
            TextView tv = (TextView) view.findViewById(R.id.goods_discounts);
            tv.setText(list.get(position));
            return view;
        }
    }


}
