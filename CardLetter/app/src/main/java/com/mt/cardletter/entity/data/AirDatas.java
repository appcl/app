package com.mt.cardletter.entity.data;

import java.io.Serializable;
import java.util.List;

/**
 * Date:2017/12/19
 * Time:16:01
 * author:demons
 */

public class AirDatas implements Serializable{

    private List<HeWeather6Bean> HeWeather6;

    public List<HeWeather6Bean> getHeWeather6() {
        return HeWeather6;
    }

    public void setHeWeather6(List<HeWeather6Bean> HeWeather6) {
        this.HeWeather6 = HeWeather6;
    }

    public static class HeWeather6Bean implements Serializable{
        /**
         * basic : {"cid":"CN101190101","location":"南京","parent_city":"南京","admin_area":"江苏","cnty":"中国","lat":"32.04154587","lon":"118.76741028","tz":"+8.0"}
         * update : {"loc":"2017-12-19 14:54","utc":"2017-12-19 06:54"}
         * status : ok
         * air_now_city : {"aqi":"71","qlty":"良","main":"PM10","pm25":"40","pm10":"92","no2":"39","so2":"19","co":"1","o3":"51","pub_time":"2017-12-19 13:00"}
         * air_now_station : [{"air_sta":"迈皋桥","aqi":"74","asid":"CNA1151","co":"0.0","lat":"32.1083","lon":"118.803","main":"PM10","no2":"30","o3":"39","pm10":"97","pm25":"42","pub_time":"2017-12-19 13:00","qlty":"良","so2":"10"},{"air_sta":"草场门","aqi":"75","asid":"CNA1152","co":"0.6","lat":"32.0572","lon":"118.749","main":"PM10","no2":"29","o3":"54","pm10":"99","pm25":"43","pub_time":"2017-12-19 13:00","qlty":"良","so2":"22"},{"air_sta":"山西路","aqi":"81","asid":"CNA1153","co":"0.2","lat":"32.0723","lon":"118.778","main":"PM10","no2":"40","o3":"53","pm10":"111","pm25":"0","pub_time":"2017-12-19 13:00","qlty":"良","so2":"17"},{"air_sta":"中华门","aqi":"79","asid":"CNA1154","co":"0.8","lat":"32.0144","lon":"118.777","main":"PM10","no2":"51","o3":"0","pm10":"108","pm25":"51","pub_time":"2017-12-19 13:00","qlty":"良","so2":"20"},{"air_sta":"瑞金路","aqi":"79","asid":"CNA1155","co":"0.8","lat":"32.0314","lon":"118.803","main":"PM10","no2":"48","o3":"42","pm10":"107","pm25":"57","pub_time":"2017-12-19 13:00","qlty":"良","so2":"17"},{"air_sta":"玄武湖","aqi":"82","asid":"CNA1156","co":"0.8","lat":"32.0775","lon":"118.795","main":"PM2.5","no2":"40","o3":"53","pm10":"102","pm25":"60","pub_time":"2017-12-19 13:00","qlty":"良","so2":"22"},{"air_sta":"浦口","aqi":"94","asid":"CNA1157","co":"0.0","lat":"32.0878","lon":"118.626","main":"PM10","no2":"47","o3":"58","pm10":"138","pm25":"64","pub_time":"2017-12-19 13:00","qlty":"良","so2":"29"},{"air_sta":"奥体中心","aqi":"85","asid":"CNA1158","co":"0.6","lat":"32.0092","lon":"118.737","main":"PM2.5","no2":"42","o3":"54","pm10":"104","pm25":"63","pub_time":"2017-12-19 13:00","qlty":"良","so2":"17"},{"air_sta":"仙林大学城","aqi":"73","asid":"CNA1159","co":"0.6","lat":"32.105","lon":"118.907","main":"PM10","no2":"30","o3":"56","pm10":"96","pm25":"21","pub_time":"2017-12-19 13:00","qlty":"良","so2":"18"}]
         */

        private BasicBean basic;
        private UpdateBean update;
        private String status;
        private AirNowCityBean air_now_city;
        private List<AirNowStationBean> air_now_station;

        public BasicBean getBasic() {
            return basic;
        }

        public void setBasic(BasicBean basic) {
            this.basic = basic;
        }

        public UpdateBean getUpdate() {
            return update;
        }

        public void setUpdate(UpdateBean update) {
            this.update = update;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public AirNowCityBean getAir_now_city() {
            return air_now_city;
        }

        public void setAir_now_city(AirNowCityBean air_now_city) {
            this.air_now_city = air_now_city;
        }

        public List<AirNowStationBean> getAir_now_station() {
            return air_now_station;
        }

        public void setAir_now_station(List<AirNowStationBean> air_now_station) {
            this.air_now_station = air_now_station;
        }

        public static class BasicBean implements Serializable{
            /**
             * cid : CN101190101
             * location : 南京
             * parent_city : 南京
             * admin_area : 江苏
             * cnty : 中国
             * lat : 32.04154587
             * lon : 118.76741028
             * tz : +8.0
             */

            private String cid;
            private String location;
            private String parent_city;
            private String admin_area;
            private String cnty;
            private String lat;
            private String lon;
            private String tz;

            public String getCid() {
                return cid;
            }

            public void setCid(String cid) {
                this.cid = cid;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getParent_city() {
                return parent_city;
            }

            public void setParent_city(String parent_city) {
                this.parent_city = parent_city;
            }

            public String getAdmin_area() {
                return admin_area;
            }

            public void setAdmin_area(String admin_area) {
                this.admin_area = admin_area;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getTz() {
                return tz;
            }

            public void setTz(String tz) {
                this.tz = tz;
            }
        }

        public static class UpdateBean implements Serializable{
            /**
             * loc : 2017-12-19 14:54
             * utc : 2017-12-19 06:54
             */

            private String loc;
            private String utc;

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }

        public static class AirNowCityBean implements Serializable{
            /**
             * aqi : 71
             * qlty : 良
             * main : PM10
             * pm25 : 40
             * pm10 : 92
             * no2 : 39
             * so2 : 19
             * co : 1
             * o3 : 51
             * pub_time : 2017-12-19 13:00
             */

            private String aqi;
            private String qlty;
            private String main;
            private String pm25;
            private String pm10;
            private String no2;
            private String so2;
            private String co;
            private String o3;
            private String pub_time;

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public String getQlty() {
                return qlty;
            }

            public void setQlty(String qlty) {
                this.qlty = qlty;
            }

            public String getMain() {
                return main;
            }

            public void setMain(String main) {
                this.main = main;
            }

            public String getPm25() {
                return pm25;
            }

            public void setPm25(String pm25) {
                this.pm25 = pm25;
            }

            public String getPm10() {
                return pm10;
            }

            public void setPm10(String pm10) {
                this.pm10 = pm10;
            }

            public String getNo2() {
                return no2;
            }

            public void setNo2(String no2) {
                this.no2 = no2;
            }

            public String getSo2() {
                return so2;
            }

            public void setSo2(String so2) {
                this.so2 = so2;
            }

            public String getCo() {
                return co;
            }

            public void setCo(String co) {
                this.co = co;
            }

            public String getO3() {
                return o3;
            }

            public void setO3(String o3) {
                this.o3 = o3;
            }

            public String getPub_time() {
                return pub_time;
            }

            public void setPub_time(String pub_time) {
                this.pub_time = pub_time;
            }
        }

        public static class AirNowStationBean implements Serializable{
            /**
             * air_sta : 迈皋桥
             * aqi : 74
             * asid : CNA1151
             * co : 0.0
             * lat : 32.1083
             * lon : 118.803
             * main : PM10
             * no2 : 30
             * o3 : 39
             * pm10 : 97
             * pm25 : 42
             * pub_time : 2017-12-19 13:00
             * qlty : 良
             * so2 : 10
             */

            private String air_sta;
            private String aqi;
            private String asid;
            private String co;
            private String lat;
            private String lon;
            private String main;
            private String no2;
            private String o3;
            private String pm10;
            private String pm25;
            private String pub_time;
            private String qlty;
            private String so2;

            public String getAir_sta() {
                return air_sta;
            }

            public void setAir_sta(String air_sta) {
                this.air_sta = air_sta;
            }

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public String getAsid() {
                return asid;
            }

            public void setAsid(String asid) {
                this.asid = asid;
            }

            public String getCo() {
                return co;
            }

            public void setCo(String co) {
                this.co = co;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getMain() {
                return main;
            }

            public void setMain(String main) {
                this.main = main;
            }

            public String getNo2() {
                return no2;
            }

            public void setNo2(String no2) {
                this.no2 = no2;
            }

            public String getO3() {
                return o3;
            }

            public void setO3(String o3) {
                this.o3 = o3;
            }

            public String getPm10() {
                return pm10;
            }

            public void setPm10(String pm10) {
                this.pm10 = pm10;
            }

            public String getPm25() {
                return pm25;
            }

            public void setPm25(String pm25) {
                this.pm25 = pm25;
            }

            public String getPub_time() {
                return pub_time;
            }

            public void setPub_time(String pub_time) {
                this.pub_time = pub_time;
            }

            public String getQlty() {
                return qlty;
            }

            public void setQlty(String qlty) {
                this.qlty = qlty;
            }

            public String getSo2() {
                return so2;
            }

            public void setSo2(String so2) {
                this.so2 = so2;
            }
        }
    }
}
