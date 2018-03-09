package com.mt.cardletter.fragment;

import android.os.Bundle;
import android.os.Handler;

import com.mt.cardletter.R;

/**
 * Date:2018/3/1
 * Time:10:28
 * author:demons
 *
 */

public class MoreFragment extends LazyFragment {
    private int tabIndex;
    public static final String INTENT_INT_INDEX = "intent_int_index";

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);

        setContentView(R.layout.fragment_tabmain_item);
        tabIndex = getArguments().getInt(INTENT_INT_INDEX);
    }

    @Override
    protected void onDestroyViewLazy() {
        super.onDestroyViewLazy();
    }

    private Handler handler;
}
