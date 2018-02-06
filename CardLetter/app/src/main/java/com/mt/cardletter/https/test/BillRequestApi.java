package com.mt.cardletter.https.test;


import com.mt.cardletter.entity.bank.Bill;
import com.mt.cardletter.https.BaseApi;
import com.mt.cardletter.https.HttpRequestService;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by HQ_Demos on 2017/4/27.
 */

public class BillRequestApi extends BaseApi {
    public static BillRequestApi httpRequestApi;
    public HttpRequestService httpRequestService;

    public BillRequestApi() {
        httpRequestService = BillMethod.getInstance().createApi(HttpRequestService.class);
    }
    public static BillRequestApi getInstance() {
        if (httpRequestApi == null) {
            httpRequestApi = new BillRequestApi();
        }
        return httpRequestApi;
    }
    /**
     * 获取账单记录
     * @param subscriber
     */
    public void getBill(String cookie,String Url, Subscriber<Bill> subscriber){
        Observable observable = httpRequestService.getbill(cookie,Url)
                .map(new HttpResultFunc<Bill>());
        toSubscribe(observable,subscriber);
    }
}
