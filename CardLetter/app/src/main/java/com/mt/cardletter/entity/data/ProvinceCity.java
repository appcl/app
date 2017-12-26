package com.mt.cardletter.entity.data;



import java.util.List;

/**
 * Created by youzehong on 15/12/27.
 */
public class ProvinceCity {

    private String province;
    private List<Citys_> citys;

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCitys(List<Citys_> citys) {
        this.citys = citys;
    }

    public String getProvince() {
        return province;
    }

    public List<Citys_> getCitys() {
        return citys;
    }

    public static class Citys_{
        private String city_name ;

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getCity_code() {
            return city_code;
        }

        public void setCity_code(String city_code) {
            this.city_code = city_code;
        }

        private String city_code ;

        public String getCity_abbr() {
            return city_abbr;
        }

        public void setCity_abbr(String city_abbr) {
            this.city_abbr = city_abbr;
        }

        private String city_abbr;
    }
}
