package com.mt.cardletter.fragment;


import android.widget.ListView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.adapter.ContentAdapter;
import com.mt.cardletter.entity.integral.IntegralEntity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by gaolei on 2017/11/13.
 */

public class IntegralFragment extends BaseFragment {
    private TextView title_name;
    private ListView content_list;
    private List<IntegralEntity> list =new ArrayList<>();
    private List<IntegralEntity.IntegralBean> beanList = new ArrayList<>();
    private IntegralEntity.IntegralBean bean ;
    private IntegralEntity entity;
    private ContentAdapter adapter;

    @Override
    protected int setLayoutResouceId() {
        getData();
        return R.layout.fragment_integral;
    }

    @Override
    public void initData() {
        title_name = findViewById(R.id.title_name);
        title_name.setText("积分商城");

        content_list = findViewById(R.id.content_list);

        setupRecycler();
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
    }

    protected void setupRecycler(){
        adapter = new ContentAdapter(getContext(),list);
        content_list.setAdapter(adapter);
    }

}
