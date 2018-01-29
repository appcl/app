package com.mt.cardletter.activity;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.user.LoginEntity;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.SharedPreferences;
import com.mt.cardletter.utils.ToastUtils;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private EditText phone;
    private EditText password;
    private EditText rePassword;
    private Button register;
    private Button btnClose;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {
        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.code);
        rePassword = (EditText) findViewById(R.id.code2);
        register = (Button) findViewById(R.id.btnSure);
        btnClose = (Button) findViewById(R.id.btnClose);
        btnClose.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSure:
                verifyData();
                break;
            case R.id.btnClose:
                finish();
                break;
        }
    }

    private void verifyData(){
        if(phone.getText().toString().isEmpty()){
            ToastUtils.makeShortText("用户名不能为空",getApplicationContext());
            return;
        }
        if(password.getText().toString().trim().isEmpty()){
            ToastUtils.makeShortText("密码不能为空",getApplicationContext());
            return;
        }
        if(!rePassword.getText().toString().trim().equals(password.getText().toString().trim())){
            ToastUtils.makeShortText("两次密码输入不一致",getApplicationContext());
            return;
        }
        toRegister(Constant.Access_Token,phone.getText().toString().trim(),password.getText().toString().trim());
    }

    private void toRegister(String ak, final String username, final String password){
        CardLetterRequestApi.getInstance().getUserInfo(ak,username,password,"",new HttpSubscriber<LoginEntity>(new SubscriberOnListener<LoginEntity>() {
            @Override
            public void onSucceed(LoginEntity data) {
                if (data.getCode() == 0){
                    String nick_name = data.getData().getNickname();
                    String user_token = data.getData().getUserToken();
                    SharedPreferences.getInstance().putString("account",username);
                    SharedPreferences.getInstance().putString("password",password);
                    SharedPreferences.getInstance().putString("nick_name",nick_name);
                    SharedPreferences.getInstance().putString("user_token",user_token);
                    SharedPreferences.getInstance().putBoolean("isLogin",false);
                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                    intent.putExtra("userName",username);
                    startActivity(intent);
                    finish();
                }else {
                    ToastUtils.makeShortText(data.getMsg(),RegisterActivity.this);
                }
            }

            @Override
            public void onError(int code, String msg) {
                ToastUtils.makeShortText(msg,RegisterActivity.this);
            }
        },RegisterActivity.this));
    }
    @Override
    public void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void handler(Message msg) {

    }


}
