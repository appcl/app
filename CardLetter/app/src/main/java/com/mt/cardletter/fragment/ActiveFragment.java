package com.mt.cardletter.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewConfigurationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.activity.SetailsActivity;
import com.mt.cardletter.utils.SizeUtils;
import com.mt.cardletter.utils.ToastUtils;
import com.mt.cardletter.utils.UIHelper;
import com.mt.cardletter.view.CustomListView;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshBase;
import com.mt.cardletter.view.pulltorefresh.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import test.abc.MyActivity;

/**
 * Created by jk on 2017/12/11.
 */

public class ActiveFragment extends Fragment {

    private List<String> list;
    private MyAdapter myAdapter;
    private CustomListView listView;
    private ScrollView parentScrollView;
    private int viewY;
    public ActiveFragment(ScrollView parentScrollView,int viewY) {
        this.parentScrollView = parentScrollView;
        this.viewY = viewY;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_layout, container, false);
        listView = (CustomListView) view.findViewById(R.id.list_view);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        touchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(getContext()));

        initData();
        initView();
    }
    private void initData() {
        list = new ArrayList<>();
        for (int i = 0 ; i <= 20 ; i ++ ){
            list.add("item"+i);
        }
    }

    private int mLastFirstPostion;
    private int mLastFirstTop;
    private int touchSlop;
    private void initView() {
        listView.setParentScrollView(parentScrollView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), SetailsActivity.class);
                intent.putExtra("goods",list.get(position));
                UIHelper.showDetails(getContext(), intent);
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int currentTop;

                View firstChildView = listView.getChildAt(0);
                if (firstChildView != null) {
                    currentTop = listView.getChildAt(0).getTop();
                } else {
                    //ListView初始化的时候会回调onScroll方法，此时getChildAt(0)仍是为空的
                    return;
                }
                if (firstVisibleItem != mLastFirstPostion) {
                    //不是同一个位置
                    if (firstVisibleItem < mLastFirstPostion) {
                        //TODO do down
                        Log.i("cs", "--->up");
                        if (firstVisibleItem == 0){
                            Log.i("cs", "--->jk");
//                            listView.set
//                            parentScrollView.requestDisallowInterceptTouchEvent(false);
                        }
                    }
                    mLastFirstTop = currentTop;
                }
                mLastFirstPostion = firstVisibleItem;
            }
        });
//        listView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        Log.i("cs", "--->jk");
//
//                    case MotionEvent.ACTION_MOVE:
//                        break;
//                    case MotionEvent.ACTION_UP:
//                    case MotionEvent.ACTION_CANCEL:
//
//                        break;
//                    default:
//                        break;
//                }
//
//                return false;
//            }
//        });
        listView.setAdapter(myAdapter = new MyAdapter());
    }

    class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();

                convertView = View.inflate(getContext(),R.layout.item_goods, null);
                holder.tv = (TextView) convertView.findViewById(R.id.goods_title);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
                holder.tv.setText(list.get(position));
            return convertView;
        }
        class ViewHolder{
            TextView tv;
        }
    }


}
