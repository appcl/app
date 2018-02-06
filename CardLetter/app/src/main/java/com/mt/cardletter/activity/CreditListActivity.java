package com.mt.cardletter.activity;

import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.adapter.CreditListAdapter;
import com.mt.cardletter.entity.bank.BankEntity;
import com.mt.cardletter.entity.creditcard.CreditDatas;
import com.mt.cardletter.utils.UIHelper;

import java.util.ArrayList;
import java.util.List;

import static com.mt.cardletter.entity.bank.BankEntity.BankBean;

/**
 * Date:2018/1/13
 * Time:15:05
 * author:demons
 */

public class CreditListActivity extends BaseActivity {

    private TextView title_name;
    private FrameLayout back;
    private ListView credit_listview;
    private ImageView item_sh,item_gd,item_jt,item_pa,item_zs;

    private String sid;
    private List<CreditDatas.MlsBean> all_credit_list = new ArrayList<>();//所有信息卡列表数据
    private BankBean bankBean;
    private List<BankEntity.BankBean> bank_lst ;
    private List<BankEntity.BankBean.ShListBean> sh_list= new ArrayList<>();
    private List<BankEntity.BankBean.PaListBean> pa_list= new ArrayList<>();
    private List<BankEntity.BankBean.GdListBean> gd_list= new ArrayList<>();
    private List<BankEntity.BankBean.ZsListBean> zs_list= new ArrayList<>();
    private List<BankEntity.BankBean.JtListBean> jt_list= new ArrayList<>();


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
//        credit_listview = (ListView) findViewById(R.id.credit_listview);

        item_sh = (ImageView) findViewById(R.id.item_sh);
        item_jt = (ImageView) findViewById(R.id.item_jt);
        item_gd = (ImageView) findViewById(R.id.item_gd);
        item_zs = (ImageView) findViewById(R.id.item_zs);
        item_pa = (ImageView) findViewById(R.id.item_pa);


    }

    @Override
    public void initListener() {
        item_sh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.showSHActivity(CreditListActivity.this,sid,sh_list,"sh");
            }
        });

        item_jt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.showJTActivity(CreditListActivity.this,sid,jt_list,"jt");
            }
        });

        item_gd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.showGDActivity(CreditListActivity.this,sid,gd_list,"gd");
            }
        });

        item_zs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.showZSActivity(CreditListActivity.this,sid,zs_list,"zs");
            }
        });

        item_pa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.showPAActivity(CreditListActivity.this,sid,pa_list,"pa");
            }
        });
    }

    @Override
    protected void initData() {
        for (int i=0;i<all_credit_list.size();i++){
            bankBean = new BankBean();
            bank_lst = new ArrayList<>();
            String which_bank = all_credit_list.get(i).getInf().getFrom().getName();
            if (which_bank.equals("上海银行")){
                BankBean.ShListBean sh= new BankBean.ShListBean();
                sh.setName(which_bank);
                sh.setId(all_credit_list.get(i).getInf().getId());
                sh.setSubj(all_credit_list.get(i).getInf().getSubj());
                sh.setAbs(all_credit_list.get(i).getInf().getAbs());
                String date = String.valueOf(all_credit_list.get(i).getInf().getDate());
                sh.setDate(toTime(date,"yyyy-MM-dd"));
                sh_list.add(sh);
                item_sh.setImageDrawable(getResources().getDrawable(R.drawable.sh_bank));
            }else if (which_bank.equals("平安信用卡")){
                BankBean.PaListBean pa= new BankBean.PaListBean();
                pa.setName(which_bank);
                pa.setId(all_credit_list.get(i).getInf().getId());
                pa.setSubj(all_credit_list.get(i).getInf().getSubj());
                pa.setAbs(all_credit_list.get(i).getInf().getAbs());
                String date = String.valueOf(all_credit_list.get(i).getInf().getDate());
                pa.setDate(toTime(date,"yyyy-MM-dd"));
                pa_list.add(pa);
                item_pa.setImageDrawable(getResources().getDrawable(R.drawable.pa_bank));
            }
            else if (which_bank.equals("中国光大银行")){
                BankBean.GdListBean gd= new BankBean.GdListBean();
                gd.setName(which_bank);
                gd.setId(all_credit_list.get(i).getInf().getId());
                gd.setSubj(all_credit_list.get(i).getInf().getSubj());
                gd.setAbs(all_credit_list.get(i).getInf().getAbs());
                String date = String.valueOf(all_credit_list.get(i).getInf().getDate());
                gd.setDate(toTime(date,"yyyy-MM-dd"));
                gd_list.add(gd);
                item_gd.setImageDrawable(getResources().getDrawable(R.drawable.gd_bank));
            }
            else if (which_bank.equals("交通银行太平洋信用卡中心")){
                BankBean.JtListBean jt= new BankBean.JtListBean();
                jt.setName(which_bank);
                jt.setId(all_credit_list.get(i).getInf().getId());
                jt.setSubj(all_credit_list.get(i).getInf().getSubj());
                jt.setAbs(all_credit_list.get(i).getInf().getAbs());
                String date = String.valueOf(all_credit_list.get(i).getInf().getDate());
                jt.setDate(toTime(date,"yyyy-MM-dd"));
                jt_list.add(jt);
                item_jt.setImageDrawable(getResources().getDrawable(R.drawable.jt_bank));
            }
            else if (which_bank.equals("招商银行信用卡")){
                BankBean.ZsListBean zs= new BankBean.ZsListBean();
                zs.setName(which_bank);
                zs.setId(all_credit_list.get(i).getInf().getId());
                zs.setSubj(all_credit_list.get(i).getInf().getSubj());
                zs.setAbs(all_credit_list.get(i).getInf().getAbs());
                String date = String.valueOf(all_credit_list.get(i).getInf().getDate());
                zs.setDate(toTime(date,"yyyy-MM-dd"));
                zs_list.add(zs);
                item_zs.setImageDrawable(getResources().getDrawable(R.drawable.zs_bank));
            }
            else{
            }
        }
        System.out.println("------上海银行-----------"+sh_list.size());
        System.out.println("------平安信用卡-----------"+pa_list.size());
        System.out.println("------中国光大银行-----------"+gd_list.size());
        System.out.println("------交通银行太平洋信用卡中心-----------"+jt_list.size());
        System.out.println("------招商银行信用卡-----------"+zs_list.size());
//        adapter = new CreditListAdapter(CreditListActivity.this,bank_lst);
//        credit_listview.setAdapter(adapter);
    }

    @Override
    protected void handler(Message msg) {

    }

    public static String toTime(String timestampString, String formats) {
        Long timestamp = Long.parseLong(timestampString)*1000;
        String date = new java.text.SimpleDateFormat(formats).format(new java.util.Date(timestamp));
        return date;
    }
}
