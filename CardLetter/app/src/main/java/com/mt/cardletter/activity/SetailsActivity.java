package com.mt.cardletter.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.mt.cardletter.R;
import com.mt.cardletter.activity.base.BaseActivity;
import com.mt.cardletter.db.dbuitls.DBCreate;
import com.mt.cardletter.db.tables.BankTable;
import com.mt.cardletter.entity.collect.Collect;
import com.mt.cardletter.entity.merchant.Good;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.base_net.CardLetterRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.SharedPreferences;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.utils.file.FileStorage;
import com.mt.cardletter.utils.file.FileUtils;
import com.mt.cardletter.utils.file.ImageUtils;
import com.mt.cardletter.utils.start.StartWithoutAppUtil;
import com.mt.cardletter.view.Scroll.TopScrollView;

import org.litepal.crud.DataSupport;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.onekeyshare.ShareContentCustomizeCallback;

/**
 * 商品详情
 */
public class SetailsActivity extends BaseActivity implements View.OnClickListener {
    private FrameLayout com_back_click;
    private TextView title_name;
    private TextView next;
    //private ImageView setails_back,setails_share;
    private TextView setails_title, setails_time, setails_tel, setails_address, setails_obj, setails_centent, setails_discounts;
    private ImageView bigImg, item_bank;
    private RelativeLayout collect;
    private GoogleApiClient client;

    private ImageView collect_img;
    private TextView collect_text;
    private Good good;
    private String cardfind_id;
    private String title;
    private LinearLayout setails_img, setails_pl,setails_photo;
    private GoogleApiClient client2;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_setails;
    }

    @Override
    public void initView() {
//        Uri uri = getIntent().getData();
//        if (uri != null){
//            String uri_cardfind_id = uri.getQueryParameter("cardfind_id");
//            cardfind_id = uri_cardfind_id;
//            System.out.println("jks-----"+cardfind_id);
//        }
        title_name = (TextView) findViewById(R.id.title_name);
        title_name.setText("商家详情");
        com_back_click = (FrameLayout) findViewById(R.id.com_back_click);
        com_back_click.setVisibility(View.VISIBLE);
        next = (TextView) findViewById(R.id.commonal_tv);
        next.setVisibility(View.VISIBLE);
        next.setText("分享");
        next.setTextColor(getResources().getColor(R.color.white));
        next.setOnClickListener(new OnMultiClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onMultiClick(View v) {
                System.out.println("jks------showShare");
                showShare();
                //jurisdiction();//权限申请  分享入口
                //startActivity(new Intent(SetailsActivity.this, ShareActivity.class));
            }
        });
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setails_title = (TextView) findViewById(R.id.setails_title);
        setails_time = (TextView) findViewById(R.id.setails_dateline);
        setails_tel = (TextView) findViewById(R.id.setails_tel);
        setails_address = (TextView) findViewById(R.id.setails_address);
        setails_obj = (TextView) findViewById(R.id.setails_obj);
        setails_centent = (TextView) findViewById(R.id.setails_centent);
        setails_discounts = (TextView) findViewById(R.id.setails_discounts);
        bigImg = (ImageView) findViewById(R.id.setails_big_img);
        item_bank = (ImageView) findViewById(R.id.item_img);
        cardfind_id = getIntent().getStringExtra("cardfind_id");
        if (cardfind_id != null) {
            loadDataForGood(cardfind_id);
        }
        collect = (RelativeLayout) findViewById(R.id.collection);
        collect_img = (ImageView) findViewById(R.id.pic_one);
        collect_text = (TextView) findViewById(R.id.pic_tow);
        collect.setOnClickListener(this);

        setails_img = (LinearLayout) findViewById(R.id.setails_img);
        setails_img.setOnClickListener(this);
        setails_pl = (LinearLayout) findViewById(R.id.setails_pl);
        setails_pl.setOnClickListener(this);
        setails_photo = (LinearLayout) findViewById(R.id.setails_photo);
        setails_photo.setOnClickListener(this);
       // top = (TopScrollView) findViewById(R.id.setails_top);

    }

    private void loadDataForGood(String cardfind_id) {
        String member_id = SharedPreferences.getInstance().getString("member_id", "");
        /*
         * 获取商家列表
         */
        CardLetterRequestApi.getInstance().getGoodDetails(Constant.Access_Token, cardfind_id, member_id, new HttpSubscriber<Good>(new SubscriberOnListener<Good>() {
            @Override
            public void onSucceed(Good data) {
                if (data != null) {
                    good = data;
                    updataView(good);
                }
            }

            @Override
            public void onError(int code, String msg) {
                ToastUtils.showShort(SetailsActivity.this, "网络故障");
            }
        }, SetailsActivity.this));
    }

    private void updataView(Good good) {
        if (good != null) {
            title = good.getName();
            setails_title.setText(title);
            setails_time.setText(good.getDeadline());
            setails_tel.setText(good.getTel());
            setails_address.setText(good.getAddress());
            setails_centent.setText(good.getContent());
            setails_discounts.setText(good.getDescribe());
            Glide.with(this).load(Constant.BASE_URL + good.getThumb()).error(R.drawable.default_error).into(bigImg);
            if (good.getData() == 1) {
                isSelect = true;
                collect_img.setImageResource(R.drawable.collected_select);
                collect_text.setText("已收藏");
            } else if (good.getData() == 0) {
                isSelect = false;
                collect_img.setImageResource(R.mipmap.collect);
                collect_text.setText("收藏");
            }

            //（4）读取数据库
            BankTable bankTable1 = DBCreate.selectBankById(good.getBankcard());

            setails_obj.setText(bankTable1.getName());
            Glide.with(this).load(Constant.BASE_URL + bankTable1.getCardThumb()).error(R.drawable.default_error).into(item_bank);
        }
    }

    @Override
    protected void initData() {

    }

    private boolean isSelect = false;

    @Override
    public void onClick(View v) {
        boolean isLogin = SharedPreferences.getInstance().getBoolean("isLogin", false);
        String member_id = SharedPreferences.getInstance().getString("member_id", "");
        switch (v.getId()) {
            case R.id.collection:
                if (!isLogin) {
                    UIHelper.showLoginActivity(this);
                } else {
                    if (!isSelect) {
                        // TODO: 2018/1/16 收藏
                        String fvalue = "https://www.51kaxin.xyz/api.php/cardfind/cardfindinfo/access_token/" + Constant.Access_Token + "/cardfind_id/" + cardfind_id;
                        System.out.println("jk-----" + title + "---" + member_id + "-----" + cardfind_id + "------" + fvalue);
                        addFavorite(title, member_id, cardfind_id, fvalue);
                    } else {
                        // TODO: 2018/1/16 取消收藏
                        delFavorite(cardfind_id, member_id);
                    }
                }
                break;
            case R.id.setails_img:
                // TODO: 2018/2/27 :拍照入口
                checkPremission();//检测权限
                break;
            case R.id.setails_photo:
                // TODO: 2018/2/27 :相册入口
                getPicture();//相册
                break;
            case R.id.setails_pl:
                // TODO: 2018/3/1 :评论入口
                //UIHelper.showCommentActivity(this);
                //StartWithoutAppUtil.doStartApplicationWithPackageName(this,"","------");//启动第三方app

                ToastUtils.makeShortText("TEST ACTIVITY FOR 待开发",getApplication());
                break;
        }
    }
    //=============图片上传==================
    private static final int CAMERA_REQUEST_CODE = 1;
    private static final int REQUEST_CAPTURE = 2;
    private static final int REQUEST_PICTURE = 5;
    private static final int REVERSAL_LEFT = 3;
    private static final int REVERSAL_UP = 4;
    private Uri imageUri;
    private Uri localUri = null;
    private void checkPremission() {
        final String permission = Manifest.permission.CAMERA;  //相机权限
        final String permission1 = Manifest.permission.WRITE_EXTERNAL_STORAGE; //写入数据权限
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, permission1) != PackageManager.PERMISSION_GRANTED) {  //先判断是否被赋予权限，没有则申请权限
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {  //给出权限申请说明
                ActivityCompat.requestPermissions(SetailsActivity.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, CAMERA_REQUEST_CODE);
            } else { //直接申请权限
                ActivityCompat.requestPermissions(SetailsActivity.this, new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST_CODE); //申请权限，可同时申请多个权限，并根据用户是否赋予权限进行判断
            }
        } else {  //赋予过权限，则直接调用相机拍照
            openCamera();
        }
    }
    private void openCamera() {  //调用相机拍照
        Intent intent = new Intent();
        File file = new FileStorage().createIconFile(); //工具类
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {  //针对Android7.0，需要通过FileProvider封装过的路径，提供给外部调用
            imageUri = FileProvider.getUriForFile(SetailsActivity.this, "com.mt.cardletter", file);//通过FileProvider创建一个content类型的Uri，进行封装
        } else { //7.0以下，如果直接拿到相机返回的intent值，拿到的则是拍照的原图大小，很容易发生OOM，所以我们同样将返回的地址，保存到指定路径，返回到Activity时，去指定路径获取，压缩图片
            try {
                imageUri = Uri.fromFile(ImageUtils.createFile(FileUtils.getInst().getPhotoPathForLockWallPaper(), true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);//设置Action为拍照
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);//将拍取的照片保存到指定URI
        startActivityForResult(intent, REQUEST_CAPTURE);//启动拍照
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {  //申请权限的返回值
            case CAMERA_REQUEST_CODE:
                int length = grantResults.length;
                final boolean isGranted = length >= 1 && PackageManager.PERMISSION_GRANTED == grantResults[length - 1];
                if (isGranted) {  //如果用户赋予权限，则调用相机
                    openCamera();
                }else{ //未赋予权限，则做出对应提示

                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CAPTURE:
                    if (null != imageUri) {
                        localUri = imageUri;
                        Glide.with(this).load(localUri).error(R.drawable.default_error).into(item_bank);
                        //setBitmap(localUri);//获取拍照并自定义保存地址的照片
                    }
                    break;
                case REQUEST_PICTURE:
                    if (data.getData()!=null) {
                        localUri = data.getData();
                        Glide.with(this).load(localUri).error(R.drawable.default_error).into(item_bank);
                        //setBitmap(localUri);  //获取相册选择的照片

                    }
                    break;
            }
        }
    }

    private void getPicture() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_PICTURE);
    }
    //=============  end   ==================



    /**
     * 添加收藏
     */
    // TODO: 2018/1/24 等待接口
    private void addFavorite(String title_name, String member_id, String name_id, String fvalue) {
        CardLetterRequestApi.getInstance().addFavorite(title_name, member_id, name_id, fvalue, new HttpSubscriber<Collect>(new SubscriberOnListener<Collect>() {
            @Override
            public void onSucceed(Collect data) {
                if (data.getCode() == 0) {
                    collect_img.setImageResource(R.drawable.collected_select);
                    collect_text.setText("已收藏");
                    ToastUtils.makeShortText("已收藏", SetailsActivity.this);
                    isSelect = true;
                }
            }

            @Override
            public void onError(int code, String msg) {
                System.out.println("jk----Collect--" + msg);
                ToastUtils.showShort(SetailsActivity.this, "网络故障");
            }
        }, SetailsActivity.this));
    }

    /**
     * 删除收藏
     */
    private void delFavorite(String name_id, String member_id) {
        CardLetterRequestApi.getInstance().delFavorite(name_id, member_id, new HttpSubscriber<Collect>(new SubscriberOnListener<Collect>() {
            @Override
            public void onSucceed(Collect data) {
                if (data.getCode() == 0) {
                    collect_img.setImageResource(R.mipmap.collect);
                    collect_text.setText("收藏");
                    ToastUtils.makeShortText("已取消收藏", SetailsActivity.this);
                    isSelect = false;
                }
            }

            @Override
            public void onError(int code, String msg) {
                ToastUtils.showShort(SetailsActivity.this, "网络故障");
            }
        }, SetailsActivity.this));
    }

    @Override
    public void initListener() {

    }


    @Override
    protected void handler(Message msg) {

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        final String url1 = "http://www.51kaxin.xyz/share.html?id=" + good.getId();
        System.out.println("jks---" + url1);
        final String img_url = Constant.BASE_URL + good.getThumb();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        oks.setShareContentCustomizeCallback(new ShareContentCustomizeCallback() {
            @Override
            public void onShare(Platform platform, Platform.ShareParams paramsToShare) {
                if ("SinaWeibo".equals(platform.getName())) {
                    paramsToShare.setText(good.getName());
                    paramsToShare.setUrl(url1);
                    paramsToShare.setImageUrl(img_url);
                }
                if ("Wechat".equals(platform.getName())) {
                    paramsToShare.setTitle(good.getName());
                    paramsToShare.setUrl(url1);
                    paramsToShare.setText(good.getDescribe());
                    paramsToShare.setImageUrl(img_url);
                    paramsToShare.setShareType(Platform.SHARE_WEBPAGE);
                }
                if ("WechatMoments".equals(platform.getName())) {
                    paramsToShare.setTitle(good.getName());
                    paramsToShare.setUrl(url1);
                    paramsToShare.setText(good.getDescribe());
                    paramsToShare.setImageUrl(img_url);
                    paramsToShare.setShareType(Platform.SHARE_WEBPAGE);
                }
                if ("QQ".equals(platform.getName())) {
                    paramsToShare.setTitle(good.getName());
                    paramsToShare.setTitleUrl(url1);
                    paramsToShare.setText(good.getDescribe());
                    paramsToShare.setImageUrl(img_url);
                    System.out.println("jks------showShare");
                }
                if ("QZone".equals(platform.getName())) {
                    paramsToShare.setTitle(good.getName());
                    paramsToShare.setTitleUrl(url1);
                    paramsToShare.setText(good.getDescribe());
                    paramsToShare.setImageUrl(img_url);
                }
            }
        });

        oks.setCallback(new PlatformActionListener() {
            @Override
            public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                Log.d("ShareLogin", "onComplete ---->  分享成功");
                platform.getName();
            }

            @Override
            public void onError(Platform platform, int i, Throwable throwable) {
                Log.d("ShareLogin", "onError ---->  失败" + throwable.getStackTrace().toString());
                Log.d("ShareLogin", "onError ---->  失败" + throwable.getMessage());
            }

            @Override
            public void onCancel(Platform platform, int i) {
                Log.d("ShareLogin", "onCancel ---->  分享取消");
            }
        });
        // 启动分享GUI
        oks.show(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2 = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Setails Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client2.connect();
        AppIndex.AppIndexApi.start(client2, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client2, getIndexApiAction());
        client2.disconnect();
    }
}
