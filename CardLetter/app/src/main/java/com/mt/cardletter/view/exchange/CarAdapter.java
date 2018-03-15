package com.mt.cardletter.view.exchange;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mt.cardletter.R;
import com.mt.cardletter.entity.food.FoodBean;

import java.math.BigDecimal;
import java.util.List;

/**
 * Date:2018/3/13
 * Time:10:07
 * author:demons
 */

public class CarAdapter extends BaseQuickAdapter<FoodBean,BaseViewHolder>{

    private AddWidget.OnAddClick onAddClick;

    public CarAdapter(@Nullable List<FoodBean> data, AddWidget.OnAddClick onAddClick) {
        super(R.layout.item_car, data);
        this.onAddClick = onAddClick;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, FoodBean item) {
        baseViewHolder.setText(R.id.car_name, item.getName())
                .setText(R.id.car_price, item.getStrPrice(mContext, item.getPrice().multiply(BigDecimal.valueOf(item.getSelectCount()))))
        ;
        AddWidget addWidget = baseViewHolder.getView(R.id.car_addwidget);
//		addWidget.setData(this, helper.getAdapterPosition(), onAddClick);
        addWidget.setData(onAddClick,item);
    }
}
