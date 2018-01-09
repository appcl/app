package com.mt.cardletter.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.adapter.SellerAdapter;
import com.mt.cardletter.entity.seller.SellerEntity;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshBase;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshListView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Date:2018/1/9
 * Time:15:28
 * author:demons
 */

public class ClassifyActivity extends BaseActivity {
    private TextView title_name;
    private FrameLayout back;
    private TextView tv_empty;
    private PullToRefreshListView mPullRefreshListView;

    //普通的listview对象
    private ListView actualListView;

    private String c_name;
    private int c_id;


    private int page = 1; //当前页
    private int list_rows = 5;//每页数

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

        tv_empty = (TextView) findViewById(R.id.tv_empty);

        initPTRListView();
        initListView();

        mPullRefreshListView.setRefreshing(true);//一打开改页面就自动刷新
    }

    private void initPTRListView() {
        mPullRefreshListView = (PullToRefreshListView) findViewById(R.id.sellerListView);
        mPullRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                //设置下拉时显示的日期和时间
                String label = DateUtils.formatDateTime(ClassifyActivity.this, System.currentTimeMillis(),
                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
                // 更新显示的label
                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);

                new GetDataTask().execute();
            }
        });

        mPullRefreshListView.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {
            @Override
            public void onLastItemVisible() {
                ToastUtils.makeShortText("已经到底了",ClassifyActivity.this);
            }
        });
        //上下都可以刷新的模式。这里有两个选择：Mode.PULL_FROM_START，Mode.BOTH，PULL_FROM_END
        mPullRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);

//        mPullRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
//            @Override
//            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
//                System.out.println("------onPullDownToRefresh---------");
//                //设置下拉时显示的日期和时间
//                String label = DateUtils.formatDateTime(ClassifyActivity.this, System.currentTimeMillis(),
//                        DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
//                // 更新显示的label
//                refreshView.getLoadingLayoutProxy().setLastUpdatedLabel(label);
//
//                new GetDataTask().execute();
//            }
//
//            @Override
//            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
//                System.out.println("------onPullUpToRefresh---------");
//                new GetDataTask().execute();
//            }
//        });
    }

    private void initListView() {
        //通过getRefreshableView()来得到一个listview对象
        actualListView = mPullRefreshListView.getRefreshableView();
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
                            if (data.getData().getTotal()==0){
                                mPullRefreshListView.setVisibility(View.GONE);
                                tv_empty.setVisibility(View.VISIBLE);
                            }else {
                                mPullRefreshListView.setVisibility(View.VISIBLE);
                                tv_empty.setVisibility(View.GONE);
                                sellerlist = data.getData().getData();
                                mListItems.addAll(sellerlist);
                                adapter = new SellerAdapter(ClassifyActivity.this,mListItems);
                                mPullRefreshListView.setAdapter(adapter);
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

    class GetDataTask extends AsyncTask<Void, Void, List<SellerEntity.DataBeanX.DataBean>>{
        @Override
        protected List<SellerEntity.DataBeanX.DataBean> doInBackground(Void... params) {
//            try {
//                Thread.sleep(2000);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
            getSellerDatas(page++);
            return mListItems;
        }

        @Override
        protected void onPostExecute(List<SellerEntity.DataBeanX.DataBean> dataBeen) {
            mListItems.addAll(dataBeen);
            // 通知数据改变了
            adapter.notifyDataSetChanged();
            // 加载完成后停止刷新
            mPullRefreshListView.onRefreshComplete();
        }
    }
}
