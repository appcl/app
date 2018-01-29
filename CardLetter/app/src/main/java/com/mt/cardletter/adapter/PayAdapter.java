package com.mt.cardletter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.bank.Jt_BankEntity;

import java.util.List;

/**
 * Date:2018/1/24
 * Time:17:55
 * author:demons
 */

public class PayAdapter extends BaseAdapter {
    private Context context;
    private List<Jt_BankEntity.PayRecord> list;
    private LayoutInflater inflater;

    public PayAdapter(Context context, List<Jt_BankEntity.PayRecord> list) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        final Jt_BankEntity.PayRecord bean = list.get(position);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.pay_item_layout,parent,false);

            viewHolder.trans_tv = (TextView) convertView.findViewById(R.id.item_trans);
            viewHolder.post_tv = (TextView) convertView.findViewById(R.id.item_post);
            viewHolder.desc_tv = (TextView) convertView.findViewById(R.id.item_desc);
            viewHolder.amount_tv = (TextView) convertView.findViewById(R.id.item_amount);
            viewHolder.card_tv = (TextView) convertView.findViewById(R.id.item_cardnum);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.trans_tv.setText(bean.getTrans_date());
        viewHolder.post_tv.setText(bean.getPost_date());
        viewHolder.desc_tv.setText(bean.getDesc());
        viewHolder.amount_tv.setText(bean.getAmount());
        viewHolder.card_tv.setText(bean.getCardNum());
        return convertView;
    }


    class ViewHolder {
        public TextView trans_tv, post_tv, desc_tv, amount_tv, card_tv;
    }


}
