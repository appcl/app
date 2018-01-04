package com.mt.cardletter.https.base_net;


import com.mt.cardletter.entity.data.FindCategoryList;
import com.mt.cardletter.entity.article.ArticleBean;
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

    /**
     * 获取活动的分类列表
     * @param access_token
     * @param subscriber
     */
    public void getCategoryList(String access_token, Subscriber<FindCategoryList> subscriber){
        Observable observable = httpRequestService.getCategoryList(access_token)
                .map(new HttpResultFunc<FindCategoryList>());
        toSubscribe(observable,subscriber);
    }

    /**
     * 修改密码
     * @param ak
     * @param username
     * @param old_password
     * @param new_password
     * @param subscriber
     */
    public void updataPassword(String ak, String username, String old_password,String new_password, Subscriber<LoginEntity> subscriber){
        Observable observable = httpRequestService.updataPassword(ak,username,old_password,new_password)
                .map(new HttpResultFunc<LoginEntity>());
        toSubscribe(observable,subscriber);
    }


    /**
     * 获取头条信息
     * @param ak
     * @param subscriber
     */
    public void getArticle(String ak, Subscriber<ArticleBean> subscriber){
        Observable observable = httpRequestService.getArticle(ak)
                .map(new HttpResultFunc<ArticleBean>());
        toSubscribe(observable,subscriber);
    }

    /**
     * 获取卡发现分类列表
     * @param ak
     * @param subscriber
     */
    public void getFindCategroyList(String ak, Subscriber<FindCategoryList> subscriber){
        Observable observable = httpRequestService.getFindCategoryList(ak)
                .map(new HttpResultFunc<FindCategoryList>());
        toSubscribe(observable,subscriber);
    }
}
