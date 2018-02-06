package com.mt.cardletter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mt.cardletter.R;
import com.mt.cardletter.entity.bank.Bill;
import com.mt.cardletter.utils.ToastUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Date:2018/2/5
 * Time:17:27
 * author:demons
 */

public class BillExpandAdapter extends BaseAdapter {

    private Context context;
    private List<Bill.TotalBean> list = new ArrayList<>();
    private int currentItem = -1; //用于记录点击的 Item 的 position，是控制 item 展开的核心

    public BillExpandAdapter(Context context,
                             List<Bill.TotalBean> list) {
        super();
        this.context = context;
        this.list = list;
    }

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
        ViewHolder holder =null;
        if (convertView==null){
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.purchase_history_layout,parent,false);
            holder = new ViewHolder();
            holder.showArea = (LinearLayout) convertView.findViewById(R.id.layout_showArea);
            holder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            holder.tv_price = (TextView) convertView.findViewById(R.id.tv_price);
            holder.hide_list = (ListView) convertView.findViewById(R.id.hide_list);
//            holder.tv_des = (TextView) convertView.findViewById(R.id.tv_des);
//            holder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
//            holder.tv_amount = (TextView) convertView.findViewById(R.id.tv_amount);
//            holder.hideArea = (RelativeLayout) convertView.findViewById(R.id.layout_hideArea);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        final Bill.TotalBean item = list.get(position);
        // 注意：我们在此给响应点击事件的区域（我的例子里是 showArea 的线性布局）添加Tag，
        // 为了记录点击的 position，我们正好用 position 设置 Tag
        holder.showArea.setTag(position);

        String date = item.getRepayment().getStatement_date();
        try {
            Date d1 = new SimpleDateFormat("yyyy年MM月dd日").parse(date);//定义起始日期
            SimpleDateFormat mm = new SimpleDateFormat("MM");
            String mm_str = mm.format(d1);
            holder.tv_time.setText(mm_str+"月");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.tv_price.setText(item.getBill().getCurrent_Bill_Amount());

        ItemPurAdapter adapter = new ItemPurAdapter(context,item.getTrade());
        holder.hide_list.setAdapter(adapter);
        setListViewHeight(holder.hide_list);

        //根据 currentItem 记录的点击位置来设置"对应Item"的可见性
        // （在list依次加载列表数据时，每加载一个时都看一下是不是需改变可见性的那一条）
        if (currentItem == position) {
            holder.hide_list.setVisibility(View.VISIBLE);
        } else {
            holder.hide_list.setVisibility(View.GONE);
        }

        holder.showArea.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //用 currentItem 记录点击位置
                if (item.getTrade()==null){
                    ToastUtils.makeShortText("该信用卡账单未提供消费记录",context);
                }{
                    int tag = (Integer) view.getTag();
                    if (tag == currentItem) { //再次点击
                        currentItem = -1; //给 currentItem 一个无效值
                    } else {
                        currentItem = tag;
                    }
                    //通知adapter数据改变需要重新加载
                    notifyDataSetChanged(); //必须有的一步
                }
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        private LinearLayout showArea;
        private ListView hide_list;
        private TextView tv_time;
        private TextView tv_price;
    }

    /**
     * 设置Listview的高度
     */
    public void setListViewHeight(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();

        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
