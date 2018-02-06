package com.mt.cardletter.activity;

import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.adapter.BillExpandAdapter;
import com.mt.cardletter.entity.bank.Bill;

import java.util.ArrayList;
import java.util.List;

/**
 * Date:2018/2/5
 * Time:16:28
 * author:demons
 */

public class BillDetailActivity extends BaseActivity {

    private TextView title;
    private FrameLayout back;

    private TextView bill_card;//卡号
    private TextView bill_name;//持卡人
    private ImageView bill_edit;//修改框
    private TextView bill_current_pay;//本期还款
    private TextView bill_low_pay;//最低还款
    private TextView bill_repayment_time;//还款日期
    private TextView bill_expenditure_time;//出账日期
    private TextView bill_quota_time;//总额度
    private TextView bill_integral_time;//积分

    private ListView bill_list;
    private BillExpandAdapter adapter;

    private List<Bill.TotalBean> list = new ArrayList<>();

    @Override
    protected int getLayoutResId() {
        return R.layout.bill_record_layout;
    }

    @Override
    public void initView() {
        title = (TextView) findViewById(R.id.title_name);
        back = (FrameLayout) findViewById(R.id.com_back_click);
        back.setVisibility(View.VISIBLE);

        bill_card = (TextView) findViewById(R.id.bill_card);
        bill_name = (TextView) findViewById(R.id.bill_name);
        bill_edit = (ImageView) findViewById(R.id.bill_edit);
        bill_current_pay = (TextView) findViewById(R.id.bill_current_pay);
        bill_low_pay = (TextView) findViewById(R.id.bill_low_pay);
        bill_repayment_time = (TextView) findViewById(R.id.bill_repayment_time);
        bill_expenditure_time = (TextView) findViewById(R.id.bill_expenditure_time);
        bill_quota_time = (TextView) findViewById(R.id.bill_quota_time);
        bill_integral_time = (TextView) findViewById(R.id.bill_integral_time);

        bill_list = (ListView) findViewById(R.id.bill_list);
    }

    @Override
    public void initListener() {

    }

    @Override
    protected void initData() {
        list= (List<Bill.TotalBean>) getIntent().getSerializableExtra("list");
        String title_name = list.get(0).getBank();
        title.setText(title_name);
        String name = list.get(0).getName();
        bill_name.setText(name);
        String cardNum;
        if (list.get(0).getTrade().size()>0){
            cardNum = list.get(0).getTrade().get(0).getCard_Number_last();
        }else {
            cardNum = "****";
        }
        bill_card.setText("- - - -  - - - -  - - - -  "+cardNum);

        String bill_repayment_time_tv = list.get(0).getRepayment().getPayment_date();
        bill_repayment_time.setText(bill_repayment_time_tv);
        String bill_expenditure_time_tv = list.get(0).getRepayment().getStatement_date();
        bill_expenditure_time.setText(bill_expenditure_time_tv);
        String bill_quota_time_tv = list.get(0).getRepayment().getCredit_Limit();
        bill_quota_time.setText(bill_quota_time_tv);
        String bill_integral_time_tv = list.get(0).getIntegral().getOpening_Balance();
        bill_integral_time.setText(bill_integral_time_tv);

        String bill_current_pay_tv = list.get(0).getBill().getTotal_Due_Amount();
        bill_current_pay.setText(bill_current_pay_tv);
        String bill_low_pay_tv = list.get(0).getBill().getMinimum_Payment();
        bill_low_pay.setText(bill_low_pay_tv);

        adapter = new BillExpandAdapter(BillDetailActivity.this,list);
        bill_list.setAdapter(adapter);
    }

    @Override
    protected void handler(Message msg) {

    }
}
