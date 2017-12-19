package com.mt.cardletter.https;


import com.mt.cardletter.entity.data.AirDatas;
import com.mt.cardletter.entity.data.HeWeather;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by HQ_Demos on 2017/4/27.
 */

public class HttpRequestApi extends BaseApi {
    public static HttpRequestApi httpRequestApi;
    public HttpRequestService httpRequestService;

    public HttpRequestApi() {
        httpRequestService = HttpMethod.getInstance().createApi(HttpRequestService.class);
    }
    public HttpRequestApi(String base_url) {
        httpRequestService = HttpMethod.getInstance(base_url).createApi(HttpRequestService.class);
    }

    public static HttpRequestApi getInstance() {
        if (httpRequestApi == null) {
            httpRequestApi = new HttpRequestApi();
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
     * 天气
     * @param city
     * @param key
     * @param subscriber
     */
    public void getWeather(String city,String key,Subscriber<HeWeather> subscriber){
        Observable observable = httpRequestService.getWeather(city,key)
                .map(new HttpResultFunc<HeWeather>());
        toSubscribe(observable,subscriber);
    }


    /**
     * 空气质量
     * @param city
     * @param key
     * @param subscriber
     */
    public void getAir(String city,String key,Subscriber<AirDatas> subscriber){
        Observable observable = httpRequestService.getAir(city,key)
                .map(new HttpResultFunc<AirDatas>());
        toSubscribe(observable,subscriber);
    }

}
