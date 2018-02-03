package com.mt.cardletter.entity.checkversion;

import java.util.List;

/**
 * Date:2018/2/2
 * Time:11:29
 * author:demons
 */

public class CheckOrUpdate {

    /**
     * code : 0
     * msg : 操作成功
     * data : [{"id":1,"name":"卡信新年特别版","version":"1.0","down_url":"2412341234","is_new":1,"create_time":"2018-01-18 23:56:10"}]
     * exe_time : 0.003445
     */

    private int code;
    private String msg;
    private String exe_time;
    private List<DataBean> data;

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

    public String getExe_time() {
        return exe_time;
    }

    public void setExe_time(String exe_time) {
        this.exe_time = exe_time;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : 卡信新年特别版
         * version : 1.0
         * down_url : 2412341234
         * is_new : 1
         * create_time : 2018-01-18 23:56:10
         */

        private int id;
        private String name;
        private String version;
        private String down_url;
        private int is_new;
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

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getDown_url() {
            return down_url;
        }

        public void setDown_url(String down_url) {
            this.down_url = down_url;
        }

        public int getIs_new() {
            return is_new;
        }

        public void setIs_new(int is_new) {
            this.is_new = is_new;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }
    }
}
