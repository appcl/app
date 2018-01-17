package com.mt.cardletter.view.animview;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.mt.cardletter.R;

import java.lang.ref.WeakReference;

/**
 * Date:2018/1/17
 * Time:10:06
 * author:demons
 */

public abstract class AnimBaseDialog extends DialogFragment{
    protected Context mContext;

    private static WeakReference<AnimBaseDialog> dialogWeakReference;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }

    public static void dissmissDialog() {
        try {
            AnimBaseDialog dialog = dialogWeakReference.get();
            if (dialog != null && dialog.isAdded()) {
                dialog.dismiss();
                dialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(getActivity(), onGetStyle());
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        View view = View.inflate(getActivity(), onGetDialogViewId(), null);
        dialog.setContentView(view);
        onDialogCreated(dialog);
        return dialog;
    }

    protected abstract void onDialogCreated(Dialog dialog);

    protected abstract int onGetDialogViewId();

    protected int onGetStyle() {
        return R.style.custom_dialog;
    }

    public void show(FragmentManager fragmentManager) {
        dialogWeakReference = new WeakReference<AnimBaseDialog>(this);
        show(fragmentManager, "dialog");
    }
}
