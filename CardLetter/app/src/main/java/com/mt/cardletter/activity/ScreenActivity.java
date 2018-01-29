package com.mt.cardletter.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.mt.cardletter.R;
import com.mt.cardletter.db.dbuitls.DBCreate;
import com.mt.cardletter.db.tables.BankTable;
import com.mt.cardletter.entity.merchant.Bank;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.SharedPreferences;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;

import org.litepal.crud.DataSupport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ScreenActivity extends BaseActivity implements View.OnClickListener{
    private RecyclerView recyclerView;
    private TextView makeShow;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private MyRecyclerAdapter myRecyclerAdapter;
    private List<Bank.DataBean> myList = new ArrayList<>();
    private List<Bank.DataBean> checkeddata = new ArrayList<>();// 选中的数据
    private TextView next;
    private String from_dis;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_screen;
    }
    @Override
    public void initView() {
        from_dis = getIntent().getExtras().getString("from_dis");
        next = (TextView) findViewById(R.id.commonal_tv);
        next.setText("跳过");
        next.setTextColor(getResources().getColor(R.color.color_text_black_31));
        next.setVisibility(View.VISIBLE);
        next.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                if (from_dis.equals("from_dis")){
                    setFlag();
                    finish();
                }else {
                    setFlag();
                    UIHelper.showMainActivity(ScreenActivity.this);
                }
            }
        });
        findViewById(R.id.screen_affirm).setOnClickListener(this);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setColorSchemeColors(Color.RED,Color.BLUE,Color.GREEN);
        TextView title_name = (TextView) findViewById(R.id.title_name);
        title_name.setText("关注信用卡");
        FrameLayout back = (FrameLayout) findViewById(R.id.com_back_click);
        back.setVisibility(View.VISIBLE);
        recyclerView = (RecyclerView) findViewById(R.id.screen_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置布局管理器
        recyclerView.setLayoutManager(new GridLayoutManager( this,4));
        //尺寸优化
        recyclerView.setHasFixedSize(true);
        //设置Adapter
        recyclerView.setAdapter( myRecyclerAdapter =  new MyRecyclerAdapter() );

        toLogin(Constant.Access_Token);

        //下拉刷新
       initPullRefresh();
//        上拉加载
//        initLoadMoreListener();
    }

    private void toLogin(String ak) {
        CardLetterRequestApi.getInstance().getBank(ak, new HttpSubscriber<Bank>(new SubscriberOnListener<Bank>() {
            @Override
            public void onSucceed(Bank data) {
                if (data.getCode() == 0) {
                    myList = data.getData();
                    mSwipeRefreshLayout.setRefreshing(false);
                    myRecyclerAdapter. notifyItemInserted(myRecyclerAdapter.getItemCount());//必须用此方法才能进行recycleview的刷新。（末尾刷新）
                } else {
                    ToastUtils.makeShortText(data.getMsg(), ScreenActivity.this);
                }
                //数据库存储操作
                DataSupport.deleteAll(BankTable.class);
                for (Bank.DataBean bank: myList) {
                    DBCreate.addBankForBankTable(bank);
                }
                List<BankTable> all = DataSupport.findAll(BankTable.class);
                for (BankTable banktable: all) {
                    System.out.println("jk----bank   "+banktable.getId()+"----"+banktable.getName());
                }
            }
            @Override
            public void onError(int code, String msg) {
                ToastUtils.makeShortText("网络故障", ScreenActivity.this);
            }
        }, ScreenActivity.this));
    }
    private void initPullRefresh() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                toLogin(Constant.Access_Token);
                Toast.makeText(ScreenActivity.this, "没有更多可加载", Toast.LENGTH_SHORT).show();

            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.screen_affirm:
                setFlag();
                UIHelper.showMainActivity(this);
                finish();
                break;
        }

    }
    /**
     *  适配器
     */
    class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
        private View view ;
        private List<Integer> checkPositionlist = new ArrayList<>();

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            view = View.inflate(ScreenActivity.this, R.layout.item_screen_layout, null);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            //构造请求头
            String credentials="51kalaxin:62kaxin";
            final String basic = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
            LazyHeaders headers=  new LazyHeaders.Builder().addHeader("Authorization", basic).build();
            //url 要加载的图片的地址，imageView 显示图片的ImageView
            Glide.with(ScreenActivity.this).load(new GlideUrl(Constant.BASE_URL+myList.get(position).getCardIcon(), headers)).error(R.drawable.default_error).into(holder.iv);
            System.out.println("URL:"+Constant.BASE_URL+myList.get(position).getCardIcon());
            holder.tv.setText(myList.get(position).getName());
            holder.checkBox.setTag(new Integer(position));//设置tag 否则划回来时选中消失
            if (checkPositionlist != null) {
                holder.checkBox.setChecked((checkPositionlist.contains(new Integer(position)) ? true : false));
            } else {
                holder.checkBox.setChecked(false);
            }
            holder.iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.checkBox.isChecked()){
                        holder.checkBox.setChecked(false);
                    }else{
                        holder.checkBox.setChecked(true);
                    }
                }
            });
            onMyChecked(holder, position);

        }
        private void onMyChecked(final MyViewHolder viewHolder, final int position) {
            viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Bank.DataBean baseBean = myList.get(position);
                    if (isChecked) {
                        if (!checkPositionlist.contains(viewHolder.checkBox.getTag())) {
                            checkeddata.add(baseBean);
                            checkPositionlist.add(new Integer(position));
                        }
                    } else {
                        if (checkPositionlist.contains(viewHolder.checkBox.getTag())) {
                            checkeddata.remove(baseBean);
                            checkPositionlist.remove(new Integer(position));
                        }
                    }
                }
            });
        }
        @Override
        public int getItemCount() {
            return myList.size();
        }

        public void AddHeaderItem(List<Bank.DataBean> items){
            myList.addAll(items);
            notifyDataSetChanged();
        }


        public void AddFooterItem(List<Bank.DataBean> items){
            myList.addAll(items);
            notifyDataSetChanged();
        }


        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView iv;
            //ImageView radio;
            CheckBox checkBox;
            TextView tv;
            public MyViewHolder(View itemView) {
                super(itemView);
                iv = (ImageView) itemView.findViewById(R.id.item_img);
                tv = (TextView) itemView.findViewById(R.id.item_text);
                checkBox = (CheckBox) itemView.findViewById(R.id.radio_button);
            }

        }
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

    @Override
    public void finish() {

        super.finish();
    }
    private void setFlag(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < checkeddata.size(); i++) {
            int id = checkeddata.get(i).getId();
            sb.append(id+",");
        }
        Constant.MY_BANK = sb.toString();
        SharedPreferences.getInstance().putInt("splash_is_open", SplashActivity.SPLASH_UNOPEN); //去除首次打开
    }
}
