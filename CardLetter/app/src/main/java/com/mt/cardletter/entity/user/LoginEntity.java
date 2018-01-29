package com.mt.cardletter.entity.user;

import com.google.gson.annotations.SerializedName;

/**
 * Date:2018/1/2
 * Time:9:57
 * author:demons
 */

public class LoginEntity {
    /**
     * code : 0
     * msg : 操作成功
     * data : {"member_id":25,"nickname":"12","username":"12","mybank":"1","myliked":null,"create_time":"2018-01-23 15:25:27","user_token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJLYXhpbiBKV1QiLCJpYXQiOjE1MTY2OTY2MDQsImV4cCI6MzAzMzM5MzIwOCwiYXVkIjoiS2F4aW4iLCJzdWIiOiJLYXhpbiIsImRhdGEiOnsibWVtYmVyX2lkIjoyNSwibmlja25hbWUiOiIxMiIsInVzZXJuYW1lIjoiMTIiLCJteWJhbmsiOiIxIiwibXlsaWtlZCI6bnVsbCwiY3JlYXRlX3RpbWUiOiIyMDE4LTAxLTIzIDE1OjI1OjI3In19.dLl6JU269rcF46jms_h9NnW32QvLVVlI1xl3jkpzmSQ","data_sign":"543334cdde45d8a55bbabd5faa53051d051b424a"}
     * exe_time : 0.004581
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
         * member_id : 25
         * nickname : 12
         * username : 12
         * mybank : 1
         * myliked : null
         * create_time : 2018-01-23 15:25:27
         * user_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJLYXhpbiBKV1QiLCJpYXQiOjE1MTY2OTY2MDQsImV4cCI6MzAzMzM5MzIwOCwiYXVkIjoiS2F4aW4iLCJzdWIiOiJLYXhpbiIsImRhdGEiOnsibWVtYmVyX2lkIjoyNSwibmlja25hbWUiOiIxMiIsInVzZXJuYW1lIjoiMTIiLCJteWJhbmsiOiIxIiwibXlsaWtlZCI6bnVsbCwiY3JlYXRlX3RpbWUiOiIyMDE4LTAxLTIzIDE1OjI1OjI3In19.dLl6JU269rcF46jms_h9NnW32QvLVVlI1xl3jkpzmSQ
         * data_sign : 543334cdde45d8a55bbabd5faa53051d051b424a
         */

        @SerializedName("member_id")
        private int memberId;
        @SerializedName("nickname")
        private String nickname;
        @SerializedName("username")
        private String username;
        @SerializedName("mybank")
        private String mybank;
        @SerializedName("myliked")
        private Object myliked;
        @SerializedName("create_time")
        private String createTime;
        @SerializedName("user_token")
        private String userToken;
        @SerializedName("data_sign")
        private String dataSign;

        public int getMemberId() {
            return memberId;
        }

        public void setMemberId(int memberId) {
            this.memberId = memberId;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getMybank() {
            return mybank;
        }

        public void setMybank(String mybank) {
            this.mybank = mybank;
        }

        public Object getMyliked() {
            return myliked;
        }

        public void setMyliked(Object myliked) {
            this.myliked = myliked;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUserToken() {
            return userToken;
        }

        public void setUserToken(String userToken) {
            this.userToken = userToken;
        }

        public String getDataSign() {
            return dataSign;
        }

        public void setDataSign(String dataSign) {
            this.dataSign = dataSign;
        }
    }
}
