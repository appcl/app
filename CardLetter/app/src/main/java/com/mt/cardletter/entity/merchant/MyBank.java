package com.mt.cardletter.entity.merchant;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jk on 2018/1/23.\
 * 我的关注 -- 银行
 */

public class MyBank {

    /**
     * code : 0
     * msg : 操作成功
     * exe_time : 0.021827
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
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

    public String getExeTime() {
        return exeTime;
    }

    public void setExeTime(String exeTime) {
        this.exeTime = exeTime;
    }
}
