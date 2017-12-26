package test.abc;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.mt.cardletter.R;
import com.mt.cardletter.fragment.order.JinxingzhongFragment;
import com.mt.cardletter.fragment.order.NoPaymentFragment;
import com.mt.cardletter.fragment.order.OverFragment;
import com.mt.cardletter.fragment.order.WaitEvaluationFragment;
import com.mt.cardletter.fragment.order.WholeFragment;
import com.mt.cardletter.utils.ToastUtils;

public class H5Activity extends AppCompatActivity {
    private TabLayout order_manager_tab;
    private ViewPager order_manager_page;
    private String[] titles = {"全部","待付款","正进行","待评价","已完成"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h5);
        initView();
        initData();
    }

    private void initData() {
        order_manager_page.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                ToastUtils.showShort(H5Activity.this,"position: "+position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        order_manager_tab = (TabLayout) findViewById(R.id.order_manager_tab);
        order_manager_page = (ViewPager) findViewById(R.id.order_manager_pager);
        order_manager_page.setAdapter(new MyAdapter(getSupportFragmentManager()));
        order_manager_tab.setupWithViewPager(order_manager_page);
        order_manager_page.setOffscreenPageLimit(4);
    }

    class MyAdapter extends FragmentPagerAdapter{
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            Fragment fragment=null;
            switch (position){
                case 0:
                    fragment=new WholeFragment();
                    break;
                case 1:
                    fragment=new NoPaymentFragment();
                    break;
                case 2:
                    fragment=new JinxingzhongFragment();
                    break;
                case 3:
                    fragment=new WaitEvaluationFragment();
                    break;
                case 4:
                    fragment=new OverFragment();
                    break;
            }
            return fragment;
        }
        @Override
        public int getCount() {
            return titles.length;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
//        private int mChildCount = 0;
        //强制刷新
//        @Override
//        public void notifyDataSetChanged() {
//            mChildCount = getCount();
//            super.notifyDataSetChanged();
//        }
//
//        @Override
//        public int getItemPosition(Object object)   {
//            if ( mChildCount > 0) {
//                mChildCount --;
//                return POSITION_NONE;
//            }
//            return super.getItemPosition(object);
//        }
    }
}
