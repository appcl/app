package com.mt.cardletter.https.violate_net;


import com.mt.cardletter.entity.data.ViolateCity;
import com.mt.cardletter.entity.data.ViolateData;
import com.mt.cardletter.entity.express.ExpressCom;
import com.mt.cardletter.entity.express.Express_Content;
import com.mt.cardletter.https.BaseApi;
import com.mt.cardletter.https.HttpRequestService;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by HQ_Demos on 2017/4/27.
 */

public class ViolateRequestApi extends BaseApi {
    public static ViolateRequestApi httpRequestApi;
    public HttpRequestService httpRequestService;

    public ViolateRequestApi() {
        httpRequestService = ViolateMethod.getInstance().createApi(HttpRequestService.class);
    }
    public static ViolateRequestApi getInstance() {
        if (httpRequestApi == null) {
            httpRequestApi = new ViolateRequestApi();
        }
        return httpRequestApi;
    }
//
//    /**
//     * 登录接口方法
//     *
//     * @param username
//     * @param password
//     * @param subscriber
//     */
//    public void login(String username, String password, Subscriber<Login> subscriber) {
//        Observable observable = httpRequestService.login(username, password)
//                .map(new HttpResultFunc<Login>());
//        toSubscribe(observable, subscriber);
//    }

    /**
     * 获取可查询城市
     * @param province
     * @param type
     * @param key
     * @param subscriber
     */
    public void getCitys(String province , String type, String key , Subscriber<ViolateCity> subscriber){
        Observable observable = httpRequestService.getCitys(province,type,key)
                .map(new HttpResultFunc<ViolateCity>());
        toSubscribe(observable,subscriber);
    }


    /**
     *
     * @param dtype
     * @param callback
     * @param city
     * @param hphm
     * @param engineno
     * @param classno
     * @param key
     * @param subscriber
     */
    public void getViolates(String dtype , String callback, String city ,String hphm , String engineno,
                            String classno ,String key , Subscriber<ViolateData> subscriber){
        Observable observable = httpRequestService.getViolates(dtype,callback,city,hphm,engineno,classno,key)
                .map(new HttpResultFunc<ViolateData>());
        toSubscribe(observable,subscriber);
    }

    /**
     * 获取快递名称
     * @param key
     * @param subscriber
     */
    public void getExpressCom(String key, Subscriber<ExpressCom> subscriber){
        Observable observable = httpRequestService.getExpressCom(key)
                .map(new HttpResultFunc<ExpressCom>());
        toSubscribe(observable,subscriber);
    }

    /**
     * 获取快递状态
     * @param key
     * @param com
     * @param no
     * @param subscriber
     */
    public void getExpressContent(String key, String com, String no, Subscriber<Express_Content> subscriber){
        Observable observable = httpRequestService.getExpressContent(key,com,no)
                .map(new HttpResultFunc<Express_Content>());
        toSubscribe(observable,subscriber);
    }
}
