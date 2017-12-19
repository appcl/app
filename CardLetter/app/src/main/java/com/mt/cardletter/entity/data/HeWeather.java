package com.mt.cardletter.entity.data;

import java.io.Serializable;
import java.util.List;

/**
 * Date:2017/12/18
 * Time:11:52
 * author:demons
 */

public class HeWeather implements Serializable {


    private List<HeWeather6Bean> HeWeather6;

    public List<HeWeather6Bean> getHeWeather6() {
        return HeWeather6;
    }

    public void setHeWeather6(List<HeWeather6Bean> HeWeather6) {
        this.HeWeather6 = HeWeather6;
    }

    public static class HeWeather6Bean implements Serializable {
        /**
         * basic : {"cid":"CN101190101","location":"南京","parent_city":"南京","admin_area":"江苏","cnty":"中国","lat":"32.04154587","lon":"118.76741028","tz":"+8.0"}
         * update : {"loc":"2017-12-18 11:51","utc":"2017-12-18 03:51"}
         * status : ok
         * now : {"cloud":"0","cond_code":"101","cond_txt":"多云","fl":"-3","hum":"37","pcpn":"0.0","pres":"1034","tmp":"5","vis":"10","wind_deg":"281","wind_dir":"西风","wind_sc":"微风","wind_spd":"10"}
         * daily_forecast : [{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2017-12-18","hum":"32","mr":"06:37","ms":"17:15","pcpn":"0.0","pop":"0","pres":"1033","sr":"06:59","ss":"17:05","tmp_max":"8","tmp_min":"-2","uv_index":"3","vis":"20","wind_deg":"219","wind_dir":"西南风","wind_sc":"3-4","wind_spd":"16"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2017-12-19","hum":"41","mr":"07:28","ms":"18:01","pcpn":"0.0","pop":"0","pres":"1036","sr":"07:00","ss":"17:05","tmp_max":"9","tmp_min":"-3","uv_index":"3","vis":"20","wind_deg":"356","wind_dir":"北风","wind_sc":"3-4","wind_spd":"13"},{"cond_code_d":"100","cond_code_n":"100","cond_txt_d":"晴","cond_txt_n":"晴","date":"2017-12-20","hum":"39","mr":"08:15","ms":"18:51","pcpn":"0.0","pop":"0","pres":"1035","sr":"07:00","ss":"17:06","tmp_max":"10","tmp_min":"-2","uv_index":"3","vis":"20","wind_deg":"324","wind_dir":"西北风","wind_sc":"4-5","wind_spd":"23"},{"cond_code_d":"100","cond_code_n":"100","cond_txt_d":"晴","cond_txt_n":"晴","date":"2017-12-21","hum":"34","mr":"09:00","ms":"19:43","pcpn":"0.0","pop":"0","pres":"1034","sr":"07:01","ss":"17:06","tmp_max":"7","tmp_min":"-3","uv_index":"3","vis":"20","wind_deg":"276","wind_dir":"西风","wind_sc":"3-4","wind_spd":"11"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2017-12-22","hum":"49","mr":"09:42","ms":"20:35","pcpn":"0.0","pop":"0","pres":"1026","sr":"07:01","ss":"17:07","tmp_max":"11","tmp_min":"0","uv_index":"3","vis":"20","wind_deg":"133","wind_dir":"东南风","wind_sc":"3-4","wind_spd":"12"},{"cond_code_d":"101","cond_code_n":"101","cond_txt_d":"多云","cond_txt_n":"多云","date":"2017-12-23","hum":"52","mr":"10:20","ms":"21:30","pcpn":"0.0","pop":"0","pres":"1022","sr":"07:02","ss":"17:07","tmp_max":"10","tmp_min":"2","uv_index":"3","vis":"20","wind_deg":"278","wind_dir":"西风","wind_sc":"3-4","wind_spd":"14"},{"cond_code_d":"101","cond_code_n":"104","cond_txt_d":"多云","cond_txt_n":"阴","date":"2017-12-24","hum":"39","mr":"10:56","ms":"22:25","pcpn":"0.0","pop":"0","pres":"1025","sr":"07:02","ss":"17:08","tmp_max":"11","tmp_min":"2","uv_index":"3","vis":"20","wind_deg":"276","wind_dir":"西风","wind_sc":"3-4","wind_spd":"10"}]
         * hourly : [{"cloud":"1","cond_code":"100","cond_txt":"晴","dew":"-10","hum":"25","pop":"0","pres":"1033","time":"2017-12-18 13:00","tmp":"5","wind_deg":"232","wind_dir":"西南风","wind_sc":"微风","wind_spd":"8"},{"cloud":"0","cond_code":"103","cond_txt":"晴间多云","dew":"-8","hum":"28","pop":"0","pres":"1033","time":"2017-12-18 16:00","tmp":"6","wind_deg":"236","wind_dir":"西南风","wind_sc":"微风","wind_spd":"6"},{"cloud":"0","cond_code":"100","cond_txt":"晴","dew":"-6","hum":"35","pop":"0","pres":"1034","time":"2017-12-18 19:00","tmp":"2","wind_deg":"228","wind_dir":"西南风","wind_sc":"微风","wind_spd":"6"},{"cloud":"0","cond_code":"100","cond_txt":"晴","dew":"-6","hum":"39","pop":"0","pres":"1034","time":"2017-12-18 22:00","tmp":"0","wind_deg":"224","wind_dir":"西南风","wind_sc":"微风","wind_spd":"6"},{"cloud":"0","cond_code":"100","cond_txt":"晴","dew":"-6","hum":"42","pop":"0","pres":"1034","time":"2017-12-19 01:00","tmp":"0","wind_deg":"241","wind_dir":"西南风","wind_sc":"微风","wind_spd":"6"},{"cloud":"0","cond_code":"100","cond_txt":"晴","dew":"-5","hum":"49","pop":"0","pres":"1034","time":"2017-12-19 04:00","tmp":"0","wind_deg":"272","wind_dir":"西风","wind_sc":"微风","wind_spd":"5"},{"cloud":"0","cond_code":"100","cond_txt":"晴","dew":"-5","hum":"52","pop":"0","pres":"1034","time":"2017-12-19 07:00","tmp":"-1","wind_deg":"292","wind_dir":"西北风","wind_sc":"微风","wind_spd":"4"},{"cloud":"0","cond_code":"100","cond_txt":"晴","dew":"-6","hum":"39","pop":"0","pres":"1035","time":"2017-12-19 10:00","tmp":"5","wind_deg":"284","wind_dir":"西北风","wind_sc":"微风","wind_spd":"6"}]
         * lifestyle : [{"brf":"较舒适","txt":"今天夜间虽然天气晴好，但会感觉偏凉，舒适、宜人。","type":"comf"},{"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。","type":"drsg"},{"brf":"易发","txt":"昼夜温差很大，易发生感冒，请注意适当增减衣服，加强自我防护避免感冒。","type":"flu"},{"brf":"较适宜","txt":"天气较好，但考虑风力较强且气温较低，推荐您进行室内运动，若在户外运动注意防风并适当增减衣物。","type":"sport"},{"brf":"一般","txt":"天空状况还是比较好的，但温度稍微有点低，且风稍大，会让您感觉些许凉意。外出请注意防风。","type":"trav"},{"brf":"最弱","txt":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。","type":"uv"},{"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。","type":"cw"},{"brf":"良","txt":"气象条件有利于空气污染物稀释、扩散和清除，可在室外正常活动。","type":"air"}]
         */

        private BasicBean basic;
        private UpdateBean update;
        private String status;
        private NowBean now;
        private List<DailyForecastBean> daily_forecast;
        private List<HourlyBean> hourly;
        private List<LifestyleBean> lifestyle;

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

        public NowBean getNow() {
            return now;
        }

        public void setNow(NowBean now) {
            this.now = now;
        }

        public List<DailyForecastBean> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public List<HourlyBean> getHourly() {
            return hourly;
        }

        public void setHourly(List<HourlyBean> hourly) {
            this.hourly = hourly;
        }

        public List<LifestyleBean> getLifestyle() {
            return lifestyle;
        }

        public void setLifestyle(List<LifestyleBean> lifestyle) {
            this.lifestyle = lifestyle;
        }

        public static class BasicBean implements Serializable {
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

        public static class UpdateBean implements Serializable {
            /**
             * loc : 2017-12-18 11:51
             * utc : 2017-12-18 03:51
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

        public static class NowBean implements Serializable {
            /**
             * cloud : 0
             * cond_code : 101
             * cond_txt : 多云
             * fl : -3
             * hum : 37
             * pcpn : 0.0
             * pres : 1034
             * tmp : 5
             * vis : 10
             * wind_deg : 281
             * wind_dir : 西风
             * wind_sc : 微风
             * wind_spd : 10
             */

            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCloud() {
                return cloud;
            }

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class DailyForecastBean implements Serializable {
            /**
             * cond_code_d : 101
             * cond_code_n : 101
             * cond_txt_d : 多云
             * cond_txt_n : 多云
             * date : 2017-12-18
             * hum : 32
             * mr : 06:37
             * ms : 17:15
             * pcpn : 0.0
             * pop : 0
             * pres : 1033
             * sr : 06:59
             * ss : 17:05
             * tmp_max : 8
             * tmp_min : -2
             * uv_index : 3
             * vis : 20
             * wind_deg : 219
             * wind_dir : 西南风
             * wind_sc : 3-4
             * wind_spd : 16
             */

            private String cond_code_d;
            private String cond_code_n;
            private String cond_txt_d;
            private String cond_txt_n;
            private String date;
            private String hum;
            private String mr;
            private String ms;
            private String pcpn;
            private String pop;
            private String pres;
            private String sr;
            private String ss;
            private String tmp_max;
            private String tmp_min;
            private String uv_index;
            private String vis;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCond_code_d() {
                return cond_code_d;
            }

            public void setCond_code_d(String cond_code_d) {
                this.cond_code_d = cond_code_d;
            }

            public String getCond_code_n() {
                return cond_code_n;
            }

            public void setCond_code_n(String cond_code_n) {
                this.cond_code_n = cond_code_n;
            }

            public String getCond_txt_d() {
                return cond_txt_d;
            }

            public void setCond_txt_d(String cond_txt_d) {
                this.cond_txt_d = cond_txt_d;
            }

            public String getCond_txt_n() {
                return cond_txt_n;
            }

            public void setCond_txt_n(String cond_txt_n) {
                this.cond_txt_n = cond_txt_n;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getMr() {
                return mr;
            }

            public void setMr(String mr) {
                this.mr = mr;
            }

            public String getMs() {
                return ms;
            }

            public void setMs(String ms) {
                this.ms = ms;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getSr() {
                return sr;
            }

            public void setSr(String sr) {
                this.sr = sr;
            }

            public String getSs() {
                return ss;
            }

            public void setSs(String ss) {
                this.ss = ss;
            }

            public String getTmp_max() {
                return tmp_max;
            }

            public void setTmp_max(String tmp_max) {
                this.tmp_max = tmp_max;
            }

            public String getTmp_min() {
                return tmp_min;
            }

            public void setTmp_min(String tmp_min) {
                this.tmp_min = tmp_min;
            }

            public String getUv_index() {
                return uv_index;
            }

            public void setUv_index(String uv_index) {
                this.uv_index = uv_index;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class HourlyBean implements Serializable {
            /**
             * cloud : 1
             * cond_code : 100
             * cond_txt : 晴
             * dew : -10
             * hum : 25
             * pop : 0
             * pres : 1033
             * time : 2017-12-18 13:00
             * tmp : 5
             * wind_deg : 232
             * wind_dir : 西南风
             * wind_sc : 微风
             * wind_spd : 8
             */

            private String cloud;
            private String cond_code;
            private String cond_txt;
            private String dew;
            private String hum;
            private String pop;
            private String pres;
            private String time;
            private String tmp;
            private String wind_deg;
            private String wind_dir;
            private String wind_sc;
            private String wind_spd;

            public String getCloud() {
                return cloud;
            }

            public void setCloud(String cloud) {
                this.cloud = cloud;
            }

            public String getCond_code() {
                return cond_code;
            }

            public void setCond_code(String cond_code) {
                this.cond_code = cond_code;
            }

            public String getCond_txt() {
                return cond_txt;
            }

            public void setCond_txt(String cond_txt) {
                this.cond_txt = cond_txt;
            }

            public String getDew() {
                return dew;
            }

            public void setDew(String dew) {
                this.dew = dew;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getWind_deg() {
                return wind_deg;
            }

            public void setWind_deg(String wind_deg) {
                this.wind_deg = wind_deg;
            }

            public String getWind_dir() {
                return wind_dir;
            }

            public void setWind_dir(String wind_dir) {
                this.wind_dir = wind_dir;
            }

            public String getWind_sc() {
                return wind_sc;
            }

            public void setWind_sc(String wind_sc) {
                this.wind_sc = wind_sc;
            }

            public String getWind_spd() {
                return wind_spd;
            }

            public void setWind_spd(String wind_spd) {
                this.wind_spd = wind_spd;
            }
        }

        public static class LifestyleBean implements Serializable {
            /**
             * brf : 较舒适
             * txt : 今天夜间虽然天气晴好，但会感觉偏凉，舒适、宜人。
             * type : comf
             */

            private String brf;
            private String txt;
            private String type;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
