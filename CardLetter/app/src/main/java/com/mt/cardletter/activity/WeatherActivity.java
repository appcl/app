package com.mt.cardletter.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.adapter.LifeAdapter;
import com.mt.cardletter.adapter.ViewPagerAdapter;
import com.mt.cardletter.adapter.WeatherViewAdapter;
import com.mt.cardletter.adapter.WeatherWeekViewAdapter;
import com.mt.cardletter.adapter.WeekViewPagerAdapter;
import com.mt.cardletter.entity.data.AirDatas;
import com.mt.cardletter.entity.data.HeWeather;
import com.mt.cardletter.https.HttpRequestApi;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.view.indicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 天气页面
 * Date:2017/12/18
 * Time:17:14
 * author:demons
 */

public class WeatherActivity extends BaseActivity {

    private HeWeather.HeWeather6Bean weatherbean;

    private TextView tvCity;

    private LinearLayout layoutNow;
    private RelativeLayout layoutDetails;

    private TextView tvNowWeatherString;
    private TextView tvNowTemp;

    private TextView tvNowHum;
    private TextView tvNowPres;
    private TextView tvNowWindSc;
    private TextView tvNowWindDir;

    private TextView tvTodayTempMax;
    private TextView tvTodayTempMin;

    public static int item_grid_num = 4;//每一页中GridView中item的数量
    public static int number_columns = 4;//gridview一行展示的数目
    private ViewPager view_pager;
    private ViewPagerAdapter mAdapter;
    private List<HeWeather.HeWeather6Bean.HourlyBean> hourList=new ArrayList<>();
    private List<GridView> gridList = new ArrayList<>();
    private CirclePageIndicator indicator;

    private ViewPager view_pager_week;
    private WeekViewPagerAdapter mAdapter_week;
    private List<GridView> gridList_week = new ArrayList<>();
    private CirclePageIndicator indicator_week;
    private List<HeWeather.HeWeather6Bean.DailyForecastBean> dailyList=new ArrayList<>();

    private AirDatas.HeWeather6Bean air_bean;
    private Button air_qlty;
    private TextView tv_aqi_name0,tv_aqi_name1,tv_aqi_name2,tv_aqi_name3,tv_aqi_name4,tv_aqi_name5;
    private TextView tv_aqi_desc0,tv_aqi_desc1,tv_aqi_desc2,tv_aqi_desc3,tv_aqi_desc4,tv_aqi_desc5;
    private TextView tv_aqi_value0,tv_aqi_value1,tv_aqi_value2,tv_aqi_value3,tv_aqi_value4,tv_aqi_value5;
    private View view_aqi_qlty0,view_aqi_qlty1,view_aqi_qlty2,view_aqi_qlty3,view_aqi_qlty4,view_aqi_qlty5;

    private GridView life_gridview;
    private LifeAdapter lifeAdapter;
    private String city;

    private List<HeWeather.HeWeather6Bean.LifestyleBean> life_list = new ArrayList<>();

    @Override
    protected int getLayoutResId() {
        getWeatherData();
        getAirDatas();
        return R.layout.activity_weather;
    }

    //获取天气实体
    private void getWeatherData() {
        Intent intent = getIntent();
        weatherbean = (HeWeather.HeWeather6Bean) intent.getSerializableExtra("weatherbean");
        city=intent.getStringExtra("city");
    }

    /**
     * 获取空气质量指数
     */
    private void getAirDatas() {
        air_bean = new AirDatas.HeWeather6Bean();
        HttpRequestApi.getInstance().getAir(city,"5ee8321670ca46aab8e7555d3b3c074b",
                new HttpSubscriber<AirDatas>(new SubscriberOnListener<AirDatas>() {
            @Override
            public void onSucceed(AirDatas data) {
                String status = data.getHeWeather6().get(0).getStatus();
                if (status.equals("ok")){
                    air_bean = data.getHeWeather6().get(0);
                    showNowAir();
                }else {
                    air_bean = new AirDatas.HeWeather6Bean();
                    ToastUtils.makeShortText("加载空气指数数据出错啦，请稍后再试",WeatherActivity.this);
                }
            }

            @Override
            public void onError(int code, String msg) {

            }
        },WeatherActivity.this));
    }

    @Override
    public void initView() {

        tvCity= (TextView) findViewById(R.id.layout_city);

        layoutNow = (LinearLayout) findViewById(R.id.layout_now);
        layoutDetails = (RelativeLayout) findViewById(R.id.layout_details);

        tvNowWeatherString = (TextView) findViewById(R.id.tv_weather_string);
        tvNowTemp = (TextView) findViewById(R.id.tv_temp);

        tvTodayTempMax = (TextView) findViewById(R.id.tv_temp_max);
        tvTodayTempMin = (TextView) findViewById(R.id.tv_temp_min);

        tvNowHum = (TextView) findViewById(R.id.tv_now_hum);
        tvNowPres = (TextView) findViewById(R.id.tv_now_pres);
        tvNowWindSc = (TextView) findViewById(R.id.tv_now_wind_sc);
        tvNowWindDir = (TextView) findViewById(R.id.tv_now_wind_dir);
        //初始化ViewPager
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        mAdapter = new ViewPagerAdapter();
        view_pager.setAdapter(mAdapter);
        //圆点指示器
        indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        indicator.setVisibility(View.GONE);
        indicator.setViewPager(view_pager);

        //初始化weekviewPager
        view_pager_week = (ViewPager) findViewById(R.id.view_pager_week);
        mAdapter_week = new WeekViewPagerAdapter();
        view_pager_week.setAdapter(mAdapter_week);
        //圆点指示器
        indicator_week = (CirclePageIndicator) findViewById(R.id.indicator_week);
        indicator_week.setVisibility(View.GONE);
        indicator_week.setViewPager(view_pager_week);

        air_qlty = (Button) findViewById(R.id.air_qlty);

        tv_aqi_name0 = (TextView) findViewById(R.id.tv_aqi_name0);
        tv_aqi_name1 = (TextView) findViewById(R.id.tv_aqi_name1);
        tv_aqi_name2 = (TextView) findViewById(R.id.tv_aqi_name2);
        tv_aqi_name3 = (TextView) findViewById(R.id.tv_aqi_name3);
        tv_aqi_name4 = (TextView) findViewById(R.id.tv_aqi_name4);
        tv_aqi_name5 = (TextView) findViewById(R.id.tv_aqi_name5);

        tv_aqi_desc0 = (TextView) findViewById(R.id.tv_aqi_desc0);
        tv_aqi_desc1 = (TextView) findViewById(R.id.tv_aqi_desc1);
        tv_aqi_desc2 = (TextView) findViewById(R.id.tv_aqi_desc2);
        tv_aqi_desc3 = (TextView) findViewById(R.id.tv_aqi_desc3);
        tv_aqi_desc4 = (TextView) findViewById(R.id.tv_aqi_desc4);
        tv_aqi_desc5 = (TextView) findViewById(R.id.tv_aqi_desc5);

        tv_aqi_value0 = (TextView) findViewById(R.id.tv_aqi_value0);
        tv_aqi_value1 = (TextView) findViewById(R.id.tv_aqi_value1);
        tv_aqi_value2 = (TextView) findViewById(R.id.tv_aqi_value2);
        tv_aqi_value3 = (TextView) findViewById(R.id.tv_aqi_value3);
        tv_aqi_value4 = (TextView) findViewById(R.id.tv_aqi_value4);
        tv_aqi_value5 = (TextView) findViewById(R.id.tv_aqi_value5);

        view_aqi_qlty0 = (View) findViewById(R.id.view_aqi_qlty0);
        view_aqi_qlty1 = (View) findViewById(R.id.view_aqi_qlty1);
        view_aqi_qlty2 = (View) findViewById(R.id.view_aqi_qlty2);
        view_aqi_qlty3 = (View) findViewById(R.id.view_aqi_qlty3);
        view_aqi_qlty4 = (View) findViewById(R.id.view_aqi_qlty4);
        view_aqi_qlty5 = (View) findViewById(R.id.view_aqi_qlty5);

        life_gridview = (GridView) findViewById(R.id.life_gridview);
    }

    /**
     * gridview自适应高度
     * @param listView
     */
    public static void setListViewHeightBasedOnChildren(GridView listView) {
        // 获取listview的adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        // 固定列宽，有多少列
        int col = 4;// listView.getNumColumns();
        int totalHeight = 0;
        // i每次加4，相当于listAdapter.getCount()小于等于4时 循环一次，计算一次item的高度，
        // listAdapter.getCount()小于等于8时计算两次高度相加
        for (int i = 0; i < listAdapter.getCount(); i += col) {
            // 获取listview的每一个item
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            // 获取item的高度和
            totalHeight += listItem.getMeasuredHeight();
        }

        // 获取listview的布局参数
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // 设置高度
        params.height = totalHeight;
        // 设置margin
        ((ViewGroup.MarginLayoutParams) params).setMargins(10, 10, 10, 10);
        // 设置参数
        listView.setLayoutParams(params);
    }


    @Override
    public void initListener() {
    }

    @Override
    protected void initData() {
        //得到本地json文本内容
//        String fileName = "weather_map.json";
//        String weatherJson = Util.getJson(fileName,this);
//
//        Type listType = new TypeToken<List<JsonDatas>>() {
//        }.getType();
//        //这里的json是字符串类型 = jsonArray.toString();
//        List<JsonDatas> list = new Gson().fromJson(weatherJson, listType );

//        //转换为对象
//        JsonDatas weatherData = Util.JsonToObject(weatherJson,JsonDatas.class);
        showNowWeather();



        hourList = weatherbean.getHourly();
        //计算viewpager一共显示几页
        int pageSize = hourList.size() % item_grid_num == 0
                ? hourList.size() / item_grid_num
                : hourList.size() / item_grid_num + 1;
        for (int i = 0; i < pageSize; i++) {
            GridView gridView = new GridView(this);
            WeatherViewAdapter adapter = new WeatherViewAdapter(WeatherActivity.this,hourList, i);
            gridView.setNumColumns(number_columns);
            gridView.setAdapter(adapter);
            gridList.add(gridView);
        }
        mAdapter.add(gridList);

        dailyList = weatherbean.getDaily_forecast();
        //计算viewpager一共显示几页
        int week_pageSize = dailyList.size() % item_grid_num == 0
                ? dailyList.size() / item_grid_num
                : dailyList.size() / item_grid_num + 1;
        for (int i = 0; i < week_pageSize; i++) {
            GridView gridView = new GridView(this);
            WeatherWeekViewAdapter adapter = new WeatherWeekViewAdapter(WeatherActivity.this,dailyList, i);
            gridView.setNumColumns(number_columns);
            gridView.setAdapter(adapter);
            gridList_week.add(gridView);
        }
        mAdapter_week.add(gridList_week);
    }


    private AirDatas.HeWeather6Bean.AirNowCityBean citybean = new AirDatas.HeWeather6Bean.AirNowCityBean();
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void showNowAir() {
        citybean = air_bean.getAir_now_city();
        String qlty=citybean.getQlty();
        if (qlty.equals("优")){
            air_qlty.setBackground(getResources().getDrawable(R.drawable.ari_qlty_bg_green));
        } else if (qlty.equals("良")){
            air_qlty.setBackground(getResources().getDrawable(R.drawable.ari_qlty_bg_yellow));
        } else {
            air_qlty.setBackground(getResources().getDrawable(R.drawable.ari_qlty_bg_red));
        }

        //pm2.5
        String p25_value = citybean.getPm25();
        tv_aqi_name0.setText("PM2.5");
        tv_aqi_desc0.setText("细颗粒物");
        tv_aqi_value0.setText(p25_value);
        setBackground(view_aqi_qlty0,Integer.valueOf(p25_value));
        //pm10
        String p10_value = citybean.getPm10();
        tv_aqi_name1.setText("PM10");
        tv_aqi_desc1.setText("可吸入颗粒物");
        tv_aqi_value1.setText(p10_value);
        setBackground(view_aqi_qlty1,Integer.valueOf(p10_value));
        //so2
        String so2 = citybean.getSo2();
        tv_aqi_name2.setText("SO2");
        tv_aqi_desc2.setText("二氧化硫");
        tv_aqi_value2.setText(so2);
        setBackground(view_aqi_qlty2,Integer.valueOf(so2));
        //no2
        String no2 = citybean.getNo2();
        tv_aqi_name3.setText("NO2");
        tv_aqi_desc3.setText("二氧化氮");
        tv_aqi_value3.setText(no2);
        setBackground(view_aqi_qlty3,Integer.valueOf(no2));
        //so2
        String co = citybean.getCo();
        tv_aqi_name4.setText("CO");
        tv_aqi_desc4.setText("一氧化碳");
        tv_aqi_value4.setText(so2);
        setBackground(view_aqi_qlty4,Integer.valueOf(co));
        //so2
        String o3 = citybean.getO3();
        tv_aqi_name5.setText("O3");
        tv_aqi_desc5.setText("臭氧");
        tv_aqi_value5.setText(o3);
        setBackground(view_aqi_qlty5,Integer.valueOf(o3));
    }

    private void setBackground(View view,int value){
        if (value <= 50) {
            view.setBackgroundColor(0xFF6BCD07);
        } else if (value <= 100) {
            view.setBackgroundColor(0xFFFBD029);
        } else if (value <= 150) {
            view.setBackgroundColor( 0xFFFE8800);
        } else if (value <= 200) {
            view.setBackgroundColor(0xFFFE0000);
        } else if (value <= 300) {
            view.setBackgroundColor(0xFF970454);
        } else {
            view.setBackgroundColor(0xFF62001E);
        }
    }

    private void showNowWeather() {
        tvCity.setText(city);
        layoutNow.setVisibility(View.VISIBLE);
        layoutDetails.setVisibility(View.VISIBLE);
        tvNowHum.setText(weatherbean.getNow().getHum() + "%");
        tvNowPres.setText(weatherbean.getNow().getPres());
        tvNowWindSc.setText(hasDigit(weatherbean.getNow().getWind_sc()) ? weatherbean.getNow().getWind_sc() + "级"
                : weatherbean.getNow().getWind_sc());
        tvNowWindDir.setText(weatherbean.getNow().getWind_dir());
        layoutNow.setAlpha(0);
        layoutDetails.setAlpha(0);
        layoutNow.animate().alpha(1).setDuration(1000);
        layoutDetails.setTranslationY(-100.0f);
        layoutDetails.animate().translationY(0).setDuration(1000);
        layoutDetails.animate().alpha(1).setDuration(1000);
//        hourlyAdapter.setNewData(weather.getFakeForecastHourly());
//        weatherChartView.setWeather(weather);
        tvNowWeatherString.setText(weatherbean.getNow().getCond_txt());
        tvNowTemp.setText(String.format("%s°", weatherbean.getNow().getTmp()));
        tvTodayTempMax.setText(weatherbean.getDaily_forecast().get(0).getTmp_max() + "℃");
        tvTodayTempMin.setText(weatherbean.getDaily_forecast().get(0).getTmp_min() + "℃");

        life_list = weatherbean.getLifestyle();
        lifeAdapter = new LifeAdapter(WeatherActivity.this,life_list);
//        setListViewHeightBasedOnChildren(life_gridview);
//        lifeAdapter.notifyDataSetChanged();
        life_gridview.setAdapter(lifeAdapter);
    }


    // 判断一个字符串是否含有数字
    private boolean hasDigit(String content) {
        boolean flag = false;
        Pattern p = Pattern.compile(".*\\d+.*");
        Matcher m = p.matcher(content);
        if (m.matches()) {
            flag = true;
        }
        return flag;
    }

    @Override
    protected void handler(Message msg) {

    }

}
