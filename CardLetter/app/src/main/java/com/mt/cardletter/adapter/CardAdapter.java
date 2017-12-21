package com.mt.cardletter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mt.cardletter.R;

import java.util.HashMap;
import java.util.List;

/**
 * Date:2017/12/20
 * Time:15:15
 * author:demons
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private Context mContext;
    private List<HashMap<String, String>> mList;

    public CardAdapter(Context context,List<HashMap<String, String>> list) {
        this.mContext=context;
        this.mList=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 给ViewHolder设置布局文件
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // 给ViewHolder设置元素
//        ImageLoader.getInstance().displayImage(mList.get(position).get("A"), holder.mImageView);
//        Glide.with(mContext).load(mList.get(position).get("A")).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.mImageView);
        holder.repay_cardnumber.setText(mList.get(position).get("name"));
        holder.repay_value.setText(mList.get(position).get("value"));
        holder.repay_date.setText(mList.get(position).get("day"));
    }

    @Override
    public int getItemCount() {
        // 返回数据总数
        return mList == null ? 0 : mList.size();
    }


    // 重写的自定义ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView repay_text;
        public TextView repay_cardnumber;
        public TextView repay_value;
        public TextView repay_date;
        public TextView repay_btn;

        public ViewHolder(View v) {
            super(v);
            mImageView = (ImageView) v.findViewById(R.id.pic);
            repay_text = (TextView) v.findViewById(R.id.repay_text);
            repay_cardnumber = (TextView) v.findViewById(R.id.card_number);
            repay_value = (TextView) v.findViewById(R.id.repay_value);
            repay_date = (TextView) v.findViewById(R.id.repay_date);
            repay_btn = (Button) v.findViewById(R.id.repay_btn);

        }
    }

}
