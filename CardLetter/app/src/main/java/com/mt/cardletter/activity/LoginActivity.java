package com.mt.cardletter.activity;

import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.user.LoginEntity;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.ToastUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Date:2017/12/13
 * Time:17:56
 * author:demons
 */

public class LoginActivity extends BaseActivity {

    @Bind({R.id.phone})
    EditText phone;
    @Bind({R.id.code})
    EditText code;
    @Bind({R.id.btnSure})
    Button btnSure;
    @Bind({R.id.btnClose})
    Button btnClose;

    private String name,password;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);

//        findViewById(R.id.btnClose).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (checkInput())
//            }
//        });
        name = phone.getText().toString();
        password = code.getText().toString();
    }

    @Override
    public void initListener() {
        btnSure.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                if (checkInput(name,password)){
                    toLogin(Constant.Access_Token,name,password);
                }
            }
        });

        btnClose.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void handler(Message msg) {

    }

    private void toLogin(String ak,String username,String password){
        CardLetterRequestApi.getInstance().getUserInfo(ak,username,password,new HttpSubscriber<LoginEntity>(new SubscriberOnListener<LoginEntity>() {
            @Override
            public void onSucceed(LoginEntity data) {

            }

            @Override
            public void onError(int code, String msg) {

            }
        },LoginActivity.this));
        finish();
    }

    /**
     * 检查注册输入的内容
     */
    public boolean checkInput(String username,String password) {
        if (TextUtils.isEmpty(username)) {
            ToastUtils.showShort(this, "请输入账号");
        }
        else if (TextUtils.isEmpty(password)) {
            ToastUtils.showShort(this, "请输入密码");
        } else {
            return true;
        }
        return false;
    }
}
