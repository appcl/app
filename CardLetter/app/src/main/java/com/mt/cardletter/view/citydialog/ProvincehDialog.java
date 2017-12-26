package com.mt.cardletter.view.citydialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.data.ProvinceCity;
import com.mt.cardletter.entity.data.ViolateCity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import kankan.wheel.widget.OnWheelChangedListener;
import kankan.wheel.widget.OnWheelScrollListener;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.AbstractWheelTextAdapter;

public class ProvincehDialog extends BaseDialog {
    @Bind(R.id.wv_province)
    WheelView mWvProvince;
    @Bind(R.id.wv_city)
    WheelView mWvCity;

    private int maxsize = 24;
    private int minsize = 14;
    private ArrayList<ProvinceCity> arrProvinces = new ArrayList<>();
    private ArrayList<ProvinceCity.Citys_> arrCitys = new ArrayList<>();
    private AddressPrTextAdapter provinceAdapter;
    private AddressCtTextAdapter cityAdapter;
    private String strProvince = "北京";
    private String strCity = "北京";
    private int selColor;
    private int unSelColor;
    private ProvinceCallBack mListener;
    private List<ViolateCity.ViolateAllCity> provinceCityLists;
    private String city_code = "BJ";
    private String city_abbr = "京";

    public static ProvincehDialog newInstance() {
        ProvincehDialog dialog = new ProvincehDialog();
        return dialog;
    }

    public void setDatas(List<ViolateCity.ViolateAllCity> provinceCityLists){
        this.provinceCityLists = provinceCityLists;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (ProvinceCallBack) activity;
    }

    @Override
    protected int onGetStyle() {
        return R.style.transparent_dialog;
    }

    @OnClick(R.id.layout_wheel_top)
    public void topClick(View v) {
        dissmissDialog();
    }

    @OnClick(R.id.iv_wheel_ok)
    public void okClick(View v) {
        strProvince = (String) provinceAdapter.getItemText(mWvProvince.getCurrentItem());
        strCity = (String) cityAdapter.getItemText(mWvCity.getCurrentItem());
        city_code = arrCitys.get(mWvCity.getCurrentItem()).getCity_code();
        city_abbr = arrCitys.get(mWvCity.getCurrentItem()).getCity_abbr();
        mListener.onWhellFinish(strProvince, strCity,city_code,city_abbr);
        System.out.println("----选择的城市是：---"+mWvProvince.getCurrentItem()+"\n"+mWvCity.getCurrentItem()+"\n"+city_code+"\n"+city_abbr);
        dismiss();
    }

    ProvinceCity pc ;
    private void initData() {
        if (provinceCityLists != null && !provinceCityLists.isEmpty()) {
            for (ViolateCity.ViolateAllCity provinceCity : provinceCityLists) {
                pc = new ProvinceCity();
                pc.setProvince(provinceCity.getProvince());
                arrProvinces.add(pc);
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        getDialog().getWindow().setLayout(dm.widthPixels, getDialog().getWindow().getAttributes().height);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void onDialogCreated(Dialog dialog) {
        selColor = getResources().getColor(R.color.color_wheel_sel);
        unSelColor = getResources().getColor(R.color.color_wheel_unsel);
        initData();
        provinceAdapter = new AddressPrTextAdapter(mContext, arrProvinces, getProvinceItem(strProvince), maxsize, minsize);
        mWvProvince.setVisibleItems(5);
        mWvProvince.setViewAdapter(provinceAdapter);
        mWvProvince.setCurrentItem(getProvinceItem(strProvince));
        mWvProvince.setShadowColor(Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT);
        mWvProvince.setWheelBackground(R.drawable.province_wheel_bg);
        mWvProvince.setWheelForeground(R.drawable.province_wheel_val);
        mWvProvince.post(new Runnable() {

            @Override
            public void run() {
                String currentText = (String) provinceAdapter.getItemText(mWvProvince.getCurrentItem());
                setTexprtviewSize(currentText, provinceAdapter);
            }
        });

        initCitys(strProvince);
        cityAdapter = new AddressCtTextAdapter(mContext, arrCitys, getCityItem(strCity), maxsize, minsize);
        mWvCity.setVisibleItems(5);
        mWvCity.setViewAdapter(cityAdapter);
        mWvCity.setCurrentItem(getCityItem(strCity));
        mWvCity.setShadowColor(Color.TRANSPARENT, Color.TRANSPARENT, Color.TRANSPARENT);
        mWvCity.setWheelBackground(R.drawable.province_wheel_bg);
        mWvCity.setWheelForeground(R.drawable.province_wheel_val);
        mWvCity.post(new Runnable() {

            @Override
            public void run() {
                String currentText = (String) cityAdapter.getItemText(mWvCity.getCurrentItem());
                setTextviewSize(currentText, cityAdapter);
            }
        });

        mWvProvince.addChangingListener(new OnWheelChangedListener() {

            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                String currentText = (String) provinceAdapter.getItemText(wheel.getCurrentItem());
                strProvince = currentText;
                setTexprtviewSize(currentText, provinceAdapter);
                initCitys(currentText);
                cityAdapter = new AddressCtTextAdapter(mContext, arrCitys, 0, maxsize, minsize);
                mWvCity.setVisibleItems(5);
                mWvCity.setCurrentItem(0);
                String currentCityText = (String) cityAdapter.getItemText(mWvCity.getCurrentItem());
                setTextviewSize(currentCityText, cityAdapter);
                mWvCity.setViewAdapter(cityAdapter);
            }
        });

        mWvProvince.addScrollingListener(new OnWheelScrollListener() {

            @Override
            public void onScrollingStarted(WheelView wheel) {
            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                String currentText = (String) provinceAdapter.getItemText(wheel.getCurrentItem());
                setTexprtviewSize(currentText, provinceAdapter);
            }
        });

        mWvCity.addChangingListener(new OnWheelChangedListener() {

            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                String currentText = (String) cityAdapter.getItemText(wheel.getCurrentItem());
                strCity = currentText;
                setTextviewSize(currentText, cityAdapter);
            }
        });

        mWvCity.addScrollingListener(new OnWheelScrollListener() {

            @Override
            public void onScrollingStarted(WheelView wheel) {
            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                String currentText = (String) cityAdapter.getItemText(wheel.getCurrentItem());
                setTextviewSize(currentText, cityAdapter);
            }
        });

    }

    @Override
    protected int onGetDialogViewId() {
        return R.layout.dialog_province;
    }

    private class AddressPrTextAdapter extends AbstractWheelTextAdapter {
        List<ProvinceCity> list;

        protected AddressPrTextAdapter(Context context, List<ProvinceCity> list, int currentItem, int maxsize, int minsize) {
            super(context, R.layout.item_view, NO_RESOURCE, currentItem, maxsize, minsize, selColor, unSelColor);
            this.list = list;
            setItemTextResource(R.id.tempValue);
        }

        @Override
        public View getItem(int index, View cachedView, ViewGroup parent) {
            View view = super.getItem(index, cachedView, parent);
            return view;
        }

        @Override
        public int getItemsCount() {
            return list.size();
        }

        @Override
        protected CharSequence getItemText(int index) {
            return list.get(index).getProvince() + "";
        }
    }

    private class AddressCtTextAdapter extends AbstractWheelTextAdapter {
        List<ProvinceCity.Citys_> list;

        protected AddressCtTextAdapter(Context context, List<ProvinceCity.Citys_> list, int currentItem, int maxsize, int minsize) {
            super(context, R.layout.item_view, NO_RESOURCE, currentItem, maxsize, minsize, selColor, unSelColor);
            this.list = list;
            setItemTextResource(R.id.tempValue);
        }

        @Override
        public View getItem(int index, View cachedView, ViewGroup parent) {
            View view = super.getItem(index, cachedView, parent);
            return view;
        }

        @Override
        public int getItemsCount() {
            return list.size();
        }

        @Override
        protected CharSequence getItemText(int index) {
            return list.get(index).getCity_name() + "";
        }


    }

    /**
     * 设置字体大小
     *
     * @param curriteItemText
     * @param adapter
     */
    public void setTexprtviewSize(String curriteItemText, AddressPrTextAdapter adapter) {
        ArrayList<View> arrayList = adapter.getTestViews();
        int size = arrayList.size();
        String currentText;
        for (int i = 0; i < size; i++) {
            TextView textvew = (TextView) arrayList.get(i);
            currentText = textvew.getText().toString();
            if (curriteItemText.equals(currentText)) {
                textvew.setTextSize(24);
                textvew.setTextColor(selColor);
            } else {
                textvew.setTextSize(14);
                textvew.setTextColor(unSelColor);
            }
        }
    }

    /**
     * 设置字体大小
     *
     * @param curriteItemText
     * @param adapter
     */
    public void setTextviewSize(String curriteItemText, AddressCtTextAdapter adapter) {
        ArrayList<View> arrayList = adapter.getTestViews();
        int size = arrayList.size();
        String currentText;
        for (int i = 0; i < size; i++) {
            TextView textvew = (TextView) arrayList.get(i);
            currentText = textvew.getText().toString();
            if (curriteItemText.equals(currentText)) {
                textvew.setTextSize(24);
                textvew.setTextColor(selColor);
            } else {
                textvew.setTextSize(14);
                textvew.setTextColor(unSelColor);
            }
        }
    }

    /**
     * 根据省找到市
     *
     * @param provinces
     */
    ProvinceCity.Citys_ ct ;
    private void initCitys(String province) {
        arrCitys.clear();
        for (ViolateCity.ViolateAllCity provinceCity : provinceCityLists) {
            if (provinceCity.getProvince().equals(province)) {
                List<ViolateCity.Citys> citys = provinceCity.getCitys();
                if (citys != null && !citys.isEmpty()) {
                    for (ViolateCity.Citys city: citys) {
                        ct = new ProvinceCity.Citys_();
                        ct.setCity_name(city.getCity_name());
                        ct.setCity_code(city.getCity_code());
                        ct.setCity_abbr(city.getAbbr());
                        arrCitys.add(ct);
                    }
                }
            }
        }
    }

    /**
     * 初始化地点
     *
     * @param province
     * @param city
     */
    public void setAddress(String province, String city) {
        if (!TextUtils.isEmpty(province)) {
            this.strProvince = province;
        }
        if (!TextUtils.isEmpty(city)) {
            this.strCity = city;
        }
    }

    /**
     * 返回省会索引
     *
     * @param province
     * @return
     */
    public int getProvinceItem(String province) {
        int size = arrProvinces.size();
        int provinceIndex = 0;
        for (int i = 0; i < size; i++) {
            if (province.equals(arrProvinces.get(i))) {
                return provinceIndex;
            } else {
                provinceIndex++;
            }
        }
        return provinceIndex;
    }

    /**
     * 得到城市索引
     *
     * @param city
     * @return
     */
    public int getCityItem(String city) {
        int size = arrCitys.size();
        int cityIndex = 0;
        for (int i = 0; i < size; i++) {
            if (city.equals(arrCitys.get(i))) {
                return cityIndex;
            } else {
                cityIndex++;
            }
        }
        return cityIndex;
    }

    private String readString(InputStream in) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            StringWriter sw = new StringWriter();
            String line;
            while ((line = br.readLine()) != null) {
                sw.write(line);
            }
            br.close();
            sw.close();
            return sw.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        return null;
    }
}
