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
     * data : {"member_id":55,"nickname":"aaaAA","username":"aaaAA","mybank":"","myliked":"","create_time":"2018-02-02 15:50:44","user_token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJLYXhpbiBKV1QiLCJpYXQiOjE1MTc1NTc4NDQsImV4cCI6MzAzNTExNTY4OCwiYXVkIjoiS2F4aW4iLCJzdWIiOiJLYXhpbiIsImRhdGEiOnsibWVtYmVyX2lkIjo1NSwibmlja25hbWUiOiJhYWFBQSIsInVzZXJuYW1lIjoiYWFhQUEiLCJteWJhbmsiOiIiLCJteWxpa2VkIjoiIiwiY3JlYXRlX3RpbWUiOiIyMDE4LTAyLTAyIDE1OjUwOjQ0In19.bz0t3Gd0_fU51ufCCWdePUyHF3sgP0g1D8kJQUTngzc","data_sign":"8928e287d8efac504e8b5ff92554f61ad79e1216"}
     * exe_time : 0.016190
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
         * member_id : 55
         * nickname : aaaAA
         * username : aaaAA
         * mybank :
         * myliked :
         * create_time : 2018-02-02 15:50:44
         * user_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJLYXhpbiBKV1QiLCJpYXQiOjE1MTc1NTc4NDQsImV4cCI6MzAzNTExNTY4OCwiYXVkIjoiS2F4aW4iLCJzdWIiOiJLYXhpbiIsImRhdGEiOnsibWVtYmVyX2lkIjo1NSwibmlja25hbWUiOiJhYWFBQSIsInVzZXJuYW1lIjoiYWFhQUEiLCJteWJhbmsiOiIiLCJteWxpa2VkIjoiIiwiY3JlYXRlX3RpbWUiOiIyMDE4LTAyLTAyIDE1OjUwOjQ0In19.bz0t3Gd0_fU51ufCCWdePUyHF3sgP0g1D8kJQUTngzc
         * data_sign : 8928e287d8efac504e8b5ff92554f61ad79e1216
         */

        @SerializedName("member_id")
        private String memberId;
        @SerializedName("nickname")
        private String nickname;
        @SerializedName("username")
        private String username;
        @SerializedName("mybank")
        private String mybank;
        @SerializedName("myliked")
        private String myliked;
        @SerializedName("create_time")
        private String createTime;
        @SerializedName("user_token")
        private String userToken;
        @SerializedName("data_sign")
        private String dataSign;

        public String getMemberId() {
            return memberId;
        }

        public void setMemberId(String memberId) {
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

        public String getMyliked() {
            return myliked;
        }

        public void setMyliked(String myliked) {
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
