package com.mt.cardletter.entity.bank;

import java.io.Serializable;
import java.util.List;

/**
 * Date:2018/2/5
 * Time:10:04
 * author:demons
 */

public class Bill implements Serializable{

    private List<List<TotalBean>> total;

    public List<List<TotalBean>> getTotal() {
        return total;
    }

    public void setTotal(List<List<TotalBean>> total) {
        this.total = total;
    }

    public static class TotalBean implements Serializable{
        /**
         * name : 王克军
         * bank : 上海银行
         * count : 0
         * repayment : {"Statement_date":"2017年12月12日-2018年01月11日","Payment_date":"2018年02月05日","Credit_Limit":"23,000","Cash":""}
         * bill : {"Currency":"RMB","Previous_Bill_Amount":"11,819.16+","Current_Bill_Amount":"2,828.87+","Paid_Amount":"3,000.00-","Other_Amount":"2,350.50+","Total_Due_Amount":"13,998.53+","Minimum_Payment":"3,590.93","Interest":""}
         * trade : [{"Trans_Date":"人民币账户","Post_Date":"RMB ACCOUNT","Description":"上期余额","Amount":"11,819.16+","Card_Number_last":"5722"},{"Trans_Date":"2018年01月05日","Post_Date":"2018年01月05日","Description":"支付宝还款","Amount":"3,000.00-","Card_Number_last":"5722"},{"Trans_Date":"2018年01月06日","Post_Date":"2018年01月06日","Description":"支付宝(信用卡快捷支付)","Amount":"59.07+","Card_Number_last":"5722"},{"Trans_Date":"2018年01月06日","Post_Date":"2018年01月06日","Description":"支付宝(信用卡快捷支付)","Amount":"299.00+","Card_Number_last":"5722"},{"Trans_Date":"2018年01月07日","Post_Date":"2018年01月08日","Description":"南京临水宫企业管理咨询有限公司","Amount":"2,144.00+","Card_Number_last":"5722"},{"Trans_Date":"2018年01月08日","Post_Date":"2018年01月08日","Description":"支付宝(信用卡快捷支付)","Amount":"118.09+","Card_Number_last":"5722"},{"Trans_Date":"2018年01月10日","Post_Date":"2018年01月10日","Description":"支付宝(信用卡快捷支付)","Amount":"33.00+","Card_Number_last":"5722"},{"Trans_Date":"2018年01月11日","Post_Date":"2018年01月11日","Description":"转账分期(微信) 第6期共12期 本金","Amount":"789.00+","Card_Number_last":"5722"},{"Trans_Date":"2018年01月11日","Post_Date":"2018年01月11日","Description":"转账分期(微信) 分期每期手续费","Amount":"54.97+","Card_Number_last":"5722"},{"Trans_Date":"2018年01月11日","Post_Date":"2018年01月11日","Description":"账单分期微信 第9期共12期 本金","Amount":"1,418.00+","Card_Number_last":"5722"},{"Trans_Date":"2018年01月11日","Post_Date":"2018年01月11日","Description":"账单分期微信 分期每期手续费","Amount":"88.53+","Card_Number_last":"5722"},{"Trans_Date":"2018年01月11日","Post_Date":"2018年01月11日","Description":"利息汇总","Amount":"175.71+","Card_Number_last":"5722"},{"Trans_Date":" ","Post_Date":"","Description":"本期余额","Amount":"13,998.53+","Card_Number_last":"5722"}]
         * integral : {"Opening_Balance":"179,759","Earned":"2,654+","Nbeifen":"0+","Adjustment":"0+","Redeemed":"5,250+","Closing_Balance":"177,163"}
         */

        private String name;
        private String bank;
        private int count;
        private RepaymentBean repayment;
        private BillBean bill;
        private IntegralBean integral;
        private List<TradeBean> trade;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public RepaymentBean getRepayment() {
            return repayment;
        }

        public void setRepayment(RepaymentBean repayment) {
            this.repayment = repayment;
        }

        public BillBean getBill() {
            return bill;
        }

        public void setBill(BillBean bill) {
            this.bill = bill;
        }

        public IntegralBean getIntegral() {
            return integral;
        }

        public void setIntegral(IntegralBean integral) {
            this.integral = integral;
        }

        public List<TradeBean> getTrade() {
            return trade;
        }

        public void setTrade(List<TradeBean> trade) {
            this.trade = trade;
        }

        public static class RepaymentBean implements Serializable{
            /**
             * Statement_date : 2017年12月12日-2018年01月11日
             * Payment_date : 2018年02月05日
             * Credit_Limit : 23,000
             * Cash :
             */

            private String Statement_date;
            private String Payment_date;
            private String Credit_Limit;
            private String Cash;

            public String getStatement_date() {
                return Statement_date;
            }

            public void setStatement_date(String Statement_date) {
                this.Statement_date = Statement_date;
            }

            public String getPayment_date() {
                return Payment_date;
            }

            public void setPayment_date(String Payment_date) {
                this.Payment_date = Payment_date;
            }

            public String getCredit_Limit() {
                return Credit_Limit;
            }

            public void setCredit_Limit(String Credit_Limit) {
                this.Credit_Limit = Credit_Limit;
            }

            public String getCash() {
                return Cash;
            }

            public void setCash(String Cash) {
                this.Cash = Cash;
            }
        }

        public static class BillBean implements Serializable{
            /**
             * Currency : RMB
             * Previous_Bill_Amount : 11,819.16+
             * Current_Bill_Amount : 2,828.87+
             * Paid_Amount : 3,000.00-
             * Other_Amount : 2,350.50+
             * Total_Due_Amount : 13,998.53+
             * Minimum_Payment : 3,590.93
             * Interest :
             */

            private String Currency;
            private String Previous_Bill_Amount;
            private String Current_Bill_Amount;
            private String Paid_Amount;
            private String Other_Amount;
            private String Total_Due_Amount;
            private String Minimum_Payment;
            private String Interest;

            public String getCurrency() {
                return Currency;
            }

            public void setCurrency(String Currency) {
                this.Currency = Currency;
            }

            public String getPrevious_Bill_Amount() {
                return Previous_Bill_Amount;
            }

            public void setPrevious_Bill_Amount(String Previous_Bill_Amount) {
                this.Previous_Bill_Amount = Previous_Bill_Amount;
            }

            public String getCurrent_Bill_Amount() {
                return Current_Bill_Amount;
            }

            public void setCurrent_Bill_Amount(String Current_Bill_Amount) {
                this.Current_Bill_Amount = Current_Bill_Amount;
            }

            public String getPaid_Amount() {
                return Paid_Amount;
            }

            public void setPaid_Amount(String Paid_Amount) {
                this.Paid_Amount = Paid_Amount;
            }

            public String getOther_Amount() {
                return Other_Amount;
            }

            public void setOther_Amount(String Other_Amount) {
                this.Other_Amount = Other_Amount;
            }

            public String getTotal_Due_Amount() {
                return Total_Due_Amount;
            }

            public void setTotal_Due_Amount(String Total_Due_Amount) {
                this.Total_Due_Amount = Total_Due_Amount;
            }

            public String getMinimum_Payment() {
                return Minimum_Payment;
            }

            public void setMinimum_Payment(String Minimum_Payment) {
                this.Minimum_Payment = Minimum_Payment;
            }

            public String getInterest() {
                return Interest;
            }

            public void setInterest(String Interest) {
                this.Interest = Interest;
            }
        }

        public static class IntegralBean implements Serializable{
            /**
             * Opening_Balance : 179,759
             * Earned : 2,654+
             * Nbeifen : 0+
             * Adjustment : 0+
             * Redeemed : 5,250+
             * Closing_Balance : 177,163
             */

            private String Opening_Balance;
            private String Earned;
            private String Nbeifen;
            private String Adjustment;
            private String Redeemed;
            private String Closing_Balance;

            public String getOpening_Balance() {
                return Opening_Balance;
            }

            public void setOpening_Balance(String Opening_Balance) {
                this.Opening_Balance = Opening_Balance;
            }

            public String getEarned() {
                return Earned;
            }

            public void setEarned(String Earned) {
                this.Earned = Earned;
            }

            public String getNbeifen() {
                return Nbeifen;
            }

            public void setNbeifen(String Nbeifen) {
                this.Nbeifen = Nbeifen;
            }

            public String getAdjustment() {
                return Adjustment;
            }

            public void setAdjustment(String Adjustment) {
                this.Adjustment = Adjustment;
            }

            public String getRedeemed() {
                return Redeemed;
            }

            public void setRedeemed(String Redeemed) {
                this.Redeemed = Redeemed;
            }

            public String getClosing_Balance() {
                return Closing_Balance;
            }

            public void setClosing_Balance(String Closing_Balance) {
                this.Closing_Balance = Closing_Balance;
            }
        }

        public static class TradeBean implements Serializable{
            /**
             * Trans_Date : 人民币账户
             * Post_Date : RMB ACCOUNT
             * Description : 上期余额
             * Amount : 11,819.16+
             * Card_Number_last : 5722
             */

            private String Trans_Date;
            private String Post_Date;
            private String Description;
            private String Amount;
            private String Card_Number_last;

            public String getTrans_Date() {
                return Trans_Date;
            }

            public void setTrans_Date(String Trans_Date) {
                this.Trans_Date = Trans_Date;
            }

            public String getPost_Date() {
                return Post_Date;
            }

            public void setPost_Date(String Post_Date) {
                this.Post_Date = Post_Date;
            }

            public String getDescription() {
                return Description;
            }

            public void setDescription(String Description) {
                this.Description = Description;
            }

            public String getAmount() {
                return Amount;
            }

            public void setAmount(String Amount) {
                this.Amount = Amount;
            }

            public String getCard_Number_last() {
                return Card_Number_last;
            }

            public void setCard_Number_last(String Card_Number_last) {
                this.Card_Number_last = Card_Number_last;
            }
        }
    }
}
