package com.mt.cardletter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.mt.cardletter.R;
import com.mt.cardletter.utils.UIHelper;

/**
 * Created by Administrator on 2018/1/18.
 */

public class SplashItemFragment extends Fragment {
    private View view;
    private ImageView item_iv;
    private int[] images = {
            R.drawable.new01,
            R.drawable.new02,
            R.drawable.new03,
    };
    private ViewPager viewPager;
    private Button btnHome;
    public SplashItemFragment(ViewPager viewPager) {
        super();
        this.viewPager = viewPager;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getContext(),R.layout.fragment_splash_item,null);
        item_iv = (ImageView) view.findViewById(R.id.splash_item_iv);
        btnHome = (Button) view.findViewById(R.id.btnHome);
        int splash_index = getArguments().getInt("splash_index", 0);
        item_iv.setImageResource(images[splash_index]);
        if (splash_index == 2){
            btnHome.setVisibility(View.VISIBLE);
        }
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.showMainActivity(getActivity());
            }
        });
        return view;
    }

}
