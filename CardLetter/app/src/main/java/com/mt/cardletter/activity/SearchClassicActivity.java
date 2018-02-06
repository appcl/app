package com.mt.cardletter.activity;

import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.adapter.ContentAdapter;
import com.mt.cardletter.entity.integral.IntegralEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Date:2017/12/13
 * Time:14:29
 * author:demons
 */

public class SearchClassicActivity extends BaseActivity {

    private TextView title_name;
    private FrameLayout back;
    private ListView content_list;
    private List<IntegralEntity> list =new ArrayList<>();
    private List<IntegralEntity.IntegralBean> beanList = new ArrayList<>();
    private IntegralEntity.IntegralBean bean ;
    private IntegralEntity entity;
    private ContentAdapter adapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_integral;
    }

    @Override
    public void initView() {
        title_name = (TextView) findViewById(R.id.title_name);
        title_name.setText("积分商城");
        back = (FrameLayout) findViewById(R.id.com_back_click);
        back.setVisibility(View.VISIBLE);

        content_list = (ListView) findViewById(R.id.content_list);
        getData();
    }

    private void getData() {
        entity = new IntegralEntity();
        bean =new IntegralEntity.IntegralBean();
        bean.setDes_integral("5000分以下");
        beanList.add(bean);

        bean =new IntegralEntity.IntegralBean();
        bean.setDes_integral("5000-8000分");
        beanList.add(bean);

        bean =new IntegralEntity.IntegralBean();
        bean.setDes_integral("8000分以上");
        beanList.add(bean);

        bean =new IntegralEntity.IntegralBean();
        bean.setDes_integral("领券中心");
        beanList.add(bean);

        bean =new IntegralEntity.IntegralBean();
        bean.setDes_integral("爱车一族");
        beanList.add(bean);

        bean =new IntegralEntity.IntegralBean();
        bean.setDes_integral("高端享受");
        beanList.add(bean);

        entity.setBean(beanList);

        list.add(entity);
        setupRecycler();
    }

    protected void setupRecycler(){
        adapter = new ContentAdapter(this,list);
        content_list.setAdapter(adapter);
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
