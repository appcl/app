package com.mt.cardletter.entity.merchant;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jk on 2018/2/6.
 * 获取用户关注银行卡
 */

public class MyBankBack {


    /**
     * code : 0
     * msg : 操作成功
     * data : [{"id":18,"name":"杭州银行","card_icon":"/upload/bank/icon/b19_big.png","card_thumb":"/upload/bank/thumb/card18.png","card_img":"/upload/bank/bank/y18.png"},{"id":13,"name":"北京银行","card_icon":"/upload/bank/icon/b14_big.png","card_thumb":"/upload/bank/thumb/card13.png","card_img":"/upload/bank/bank/y13.png"},{"id":9,"name":"建设银行","card_icon":"/upload/bank/icon/b10_big.png","card_thumb":"/upload/bank/thumb/card9.png","card_img":"/upload/bank/bank/y9.png"}]
     * exe_time : 0.006310
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
         * id : 18
         * name : 杭州银行
         * card_icon : /upload/bank/icon/b19_big.png
         * card_thumb : /upload/bank/thumb/card18.png
         * card_img : /upload/bank/bank/y18.png
         */

        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("card_icon")
        private String cardIcon;
        @SerializedName("card_thumb")
        private String cardThumb;
        @SerializedName("card_img")
        private String cardImg;

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

        public String getCardIcon() {
            return cardIcon;
        }

        public void setCardIcon(String cardIcon) {
            this.cardIcon = cardIcon;
        }

        public String getCardThumb() {
            return cardThumb;
        }

        public void setCardThumb(String cardThumb) {
            this.cardThumb = cardThumb;
        }

        public String getCardImg() {
            return cardImg;
        }

        public void setCardImg(String cardImg) {
            this.cardImg = cardImg;
        }
    }
}
