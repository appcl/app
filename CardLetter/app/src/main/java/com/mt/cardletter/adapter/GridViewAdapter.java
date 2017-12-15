package com.mt.cardletter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.SearchIntegralActivity;
import com.mt.cardletter.entity.data.DataBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MQ on 2016/11/11.
 */

public class GridViewAdapter extends BaseAdapter {
    private List<DataBean> dataList;

    public GridViewAdapter(List<DataBean> datas, int page) {
        dataList = new ArrayList<>();
        //start end分别代表要显示的数组在总数据List中的开始和结束位置
        int start = page * SearchIntegralActivity.item_grid_num;
        int end = start + SearchIntegralActivity.item_grid_num;
        while ((start < datas.size()) && (start < end)) {
            dataList.add(datas.get(start));
            start++;
        }
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View itemView, ViewGroup viewGroup) {
        ViewHolder mHolder;
        if (itemView == null) {
            mHolder = new ViewHolder();
            itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_gridview, viewGroup, false);
            mHolder.iv_img = (ImageView) itemView.findViewById(R.id.iv_img);
            mHolder.tv_text = (TextView) itemView.findViewById(R.id.tv_text);
            itemView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) itemView.getTag();
        }
        DataBean bean = dataList.get(i);
        if (bean != null) {
            mHolder.iv_img.setImageResource(R.mipmap.group_icon);
            mHolder.tv_text.setText(bean.name);
        }
        return itemView;
    }

    private class ViewHolder {
        private ImageView iv_img;
        private TextView tv_text;
    }
}
