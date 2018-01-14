package com.mt.cardletter.entity.merchant;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jk on 2018/1/9.
 * 商家优惠详情
 */

public class Good {

    /**
     * code : 0
     * msg : 操作成功
     * data : {"id":13,"name":"月福汽车装饰(百旺山店)","category_id":"11","describe":"享受10元洗车一次","thumb":null,"address":"永丰路269号百望山北侧(中海枫涟册庄南)","city":"北京","lng":40.0462,"lat":116.258,"bankcard":"14","tel":"010-82404951","deadline":"2020/12/31","thumbs":null,"content":"\n持光大银行信用卡1活动期间，每周日在月福汽车装饰有限公司指定洗车行刷光大银行信用卡即可享受10元洗车一次。每人每周限参与一次。\n2.每店每个活动日10个名额，权益数额有限，额满为止。首都机场T2、T3航站楼两家月福洗车门店不参与活动。\n3.可参与活动车型：五座(含)以下小轿车；车辆规格：车长：5300毫米以内、车宽：2000毫米以内、车高：2200毫米以内、胎宽：275毫米以内。\n\n                ","create_time":"2017-12-26 12:47:42"}
     * exe_time : 0.030001
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
         * id : 13
         * name : 月福汽车装饰(百旺山店)
         * category_id : 11
         * describe : 享受10元洗车一次
         * thumb : null
         * address : 永丰路269号百望山北侧(中海枫涟册庄南)
         * city : 北京
         * lng : 40.0462
         * lat : 116.258
         * bankcard : 14
         * tel : 010-82404951
         * deadline : 2020/12/31
         * thumbs : null
         * content :
         持光大银行信用卡1活动期间，每周日在月福汽车装饰有限公司指定洗车行刷光大银行信用卡即可享受10元洗车一次。每人每周限参与一次。
         2.每店每个活动日10个名额，权益数额有限，额满为止。首都机场T2、T3航站楼两家月福洗车门店不参与活动。
         3.可参与活动车型：五座(含)以下小轿车；车辆规格：车长：5300毫米以内、车宽：2000毫米以内、车高：2200毫米以内、胎宽：275毫米以内。


         * create_time : 2017-12-26 12:47:42
         */
        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("category_id")
        private String categoryId;
        @SerializedName("describe")
        private String describe;
        @SerializedName("thumb")
        private Object thumb;
        @SerializedName("address")
        private String address;
        @SerializedName("city")
        private String city;
        @SerializedName("lng")
        private double lng;
        @SerializedName("lat")
        private double lat;
        @SerializedName("bankcard")
        private String bankcard;
        @SerializedName("tel")
        private String tel;
        @SerializedName("deadline")
        private String deadline;
        @SerializedName("thumbs")
        private Object thumbs;
        @SerializedName("content")
        private String content;
        @SerializedName("create_time")
        private String createTime;

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

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public Object getThumb() {
            return thumb;
        }

        public void setThumb(Object thumb) {
            this.thumb = thumb;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public String getBankcard() {
            return bankcard;
        }

        public void setBankcard(String bankcard) {
            this.bankcard = bankcard;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getDeadline() {
            return deadline;
        }

        public void setDeadline(String deadline) {
            this.deadline = deadline;
        }

        public Object getThumbs() {
            return thumbs;
        }

        public void setThumbs(Object thumbs) {
            this.thumbs = thumbs;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }
    }
}
