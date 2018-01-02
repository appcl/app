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
import android.widget.Toast;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.ScreenActivity;
import com.mt.cardletter.activity.SetailsActivity;
import com.mt.cardletter.entity.data.GoodsBean;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.test.TestMethod;
import com.mt.cardletter.https.test.TestRequestApi;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshBase;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jk on 2017/12/11.
 */

public class CompleteFragment extends Fragment {
    private static final int UPDATA_UP = 0X01;
    private static final int UPDATA_DOWN = 0X02;
    private Activity context;
    private  List<GoodsBean.ResultBean> list = new ArrayList();
    private MyAdapter myAdapter;
    private int page_index = 0;
    @Bind(R.id.listView)
    PullToRefreshListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_find, container, false);
        ButterKnife.bind(this, view);
        loadData(UPDATA_UP,page_index,10);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getActivity();
        initView();

    }

    private void loadData(final int updataFlag , int page_index, int page_size) {
        TestRequestApi.getInstance().getGoods( page_index, page_size, new HttpSubscriber<GoodsBean>(new SubscriberOnListener<GoodsBean>() {
            @Override
            public void onSucceed(GoodsBean data) {
                if (updataFlag == UPDATA_UP){
                    List<GoodsBean.ResultBean> result = data.getResult();
                    list.addAll(result);
                }else{
                    list = data.getResult();
                }
                myAdapter.notifyDataSetChanged();
            }
            @Override
            public void onError(int code, String msg) {
                System.out.println("----datas-----"+"Get 请求失败");
            }
        },getContext()));
    }
    private void initView() {
        /**
         * 点击事件
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), SetailsActivity.class);
                if (list.get(position)!=null) {
                    intent.putExtra("goods", list.get(position-1));
                }
                UIHelper.showDetails(getContext(), intent);
            }
        });

        listView.setAdapter(myAdapter = new MyAdapter());
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                new CompleteFragment.GetDataTask().execute();
            }
        });
        /**
         * 下拉加载
         */
        listView.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {
            @Override
            public void onLastItemVisible() {
                page_index = page_index + 1;
                ToastUtils.makeShortText("page_index:"+page_index,getContext());
                loadData(UPDATA_UP,page_index,10);
            }
        });
    }
    private class GetDataTask extends AsyncTask<Void, Void, List<GoodsBean.ResultBean>> {
        @Override
        protected List<GoodsBean.ResultBean> doInBackground(Void... params) {
            loadData(UPDATA_DOWN,10,10);
            return list;
        }
        @Override
        protected void onPostExecute(List<GoodsBean.ResultBean> result) {
            listView.onRefreshComplete();
            super.onPostExecute(result);
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
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(getContext(),R.layout.item_goods, null);
                holder.title = (TextView) convertView.findViewById(R.id.goods_title);
                holder.discounts = (TextView) convertView.findViewById(R.id.goods_discounts);
                holder.obj = (TextView) convertView.findViewById(R.id.goods_obj);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.title.setText(list.get(position).getShopName());
            holder.discounts.setText(list.get(position).getShopDiscounts());
            holder.obj.setText(list.get(position).getShopCard());
            return convertView;
        }
        class ViewHolder{
            TextView title,discounts,obj;
        }
    }


}
