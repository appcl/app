package com.mt.cardletter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.integral.CategoryEntity;

import java.util.List;

/**
 * Created by MQ on 2016/11/11.
 */

public class CategoryAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<CategoryEntity.DataBean> list;


    public CategoryAdapter(Context context, List<CategoryEntity.DataBean> list) {
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
        CategoryEntity.DataBean bean = list.get(i);
        if (itemView == null) {
            mHolder = new ViewHolder();
            itemView = inflater.inflate(R.layout.item_cagegroy, viewGroup, false);
            mHolder.tv_text = (TextView) itemView.findViewById(R.id.c_tv);
            itemView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) itemView.getTag();
        }
        if (bean != null) {
            mHolder.tv_text.setText(bean.getName());
        }
        return itemView;
    }

    private class ViewHolder {
        private TextView tv_text;
    }
}
