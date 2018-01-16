package com.mt.cardletter.activity.setting;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mt.cardletter.R;
import com.mt.cardletter.activity.BaseActivity;
import com.mt.cardletter.activity.LoginActivity;
import com.mt.cardletter.entity.user.LoginEntity;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.PermissionUtils;
import com.mt.cardletter.utils.PictureUtils;
import com.mt.cardletter.utils.SharedPreferences;
import com.mt.cardletter.utils.ThirdpartyLoginUtils;
import com.mt.cardletter.utils.ToastUtils;
import com.umeng.socialize.UMShareAPI;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;
import test.abc.H5Activity;

/**
 *  jk - 修改文件
 */
public class  SettingMsgActivity  extends  BaseActivity  implements  View.OnClickListener {
    private int[] headImgID = {R.mipmap.head1,R.mipmap.head2,R.mipmap.head3,R.mipmap.head4,R.mipmap.head5,R.mipmap.head6};
    private CircleImageView circleImageView;
    private RelativeLayout msgTop;
    private boolean isLogin;
    private Button btnExit;
    private RelativeLayout updataUserName;
    private TextView updata;
    private EditText old_pw,new_pw,new_pw_re;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_setting_msg;
    }

    @Override
    public void initView() {
        old_pw = (EditText) findViewById(R.id.old_pw);
        new_pw = (EditText) findViewById(R.id.new_pw);
        new_pw_re = (EditText) findViewById(R.id.new_pw_re);

        updataUserName = (RelativeLayout) findViewById(R.id.user_msg);
        updataUserName.setOnClickListener(this);
        updata = (TextView) findViewById(R.id.updata);
        updata.setOnClickListener(this);
        findViewById(R.id.user_head).setOnClickListener(this);
        btnExit = (Button) findViewById(R.id.btnExit);
        btnExit.setOnClickListener(this);
        circleImageView = (CircleImageView) findViewById(R.id.user_head);
        msgTop = (RelativeLayout) findViewById(R.id.msg_top);
        msgTop.setOnClickListener(this);

        isLogin = SharedPreferences.getInstance().getBoolean("isLogin", false);
        System.out.println("isLogin: "+isLogin);
        if (isLogin){
            btnExit.setBackgroundResource(R.color.blue);
            btnExit.setClickable(true);
            btnExit.setEnabled(true);
        } else {
            btnExit.setBackgroundResource(R.color.button_bg);
            btnExit.setClickable(false);
            btnExit.setEnabled(false);
        }
        resetInfo();
    }
    @Override
    public void onRequestPermissionsResult(int permsRequestCode, String[] permissions, int[] grantResults){
        switch(permsRequestCode){
            case 200:
                boolean cameraAccepted = grantResults[0]== PackageManager.PERMISSION_GRANTED;
                if(cameraAccepted){
                    showTakePicture();
                }else{
                    ToastUtils.showShort(this,"您可以在应用管理中打开相应权限");
                }
            break;
        }
    }
    /**
     * 获取相机和SD卡权限
     */
    private void getPermissions(){
        String[] permissions = {Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE};
        PermissionUtils.checkPermissionArray(this, permissions, 200);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_head:
            case R.id.msg_top:
//                showMenuPop();

                //circleImageView.setImageResource(R.mipmap.head1);
                break;
            case R.id.btnExit:
                boolean isLogin = SharedPreferences.getInstance().getBoolean("isLogin", false);
                if (isLogin){
                    ThirdpartyLoginUtils.unLoginForQQ();
                    btnExit.setClickable(true);
                    btnExit.setEnabled(true);
                    SharedPreferences.getInstance().putBoolean("isLogin",false);
                    SharedPreferences.getInstance().remove("account");
                    SharedPreferences.getInstance().remove("password");
                    SharedPreferences.getInstance().remove("nick_name");
                    SharedPreferences.getInstance().remove("user_token");
                    SharedPreferences.getInstance().remove("url");
                    btnExit.setBackgroundResource(R.color.button_bg);
                    btnExit.setClickable(false);
                    btnExit.setEnabled(false);
                    SharedPreferences.getInstance().putInt("headImgIndex",-1);
                    resetInfo();
                    finish();
                    //ToastUtils.makeShortText("退出成功",getApplicationContext());
                }
                //startActivity(new Intent(SettingMsgActivity.this, H5Activity.class));
                break;
            case R.id.user_msg:
                break;
            case R.id.updata:
                checkout();
                break;
        }
    }
    private void checkout(){
        if (old_pw.getText().toString().trim().isEmpty()){
            ToastUtils.makeShortText("旧密码不能为空",getApplicationContext());
            return;
        }
        if (new_pw.getText().toString().trim().isEmpty()){
            ToastUtils.makeShortText("新密码不能为空",getApplicationContext());
            return;
        }
        if (!new_pw_re.getText().toString().trim().equals(new_pw.getText().toString().trim())){
            ToastUtils.makeShortText("两次输入新密码不相同",getApplicationContext());
            return;
        }
        updataUserData(old_pw.getText().toString().trim(),new_pw.getText().toString().trim());
    }
    private void updataUserData(String old_password,String new_password) {
        CardLetterRequestApi.getInstance().updataPassword(Constant.Access_Token,
                SharedPreferences.getInstance().getString("user_token",""),old_password,new_password,new HttpSubscriber<LoginEntity>(new SubscriberOnListener<LoginEntity>() {
            @Override
            public void onSucceed(LoginEntity data) {
                ToastUtils.makeShortText("成功",SettingMsgActivity.this);
            }
            @Override
            public void onError(int code, String msg) {
                ToastUtils.makeShortText("网络故障",SettingMsgActivity.this);
            }
        },SettingMsgActivity.this));


    }

    public void resetInfo() {
        isLogin = SharedPreferences.getInstance().getBoolean("isLogin", false);
        ToastUtils.showShort(this,"================"+isLogin+"  "+SharedPreferences.getInstance().getString("nick_name","")+" "+ SharedPreferences.getInstance().getString("url","")+" ");
        if (isLogin) {
            String name = SharedPreferences.getInstance().getString("nick_name","");
            String url = SharedPreferences.getInstance().getString("url","");
            if ((!url.isEmpty())&&(!url.equals(""))){
                Glide.with(this).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(circleImageView);//设置网络头像
            }else{
                setTingHead();//设置随机头像
            }
        }else {
            circleImageView.setImageResource(R.mipmap.icon_default);
        }

    }
    /**
     * 弹窗选择：相机/相册
     */
    private PopupWindow mPopupWindow;
    private void showMenuPop() {
        View popView = LayoutInflater.from(this).inflate(R.layout.pull_popu_icon, null);
        mPopupWindow = new PopupWindow(popView, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        // 设置允许在外点击消失
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable());
        final Window window = this.getWindow();
        final WindowManager.LayoutParams params = window.getAttributes();
        params.alpha = 0.8F;
        window.setAttributes(params);
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                params.alpha = 1.0F;
                window.setAttributes(params);
            }
        });
        //设置动画
        // mPopupWindow.setAnimationStyle(R.style.anim_bottom_dialog);
        mPopupWindow.setAnimationStyle(android.R.style.Animation_InputMethod);
        popView.findViewById(R.id.tv_camera_album).setOnClickListener(onClickListenerForPop);
        popView.findViewById(R.id.tv_picasso).setOnClickListener(onClickListenerForPop);
        popView.findViewById(R.id.tv_cancel).setOnClickListener(onClickListenerForPop);
        //参数1:根视图，整个Window界面的最顶层View  参数2:显示位置
        mPopupWindow.showAtLocation(window.getDecorView(), Gravity.BOTTOM, 0, 0);
    }

    private View.OnClickListener onClickListenerForPop = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_camera_album:
                    mPopupWindow.dismiss();
                    if (ContextCompat.checkSelfPermission(SettingMsgActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
                            || ContextCompat.checkSelfPermission(SettingMsgActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        showTakePicture();
                    } else {
                        getPermissions();
                    }
                    break;
                case R.id.tv_picasso:
                    mPopupWindow.dismiss();
                    getImageFromAlbum();
                    break;
                case R.id.tv_cancel:
                    mPopupWindow.dismiss();
                    break;
            }
        }
    };
    /**
     * 获取相册中的图片
     */
    private static final int REQUEST_CODE_PICK_IMAGE = 222;
    private static final int REQ_GALLERY = 333;
    private String mPublicPhotoPath;
    public void getImageFromAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");//相片类型
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
    }
    /**
     * 拍照的功能
     */
    private void showTakePicture() {
        startTake();
    }
    /**
     * 拍照
     */
    private void startTake() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //判断是否有相机应用
        if (takePictureIntent.resolveActivity(this.getPackageManager()) != null) {
            //创建临时图片文件
            File photoFile = null;
            try {
                photoFile = PictureUtils.createPublicImageFile();
                mPublicPhotoPath = photoFile.getAbsolutePath();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //设置Action为拍照
            if (photoFile != null) {
                takePictureIntent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                takePictureIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                Uri photoURI = FileProvider.getUriForFile(this, "com.mt.cardletter", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQ_GALLERY);
            }
        }
    }

    /**
     * 设置随机设置头像
     */
    private void setTingHead(){
        Random rand = new Random();
        SharedPreferences sp = SharedPreferences.getInstance();
        int defImgIndex = sp.getInt("headImgIndex", -1);
        if (defImgIndex == -1){
            sp.putInt("headImgIndex",rand.nextInt(6));
        }
        defImgIndex = sp.getInt("headImgIndex", -1);
        circleImageView.setImageResource(headImgID[defImgIndex]);
    }

    @Override
    protected void onResume() {
        super.onResume();
        resetInfo();
    }

    @Override
    public void initListener() { }

    @Override
    protected void initData() { }
    @Override
    protected void handler(Message msg) { }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
