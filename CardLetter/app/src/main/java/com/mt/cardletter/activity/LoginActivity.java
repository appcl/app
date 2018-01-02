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
import com.mt.cardletter.utils.SharedPreferences;
import com.mt.cardletter.utils.ToastUtils;

/**
 * Date:2017/12/13
 * Time:17:56
 * author:demons
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private EditText phone;
    private EditText code;
    private Button btnSure;
    private Button btnClose;

    private String name;
    private String password;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        phone= (EditText) findViewById(R.id.phone);
        code = (EditText) findViewById(R.id.code);
        btnSure = (Button) findViewById(R.id.btnSure);
        btnClose = (Button) findViewById(R.id.btnClose);

        btnSure.setOnClickListener(this);
        btnClose.setOnClickListener(this);

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

    private void toLogin(String ak, final String username, final String password){
        CardLetterRequestApi.getInstance().getUserInfo(ak,username,password,new HttpSubscriber<LoginEntity>(new SubscriberOnListener<LoginEntity>() {
            @Override
            public void onSucceed(LoginEntity data) {
                if (data.getCode() == 0){
                    String nick_name = data.getData().getNickname();
                    String user_token = data.getData().getUser_token();
                    SharedPreferences.getInstance().putString("account",username);
                    SharedPreferences.getInstance().putString("password",password);
                    SharedPreferences.getInstance().putString("nick_name",nick_name);
                    SharedPreferences.getInstance().putString("user_token",user_token);
                    SharedPreferences.getInstance().putBoolean("isLogin",true);
                    finish();
                }else {
                    ToastUtils.makeShortText(data.getMsg(),LoginActivity.this);
                }
            }

            @Override
            public void onError(int code, String msg) {
                ToastUtils.makeShortText("网络故障",LoginActivity.this);
            }
        },LoginActivity.this));
    }

    /**
     * 检查注册输入的内容
     */
    public boolean checkInput(String phone, String password) {
        if (TextUtils.isEmpty(phone)) {
            ToastUtils.showShort(this, "请填写账号");
        }
      /*  else if (!RegexUtils.checkMobile(phone)) {
            ToastUtils.showShort(this, R.string.tip_phone_regex_not_right);

        } */
        else if (TextUtils.isEmpty(password)) {
            ToastUtils.showShort(this, "请输入密码");
        } else {
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        name = phone.getText().toString();
        password = code.getText().toString();
        switch (v.getId()){
            case R.id.btnSure:
                if (checkInput(name,password)){
                    toLogin(Constant.Access_Token,name,password);
                }
                break;
            case R.id.btnClose:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
