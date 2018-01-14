package com.mt.cardletter.entity.bank;

import java.io.Serializable;
import java.util.List;

/**
 * Date:2018/1/13
 * Time:16:20
 * author:demons
 */

public class BankEntity implements Serializable{

    /**
     * bank : {"sh_list":[{"name":"上海银行","id":"1"}],"pa_list":[{"name":"平安信用卡","id":"1"}],"gd_list":[{"name":"中国光大银行","id":"1"}],"jt_list":[{"name":"交通银行太平洋信用卡中心","id":"1"}],"zs_list":[{"name":"招商银行信用卡","id":"1"}]}
     */

    private BankBean bank;

    public BankBean getBank() {
        return bank;
    }

    public void setBank(BankBean bank) {
        this.bank = bank;
    }

    public static class BankBean implements Serializable{
        private List<ShListBean> sh_list;
        private List<PaListBean> pa_list;
        private List<GdListBean> gd_list;
        private List<JtListBean> jt_list;
        private List<ZsListBean> zs_list;

        public List<ShListBean> getSh_list() {
            return sh_list;
        }

        public void setSh_list(List<ShListBean> sh_list) {
            this.sh_list = sh_list;
        }

        public List<PaListBean> getPa_list() {
            return pa_list;
        }

        public void setPa_list(List<PaListBean> pa_list) {
            this.pa_list = pa_list;
        }

        public List<GdListBean> getGd_list() {
            return gd_list;
        }

        public void setGd_list(List<GdListBean> gd_list) {
            this.gd_list = gd_list;
        }

        public List<JtListBean> getJt_list() {
            return jt_list;
        }

        public void setJt_list(List<JtListBean> jt_list) {
            this.jt_list = jt_list;
        }

        public List<ZsListBean> getZs_list() {
            return zs_list;
        }

        public void setZs_list(List<ZsListBean> zs_list) {
            this.zs_list = zs_list;
        }

        public static class ShListBean implements Serializable{
            /**
             * name : 上海银行
             * id : 1
             */

            private String name;
            private String id;

            public String getSubj() {
                return subj;
            }

            public void setSubj(String subj) {
                this.subj = subj;
            }

            public String getAbs() {
                return abs;
            }

            public void setAbs(String abs) {
                this.abs = abs;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            private String subj;
            private String abs;
            private String date;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class PaListBean implements Serializable{
            /**
             * name : 平安信用卡
             * id : 1
             */

            private String name;
            private String id;

            public String getSubj() {
                return subj;
            }

            public void setSubj(String subj) {
                this.subj = subj;
            }

            public String getAbs() {
                return abs;
            }

            public void setAbs(String abs) {
                this.abs = abs;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            private String subj;
            private String abs;
            private String date;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class GdListBean implements Serializable{
            /**
             * name : 中国光大银行
             * id : 1
             */

            private String name;
            private String id;

            public String getSubj() {
                return subj;
            }

            public void setSubj(String subj) {
                this.subj = subj;
            }

            public String getAbs() {
                return abs;
            }

            public void setAbs(String abs) {
                this.abs = abs;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            private String subj;
            private String abs;
            private String date;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class JtListBean implements Serializable{
            /**
             * name : 交通银行太平洋信用卡中心
             * id : 1
             */

            private String name;
            private String id;

            public String getSubj() {
                return subj;
            }

            public void setSubj(String subj) {
                this.subj = subj;
            }

            public String getAbs() {
                return abs;
            }

            public void setAbs(String abs) {
                this.abs = abs;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            private String subj;
            private String abs;
            private String date;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class ZsListBean implements Serializable{
            /**
             * name : 招商银行信用卡
             * id : 1
             */

            private String name;
            private String id;

            public String getSubj() {
                return subj;
            }

            public void setSubj(String subj) {
                this.subj = subj;
            }

            public String getAbs() {
                return abs;
            }

            public void setAbs(String abs) {
                this.abs = abs;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            private String subj;
            private String abs;
            private String date;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
