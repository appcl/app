package com.mt.cardletter.entity.data;

import java.util.List;

/**
 * Date:2017/12/22
 * Time:10:21
 * author:demons
 */

public class ViolateCity {
    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ViolateAllCity> getResult() {
        return result;
    }

    public void setResult(List<ViolateAllCity> result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    private String resultcode;
    private String reason ;
    private List<ViolateAllCity> result;
    private int error_code;

    public static class  ViolateAllCity{
        private String province ;

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getProvince_code() {
            return province_code;
        }

        public void setProvince_code(String province_code) {
            this.province_code = province_code;
        }

        public List<Citys> getCitys() {
            return citys;
        }

        public void setCitys(List<Citys> citys) {
            this.citys = citys;
        }

        private String province_code;
        private List<Citys> citys;
    }

    public static class Citys{
        private String city_name;

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

        public String getAbbr() {
            return abbr;
        }

        public void setAbbr(String abbr) {
            this.abbr = abbr;
        }

        public String getEngine() {
            return engine;
        }

        public void setEngine(String engine) {
            this.engine = engine;
        }

        public String getEngineno() {
            return engineno;
        }

        public void setEngineno(String engineno) {
            this.engineno = engineno;
        }

        public String getClassa() {
            return classa;
        }

        public void setClassa(String classa) {
            this.classa = classa;
        }

        public String getClassno() {
            return classno;
        }

        public void setClassno(String classno) {
            this.classno = classno;
        }

        public String getRegist() {
            return regist;
        }

        public void setRegist(String regist) {
            this.regist = regist;
        }

        public String getRegistno() {
            return registno;
        }

        public void setRegistno(String registno) {
            this.registno = registno;
        }

        private String city_code;
        private String abbr;
        private String engine;
        private String engineno;
        private String classa;
        private String classno;
        private String regist;
        private String registno;



    }
}
