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
     * data : {"access_token":"6d6551fa0063bdcde7ce9d94b60f29fa","name":"戴森落地式无叶风扇AM08","member_id":"20","name_id":"14","fvalue":"戴森落地式无叶风扇AM08"}
     * exe_time : 0.001468
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private DataBean data;
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getExeTime() {
        return exeTime;
    }

    public void setExeTime(String exeTime) {
        this.exeTime = exeTime;
    }

    public static class DataBean {
        /**
         * access_token : 6d6551fa0063bdcde7ce9d94b60f29fa
         * name : 戴森落地式无叶风扇AM08
         * member_id : 20
         * name_id : 14
         * fvalue : 戴森落地式无叶风扇AM08
         */

        @SerializedName("access_token")
        private String accessToken;
        @SerializedName("name")
        private String name;
        @SerializedName("member_id")
        private String memberId;
        @SerializedName("name_id")
        private String nameId;
        @SerializedName("fvalue")
        private String fvalue;

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMemberId() {
            return memberId;
        }

        public void setMemberId(String memberId) {
            this.memberId = memberId;
        }

        public String getNameId() {
            return nameId;
        }

        public void setNameId(String nameId) {
            this.nameId = nameId;
        }

        public String getFvalue() {
            return fvalue;
        }

        public void setFvalue(String fvalue) {
            this.fvalue = fvalue;
        }
    }
}
