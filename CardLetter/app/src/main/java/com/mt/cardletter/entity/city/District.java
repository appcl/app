package com.mt.cardletter.entity.city;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * 地区列表
 * Created by jk on 2018/1/18.
 */

public class District  implements Serializable{


    /**
     * code : 0
     * msg : 操作成功
     * data : [{"id":110000,"name":"北京市"},{"id":120000,"name":"天津市"},{"id":130100,"name":"石家庄市"},{"id":210100,"name":"沈阳市"},{"id":210200,"name":"大连市"},{"id":310000,"name":"上海市"},{"id":320100,"name":"南京市"},{"id":320500,"name":"苏州市"},{"id":330100,"name":"杭州市"},{"id":330200,"name":"宁波市"},{"id":340100,"name":"合肥市"},{"id":350100,"name":"福州市"},{"id":350200,"name":"厦门市"},{"id":360100,"name":"南昌市"},{"id":370100,"name":"济南市"},{"id":370200,"name":"青岛市"},{"id":410100,"name":"郑州市"},{"id":420100,"name":"武汉市"},{"id":430100,"name":"长沙市"},{"id":440100,"name":"广州市"},{"id":440300,"name":"深圳市"},{"id":450100,"name":"南宁市"},{"id":460100,"name":"海口市"},{"id":460200,"name":"三亚市"},{"id":500000,"name":"重庆市"},{"id":510100,"name":"成都市"},{"id":530100,"name":"昆明市"},{"id":610100,"name":"西安市"}]
     * exe_time : 0.005476
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

    public static class DataBean implements Serializable{
        /**
         * id : 110000
         * name : 北京市
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
