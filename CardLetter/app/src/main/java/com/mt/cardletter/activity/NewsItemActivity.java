package com.mt.cardletter.activity;

import android.os.Message;
import android.text.Html;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.entity.news.NetNews;

public class NewsItemActivity extends BaseActivity {
    private TextView new_title,new_src,new_time;
    private ImageView new_img;
    private NetNews.ResultBeanX.ResultBean.ListBean bean;
    private TextView title_name ,new_text;
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
        new_text = (TextView) findViewById(R.id.new_text);
        new_img = (ImageView) findViewById(R.id.new_img);
    }
    @Override
    protected void initData() {
        if (bean.getSrc().equals("")){
            title_name.setText("新闻"+bean.getSrc());
        }else {
            title_name.setText("新闻-"+bean.getSrc());
        }
        new_title.setText(bean.getTitle());
        new_src.setText(bean.getSrc());
        new_time.setText(bean.getTime());

        if (bean.getPic() != null&&!bean.getPic().equals("")){
            Glide.with(this).load(bean.getPic()).error(R.drawable.default_error).into(new_img);
        }else{
            new_img.setVisibility(View.GONE);
        }

        CharSequence charSequence;
        String content = bean.getContent();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            charSequence = Html.fromHtml(content,Html.FROM_HTML_MODE_LEGACY);
        } else {
            charSequence = Html.fromHtml(content);
        }
        new_text.setText(charSequence);
    }
    @Override
    public void initListener() {

    }


    @Override
    protected void handler(Message msg) {

    }
}
