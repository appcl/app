package com.mt.cardletter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mt.cardletter.R;
import com.mt.cardletter.entity.integral.CategoryEntity;
import com.mt.cardletter.utils.Constant;

import java.util.List;

/**
 * Created by MQ on 2016/11/11.
 */

public class BankAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<CategoryEntity.DataBeanX.BankcardListBean> list;


    public BankAdapter(Context context, List<CategoryEntity.DataBeanX.BankcardListBean> list) {
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
        CategoryEntity.DataBeanX.BankcardListBean bean = list.get(i);
        if (itemView == null) {
            mHolder = new ViewHolder();
            itemView = inflater.inflate(R.layout.item_bank_tag, viewGroup, false);
            mHolder.tv_text = (ImageView) itemView.findViewById(R.id.b_img);
            itemView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) itemView.getTag();
        }
        if (bean != null) {
            Glide.with(context)
                    .load(Constant.PIC_URL+bean.getCard_img())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(mHolder.tv_text);
        }
        return itemView;
    }

    private class ViewHolder {
        private ImageView tv_text;
    }
}
