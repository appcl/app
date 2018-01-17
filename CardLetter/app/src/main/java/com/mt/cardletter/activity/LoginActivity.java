package com.mt.cardletter.activity;

import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.user.LoginEntity;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.SharedPreferences;
import com.mt.cardletter.utils.ThirdpartyLoginUtils;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * Date:2017/12/13
 * Time:17:56
 * author:demons
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText phone;
    private EditText code;
    private Button btnSure;

    private String name;
    private String password;

    private FrameLayout com_back_click;
    private TextView title_name;
    private TextView next;

    private ImageView sina;
    private boolean isShouQuan;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        sina = (ImageView) findViewById(R.id.sina);
        sina.setOnClickListener(this);
        findViewById(R.id.qq).setOnClickListener(this);
        findViewById(R.id.weixin).setOnClickListener(this);
        phone = (EditText) findViewById(R.id.phone);
        code = (EditText) findViewById(R.id.code);
        btnSure = (Button) findViewById(R.id.btnSure);
        btnSure.setOnClickListener(this);
        com_back_click = (FrameLayout) findViewById(R.id.com_back_click);
        title_name = (TextView) findViewById(R.id.title_name);
        next = (TextView) findViewById(R.id.commonal_tv);
        com_back_click.setVisibility(View.VISIBLE);
        title_name.setText("登录");
        next.setVisibility(View.VISIBLE);
        next.setText("注册");
        next.setTextColor(getResources().getColor(R.color.color_text_black_31));
        next.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                UIHelper.showRegisterActivity(LoginActivity.this);
                finish();
            }
        });
        phone.setText(SharedPreferences.getInstance().getString("account", ""));
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

    private void toLogin(String ak, final String username, final String password) {
        CardLetterRequestApi.getInstance().getUserInfo(ak, username, password, new HttpSubscriber<LoginEntity>(new SubscriberOnListener<LoginEntity>() {
            @Override
            public void onSucceed(LoginEntity data) {
                if (data.getCode() == 0) {
                    String nick_name = data.getData().getNickname();
                    String user_token = data.getData().getUser_token();
                    SharedPreferences.getInstance().putString("account", username);
                    SharedPreferences.getInstance().putString("password", password);
                    SharedPreferences.getInstance().putString("nick_name", nick_name);
                    SharedPreferences.getInstance().putString("user_token", user_token);
                    SharedPreferences.getInstance().putBoolean("isLogin", true);
                    SharedPreferences.getInstance().putString("url","");//将URL设置为空
                    finish();
                } else {
                    ToastUtils.makeShortText(data.getMsg(), LoginActivity.this);
                }
            }

            @Override
            public void onError(int code, String msg) {
                ToastUtils.makeShortText(msg, LoginActivity.this);
            }
        }, LoginActivity.this));
    }

    /**
     * 检查注册输入的内容
     */
    public boolean checkInput(String phone, String password) {
        if (TextUtils.isEmpty(phone)) {
            ToastUtils.showShort(this, "请输入账号");
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
        switch (v.getId()) {
            case R.id.btnSure:
                if (checkInput(name, password)) {
                    toLogin(Constant.Access_Token, name, password);
                }
                break;
            case R.id.login_forget:

                break;
            case R.id.sina:
                startActivity(new Intent(LoginActivity.this, MyLoginActivity.class));
                break;
            case R.id.weixin:
                ThirdpartyLoginUtils.loginForWinxin(this);
                break;
            case R.id.qq:
                ThirdpartyLoginUtils.loginForQQ(this);
                break;
        }
    }

    /**
     * 回显
     */
    @Override
    protected void onResume() {
        super.onResume();
        if (getIntent().getStringExtra("username") != null) {
            phone.setText(getIntent().getStringExtra("username"));
        }
        phone.setText(SharedPreferences.getInstance().getString("account", ""));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }



}
