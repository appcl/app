package com.mt.cardletter.https.test;


import com.mt.cardletter.entity.merchant.FindCategoryList;
import com.mt.cardletter.entity.merchant.GoodsBean;
import com.mt.cardletter.https.BaseApi;
import com.mt.cardletter.https.HttpRequestService;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by HQ_Demos on 2017/4/27.
 */

public class TestRequestApi extends BaseApi {
    public static TestRequestApi httpRequestApi;
    public HttpRequestService httpRequestService;

    public TestRequestApi() {
        httpRequestService = TestMethod.getInstance().createApi(HttpRequestService.class);
    }
    public static TestRequestApi getInstance() {
        if (httpRequestApi == null) {
            httpRequestApi = new TestRequestApi();
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

}
