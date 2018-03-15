package com.mt.cardletter.db.dbuitls;

import android.database.sqlite.SQLiteDatabase;

import com.mt.cardletter.db.tables.BankTable;
import com.mt.cardletter.entity.merchant.Bank;

import org.litepal.tablemanager.Connector;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmResults;

/**
 * Created by Administrator on 2018/1/23.
 */

public class DBCreate {
    /**
     * 单例暴露
     */
    public static Realm realm = Realm.getDefaultInstance();
    public static Realm getInstance(){
        return realm;
    }
    /**
     * 添加
     * @param id
     * @param bank
     */
    public static void addBankForBankTable(int id ,Bank.DataBean bank){

        realm.beginTransaction();
        BankTable bankTable =  new BankTable();
        int bank_id = bank.getId();
        bankTable.setId(id);
        bankTable.setBank_id(bank_id+"");
        bankTable.setName(bank.getName());
        bankTable.setDescribe(bank.getDescribe());
        bankTable.setCardIcon(bank.getCardIcon());
        bankTable.setCardImg(bank.getCardImg());
        bankTable.setCardThumb(bank.getCardThumb());

      switch (bank_id)
      {
          case 2:
              bankTable.setBank_page("com.cmbchina.ccd.pluto.cmbActivity");
              bankTable.setBank_page_name("掌上生活");
              break;
          case 3:
              bankTable.setBank_page("");
              bankTable.setBank_page_name("");
              break;
          case 4:
              bankTable.setBank_page("");
              bankTable.setBank_page_name("");
              break;
          case 6:
              bankTable.setBank_page("com.HuaXiaBank.HuaCard");
              bankTable.setBank_page_name("华彩生活");
              break;
          case 7:
              bankTable.setBank_page("com.android.bankabc");
              bankTable.setBank_page_name("中国农业银行");
              break;
          case 8:
              bankTable.setBank_page("");
              bankTable.setBank_page_name("");
              break;
          case 9:
              bankTable.setBank_page("");
              bankTable.setBank_page_name("");
              break;
          case 10:
              bankTable.setBank_page("com.spdbccc.app");
              bankTable.setBank_page_name("浦发信用卡");
              break;
          case 11:
              bankTable.setBank_page("com.cmbc.cc.mbank");
              bankTable.setBank_page_name("民生信用卡");
              break;
          case 12:
              bankTable.setBank_page("");
              bankTable.setBank_page_name("");
              break;
          case 13:
              bankTable.setBank_page("com.rytong.bankbj");
              bankTable.setBank_page_name("北京银行");
              break;
          case 14:
              bankTable.setBank_page("com.ebank.creditcard");
              bankTable.setBank_page_name("阳光惠生活");
              break;
          case 16:
              bankTable.setBank_page("com.citiccard.mobilebank");
              bankTable.setBank_page_name("动卡空间");
              break;
          case 17:
              bankTable.setBank_page("");
              bankTable.setBank_page_name("");
              break;
          case 18:
              bankTable.setBank_page("");
              bankTable.setBank_page_name("");
              break;
          case 19:
              bankTable.setBank_page("cn.jsb.china");
              bankTable.setBank_page_name("江苏银行");
              break;
          case 20:
              bankTable.setBank_page("cn.com.shbank.mper");
              bankTable.setBank_page_name("上海银行");
              break;
          case 23:
              bankTable.setBank_page("com.yitong.mbank.psbc");
              bankTable.setBank_page_name("邮储银行");
              break;
          case 24:
              bankTable.setBank_page("");
              bankTable.setBank_page_name("");
              break;
          case 25:
              bankTable.setBank_page("");
              bankTable.setBank_page_name("");
              break;
          case 26:
              bankTable.setBank_page("");
              bankTable.setBank_page_name("");
              break;
          case 28:
              bankTable.setBank_page("");
              bankTable.setBank_page_name("");
              break;
          case 29:
              bankTable.setBank_page("");
              bankTable.setBank_page_name("");
              break;
          case 30:
              bankTable.setBank_page("");
              bankTable.setBank_page_name("");
              break;
          case 1:
              bankTable.setBank_page("com.icbc.emallmobile");
              bankTable.setBank_page_name("融e购");
              break;
          case 5:
              bankTable.setBank_page("com.bankcomm.Bankcomm");
              bankTable.setBank_page_name("交通银行");
              break;
          case 15:
              bankTable.setBank_page("com.pingan.paces.ccms");
              bankTable.setBank_page_name("平安口袋银行");
              break;
          case 21:
              bankTable.setBank_page("");
              bankTable.setBank_page_name("");
              break;
          case 22:
              bankTable.setBank_page("");
              bankTable.setBank_page_name(" ");
              break;
          case 27://浙商银行
              bankTable.setBank_page("");
              bankTable.setBank_page_name("");
              break;
          case 31:
              bankTable.setBank_page("");
              bankTable.setBank_page_name("");
              break;
          case 32:
              bankTable.setBank_page("");
              bankTable.setBank_page_name("");
              break;
          case 33:
              bankTable.setBank_page("");
              bankTable.setBank_page_name("");
              break;
      }
        realm.copyToRealmOrUpdate(bankTable);
        realm.commitTransaction();
       // realm.close();
    }

    /**
     * 根据id 查询
     * @param bank_id
     * @return
     */
    public static BankTable selectBankById(String bank_id) {
        BankTable bankTable = realm.where(BankTable.class).equalTo("bank_id", bank_id).findFirst();
        System.out.println("jj------"+bank_id+"--根据id 查询成功");
        return  bankTable;
    }

    /**
     * 查询所有
     * @return
     */
    public static List<BankTable> selectBankAll() {
        RealmResults<BankTable> lists = realm.where(BankTable.class).findAll();
        System.out.println("jj------"+lists.size()+"--查询全部成功");
        return realm.copyFromRealm(lists);
    }

    /**
     * 释放
     */
    public static void closeRealm(){
        realm.close();
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
