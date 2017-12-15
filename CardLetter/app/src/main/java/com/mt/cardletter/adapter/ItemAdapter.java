package com.mt.cardletter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.integral.IntegralEntity;
import com.mt.cardletter.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Date:2017/12/12
 * Time:14:01
 * author:demons
 */

public class ItemAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;

    private List<IntegralEntity.IntegralBean> list=new ArrayList<>();

    public ItemAdapter(Context context) {
        this.context=context;
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
        final IntegralEntity.IntegralBean bean= list.get(position);
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView=inflater.inflate(R.layout.item_layout,parent,false);

            viewHolder.text=(TextView)convertView.findViewById(R.id.item_text);
            viewHolder.img= (ImageView) convertView.findViewById(R.id.item_img);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.text.setText(bean.getDes_integral().toString());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.makeShortText("-----点击了-----"+position,context);
            }
        });
        return convertView;
    }

    public void setList(List<IntegralEntity.IntegralBean> list_item) {
        this.list = list_item;
    }

    public List<IntegralEntity.IntegralBean> getList() {
        return list;
    }

    static class ViewHolder{
        private TextView text;
        private ImageView img;
    }
}
