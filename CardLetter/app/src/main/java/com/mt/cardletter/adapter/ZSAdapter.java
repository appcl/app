package com.mt.cardletter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.bank.BankEntity;

import java.util.List;


/**
 * Date:2017/12/12
 * Time:13:35
 * author:demons
 */

public class ZSAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<BankEntity.BankBean.ZsListBean> list;

    public ZSAdapter(Context context, List<BankEntity.BankBean.ZsListBean> list) {
        this.context=context;
        this.list = list;
        inflater=LayoutInflater.from(context);
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder =null;
        final BankEntity.BankBean.ZsListBean bean= list.get(position);
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=inflater.inflate(R.layout.item_sh,parent,false);
            viewHolder.item_abs=(TextView) convertView.findViewById(R.id.item_abs);
            viewHolder.item_subj=(TextView) convertView.findViewById(R.id.item_subj);
            viewHolder.item_date=(TextView) convertView.findViewById(R.id.item_date);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.item_abs.setText(bean.getAbs());
        viewHolder.item_date.setText(bean.getDate());
        viewHolder.item_subj.setText(bean.getSubj());
        return convertView;
    }


    static class ViewHolder{
        private TextView item_abs,item_subj,item_date;
    }
}
