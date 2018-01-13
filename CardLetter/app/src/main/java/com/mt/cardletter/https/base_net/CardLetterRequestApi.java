package com.mt.cardletter.https.base_net;


import com.mt.cardletter.entity.article.ArticleBean;
import com.mt.cardletter.entity.data.SearchDatas;
import com.mt.cardletter.entity.integral.CategoryEntity;
import com.mt.cardletter.entity.merchant.Bank;
import com.mt.cardletter.entity.merchant.FindCategoryList;
import com.mt.cardletter.entity.merchant.Good;
import com.mt.cardletter.entity.merchant.Goods;
import com.mt.cardletter.entity.news.News;
import com.mt.cardletter.entity.news.NewsCategory;
import com.mt.cardletter.entity.picture.PictureEntity;
import com.mt.cardletter.entity.seller.SellerEntity;
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
//        httpRequestService = CardLetterMethod.getInstance(base_url).createApi(HttpRequestService.class);
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

    /**
     * 获取卡发现分类列表
     * @param ak
     * @param subscriber
     */
    public void getFindMerchant(String ak,  String list_rows,  String page,  String category_id,  Subscriber<Goods> subscriber){
        Observable observable = httpRequestService.getFindMerchant(ak,  list_rows,  page,  category_id)
                .map(new HttpResultFunc<Goods>());
        toSubscribe(observable,subscriber);
    }

    /**
     * 积分商城分类列表
     * @param ak
     * @param subscriber
     */
    public void getCategory(String ak, Subscriber<CategoryEntity> subscriber){
        Observable observable = httpRequestService.getCategory(ak)
                .map(new HttpResultFunc<CategoryEntity>());
        toSubscribe(observable,subscriber);
    }

    /**
     * 银行列表
     * @param ak
     * @param subscriber
     */
    public void getBank(String ak, Subscriber<Bank> subscriber){
        Observable observable = httpRequestService.getBank(ak)
                .map(new HttpResultFunc<Bank>());
        toSubscribe(observable,subscriber);
    }
    /**
     * 优惠详情
     * @param subscriber
     */
    public void getGoodDetails(String ak,String cardfind_id,Subscriber<Good> subscriber){
        Observable observable = httpRequestService.getGoodDetails(ak,cardfind_id)
                .map(new HttpResultFunc<Good>());
        toSubscribe(observable,subscriber);
    }

    /**
     * 新闻列表
     * @param ak
     * @param subscriber
     */
    public void getHomeCategory(String ak, Subscriber<NewsCategory> subscriber){
        Observable observable = httpRequestService.getHomeCategory(ak)
                .map(new HttpResultFunc<NewsCategory>());
        toSubscribe(observable,subscriber);
    }

    /**
     * 广告
     * @param ak
     * @param group
     * @param ad_id
     * @param subscriber
     */
    public void getPics(String ak , String group , String ad_id, Subscriber<PictureEntity> subscriber){
        Observable observable = httpRequestService.getPics(ak,group,ad_id)
                .map(new HttpResultFunc<PictureEntity>());
        toSubscribe(observable,subscriber);
    }

    /**
     * 积分商城内容列表
     * @param ak
     * @param list_rows
     * @param page
     * @param category_id
     * @param subscriber
     */
    public void getSeller(String ak , int list_rows, int page , int category_id, Subscriber<SellerEntity> subscriber){
        Observable observable = httpRequestService.getSellers(ak,list_rows,page,category_id)
                .map(new HttpResultFunc<SellerEntity>());
        toSubscribe(observable,subscriber);
    }
    /**
     * 积分商城内容列表
     * @param ak
     * @param list_rows
     * @param page
     * @param category_id
     * @param subscriber
     */
    public void getNews(String ak , int list_rows, int page , int category_id, Subscriber<News> subscriber){
        Observable observable = httpRequestService.getNews(ak,list_rows,page,category_id)
                .map(new HttpResultFunc<News>());
        toSubscribe(observable,subscriber);
    }


    /**
     * 搜索接口
     * @param ak
     * @param list_rows
     * @param page
     * @param category_id
     * @param str_search
     * @param subscriber
     */
    public void getSearchData(String ak , int list_rows, int page , int category_id,String str_search,Subscriber<SearchDatas> subscriber){
        Observable observable = httpRequestService.getSearchData(ak,list_rows,page,category_id,str_search)
                .map(new HttpResultFunc<SearchDatas>());
        toSubscribe(observable,subscriber);
    }
}
