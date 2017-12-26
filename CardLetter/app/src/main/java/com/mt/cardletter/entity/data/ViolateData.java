package com.mt.cardletter.entity.data;

import java.io.Serializable;
import java.util.List;

/**
 * Date:2017/12/21
 * Time:16:47
 * author:demons
 */

public class ViolateData implements Serializable{

    /**
     * resultcode : 200
     * reason : 查询成功
     * result : {"province":"JS","city":"JS_NJ","hphm":"苏AE4D00","hpzl":"02","lists":[{"date":"2016-10-31 02:14:00","area":"应天大街 云锦路路口","act":"驾驶机动车违反道路交通信号灯通行的","code":"1625","fen":"6","money":"200","handled":"0","archiveno":""},{"date":"2016-11-24 10:55:00","area":"积贤街(燕山路至江东南路路段)","act":"违反规定停放、临时停车，妨碍其它车辆、行人通行，驾驶人不在现场","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2016-12-03 09:59:00","area":"积贤街(燕山路至江东南路路段)","act":"违反规定停放、临时停车，妨碍其它车辆、行人通行，驾驶人不在现场","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2016-12-18 10:03:00","area":"宁高线（123省道）79公里950米","act":"驾驶中型以上载客载货汽车、校车、危险物品运输车辆以外的其他机动车行驶超过规定时速20%以上未达到50%","code":"","fen":"6","money":"200","handled":"0","archiveno":""},{"date":"2017-01-10 15:10:00","area":"小火瓦巷(小火瓦巷全线路段)","act":"违反规定停放、临时停车，妨碍其它车辆、行人通行，驾驶人不在现场","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-01-14 15:37:00","area":"江东中路(汉中门大街至集庆门大街路段)","act":"违反禁令标志指示","code":"1344","fen":"3","money":"100","handled":"0","archiveno":""},{"date":"2017-01-22 13:41:00","area":"宝塔路南漪路路口","act":"机动车违反禁止标线指示的","code":"13453","fen":"3","money":"100","handled":"0","archiveno":""},{"date":"2017-02-20 21:47:00","area":"应天大街赛虹桥立交长江装饰城路口","act":"驾驶机动车违反道路交通信号灯通行的","code":"1625","fen":"6","money":"200","handled":"0","archiveno":""},{"date":"2017-02-23 08:24:00","area":"应天大街 嵩山路路口","act":"违反禁止停车禁令标志的","code":"","fen":"3","money":"100","handled":"0","archiveno":""},{"date":"2017-03-09 09:25:00","area":"积贤街(燕山路至江东南路路段)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-03-17 08:18:00","area":"虎踞南路汉中路路口","act":"机动车违反规定使用专用车道","code":"","fen":"0","money":"100","handled":"0","archiveno":""},{"date":"2017-03-24 16:22:00","area":"应天大街 云锦路路口","act":"不按导向车道行驶","code":"12082","fen":"2","money":"100","handled":"0","archiveno":""},{"date":"2017-03-28 12:35:00","area":"新扬高速","act":"机动车在高速公路上行驶超过规定时速10%以上不到20%的","code":"","fen":"3","money":"50","handled":"0","archiveno":""},{"date":"2017-03-28 14:13:00","area":"淮徐高速155公里300米","act":"机动车在高速公路上行驶超过规定时速10%以上不到20%的","code":"","fen":"3","money":"50","handled":"0","archiveno":""},{"date":"2017-05-02 16:30:00","area":"钞库街(长乐路至来燕路段)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-06-28 15:38:00","area":"长虹路(凤台南路至雨花西路段)","act":"违反禁止停车禁令标志的","code":"","fen":"3","money":"100","handled":"0","archiveno":""},{"date":"2017-07-19 09:23:00","area":"积贤街(燕山路至江东南路路段)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-08-01 15:11:00","area":"长江隧道进城方向2.2公里处","act":"机动车停车违反禁止标线指示的","code":"13452","fen":"3","money":"100","handled":"0","archiveno":""},{"date":"2017-08-03 12:18:00","area":"钞库街(长乐路至来燕路段)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-08-16 10:07:00","area":"积贤街(燕山路至江东南路路段)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-08-23 20:07:00","area":"小火瓦巷(小火瓦巷全线路段)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-08-26 15:36:00","area":"积贤街(燕山路至江东南路路段)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-08-29 10:45:00","area":"高家酒馆(中山路至华侨路)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-09-06 12:43:00","area":"三条巷(中山东路至常府街)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-09-06 17:03:00","area":"石杨路友谊河路路口","act":"不按导向车道行驶","code":"12082","fen":"2","money":"100","handled":"0","archiveno":""},{"date":"2017-09-07 19:02:00","area":"卡子门高架内环东线与内环南线分道口","act":"机动车停车违反禁止标线指示的","code":"13452","fen":"3","money":"100","handled":"0","archiveno":""},{"date":"2017-09-08 10:49:00","area":"大香炉(明瓦廊至木料市)","act":"机动车违反禁令标志指示的","code":"1344","fen":"3","money":"100","handled":"0","archiveno":""},{"date":"2017-10-04 09:43:00","area":"机场高速集散道路（花神庙枢纽至翠屏山互通路段）","act":"驾驶中型以上载客载货汽车、校车、危险物品运输车辆以外的其他机动车在高速公路上行驶超过规定时速20%以上未达到50%的","code":"","fen":"6","money":"200","handled":"0","archiveno":""},{"date":"2017-10-31 16:08:00","area":"中山南路(新街口至程阁老巷路段)","act":"违反禁止停车禁令标志的","code":"","fen":"3","money":"100","handled":"0","archiveno":""},{"date":"2017-11-06 14:08:00","area":"沈举人巷(管家桥至慈悲社路段)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-11-14 02:45:00","area":"G3566公里600米至G3541公里900米","act":"机动车在高速公路上行驶超过规定时速10%以上不到20%的","code":"","fen":"3","money":"50","handled":"0","archiveno":""}]}
     * error_code : 0
     */

    private String resultcode;
    private String reason;
    private ResultBean result;
    private int error_code;

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

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean implements Serializable{
        /**
         * province : JS
         * city : JS_NJ
         * hphm : 苏AE4D00
         * hpzl : 02
         * lists : [{"date":"2016-10-31 02:14:00","area":"应天大街 云锦路路口","act":"驾驶机动车违反道路交通信号灯通行的","code":"1625","fen":"6","money":"200","handled":"0","archiveno":""},{"date":"2016-11-24 10:55:00","area":"积贤街(燕山路至江东南路路段)","act":"违反规定停放、临时停车，妨碍其它车辆、行人通行，驾驶人不在现场","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2016-12-03 09:59:00","area":"积贤街(燕山路至江东南路路段)","act":"违反规定停放、临时停车，妨碍其它车辆、行人通行，驾驶人不在现场","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2016-12-18 10:03:00","area":"宁高线（123省道）79公里950米","act":"驾驶中型以上载客载货汽车、校车、危险物品运输车辆以外的其他机动车行驶超过规定时速20%以上未达到50%","code":"","fen":"6","money":"200","handled":"0","archiveno":""},{"date":"2017-01-10 15:10:00","area":"小火瓦巷(小火瓦巷全线路段)","act":"违反规定停放、临时停车，妨碍其它车辆、行人通行，驾驶人不在现场","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-01-14 15:37:00","area":"江东中路(汉中门大街至集庆门大街路段)","act":"违反禁令标志指示","code":"1344","fen":"3","money":"100","handled":"0","archiveno":""},{"date":"2017-01-22 13:41:00","area":"宝塔路南漪路路口","act":"机动车违反禁止标线指示的","code":"13453","fen":"3","money":"100","handled":"0","archiveno":""},{"date":"2017-02-20 21:47:00","area":"应天大街赛虹桥立交长江装饰城路口","act":"驾驶机动车违反道路交通信号灯通行的","code":"1625","fen":"6","money":"200","handled":"0","archiveno":""},{"date":"2017-02-23 08:24:00","area":"应天大街 嵩山路路口","act":"违反禁止停车禁令标志的","code":"","fen":"3","money":"100","handled":"0","archiveno":""},{"date":"2017-03-09 09:25:00","area":"积贤街(燕山路至江东南路路段)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-03-17 08:18:00","area":"虎踞南路汉中路路口","act":"机动车违反规定使用专用车道","code":"","fen":"0","money":"100","handled":"0","archiveno":""},{"date":"2017-03-24 16:22:00","area":"应天大街 云锦路路口","act":"不按导向车道行驶","code":"12082","fen":"2","money":"100","handled":"0","archiveno":""},{"date":"2017-03-28 12:35:00","area":"新扬高速","act":"机动车在高速公路上行驶超过规定时速10%以上不到20%的","code":"","fen":"3","money":"50","handled":"0","archiveno":""},{"date":"2017-03-28 14:13:00","area":"淮徐高速155公里300米","act":"机动车在高速公路上行驶超过规定时速10%以上不到20%的","code":"","fen":"3","money":"50","handled":"0","archiveno":""},{"date":"2017-05-02 16:30:00","area":"钞库街(长乐路至来燕路段)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-06-28 15:38:00","area":"长虹路(凤台南路至雨花西路段)","act":"违反禁止停车禁令标志的","code":"","fen":"3","money":"100","handled":"0","archiveno":""},{"date":"2017-07-19 09:23:00","area":"积贤街(燕山路至江东南路路段)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-08-01 15:11:00","area":"长江隧道进城方向2.2公里处","act":"机动车停车违反禁止标线指示的","code":"13452","fen":"3","money":"100","handled":"0","archiveno":""},{"date":"2017-08-03 12:18:00","area":"钞库街(长乐路至来燕路段)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-08-16 10:07:00","area":"积贤街(燕山路至江东南路路段)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-08-23 20:07:00","area":"小火瓦巷(小火瓦巷全线路段)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-08-26 15:36:00","area":"积贤街(燕山路至江东南路路段)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-08-29 10:45:00","area":"高家酒馆(中山路至华侨路)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-09-06 12:43:00","area":"三条巷(中山东路至常府街)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-09-06 17:03:00","area":"石杨路友谊河路路口","act":"不按导向车道行驶","code":"12082","fen":"2","money":"100","handled":"0","archiveno":""},{"date":"2017-09-07 19:02:00","area":"卡子门高架内环东线与内环南线分道口","act":"机动车停车违反禁止标线指示的","code":"13452","fen":"3","money":"100","handled":"0","archiveno":""},{"date":"2017-09-08 10:49:00","area":"大香炉(明瓦廊至木料市)","act":"机动车违反禁令标志指示的","code":"1344","fen":"3","money":"100","handled":"0","archiveno":""},{"date":"2017-10-04 09:43:00","area":"机场高速集散道路（花神庙枢纽至翠屏山互通路段）","act":"驾驶中型以上载客载货汽车、校车、危险物品运输车辆以外的其他机动车在高速公路上行驶超过规定时速20%以上未达到50%的","code":"","fen":"6","money":"200","handled":"0","archiveno":""},{"date":"2017-10-31 16:08:00","area":"中山南路(新街口至程阁老巷路段)","act":"违反禁止停车禁令标志的","code":"","fen":"3","money":"100","handled":"0","archiveno":""},{"date":"2017-11-06 14:08:00","area":"沈举人巷(管家桥至慈悲社路段)","act":"汽车在道路上违反规定停放且驾驶人不在现场，妨碍其他车辆、行人通行的","code":"","fen":"0","money":"50","handled":"0","archiveno":""},{"date":"2017-11-14 02:45:00","area":"G3566公里600米至G3541公里900米","act":"机动车在高速公路上行驶超过规定时速10%以上不到20%的","code":"","fen":"3","money":"50","handled":"0","archiveno":""}]
         */

        private String province;
        private String city;
        private String hphm;
        private String hpzl;
        private List<ListsBean> lists;

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getHphm() {
            return hphm;
        }

        public void setHphm(String hphm) {
            this.hphm = hphm;
        }

        public String getHpzl() {
            return hpzl;
        }

        public void setHpzl(String hpzl) {
            this.hpzl = hpzl;
        }

        public List<ListsBean> getLists() {
            return lists;
        }

        public void setLists(List<ListsBean> lists) {
            this.lists = lists;
        }

        public static class ListsBean implements Serializable{
            /**
             * date : 2016-10-31 02:14:00
             * area : 应天大街 云锦路路口
             * act : 驾驶机动车违反道路交通信号灯通行的
             * code : 1625
             * fen : 6
             * money : 200
             * handled : 0
             * archiveno :
             */

            private String date;
            private String area;
            private String act;
            private String code;
            private String fen;
            private String money;
            private String handled;
            private String archiveno;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getAct() {
                return act;
            }

            public void setAct(String act) {
                this.act = act;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getFen() {
                return fen;
            }

            public void setFen(String fen) {
                this.fen = fen;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getHandled() {
                return handled;
            }

            public void setHandled(String handled) {
                this.handled = handled;
            }

            public String getArchiveno() {
                return archiveno;
            }

            public void setArchiveno(String archiveno) {
                this.archiveno = archiveno;
            }
        }
    }
}
