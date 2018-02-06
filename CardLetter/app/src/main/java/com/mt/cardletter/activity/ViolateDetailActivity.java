package com.mt.cardletter.activity;

import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.adapter.ViolateAdapter;
import com.mt.cardletter.entity.data.ViolateData;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Date:2017/12/26
 * Time:16:55
 * author:demons
 */

public class ViolateDetailActivity extends BaseActivity {
    @Bind({R.id.violate_listview})
    ListView violate_listview;
    @Bind({R.id.title_name})
    TextView title_name;
    @Bind({R.id.com_back_click})
    FrameLayout back;
    private List<ViolateData.ResultBean.ListsBean> violate_list = new ArrayList<>();
    private ViolateAdapter adapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.violate_list_layout;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_name.setText("违章详情");
        back.setVisibility(View.VISIBLE);
    }

    @Override
    public void initListener() {

    }

    @Override
    protected void initData() {
        violate_list= (List<ViolateData.ResultBean.ListsBean>) getIntent().getSerializableExtra("list");
        adapter =  new ViolateAdapter(this,violate_list);
        violate_listview.setAdapter(adapter);
    }

    @Override
    protected void handler(Message msg) {

    }
}
