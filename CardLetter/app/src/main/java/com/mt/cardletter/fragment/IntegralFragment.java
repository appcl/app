package com.mt.cardletter.fragment;


import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.mt.cardletter.R;
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

import java.util.ArrayList;
import java.util.List;


/**
 * Created by gaolei on 2017/11/13.
 */

public class IntegralFragment extends BaseFragment {
    private TextView title_name;
    private GridView content_list;
    private List<IntegralEntity> list =new ArrayList<>();
    private ContentAdapter adapter;
    private GridView gridView;
    private IntegralAdapter iAdapter;
    private List<CategoryEntity.DataBean> c_list=new ArrayList<>();
    private CategoryAdapter cAdapter;

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
        entity.setI_tv("3k分以内");
        list.add(entity);

        IntegralEntity entity1 = new IntegralEntity();
        entity1.setI_tv("5k分以下");
        list.add(entity1);

        IntegralEntity entity2 = new IntegralEntity();
        entity2.setI_tv("5k-8k积分");
        list.add(entity2);

        IntegralEntity entity3 = new IntegralEntity();
        entity3.setI_tv("8k-15k积分");
        list.add(entity3);

        IntegralEntity entity4 =new IntegralEntity();
        entity4.setI_tv("15k积分以上");
        list.add(entity4);

        CardLetterRequestApi.getInstance().getCategory(Constant.Access_Token,
                new HttpSubscriber<CategoryEntity>(new SubscriberOnListener<CategoryEntity>() {
                    @Override
                    public void onSucceed(CategoryEntity data) {
                        if (data.getCode()==0){
                            c_list=data.getData();
                            System.out.println("-----c_list--------"+c_list.size());
                            cAdapter = new CategoryAdapter(getContext(),c_list);
                            content_list.setAdapter(cAdapter);
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
