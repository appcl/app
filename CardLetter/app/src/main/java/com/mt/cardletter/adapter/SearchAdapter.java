package com.mt.cardletter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mt.cardletter.R;
import com.mt.cardletter.entity.data.SearchDatas;
import com.mt.cardletter.utils.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MQ on 2016/11/11.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<SearchDatas.DataBeanX.DataBean> list;
    private OnItemClickListener mItemClickListener;



    public SearchAdapter(Context context) {
        this.context=context;
        list = new ArrayList<>();
        inflater=LayoutInflater.from(this.context);
    }

    public void addData(List<SearchDatas.DataBeanX.DataBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    public void clearData(){
        this.list.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_seller, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener!=null){
                    mItemClickListener.onItemClick((Integer) v.getTag());
                }
            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final SearchDatas.DataBeanX.DataBean bean = list.get(position);
        holder.tv_name.setText(bean.getName());
        holder.tv_des.setText(bean.getDescribe());
        holder.tv_time.setText(bean.getCreate_time());
        Glide.with(context)
                .load(Constant.PIC_URL+bean.getThumb())
                .error(R.drawable.default_error)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ss_img);
        holder.itemView.setTag(position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name,tv_des,tv_time;
        private ImageView ss_img;
        public ViewHolder(View itemView){
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.s_name);
            tv_des = (TextView) itemView.findViewById(R.id.s_des);
            ss_img = (ImageView) itemView.findViewById(R.id.ss_img);
            tv_time= (TextView) itemView.findViewById(R.id.s_time);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }
}
