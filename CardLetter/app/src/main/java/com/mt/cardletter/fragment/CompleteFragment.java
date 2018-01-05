package com.mt.cardletter.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
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
import com.mt.cardletter.entity.merchant.FindCategoryList;
import com.mt.cardletter.entity.merchant.Goods;
import com.mt.cardletter.entity.merchant.GoodsBean;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.pulltorefresh.ILoadingLayout;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshBase;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jk on 2017/12/11.
 */

public class CompleteFragment extends Fragment {
    private static final int UPDATA_UP = 0X01; // 上拉加载
    private static final int UPDATA_DOWN = 0X02; //下拉刷新
    private static final int UPDATA_DEF = 0X03; //默认加载
    private Activity context;
    private  List<GoodsBean.ResultBean> list = new ArrayList();
    private  List<Goods.DataBeanX.DataBean>  myList;
    private MyAdapter myAdapter;
    private int page_index = 0;
    private String cartgory_id = "";
    private String page_size = "10";
    @Bind(R.id.listView)
    PullToRefreshListView listView;
    private boolean isOpen = true;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (isOpen){
            view = inflater.inflate(R.layout.activity_fragment_find, container, false);
            ButterKnife.bind(this, view);
            cartgory_id= (int) getArguments().get("id") + "";
            loadData( UPDATA_DEF , page_size , ""+page_index , 0+"" );
        }
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (isOpen){
            context = getActivity();
            initView();
            isOpen = false;
        }


    }

    private void loadData(int upDataFlag ,String list_rows,  String page,  String category_id) {
        myList = new ArrayList<>();
        /*
         * 获取商家列表
         */
        CardLetterRequestApi.getInstance().getFindMerchant(Constant.Access_Token,list_rows,page,category_id,new HttpSubscriber<Goods>(new SubscriberOnListener<Goods>() {
            @Override
            public void onSucceed(Goods data) {
                System.out.println("商家请求成功");
                if (data.getCode()==0){
                    List<Goods.DataBeanX.DataBean> data1 = data.getData().getData();

                    myList = data1;
                    myAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onError(int code, String msg) {
                System.out.println("商家网络异常");
                ToastUtils.showShort(getContext(),msg);
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
        //listView.withLoadMoreView();
        listView.setAdapter(myAdapter = new MyAdapter());
        /**
         * 注册下拉刷新
         */
        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                new CompleteFragment.GetDataTask().execute();
            }
        });
        /**
         * 注册下拉加载
         */
        listView.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {
            @Override
            public void onLastItemVisible() {
                page_index = page_index + 1;
                loadData(UPDATA_UP,page_size,page_index+"",cartgory_id);
                ToastUtils.makeShortText("page_index:"+page_index,getContext());
            }
        });
        /**
         * 焦点改变监听
         */
        listView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });
    }

    /**
     * 上拉加载
     */
    private class GetDataTask extends AsyncTask<Void, Void, List<GoodsBean.ResultBean>> {
        @Override
        protected List<GoodsBean.ResultBean> doInBackground(Void... params) {
            loadData(UPDATA_DOWN , page_size, "1" ,cartgory_id);
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
//            holder.title.setText(list.get(position).getShopName());
//            holder.discounts.setText(list.get(position).getShopDiscounts());
//            holder.obj.setText(list.get(position).getShopCard());
            holder.title.setText(myList.get(position).getName());
            holder.discounts.setText(myList.get(position).getDescribe());
            holder.obj.setText(myList.get(position).getCreateTime());
            return convertView;
        }
        class ViewHolder{
            TextView title,discounts,obj;
        }
    }


}
