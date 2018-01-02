package com.mt.cardletter.https.base_net;


import com.mt.cardletter.entity.user.LoginEntity;
import com.mt.cardletter.https.BaseApi;
import com.mt.cardletter.https.HttpRequestService;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by HQ_Demos on 2017/4/27.
 */

public class CardLetterRequestApi extends BaseApi {
    public static CardLetterRequestApi httpRequestApi;
    public HttpRequestService httpRequestService;

    public CardLetterRequestApi() {
        httpRequestService = CardLetterMethod.getInstance().createApi(HttpRequestService.class);
    }
//    public CardLetterRequestApi(String base_url) {
//        httpRequestService = HttpMethod.getInstance(base_url).createApi(HttpRequestService.class);
//    }

    public static CardLetterRequestApi getInstance() {
        if (httpRequestApi == null) {
            httpRequestApi = new CardLetterRequestApi();
        }
        return httpRequestApi;
    }

    /**
     * 获取用户信息
     * @param ak
     * @param username
     * @param password
     * @param subscriber
     */
    public void getUserInfo(String ak, String username, String password, Subscriber<LoginEntity> subscriber){
        Observable observable = httpRequestService.getUserInfo(ak,username,password)
                .map(new HttpResultFunc<LoginEntity>());
        toSubscribe(observable,subscriber);
    }
}
