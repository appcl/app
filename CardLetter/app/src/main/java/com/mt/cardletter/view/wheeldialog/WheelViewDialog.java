package com.mt.cardletter.view.wheeldialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.express.ExpressCom;
import com.weigan.loopview.LoopView;
import com.weigan.loopview.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Date:2018/1/2
 * Time:20:37
 * author:demons
 */

public class WheelViewDialog extends Dialog {

    private LoopView loopView;
    private Button btn_ok;
    private Button btn_cancle;

    private OnSelectedListener listener;
    private  List<ExpressCom.ExpBean> stringArrayList = new ArrayList<>();
    private List<String> list = new ArrayList<>();
    private int position = 0;
    public String no;

    public WheelViewDialog(Context context, List<ExpressCom.ExpBean> arrayList, List<String> list) {
        super(context,R.style.alert_dialog);
        stringArrayList = arrayList;
        this.list = list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loopview_dialog);
        setCanceledOnTouchOutside(false);//设置显示dialog后,触屏屏幕不会使dialog消失

        loopView = (LoopView) findViewById(R.id.loopView);
        btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_cancle = (Button) findViewById(R.id.btn_cancle);

        // 设置原始数据
        loopView.setItems(list);
        // 滚动监听
        loopView.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                if (!TextUtils.isEmpty( stringArrayList.get( index).getCom() ) ){
//                    Toast.makeText(getContext() ,"选择了" + stringArrayList.get( index).getCom() , Toast.LENGTH_SHORT).show();
                    position = index;//存储选择的位序
                }
            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){
                    if (!TextUtils.isEmpty( stringArrayList.get( position).getCom() ) ){
                        listener.getData( stringArrayList.get( position).getCom(),stringArrayList.get( position).getNo() );
                    }
                }
                dismiss();
            }
        });

        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    public interface OnSelectedListener{
        void getData(String data,String no);
    }
    public void setOnSelectedListener(OnSelectedListener listener){
        this.listener = listener;
    }
}
