package com.mt.cardletter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.seller.SellerEntity;

import java.util.LinkedList;

/**
 * Created by MQ on 2016/11/11.
 */

public class SellerAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private LinkedList<SellerEntity.DataBeanX.DataBean> list;


    public SellerAdapter(Context context, LinkedList<SellerEntity.DataBeanX.DataBean> list) {
        this.context=context;
        this.list = list;
        inflater=LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View itemView, ViewGroup viewGroup) {
        ViewHolder mHolder;
        SellerEntity.DataBeanX.DataBean bean = list.get(i);
        if (itemView == null) {
            mHolder = new ViewHolder();
            itemView = inflater.inflate(R.layout.item_seller, viewGroup, false);
            mHolder.tv_name = (TextView) itemView.findViewById(R.id.s_name);
            mHolder.tv_des = (TextView) itemView.findViewById(R.id.s_des);
            mHolder.tv_time = (TextView) itemView.findViewById(R.id.s_time);
            itemView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) itemView.getTag();
        }
        if (bean != null) {
            mHolder.tv_name.setText(bean.getName());
            mHolder.tv_des.setText(bean.getDescribe());
            mHolder.tv_time.setText(bean.getCreate_time());
        }
        return itemView;
    }

    private class ViewHolder {
        private TextView tv_name,tv_des,tv_time;
    }
}
