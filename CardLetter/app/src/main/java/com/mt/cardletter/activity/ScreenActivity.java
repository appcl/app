package com.mt.cardletter.activity;

import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.mt.cardletter.R;
import java.util.ArrayList;

public class ScreenActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private ArrayList<String> list;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_screen;
    }
    @Override
    public void initView() {
        init();
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
        recyclerView.setAdapter( new MyRecyclerAdapter());
    }
    private void init() {
        list = new ArrayList();
        for ( int i = 0 ; i <= 100 ; i ++ ){
            list.add("item "+i);
        }
    }

    /**
     *  适配器
     */
    class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(ScreenActivity.this, R.layout.item_screen_layout, null);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        }
        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            holder.iv.setImageResource(R.drawable.default_error);
            holder.tv.setText(list.get(position));
            holder.iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.radio.getTag().equals("false")){
                        holder.radio.setImageResource(R.mipmap.radio_button_selected);
                        holder.radio.setTag("true");
                    } else {
                        holder.radio.setImageResource(R.mipmap.radio_button);
                        holder.radio.setTag("false");
                    }
                }
            });
            holder.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.radio.getTag().equals("false")){
                        holder.radio.setImageResource(R.mipmap.radio_button_selected);
                        holder.radio.setTag("true");
                    } else {
                        holder.radio.setImageResource(R.mipmap.radio_button);
                        holder.radio.setTag("false");
                    }
                }
            });
        }
        @Override
        public int getItemCount() {
            return list.size();
        }



        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView iv,radio;
            TextView tv;
            public MyViewHolder(View itemView) {
                super(itemView);
                iv = (ImageView) itemView.findViewById(R.id.item_img);
                tv = (TextView) itemView.findViewById(R.id.item_text);
                radio = (ImageView) itemView.findViewById(R.id.radio_button);
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
