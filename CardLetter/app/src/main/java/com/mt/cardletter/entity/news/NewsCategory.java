package com.mt.cardletter.entity.news;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jk on 2018/1/9.
 */

public class NewsCategory {


    /**
     * code : 0
     * msg : 操作成功
     * data : [{"id":7,"name":"活动"},{"id":8,"name":"美食"},{"id":9,"name":"咖啡"},{"id":10,"name":"西点"},{"id":11,"name":"电影"},{"id":12,"name":"头条"}]
     * exe_time : 0.030001
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("exe_time")
    private String exeTime;
    @SerializedName("data")
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

    public String getExeTime() {
        return exeTime;
    }

    public void setExeTime(String exeTime) {
        this.exeTime = exeTime;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 7
         * name : 活动
         */

        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;

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
    }
}
