package com.mt.cardletter.activity;

import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.adapter.MyAdapter;
import com.mt.cardletter.app.AppContext;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Date:2017/12/28
 * Time:15:18
 * author:demons
 */

public class MessageActivity extends BaseActivity {
    @Bind({R.id.com_back_click})
    FrameLayout back;
    @Bind({R.id.title_name})
    TextView name;
    @Bind({R.id.message_list})
    ListView message_list;

    private MyAdapter adapter;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_message;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        back.setVisibility(View.VISIBLE);
        name.setText("系统消息");
    }

    @Override
    public void initListener() {

    }

    @Override
    protected void initData() {
        System.out.println("-----MessageActivity-----"+AppContext.push_data.size());
        adapter = new MyAdapter(this, AppContext.push_data);
        message_list.setAdapter(adapter);
    }

    @Override
    protected void handler(Message msg) {

    }
}
