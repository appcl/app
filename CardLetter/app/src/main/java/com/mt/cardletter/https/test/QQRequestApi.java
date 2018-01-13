package com.mt.cardletter.https.test;


import com.mt.cardletter.entity.creditcard.CreditCard;
import com.mt.cardletter.entity.creditcard.CreditDatas;
import com.mt.cardletter.entity.merchant.FindCategoryList;
import com.mt.cardletter.entity.merchant.GoodsBean;
import com.mt.cardletter.https.BaseApi;
import com.mt.cardletter.https.HttpRequestService;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by HQ_Demos on 2017/4/27.
 */

public class QQRequestApi extends BaseApi {
    public static QQRequestApi httpRequestApi;
    public HttpRequestService httpRequestService;

    public QQRequestApi() {
        httpRequestService = QQMethod.getInstance().createApi(HttpRequestService.class);
    }
    public static QQRequestApi getInstance() {
        if (httpRequestApi == null) {
            httpRequestApi = new QQRequestApi();
        }
        return httpRequestApi;
    }

    /**
     * 优惠列表
     * @param subscriber
     */
    public void getGoods(int page_index,
                         int page_size,
                         Subscriber<GoodsBean> subscriber){
        Observable observable = httpRequestService.getGoods(page_index,page_size).map(new HttpResultFunc<GoodsBean>());
        toSubscribe(observable,subscriber);
    }

    public void getCategoryList(String access_token,
                         Subscriber<FindCategoryList> subscriber){
        Observable observable = httpRequestService.getCategoryList(access_token).map(new HttpResultFunc<FindCategoryList>());
        toSubscribe(observable,subscriber);
    }

    public void getCreditCard(String email,String password,String ak,Subscriber<CreditCard> subscriber){
        Observable observable = httpRequestService.getCreditCard(email,password,ak)
                .map(new HttpResultFunc<CreditCard>());
        toSubscribe(observable,subscriber);
    }

    public void getCreditData(String sid,Subscriber<CreditDatas> subscriber){
        Observable observable = httpRequestService.getCreditData("js","0.8359997912528966",sid,"mobile_data.json",
                "list","max","1506287028","ZL1925_juPQJ6D7dUdGA1UkN5hM79","50","1","all","信用卡电子",
                "信用卡电子","信用卡电子","信用卡电子","or","unknow","phone","app")
                .map(new HttpResultFunc<CreditDatas>());
        toSubscribe(observable,subscriber);
    }

    public void getCreditDetail(String sid,String t,Subscriber<String> subscriber){
        Observable observable = httpRequestService.getCreditDetailData(sid,t)
                .map(new HttpResultFunc<String>());
        toSubscribe(observable,subscriber);
    }
}
