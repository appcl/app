package com.mt.cardletter.activity.showimg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.showimg.ImageDetailFragment;

import java.util.ArrayList;

/**
 * 图片查看器 
 */
public class ImagePagerActivity extends FragmentActivity {
    private static final String STATE_POSITION = "STATE_POSITION";
    public static final String EXTRA_IMAGE_INDEX = "image_index";
    public static final String EXTRA_IMAGE_URLS = "image_urls";

    private ViewPager mPager;
    private int pagerPosition;
    private TextView indicator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_pager);
        //pagerPosition = getIntent().getIntExtra(EXTRA_IMAGE_INDEX, 0);
        ArrayList<String> urls = new ArrayList<>();
        urls.add("https://baike.baidu.com/pic/%E7%99%BE%E5%BA%A6/6699/0/1c950a7b02087bf49212ea50f1d3572c10dfcf89?fr=lemma&ct=single#aid=0&pic=1c950a7b02087bf49212ea50f1d3572c10dfcf89");
        urls.add("https://baike.baidu.com/pic/%E7%99%BE%E5%BA%A6/6699/0/7c1ed21b0ef41bd5b654642550da81cb38db3ddf?fr=lemma&ct=single#aid=0&pic=7c1ed21b0ef41bd5b654642550da81cb38db3ddf");
        mPager = (ViewPager) findViewById(R.id.pager);
        ImagePagerAdapter mAdapter = new ImagePagerAdapter(getSupportFragmentManager(), urls);
        mPager.setAdapter(mAdapter);

        indicator = (TextView) findViewById(R.id.indicator);
        indicator.setText("sada");

        // 更新下标
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }
            @Override
            public void onPageSelected(int arg0) {
                indicator.setText("sadasdas");
            }

        });

        if (savedInstanceState != null) {
            pagerPosition = savedInstanceState.getInt(STATE_POSITION);
        }

        mPager.setCurrentItem(pagerPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_POSITION, mPager.getCurrentItem());
    }

    private class ImagePagerAdapter extends FragmentStatePagerAdapter {

        public ArrayList<String> fileList;

        public ImagePagerAdapter(FragmentManager fm, ArrayList<String> fileList) {
            super(fm);
            this.fileList = fileList;
        }

        @Override
        public int getCount() {
            return fileList == null ? 0 : fileList.size();
        }

        @Override
        public Fragment getItem(int position) {
            String url = fileList.get(position);
            return ImageDetailFragment.newInstance(url);
        }

    }
}  