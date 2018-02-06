package com.mt.cardletter.activity;

import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.entity.article.ArticleBean;
import com.mt.cardletter.utils.Constant;

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
    private ImageView a_img;

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
        a_img = (ImageView) findViewById(R.id.a_image);
        back = (FrameLayout) findViewById(R.id.com_back_click);

        title_name.setText("头条");
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
            String img_url = bean.getThumb();
//            String credentials="51kalaxin:62kaxin";
//            final String basic =
//                    "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
//            //Authorization 请求头信息
//            LazyHeaders headers=  new LazyHeaders.Builder().addHeader("Authorization", basic).build();
            System.out.println("-------------"+Constant.PIC_URL+img_url);
            Glide.with(this)
//                    .load(new GlideUrl(Constant.PIC_URL+img_url, headers))
                    .load(Constant.PIC_URL+img_url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(a_img);;
        }
    }

    @Override
    protected void handler(Message msg) {

    }
}
