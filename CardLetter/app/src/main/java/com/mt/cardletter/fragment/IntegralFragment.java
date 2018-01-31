package com.mt.cardletter.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.BankJFActivity;
import com.mt.cardletter.adapter.BankAdapter;
import com.mt.cardletter.adapter.CategoryAdapter;
import com.mt.cardletter.adapter.IntegralAdapter;
import com.mt.cardletter.entity.integral.CategoryEntity;
import com.mt.cardletter.entity.integral.IntegralEntity;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.cityview.WrapHeightGridView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by gaolei on 2017/11/13.
 */

public class IntegralFragment extends BaseFragment {
    private TextView title_name;
    private WrapHeightGridView content_list;
    private List<IntegralEntity> list =new ArrayList<>();
    private GridView gridView;
    private IntegralAdapter iAdapter;
    private List<CategoryEntity.DataBeanX.SellerCategoryListBean> c_list=new ArrayList<>();
    private List<CategoryEntity.DataBeanX.BankcardListBean> b_list=new ArrayList<>();
    private List<CategoryEntity.DataBeanX.SellerListBean.DataBean>s_list =new ArrayList<>();
    private CategoryAdapter cAdapter;
    private BankAdapter bAdapter;
    private LinearLayout searchView;
    private WrapHeightGridView b_gridview;
    private EditText search_et_input;

    @Override
    protected int setLayoutResouceId() {
        getData();
        return R.layout.fragment_integral;
    }

    int b_id;
    String b_name;
    @Override
    protected void initView() {
        super.initView();
        title_name = findViewById(R.id.title_name);
        gridView=findViewById(R.id.grid);

        content_list = findViewById(R.id.content_list);

        content_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int c_id = c_list.get(position).getId();
                String c_name = c_list.get(position).getName();
                getTAGBank(2,c_name,c_id,Constant.Access_Token,1);
            }
        });

        searchView = findViewById(R.id.search_layout);
        search_et_input= findViewById(R.id.search_et_input);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.showSearchIntegralActivity(getContext());
            }
        });
        search_et_input.setFocusable(false);//让EditText失去焦点，然后获取点击事件
        search_et_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.showSearchIntegralActivity(getContext());
            }
        });

        b_gridview = findViewById(R.id.bank_list);

        b_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bAdapter.setSelectItem(position);
                TextView tv_= (TextView) view.findViewById(R.id.b_bank);
                ImageView img_ = (ImageView) view.findViewById(R.id.b_img);
                if (b_list1.get(position).getName().
                        equals("更多"))
                {
                    bAdapter.setSelectItem(-1);
                    b_list1.clear();
                    b_list1.addAll(b_list);
//                    tv_.setVisibility(View.INVISIBLE);
//                    img_.setVisibility();
                    CategoryEntity.DataBeanX.BankcardListBean bean = new CategoryEntity.DataBeanX.BankcardListBean();
                    bean.setName("收起");

//                    b_list1.get(position).setName("收起");
                    b_list1.add(bean);
                    bAdapter.notifyDataSetChanged();
                }else if (b_list1.get(position).getName().
                        equals("收起")){
                    bAdapter.setSelectItem(-1);
                    b_list1.clear();
                    for(int i=0;i<11;i++){
                        b_list1.add(b_list.get(i));
                    }
                    CategoryEntity.DataBeanX.BankcardListBean bean = new CategoryEntity.DataBeanX.BankcardListBean();
                    bean.setName("更多");
                    b_list1.add(bean);
                    tv_.setVisibility(View.VISIBLE);
                    bAdapter.notifyDataSetChanged();
                }else {
//                    if (b_list1.get(position).getName().equals("汇丰银行")){
//                        ToastUtils.makeShortText("暂不支持汇丰银行积分查询、兑换",getContext());
//                    }else {
                        b_id = b_list1.get(position).getId();
                        b_name = b_list1.get(position).getName();
                        System.out.println("点击了-----"+b_name);
                        getBank(1,b_name,b_id,Constant.Access_Token,1);
                        bAdapter.notifyDataSetChanged();
//                    }
                }
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = list.get(position).getI_tv();
                switch (position){
                    case 0://5k
                        getChangeData(name,"t1",Constant.Access_Token,1);
                        break;
                    case 1://5-8k
                        getChangeData(name,"t2",Constant.Access_Token,1);
                        break;
                    case 2://8-15k
                        getChangeData(name,"t3",Constant.Access_Token,1);
                        break;
                    case 3://15-30k
                        getChangeData(name,"t4",Constant.Access_Token,1);
                        break;
                    case 4://30k+
                        getChangeData(name,"t5",Constant.Access_Token,1);
                        break;
                }
            }
        });

    }

    private void getChangeData(final String name, final String channel, String access_token, int i) {
        CardLetterRequestApi.getInstance().getChannel_BJ(channel,access_token,i,new HttpSubscriber<CategoryEntity>(new SubscriberOnListener<CategoryEntity>() {
            @Override
            public void onSucceed(CategoryEntity data) {
                if (data.getCode()==0){
                    s_list = data.getData().getSeller_list().getData();
                    if (s_list.size()>0){
                        Intent intent = new Intent(getContext(), BankJFActivity.class);
                        Bundle b = new Bundle();
                        b.putString("channel",channel);
                        b.putInt("is_from",0);
                        intent.putExtras(b);
                        intent.putExtra("list", (Serializable) s_list);
                        getContext().startActivity(intent);
                    }else {
                        ToastUtils.makeShortText(name+"暂无积分信息!",getContext());
                    }
                }else {
                    ToastUtils.makeShortText(data.getMsg(),getContext());
                }
            }

            @Override
            public void onError(int code, String msg) {

            }
        },getContext()));
    }

    private void getBank(final int is_from,final String b_name, final int b_id, String access_token, int i) {
        CardLetterRequestApi.getInstance().getBank_JF(b_id,access_token,i,new HttpSubscriber<CategoryEntity>(new SubscriberOnListener<CategoryEntity>() {
            @Override
            public void onSucceed(CategoryEntity data) {
                System.out.println("------onSucceed------");
                if (data.getCode()==0){
                    List<CategoryEntity.DataBeanX.SellerListBean.DataBean> sell_list = data.getData().getSeller_list().getData();
                    if (sell_list.size()>0){
                        Intent intent = new Intent(getContext(), BankJFActivity.class);
                        Bundle b = new Bundle();
                        b.putInt("b_id",b_id);
                        b.putInt("is_from",is_from);
                        intent.putExtras(b);
                        intent.putExtra("list", (Serializable) sell_list);
                        getContext().startActivity(intent);
                    }else {
                        ToastUtils.makeShortText(b_name+"暂无积分信息!",getContext());
                    }
                }else {
                    ToastUtils.makeShortText(data.getMsg(),getContext());
                }
            }

            @Override
            public void onError(int code, String msg) {
                System.out.println("------onError------");
            }
        },getContext()));
    }

    private void getTAGBank(final int is_from,final String b_name, final int c_id, String access_token, int i) {
        CardLetterRequestApi.getInstance().getTAG_BJ(c_id,access_token,i,new HttpSubscriber<CategoryEntity>(new SubscriberOnListener<CategoryEntity>() {
            @Override
            public void onSucceed(CategoryEntity data) {
                if (data.getCode()==0){
                    List<CategoryEntity.DataBeanX.SellerListBean.DataBean> sell_list = data.getData().getSeller_list().getData();
                    if (sell_list.size()>0){
                        Intent intent = new Intent(getContext(), BankJFActivity.class);
                        Bundle b = new Bundle();
                        b.putInt("c_id",c_id);
                        b.putInt("is_from",is_from);
                        intent.putExtras(b);
                        intent.putExtra("list", (Serializable) sell_list);
                        getContext().startActivity(intent);
                    }else {
                        ToastUtils.makeShortText(b_name+"暂无积分信息!",getContext());
                    }
                }else {
                    ToastUtils.makeShortText(data.getMsg(),getContext());
                }
            }

            @Override
            public void onError(int code, String msg) {

            }
        },getContext()));
    }

    @Override
    public void initData() {
        title_name.setText("积分商城");
        iAdapter = new IntegralAdapter(getContext(),list);
        gridView.setAdapter(iAdapter);

//        setupRecycler();
    }

    private void getData() {
        IntegralEntity entity = new IntegralEntity();
        entity.setI_tv("5k分以内");
        entity.setI_pic(getResources().getDrawable(R.drawable.jf_5));
        list.add(entity);

        IntegralEntity entity1 = new IntegralEntity();
        entity1.setI_tv("5K-8k积分");
        entity1.setI_pic(getResources().getDrawable(R.drawable.jf_58));
        list.add(entity1);

        IntegralEntity entity2 = new IntegralEntity();
        entity2.setI_tv("8k-15k积分");
        entity2.setI_pic(getResources().getDrawable(R.drawable.jf_815));
        list.add(entity2);

        IntegralEntity entity3 = new IntegralEntity();
        entity3.setI_tv("15k-30k积分");
        entity3.setI_pic(getResources().getDrawable(R.drawable.jf_1530));
        list.add(entity3);

        IntegralEntity entity4 =new IntegralEntity();
        entity4.setI_tv("30k积分以上");
        entity4.setI_pic(getResources().getDrawable(R.drawable.jf_30));
        list.add(entity4);

        CardLetterRequestApi.getInstance().getCategory(Constant.Access_Token,
                new HttpSubscriber<CategoryEntity>(new SubscriberOnListener<CategoryEntity>() {
                    @Override
                    public void onSucceed(CategoryEntity data) {
                        if (data.getCode()==0){
                            c_list=data.getData().getSeller_category_list();
                            b_list = data.getData().getBankcard_list();
                            System.out.println("-----c_list--------"+c_list.size());
                            cAdapter = new CategoryAdapter(getContext(),c_list);
                            content_list.setAdapter(cAdapter);
                            setGridView(b_list);
                        }else {
                            ToastUtils.makeShortText(data.getMsg(),getContext());
                        }
                    }

                    @Override
                    public void onError(int code, String msg) {

                    }
                },getContext()));
    }
    private List<CategoryEntity.DataBeanX.BankcardListBean> b_list1;
    private void setGridView(final List<CategoryEntity.DataBeanX.BankcardListBean> b_list) {
        if (b_list.size()>12){ //>12即为三行 超过三行隐藏
            b_list1 = new ArrayList<>();
            for (int i =0;i<11;i++){
                b_list1.add(b_list.get(i));
            }
            CategoryEntity.DataBeanX.BankcardListBean bean = new CategoryEntity.DataBeanX.BankcardListBean();
            bean.setName("更多");
            b_list1.add(bean);
            bAdapter= new BankAdapter(getContext(),b_list1);
            b_gridview.setAdapter(bAdapter);
        }else {
            bAdapter= new BankAdapter(getContext(),b_list);
            b_gridview.setAdapter(bAdapter);
        }
    }

    protected void setupRecycler(){
//        adapter = new ContentAdapter(getContext(),list);
        //content_list.setAdapter(adapter);
    }

}
