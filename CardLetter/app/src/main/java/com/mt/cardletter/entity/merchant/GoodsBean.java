package com.mt.cardletter.entity.merchant;

/**
 * Created by jk on 2017/12/29.
 */

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * 商品
 */
public class GoodsBean implements Serializable {
    @SerializedName("result")
    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable{
        /**
         * shop_id : 11
         * shop_name : 月福汽车装饰(北洼路店)
         * shop_discounts : 享受10元洗车一次
         * shop_tel : 010-68464425
         * shop_deadline : 2020/12/31
         * shop_address : 北洼路东里5号
         * shop_card : 光大银行
         * shop_content :
         持光大银行信用卡1.活动期间，每周日在月福汽车装饰有限公司指定洗车行刷光大银行信用卡即可享受10元洗车一次。每人每周限参与一次。
         2.每店每个活动日10个名额，权益数额有限，额满为止。首都机场T2、T3航站楼两家月福洗车门店不参与活动。
         3.可参与活动车型：五座(含)以下小轿车；车辆规格：车长：5300毫米以内、车宽：2000毫米以内、车高：2200毫米以内、胎宽：275毫米以内。
         * city : 北京
         * discounts_type : 汽车
         */

        @SerializedName("shop_id")
        private int shopId;
        @SerializedName("shop_name")
        private String shopName;
        @SerializedName("shop_discounts")
        private String shopDiscounts;
        @SerializedName("shop_tel")
        private String shopTel;
        @SerializedName("shop_deadline")
        private String shopDeadline;
        @SerializedName("shop_address")
        private String shopAddress;
        @SerializedName("shop_card")
        private String shopCard;
        @SerializedName("shop_content")
        private String shopContent;
        @SerializedName("city")
        private String city;
        @SerializedName("discounts_type")
        private String discountsType;

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getShopDiscounts() {
            return shopDiscounts;
        }
        public void setShopDiscounts(String shopDiscounts) {
            this.shopDiscounts = shopDiscounts;
        }

        public String getShopTel() {
            return shopTel;
        }

        public void setShopTel(String shopTel) {
            this.shopTel = shopTel;
        }

        public String getShopDeadline() {
            return shopDeadline;
        }

        public void setShopDeadline(String shopDeadline) {
            this.shopDeadline = shopDeadline;
        }

        public String getShopAddress() {
            return shopAddress;
        }

        public void setShopAddress(String shopAddress) {
            this.shopAddress = shopAddress;
        }

        public String getShopCard() {
            return shopCard;
        }

        public void setShopCard(String shopCard) {
            this.shopCard = shopCard;
        }

        public String getShopContent() {
            return shopContent;
        }

        public void setShopContent(String shopContent) {
            this.shopContent = shopContent;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDiscountsType() {
            return discountsType;
        }

        public void setDiscountsType(String discountsType) {
            this.discountsType = discountsType;
        }
    }
}
