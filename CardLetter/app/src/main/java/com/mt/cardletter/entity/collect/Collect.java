package com.mt.cardletter.entity.collect;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jk on 2018/1/24.
 * 收藏返回
 */

public class Collect {


    /**
     * code : 0
     * msg : 操作成功
     * data : 46
     * exe_time : 0.005453
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private String data;
    @SerializedName("exe_time")
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getExeTime() {
        return exeTime;
    }

    public void setExeTime(String exeTime) {
        this.exeTime = exeTime;
    }
}
