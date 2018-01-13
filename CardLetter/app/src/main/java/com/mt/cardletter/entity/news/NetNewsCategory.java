package com.mt.cardletter.entity.news;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jk on 2018/1/11.
 */

public class NetNewsCategory {


    /**
     * code : 10000
     * charge : false
     * msg : 查询成功
     * result : {"msg":"ok","result":["头条","新闻","财经","体育","娱乐","军事","教育","科技","NBA","股票","星座","女性","健康","育儿"],"status":"0"}
     */

    @SerializedName("code")
    private String code;
    @SerializedName("charge")
    private boolean charge;
    @SerializedName("msg")
    private String msg;
    @SerializedName("result")
    private ResultBean result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isCharge() {
        return charge;
    }

    public void setCharge(boolean charge) {
        this.charge = charge;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * msg : ok
         * result : ["头条","新闻","财经","体育","娱乐","军事","教育","科技","NBA","股票","星座","女性","健康","育儿"]
         * status : 0
         */

        @SerializedName("msg")
        private String msg;
        @SerializedName("status")
        private String status;
        @SerializedName("result")
        private List<String> result;

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public List<String> getResult() {
            return result;
        }

        public void setResult(List<String> result) {
            this.result = result;
        }
    }
}
