package com.mt.cardletter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.integral.IntegralEntity;

import java.util.List;

/**
 * Created by MQ on 2016/11/11.
 */

public class IntegralAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<IntegralEntity> list;


    public IntegralAdapter(Context context, List<IntegralEntity> list) {
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
        IntegralEntity bean = list.get(i);
        if (itemView == null) {
            mHolder = new ViewHolder();
            itemView = inflater.inflate(R.layout.item_intergal, viewGroup, false);
            mHolder.iv_img = (ImageView) itemView.findViewById(R.id.intergal_iv);
            mHolder.tv_text = (TextView) itemView.findViewById(R.id.intergal_tv);
            itemView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) itemView.getTag();
        }
        if (bean != null) {
            mHolder.iv_img.setImageResource(R.drawable.default_error);
            mHolder.tv_text.setText(bean.getI_tv());
        }
        return itemView;
    }

    private class ViewHolder {
        private ImageView iv_img;
        private TextView tv_text;
    }
}
