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
import com.mt.cardletter.activity.BaseActivity;
import com.mt.cardletter.adapter.SHAdapter;
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

    private TextView title_name;
    private FrameLayout back;
    private ListView listview;

    private SHAdapter adapter;

    private String sid;

    @Override
    protected int getLayoutResId() {
        getDatas();
        return R.layout.activity_sh;
    }

    private void getDatas() {
        sh_list = (List<BankEntity.BankBean.ShListBean>) getIntent().getSerializableExtra("sh_list");
        Bundle bundle = getIntent().getExtras();
        sid = bundle.getString("sid");
    }

    @Override
    public void initView() {
        title_name = (TextView) findViewById(R.id.title_name);
        title_name.setText(sh_list.get(0).getName());
        back = (FrameLayout) findViewById(R.id.com_back_click);
        back.setVisibility(View.VISIBLE);
        listview = (ListView) findViewById(R.id.sh_listview);
    }

    @Override
    public void initListener() {
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item_id = sh_list.get(position).getId();
                Intent i = new Intent(SHActivity.this,SHWebActiviy.class);
                Bundle b =  new Bundle();
                b.putString("item_id",item_id);
                b.putString("sid",sid);
                i.putExtras(b);
                startActivity(i);
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
        adapter = new SHAdapter(this,sh_list);
        listview.setAdapter(adapter);
    }

    @Override
    protected void handler(Message msg) {

    }
}
