package com.mt.cardletter.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.entity.integral.SearchIntegralData;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshBase;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import static com.mt.cardletter.R.id.bjf_jf;
import static com.mt.cardletter.R.id.bjf_time;

/**
 * Date:2017/12/13
 * Time:11:42
 * author:demons
 */

public class SearchIntegralActivity extends BaseActivity implements PullToRefreshBase.OnRefreshListener2{
    private static final int UPDATA_UP = 0X01; // 上拉加载
    private static final int UPDATA_DOWN = 0X02; //下拉刷新
    private static final int UPDATA_DEF = 0X03; //默认加载
    private FrameLayout back_btn;
    private EditText search_et_input;
    private RelativeLayout search_iv_delete;
    private TextView search_btn;
    private PullToRefreshListView recyclerView;
    private int page = 1;
    private int num = 10;
    private List<SearchIntegralData.DataBeanX.DataBean> list = new ArrayList<>();
    private MyAllAdapter adapter;
    private TextView tv_noll;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_integral_search;
    }

    @Override
    public void initView() {
        back_btn = (FrameLayout) findViewById(R.id.back_btn);
        search_et_input = (EditText) findViewById(R.id.search_et_input);
        search_iv_delete = (RelativeLayout) findViewById(R.id.search_iv_delete);
        search_btn = (TextView) findViewById(R.id.search_btn);
        tv_noll = (TextView) findViewById(R.id.tv_noll);
        recyclerView = (PullToRefreshListView) findViewById(R.id.search_recycler_view);
        recyclerView.setAdapter(adapter = new MyAllAdapter());
        recyclerView.setMode(PullToRefreshBase.Mode.BOTH);
        recyclerView.setOnRefreshListener(this);
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (list.get(position-1).getB_url()==null||list.get(position-1).getB_url().equals("")){
                    ToastUtils.makeShortText("商品已下架，请等待更新",SearchIntegralActivity.this);
                }else {
                    Intent intent = new Intent(SearchIntegralActivity.this,BankJFWebViewActivity.class);
                    Bundle b = new Bundle();
                    b.putString("url",list.get(position-1).getB_url());
                    intent.putExtras(b);
                    startActivity(intent);
                }
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
                    getDatas(UPDATA_DEF,page);
                }
            }
        });

        search_et_input.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH){
                    if (checkInput(search_et_input.getText().toString())){
                        getDatas(UPDATA_DEF,page);
                    }
                    return true;
                }
                return false;
            }
        });
    }

    private void getDatas(final int upDataFlag,int page){
        CardLetterRequestApi.getInstance().getSearchIntegralData(Constant.Access_Token,num,page,0,search_et_input.getText().toString(),
                new HttpSubscriber<SearchIntegralData>(new SubscriberOnListener<SearchIntegralData>() {
                    @Override
                    public void onSucceed(SearchIntegralData data) {
                        if (data.getCode()==0){
                            List<SearchIntegralData.DataBeanX.DataBean>data1 = data.getData().getData();
                            if (data1.size()>0){
                                if (upDataFlag == UPDATA_DEF){
                                    System.out.println("UPDATA_DEF-----"+data1.size());
                                    if (data1.size()>0){
                                        tv_noll.setVisibility(View.GONE);
                                    }else {
                                        tv_noll.setVisibility(View.VISIBLE);
                                    }
                                    list = data1;
                                }else if(upDataFlag == UPDATA_UP){
                                    System.out.println("UPDATA_UP-----"+data1.size());
                                    if (data1.size()>0){
                                        tv_noll.setVisibility(View.GONE);
                                    }else {
                                        tv_noll.setVisibility(View.VISIBLE);
                                    }
                                    list.addAll(data1);
                                }else if(upDataFlag == UPDATA_DOWN){
                                    System.out.println("UPDATA_DOWN-----"+data1.size());
                                    if (data1.size()>0){
                                        tv_noll.setVisibility(View.GONE);
                                    }else {
                                        tv_noll.setVisibility(View.VISIBLE);
                                    }
                                    list = data1;
                                }
                                adapter.notifyDataSetChanged();
                                recyclerView.onRefreshComplete();
                            }else {
                                adapter.notifyDataSetChanged();
                                recyclerView.onRefreshComplete();
                                ToastUtils.makeShortText("暂无数据",SearchIntegralActivity.this);
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

    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
        page=1;
        getDatas(UPDATA_DOWN,page);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
        page++;
        getDatas(UPDATA_UP,page);
    }

    class MyAllAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            SearchIntegralData.DataBeanX.DataBean bean = list.get(position);
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(SearchIntegralActivity.this,R.layout.item_b_seller, null);
                holder.tv_name = (TextView) convertView.findViewById(R.id.bjf_name);
                holder.bjf_jf = (TextView) convertView.findViewById(bjf_jf);
                holder.img_bfj = (ImageView) convertView.findViewById(R.id.bjf_img);
                holder.bjf_time = (TextView) convertView.findViewById(bjf_time);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tv_name.setText(bean.getName());
            holder.bjf_jf.setText("消费积分: "+String.valueOf(bean.getNeed_score()));
            holder.bjf_time.setText(bean.getCreate_time());
            Glide.with(SearchIntegralActivity.this)
                    .load(Constant.PIC_URL+bean.getThumb())
                    .error(R.drawable.default_error)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.img_bfj);
            return convertView;
        }

        class ViewHolder{
            private TextView tv_name,bjf_jf,bjf_time;
            private ImageView img_bfj;
        }
    }

}
