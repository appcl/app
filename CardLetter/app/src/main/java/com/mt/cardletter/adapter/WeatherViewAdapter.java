package com.mt.cardletter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mt.cardletter.R;
import com.mt.cardletter.activity.WeatherActivity;
import com.mt.cardletter.entity.data.HeWeather;
import com.mt.cardletter.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MQ on 2016/11/11.
 */

public class WeatherViewAdapter extends BaseAdapter {
    private List<HeWeather.HeWeather6Bean.HourlyBean> dataList;
    private Context context;

    public WeatherViewAdapter(Context context,List<HeWeather.HeWeather6Bean.HourlyBean> datas, int page) {
        this.context=context;
        dataList = new ArrayList<>();
        //start end分别代表要显示的数组在总数据List中的开始和结束位置
        int start = page * WeatherActivity.item_grid_num;
        int end = start + WeatherActivity.item_grid_num;
        while ((start < datas.size()) && (start < end)) {
            dataList.add(datas.get(start));
            start++;
        }
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View itemView, ViewGroup viewGroup) {
        ViewHolder mHolder;
        if (itemView == null) {
            mHolder = new ViewHolder();
            itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_weather_gridview, viewGroup, false);
            mHolder.iv_img = (ImageView) itemView.findViewById(R.id.iv_hourly_weather);
            mHolder.tv_time = (TextView) itemView.findViewById(R.id.tv_hourly_time);
            mHolder.tv_tmp = (TextView) itemView.findViewById(R.id.tv_hourly_temp);
            itemView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) itemView.getTag();
        }
        HeWeather.HeWeather6Bean.HourlyBean bean = dataList.get(i);

        if (bean != null) {
            mHolder.tv_time.setText(TimeUtils.string2String(bean.getTime(), TimeUtils.HOURLY_FORECAST_SDF, TimeUtils.HOUR_SDF));
            mHolder.tv_tmp.setText(bean.getTmp()+" °");
            String code = bean.getCond_code();
            switch (code){
                case "100":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/100.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "101":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/101.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "102":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/102.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "103":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/103.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "104":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/104.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "200":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/200.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "201":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/201.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "202":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/202.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "203":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/203.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "204":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/204.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "205":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/205.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "206":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/206.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "207":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/207.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "208":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/208.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "209":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/209.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "210":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/210.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "211":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/211.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "212":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/212.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "213":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/213.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "300":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/300.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "301":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/301.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "302":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/302.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "303":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/303.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "304":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/304.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "305":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/305.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "306":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/306.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "307":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/307.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "308":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/308.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "309":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/309.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "310":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/310.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "311":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/311.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "312":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/312.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "313":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/313.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "400":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/400.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "401":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/401.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "402":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/402.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "403":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/403.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "404":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/404.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "405":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/405.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "406":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/406.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "407":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/407.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "500":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/500.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "501":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/501.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "502":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/502.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "503":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/503.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "504":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/504.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "507":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/507.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "508":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/508.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "900":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/900.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "901":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/901.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
                case "999":
                    Glide.with(context).load("http://7xp1a1.com1.z0.glb.clouddn.com/weather1/999.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(mHolder.iv_img);
                    break;
            }
        }
        return itemView;
    }

    private class ViewHolder {
        private ImageView iv_img;
        private TextView tv_tmp;
        private TextView tv_time;
    }
}
