package com.mt.cardletter.activity;

import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.data.Peccant;
import com.mt.cardletter.entity.data.ViolateCity;
import com.mt.cardletter.entity.data.ViolateData;
import com.mt.cardletter.https.HttpSubscriber;
import com.mt.cardletter.https.SubscriberOnListener;
import com.mt.cardletter.https.test.PeccantRequestApi;
import com.mt.cardletter.https.violate_net.ViolateRequestApi;
import com.mt.cardletter.utils.Constant;
import com.mt.cardletter.utils.OnMultiClickListener;
import com.mt.cardletter.utils.RegexUtils;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.citydialog.ProvinceCallBack;
import com.mt.cardletter.view.citydialog.ProvincehDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 违章查询
 * Date:2017/12/21
 * Time:16:51
 * author:demons
 */

public class ViolateActivity extends BaseActivity implements ProvinceCallBack{

    @Bind({R.id.title_name})
    TextView title_name;
    @Bind({R.id.com_back_click})
    FrameLayout com_back_click;
    @Bind({R.id.set_address_value})
    LinearLayout set_address_value;
    @Bind({R.id.province_value})
    TextView province_value;
    @Bind({R.id.chose_city_txt})
    TextView chose_city_txt;
    @Bind({R.id.city_value})
    TextView city_value;
    @Bind({R.id.card_arr_value})
    TextView card_arr_value;
    @Bind({R.id.card_editText})
    EditText card_editText;
    @Bind({R.id.fdj_editText})
    TextView fdj_editText;
    @Bind({R.id.btn_search})
    Button btn_search;
//    @Bind({R.id.violae_listview})
//    RecyclerView violae_listview;

    private String key = "fa86b8fc6cf00777395ae0748a4e5ac3";

    private List<ViolateCity.ViolateAllCity> result = new ArrayList<>();

    private String mProvince = "北京";;
    private String mCity = "北京";
    private String mCode = "BJ";
    private String mAbbr = "京";

    private List<ViolateData.ResultBean.ListsBean> violate_list = new ArrayList<>();

    @Override
    protected int getLayoutResId() {
        getCityData();
        return R.layout.activity_violate;
    }
    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_name.setText("违章查询");
        com_back_click.setVisibility(View.VISIBLE);
        //// TODO: 2018/1/17
//        loadData();
    }

    @Override
    public void initListener() {
        set_address_value.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                showCityChoiseView();
            }
        });

        btn_search.setOnClickListener(new OnMultiClickListener() {
            @Override
            public void onMultiClick(View v) {
                String car_number = card_editText.getText().toString();
                String car_fdj = fdj_editText.getText().toString();
                String full_number = mAbbr+car_number;
                if (checkInput(car_number,full_number,car_fdj)){
//                    btn_search.setClickable(true);
//                    btn_search.setEnabled(true);
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                        btn_search.setBackground(getResources().getDrawable(R.color.color_btn_red_de));
//                    }
                    ViolateRequestApi.getInstance().getViolates("","",mCode,full_number,car_fdj,car_fdj, Constant.JH_CAR,
                            new HttpSubscriber<ViolateData>(new SubscriberOnListener<ViolateData>() {
                        @Override
                        public void onSucceed(ViolateData data) {
                            if (data.getError_code()==0){
                                violate_list=data.getResult().getLists();
                                UIHelper.showViolateDetailActivity(ViolateActivity.this,violate_list);
                            }else {
                                ToastUtils.makeShortText(data.getReason(),ViolateActivity.this);
                            }
                        }

                        @Override
                        public void onError(int code, String msg) {

                        }
                    },ViolateActivity.this));
//                }else {
//                    btn_search.setClickable(false);
//                    btn_search.setEnabled(false);
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                        btn_search.setBackgroundColor(getResources().getColor(R.color.gray_d1d1d1));
//                    }
                }
            }
        });
    }
    private void loadData() {
       /*
         * 获取文章分类列表
         */
        PeccantRequestApi.getInstance().getPeccant("APPCODE 4be7846862f141bab64b37897447ea56","苏AE4D00","","0306ps","","",new HttpSubscriber<Peccant>(new SubscriberOnListener<Peccant>() {
            @Override
            public void onSucceed(Peccant data) {
                System.out.println("jk========:"+data.getData().getTotalFine());
            }
            @Override
            public void onError(int code, String msg) {
                ToastUtils.showShort(ViolateActivity.this,"网络故障");
            }
        },ViolateActivity.this));
    }

    /**
     * 检查注册输入的内容
     */
    public boolean checkInput(String car_num,String full_number, String car_fdj) {
        if (TextUtils.isEmpty(car_num)) {
            ToastUtils.showShort(this, "请输入车牌号");
        }
        else if (!RegexUtils.isCarnumberNO(full_number)) {
            ToastUtils.showShort(this, "输入的车牌号有误");
        }
        else if (car_fdj.length() < 6 || car_fdj.length() > 6 || TextUtils.isEmpty(car_fdj)) {
            ToastUtils.showShort(this, "请输入发动机号后六位");
        } else {
            return true;
        }
        return false;
    }



    @Override
    protected void initData() {

    }

    @Override
    protected void handler(Message msg) {

    }

    private void showCityChoiseView() {
        ProvincehDialog branchDialog = ProvincehDialog.newInstance();
        branchDialog.setDatas(result);
        branchDialog.setAddress(mProvince,mCity);
        branchDialog.show(getSupportFragmentManager());
    }

//获取可用城市
    private void getCityData() {
        ViolateRequestApi.getInstance().getCitys("","",Constant.JH_CAR,new HttpSubscriber<ViolateCity>(new SubscriberOnListener<ViolateCity>() {
            @Override
            public void onSucceed(ViolateCity data) {
                if (data.getError_code() == 0){
                    result=data.getResult();
                    String province = result.get(3).getProvince();
                    String citys = result.get(3).getCitys().get(0).getCity_name();
                    System.out.println("-------result--------"+province+"\n"+citys);
                }else {
                    ToastUtils.makeShortText(data.getReason(),ViolateActivity.this);
                }
            }

            @Override
            public void onError(int code, String msg) {

            }
        },this));
    }

    @Override
    public void onWhellFinish(String province, String city,String code,String abbr) {
        mProvince = province;
        mCity = city;
        mCode = code;
        mAbbr = abbr;
        province_value.setText(province);
        city_value.setText(city);

        card_arr_value.setText(abbr);
    }
}
