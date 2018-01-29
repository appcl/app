package com.mt.cardletter.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.DistanceUtil;
import com.bumptech.glide.Glide;
import com.mt.cardletter.R;
import com.mt.cardletter.activity.SetailsActivity;
import com.mt.cardletter.app.AppContext;
import com.mt.cardletter.db.tables.BankTable;
import com.mt.cardletter.entity.city.District;
import com.mt.cardletter.entity.merchant.Bank;
import com.mt.cardletter.entity.merchant.Goods;
import com.mt.cardletter.entity.merchant.GoodsBean;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshBase;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshListView;

import org.litepal.crud.DataSupport;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jk on 2017/12/11.
 */

public class SearchHomeFragment extends BaseFragment {
    private static final int UPDATA_UP = 0X01; // 上拉加载
    private static final int UPDATA_DOWN = 0X02; //下拉刷新
    private static final int UPDATA_DEF = 0X03; //默认加载
    private Activity context;
    private List<GoodsBean.ResultBean> list = new ArrayList();
    private List<Goods.DataBeanX.CardfindListBean.DataBean>  myList = new ArrayList<>();
    private MyAdapter myAdapter;
    private int page_index = 1;
    private String cartgory_id = "2";
    private String page_size = "10";
    @Bind(R.id.listView)
    PullToRefreshListView listView;
    private boolean isOpen = true;
    private View view;
    public View loadmoreView;
    private List<Bank.DataBean> banks = new ArrayList<>();
    private TextView tv_noll;
    private String lng;
    private String lat;
    private String search_data;
    private List<District.DataBean> districtList;
    private String city;
    private String city_id = "";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (isOpen){
            context = getActivity();
            view = inflater.inflate(R.layout.activity_fragment_find, container, false);
            loadmoreView = View.inflate(getContext(),R.layout.load_more,null);
            loadmoreView.setVisibility(View.VISIBLE);
            tv_noll = (TextView) view.findViewById(R.id.tv_noll);
            tv_noll.setVisibility(View.GONE);
            ButterKnife.bind(this, view);
            search_data = getArguments().getString("search_data");
            lng = AppContext.getInstance().getLat()+"";
            lat = AppContext.getInstance().getLon()+"";
            loadData( UPDATA_DEF , ""+page_index , "" ,Constant.CITY_ID, "",lng,lat,search_data);
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

    private void loadData(final int upDataFlag ,String page, String category_id, String city, String  bankcard, String lng, String lat,String search_data) {
        CardLetterRequestApi.getInstance().getFindMerchant(
                Constant.Access_Token,10+"",page,"",city,"",lng,lat,search_data,new HttpSubscriber<Goods>(new SubscriberOnListener<Goods>() {
                    @Override
                    public void onSucceed(Goods data) {
                        if (data.getCode()==0){
                            List<Goods.DataBeanX.CardfindListBean.DataBean> data1 = data.getData().getCardfindList().getData();
                            if (data1.size()==0){
                                ToastUtils.makeShortText("已没有更多",getContext());
                                listView.onRefreshComplete();
                                return;
                            }
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
         * 设置加载更多布局
         */

        //TODO 上拉加载提示

        /**
         * 点击事件
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent intent = new Intent(getActivity(), SetailsActivity.class);
                Intent intent = getActivity().getIntent();
                intent.setClass(getActivity(),SetailsActivity.class);
                if(myList.get(position-1)!=null){
                    List<BankTable> bankTable = DataSupport.where("bank_id = ?",myList.get(position-1).getBankcard()+"").find(BankTable.class);//查询数据库
                    intent.putExtra("cardfind_id",myList.get(position-1).getId()+"");
                    intent.putExtra("bank",bankTable.get(0).getName());  // TODO: 2018/1/23 银行类别待修改
                    intent.putExtra("bank_url",bankTable.get(0).getCardThumb());
                }
                UIHelper.showDetails(getContext(), intent);

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
                loadData( UPDATA_DOWN , ""+page_index , "" ,Constant.CITY_ID, "",AppContext.getInstance().getLat()+"",AppContext.getInstance().getLon()+"",search_data);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page_index = page_index + 1;

                loadData( UPDATA_UP , ""+page_index , "" ,Constant.CITY_ID, "",AppContext.getInstance().getLat()+"",AppContext.getInstance().getLon()+"",search_data);

            }
        });
    }

    @Override
    protected int setLayoutResouceId() {
        return 0;
    }

    @Override
    public void initData() {

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

                List<BankTable> bankTable = DataSupport.where("bank_id = ?",myList.get(position).getBankcard()+"").find(BankTable.class);
                holder.bank.setText(bankTable.get(0).getName());
                LatLng p1LL = new LatLng(  AppContext.getInstance().getLat(),AppContext.getInstance().getLon());
                LatLng p2LL = new LatLng( myList.get(position).getLng(),myList.get(position).getLat());

                BigDecimal bg = new BigDecimal(DistanceUtil.getDistance(p1LL, p2LL));
                DecimalFormat df = new DecimalFormat("#");
                String format = df.format(bg);
                byte[] bytes = format.getBytes();
                holder.distance.setText(format+" M");
                Glide.with(SearchHomeFragment.this).load(Constant.BASE_URL+myList.get(position).getThumb()).error(R.drawable.default_error).into(holder.img);
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


}