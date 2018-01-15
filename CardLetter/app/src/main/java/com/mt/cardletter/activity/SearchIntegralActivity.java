package com.mt.cardletter.activity;

import android.content.Context;
import android.content.Intent;
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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.adapter.SearchIntegralAdapter;
import com.mt.cardletter.entity.integral.SearchIntegralData;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.view.RefreshRecyclerView.PullToRefreshRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Date:2017/12/13
 * Time:11:42
 * author:demons
 */

public class SearchIntegralActivity extends BaseActivity {
    private FrameLayout back_btn;
    private EditText search_et_input;
    private RelativeLayout search_iv_delete;
    private TextView search_btn;
    private PullToRefreshRecyclerView recyclerView;
    private int page = 1;
    private int num = 5;
    private List<SearchIntegralData.DataBeanX.DataBean> list = new ArrayList<>();
    private SearchIntegralAdapter adapter;

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

        recyclerView = (PullToRefreshRecyclerView) findViewById(R.id.search_recycler_view);
        recyclerView.initRefreshView(this,new LinearLayoutManager(this));
        recyclerView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                getDatas(page);
            }
        });
        recyclerView.setPagingableListener(new PullToRefreshRecyclerView.PagingableListener() {
            @Override
            public void onLoadMoreItems() {
                page++;
                getDatas(page);
            }
        });
        adapter = new SearchIntegralAdapter(this);
        recyclerView.setAdapter(adapter);

        adapter.setItemClickListener(new SearchIntegralAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(SearchIntegralActivity.this,BankJFWebViewActivity.class);
                Bundle b = new Bundle();
                b.putString("url",list.get(position).getB_url());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
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
                    getDatas(page);
                    adapter.clearData();
                    adapter.notifyDataSetChanged();
                }
            }
        });

        search_et_input.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    hideSoftKeyboard(search_et_input);
                    if (checkInput(search_et_input.getText().toString())){
                        getDatas(page);
                        adapter.clearData();
                        adapter.notifyDataSetChanged();
                    }
                    return true;
                }
                return false;
            }
        });
    }

    private void getDatas(int page){
        CardLetterRequestApi.getInstance().getSearchIntegralData(Constant.Access_Token,num,page,0,search_et_input.getText().toString(),
                new HttpSubscriber<SearchIntegralData>(new SubscriberOnListener<SearchIntegralData>() {
                    @Override
                    public void onSucceed(SearchIntegralData data) {
                        if (data.getCode()==0){
                            if (data.getData().getTotal()>0) {
                                list = data.getData().getData();
                                adapter.addData(list);
                                recyclerView.setOnRefreshComplete();
                                recyclerView.onFinishLoading(true,false);
                            }else {
                                recyclerView.setOnLoadMoreComplete();
                                ToastUtils.makeShortText("已没有更多",SearchIntegralActivity.this);
                            }
                        }else {
                            ToastUtils.makeShortText(data.getMsg(),SearchIntegralActivity.this);
                        }
                    }

                    @Override
                    public void onError(int code, String msg) {

                    }
                },this));
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
}
