package com.mt.cardletter.fragment;


import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;

/**
 * Created by gaolei on 2017/11/13.
 */

public class CardManagerFragment extends BaseFragment {
    private TextView title_name;
    private TextView commonal_tv;
    private CardView bank_layout;

    @Override
    protected int setLayoutResouceId() {
        return R.layout.fragment_cm;
    }


    @Override
    protected void initView() {
        title_name = findViewById(R.id.title_name);
        commonal_tv = findViewById(R.id.commonal_tv);
        commonal_tv.setVisibility(View.VISIBLE);
        bank_layout = findViewById(R.id.card_layout);
        super.initView();
    }

    @Override
    public void initData() {
        title_name.setText("卡管家");
        commonal_tv.setText("添加");
        commonal_tv.setTextColor(getResources().getColor(R.color.white));
        commonal_tv.setVisibility(View.VISIBLE);

        commonal_tv.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                UIHelper.showQQH5(getContext());
            }
        });

        bank_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.makeShortText("点击右上角的添加按钮",getContext());
            }
        });
    }

    private void getData() {
    }

}
