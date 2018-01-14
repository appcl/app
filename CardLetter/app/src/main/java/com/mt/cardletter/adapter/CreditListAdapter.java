package com.mt.cardletter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.bank.BankEntity;

import java.util.List;


/**
 * Date:2017/12/12
 * Time:13:35
 * author:demons
 */

public class CreditListAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<BankEntity.BankBean> list;

    public CreditListAdapter(Context context, List<BankEntity.BankBean> list) {
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
        final BankEntity.BankBean bean= list.get(position);
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=inflater.inflate(R.layout.credit_list_layout,parent,false);
            viewHolder.credit=(ImageView) convertView.findViewById(R.id.item_bank);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
//        viewHolder.credit.setImageDrawable(bean.getPic());
        return convertView;
    }


    static class ViewHolder{
        private ImageView credit;
    }
}
