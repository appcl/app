package com.mt.cardletter.activity;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
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

import com.mt.cardletter.R;
import com.mt.cardletter.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class ScreenActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private ArrayList<Bean> list;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private MyRecyclerAdapter myRecyclerAdapter;
    private  List<Bean> headDatas;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_screen;
    }
    @Override
    public void initView() {
        init();

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
        //设置Adapter
        recyclerView.setAdapter( myRecyclerAdapter =  new MyRecyclerAdapter() );
        //下拉刷新
//        initPullRefresh();
//        //上拉加载
//        initLoadMoreListener();
    }
    class Bean{
        String name;
        boolean flag;
    }
    private void init() {
        list = new ArrayList();
        for ( int i = 0 ; i <= 60 ; i ++ ){
            Bean bean = new Bean();
            bean.name = "item"+i;
            bean.flag = false;
            list.add(bean);
        }
    }
    private void initPullRefresh() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        headDatas = new ArrayList<>();
                        for (int i = list.size(); i< list.size()+10; i++) {
                            Bean bean = new Bean();
                            bean.name = "Heard Item "+i;
                            headDatas.add(bean);
                        }
                        myRecyclerAdapter.AddHeaderItem(headDatas);
                        //刷新完成
                        mSwipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(ScreenActivity.this, "更新了 "+headDatas.size()+" 条目数据", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            }
        });
    }
    private void initLoadMoreListener() {

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            int lastVisibleItem ;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                //判断RecyclerView的状态 是空闲时，同时，是最后一个可见的ITEM时才加载
                if(newState==RecyclerView.SCROLL_STATE_IDLE&&lastVisibleItem+1==myRecyclerAdapter.getItemCount()){

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            List<Bean> footerDatas = new ArrayList<>();
                            for (int i = list.size(); i< list.size()+10; i++) {
                                Bean bean = new Bean();
                                bean.name = "Heard Item "+i;
                                footerDatas.add(bean);
                            }
                            myRecyclerAdapter.AddFooterItem(footerDatas);
                            Toast.makeText(ScreenActivity.this, "更新了 "+footerDatas.size()+" 条目数据", Toast.LENGTH_SHORT).show();
                        }
                    }, 3000);
                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                //最后一个可见的ITEM
                lastVisibleItem=layoutManager.findLastVisibleItemPosition();
            }
        });

    }
    /**
     *  适配器
     */
    class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
        private View view ;
        private List<Integer> checkPositionlist = new ArrayList<>();
        private List<Bean> checkeddata = new ArrayList<>();// 选中的数据

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            view = View.inflate(ScreenActivity.this, R.layout.item_screen_layout, null);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            holder.iv.setImageResource(R.drawable.default_error);
            holder.tv.setText(list.get(position).name);
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
                    Bean baseBean = list.get(position);
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
            return list.size();
        }

        public void AddHeaderItem(List<Bean> items){
            list.addAll(items);
            notifyDataSetChanged();
        }


        public void AddFooterItem(List<Bean> items){
            list.addAll(items);
            notifyDataSetChanged();
        }


        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView iv;
            ImageView radio;
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
