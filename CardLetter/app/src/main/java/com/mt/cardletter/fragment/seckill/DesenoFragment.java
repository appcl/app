package com.mt.cardletter.fragment.seckill;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.fragment.BaseFragment;
import com.mt.cardletter.utils.ToastUtils;

import test.abc.MyActivity;

/**
 * jk 限时购买
 */
public class DesenoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_deseno, null);
        TextView view1 = (TextView) view.findViewById(R.id.id_test);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.makeShortText("TextView",getContext());
                startActivity(new Intent(getContext(),MyActivity.class));
            }
        });
        return view;
    }

}
