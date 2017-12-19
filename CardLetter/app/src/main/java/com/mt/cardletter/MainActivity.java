package com.mt.cardletter;

import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.RadioGroup;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.mt.cardletter.activity.BaseActivity;
import com.mt.cardletter.app.AppContext;
import com.mt.cardletter.fragment.CardManagerFragment;
import com.mt.cardletter.fragment.DiscoverFragment;
import com.mt.cardletter.fragment.HomeFragment;
import com.mt.cardletter.fragment.IntegralFragment;
import com.mt.cardletter.fragment.MineFragment;
import com.mt.cardletter.service.LocationService;
import com.mt.cardletter.utils.ToastUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private LocationService locationService;

    @Bind({R.id.activity_main_radiogroup})
    RadioGroup radioGroup;

    private HomeFragment homeFragment;
    private IntegralFragment integralFragment;
    private DiscoverFragment discoverFragment;
    private CardManagerFragment cardManagerFragment;
    private MineFragment mineFragment;
    private FragmentManager fragmentManager;
    private Fragment showFragment;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
    }

    @Override
    public void initListener() {
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    protected void initData() {
        homeFragment = new HomeFragment();
        integralFragment = new IntegralFragment();
        discoverFragment = new DiscoverFragment();
        cardManagerFragment = new CardManagerFragment();
        mineFragment = new MineFragment();

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(R.id.activity_main_layout,homeFragment);
        beginTransaction.add(R.id.activity_main_layout,integralFragment);
        beginTransaction.add(R.id.activity_main_layout,discoverFragment);
        beginTransaction.add(R.id.activity_main_layout,cardManagerFragment);
        beginTransaction.add(R.id.activity_main_layout,mineFragment);

        beginTransaction.hide(integralFragment);
        beginTransaction.hide(discoverFragment);
        beginTransaction.hide(cardManagerFragment);
        beginTransaction.hide(mineFragment);
        beginTransaction.commit();
        showFragment = homeFragment;
    }

    @Override
    protected void handler(Message msg) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.hide(showFragment);
        switch (i){
            case R.id.activity_main_radiobutton_home:
                beginTransaction.show(homeFragment);
                showFragment = homeFragment;
                break;
            case R.id.activity_main_radiobutton_integral:
                beginTransaction.show(integralFragment);
                showFragment = integralFragment;
                break;
            case R.id.activity_main_radiobutton_discover:
                beginTransaction.show(discoverFragment);
                showFragment = discoverFragment;
                break;
            case R.id.activity_main_radiobutton_card:
                beginTransaction.show(cardManagerFragment);
                showFragment = cardManagerFragment;
                break;
            case R.id.activity_main_radiobutton_user:
                beginTransaction.show(mineFragment);
                showFragment = mineFragment;
                break;
        }
        beginTransaction.commit();
    }

    /**
     * 再按一次退出程序
     */
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - exitTime > 2000) {
                ToastUtils.showShort(this, "再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /***
     * Stop location service
     */
    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        locationService.unregisterListener(mListener); //注销掉监听
        locationService.stop(); //停止定位服务
        super.onStop();
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        // -----------location config ------------
        locationService = AppContext.getInstance().locationService;
        //获取locationservice实例，建议应用中只初始化1个location实例，然后使用，可以参考其他示例的activity，都是通过此种方式获取locationservice实例的
        locationService.registerListener(mListener);
        //注册监听
        int type = getIntent().getIntExtra("from", 0);
        if (type == 0) {
            locationService.setLocationOption(locationService.getDefaultLocationClientOption());
        } else if (type == 1) {
            locationService.setLocationOption(locationService.getOption());
        }
        locationService.start();// 定位SDK
    }



    /*****
     *
     * 定位结果回调，重写onReceiveLocation方法，可以直接拷贝如下代码到自己工程中修改
     *
     */
    private BDAbstractLocationListener mListener = new BDAbstractLocationListener() {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // TODO Auto-generated method stub
            if (null != location && location.getLocType() != BDLocation.TypeServerError) {
                StringBuffer sb = new StringBuffer(256);
                sb.append("time : ");
                /**
                 * 时间也可以使用systemClock.elapsedRealtime()方法 获取的是自从开机以来，每次回调的时间；
                 * location.getTime() 是指服务端出本次结果的时间，如果位置不发生变化，则时间不变
                 */
                sb.append(location.getTime());
                sb.append("\nlocType : ");// 定位类型
                sb.append(location.getLocType());
                sb.append("\nlocType description : ");// *****对应的定位类型说明*****
                sb.append(location.getLocTypeDescription());
                sb.append("\nlatitude : ");// 纬度
                sb.append(location.getLatitude());
                sb.append("\nlontitude : ");// 经度
                sb.append(location.getLongitude());
                sb.append("\nradius : ");// 半径
                sb.append(location.getRadius());
                sb.append("\nCountryCode : ");// 国家码
                sb.append(location.getCountryCode());
                sb.append("\nCountry : ");// 国家名称
                sb.append(location.getCountry());
                sb.append("\ncitycode : ");// 城市编码
                sb.append(location.getCityCode());
                sb.append("\ncity : ");// 城市
                sb.append(location.getCity());
                sb.append("\nDistrict : ");// 区
                sb.append(location.getDistrict());
                sb.append("\nStreet : ");// 街道
                sb.append(location.getStreet());
                sb.append("\naddr : ");// 地址信息
                sb.append(location.getAddrStr());
                sb.append("\nUserIndoorState: ");// *****返回用户室内外判断结果*****
                sb.append(location.getUserIndoorState());
                sb.append("\nDirection(not all devices have value): ");
                sb.append(location.getDirection());// 方向
                sb.append("\nlocationdescribe: ");
                sb.append(location.getLocationDescribe());// 位置语义化信息
                sb.append("\nPoi: ");// POI信息
                if (location.getPoiList() != null && !location.getPoiList().isEmpty()) {
                    for (int i = 0; i < location.getPoiList().size(); i++) {
                        Poi poi = (Poi) location.getPoiList().get(i);
                        sb.append(poi.getName() + ";");
                    }
                }
                if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
                    sb.append("\nspeed : ");
                    sb.append(location.getSpeed());// 速度 单位：km/h
                    sb.append("\nsatellite : ");
                    sb.append(location.getSatelliteNumber());// 卫星数目
                    sb.append("\nheight : ");
                    sb.append(location.getAltitude());// 海拔高度 单位：米
                    sb.append("\ngps status : ");
                    sb.append(location.getGpsAccuracyStatus());// *****gps质量判断*****
                    sb.append("\ndescribe : ");
                    sb.append("gps定位成功");
                } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
                    // 运营商信息
                    if (location.hasAltitude()) {// *****如果有海拔高度*****
                        sb.append("\nheight : ");
                        sb.append(location.getAltitude());// 单位：米
                    }
                    sb.append("\noperationers : ");// 运营商信息
                    sb.append(location.getOperators());
                    sb.append("\ndescribe : ");
                    sb.append("网络定位成功");
                } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                    sb.append("\ndescribe : ");
                    sb.append("离线定位成功，离线定位结果也是有效的");
                } else if (location.getLocType() == BDLocation.TypeServerError) {
                    sb.append("\ndescribe : ");
                    sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
                } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                    sb.append("\ndescribe : ");
                    sb.append("网络不同导致定位失败，请检查网络是否通畅");
                } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                    sb.append("\ndescribe : ");
                    sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
                }
                String district = location.getDistrict().toString();
                String city = location.getCity().toString();
                if (!district.equals("")||district!=null){
                    AppContext.getInstance().setDistrict(district);
                }else {
                    AppContext.getInstance().setDistrict(city);
                }

                AppContext.getInstance().setCity(city);
            }
        }

    };

}
