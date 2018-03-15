package com.mt.cardletter.activity;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.adapter.BillListAdapter;
import com.mt.cardletter.entity.bank.Bill;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.test.BillRequestApi;
import com.mt.cardletter.utils.ToastUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Date:2018/2/5
 * Time:14:08
 * author:demons
 */

public class BillActivity extends BaseActivity {

    private String sid;
    private String cookieStr;

    private ListView bank_list;
    private TextView title;
    private FrameLayout back;

    private List<List<Bill.TotalBean>> list = new ArrayList<>();
    private BillListAdapter adapter;


    @Override
    protected int getLayoutResId() {
        getDatas();
        return R.layout.bank_bill_layout;
    }

    private void getDatas() {
        sid=getIntent().getStringExtra("sid");
        cookieStr=getIntent().getStringExtra("cookieStr");
        System.out.println("sid===="+sid+"\n"+"cookieStr======="+cookieStr);
    }

    @Override
    public void initView() {
        title = (TextView) findViewById(R.id.title_name);
        title.setText("账单列表");

        back = (FrameLayout) findViewById(R.id.com_back_click);
        back.setVisibility(View.VISIBLE);

        bank_list = (ListView) findViewById(R.id.bank_list);

        bank_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BillActivity.this,BillDetailActivity.class);
                intent.putExtra("list", (Serializable) list.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public void initListener() {

    }

    @Override
    protected void initData() {
        BillRequestApi.getInstance().getBill(cookieStr,sid,new HttpSubscriber<Bill>(new SubscriberOnListener<Bill>() {
            @Override
            public void onSucceed(Bill data) {
                int count = data.getTotal().size();
                if (count>0){
                list = data.getTotal();
                adapter = new BillListAdapter(BillActivity.this,list);
                bank_list.setAdapter(adapter);
                }else {
                    ToastUtils.makeShortText("未获取到信用卡账单信息",BillActivity.this);
                    finish();
                }
            }

            @Override
            public void onError(int code, String msg) {
//                ToastUtils.makeShortText("获取信用卡账单请求超时了，请重新获取",BillActivity.this);
                finish();
            }
        },BillActivity.this));
    }

    @Override
    protected void handler(Message msg) {

    }
}
