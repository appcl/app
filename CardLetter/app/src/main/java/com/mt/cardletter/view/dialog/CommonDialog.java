package com.mt.cardletter.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mt.cardletter.R;

/**
 * Date:2017/12/20
 * Time:10:09
 * author:demons
 */

public class CommonDialog extends Dialog implements View.OnClickListener{

    private TextView i_know;
    private Context mContext;
    private ImageView error_img;
    private int image_id;
    private OnCloseListener listener;
    
    private String content;
    private String positiveName;
    private String negativeName;
    public CommonDialog(Context context) {
        super(context);
        this.mContext=context;
    }

    public CommonDialog(Context context, int themeResId, String content) {
        super(context, themeResId);
        this.mContext = context;
        this.content = content;
    }

    public CommonDialog(Context context,int error_img,int themeResId, OnCloseListener listener) {
        super(context, themeResId);
        this.mContext = context;
        this.listener = listener;
        this.image_id = error_img;
    }

    protected CommonDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.mContext = context;
    }

    public CommonDialog setPositiveButton(String name){
        this.positiveName = name;
        return this;
    }

    public CommonDialog setNegativeButton(String name){
        this.negativeName = name;
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.i_know:
                if (listener!=null){
                    listener.onClick(this,false);
                }
                this.dismiss();
                break;
            default:
                break;
        }
    }

    public interface OnCloseListener{
        void onClick(Dialog dialog, boolean confirm);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_commom);
        setCanceledOnTouchOutside(false);
        initView();
    }

    private void initView() {
        i_know= (TextView) findViewById(R.id.i_know);
        error_img = (ImageView) findViewById(R.id.error_img);
        error_img.setImageResource(image_id);
        i_know.setOnClickListener(this);
    }
}
