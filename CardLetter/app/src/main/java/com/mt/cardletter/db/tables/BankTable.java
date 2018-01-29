package com.mt.cardletter.db.tables;

import com.google.gson.annotations.SerializedName;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by jk on 2018/1/23.
 * 银行 表
 */

public class BankTable extends DataSupport {
    /**
     * bank_id : 2
     * name : 招商银行
     * describe : 招商银行是国内大型银行之一
     * card_icon : /upload/bank/icon/b4_big.png
     * card_thumb : /upload/bank/thumb/card2.png
     * card_img : /upload/bank/bank/y2.png
     */

    private String bank_id;

    public String getBank_id() {
        return bank_id;
    }

    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }
    private int id;
    private String name;
    private String describe;
    private String cardIcon;
    private String cardThumb;
    private String cardImg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getCardIcon() {
        return cardIcon;
    }

    public void setCardIcon(String cardIcon) {
        this.cardIcon = cardIcon;
    }

    public String getCardThumb() {
        return cardThumb;
    }

    public void setCardThumb(String cardThumb) {
        this.cardThumb = cardThumb;
    }

    public String getCardImg() {
        return cardImg;
    }

    public void setCardImg(String cardImg) {
        this.cardImg = cardImg;
    }

}
