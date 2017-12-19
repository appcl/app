package com.mt.cardletter.activity;

import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.app.AppContext;
import com.mt.cardletter.entity.data.HeWeather;
import com.mt.cardletter.https.HttpRequestApi;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Date:2017/12/13
 * Time:10:24
 * author:demons
 */

public class MakeIntegralActivity extends BaseActivity {

    @Bind({R.id.title_name})
    TextView title_name;
    @Bind({R.id.com_back_click})
    FrameLayout com_back_click;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_make_integral;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_name.setText("赚积分攻略");
        com_back_click.setVisibility(View.VISIBLE);
        getDatas(AppContext.getInstance().getDistrict(),"5ee8321670ca46aab8e7555d3b3c074b");
    }

    private HeWeather.HeWeather6Bean weather6Bean;

    private void getDatas(String city,String key) {
        weather6Bean=new HeWeather.HeWeather6Bean();
        HttpRequestApi.getInstance().getWeather(city,key,new HttpSubscriber<HeWeather>(new SubscriberOnListener<HeWeather>() {
            @Override
            public void onSucceed(HeWeather data) {
                String statue=data.getHeWeather6().get(0).getStatus();
                weather6Bean= data.getHeWeather6().get(0);
                if (statue.equals("ok")){
                    UIHelper.showWeather(MakeIntegralActivity.this,weather6Bean);
                }else {
                    weather6Bean=new HeWeather.HeWeather6Bean();
                    ToastUtils.makeShortText("小信加载数据出错啦，请稍后再试",MakeIntegralActivity.this);
                }
            }

            @Override
            public void onError(int code, String msg) {
            }
        },MakeIntegralActivity.this));
    }

    @Override
    public void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void handler(Message msg) {

    }
}
