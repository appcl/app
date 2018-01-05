package com.mt.cardletter.entity.integral;

import java.util.List;

/**
 * Date:2018/1/5
 * Time:18:42
 * author:demons
 */

public class CategoryEntity {

    /**
     * code : 0
     * msg : 操作成功
     * data : [{"id":15,"name":"培训"},{"id":14,"name":"宠物"},{"id":13,"name":"爱车"},{"id":12,"name":"医疗健康"},{"id":11,"name":"生活"},{"id":10,"name":"购物"},{"id":9,"name":"运动健身"},{"id":8,"name":"旅游"},{"id":7,"name":"亲子"},{"id":6,"name":"酒店"},{"id":5,"name":"丽人"},{"id":4,"name":"电影演出"},{"id":3,"name":"结婚"},{"id":2,"name":"休闲娱乐"},{"id":1,"name":"美食"}]
     * exe_time : 0.030002
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
         * id : 15
         * name : 培训
         */

        private int id;
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
