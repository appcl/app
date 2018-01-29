package com.mt.cardletter.entity.bank;

import java.util.List;

/**
 * Date:2018/1/29
 * Time:15:11
 * author:demons
 */

public class Bank_JT {
    public PayMoney getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(PayMoney payMoney) {
        this.payMoney = payMoney;
    }

    private PayMoney payMoney;

    public List<PayRecord> getPayRecord() {
        return payRecord;
    }

    public void setPayRecord(List<PayRecord> payRecord) {
        this.payRecord = payRecord;
    }

    private List<PayRecord> payRecord;

    public static class PayMoney{
        public String getDate_line() {
            return date_line;
        }

        public void setDate_line(String date_line) {
            this.date_line = date_line;
        }

        public String getTotal_due_amount() {
            return total_due_amount;
        }

        public void setTotal_due_amount(String total_due_amount) {
            this.total_due_amount = total_due_amount;
        }

        public String getMin_payment_amount() {
            return min_payment_amount;
        }

        public void setMin_payment_amount(String min_payment_amount) {
            this.min_payment_amount = min_payment_amount;
        }

        public String getCredit_line() {
            return credit_line;
        }

        public void setCredit_line(String credit_line) {
            this.credit_line = credit_line;
        }

        public String getCash_line() {
            return cash_line;
        }

        public void setCash_line(String cash_line) {
            this.cash_line = cash_line;
        }

        private String date_line;//还款日
        private String total_due_amount;//本期应还金额
        private String min_payment_amount;//本期最低还款金额
        private String credit_line;//信用额度
        private String cash_line;//提现额度
    }

    public static class PayRecord{
        public String getTrans_date() {
            return trans_date;
        }

        public void setTrans_date(String trans_date) {
            this.trans_date = trans_date;
        }

        public String getPost_date() {
            return post_date;
        }

        public void setPost_date(String post_date) {
            this.post_date = post_date;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }
        private String trans_date;//交易日期
        private String post_date;//记账日期
        private String desc;//交易摘要
        private String amount;//记账金额

        public String getCardNum() {
            return cardNum;
        }

        public void setCardNum(String cardNum) {
            this.cardNum = cardNum;
        }

        private String cardNum;//卡号末四位
    }
}
