package com.mt.cardletter.activity;

import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.adapter.GridViewAdapter;
import com.mt.cardletter.adapter.ViewPagerAdapter;
import com.mt.cardletter.entity.data.DataBean;
import com.mt.cardletter.view.indicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Date:2017/12/13
 * Time:11:42
 * author:demons
 */

public class SearchIntegralActivity extends BaseActivity {
    @Bind({R.id.title_name})
    TextView title_name;
    @Bind({R.id.com_back_click})
    FrameLayout back;

    public static int item_grid_num = 4;//每一页中GridView中item的数量
    public static int number_columns = 4;//gridview一行展示的数目
    private ViewPager view_pager;
    private ViewPagerAdapter mAdapter;
    private List<DataBean> dataList;
    private List<GridView> gridList = new ArrayList<>();
    private CirclePageIndicator indicator;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_search_integral;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        title_name.setText("我的积分");
        back.setVisibility(View.VISIBLE);

        //初始化ViewPager
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        mAdapter = new ViewPagerAdapter();
        view_pager.setAdapter(mAdapter);
        dataList = new ArrayList<>();
        //圆点指示器
        indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        indicator.setVisibility(View.VISIBLE);
        indicator.setViewPager(view_pager);
    }
    @Override
    public void initListener() {

    }

    @Override
    protected void initData() {
        if (dataList.size() > 0) {
            dataList.clear();
        }
        if (gridList.size() > 0) {
            gridList.clear();
        }
        //初始化数据
        for (int i = 0; i < 6; i++) {
            DataBean bean = new DataBean();
            bean.name = "第" + (i + 1) + "条数据";
            dataList.add(bean);
        }
        //计算viewpager一共显示几页
        int pageSize = dataList.size() % item_grid_num == 0
                ? dataList.size() / item_grid_num
                : dataList.size() / item_grid_num + 1;
        for (int i = 0; i < pageSize; i++) {
            GridView gridView = new GridView(this);
            GridViewAdapter adapter = new GridViewAdapter(dataList, i);
            gridView.setNumColumns(number_columns);
            gridView.setAdapter(adapter);
            gridList.add(gridView);
        }
        mAdapter.add(gridList);
    }

    @Override
    protected void handler(Message msg) {

    }
}
