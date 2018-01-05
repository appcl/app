package com.mt.cardletter.entity.integral;

import java.util.List;

/**
 * Date:2017/12/12
 * Time:11:24
 * author:demons
 */

public class IntegralEntity {
    public String getTag_url() {
        return tag_url;
    }

    public void setTag_url(String tag_url) {
        this.tag_url = tag_url;
    }

    public List<IntegralBean> getBean() {
        return bean;
    }

    public void setBean(List<IntegralBean> bean) {
        this.bean = bean;
    }

    private String tag_url;

    public String getI_tv() {
        return i_tv;
    }

    public void setI_tv(String i_tv) {
        this.i_tv = i_tv;
    }

    private String i_tv;
    private List<IntegralBean> bean;


    public static class IntegralBean{
        private String item_url;

        public String getDes_integral() {
            return des_integral;
        }

        public void setDes_integral(String des_integral) {
            this.des_integral = des_integral;
        }

        public String getItem_url() {
            return item_url;
        }

        public void setItem_url(String item_url) {
            this.item_url = item_url;
        }

        private String des_integral;
    }
}
