package com.mt.cardletter.activity;

import android.media.Image;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mt.cardletter.R;
import com.mt.cardletter.entity.news.NetNews;
import com.mt.cardletter.view.Scroll.TopScrollView;

import java.util.List;

public class NewsItemActivity extends BaseActivity {
    private TextView new_title,new_src,new_time;
    private ImageView new_img;
    private NetNews.ResultBeanX.ResultBean.ListBean bean;
    private TextView title_name;
    private ScrollView new_scroll;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_news_item;
    }

    @Override
    public void initView() {
        title_name = (TextView) findViewById(R.id.title_name);
        new_scroll = (ScrollView) findViewById(R.id.new_scroll);
        FrameLayout back = (FrameLayout) findViewById(R.id.com_back_click);
        back.setVisibility(View.VISIBLE);
        bean = (NetNews.ResultBeanX.ResultBean.ListBean) getIntent().getSerializableExtra("new");
        new_title = (TextView) findViewById(R.id.new_title);
        new_src = (TextView) findViewById(R.id.new_src);
        new_time = (TextView) findViewById(R.id.new_time);
        new_img = (ImageView) findViewById(R.id.new_img);
    }
    @Override
    protected void initData() {
        title_name.setText("新闻-"+bean.getSrc());
        new_title.setText(bean.getTitle());
        new_src.setText(bean.getSrc());
        new_time.setText(bean.getTime());
        if (bean.getPic() != null&&!bean.getPic().equals("")){
            Glide.with(this).load(bean.getPic()).error(R.drawable.default_error).into(new_img);
        }else{
            new_img.setVisibility(View.GONE);
        }
    }
    @Override
    public void initListener() {

    }


    @Override
    protected void handler(Message msg) {

    }
}
