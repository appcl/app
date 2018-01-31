package com.mt.cardletter.https.base_net;


import com.mt.cardletter.entity.article.ArticleBean;
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
import com.mt.cardletter.entity.news.News;
import com.mt.cardletter.entity.news.NewsCategory;
import com.mt.cardletter.entity.picture.PictureEntity;
import com.mt.cardletter.entity.seller.SellerEntity;
import com.mt.cardletter.entity.user.LoginEntity;
import com.mt.cardletter.https.BaseApi;
import com.mt.cardletter.https.HttpRequestService;
import com.mt.cardletter.utils.Constant;

import retrofit2.http.Query;
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
     * @param ak
     * @param username
     * @param password
     * @param subscriber
     */
    public void getUserInfo(String ak, String username, String password,String ext_token, Subscriber<LoginEntity> subscriber){
        Observable observable = httpRequestService.getUserInfo(ak,username,password,ext_token)
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
     1  access_token
     2  list_rows
     3  page
     4  category_id
     5  city
     6  bankcard
     7  lng
     8  lat
     * @param ak
     * @param subscriber
     */
    public void getFindMerchant(
            String ak,  String list_rows,  String page,  String category_id,String city,String  bankcard,String lng,String lat,String search_data, Subscriber<Goods> subscriber){
        if (city.equals("")){
            if (lng.equals("")||lng.equals("0.0")){
                lng = 32.020843+"";
                lat = 118.763019 +"";
                System.out.println("jk=====未获取到经纬度="+lng+"   ---   "+lat);
            }
        }else{
            lng = "";
            lat = "";
        }
        System.out.println("jk-------Constant.CITY_ID----+"+Constant.CITY_ID);
        System.out.println("jk---------city_id+"+city);
        Observable observable = httpRequestService.getFindMerchant(ak,  list_rows,  page,  category_id,city,bankcard,lng,lat,search_data)
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

    /**
     * 银行积分
     * @param id
     * @param ak
     * @param page
     * @param subscriber
     */
    public void getBank_JF(int id,String ak,int page,Subscriber<CategoryEntity> subscriber){
        Observable observable = httpRequestService.getBank_JF(id,ak,page)
                .map(new HttpResultFunc<CategoryEntity>());
        toSubscribe(observable,subscriber);
    }

    /**
     * 推荐积分
     * @param channel
     * @param ak
     * @param page
     * @param subscriber
     */
    public void getChannel_BJ(String channel,String ak,int page,Subscriber<CategoryEntity> subscriber){
        Observable observable = httpRequestService.getChannel_JF(channel,ak,page)
                .map(new HttpResultFunc<CategoryEntity>());

        toSubscribe(observable,subscriber);
    }

    /**
     * 标签积分
     * @param category_id
     * @param ak
     * @param page
     * @param subscriber
     */
    public void getTAG_BJ(int category_id,String ak,int page,Subscriber<CategoryEntity> subscriber){
        Observable observable = httpRequestService.getTAG_JF(category_id,ak,page)
                .map(new HttpResultFunc<CategoryEntity>());

        toSubscribe(observable,subscriber);
    }

    /**
     * 搜索积分接口
     * @param ak
     * @param list_rows
     * @param page
     * @param category_id
     * @param str_search
     * @param subscriber
     */
    public void getSearchIntegralData(String ak , int list_rows, int page , int category_id,String str_search,Subscriber<SearchIntegralData> subscriber){
        Observable observable = httpRequestService.getSearchIntegralData(ak,list_rows,page,category_id,str_search)
                .map(new HttpResultFunc<SearchIntegralData>());
        toSubscribe(observable,subscriber);
    }

    /**
     * 地区类表
     * @param subscriber
     */
    public void getdDistrictID(Subscriber<District> subscriber){
        Observable observable = httpRequestService.getdDistrictID(Constant.Access_Token)
                .map(new HttpResultFunc<District>());
        toSubscribe(observable,subscriber);
    }

    /**
     * 保存关注银行
     * @param subscriber
     */
    public void addMybank(String user_token,String my_bank ,Subscriber<MyBank> subscriber){
        Observable observable = httpRequestService.addMybank(Constant.Access_Token,user_token,my_bank)
                .map(new HttpResultFunc<MyBank>());
        toSubscribe(observable,subscriber);
    }
    /**
     * 添加收藏
     * @param subscriber
     */
    public void addFavorite(String name, String member_id, String name_id, String fvalue,Subscriber<Collect> subscriber){
        Observable observable = httpRequestService.addFavorite(Constant.Access_Token,name,member_id,name_id,fvalue)
                .map(new HttpResultFunc<Collect>());
        toSubscribe(observable,subscriber);
    }
    /**
     * 收藏列表
     * @param subscriber
     */
    public void favoriteList(int list_rows, int page, String member_id, Subscriber<CollectList> subscriber){
        Observable observable = httpRequestService.favoriteList(Constant.Access_Token,list_rows,page,member_id)
                .map(new HttpResultFunc<CollectList>());
        toSubscribe(observable,subscriber);
    }
    /**
     * 删除收藏
     * @param subscriber
     */
    public void delFavorite(String name_id, String member_id, Subscriber<Collect> subscriber){
        Observable observable = httpRequestService.delFavorite(Constant.Access_Token,name_id,member_id)
                .map(new HttpResultFunc<Collect>());
        toSubscribe(observable,subscriber);
    }

}
