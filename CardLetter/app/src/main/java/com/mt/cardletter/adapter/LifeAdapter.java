package com.mt.cardletter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.data.HeWeather;

import java.util.List;

/**
 * Date:2017/12/19
 * Time:19:40
 * author:demons
 */

public class LifeAdapter extends BaseAdapter {
    private List<HeWeather.HeWeather6Bean.LifestyleBean> list;
    private Context context;
    private LayoutInflater inflater;

    public LifeAdapter(Context context, List<HeWeather.HeWeather6Bean.LifestyleBean> list){
        this.context =context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
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
        ViewHolder mHolder;
        if (convertView == null) {
            mHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.activity_knowledge_layout, parent, false);
            mHolder.civ_suggesstion = (com.mt.cardletter.view.CircleImageView) convertView.findViewById(R.id.civ_suggesstion);
            mHolder.tvMsg = (TextView) convertView.findViewById(R.id.tvMsg);
            mHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) convertView.getTag();
        }
        HeWeather.HeWeather6Bean.LifestyleBean bean = list.get(position);
        mHolder.tvMsg.setText(bean.getBrf());
        if (bean.getType().equals("air")){
            mHolder.tvName.setText("空气");
            mHolder.civ_suggesstion.setImageResource(R.drawable.ic_air);
            mHolder.civ_suggesstion.setFillColor(0xFF7F9EE9);
        }else if (bean.getType().equals("cw")){
            mHolder.tvName.setText("洗车");
            mHolder.civ_suggesstion.setImageResource(R.drawable.ic_cw);
            mHolder.civ_suggesstion.setFillColor(0xFF62B1FF);
        }else if (bean.getType().equals("comf")){
            mHolder.tvName.setText("舒适度");
            mHolder.civ_suggesstion.setImageResource(R.drawable.ic_comf);
            mHolder.civ_suggesstion.setFillColor(0xFFE99E3C);
        }
        else if (bean.getType().equals("drsg")){
            mHolder.tvName.setText("穿衣");
            mHolder.civ_suggesstion.setImageResource(R.drawable.ic_drsg);
            mHolder.civ_suggesstion.setFillColor(0xFF8FC55F);
        }
        else if (bean.getType().equals("flu")){
            mHolder.tvName.setText("感冒");
            mHolder.civ_suggesstion.setImageResource(R.drawable.ic_flu);
            mHolder.civ_suggesstion.setFillColor(0xFFF98178);
        }
        else if (bean.getType().equals("sport")){
            mHolder.tvName.setText("运动");
            mHolder.civ_suggesstion.setImageResource(R.drawable.ic_sport);
            mHolder.civ_suggesstion.setFillColor(0xFFB3CA60);
        }
        else if (bean.getType().equals("trav")){
            mHolder.tvName.setText("旅游");
            mHolder.civ_suggesstion.setImageResource(R.drawable.ic_trav);
            mHolder.civ_suggesstion.setFillColor(0xFFFD6C35);
        }else {
            mHolder.tvName.setText("紫外线");
            mHolder.civ_suggesstion.setImageResource(R.drawable.ic_uv);
            mHolder.civ_suggesstion.setFillColor(0xFFF0AB2A);
        }
        return convertView;
    }

    private class ViewHolder {
        private com.mt.cardletter.view.CircleImageView civ_suggesstion;
        private TextView tvMsg;
        private TextView tvName;
    }
}
