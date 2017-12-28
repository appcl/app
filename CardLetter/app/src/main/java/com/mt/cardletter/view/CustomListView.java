package com.mt.cardletter.view;

import android.content.Context;

import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * Created by jk on 2017/12/27.
 */

public class CustomListView extends ListView {
    private ScrollView parentScrollView;
    private static boolean isScroll = true;

    public CustomListView(Context context) {
        super(context ,null);

    }

    public CustomListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setFocusable(false);
    }
    public void setParentScrollView(ScrollView parentScrollView){
        this.parentScrollView = parentScrollView;
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                setParentScrollAble(isScroll,false);
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                setParentScrollAble(isScroll,true);
                break;
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }


    /**
     * 是否把滚动事件交给父scrollview
     *
     * @param
     */
    public void setParentScrollAble(boolean isAble,boolean flag) {
        if(isAble) {
            parentScrollView.requestDisallowInterceptTouchEvent(!flag);
        } else {
            parentScrollView.requestDisallowInterceptTouchEvent(!flag);
        }
    }
    public static void setScrollAble(boolean isScroll) {
        CustomListView.isScroll = isScroll;
    }

//    public void  setOnScrollListener (){
//        this.setOnScrollListener(new OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//            }
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//
//            }
//        });
//    }
}
