package com.mt.cardletter.activity.bank;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.adapter.GDAdapter;
import com.mt.cardletter.adapter.JTAdapter;
import com.mt.cardletter.adapter.PAAdapter;
import com.mt.cardletter.adapter.SHAdapter;
import com.mt.cardletter.adapter.ZSAdapter;
import com.mt.cardletter.entity.bank.BankEntity;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.test.QQRequestApi;

import java.util.ArrayList;
import java.util.List;

/**
 * Date:2018/1/14
 * Time:10:57
 * author:demons
 */

public class SHActivity extends BaseActivity {

    private List<BankEntity.BankBean.ShListBean> sh_list=new ArrayList<>();
    private List<BankEntity.BankBean.GdListBean> gd_list = new ArrayList<>();
    private List<BankEntity.BankBean.JtListBean> jt_list = new ArrayList<>();
    private List<BankEntity.BankBean.ZsListBean> zs_list = new ArrayList<>();
    private List<BankEntity.BankBean.PaListBean> pa_list = new ArrayList<>();
    private TextView title_name;
    private FrameLayout back;
    private ListView listview;

    private SHAdapter shAdapter;
    private GDAdapter gdAdapter;
    private ZSAdapter zsAdapter;
    private JTAdapter jtAdapter;
    private PAAdapter paAdapter;

    private String sid;
    private String which_from;
    private String bank_name;

    @Override
    protected int getLayoutResId() {
        getDatas();
        return R.layout.activity_sh;
    }

    private void getDatas() {
        Bundle bundle = getIntent().getExtras();
        sid = bundle.getString("sid");
        which_from = bundle.getString("which_bank");
        System.out.println("-----which_from-----"+which_from);
        if(which_from.equals("sh")){
            sh_list = (List<BankEntity.BankBean.ShListBean>) getIntent().getSerializableExtra("sh_list");
            bank_name = sh_list.get(0).getName();
        }else if (which_from.equals("gd")){
            gd_list = (List<BankEntity.BankBean.GdListBean>) getIntent().getSerializableExtra("gd_list");
            bank_name = gd_list.get(0).getName();
        }else if (which_from.equals("jt")){
            jt_list = (List<BankEntity.BankBean.JtListBean>) getIntent().getSerializableExtra("jt_list");
            bank_name = jt_list.get(0).getName();
        }else if (which_from.equals("zs")){
            zs_list = (List<BankEntity.BankBean.ZsListBean>) getIntent().getSerializableExtra("zs_list");
            bank_name = zs_list.get(0).getName();
        }else if (which_from.equals("pa")){
            pa_list = (List<BankEntity.BankBean.PaListBean>) getIntent().getSerializableExtra("pa_list");
            bank_name = pa_list.get(0).getName();
        }
    }

    @Override
    public void initView() {
        title_name = (TextView) findViewById(R.id.title_name);
        title_name.setText(bank_name);
        back = (FrameLayout) findViewById(R.id.com_back_click);
        back.setVisibility(View.VISIBLE);
        listview = (ListView) findViewById(R.id.sh_listview);
    }

    @Override
    public void initListener() {
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (which_from.equals("sh")){
                    String item_id = sh_list.get(position).getId();
                    Intent i = new Intent(SHActivity.this,SHWebActiviy.class);
                    Bundle b =  new Bundle();
                    b.putString("item_id",item_id);
                    b.putString("sid",sid);
                    i.putExtras(b);
                    startActivity(i);
                }else if (which_from.equals("jt")){
                    String jt_item_id = jt_list.get(position).getId();
                    Intent i = new Intent(SHActivity.this,JTWebActiviy.class);
                    Bundle b =  new Bundle();
                    b.putString("jt_item_id",jt_item_id);
                    b.putString("sid",sid);
                    i.putExtras(b);
                    startActivity(i);
                }else if (which_from.equals("zs")){
                    String zs_item_id = zs_list.get(position).getId();
                    Intent i = new Intent(SHActivity.this,SHWebActiviy.class);
                    Bundle b =  new Bundle();
                    b.putString("zs_item_id",zs_item_id);
                    b.putString("sid",sid);
                    i.putExtras(b);
                    startActivity(i);
                }else if (which_from.equals("gd")){
                    String gd_item_id = gd_list.get(position).getId();
                    Intent i = new Intent(SHActivity.this,SHWebActiviy.class);
                    Bundle b =  new Bundle();
                    b.putString("gd_item_id",gd_item_id);
                    b.putString("sid",sid);
                    i.putExtras(b);
                    startActivity(i);
                }else if (which_from.equals("pa")){
                    String pa_item_id = pa_list.get(position).getId();
                    Intent i = new Intent(SHActivity.this,SHWebActiviy.class);
                    Bundle b =  new Bundle();
                    b.putString("pa_item_id",pa_item_id);
                    b.putString("sid",sid);
                    i.putExtras(b);
                    startActivity(i);
                }
//                getItemDatas(sid,item_id);
            }
        });
    }

    private void getItemDatas(String sid,String item_id) {
        String url = "phone#mail,search_%E4%BF%A1%E7%94%A8%E5%8D%A1%E7%94%B5%E5%AD%90_all%5F%5F,"+item_id;
        QQRequestApi.getInstance().getCreditDetail(sid,url,new HttpSubscriber<Object>(new SubscriberOnListener<Object>() {
            @Override
            public void onSucceed(Object data) {
                System.out.println("----data-----"+data);
            }

            @Override
            public void onError(int code, String msg) {
                System.out.println("----onError-----");
            }
        },this));
    }

    @Override
    protected void initData() {
        if (which_from.equals("sh")){
            shAdapter = new SHAdapter(this,sh_list);
            listview.setAdapter(shAdapter);
        }else if (which_from.equals("gd")){
            gdAdapter = new GDAdapter(this,gd_list);
            listview.setAdapter(gdAdapter);
        }else if (which_from.equals("jt")){
            jtAdapter = new JTAdapter(this,jt_list);
            listview.setAdapter(jtAdapter);
        }
        else if (which_from.equals("zs")){
            zsAdapter = new ZSAdapter(this,zs_list);
            listview.setAdapter(zsAdapter);
        }
        else if (which_from.equals("pa")){
            paAdapter = new PAAdapter(this,pa_list);
            listview.setAdapter(paAdapter);
        }
    }

    @Override
    protected void handler(Message msg) {

    }
}
