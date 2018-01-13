package com.mt.cardletter.https.test;


import com.mt.cardletter.entity.merchant.FindCategoryList;
import com.mt.cardletter.entity.merchant.GoodsBean;
import com.mt.cardletter.entity.news.NetNews;
import com.mt.cardletter.entity.news.NetNewsCategory;
import com.mt.cardletter.entity.news.NetNewsForMap;
import com.mt.cardletter.https.BaseApi;
import com.mt.cardletter.https.HttpRequestService;

import retrofit2.http.Query;
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
     * 网络新闻分类列表
     * @param subscriber
     */
    public void getNetNewsCategory(String apikey, Subscriber<NetNewsCategory> subscriber){
        Observable observable = httpRequestService.getNetNewsCategory(apikey).map(new HttpResultFunc<NetNewsCategory>());
        toSubscribe(observable,subscriber);
    }


    /**
     * 网络新闻列表
     * @param channel
     * @param num
     * @param start
     * @param apikey
     * @param subscriber
     */
    public void getNetNews(String channel,int num,int start,String apikey, Subscriber<NetNews> subscriber){
        Observable observable = httpRequestService.getNetNews(channel,num,start,apikey).map(new HttpResultFunc<NetNews>());
        toSubscribe(observable,subscriber);
    }

    /**
     * https://way.jd.com/jisuapi/newSearch?keyword=南京&appkey=9a025356104a37cd0c690368a0461f41
     * 新闻搜索列表
     * @param apikey
     * @param subscriber
     */
    public void getLocalityNews(String keyword,String apikey, Subscriber<NetNews> subscriber){
        Observable observable = httpRequestService.getLocalityNews(keyword,apikey).map(new HttpResultFunc<NetNews>());
        toSubscribe(observable,subscriber);
    }
}
