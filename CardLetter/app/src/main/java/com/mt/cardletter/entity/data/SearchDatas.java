package com.mt.cardletter.entity.data;

import java.util.List;

/**
 * Date:2018/1/10
 * Time:20:11
 * author:demons
 */

public class SearchDatas {

    /**
     * code : 0
     * msg : 操作成功
     * data : {"total":47,"per_page":15,"current_page":1,"last_page":4,"data":[{"id":11,"name":"月福汽车装饰(北洼路店)","category_id":"11","describe":"享受10元洗车一次","create_time":"2017-12-26 12:47:42"},{"id":4236,"name":"马立可汽车服务中心（1003金沙店）","category_id":"11","describe":"8.5折","create_time":"2017-12-26 12:47:42"}]}
     * exe_time : 0.066004
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
         * total : 47
         * per_page : 15
         * current_page : 1
         * last_page : 4
         * data : [{"id":11,"name":"月福汽车装饰(北洼路店)","category_id":"11","describe":"享受10元洗车一次","create_time":"2017-12-26 12:47:42"},{"id":4236,"name":"马立可汽车服务中心（1003金沙店）","category_id":"11","describe":"8.5折","create_time":"2017-12-26 12:47:42"}]
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
             * id : 11
             * name : 月福汽车装饰(北洼路店)
             * category_id : 11
             * describe : 享受10元洗车一次
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
