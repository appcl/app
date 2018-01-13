package com.mt.cardletter.entity.bank;

/**
 * Date:2018/1/13
 * Time:16:06
 * author:demons
 */

public class Jt_BankEntity {
    private String hk_date;//还款日
    private String xy_line;//信用额度

    public String getHk_date() {
        return hk_date;
    }

    public void setHk_date(String hk_date) {
        this.hk_date = hk_date;
    }

    public String getXy_line() {
        return xy_line;
    }

    public void setXy_line(String xy_line) {
        this.xy_line = xy_line;
    }

    public String getCurrent_repay() {
        return current_repay;
    }

    public void setCurrent_repay(String current_repay) {
        this.current_repay = current_repay;
    }

    public String getCurrent_min_repay() {
        return current_min_repay;
    }

    public void setCurrent_min_repay(String current_min_repay) {
        this.current_min_repay = current_min_repay;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public String getTransaction_des() {
        return transaction_des;
    }

    public void setTransaction_des(String transaction_des) {
        this.transaction_des = transaction_des;
    }

    public String getTransaction_money() {
        return transaction_money;
    }

    public void setTransaction_money(String transaction_money) {
        this.transaction_money = transaction_money;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public String getCurrent_money() {
        return current_money;
    }

    public void setCurrent_money(String current_money) {
        this.current_money = current_money;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    private String current_repay;//本期应还金额
    private String current_min_repay;//本期最低还款
    private String transaction_date;//交易日期
    private String transaction_des;//交易记录
    private String transaction_money;//交易金额
    private String cardnum;//交易卡号
    private String current_money;//本期余额
    private String integral;//可用积分
}
