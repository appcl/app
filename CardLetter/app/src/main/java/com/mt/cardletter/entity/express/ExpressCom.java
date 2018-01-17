package com.mt.cardletter.entity.express;

import java.util.List;

/**
 * Date:2018/1/2
 * Time:19:46
 * author:demons
 */

public class ExpressCom {


    private List<ExpBean> exp;

    public List<ExpBean> getExp() {
        return exp;
    }

    public void setExp(List<ExpBean> exp) {
        this.exp = exp;
    }

    public static class ExpBean {
        /**
         * com : 顺丰
         * no : sf
         */

        private String com;
        private String no;

        public String getCom() {
            return com;
        }

        public void setCom(String com) {
            this.com = com;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }
    }
}
