package com.mt.cardletter.view.animview;

import android.app.Dialog;
import android.view.Gravity;
import android.view.WindowManager;

import com.mt.cardletter.R;

/**
 * Date:2018/1/17
 * Time:10:06
 * author:demons
 */

public class AnimDialog extends AnimBaseDialog{
    private SlackLoadingView loading_view;


    public static AnimDialog newInstance() {
        AnimDialog dialog = new AnimDialog();
        return dialog;
    }

    @Override
    protected void onDialogCreated(Dialog dialog) {
        loading_view = (SlackLoadingView) dialog.findViewById(R.id.loading_view);
        // 设置居中
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        // 设置背景层透明度
        lp.dimAmount = 0.2f;
        dialog.getWindow().setAttributes(lp);
        loading_view.setLineLength(10 / 100f);
        loading_view.setDuration(50 / 100f);
        loading_view.start();
    }

    @Override
    protected int onGetDialogViewId() {
        return R.layout.anim_view;
    }
}
