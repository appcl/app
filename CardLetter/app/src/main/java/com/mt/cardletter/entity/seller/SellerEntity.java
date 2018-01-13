package com.mt.cardletter.entity.seller;

import java.util.List;

/**
 * Date:2018/1/9
 * Time:15:36
 * author:demons
 */

public class SellerEntity {

    /**
     * code : 0
     * msg : 操作成功
     * data : {"total":3,"per_page":15,"current_page":1,"last_page":1,"data":[{"id":882,"name":"1000wehotel酒店积分","category_id":"6","describe":"\n\t温馨提示：\n\n\t1.每位客户每月限兑30份，单个手机号兑换数量不能超过每月限兑总数！\n\t2.仅限网上及二维码兑换，网上及二维码兑换处理时间为十个工作日左右（双休日、元旦、春节、五一、十一等节假日处理时间相应顺延）。\n\n\t\n\n\t \n","create_time":"2017-12-26 12:47:42"},{"id":885,"name":"100wehotel酒店积分","category_id":"6","describe":"\n\t温馨提示：\n\n\t1.每位客户每月限兑330份，单个手机号兑换数量不能超过每月限兑总数！\n\t2.仅限网上及二维码兑换，网上及二维码兑换处理时间为十个工作日左右（双休日、元旦、春节、五一、十一等节假日处理时间相应顺延）。\n\n\t\n\n\t \n","create_time":"2017-12-26 12:47:42"},{"id":886,"name":"10000wehotel酒店积分","category_id":"6","describe":"\n\t温馨提示：\n\n\t1.每位客户每月限兑3份，单个手机号兑换数量不能超过每月限兑总数！\n\t2.仅限网上及二维码兑换，网上及二维码兑换处理时间为十个工作日左右（双休日、元旦、春节、五一、十一等节假日处理时间相应顺延）。\n\n\t\n\n\t \n\n\t \n","create_time":"2017-12-26 12:47:42"}]}
     * exe_time : 0.040002
     */

    private int code;
    private String msg;
    private DataBeanX data;
    private String exe_time;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public String getExe_time() {
        return exe_time;
    }

    public void setExe_time(String exe_time) {
        this.exe_time = exe_time;
    }

    public static class DataBeanX {
        /**
         * total : 3
         * per_page : 15
         * current_page : 1
         * last_page : 1
         * data : [{"id":882,"name":"1000wehotel酒店积分","category_id":"6","describe":"\n\t温馨提示：\n\n\t1.每位客户每月限兑30份，单个手机号兑换数量不能超过每月限兑总数！\n\t2.仅限网上及二维码兑换，网上及二维码兑换处理时间为十个工作日左右（双休日、元旦、春节、五一、十一等节假日处理时间相应顺延）。\n\n\t\n\n\t \n","create_time":"2017-12-26 12:47:42"},{"id":885,"name":"100wehotel酒店积分","category_id":"6","describe":"\n\t温馨提示：\n\n\t1.每位客户每月限兑330份，单个手机号兑换数量不能超过每月限兑总数！\n\t2.仅限网上及二维码兑换，网上及二维码兑换处理时间为十个工作日左右（双休日、元旦、春节、五一、十一等节假日处理时间相应顺延）。\n\n\t\n\n\t \n","create_time":"2017-12-26 12:47:42"},{"id":886,"name":"10000wehotel酒店积分","category_id":"6","describe":"\n\t温馨提示：\n\n\t1.每位客户每月限兑3份，单个手机号兑换数量不能超过每月限兑总数！\n\t2.仅限网上及二维码兑换，网上及二维码兑换处理时间为十个工作日左右（双休日、元旦、春节、五一、十一等节假日处理时间相应顺延）。\n\n\t\n\n\t \n\n\t \n","create_time":"2017-12-26 12:47:42"}]
         */

        private int total;
        private int per_page;
        private int current_page;
        private int last_page;
        private List<DataBean> data;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public int getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(int current_page) {
            this.current_page = current_page;
        }

        public int getLast_page() {
            return last_page;
        }

        public void setLast_page(int last_page) {
            this.last_page = last_page;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 882
             * name : 1000wehotel酒店积分
             * category_id : 6
             * describe :
             温馨提示：

             1.每位客户每月限兑30份，单个手机号兑换数量不能超过每月限兑总数！
             2.仅限网上及二维码兑换，网上及二维码兑换处理时间为十个工作日左右（双休日、元旦、春节、五一、十一等节假日处理时间相应顺延）。

             * create_time : 2017-12-26 12:47:42
             */

            private int id;
            private String name;
            private String category_id;
            private String describe;
            private String create_time;

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

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }
        }
    }
}
