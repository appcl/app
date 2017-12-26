package com.mt.cardletter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.data.ViolateData;

import java.util.ArrayList;
import java.util.List;

/**
 * Date:2017/12/12
 * Time:14:01
 * author:demons
 */

public class ViolateAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;

    private List<ViolateData.ResultBean.ListsBean> list=new ArrayList<>();

    public ViolateAdapter(Context context,List<ViolateData.ResultBean.ListsBean> list) {
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
        final ViolateData.ResultBean.ListsBean bean= list.get(position);
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=inflater.inflate(R.layout.item_violate,parent,false);

            viewHolder.violate_date=(TextView)convertView.findViewById(R.id.violate_date);
            viewHolder.violate_area=(TextView)convertView.findViewById(R.id.violate_area);
            viewHolder.violate_act=(TextView)convertView.findViewById(R.id.violate_act);
            viewHolder.violate_fen=(TextView)convertView.findViewById(R.id.violate_fen);
            viewHolder.violate_money=(TextView)convertView.findViewById(R.id.violate_money);

            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.violate_date.setText(bean.getDate().toString());
        viewHolder.violate_area.setText(bean.getArea().toString());
        viewHolder.violate_act.setText(bean.getAct().toString());
        viewHolder.violate_fen.setText("扣 "+bean.getFen()+" 分");
        viewHolder.violate_money.setText("罚款:"+bean.getMoney());

        return convertView;
    }


    static class ViewHolder{
        private TextView violate_date;
        private TextView violate_area;
        private TextView violate_act;
        private TextView violate_fen;
        private TextView violate_money;

    }
}
