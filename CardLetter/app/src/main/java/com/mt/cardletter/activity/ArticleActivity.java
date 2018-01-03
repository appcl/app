package com.mt.cardletter.activity;

import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.article.ArticleBean;

/**
 * Date:2018/1/2
 * Time:19:16
 * author:demons
 */

public class ArticleActivity extends BaseActivity {

    private TextView title_name;
    private FrameLayout back;
    private TextView a_title;
    private TextView a_content;
    private TextView a_time;

    private ArticleBean.DataBeanX.DataBean bean ;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_article_layout;
    }

    @Override
    public void initView() {
        title_name = (TextView) findViewById(R.id.title_name);
        a_title = (TextView) findViewById(R.id.a_title);
        a_content = (TextView) findViewById(R.id.a_content);
        a_time = (TextView) findViewById(R.id.a_time);
        back = (FrameLayout) findViewById(R.id.com_back_click);

        title_name.setVisibility(View.INVISIBLE);
        back.setVisibility(View.VISIBLE);

    }

    @Override
    public void initListener() {

    }

    @Override
    protected void initData() {
        bean = new ArticleBean.DataBeanX.DataBean();
        bean= (ArticleBean.DataBeanX.DataBean) getIntent().getSerializableExtra("bean");
        if (bean!=null){
            a_title.setText(bean.getName().toString());
            a_content.setText(bean.getDescribe().toString());
            a_time.setText(bean.getCreate_time().toString());
        }
    }

    @Override
    protected void handler(Message msg) {

    }
}
