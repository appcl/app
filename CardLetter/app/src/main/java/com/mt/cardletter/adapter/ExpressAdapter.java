package com.mt.cardletter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.express.Express_Content;

import java.util.List;

/**
 * Date:2018/1/3
 * Time:13:26
 * author:demons
 */

public class ExpressAdapter extends RecyclerView.Adapter {

    private LayoutInflater inflater;
    private List<Express_Content.ResultBean.ListBean> list;

    public ExpressAdapter(Context context,List<Express_Content.ResultBean.ListBean>list){
        inflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Viewholder(inflater.inflate(R.layout.item_cell, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Viewholder vh = (Viewholder) holder;
        // 绑定数据到ViewHolder里面
        vh.Title.setText(list.get(position).getDatetime().toString());
        vh.Text.setText(list.get(position).getRemark().toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //定义Viewholder
    class Viewholder extends RecyclerView.ViewHolder  {
        private TextView Title, Text;

        public Viewholder(View root) {
            super(root);
            Title = (TextView) root.findViewById(R.id.Itemtitle);
            Text = (TextView) root.findViewById(R.id.Itemtext);

        }

        public TextView getTitle() {
            return Title;
        }

        public TextView getText() {
            return Text;
        }


    }

}
