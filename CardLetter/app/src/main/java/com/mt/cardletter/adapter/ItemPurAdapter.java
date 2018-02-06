package com.mt.cardletter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.bank.Bill;

import java.util.ArrayList;
import java.util.List;

/**
 * Date:2018/2/5
 * Time:18:18
 * author:demons
 */

public class ItemPurAdapter extends BaseAdapter {

    private Context context;
    private List<Bill.TotalBean.TradeBean> trade=new ArrayList<>();

    public ItemPurAdapter(Context context, List<Bill.TotalBean.TradeBean> trade) {
        this.context = context;
        this.trade = trade;
    }

    @Override
    public int getCount() {
        return trade.size();
    }

    @Override
    public Object getItem(int position) {
        return trade.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        Bill.TotalBean.TradeBean item = trade.get(position);
        if (holder ==null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_pur,parent,false);
            holder.tv_des = (TextView) convertView.findViewById(R.id.tv_des);
            holder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
            holder.tv_amount = (TextView) convertView.findViewById(R.id.tv_amount);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        holder.tv_des.setText(item.getDescription());
        holder.tv_date.setText(item.getTrans_Date());
        holder.tv_amount.setText(item.getAmount());
        return convertView;
    }

    private static class ViewHolder {
        private TextView tv_des;
        private TextView tv_date;
        private TextView tv_amount;
    }
}
