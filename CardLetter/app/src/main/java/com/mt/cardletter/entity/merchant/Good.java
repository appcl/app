package com.mt.cardletter.entity.merchant;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jk on 2018/1/9.
 * 商家优惠详情
 */

public class Good {

    /**
     * id : 12
     * name : 宽途汽车福翔顺发汽车服务中心
     * category_id : 11
     * describe : 6折
     * thumb : /upload/shop_pic/2/12/999.jpg
     * address : 赵登禹路114号
     * city : 110000
     * lng : 39.930561
     * lat : 116.367929
     * bankcard : 1
     * tel : 400-6666-377
     * deadline : 2020/12/31
     * thumbs : null
     * content :
     工银信用卡在我行指定的宽途门店积分兑换宽途储值洗车卡，持卡人可使用宽途洗车卡在去昂过1287家宽途洗车门店结算，并享受市场价6-7折的专业洗车服务;每600信用卡综合积分兑换1宽途积分，持卡人每次可兑换积分数为50、100、200、500的宽途洗车卡

     * create_time : 2017-12-27 14:12:29
     * data : 0
     * exe_time : 0.006033
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
    private String thumb;
    @SerializedName("address")
    private String address;
    @SerializedName("city")
    private String city;
    @SerializedName("lng")
    private String lng;
    @SerializedName("lat")
    private String lat;
    @SerializedName("bankcard")
    private String bankcard;
    @SerializedName("tel")
    private String tel;
    @SerializedName("deadline")
    private String deadline;
    @SerializedName("thumbs")
    private String thumbs;
    @SerializedName("content")
    private String content;
    @SerializedName("create_time")
    private String createTime;
    @SerializedName("data")
    private int data;
    @SerializedName("exe_time")
    private String exeTime;

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

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
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

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
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

    public String getThumbs() {
        return thumbs;
    }

    public void setThumbs(String thumbs) {
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

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getExeTime() {
        return exeTime;
    }

    public void setExeTime(String exeTime) {
        this.exeTime = exeTime;
    }
}
