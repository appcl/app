package com.mt.cardletter.view.exchange;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mt.cardletter.R;
import com.mt.cardletter.entity.food.FoodBean;

import java.util.List;

/**
 * Date:2018/3/13
 * Time:11:03
 * author:demons
 */

public class DetailAdapter extends BaseQuickAdapter<FoodBean, BaseViewHolder>{
    private AddWidget.OnAddClick onAddClick;
    public DetailAdapter(@Nullable List<FoodBean> data, AddWidget.OnAddClick onAddClick) {
        super(R.layout.item_detail, data);
        this.onAddClick = onAddClick;
    }

    @Override
    protected void convert(BaseViewHolder helper, FoodBean item) {
        helper.setText(R.id.textView6, item.getName())
                .setText(R.id.textView7, item.getSale())
                .setText(R.id.textView8, item.getStrPrice(mContext))
                .setImageResource(R.id.imageView2, item.getIcon())
        ;
        AddWidget addWidget = helper.getView(R.id.detail_addwidget);
        addWidget.setData(onAddClick,item);
    }
}
