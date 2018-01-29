package com.mt.cardletter.entity.bank;

import java.util.List;

/**
 * Date:2018/1/13
 * Time:16:06
 * author:demons
 */

public class Jt_BankEntity {
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
        private String previous_bill_amount;//上期账单金额

        public String getPrevious_bill_amount() {
            return previous_bill_amount;
        }

        public void setPrevious_bill_amount(String previous_bill_amount) {
            this.previous_bill_amount = previous_bill_amount;
        }

        public String getCurrent_bill_amount() {
            return current_bill_amount;
        }

        public void setCurrent_bill_amount(String current_bill_amount) {
            this.current_bill_amount = current_bill_amount;
        }

        public String getPay_amount() {
            return pay_amount;
        }

        public void setPay_amount(String pay_amount) {
            this.pay_amount = pay_amount;
        }

        public String getOther_amout() {
            return other_amout;
        }

        public void setOther_amout(String other_amout) {
            this.other_amout = other_amout;
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

        private String current_bill_amount;//本期账单金额
        private String pay_amount;//还款金额
        private String other_amout;//其他金额
        private String total_due_amount;//本期应还金额
        private String min_payment_amount;//本期最低还款金额
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

        public String getCardNum() {
            return cardNum;
        }

        public void setCardNum(String cardNum) {
            this.cardNum = cardNum;
        }

        private String trans_date;//交易日期
        private String post_date;//记账日期
        private String desc;//交易摘要
        private String amount;//记账金额
        private String cardNum;//卡号末四位
    }
}
