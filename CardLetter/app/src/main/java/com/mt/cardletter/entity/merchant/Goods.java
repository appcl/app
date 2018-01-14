package com.mt.cardletter.entity.merchant;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jk on 2018/1/5.
 * 商家优惠列表
 */

public class Goods implements Serializable{


    /**
     * code : 0
     * msg : 操作成功
     * data : {"cardfind_list":{"total":12,"per_page":"10","current_page":"1","last_page":2,"data":[{"id":4179,"name":"涵沛女子","describe":"8折","tel":"025-84738687","deadline":"2020/12/31","address":"中山南路122号大洋百货8楼","bankcard":"9","city":"320100","lng":32.0387,"lat":118.783,"thumb":null,"thumbs":null,"category_id":"12","content":"\n商户名称： 南京涵沛女子SPA生活馆   优惠内容： 持龙卡消费单次体验芳疗护理享8折入会银卡赠7000点无折扣入会金卡赠3000点无折扣  截止时间： 长期  商户地址： 中山南路122号大洋百货8楼  商户电话： 025-84738687  \n                ","create_time":"2017-12-26 12:47:42"},{"id":4184,"name":"经禅和按摩","describe":"9折","tel":"025-86668466","deadline":"2020/12/31","address":"王府大街65-2号","bankcard":"9","city":"320100","lng":32.0375,"lat":118.779,"thumb":"/upload/shop_pic/5/4184/999.jpg","thumbs":"/upload/shop_pic/5/4184/0.jpg,/upload/shop_pic/5/4184/1.jpg,/upload/shop_pic/5/4184/2.jpg","category_id":"12","content":"\n\n商户名称： 南京经禅和全息法按摩中心  优惠内容： 刷龙卡消费享受9折  截止时间： 长期  商户地址： 王府大街65-2号  商户电话： 025-86668466  商户介绍： 专业的技术，一流的服务，绿色疗法和养生的完美结合。虽是小店，但品质超越大店。  \n                ","create_time":"2017-12-26 12:47:42"},{"id":9507,"name":"涵沛女子","describe":"8折","tel":"025-84738687","deadline":"2020/12/31","address":"中山南路122号大洋百货8楼","bankcard":"9","city":"320100","lng":32.0387,"lat":118.783,"thumb":null,"thumbs":null,"category_id":"12","content":"\n商户名称： 南京涵沛女子SPA生活馆   优惠内容： 持龙卡消费单次体验芳疗护理享8折入会银卡赠7000点无折扣入会金卡赠3000点无折扣  截止时间： 长期  商户地址： 中山南路122号大洋百货8楼  商户电话： 025-84738687  \n                ","create_time":"2017-12-26 12:47:42"},{"id":9511,"name":"经禅和按摩","describe":"9折","tel":"025-86668466","deadline":"2020/12/31","address":"王府大街65-2号","bankcard":"9","city":"320100","lng":32.0375,"lat":118.779,"thumb":"/upload/shop_pic/5/9511/999.jpg","thumbs":"/upload/shop_pic/5/9511/0.jpg,/upload/shop_pic/5/9511/1.jpg,/upload/shop_pic/5/9511/2.jpg","category_id":"12","content":"\n\n商户名称： 南京经禅和全息法按摩中心  优惠内容： 刷龙卡消费享受9折  截止时间： 长期  商户地址： 王府大街65-2号  商户电话： 025-86668466  商户介绍： 专业的技术，一流的服务，绿色疗法和养生的完美结合。虽是小店，但品质超越大店。  \n                ","create_time":"2017-12-26 12:47:42"},{"id":9971,"name":"经禅和按摩","describe":"9折","tel":"025-86668466","deadline":"2020/12/31","address":"王府大街65-2号","bankcard":"9","city":"320100","lng":32.0375,"lat":118.779,"thumb":"/upload/shop_pic/5/9971/999.jpg","thumbs":"/upload/shop_pic/5/9971/0.jpg,/upload/shop_pic/5/9971/1.jpg,/upload/shop_pic/5/9971/2.jpg","category_id":"12","content":"\n\n商户名称： 南京经禅和全息法按摩中心  优惠内容： 刷龙卡消费享受9折  截止时间： 长期  商户地址： 王府大街65-2号  商户电话： 025-86668466  商户介绍： 专业的技术，一流的服务，绿色疗法和养生的完美结合。虽是小店，但品质超越大店。  \n                ","create_time":"2017-12-26 12:47:42"},{"id":9987,"name":"涵沛女子","describe":"8折","tel":"025-84738687","deadline":"2020/12/31","address":"中山南路122号大洋百货8楼","bankcard":"9","city":"320100","lng":32.0387,"lat":118.783,"thumb":null,"thumbs":null,"category_id":"12","content":"\n商户名称： 南京涵沛女子SPA生活馆   优惠内容： 持龙卡消费单次体验芳疗护理享8折入会银卡赠7000点无折扣入会金卡赠3000点无折扣  截止时间： 长期  商户地址： 中山南路122号大洋百货8楼  商户电话： 025-84738687  \n                ","create_time":"2017-12-26 12:47:42"},{"id":10426,"name":"经禅和按摩","describe":"9折","tel":"025-86668466","deadline":"2020/12/31","address":"王府大街65-2号","bankcard":"9","city":"320100","lng":32.0375,"lat":118.779,"thumb":"/upload/shop_pic/5/10426/999.jpg","thumbs":"/upload/shop_pic/5/10426/0.jpg,/upload/shop_pic/5/10426/1.jpg,/upload/shop_pic/5/10426/2.jpg","category_id":"12","content":"\n\n商户名称： 南京经禅和全息法按摩中心  优惠内容： 刷龙卡消费享受9折  截止时间： 长期  商户地址： 王府大街65-2号  商户电话： 025-86668466  商户介绍： 专业的技术，一流的服务，绿色疗法和养生的完美结合。虽是小店，但品质超越大店。  \n                ","create_time":"2017-12-26 12:47:42"},{"id":10427,"name":"涵沛女子","describe":"8折","tel":"025-84738687","deadline":"2020/12/31","address":"中山南路122号大洋百货8楼","bankcard":"9","city":"320100","lng":32.0387,"lat":118.783,"thumb":null,"thumbs":null,"category_id":"12","content":"\n商户名称： 南京涵沛女子SPA生活馆   优惠内容： 持龙卡消费单次体验芳疗护理享8折入会银卡赠7000点无折扣入会金卡赠3000点无折扣  截止时间： 长期  商户地址： 中山南路122号大洋百货8楼  商户电话： 025-84738687  \n                ","create_time":"2017-12-26 12:47:42"},{"id":10861,"name":"涵沛女子","describe":"8折","tel":"025-84738687","deadline":"2020/12/31","address":"中山南路122号大洋百货8楼","bankcard":"9","city":"320100","lng":32.0387,"lat":118.783,"thumb":null,"thumbs":null,"category_id":"12","content":"\n商户名称： 南京涵沛女子SPA生活馆   优惠内容： 持龙卡消费单次体验芳疗护理享8折入会银卡赠7000点无折扣入会金卡赠3000点无折扣  截止时间： 长期  商户地址： 中山南路122号大洋百货8楼  商户电话： 025-84738687  \n                ","create_time":"2017-12-26 12:47:42"},{"id":10871,"name":"经禅和按摩","describe":"9折","tel":"025-86668466","deadline":"2020/12/31","address":"王府大街65-2号","bankcard":"9","city":"320100","lng":32.0375,"lat":118.779,"thumb":"/upload/shop_pic/5/10871/999.jpg","thumbs":"/upload/shop_pic/5/10871/0.jpg,/upload/shop_pic/5/10871/1.jpg,/upload/shop_pic/5/10871/2.jpg","category_id":"12","content":"\n\n商户名称： 南京经禅和全息法按摩中心  优惠内容： 刷龙卡消费享受9折  截止时间： 长期  商户地址： 王府大街65-2号  商户电话： 025-86668466  商户介绍： 专业的技术，一流的服务，绿色疗法和养生的完美结合。虽是小店，但品质超越大店。  \n                ","create_time":"2017-12-26 12:47:42"}]}}
     * exe_time : 0.012960
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private DataBeanX data;
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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public String getExeTime() {
        return exeTime;
    }

    public void setExeTime(String exeTime) {
        this.exeTime = exeTime;
    }

    public static class DataBeanX implements Serializable {
        /**
         * cardfind_list : {"total":12,"per_page":"10","current_page":"1","last_page":2,"data":[{"id":4179,"name":"涵沛女子","describe":"8折","tel":"025-84738687","deadline":"2020/12/31","address":"中山南路122号大洋百货8楼","bankcard":"9","city":"320100","lng":32.0387,"lat":118.783,"thumb":null,"thumbs":null,"category_id":"12","content":"\n商户名称： 南京涵沛女子SPA生活馆   优惠内容： 持龙卡消费单次体验芳疗护理享8折入会银卡赠7000点无折扣入会金卡赠3000点无折扣  截止时间： 长期  商户地址： 中山南路122号大洋百货8楼  商户电话： 025-84738687  \n                ","create_time":"2017-12-26 12:47:42"},{"id":4184,"name":"经禅和按摩","describe":"9折","tel":"025-86668466","deadline":"2020/12/31","address":"王府大街65-2号","bankcard":"9","city":"320100","lng":32.0375,"lat":118.779,"thumb":"/upload/shop_pic/5/4184/999.jpg","thumbs":"/upload/shop_pic/5/4184/0.jpg,/upload/shop_pic/5/4184/1.jpg,/upload/shop_pic/5/4184/2.jpg","category_id":"12","content":"\n\n商户名称： 南京经禅和全息法按摩中心  优惠内容： 刷龙卡消费享受9折  截止时间： 长期  商户地址： 王府大街65-2号  商户电话： 025-86668466  商户介绍： 专业的技术，一流的服务，绿色疗法和养生的完美结合。虽是小店，但品质超越大店。  \n                ","create_time":"2017-12-26 12:47:42"},{"id":9507,"name":"涵沛女子","describe":"8折","tel":"025-84738687","deadline":"2020/12/31","address":"中山南路122号大洋百货8楼","bankcard":"9","city":"320100","lng":32.0387,"lat":118.783,"thumb":null,"thumbs":null,"category_id":"12","content":"\n商户名称： 南京涵沛女子SPA生活馆   优惠内容： 持龙卡消费单次体验芳疗护理享8折入会银卡赠7000点无折扣入会金卡赠3000点无折扣  截止时间： 长期  商户地址： 中山南路122号大洋百货8楼  商户电话： 025-84738687  \n                ","create_time":"2017-12-26 12:47:42"},{"id":9511,"name":"经禅和按摩","describe":"9折","tel":"025-86668466","deadline":"2020/12/31","address":"王府大街65-2号","bankcard":"9","city":"320100","lng":32.0375,"lat":118.779,"thumb":"/upload/shop_pic/5/9511/999.jpg","thumbs":"/upload/shop_pic/5/9511/0.jpg,/upload/shop_pic/5/9511/1.jpg,/upload/shop_pic/5/9511/2.jpg","category_id":"12","content":"\n\n商户名称： 南京经禅和全息法按摩中心  优惠内容： 刷龙卡消费享受9折  截止时间： 长期  商户地址： 王府大街65-2号  商户电话： 025-86668466  商户介绍： 专业的技术，一流的服务，绿色疗法和养生的完美结合。虽是小店，但品质超越大店。  \n                ","create_time":"2017-12-26 12:47:42"},{"id":9971,"name":"经禅和按摩","describe":"9折","tel":"025-86668466","deadline":"2020/12/31","address":"王府大街65-2号","bankcard":"9","city":"320100","lng":32.0375,"lat":118.779,"thumb":"/upload/shop_pic/5/9971/999.jpg","thumbs":"/upload/shop_pic/5/9971/0.jpg,/upload/shop_pic/5/9971/1.jpg,/upload/shop_pic/5/9971/2.jpg","category_id":"12","content":"\n\n商户名称： 南京经禅和全息法按摩中心  优惠内容： 刷龙卡消费享受9折  截止时间： 长期  商户地址： 王府大街65-2号  商户电话： 025-86668466  商户介绍： 专业的技术，一流的服务，绿色疗法和养生的完美结合。虽是小店，但品质超越大店。  \n                ","create_time":"2017-12-26 12:47:42"},{"id":9987,"name":"涵沛女子","describe":"8折","tel":"025-84738687","deadline":"2020/12/31","address":"中山南路122号大洋百货8楼","bankcard":"9","city":"320100","lng":32.0387,"lat":118.783,"thumb":null,"thumbs":null,"category_id":"12","content":"\n商户名称： 南京涵沛女子SPA生活馆   优惠内容： 持龙卡消费单次体验芳疗护理享8折入会银卡赠7000点无折扣入会金卡赠3000点无折扣  截止时间： 长期  商户地址： 中山南路122号大洋百货8楼  商户电话： 025-84738687  \n                ","create_time":"2017-12-26 12:47:42"},{"id":10426,"name":"经禅和按摩","describe":"9折","tel":"025-86668466","deadline":"2020/12/31","address":"王府大街65-2号","bankcard":"9","city":"320100","lng":32.0375,"lat":118.779,"thumb":"/upload/shop_pic/5/10426/999.jpg","thumbs":"/upload/shop_pic/5/10426/0.jpg,/upload/shop_pic/5/10426/1.jpg,/upload/shop_pic/5/10426/2.jpg","category_id":"12","content":"\n\n商户名称： 南京经禅和全息法按摩中心  优惠内容： 刷龙卡消费享受9折  截止时间： 长期  商户地址： 王府大街65-2号  商户电话： 025-86668466  商户介绍： 专业的技术，一流的服务，绿色疗法和养生的完美结合。虽是小店，但品质超越大店。  \n                ","create_time":"2017-12-26 12:47:42"},{"id":10427,"name":"涵沛女子","describe":"8折","tel":"025-84738687","deadline":"2020/12/31","address":"中山南路122号大洋百货8楼","bankcard":"9","city":"320100","lng":32.0387,"lat":118.783,"thumb":null,"thumbs":null,"category_id":"12","content":"\n商户名称： 南京涵沛女子SPA生活馆   优惠内容： 持龙卡消费单次体验芳疗护理享8折入会银卡赠7000点无折扣入会金卡赠3000点无折扣  截止时间： 长期  商户地址： 中山南路122号大洋百货8楼  商户电话： 025-84738687  \n                ","create_time":"2017-12-26 12:47:42"},{"id":10861,"name":"涵沛女子","describe":"8折","tel":"025-84738687","deadline":"2020/12/31","address":"中山南路122号大洋百货8楼","bankcard":"9","city":"320100","lng":32.0387,"lat":118.783,"thumb":null,"thumbs":null,"category_id":"12","content":"\n商户名称： 南京涵沛女子SPA生活馆   优惠内容： 持龙卡消费单次体验芳疗护理享8折入会银卡赠7000点无折扣入会金卡赠3000点无折扣  截止时间： 长期  商户地址： 中山南路122号大洋百货8楼  商户电话： 025-84738687  \n                ","create_time":"2017-12-26 12:47:42"},{"id":10871,"name":"经禅和按摩","describe":"9折","tel":"025-86668466","deadline":"2020/12/31","address":"王府大街65-2号","bankcard":"9","city":"320100","lng":32.0375,"lat":118.779,"thumb":"/upload/shop_pic/5/10871/999.jpg","thumbs":"/upload/shop_pic/5/10871/0.jpg,/upload/shop_pic/5/10871/1.jpg,/upload/shop_pic/5/10871/2.jpg","category_id":"12","content":"\n\n商户名称： 南京经禅和全息法按摩中心  优惠内容： 刷龙卡消费享受9折  截止时间： 长期  商户地址： 王府大街65-2号  商户电话： 025-86668466  商户介绍： 专业的技术，一流的服务，绿色疗法和养生的完美结合。虽是小店，但品质超越大店。  \n                ","create_time":"2017-12-26 12:47:42"}]}
         */

        @SerializedName("cardfind_list")
        private CardfindListBean cardfindList;

        public CardfindListBean getCardfindList() {
            return cardfindList;
        }

        public void setCardfindList(CardfindListBean cardfindList) {
            this.cardfindList = cardfindList;
        }

        public static class CardfindListBean implements Serializable{
            /**
             * total : 12
             * per_page : 10
             * current_page : 1
             * last_page : 2
             * data : [{"id":4179,"name":"涵沛女子","describe":"8折","tel":"025-84738687","deadline":"2020/12/31","address":"中山南路122号大洋百货8楼","bankcard":"9","city":"320100","lng":32.0387,"lat":118.783,"thumb":null,"thumbs":null,"category_id":"12","content":"\n商户名称： 南京涵沛女子SPA生活馆   优惠内容： 持龙卡消费单次体验芳疗护理享8折入会银卡赠7000点无折扣入会金卡赠3000点无折扣  截止时间： 长期  商户地址： 中山南路122号大洋百货8楼  商户电话： 025-84738687  \n                ","create_time":"2017-12-26 12:47:42"},{"id":4184,"name":"经禅和按摩","describe":"9折","tel":"025-86668466","deadline":"2020/12/31","address":"王府大街65-2号","bankcard":"9","city":"320100","lng":32.0375,"lat":118.779,"thumb":"/upload/shop_pic/5/4184/999.jpg","thumbs":"/upload/shop_pic/5/4184/0.jpg,/upload/shop_pic/5/4184/1.jpg,/upload/shop_pic/5/4184/2.jpg","category_id":"12","content":"\n\n商户名称： 南京经禅和全息法按摩中心  优惠内容： 刷龙卡消费享受9折  截止时间： 长期  商户地址： 王府大街65-2号  商户电话： 025-86668466  商户介绍： 专业的技术，一流的服务，绿色疗法和养生的完美结合。虽是小店，但品质超越大店。  \n                ","create_time":"2017-12-26 12:47:42"},{"id":9507,"name":"涵沛女子","describe":"8折","tel":"025-84738687","deadline":"2020/12/31","address":"中山南路122号大洋百货8楼","bankcard":"9","city":"320100","lng":32.0387,"lat":118.783,"thumb":null,"thumbs":null,"category_id":"12","content":"\n商户名称： 南京涵沛女子SPA生活馆   优惠内容： 持龙卡消费单次体验芳疗护理享8折入会银卡赠7000点无折扣入会金卡赠3000点无折扣  截止时间： 长期  商户地址： 中山南路122号大洋百货8楼  商户电话： 025-84738687  \n                ","create_time":"2017-12-26 12:47:42"},{"id":9511,"name":"经禅和按摩","describe":"9折","tel":"025-86668466","deadline":"2020/12/31","address":"王府大街65-2号","bankcard":"9","city":"320100","lng":32.0375,"lat":118.779,"thumb":"/upload/shop_pic/5/9511/999.jpg","thumbs":"/upload/shop_pic/5/9511/0.jpg,/upload/shop_pic/5/9511/1.jpg,/upload/shop_pic/5/9511/2.jpg","category_id":"12","content":"\n\n商户名称： 南京经禅和全息法按摩中心  优惠内容： 刷龙卡消费享受9折  截止时间： 长期  商户地址： 王府大街65-2号  商户电话： 025-86668466  商户介绍： 专业的技术，一流的服务，绿色疗法和养生的完美结合。虽是小店，但品质超越大店。  \n                ","create_time":"2017-12-26 12:47:42"},{"id":9971,"name":"经禅和按摩","describe":"9折","tel":"025-86668466","deadline":"2020/12/31","address":"王府大街65-2号","bankcard":"9","city":"320100","lng":32.0375,"lat":118.779,"thumb":"/upload/shop_pic/5/9971/999.jpg","thumbs":"/upload/shop_pic/5/9971/0.jpg,/upload/shop_pic/5/9971/1.jpg,/upload/shop_pic/5/9971/2.jpg","category_id":"12","content":"\n\n商户名称： 南京经禅和全息法按摩中心  优惠内容： 刷龙卡消费享受9折  截止时间： 长期  商户地址： 王府大街65-2号  商户电话： 025-86668466  商户介绍： 专业的技术，一流的服务，绿色疗法和养生的完美结合。虽是小店，但品质超越大店。  \n                ","create_time":"2017-12-26 12:47:42"},{"id":9987,"name":"涵沛女子","describe":"8折","tel":"025-84738687","deadline":"2020/12/31","address":"中山南路122号大洋百货8楼","bankcard":"9","city":"320100","lng":32.0387,"lat":118.783,"thumb":null,"thumbs":null,"category_id":"12","content":"\n商户名称： 南京涵沛女子SPA生活馆   优惠内容： 持龙卡消费单次体验芳疗护理享8折入会银卡赠7000点无折扣入会金卡赠3000点无折扣  截止时间： 长期  商户地址： 中山南路122号大洋百货8楼  商户电话： 025-84738687  \n                ","create_time":"2017-12-26 12:47:42"},{"id":10426,"name":"经禅和按摩","describe":"9折","tel":"025-86668466","deadline":"2020/12/31","address":"王府大街65-2号","bankcard":"9","city":"320100","lng":32.0375,"lat":118.779,"thumb":"/upload/shop_pic/5/10426/999.jpg","thumbs":"/upload/shop_pic/5/10426/0.jpg,/upload/shop_pic/5/10426/1.jpg,/upload/shop_pic/5/10426/2.jpg","category_id":"12","content":"\n\n商户名称： 南京经禅和全息法按摩中心  优惠内容： 刷龙卡消费享受9折  截止时间： 长期  商户地址： 王府大街65-2号  商户电话： 025-86668466  商户介绍： 专业的技术，一流的服务，绿色疗法和养生的完美结合。虽是小店，但品质超越大店。  \n                ","create_time":"2017-12-26 12:47:42"},{"id":10427,"name":"涵沛女子","describe":"8折","tel":"025-84738687","deadline":"2020/12/31","address":"中山南路122号大洋百货8楼","bankcard":"9","city":"320100","lng":32.0387,"lat":118.783,"thumb":null,"thumbs":null,"category_id":"12","content":"\n商户名称： 南京涵沛女子SPA生活馆   优惠内容： 持龙卡消费单次体验芳疗护理享8折入会银卡赠7000点无折扣入会金卡赠3000点无折扣  截止时间： 长期  商户地址： 中山南路122号大洋百货8楼  商户电话： 025-84738687  \n                ","create_time":"2017-12-26 12:47:42"},{"id":10861,"name":"涵沛女子","describe":"8折","tel":"025-84738687","deadline":"2020/12/31","address":"中山南路122号大洋百货8楼","bankcard":"9","city":"320100","lng":32.0387,"lat":118.783,"thumb":null,"thumbs":null,"category_id":"12","content":"\n商户名称： 南京涵沛女子SPA生活馆   优惠内容： 持龙卡消费单次体验芳疗护理享8折入会银卡赠7000点无折扣入会金卡赠3000点无折扣  截止时间： 长期  商户地址： 中山南路122号大洋百货8楼  商户电话： 025-84738687  \n                ","create_time":"2017-12-26 12:47:42"},{"id":10871,"name":"经禅和按摩","describe":"9折","tel":"025-86668466","deadline":"2020/12/31","address":"王府大街65-2号","bankcard":"9","city":"320100","lng":32.0375,"lat":118.779,"thumb":"/upload/shop_pic/5/10871/999.jpg","thumbs":"/upload/shop_pic/5/10871/0.jpg,/upload/shop_pic/5/10871/1.jpg,/upload/shop_pic/5/10871/2.jpg","category_id":"12","content":"\n\n商户名称： 南京经禅和全息法按摩中心  优惠内容： 刷龙卡消费享受9折  截止时间： 长期  商户地址： 王府大街65-2号  商户电话： 025-86668466  商户介绍： 专业的技术，一流的服务，绿色疗法和养生的完美结合。虽是小店，但品质超越大店。  \n                ","create_time":"2017-12-26 12:47:42"}]
             */

            @SerializedName("total")
            private int total;
            @SerializedName("per_page")
            private String perPage;
            @SerializedName("current_page")
            private String currentPage;
            @SerializedName("last_page")
            private int lastPage;
            @SerializedName("data")
            private List<DataBean> data;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public String getPerPage() {
                return perPage;
            }

            public void setPerPage(String perPage) {
                this.perPage = perPage;
            }

            public String getCurrentPage() {
                return currentPage;
            }

            public void setCurrentPage(String currentPage) {
                this.currentPage = currentPage;
            }

            public int getLastPage() {
                return lastPage;
            }

            public void setLastPage(int lastPage) {
                this.lastPage = lastPage;
            }

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public static class DataBean implements Serializable{
                /**
                 * id : 4179
                 * name : 涵沛女子
                 * describe : 8折
                 * tel : 025-84738687
                 * deadline : 2020/12/31
                 * address : 中山南路122号大洋百货8楼
                 * bankcard : 9
                 * city : 320100
                 * lng : 32.0387
                 * lat : 118.783
                 * thumb : null
                 * thumbs : null
                 * category_id : 12
                 * content :
                 商户名称： 南京涵沛女子SPA生活馆   优惠内容： 持龙卡消费单次体验芳疗护理享8折入会银卡赠7000点无折扣入会金卡赠3000点无折扣  截止时间： 长期  商户地址： 中山南路122号大洋百货8楼  商户电话： 025-84738687

                 * create_time : 2017-12-26 12:47:42
                 */

                @SerializedName("id")
                private int id;
                @SerializedName("name")
                private String name;
                @SerializedName("describe")
                private String describe;
                @SerializedName("tel")
                private String tel;
                @SerializedName("deadline")
                private String deadline;
                @SerializedName("address")
                private String address;
                @SerializedName("bankcard")
                private String bankcard;
                @SerializedName("city")
                private String city;
                @SerializedName("lng")
                private double lng;
                @SerializedName("lat")
                private double lat;
                @SerializedName("thumb")
                private Object thumb;
                @SerializedName("thumbs")
                private Object thumbs;
                @SerializedName("category_id")
                private String categoryId;
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

                public String getDescribe() {
                    return describe;
                }

                public void setDescribe(String describe) {
                    this.describe = describe;
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

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getBankcard() {
                    return bankcard;
                }

                public void setBankcard(String bankcard) {
                    this.bankcard = bankcard;
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

                public Object getThumb() {
                    return thumb;
                }

                public void setThumb(Object thumb) {
                    this.thumb = thumb;
                }

                public Object getThumbs() {
                    return thumbs;
                }

                public void setThumbs(Object thumbs) {
                    this.thumbs = thumbs;
                }

                public String getCategoryId() {
                    return categoryId;
                }

                public void setCategoryId(String categoryId) {
                    this.categoryId = categoryId;
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
    }
}
