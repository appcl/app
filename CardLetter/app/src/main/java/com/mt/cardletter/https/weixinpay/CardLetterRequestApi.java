package com.mt.cardletter.https.weixinpay;


import com.mt.cardletter.entity.article.ArticleBean;
import com.mt.cardletter.entity.checkversion.CheckOrUpdate;
import com.mt.cardletter.entity.city.District;
import com.mt.cardletter.entity.collect.Collect;
import com.mt.cardletter.entity.collect.CollectList;
import com.mt.cardletter.entity.data.SearchDatas;
import com.mt.cardletter.entity.integral.CategoryEntity;
import com.mt.cardletter.entity.integral.SearchIntegralData;
import com.mt.cardletter.entity.merchant.Bank;
import com.mt.cardletter.entity.merchant.FindCategoryList;
import com.mt.cardletter.entity.merchant.Good;
import com.mt.cardletter.entity.merchant.Goods;
import com.mt.cardletter.entity.merchant.MyBank;
import com.mt.cardletter.entity.merchant.MyBankBack;
import com.mt.cardletter.entity.news.News;
import com.mt.cardletter.entity.news.NewsCategory;
import com.mt.cardletter.entity.picture.PictureEntity;
import com.mt.cardletter.entity.seller.SellerEntity;
import com.mt.cardletter.entity.user.LoginEntity;
import com.mt.cardletter.https.BaseApi;
import com.mt.cardletter.https.HttpRequestService;
import com.mt.cardletter.utils.Constant;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by HQ_Demos on 2017/4/27.
 */
// TODO: 2018/1/24 目前有id为int 型  ，为防止溢出，需修改为 long 或者 String ! jk
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
     * @param username
     * @param password
     * @param subscriber
     */
    public void getUserInfo(String username,String nickname, String password,String ext_token, Subscriber<LoginEntity> subscriber){
        Observable observable = httpRequestService.getUserInfo(Constant.Access_Token,username,nickname,password,ext_token)
                .map(new HttpResultFunc<LoginEntity>());
        toSubscribe(observable,subscriber);
    }

}
