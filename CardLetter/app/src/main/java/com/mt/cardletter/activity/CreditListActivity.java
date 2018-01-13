package com.mt.cardletter.activity;

import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.adapter.CreditListAdapter;
import com.mt.cardletter.entity.bank.BankEntity;
import com.mt.cardletter.entity.creditcard.CreditDatas;

import java.util.ArrayList;
import java.util.List;

/**
 * Date:2018/1/13
 * Time:15:05
 * author:demons
 */

public class CreditListActivity extends BaseActivity {

    private TextView title_name;
    private FrameLayout back;
    private ListView credit_listview;

    private String sid;
    private List<CreditDatas.MlsBean> all_credit_list = new ArrayList<>();//所有信息卡列表数据
    private BankEntity be;
    private List<BankEntity> be_list=new ArrayList<>();

    CreditListAdapter adapter ;

    @Override
    protected int getLayoutResId() {
        getDatas();
        return R.layout.activity_creditlist;
    }

    private void getDatas() {
        sid = getIntent().getStringExtra("sid");
        all_credit_list = (List<CreditDatas.MlsBean>) getIntent().getSerializableExtra("data");
    }

    @Override
    public void initView() {
        title_name = (TextView) findViewById(R.id.title_name);
        title_name.setText("信用卡列表");
        back = (FrameLayout) findViewById(R.id.com_back_click);
        back.setVisibility(View.VISIBLE);
        credit_listview = (ListView) findViewById(R.id.credit_listview);
    }

    @Override
    public void initListener() {

    }

    @Override
    protected void initData() {
        for (int i=0;i<all_credit_list.size();i++){
            String which_bank = all_credit_list.get(i).getInf().getFrom().getName();
            if (which_bank.equals("上海银行")){
                BankEntity sh= new BankEntity();
                sh.setName(which_bank);
                sh.setId(all_credit_list.get(i).getInf().getId());
                sh.setPic(getResources().getDrawable(R.drawable.sh_bank));
                be_list.add(sh);
            }else if (which_bank.equals("平安信用卡")){
                BankEntity pa= new BankEntity();
                pa.setName(which_bank);
                pa.setId(all_credit_list.get(i).getInf().getId());
                pa.setPic(getResources().getDrawable(R.drawable.pa_bank));
                be_list.add(pa);
            }
            else if (which_bank.equals("中国光大银行")){
                BankEntity gd= new BankEntity();
                gd.setName(which_bank);
                gd.setId(all_credit_list.get(i).getInf().getId());
                gd.setPic(getResources().getDrawable(R.drawable.gd_bank));
                be_list.add(gd);
            }
            else if (which_bank.equals("交通银行太平洋信用卡中心")){
                BankEntity jt= new BankEntity();
                jt.setName(which_bank);
                jt.setId(all_credit_list.get(i).getInf().getId());
                jt.setPic(getResources().getDrawable(R.drawable.jt_bank));
                be_list.add(jt);
            }
            else if (which_bank.equals("招商银行信用卡")){
                BankEntity zs= new BankEntity();
                zs.setName(which_bank);
                zs.setId(all_credit_list.get(i).getInf().getId());
                zs.setPic(getResources().getDrawable(R.drawable.zs_bank));
                be_list.add(zs);
            }
            else{
            }
        }
        System.out.println("------aaaaa-----------"+be_list.size());
        adapter = new CreditListAdapter(CreditListActivity.this,be_list);
        credit_listview.setAdapter(adapter);
    }

    @Override
    protected void handler(Message msg) {

    }
}
