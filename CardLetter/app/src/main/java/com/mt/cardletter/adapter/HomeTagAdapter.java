package com.mt.cardletter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mt.cardletter.R;
import com.mt.cardletter.entity.news.NetNews;
import com.mt.cardletter.fragment.NetNewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/12.
 */

public class HomeTagAdapter extends RecyclerView.Adapter<HomeTagAdapter.ViewHolder>{

    private Context context ;
    private LayoutInflater inflater;
    private List<NetNews.ResultBeanX.ResultBean.ListBean> data;

    public HomeTagAdapter(Context context){
        this.context= context;
        data = new ArrayList<>();
        inflater=LayoutInflater.from(this.context);
    }

    public void addData(List<NetNews.ResultBeanX.ResultBean.ListBean> list){
        data.addAll(list);
        notifyDataSetChanged();
    }
    public void clearData(){
        data.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_news, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NetNews.ResultBeanX.ResultBean.ListBean bean = data.get(position);
        holder.tv_title.setText(bean.getTitle());
        holder.tv_content.setText(bean.getTime());
        if (bean.getPic() != null){
            Glide.with(this.context).load(bean.getPic()).error(R.drawable.default_error).into(holder.img);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title;
        TextView tv_content;
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.news_title);
            tv_content = (TextView) itemView.findViewById(R.id.news_content);
            img = (ImageView) itemView.findViewById(R.id.news_img);
        }
    }
}
