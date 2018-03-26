package com.mt.cardletter.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.mt.cardletter.R;



import com.mt.cardletter.activity.SetailsActivity;
import com.mt.cardletter.app.AppContext;
import com.mt.cardletter.db.dbuitls.DBCreate;
import com.mt.cardletter.db.tables.BankTable;
import com.mt.cardletter.entity.merchant.Bank;

import com.mt.cardletter.entity.merchant.Goods;

import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;

import com.mt.cardletter.utils.ToastUtils;

import com.mt.cardletter.view.pulltorefresh.PullToRefreshBase;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshListView;


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
    private ViewPager pager;
    private Button test;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        System.out.println("jk------"+"jk---CompleteFragment--1");
        if (isOpen){
            System.out.println("jk------"+"jk---CompleteFragment--1-1");
            context = getActivity();
            view = inflater.inflate(R.layout.activity_fragment_find, container, false);
            test = (Button) view.findViewById(R.id.test);
            test.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ListView refreshableView = listView.getRefreshableView();
                    refreshableView.smoothScrollToPosition(0);
                }
            });

            tv_noll = (TextView) view.findViewById(R.id.tv_noll);
            tv_noll.setVisibility(View.GONE);
            ButterKnife.bind(this, view);
            cartgory_id= (int) getArguments().get("id")+"";
            loadData( UPDATA_DEF , page_size , ""+page_index , cartgory_id ,Constant.CITY_ID, Constant.MY_BANK, AppContext.getInstance().getLat()+"", AppContext.getInstance().getLon()+"");
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (isOpen){
            initViews();
            isOpen = true;
        }
    }

    @Override
    public void onResume() {
        if (Constant.MY_BANK_FLAG==1){
            loadData( UPDATA_DEF , page_size , ""+1 , cartgory_id ,Constant.CITY_ID, Constant.MY_BANK, AppContext.getInstance().getLat()+"", AppContext.getInstance().getLon()+"");
        }
        super.onResume();
    }
    private void loadData(final int upDataFlag , final String list_rows, final String page, final String category_id, final String city, final String  bankcard, final String lng, final String lat) {
        HttpSubscriber.isOpen = false;
        CardLetterRequestApi.getInstance().getFindMerchant(
                Constant.Access_Token,list_rows,page,category_id,city, bankcard,lng,lat,"",new HttpSubscriber<Goods>(new SubscriberOnListener<Goods>() {

                    @Override
                    public void onSucceed(Goods data) {
                        System.out.println("jk==--"+list_rows+" - "+page+" - "+category_id+" - "+city+" - "+bankcard+" - "+lng+"   - "+lat);
                        if (data.getCode()==0) {
                            System.out.println("jk---------" + data.getData().getCardfindList().getData().size());
                            List<Goods.DataBeanX.CardfindListBean.DataBean> data1 = data.getData().getCardfindList().getData();
                            if (upDataFlag == UPDATA_DEF) {
                                if (data.getData().getCardfindList().getTotal() == 0) {
                                    tv_noll.setVisibility(View.VISIBLE);
                                } else {
                                    tv_noll.setVisibility(View.GONE);
                                }
                                myList = data1;
                            } else if (upDataFlag == UPDATA_UP) {
                                if (data.getData().getCardfindList().getTotal() == 0) {
                                    Toast.makeText(getContext(), "已到底了", Toast.LENGTH_SHORT).show();
                                    tv_noll.setVisibility(View.VISIBLE);
                                } else {
                                    tv_noll.setVisibility(View.GONE);
                                }
                                myList.addAll(data1);
                            } else if (upDataFlag == UPDATA_DOWN) {
                                if (data.getData().getCardfindList().getTotal() == 0) {
                                    tv_noll.setVisibility(View.VISIBLE);
                                } else {
                                    tv_noll.setVisibility(View.GONE);
                                }
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
//                    intent.putExtra("bank",bankTable.get(0).getName());  // TODO: 2018/1/23 银行类别待修改
//                    intent.putExtra("bank_url",bankTable.get(0).getCardThumb());
                }
                Constant.MY_BANK_FLAG = 2;
                startActivity(intent);
            }
        });

        listView.setAdapter(myAdapter = new MyAdapter());
        listView.setMode(PullToRefreshBase.Mode.BOTH);

        listView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                page_index = 1;
                loadData( UPDATA_DOWN , page_size , ""+page_index , cartgory_id ,Constant.CITY_ID, Constant.MY_BANK,AppContext.getInstance().getLat()+"",AppContext.getInstance().getLon()+"");
            }
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page_index = page_index + 1;
                loadData( UPDATA_UP , page_size , ""+page_index , cartgory_id ,Constant.CITY_ID, Constant.MY_BANK,AppContext.getInstance().getLat()+"",AppContext.getInstance().getLon()+"");
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
                holder.discounts.setText("");
                holder.obj.setText(myList.get(position).getDescribe());

               BankTable bankTable = DBCreate.selectBankById(myList.get(position).getBankcard());
                holder.bank.setText(bankTable.getName());

//                LatLng p1LL = new LatLng(  37.0,118.0);
//                LatLng p2LL = new LatLng( myList.get(position).getLng(),myList.get(position).getLat() );
//
//                BigDecimal bg = new BigDecimal( DistanceUtil.getDistance(p1LL, p2LL) );
//                DecimalFormat df = new DecimalFormat("#");//忽略
//                String format = df.format(bg);
                holder.distance.setText("1000"+" 米");

                Glide.with(CompleteFragment.this).load(Constant.BASE_URL+myList.get(position).getThumb()).error(R.drawable.default_error).into(holder.img);
            }
            return convertView;
        }
        class ViewHolder{
            TextView title,discounts,obj,bank,distance;
            ImageView img;
        }
    }

    private PopupWindow mPopupWindow;

    private void showMenuPop() {

        View popView = LayoutInflater.from(getContext()).inflate(R.layout.pull_popu_icon, null);
        mPopupWindow = new PopupWindow(popView, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        // 设置允许在外点击消失
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable());
        final Window window = getActivity().getWindow();
        final WindowManager.LayoutParams params = window.getAttributes();
        //params.alpha = 0.8F;
        params.alpha = 1.0F;
        window.setAttributes(params);
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                params.alpha = 1.0F;
                window.setAttributes(params);
            }
        });
        //设置动画
        // mPopupWindow.setAnimationStyle(R.style.anim_bottom_dialog);
        mPopupWindow.setAnimationStyle(android.R.style.Animation_InputMethod);
//        popView.findViewById(R.id.tv_camera_album).setOnClickListener(onClickListenerForPop);
//        popView.findViewById(R.id.tv_picasso).setOnClickListener(onClickListenerForPop);
//        popView.findViewById(R.id.tv_cancel).setOnClickListener(onClickListenerForPop);
        mPopupWindow.showAtLocation(window.getDecorView(), Gravity.BOTTOM, 0, 0);
    }

    /**
     * @param requestCode  请求码，即调用startActivityForResult()传递过去的值
     * @param resultCode  结果码，结果码用于标识返回数据来自哪个新Activity
     * @param data  Intent 数据
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }

}