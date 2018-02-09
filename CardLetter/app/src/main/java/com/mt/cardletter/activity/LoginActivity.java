package com.mt.cardletter.activity;

import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.entity.user.LoginEntity;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.SharedPreferences;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import cn.sharesdk.wechat.friends.Wechat;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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
        next.setTextColor(getResources().getColor(R.color.white));
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

//    private void toLogin(String ak, final String username, final String password) {
//        CardLetterRequestApi.getInstance().getUserInfo(ak, username, "",password,"", new HttpSubscriber<LoginEntity>(new SubscriberOnListener<LoginEntity>() {
//            @Override
//            public void onSucceed(LoginEntity data) {
//                if (data.getCode() == 0) {
//                    String nick_name = data.getData().getNickname();
//                    String user_token = data.getData().getUserToken();
//                    SharedPreferences.getInstance().putString("account", username);
//                    SharedPreferences.getInstance().putString("password", password);
//                    SharedPreferences.getInstance().putString("nick_name", nick_name);
//                    SharedPreferences.getInstance().putString("user_token", user_token);
//                    SharedPreferences.getInstance().putBoolean("isLogin", true);
//                    SharedPreferences.getInstance().putString("url","");//将URL设置为空
//                    finish();
//                } else {
//                    ToastUtils.makeShortText(data.getMsg(), LoginActivity.this);
//                }
//            }
//
//            @Override
//            public void onError(int code, String msg) {
//                ToastUtils.makeShortText(msg, LoginActivity.this);
//            }
//        }, LoginActivity.this));
//    }

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
                    //toLogin(Constant.Access_Token, name, password);
                }
                break;
            case R.id.login_forget:

                break;
            case R.id.sina://sina
                impower(SinaWeibo.NAME);
                //startActivity(new Intent(LoginActivity.this, MyLoginActivity.class));
                break;
            case R.id.weixin://weixin
                impower(Wechat.NAME );

                break;
            case R.id.qq:
                impower(QQ.NAME);
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
    /**
     * @param mode  Wechat.NAME  QQ.NAME  SinaWeibo.NAME
     */
    public void impower( String mode ){
        final Logger httpLogger = Logger.getLogger(HttpURLConnection.class.getName());
        httpLogger.setLevel(Level.OFF);
        Platform platform = ShareSDK.getPlatform(mode);
        SharedPreferences.getInstance().putString("impower_mode",mode);
        platform.SSOSetting(false);  //设置false表示使用SSO授权方式
        platform.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onError(Platform arg0, int arg1, Throwable arg2) {
                ToastUtils.makeShortText("请下载最新第三方应用",LoginActivity.this);
                arg2.printStackTrace();
            }
            @Override
            public void onComplete(Platform platform, int action, HashMap<String, Object> res) {
                if (action == Platform.ACTION_USER_INFOR) {
                    PlatformDb platDB = platform.getDb();//获取数平台数据DB
                    String token = platDB.getToken();
                    String userGender = platDB.getUserGender();
                    String userIcon = platDB.getUserIcon();
                    String userId = platDB.getUserId();
                    String userName = platDB.getUserName();
                    //设置第三方名字,头像,第三方id
                    SharedPreferences.getInstance().putString("nick_name",userName);
                    SharedPreferences.getInstance().putString("url",userIcon);
                    SharedPreferences.getInstance().putString("ext_token", userId);
                    SharedPreferences.getInstance().putBoolean("isLogin",true);

                    toLogin_1(userName+userId,userName,userId,userId);
                }
            }
            @Override
            public void onCancel(Platform arg0, int arg1) {}
        });
        platform.showUser(null);//授权并获取用户信息


    }

    private void toLogin_1(String username,String nickname,String password,String ext_token){
        String url = "http://www.51kaxin.xyz/api.php/common/login/access_token/"+Constant.Access_Token+
                "/username/"+username+"/nickname/"+nickname+"/password/"+password+"/ext_token/"+ext_token;
        System.out.println("jk-=url");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder().build();
        Request request = new Request.Builder()
                .post(body)
                .url("http://www.51kaxin.xyz/api.php/common/login/access_token/"+Constant.Access_Token+"/username/"+username+"/nickname/"+nickname+"/password/"+password+"/ext_token/"+ext_token)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                LoginEntity p = gson.fromJson(s, LoginEntity.class);
                String memberId = p.getData().getMemberId();
                String user_token = p.getData().getUserToken();
                String mybank = p.getData().getMybank();
                SharedPreferences.getInstance().putString("member_id",memberId);
                SharedPreferences.getInstance().putString("user_token",user_token);
                SharedPreferences.getInstance().putString("mybank",mybank);
                Constant.MY_BANK = mybank;
                LoginActivity.this.finish();
            }
        });
    }
    private void toLogin_2(String username,String nickname,String password,String ext_token) {
        CardLetterRequestApi.getInstance().getUserInfo(
                username,nickname,password,ext_token,new HttpSubscriber<LoginEntity>(new SubscriberOnListener<LoginEntity>() {
                    @Override
                    public void onSucceed(LoginEntity data) {
                        if (data.getCode()==0) {
                            System.out.println("jk--===LoginEntity");
                        }
                    }
                    @Override
                    public void onError(int code, String msg) {
                        System.out.println("jk--===LoginEntity");
                    }
                },LoginActivity.this));
    }

}
