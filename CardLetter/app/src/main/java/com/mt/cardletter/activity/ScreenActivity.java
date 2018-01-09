package com.mt.cardletter.activity;

import android.graphics.Color;
import android.os.Handler;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.mt.cardletter.R;
import com.mt.cardletter.entity.merchant.Bank;
import com.mt.cardletter.entity.user.LoginEntity;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.SharedPreferences;
import com.mt.cardletter.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class ScreenActivity extends BaseActivity implements View.OnClickListener{
    private RecyclerView recyclerView;
    private TextView makeShow;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private MyRecyclerAdapter myRecyclerAdapter;
    private List<Bank.DataBean> myList = new ArrayList<>();
    private List<Bank.DataBean> checkeddata = new ArrayList<>();// 选中的数据
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_screen;
    }
    @Override
    public void initView() {
        findViewById(R.id.screen_affirm).setOnClickListener(this);
        findViewById(R.id.screen_next).setOnClickListener(this);
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
                    System.out.println("=======myList.size()"+myList.size());
                    //myRecyclerAdapter.notifyDataSetChanged();
                    mSwipeRefreshLayout.setRefreshing(false);
                    myRecyclerAdapter. notifyItemInserted(myRecyclerAdapter.getItemCount());//必须用此方法才能进行recycleview的刷新。（末尾刷新）
                } else {
                    ToastUtils.makeShortText(data.getMsg(), ScreenActivity.this);
                }
            }
            @Override
            public void onError(int code, String msg) {
                ToastUtils.makeShortText("====xz======网络故障+code:  "+code, ScreenActivity.this);
            }
        }, ScreenActivity.this));
    }
    private void initPullRefresh() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                toLogin(Constant.Access_Token);
                Toast.makeText(ScreenActivity.this, "没有更多可加载", Toast.LENGTH_SHORT).show();
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        headDatas = new ArrayList<>();
//                        for (int i = list.size(); i< list.size()+10; i++) {
//                            Bean bean = new Bean();
//                            bean.name = "Heard Item "+i;
//                            headDatas.add(bean);
//                        }
//                        myRecyclerAdapter.AddHeaderItem(headDatas);
//                        //刷新完成
//                        mSwipeRefreshLayout.setRefreshing(false);
//                        Toast.makeText(ScreenActivity.this, "更新了 "+headDatas.size()+" 条目数据", Toast.LENGTH_SHORT).show();
//                    }
//                }, 2000);
            }
        });
    }
    private void initLoadMoreListener() {
//        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
//            int lastVisibleItem ;
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//
//                //判断RecyclerView的状态 是空闲时，同时，是最后一个可见的ITEM时才加载
//                if(newState==RecyclerView.SCROLL_STATE_IDLE&&lastVisibleItem+1==myRecyclerAdapter.getItemCount()){
//
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//
//                            List<Bean> footerDatas = new ArrayList<>();
//                            for (int i = list.size(); i< list.size()+10; i++) {
//                                Bean bean = new Bean();
//                                bean.name = "Heard Item "+i;
//                                footerDatas.add(bean);
//                            }
//                            myRecyclerAdapter.AddFooterItem(footerDatas);
//                            Toast.makeText(ScreenActivity.this, "更新了 "+footerDatas.size()+" 条目数据", Toast.LENGTH_SHORT).show();
//                        }
//                    }, 3000);
//                }
//
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//
//                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
//                //最后一个可见的ITEM
//                lastVisibleItem=layoutManager.findLastVisibleItemPosition();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        finish();
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
            final String basic =
                    "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
            //Authorization 请求头信息
            LazyHeaders headers=  new LazyHeaders.Builder().addHeader("Authorization", basic).build();
            //url 要加载的图片的地址，imageView 显示图片的ImageView
            Glide.with(ScreenActivity.this).load(new GlideUrl(Constant.BASE_URL+myList.get(position).getCardIcon(), headers)).error(R.drawable.default_error).into(holder.iv);
            //===========================
//            LazyHeaders headers=  new LazyHeaders.Builder().addHeader("Authorization", Constant.BASIC).build();
//            String url = Constant.BASE_URL+myList.get(position).getCardIcon();
//            Glide.with(ScreenActivity.this).load(new GlideUrl(url, headers)).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.iv);
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
}
