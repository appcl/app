package com.mt.cardletter.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.adapter.SearchAdapter;
import com.mt.cardletter.entity.city.District;
import com.mt.cardletter.entity.data.SearchDatas;
import com.mt.cardletter.entity.integral.SearchIntegralData;
import com.mt.cardletter.entity.merchant.Goods;
import com.mt.cardletter.fragment.CompleteFragment;
import com.mt.cardletter.fragment.SearchHomeFragment;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.view.RefreshRecyclerView.PullToRefreshRecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Date:2018/1/10
 * Time:20:22
 * 首页搜索
 */

public class SearchActivity extends BaseActivity {
    private LinearLayout search_fragment;
    private FrameLayout back_btn;
    private EditText search_et_input;
    private RelativeLayout search_iv_delete;
    private TextView search_btn;
    private android.support.v4.app.FragmentTransaction beginTransaction;
    private android.support.v4.app.FragmentManager fragmentManager;
    private List<District.DataBean> districtList;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        back_btn = (FrameLayout) findViewById(R.id.back_btn);
        search_et_input = (EditText) findViewById(R.id.search_et_input);
        search_iv_delete = (RelativeLayout) findViewById(R.id.search_iv_delete);
        search_btn = (TextView) findViewById(R.id.search_btn);
        search_fragment = (LinearLayout) findViewById(R.id.search_fragment);

        fragmentManager = getSupportFragmentManager();
        beginTransaction = fragmentManager.beginTransaction();
        //beginTransaction.add(R.id.search_fragment,new SearchHomeFragment());
        beginTransaction.commit();
    }

    @Override
    public void initListener() {
        back_btn.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                hideSoftKeyboard(search_et_input);
                finish();
            }
        });

        search_iv_delete.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                search_et_input.setText("");
                search_iv_delete.setVisibility(View.GONE);
            }
        });

        search_et_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!"".equals(s.toString())) {
                    search_iv_delete.setVisibility(View.VISIBLE);
                }else {
                    search_iv_delete.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        search_btn.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                if (checkInput(search_et_input.getText().toString())){
                    SearchHomeFragment fragment = new SearchHomeFragment();
                    Bundle bundle = new Bundle();
                    String strValue = search_et_input.getText().toString();
                    bundle.putString("search_data", strValue);

                    fragment.setArguments(bundle);

                    beginTransaction = fragmentManager.beginTransaction();
                    beginTransaction.replace(R.id.search_fragment,fragment);
                    beginTransaction.commit();
                }
            }
        });

        search_et_input.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    hideSoftKeyboard(search_et_input);
                    if (checkInput(search_et_input.getText().toString())){
                        SearchHomeFragment fragment = new SearchHomeFragment();
                        Bundle bundle = new Bundle();
                        String strValue = search_et_input.getText().toString();
                        bundle.putString("search_data", strValue);
                        fragment.setArguments(bundle);

                        beginTransaction = fragmentManager.beginTransaction();
                        beginTransaction.replace(R.id.search_fragment,fragment);
                        beginTransaction.commit();
                    }
                    return true;
                }
                    return false;
            }
        });
    }



    @Override
    protected void initData() {

    }

    @Override
    protected void handler(Message msg) {

    }

    /**
     * 隐藏键盘
     * @param editText
     */
    private void hideSoftKeyboard(EditText editText){
        InputMethodManager imm = (InputMethodManager)getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public boolean checkInput(String et_search) {
        if (TextUtils.isEmpty(et_search)) {
            ToastUtils.showShort(this, "请输入搜索的关键字");
        }
        else {
            return true;
        }
        return false;
    }

    @Override
    public void finish() {
        hideSoftKeyboard(search_et_input);
        super.finish();
    }
}
