package com.mt.cardletter.fragment;


import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.adapter.CardAdapter;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.UIHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gaolei on 2017/11/13.
 */

public class CardManagerFragment extends BaseFragment {
    private TextView title_name;
    private TextView commonal_tv;
    private RecyclerView card_listview;
    private CardAdapter adapter ;
    private List<HashMap<String, String>> mList = new ArrayList<HashMap<String, String>>();

    @Override
    protected int setLayoutResouceId() {
        getPicUrls();
        return R.layout.fragment_cm;
    }

    private void getPicUrls() {
        List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("A", "http://img3.hao123.com/data/1_8583424a3f55c06ebeafce438a637c0d_0");
        map1.put("name","工行 9066 0336");
        map1.put("value","20006");
        map1.put("day","逾期10天");
        list.add(map1);

        HashMap<String, String> map2 = new HashMap<String, String>();
        map2.put("A", "http://img0.hao123.com/data/1_981ee6e65d3f13ec691804ab82f2a0ab_510");
        map2.put("name","农行 95559 0336");
        map2.put("value","20123");
        map2.put("day","逾期1天");
        list.add(map2);

        HashMap<String, String> map3 = new HashMap<String, String>();
        map3.put("A", "http://img3.hao123.com/data/desktop/4926b79748d1c9d4db328e1a8b7a7794_1280_800");
        map3.put("name","中行 90009 0216");
        map3.put("value","26");
        map3.put("day","逾期11天");
        list.add(map3);

        HashMap<String, String> map4 = new HashMap<String, String>();
        map4.put("A", "http://img5.hao123.com/data/1_7793be4df6fd23d63ca321b205ba083b_510");
        map4.put("name","招行 955586 0336");
        map4.put("value","106");
        map4.put("day","逾期2天");
        list.add(map4);

        HashMap<String, String> map5 = new HashMap<String, String>();
        map5.put("A", "http://img3.hao123.com/data/1_c46275cc6b24a480ecec31b3b5ec3c39_510");
        map5.put("name","交通银行 9222 022006");
        map5.put("value","306");
        map5.put("day","逾期3天");
        list.add(map5);
        mList = list;
    }

    @Override
    protected void initView() {
        title_name = findViewById(R.id.title_name);
        commonal_tv = findViewById(R.id.commonal_tv);
        commonal_tv.setVisibility(View.VISIBLE);
        card_listview = findViewById(R.id.card_listview);
        // 设置LinearLayoutManager
        card_listview.setLayoutManager(new LinearLayoutManager(getContext()));
        // 设置ItemAnimator
        card_listview.setItemAnimator(new DefaultItemAnimator());
        // 设置固定大小
        card_listview.setHasFixedSize(true);
        super.initView();
    }

    @Override
    public void initData() {
        title_name.setText("卡管家");
        commonal_tv.setText("添加");
        commonal_tv.setTextColor(getResources().getColor(R.color.white));
        commonal_tv.setVisibility(View.VISIBLE);
        // 初始化自定义的适配器
        adapter = new CardAdapter(getContext(), mList);
        // 为mRecyclerView设置适配器
        card_listview.setAdapter(adapter);

        commonal_tv.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                UIHelper.showQQH5(getContext());
            }
        });
    }

    private void getData() {
    }

}
