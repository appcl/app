package com.mt.cardletter.activity;

import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.adapter.ExpressAdapter;
import com.mt.cardletter.entity.express.Express_Content;
import com.mt.cardletter.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Date:2018/1/3
 * Time:10:23
 * author:demons
 */

public class ExpressDetailActivity extends BaseActivity {
    @Bind({R.id.title_name})
    TextView name;
    @Bind({R.id.com_back_click})
    FrameLayout back;
    @Bind({R.id.ex_recyler})
    RecyclerView ex_recyler;
    @Bind({R.id.ex_status})
    TextView ex_status;
    @Bind({R.id.ex_company})
    TextView ex_company;
    @Bind({R.id.ex_order})
    TextView ex_order;


    private ExpressAdapter adapter;

    private Express_Content.ResultBean resultBean = new Express_Content.ResultBean();
    private List<Express_Content.ResultBean.ListBean> list =new ArrayList<>();

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_expressdetail;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        name.setText("物流详情");
        back.setVisibility(View.VISIBLE);
    }

    @Override
    public void initListener() {

    }

    @Override
    protected void initData() {
        resultBean = (Express_Content.ResultBean) getIntent().getSerializableExtra("resultBean");
        if (resultBean!=null){
            String status = resultBean.getStatus().toString();
            if (status.equals("1")){
                ex_status.setText("物流状态：已签收");
            }else {
                ex_status.setText("物流状态：派送中");
            }
            ex_company.setText("物流公司："+resultBean.getCompany().toString());
            ex_order.setText("运单编号："+resultBean.getNo().toString());
            list=resultBean.getList();
            if (list != null && list.size() > 0) {
//                使用线性布局
                LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                ex_recyler.setLayoutManager(layoutManager);
                ex_recyler.setHasFixedSize(true);

//                用自定义分割线类设置分割线
                ex_recyler.addItemDecoration(new DividerItemDecoration(ExpressDetailActivity.this));
                adapter = new ExpressAdapter(ExpressDetailActivity.this,list);
                ex_recyler.setAdapter(adapter);
            }
        }
    }

    @Override
    protected void handler(Message msg) {

    }
}
