package com.mt.cardletter.entity.merchant;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jk on 2018/1/5.
 */

public class Goods {

    /**
     * code : 0
     * msg : 操作成功
     * data : {"total":11,"per_page":15,"current_page":1,"last_page":1,"data":[{"id":11,"name":"测试信息123","category_id":10,"describe":"asdf ","create_time":"2017-12-29 15:25:05"},{"id":10,"name":"商户测试信息8","category_id":9,"describe":"商户测试信息8","create_time":"2017-12-29 15:03:33"},{"id":9,"name":"商户测试信息77","category_id":8,"describe":"商户测试信息7","create_time":"2017-12-29 15:03:07"},{"id":8,"name":"商户测试信息66","category_id":7,"describe":"商户测试信息66","create_time":"2017-12-29 15:02:25"},{"id":7,"name":"商户测试信息6","category_id":6,"describe":"商户测试信息","create_time":"2017-12-29 15:01:21"},{"id":6,"name":"商户测试信息5","category_id":5,"describe":"商户测试信息","create_time":"2017-12-29 15:01:01"},{"id":5,"name":"商户测试信息4","category_id":4,"describe":"商户测试信息","create_time":"2017-12-29 15:00:41"},{"id":4,"name":"商户测试信息33","category_id":1,"describe":"商户测试信息","create_time":"2017-12-29 15:00:27"},{"id":3,"name":"商户测试信息2","category_id":3,"describe":"商户测试信息","create_time":"2017-12-29 14:59:08"},{"id":2,"name":"商户测试信息","category_id":2,"describe":"阿斯蒂芬","create_time":"2017-12-29 14:58:39"},{"id":1,"name":"阿斯顿发顺丰","category_id":1,"describe":"发生地方撒地方","create_time":"2017-12-29 14:58:16"}]}
     * exe_time : 0.035002
     */


    private int code;
    private String msg;
    private DataBeanX data;
    private String exeTime;

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

    public String getExeTime() {
        return exeTime;
    }

    public void setExeTime(String exeTime) {
        this.exeTime = exeTime;
    }

    public static class DataBeanX {
        /**
         * total : 11
         * per_page : 15
         * current_page : 1
         * last_page : 1
         * data : [{"id":11,"name":"测试信息123","category_id":10,"describe":"asdf ","create_time":"2017-12-29 15:25:05"},{"id":10,"name":"商户测试信息8","category_id":9,"describe":"商户测试信息8","create_time":"2017-12-29 15:03:33"},{"id":9,"name":"商户测试信息77","category_id":8,"describe":"商户测试信息7","create_time":"2017-12-29 15:03:07"},{"id":8,"name":"商户测试信息66","category_id":7,"describe":"商户测试信息66","create_time":"2017-12-29 15:02:25"},{"id":7,"name":"商户测试信息6","category_id":6,"describe":"商户测试信息","create_time":"2017-12-29 15:01:21"},{"id":6,"name":"商户测试信息5","category_id":5,"describe":"商户测试信息","create_time":"2017-12-29 15:01:01"},{"id":5,"name":"商户测试信息4","category_id":4,"describe":"商户测试信息","create_time":"2017-12-29 15:00:41"},{"id":4,"name":"商户测试信息33","category_id":1,"describe":"商户测试信息","create_time":"2017-12-29 15:00:27"},{"id":3,"name":"商户测试信息2","category_id":3,"describe":"商户测试信息","create_time":"2017-12-29 14:59:08"},{"id":2,"name":"商户测试信息","category_id":2,"describe":"阿斯蒂芬","create_time":"2017-12-29 14:58:39"},{"id":1,"name":"阿斯顿发顺丰","category_id":1,"describe":"发生地方撒地方","create_time":"2017-12-29 14:58:16"}]
         */


        private int total;
        private int perPage;
        private int currentPage;
        private int lastPage;
        private List<DataBean> data;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPerPage() {
            return perPage;
        }

        public void setPerPage(int perPage) {
            this.perPage = perPage;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
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
             * name : 测试信息123
             * category_id : 10
             * describe : asdf
             * create_time : 2017-12-29 15:25:05
             */

            @SerializedName("id")
            private int id;
            @SerializedName("name")
            private String name;
            @SerializedName("category_id")
            private int categoryId;
            @SerializedName("describe")
            private String describe;
            @SerializedName("create_time")
            private String createTime;

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

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }
    }
}
