package com.mt.cardletter.entity.creditcard;

import java.util.List;

/**
 * Date:2018/1/12
 * Time:11:38
 * author:demons
 */

public class CreditCard {

    /**
     * code : 10000
     * charge : false
     * msg : 查询成功
     * result : {"code":0,"msg":"找到1个邮件中有银行账单，解析1个银行账单。","result":[{"apply_id":"1171107","created_date":"2016-11-08","credit_card_stmt_id":7857589253227612,"email":"test@qq.com","expense_rmb":"0.00","holder_name":"万三千","issue_bank":"中国工商银行","last4digit":"8888","last_balance_rmb":"0.00","payment_due_date":"2014-12-25","payment_rmb":"0.00","statement_date":"2014-11-30","statement_detail":[{"apply_id":"1171107","created_date":"2016-11-08","credit_card_stmt_id":7857589253227612,"issue_bank":"中国工商银行","last4digit":"8888","post_amt":"4,939.52","post_currency":"RMB","post_date":"2014-11-24","seq_no":1,"statement_end_date":"2014-11-30","statement_start_date":"2014-11-01","trans_date":"2014-11-24","trans_desc":"新华支行","trans_type":"信用卡还款","user_id":"11071107"}],"statement_end_date":"2014-11-30","statement_start_date":"2014-11-01","user_id":"11071107"}]}
     */

    private String code;
    private boolean charge;
    private String msg;
    private ResultBeanX result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isCharge() {
        return charge;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBeanX getResult() {
        return result;
    }

    public void setResult(ResultBeanX result) {
        this.result = result;
    }

    public static class ResultBeanX {
        /**
         * code : 0
         * msg : 找到1个邮件中有银行账单，解析1个银行账单。
         * result : [{"apply_id":"1171107","created_date":"2016-11-08","credit_card_stmt_id":7857589253227612,"email":"test@qq.com","expense_rmb":"0.00","holder_name":"万三千","issue_bank":"中国工商银行","last4digit":"8888","last_balance_rmb":"0.00","payment_due_date":"2014-12-25","payment_rmb":"0.00","statement_date":"2014-11-30","statement_detail":[{"apply_id":"1171107","created_date":"2016-11-08","credit_card_stmt_id":7857589253227612,"issue_bank":"中国工商银行","last4digit":"8888","post_amt":"4,939.52","post_currency":"RMB","post_date":"2014-11-24","seq_no":1,"statement_end_date":"2014-11-30","statement_start_date":"2014-11-01","trans_date":"2014-11-24","trans_desc":"新华支行","trans_type":"信用卡还款","user_id":"11071107"}],"statement_end_date":"2014-11-30","statement_start_date":"2014-11-01","user_id":"11071107"}]
         */

        private int code;
        private String msg;
        private List<ResultBean> result;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<ResultBean> getResult() {
            return result;
        }

        public void setResult(List<ResultBean> result) {
            this.result = result;
        }

        public static class ResultBean {
            /**
             * apply_id : 1171107
             * created_date : 2016-11-08
             * credit_card_stmt_id : 7857589253227612
             * email : test@qq.com
             * expense_rmb : 0.00
             * holder_name : 万三千
             * issue_bank : 中国工商银行
             * last4digit : 8888
             * last_balance_rmb : 0.00
             * payment_due_date : 2014-12-25
             * payment_rmb : 0.00
             * statement_date : 2014-11-30
             * statement_detail : [{"apply_id":"1171107","created_date":"2016-11-08","credit_card_stmt_id":7857589253227612,"issue_bank":"中国工商银行","last4digit":"8888","post_amt":"4,939.52","post_currency":"RMB","post_date":"2014-11-24","seq_no":1,"statement_end_date":"2014-11-30","statement_start_date":"2014-11-01","trans_date":"2014-11-24","trans_desc":"新华支行","trans_type":"信用卡还款","user_id":"11071107"}]
             * statement_end_date : 2014-11-30
             * statement_start_date : 2014-11-01
             * user_id : 11071107
             */

            private String apply_id;
            private String created_date;
            private long credit_card_stmt_id;
            private String email;
            private String expense_rmb;
            private String holder_name;
            private String issue_bank;
            private String last4digit;
            private String last_balance_rmb;
            private String payment_due_date;
            private String payment_rmb;
            private String statement_date;
            private String statement_end_date;
            private String statement_start_date;
            private String user_id;
            private List<StatementDetailBean> statement_detail;

            public String getApply_id() {
                return apply_id;
            }

            public void setApply_id(String apply_id) {
                this.apply_id = apply_id;
            }

            public String getCreated_date() {
                return created_date;
            }

            public void setCreated_date(String created_date) {
                this.created_date = created_date;
            }

            public long getCredit_card_stmt_id() {
                return credit_card_stmt_id;
            }

            public void setCredit_card_stmt_id(long credit_card_stmt_id) {
                this.credit_card_stmt_id = credit_card_stmt_id;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getExpense_rmb() {
                return expense_rmb;
            }

            public void setExpense_rmb(String expense_rmb) {
                this.expense_rmb = expense_rmb;
            }

            public String getHolder_name() {
                return holder_name;
            }

            public void setHolder_name(String holder_name) {
                this.holder_name = holder_name;
            }

            public String getIssue_bank() {
                return issue_bank;
            }

            public void setIssue_bank(String issue_bank) {
                this.issue_bank = issue_bank;
            }

            public String getLast4digit() {
                return last4digit;
            }

            public void setLast4digit(String last4digit) {
                this.last4digit = last4digit;
            }

            public String getLast_balance_rmb() {
                return last_balance_rmb;
            }

            public void setLast_balance_rmb(String last_balance_rmb) {
                this.last_balance_rmb = last_balance_rmb;
            }

            public String getPayment_due_date() {
                return payment_due_date;
            }

            public void setPayment_due_date(String payment_due_date) {
                this.payment_due_date = payment_due_date;
            }

            public String getPayment_rmb() {
                return payment_rmb;
            }

            public void setPayment_rmb(String payment_rmb) {
                this.payment_rmb = payment_rmb;
            }

            public String getStatement_date() {
                return statement_date;
            }

            public void setStatement_date(String statement_date) {
                this.statement_date = statement_date;
            }

            public String getStatement_end_date() {
                return statement_end_date;
            }

            public void setStatement_end_date(String statement_end_date) {
                this.statement_end_date = statement_end_date;
            }

            public String getStatement_start_date() {
                return statement_start_date;
            }

            public void setStatement_start_date(String statement_start_date) {
                this.statement_start_date = statement_start_date;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public List<StatementDetailBean> getStatement_detail() {
                return statement_detail;
            }

            public void setStatement_detail(List<StatementDetailBean> statement_detail) {
                this.statement_detail = statement_detail;
            }

            public static class StatementDetailBean {
                /**
                 * apply_id : 1171107
                 * created_date : 2016-11-08
                 * credit_card_stmt_id : 7857589253227612
                 * issue_bank : 中国工商银行
                 * last4digit : 8888
                 * post_amt : 4,939.52
                 * post_currency : RMB
                 * post_date : 2014-11-24
                 * seq_no : 1
                 * statement_end_date : 2014-11-30
                 * statement_start_date : 2014-11-01
                 * trans_date : 2014-11-24
                 * trans_desc : 新华支行
                 * trans_type : 信用卡还款
                 * user_id : 11071107
                 */

                private String apply_id;
                private String created_date;
                private long credit_card_stmt_id;
                private String issue_bank;
                private String last4digit;
                private String post_amt;
                private String post_currency;
                private String post_date;
                private int seq_no;
                private String statement_end_date;
                private String statement_start_date;
                private String trans_date;
                private String trans_desc;
                private String trans_type;
                private String user_id;

                public String getApply_id() {
                    return apply_id;
                }

                public void setApply_id(String apply_id) {
                    this.apply_id = apply_id;
                }

                public String getCreated_date() {
                    return created_date;
                }

                public void setCreated_date(String created_date) {
                    this.created_date = created_date;
                }

                public long getCredit_card_stmt_id() {
                    return credit_card_stmt_id;
                }

                public void setCredit_card_stmt_id(long credit_card_stmt_id) {
                    this.credit_card_stmt_id = credit_card_stmt_id;
                }

                public String getIssue_bank() {
                    return issue_bank;
                }

                public void setIssue_bank(String issue_bank) {
                    this.issue_bank = issue_bank;
                }

                public String getLast4digit() {
                    return last4digit;
                }

                public void setLast4digit(String last4digit) {
                    this.last4digit = last4digit;
                }

                public String getPost_amt() {
                    return post_amt;
                }

                public void setPost_amt(String post_amt) {
                    this.post_amt = post_amt;
                }

                public String getPost_currency() {
                    return post_currency;
                }

                public void setPost_currency(String post_currency) {
                    this.post_currency = post_currency;
                }

                public String getPost_date() {
                    return post_date;
                }

                public void setPost_date(String post_date) {
                    this.post_date = post_date;
                }

                public int getSeq_no() {
                    return seq_no;
                }

                public void setSeq_no(int seq_no) {
                    this.seq_no = seq_no;
                }

                public String getStatement_end_date() {
                    return statement_end_date;
                }

                public void setStatement_end_date(String statement_end_date) {
                    this.statement_end_date = statement_end_date;
                }

                public String getStatement_start_date() {
                    return statement_start_date;
                }

                public void setStatement_start_date(String statement_start_date) {
                    this.statement_start_date = statement_start_date;
                }

                public String getTrans_date() {
                    return trans_date;
                }

                public void setTrans_date(String trans_date) {
                    this.trans_date = trans_date;
                }

                public String getTrans_desc() {
                    return trans_desc;
                }

                public void setTrans_desc(String trans_desc) {
                    this.trans_desc = trans_desc;
                }

                public String getTrans_type() {
                    return trans_type;
                }

                public void setTrans_type(String trans_type) {
                    this.trans_type = trans_type;
                }

                public String getUser_id() {
                    return user_id;
                }

                public void setUser_id(String user_id) {
                    this.user_id = user_id;
                }
            }
        }
    }
}
