package com.mt.cardletter.entity.merchant;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by JK on 2018/1/6.
 *
 * 银行列表
 */

public class Bank {


    /**
     * code : 0
     * msg : 操作成功
     * data : [{"id":1,"name":"工商银行","describe":"中国工商银行，国有四大银行之一","card_icon":"/upload/bank/icon/b1.png","card_thumb":"","card_img":"/upload/bank/bank/y1.png"},{"id":2,"name":"招商银行","describe":"招商银行是国内大型银行之一","card_icon":"/upload/bank/icon/b4.png","card_thumb":"","card_img":"/upload/bank/bank/y2.png"},{"id":3,"name":"中国银行","describe":"中国银行是国有四大银行之一","card_icon":"/upload/bank/icon/b5.png","card_thumb":"","card_img":"/upload/bank/bank/y3.png"},{"id":4,"name":"广发银行","describe":"广东发展银行","card_icon":"/upload/bank/icon/b6.png","card_thumb":"","card_img":"/upload/bank/bank/y4.png"},{"id":5,"name":"交通银行","describe":"交通银行","card_icon":"/upload/bank/icon/b3.png","card_thumb":"","card_img":"/upload/bank/bank/y5.png"},{"id":6,"name":"华夏银行","describe":"华夏银行是商业银行","card_icon":"/upload/bank/icon/b7.png","card_thumb":"","card_img":"/upload/bank/bank/y6.png"},{"id":7,"name":"农业银行","describe":"中国农业银行，国有四大商业银行之一","card_icon":"/upload/bank/icon/b8.png","card_thumb":"","card_img":"/upload/bank/bank/y7.png"},{"id":8,"name":"兴业银行","describe":"兴业银行，商业银行之一","card_icon":"/upload/bank/icon/b9.png","card_thumb":"","card_img":"/upload/bank/bank/y8.png"},{"id":9,"name":"建设银行","describe":"中国建设银行，国有四大商业银行之一","card_icon":"/upload/bank/icon/b10.png","card_thumb":"","card_img":"/upload/bank/bank/y9.png"},{"id":10,"name":"浦发银行","describe":"浦东发展银行","card_icon":"/upload/bank/icon/b11.png","card_thumb":"","card_img":"/upload/bank/bank/y10.png"},{"id":11,"name":"民生银行","describe":"中国民生银行，商业银行之一","card_icon":"/upload/bank/icon/b12.png","card_thumb":"","card_img":"/upload/bank/bank/y11.png"},{"id":12,"name":"南京银行","describe":"南京银行，商业银行","card_icon":"/upload/bank/icon/b13.png","card_thumb":"","card_img":"/upload/bank/bank/y12.png"},{"id":13,"name":"北京银行","describe":"北京商业银行","card_icon":"/upload/bank/icon/b14.png","card_thumb":"","card_img":"/upload/bank/bank/y13.png"},{"id":14,"name":"光大银行","describe":"中国光大银行，商业银行","card_icon":"/upload/bank/icon/b15.png","card_thumb":"","card_img":"/upload/bank/bank/y14.png"},{"id":15,"name":"平安银行","describe":"中国平安银行，国有商业银行","card_icon":"/upload/bank/icon/b16.png","card_thumb":"","card_img":"/upload/bank/bank/y15.png"},{"id":16,"name":"中信银行","describe":"中信银行，商业银行之一","card_icon":"/upload/bank/icon/b17.png","card_thumb":"","card_img":"/upload/bank/bank/y16.png"},{"id":17,"name":"上海农商","describe":"上海农商银行","card_icon":"/upload/bank/icon/b18.png","card_thumb":"","card_img":"/upload/bank/bank/y17.png"},{"id":18,"name":"杭州银行","describe":"杭州银行，商业银行","card_icon":"/upload/bank/icon/b19.png","card_thumb":"","card_img":"/upload/bank/bank/y18.png"},{"id":19,"name":"江苏银行","describe":"江苏银行，商业银行","card_icon":"/upload/bank/icon/b20.png","card_thumb":"","card_img":"/upload/bank/bank/y19.png"},{"id":20,"name":"上海银行","describe":"上海商业银行，商业银行","card_icon":"/upload/bank/icon/b21.png","card_thumb":"","card_img":"/upload/bank/bank/y20.png"},{"id":21,"name":"花旗银行","describe":"花旗银行，外资银行","card_icon":"/upload/bank/icon/b22.png","card_thumb":"","card_img":"/upload/bank/bank/y21.png"},{"id":22,"name":"银联","describe":"银联","card_icon":"/upload/bank/icon/b23.png","card_thumb":"","card_img":"/upload/bank/bank/y22.png"},{"id":23,"name":"邮储银行","describe":"邮政储蓄银行","card_icon":"/upload/bank/icon/b24.png","card_thumb":"","card_img":"/upload/bank/bank/y23.png"},{"id":24,"name":"天津银行","describe":"天津银行，商业银行","card_icon":"/upload/bank/icon/b25.png","card_thumb":"","card_img":"/upload/bank/bank/y24.png"},{"id":25,"name":"广州银行","describe":"广州商业银行","card_icon":"/upload/bank/icon/b26.png","card_thumb":"","card_img":"/upload/bank/bank/y25.png"},{"id":26,"name":"渤海银行","describe":"渤海商业银行","card_icon":"/upload/bank/icon/b27.png","card_thumb":"","card_img":"/upload/bank/bank/y26.png"},{"id":27,"name":"浙商银行","describe":"浙江商业银行","card_icon":"/upload/bank/icon/b28.png","card_thumb":"","card_img":"/upload/bank/bank/y27.png"},{"id":28,"name":"北京农商","describe":"北京农商银行","card_icon":"/upload/bank/icon/b29.png","card_thumb":"","card_img":"/upload/bank/bank/y28.png"},{"id":29,"name":"广州农商","describe":"广州农商银行","card_icon":"/upload/bank/icon/b30.png","card_thumb":"","card_img":"/upload/bank/bank/y29.png"},{"id":30,"name":"汇丰银行","describe":"商业银行，外资银行","card_icon":"/upload/bank/icon/b31.png","card_thumb":"","card_img":"/upload/bank/bank/y30.png"},{"id":31,"name":"东亚银行","describe":"日本商业银行，外资银行","card_icon":"","card_thumb":"","card_img":""}]
     * exe_time : 0.031002
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
         * id : 1
         * name : 工商银行
         * describe : 中国工商银行，国有四大银行之一
         * card_icon : /upload/bank/icon/b1.png
         * card_thumb :
         * card_img : /upload/bank/bank/y1.png
         */

        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("describe")
        private String describe;
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

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
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
