package com.mt.cardletter.activity.setting;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.BaseActivity;
import com.mt.cardletter.utils.PermissionUtils;
import com.mt.cardletter.utils.PictureUtils;
import com.mt.cardletter.utils.ToastUtils;
import java.io.File;
import java.io.IOException;
import de.hdodenhof.circleimageview.CircleImageView;
import test.abc.H5Activity;

/**
 *  jk - 修改文件
 */
public class  SettingMsgActivity  extends  BaseActivity  implements  View.OnClickListener {
    private LinearLayout pwLinearLayout;
    private ImageView img;
    private CircleImageView circleImageView;
    private RelativeLayout msgTop;
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_setting_msg;
    }

    @Override
    public void initView() {
        findViewById(R.id.msg_updata_pw).setOnClickListener(this);
        pwLinearLayout = (LinearLayout) findViewById(R.id.updata_password);
        img = (ImageView) findViewById(R.id.msg_updata_pw_img);
        findViewById(R.id.user_head).setOnClickListener(this);
        findViewById(R.id.msg_commit).setOnClickListener(this);
        circleImageView = (CircleImageView) findViewById(R.id.user_head);

        msgTop = (RelativeLayout) findViewById(R.id.msg_top);
        msgTop.setOnClickListener(this);
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
            case R.id.msg_updata_pw:
                if (pwLinearLayout.getVisibility() == View.VISIBLE) {
                    pwLinearLayout.setVisibility(View.GONE);
                    img.setImageResource(R.mipmap.next);
                } else if (pwLinearLayout.getVisibility() == View.GONE) {
                    pwLinearLayout.setVisibility(View.VISIBLE);
                    img.setImageResource(R.mipmap.drow_icon);
                }
                break;
            case R.id.user_head:
            case R.id.msg_top:
                showMenuPop();
                break;
            case R.id.msg_commit:
                startActivity(new Intent(SettingMsgActivity.this, H5Activity.class));
                break;
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
    private Uri uri;
    String path;
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            //拍照
            case REQ_GALLERY:
                if (resultCode != Activity.RESULT_OK) return;
                uri = Uri.parse(mPublicPhotoPath);
                path = uri.getPath();
                break;
            //获取相册的图片
            case REQUEST_CODE_PICK_IMAGE:
                if (data == null) return;
                uri = data.getData();
                int sdkVersion = Integer.valueOf(Build.VERSION.SDK);
                if (sdkVersion >= 19) {
                    path = this.uri.getPath();
                    path = PictureUtils.getPath_above19(this, this.uri);
                } else {
                    path = PictureUtils.getFilePath_below19(this, this.uri);
                }
                break;
        }
        circleImageView.setImageBitmap(PictureUtils.getSmallBitmap(path, 100, 100));
    }
    @Override
    public void initListener() { }

    @Override
    protected void initData() { }
    @Override
    protected void handler(Message msg) { }
}
