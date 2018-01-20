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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.utils.DistanceUtil;
import com.bumptech.glide.Glide;
import com.mt.cardletter.R;
import com.mt.cardletter.activity.ScreenActivity;
import com.mt.cardletter.activity.SetailsActivity;
import com.mt.cardletter.app.AppContext;
import com.mt.cardletter.entity.merchant.Bank;
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

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jk on 2017/12/11.
 */

public class CompleteFragment extends BaseFragment {
    private static final int UPDATA_UP = 0X01; // 上拉加载
    private static final int UPDATA_DOWN = 0X02; //下拉刷新
    private static final int UPDATA_DEF = 0X03; //默认加载
    private Activity context;
    private List<Goods.DataBeanX.CardfindListBean.DataBean>  myList = new ArrayList<>();
    private MyAdapter myAdapter;
    private int page_index = 1;
    private String cartgory_id = "";
    private String page_size = "10";
    @Bind(R.id.listView)
    PullToRefreshListView listView;
    private boolean isOpen = true;
    private View view;
    private List<Bank.DataBean> banks = new ArrayList<>();
    private TextView tv_noll;
    private String lng;
    private String lat;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (isOpen){
            context = getActivity();
            view = inflater.inflate(R.layout.activity_fragment_find, container, false);
            tv_noll = (TextView) view.findViewById(R.id.tv_noll);
            tv_noll.setVisibility(View.GONE);
            ButterKnife.bind(this, view);

            cartgory_id= (int) getArguments().get("id")+"";
            loadData( UPDATA_DEF , page_size , ""+page_index , cartgory_id ,Constant.CITY_ID, "", AppContext.getInstance().getLat()+"", AppContext.getInstance().getLon()+"");
            toLogin(Constant.Access_Token);
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (isOpen){
            initViews();
            isOpen = false;
        }
    }

    @Override
    protected void onLazyLoad() {
        super.onLazyLoad();
    }

    private void loadData(final int upDataFlag , String list_rows, String page, String category_id, String city, String  bankcard, String lng, String lat) {
        CardLetterRequestApi.getInstance().getFindMerchant(
                Constant.Access_Token,list_rows,page,category_id,city, "",lng,lat,"",new HttpSubscriber<Goods>(new SubscriberOnListener<Goods>() {
                    @Override
                    public void onSucceed(Goods data) {
                        if (data.getCode()==0){
                            List<Goods.DataBeanX.CardfindListBean.DataBean> data1 = data.getData().getCardfindList().getData();
                            if (upDataFlag == UPDATA_DEF){
                                if (data.getData().getCardfindList().getTotal()==0){
                                    tv_noll.setVisibility(View.VISIBLE);
                                }
                                myList = data1;
                            }else if(upDataFlag == UPDATA_UP){
                                myList.addAll(data1);
                            }else if(upDataFlag == UPDATA_DOWN){
                                ToastUtils.makeShortText("已是加载最新",getContext());
                                myList = data1;
                            }
                            myAdapter.notifyDataSetChanged();
                            listView.onRefreshComplete();
                        }
                    }
                    @Override
                    public void onError(int code, String msg) {
                        ToastUtils.showShort(getContext(),"网络异常");
                    }
                },getContext()));
    }

    private void initViews() {
        /**
         * 点击事件
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = getActivity().getIntent();
                intent.setClass(getActivity(),SetailsActivity.class);
                if(myList.get(position-1)!=null){
                    intent.putExtra("cardfind_id",myList.get(position-1).getId()+"");
                    intent.putExtra("bank",banks.get(Integer.parseInt(myList.get(position-1).getBankcard())-1).getName());
                    intent.putExtra("bank_url",banks.get(Integer.parseInt(myList.get(position-1).getBankcard())-1).getCardThumb());
                }
                startActivity(intent);
            }
        });
        listView.setAdapter(myAdapter = new MyAdapter());
        listView.setMode(PullToRefreshBase.Mode.BOTH);
        /**
         * 注册加载
         */

        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page_index = 1;
                loadData( UPDATA_DOWN , page_size , ""+page_index , cartgory_id ,Constant.CITY_ID, "",AppContext.getInstance().getLat()+"",AppContext.getInstance().getLon()+"");
            }
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page_index = page_index + 1;
                loadData( UPDATA_UP , page_size , ""+page_index , cartgory_id ,Constant.CITY_ID, "",AppContext.getInstance().getLat()+"",AppContext.getInstance().getLon()+"");
            }
        });
    }

    @Override
    protected int setLayoutResouceId() {return 0;}

    @Override
    public void initData() { }

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
                holder.img = (ImageView) convertView.findViewById(R.id.goods_img);
                holder.bank = (TextView) convertView.findViewById(R.id.goods_bank);
                holder.distance = (TextView) convertView.findViewById(R.id.goods_distance);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            if (myList!=null&&myList.size()!=0){
                holder.title.setText(myList.get(position).getName());
                holder.discounts.setText(myList.get(position).getDescribe());
                holder.obj.setText(myList.get(position).getCreateTime());

                if (banks.size()>0){
                    int bankcard = Integer.parseInt(myList.get(position).getBankcard());
                    if (bankcard < 34){
                        Bank.DataBean dataBean = banks.get(bankcard - 1);
                        String name = dataBean.getName();
                        holder.bank.setText(name);
                    }else{
                        holder.bank.setText("------------");
                    }
                }
                LatLng p1LL = new LatLng(  AppContext.getInstance().getLat(),AppContext.getInstance().getLon());
                LatLng p2LL = new LatLng( myList.get(position).getLng(),myList.get(position).getLat());

                BigDecimal bg = new BigDecimal(DistanceUtil.getDistance(p1LL, p2LL));
                DecimalFormat df = new DecimalFormat("#");
                String format = df.format(bg);
                byte[] bytes = format.getBytes();
                holder.distance.setText(format+" M");
                Glide.with(CompleteFragment.this).load(Constant.BASE_URL+myList.get(position).getThumb()).error(R.drawable.default_error).into(holder.img);
            }
            return convertView;
        }
        class ViewHolder{
            TextView title,discounts,obj,bank,distance;
            ImageView img;
        }
    }
    private void toLogin(String ak) {
        CardLetterRequestApi.getInstance().getBank(ak, new HttpSubscriber<Bank>(new SubscriberOnListener<Bank>() {
            @Override
            public void onSucceed(Bank data) {
                if (data.getCode() == 0) {
                    banks = data.getData();
                }
            }
            @Override
            public void onError(int code, String msg) {

            }
        }, getContext()));
    }

    /**
     * @param requestCode  请求码，即调用startActivityForResult()传递过去的值
     * @param resultCode  结果码，结果码用于标识返回数据来自哪个新Activity
     * @param data  Intent 数据
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("jk====onActivityResult===");
    }
}