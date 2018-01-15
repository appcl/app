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
import com.mt.cardletter.entity.integral.SearchIntegralData;
import com.mt.cardletter.utils.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MQ on 2016/11/11.
 */

public class SearchIntegralAdapter extends RecyclerView.Adapter<SearchIntegralAdapter.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<SearchIntegralData.DataBeanX.DataBean> list;
    private OnItemClickListener mItemClickListener;


    public SearchIntegralAdapter(Context context) {
        this.context=context;
        list = new ArrayList<>();
        inflater=LayoutInflater.from(this.context);
    }

    public void addData(List<SearchIntegralData.DataBeanX.DataBean> list){
        this.list.addAll(list);
        notifyDataSetChanged();
    }
    public void clearData(){
        this.list.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_b_seller, parent, false);
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
        final SearchIntegralData.DataBeanX.DataBean bean = list.get(position);
        holder.tv_name.setText(bean.getName());
        holder.bjf_jf.setText("消费积分: "+String.valueOf(bean.getNeed_score()));
        holder.bjf_time.setText(bean.getCreate_time());
        Glide.with(context)
                .load(Constant.PIC_URL+bean.getThumb())
                .error(R.drawable.default_error)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.img_bfj);
        holder.itemView.setTag(position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_name,bjf_jf,bjf_time;
        private ImageView img_bfj;
        public ViewHolder(View itemView){
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.bjf_name);
            bjf_jf = (TextView) itemView.findViewById(R.id.bjf_jf);
            img_bfj = (ImageView) itemView.findViewById(R.id.bjf_img);
            bjf_time = (TextView) itemView.findViewById(R.id.bjf_time);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }
}
