package com.mt.cardletter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.integral.IntegralEntity;
import com.mt.cardletter.view.NoScrollGridView;

import java.util.ArrayList;
import java.util.List;


/**
 * Date:2017/12/12
 * Time:13:35
 * author:demons
 */

public class ContentAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<IntegralEntity> list;
    private List<IntegralEntity.IntegralBean> list_item=new ArrayList<>();

    public ContentAdapter(Context context, List<IntegralEntity> list) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder =null;
        IntegralEntity bean = list.get(position);
        if (convertView==null){
            convertView=inflater.inflate(R.layout.item_content_layout,parent,false);
            viewHolder=new ViewHolder(convertView);
            viewHolder.gridView= (NoScrollGridView) convertView.findViewById(R.id.item_grid);
            viewHolder.item_tag = (ImageView) convertView.findViewById(R.id.item_tag);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }

//        viewHolder.item_tag.setBackgroundColor(context.getResources().getColor(R.color.blue));

        list_item=bean.getBean();
        viewHolder.adapter.setList(list_item);
        viewHolder.adapter.notifyDataSetChanged();
        return convertView;
    }

    class ViewHolder{
        private ImageView item_tag;
        private NoScrollGridView gridView;
        ItemAdapter adapter;
        public ViewHolder(View view) {

            gridView = (NoScrollGridView) view.findViewById(R.id.item_grid);
            //将adapter定义在此，优化滑动效果(核心)
            adapter = new ItemAdapter(context);
            //在此设置适配器，数据源在getView中添加(核心)
            gridView.setAdapter(adapter);
            view.setTag(this);
        }
    }
}
