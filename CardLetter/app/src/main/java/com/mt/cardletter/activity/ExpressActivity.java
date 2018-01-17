package com.mt.cardletter.activity;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.mt.cardletter.R;
import com.mt.cardletter.entity.express.ExpressCom;
import com.mt.cardletter.entity.express.Express_Content;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.violate_net.ViolateRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.wheeldialog.WheelViewDialog;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Date:2018/1/2
 * Time:19:55
 * author:demons
 */

public class ExpressActivity extends BaseActivity {

    @Bind({R.id.title_name})
    TextView title_name;
    @Bind({R.id.express_com})
    TextView express_com;
    @Bind({R.id.express_order})
    EditText express_order;
    @Bind({R.id.com_back_click})
    FrameLayout back;
    @Bind({R.id.btn_express_search})
    Button search;

//    private List<ExpressCom.ResultBean> stringArrayList = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    private String ex_no="";
    List<ExpressCom.ExpBean> states=new ArrayList();

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_express;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_name.setText("订单查询");
        back.setVisibility(View.VISIBLE);
//        for (int i = 0; i < 15; i++) {
//            stringArrayList.add("item " + i);
//        }
//        getDatas();
        states=getStates(this);
        if (states.size()>0){
            for (int i = 0;i<states.size();i++){
                list.add(states.get(i).getCom());
            }
        }else {

        }
    }

    private void getDatas() {
//        ViolateRequestApi.getInstance().getExpressCom(Constant.JH_KEY,new HttpSubscriber<ExpressCom>(new SubscriberOnListener<ExpressCom>() {
//            @Override
//            public void onSucceed(ExpressCom data) {
//                if (data.getError_code()==0){
//                    stringArrayList=data.getResult();
//                    for (int i = 0;i<stringArrayList.size();i++){
//                        list.add(data.getResult().get(i).getCom());
//                    }
//                }else {
//                    ToastUtils.makeShortText(data.getReason(),ExpressActivity.this);
//                }
//            }
//
//            @Override
//            public void onError(int code, String msg) {
//            }
//        },ExpressActivity.this));
    }

    public List<ExpressCom.ExpBean> getStates(Context context) {
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            is = context.getAssets().open("express.json");
            bos = new ByteArrayOutputStream();
            byte[] bytes = new byte[4 * 1024];
            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }
            final String json = new String(bos.toByteArray());
            final ExpressCom areas = JSON.parseObject(json, ExpressCom.class);
            states = areas.getExp();
            return states;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
            }
        }
        return null;
    }

    @Override
    public void initListener() {
        express_com.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                if (states.size()>0){
                    showWheelDialog();
                }else {
                    ToastUtils.makeShortText("为获取到快递公司",ExpressActivity.this);
                }
            }
        });

        search.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                showSearchResult();
            }
        });

    }

    private void showSearchResult() {
        String ex_order = express_order.getText().toString();
        if (checkInput(ex_no,ex_order)){
            System.out.println("----"+ex_no+"\n"+ex_order);
            ViolateRequestApi.getInstance().getExpressContent(Constant.JH_KEY,ex_no,ex_order,
                    new HttpSubscriber<Express_Content>(new SubscriberOnListener<Express_Content>() {
                @Override
                public void onSucceed(Express_Content data) {
                    if (data.getError_code()==0){
                        UIHelper.showExpressDetailActivity(ExpressActivity.this,data.getResult());
                    }else {
                        ToastUtils.makeShortText(data.getReason(),ExpressActivity.this);
                    }
                }

                @Override
                public void onError(int code, String msg) {

                }
            },ExpressActivity.this));
        }
    }

    private void showWheelDialog() {
        WheelViewDialog dialog = new WheelViewDialog( ExpressActivity.this, states ,list);
        dialog.setOnSelectedListener(new WheelViewDialog.OnSelectedListener() {
            @Override
            public void getData(String data,String no) {
                express_com.setText( data );
                ex_no=no;
            }
        });
        dialog.show();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void handler(Message msg) {

    }

    /**
     * 检查注册输入的内容
     */
    public boolean checkInput(String no, String order) {
        if (no.equals("")) {
            ToastUtils.showShort(this, "请选择快递公司");
        }
        else if (TextUtils.isEmpty(order)) {
            ToastUtils.showShort(this, "请输入订单号");
        } else {
            return true;
        }
        return false;
    }
}
