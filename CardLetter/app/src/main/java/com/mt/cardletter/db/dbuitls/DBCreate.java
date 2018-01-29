package com.mt.cardletter.db.dbuitls;

import android.database.sqlite.SQLiteDatabase;

import com.mt.cardletter.db.tables.BankTable;
import com.mt.cardletter.entity.merchant.Bank;

import org.litepal.tablemanager.Connector;

import java.util.List;

/**
 * Created by Administrator on 2018/1/23.
 */

public class DBCreate {
    private SQLiteDatabase db = Connector.getDatabase();
    private DBCreate(){
    }
    public SQLiteDatabase getInstance(){
        return db;
    }

    /**
     * 给 BankTable 表添加数据
     * DataSupport.saveAll(List); 添加list 集合
     * @param bank
     * @return
     */
    public static boolean addBankForBankTable(Bank.DataBean bank){
        BankTable bankTable = new BankTable();
        bankTable.setName(bank.getName());
        bankTable.setCardIcon(bank.getCardIcon());
        bankTable.setCardImg(bank.getCardImg());
        bankTable.setCardThumb(bank.getCardThumb());
        bankTable.setDescribe(bank.getDescribe());
        bankTable.setBank_id(bank.getId()+"");
        boolean isSave = bankTable.save();
        if (isSave) {
            System.out.println("jk----bank存储成功 "+bank.getId());
        } else {
            System.out.println("jk----bank存储失败  ");
        }
        return isSave;
    }

    /*
    1,修改
     ContentValues values = new ContentValues();
     values.put("title", "8888888888");
     DataSupport.update(News.class, values, 2);
        条件修改
     ContentValues values = new ContentValues();
     values.put("title", "今日iPhone6 Plus发布");
     DataSupport.updateAll(News.class, values, "title = ?", "今日iPhone6发布");

     ContentValues values = new ContentValues();
     values.put("title", "今日iPhone6 Plus发布");
     DataSupport.updateAll(News.class, values, "title = ? and commentcount > ?", "今日iPhone6发布", "0");
      修改全部
     ContentValues values = new ContentValues();
     values.put("title", "今日iPhone6 Plus发布");
     DataSupport.updateAll(News.class, values);

     2.删除
     DataSupport.delete(News.class, 2);  删除 id为2

     isSaved() 判断对象是否持久化

     3，查询
     News news = DataSupport.find(News.class, 1); 根据id 查
     News firstNews = DataSupport.findFirst(News.class); 查第一条数据
     News lastNews = DataSupport.findLast(News.class);  查最后一条

     List<News> newsList = DataSupport.findAll(News.class, 1, 3, 5, 7);

     long[] ids = new long[] { 1, 3, 5, 7 };
     List<News> newsList = DataSupport.findAll(News.class, ids);

     List<News> allNews = DataSupport.findAll(News.class);  查询所有

     List<News> newsList = DataSupport.select("title", "content")
        .where("commentcount > ?", "0")
        .order("publishdate desc").limit(10).offset(10)
        .find(News.class);
     */

}
