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
 * Time:14:44
 * author:demons
 */

public class BillListAdapter extends BaseAdapter {

    private Context context;
    private List<List<Bill.TotalBean>> list = new ArrayList<>();
    private LayoutInflater inflater;

    public BillListAdapter(Context context, List<List<Bill.TotalBean>> list) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(this.context);
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
        ViewHolder holder = null;
        List<Bill.TotalBean> bank =  list.get(position);
        if (convertView ==null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.bank_layout,parent,false);
            holder.bill_bank = (TextView) convertView.findViewById(R.id.bill_bank);
            holder.bill_total = (TextView) convertView.findViewById(R.id.bill_total);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
            holder.bill_bank.setText(bank.get(0).getBank());
            holder.bill_total.setText("共有"+bank.size()+"条记录");
        return convertView;
    }

    private class ViewHolder {
        private TextView bill_bank;
        private TextView bill_total;
    }

}
