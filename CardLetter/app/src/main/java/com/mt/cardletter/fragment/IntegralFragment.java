package com.mt.cardletter.fragment;


import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.adapter.BankAdapter;
import com.mt.cardletter.adapter.CategoryAdapter;
import com.mt.cardletter.adapter.ContentAdapter;
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

import java.util.ArrayList;
import java.util.List;


/**
 * Created by gaolei on 2017/11/13.
 */

public class IntegralFragment extends BaseFragment {
    private TextView title_name;
    private WrapHeightGridView content_list;
    private List<IntegralEntity> list =new ArrayList<>();
    private ContentAdapter adapter;
    private GridView gridView;
    private IntegralAdapter iAdapter;
    private List<CategoryEntity.DataBeanX.SellerCategoryListBean> c_list=new ArrayList<>();
    private List<CategoryEntity.DataBeanX.BankcardListBean> b_list=new ArrayList<>();
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
                UIHelper.showClassifyActivity(getContext(),c_id,c_name);
            }
        });

        searchView = findViewById(R.id.search_layout);
        search_et_input= findViewById(R.id.search_et_input);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.showSearchActivity(getContext());
            }
        });
        search_et_input.setFocusable(false);//让EditText失去焦点，然后获取点击事件
        search_et_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.showSearchActivity(getContext());
            }
        });

        b_gridview = findViewById(R.id.bank_list);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0://5k
                        break;
                    case 1://5-8k
                        break;
                    case 2://8-15k
                        break;
                    case 3://15-30k
                        break;
                    case 4://30k+
                        break;
                }
            }
        });
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
        list.add(entity);

        IntegralEntity entity1 = new IntegralEntity();
        entity1.setI_tv("5K-8k积分");
        list.add(entity1);

        IntegralEntity entity2 = new IntegralEntity();
        entity2.setI_tv("8k-15k积分");
        list.add(entity2);

        IntegralEntity entity3 = new IntegralEntity();
        entity3.setI_tv("15k-30k积分");
        list.add(entity3);

        IntegralEntity entity4 =new IntegralEntity();
        entity4.setI_tv("30k积分以上");
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

                            bAdapter= new BankAdapter(getContext(),b_list);
                            b_gridview.setAdapter(bAdapter);
                        }else {
                            ToastUtils.makeShortText(data.getMsg(),getContext());
                        }
                    }

                    @Override
                    public void onError(int code, String msg) {

                    }
                },getContext()));
    }

    protected void setupRecycler(){
//        adapter = new ContentAdapter(getContext(),list);
        //content_list.setAdapter(adapter);
    }

}
