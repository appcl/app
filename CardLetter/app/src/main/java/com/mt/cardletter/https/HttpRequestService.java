package com.mt.cardletter.https;


import com.mt.cardletter.entity.article.ArticleBean;
import com.mt.cardletter.entity.creditcard.CreditCard;
import com.mt.cardletter.entity.creditcard.CreditDatas;
import com.mt.cardletter.entity.data.AirDatas;
import com.mt.cardletter.entity.data.HeWeather;
import com.mt.cardletter.entity.data.SearchDatas;
import com.mt.cardletter.entity.data.ViolateCity;
import com.mt.cardletter.entity.data.ViolateData;
import com.mt.cardletter.entity.express.ExpressCom;
import com.mt.cardletter.entity.express.Express_Content;
import com.mt.cardletter.entity.integral.CategoryEntity;
import com.mt.cardletter.entity.merchant.Bank;
import com.mt.cardletter.entity.merchant.FindCategoryList;
import com.mt.cardletter.entity.merchant.Good;
import com.mt.cardletter.entity.merchant.Goods;
import com.mt.cardletter.entity.merchant.GoodsBean;
import com.mt.cardletter.entity.news.NetNews;
import com.mt.cardletter.entity.news.NetNewsCategory;
import com.mt.cardletter.entity.news.NetNewsForMap;
import com.mt.cardletter.entity.news.News;
import com.mt.cardletter.entity.news.NewsCategory;
import com.mt.cardletter.entity.picture.PictureEntity;
import com.mt.cardletter.entity.seller.SellerEntity;
import com.mt.cardletter.entity.user.LoginEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by HQ_Demos on 2017/4/27.
 */

public interface HttpRequestService {
    /**
     * 获取天气
     * @return
     */
    @GET("/s6/weather")
    Observable<HeWeather> getWeather(@Query("location") String city,
                                     @Query("key")String key);

    /**
     * 空气质量
     * @return
     */
    @GET("/s6/air/now")
    Observable<AirDatas> getAir(@Query("location") String city,
                                @Query("key")String key);

    /**
     * 目前支持查询的城市
     * @param province
     * @param dtype
     * @param key
     * @return
     */
    @GET("/sweizhang/citys")
    Observable<ViolateCity> getCitys(@Query("province") String province,
                                     @Query("dtype") String dtype,
                                     @Query("key") String key);

    /**
     *
     * @param dtype json或xml,默认json
     * @param callback 返回格式选择jsonp时，必须传递
     * @param city 城市代码 *
     * @param hphm 号牌号码 完整7位 ,需要utf8 urlencode*
     * @param engineno 发动机号 (根据城市接口中的参数填写)
     * @param classno 车架号 (根据城市接口中的参数填写)
     * @param key
     * @return
     */
    @GET("/sweizhang/query")
    Observable<ViolateData> getViolates(@Query("dtype") String dtype,
                                        @Query("callback") String callback,
                                        @Query("city") String city,
                                        @Query("hphm") String hphm,
                                        @Query("engineno") String engineno,
                                        @Query("classno") String classno,
                                        @Query("key") String key);

    /**
     * 登录注册接口
     * @param access_token
     * @param username
     * @param password
     * @return
     */
    @POST("/api.php/common/login")
    Observable<LoginEntity> getUserInfo(@Query("access_token") String access_token,
                                        @Query("username") String username,
                                        @Query("password") String password);

    /**
     * 优惠 test
     * @param page_index
     * @param page_size
     * @return
     */
    @GET("/")
    Observable<GoodsBean> getGoods(@Query("page_index") int page_index,
                                   @Query("page_size") int page_size);

    /**
     * 获取活动分类，test
     * @param access_token
     * @return
     */
    @FormUrlEncoded
    @POST("/api.php/article/categorylist")
    Observable<FindCategoryList> getCategoryList(@Field("access_token") String access_token);


    /**
     * 修改密码
     * @param access_token
     * @param user_token
     * @param old_password
     * @param new_password
     * @return
     */
    @POST("/api.php/common/changepassword")
    Observable<LoginEntity> updataPassword(@Query("access_token") String access_token,
                                            @Query("user_token") String user_token,
                                            @Query("old_password") String old_password,
                                            @Query("new_password") String new_password);

    /**
     * 头条
     * @param access_token
     * @return
     */
    @POST("/api.php/article/articlelist/category_id/12/")
    Observable<ArticleBean>getArticle(@Query("access_token") String access_token);

    /**
     * 获取快递名称
     * @param key
     * @return
     */
    @GET("/exp/com")
    Observable<ExpressCom> getExpressCom(@Query("key") String key);


    /**
     * 获取快递状态
     * @param key
     * @param com
     * @param no
     * @return
     */
    @POST("/exp/index")
    Observable<Express_Content> getExpressContent(@Query("key") String key,
                                                  @Query("com") String com,
                                                  @Query("no") String no);

    /**
     * 获取卡发现 分类列表
     * @param access_token
     * @return
     */
    @POST("/api.php/cardfind/categorylist")
    Observable<FindCategoryList> getFindCategoryList(@Query("access_token") String access_token);

    /**
     * 获取卡发现 商家列表
     * @param access_token
     * @param list_rows     每页显示条目数
     * @param page          页数
     *
     * @param category_id   分类ID
     * @return
     */
    @POST("/api.php/cardfind/cardfindlist")
    Observable<FindCategoryList> getFindmerchant (@Query("access_token") String access_token,
                                                  @Query("list_rows") String list_rows,
                                                  @Query("page") String page,
                                                  @Query("category_id") String category_id);
    /**
     * 获取卡发现 商家列表
     * @param access_token
     * @param list_rows     每页显示条目数
     * @param page          页数
     *
     * @param category_id   分类ID
     * @return
     */
    @POST("/api.php/cardfind/cardfindlist")
    Observable<Goods> getFindMerchant (@Query("access_token") String access_token,
                                       @Query("list_rows") String list_rows,
                                       @Query("page") String page,
                                       @Query("category_id") String category_id);

    /**
     * 积分商城分类列表
     * @param access_token
     * @return
     */
    @POST("/api.php/seller/categorylist")
    Observable<CategoryEntity> getCategory(@Query("access_token") String access_token);

    /**
     * 银行列表
     * @param access_token
     * @return
     */
    @POST("/api.php/bankcard/bankcardlist")
    Observable<Bank> getBank(@Query("access_token") String access_token);

    /**
     * 优惠详情
     * @return
     *
     */
    @GET("/api.php/cardfind/cardfindinfo/cardfind_id/{cardfind_id}/access_token/{access_token}")
    Observable<Good> getGoodDetails(@Path("access_token") String access_token,
                                    @Path("cardfind_id") String cardfind_id);
    /**
     * 首页列表
     * @param access_token
     * @return
     */
    @POST("/api.php/article/categorylist")
    Observable<NewsCategory> getHomeCategory(@Query("access_token") String access_token);


    /**
     * 广告接口
     * @param access_token
     * @param group 1）、首页广告请求  2）、板块广告请求  3）、植入广告请求
     * @param ad_id
     * @return
     */
    @POST("/api.php/ad/adlist")
    Observable<PictureEntity> getPics(@Query("access_token") String access_token,
                                      @Query("group") String group,
                                      @Query("ad_id") String ad_id);

    /**
    * 积分商城内容列表信息
    * @param access_token
    * @param list_rows
    * @param page
    * @param category_id
    * @return
            */
    @POST("/api.php/seller/sellerlist")
    Observable<SellerEntity> getSellers(@Query("access_token") String access_token,
                                        @Query("list_rows") int list_rows,
                                        @Query("page") int page,
                                        @Query("category_id") int category_id);

    /**
     * 新闻列表
    * @param access_token
    * @param list_rows
    * @param page
    * @param category_id
    * @return
            */
    @POST("/api.php/article/articlelist")
    Observable<News> getNews(@Query("access_token") String access_token,
                             @Query("list_rows") int list_rows,
                             @Query("page") int page,
                             @Query("category_id") int category_id);

    /**
     *  网络新闻分类列表
     * https://way.jd.com/jisuapi/channel?appkey=9a025356104a37cd0c690368a0461f41
     *  9a025356104a37cd0c690368a0461f41
     * @param appkey
     * @return
     */
    @POST("/jisuapi/channel")
    Observable<NetNewsCategory> getNetNewsCategory(@Query("appkey") String appkey);

    /**
     * https://way.jd.com/jisuapi/get?channel=头条&num=11&start=0&appkey=9a025356104a37cd0c690368a0461f41
     * 网络新闻列表
     * @param channel
     * @param num
     * @param start
     * @param appkey
     * @return
     */
    @POST("/jisuapi/get")
    Observable<NetNews> getNetNews( @Query("channel") String channel,
                                            @Query("num") int num,
                                            @Query("start") int start,
                                            @Query("appkey") String appkey);
    /**
     * https://way.jd.com/jisuapi/newSearch? keyword=南京 &appkey=9a025356104a37cd0c690368a0461f41
     * 本地新闻列表
     * @param appkey
     * @return
     */
    @POST("/jisuapi/newSearch")
    Observable<NetNews> getLocalityNews(@Query("keyword") String keyword,
                                              @Query("appkey") String appkey);

    /**
     * 搜索接口
     * @param access_token
     * @param list_rows
     * @param page
     * @param category_id
     * @param search_data
     * @return
     */
    @POST("/api.php/cardfind/cardfindlist")
    Observable<SearchDatas> getSearchData(@Query("access_token") String access_token,
                                          @Query("list_rows") int list_rows,
                                          @Query("page") int page,
                                          @Query("category_id") int category_id,
                                          @Query("search_data")String search_data);

    /**
     * 信用卡账单信息
     * @param email
     * @param password
     * @param appkey
     * @return
     */
    @POST("/creditsaas/get_creditcard_statements")
    Observable<CreditCard> getCreditCard(@Query("email") String email,
                                         @Query("password") String password,
                                         @Query("appkey") String appkey);

    /**
     * 账单列表信息
     * @param ef
     * @param r
     * @param sid
     * @param t
     * @param s
     * @param cursor
     * @param cursorutc
     * @param cursorid
     * @param cursorcount
     * @param cursorsearch
     * @param folderid
     * @param receiver
     * @param sender
     * @param subject
     * @param keyword
     * @param combinetype
     * @param device
     * @param app
     * @param ver
     * @return
     */
    @GET("/cgi-bin/mail_list")
    Observable<CreditDatas> getCreditData(@Query("ef") String ef,
                                          @Query("r") String r,
                                          @Query("sid") String sid,
                                          @Query("t") String t,
                                          @Query("s") String s,
                                          @Query("cursor") String cursor,
                                          @Query("cursorutc") String cursorutc,
                                          @Query("cursorid") String cursorid,
                                          @Query("cursorcount") String cursorcount,
                                          @Query("cursorsearch") String cursorsearch,
                                          @Query("folderid") String folderid,
                                          @Query("receiver") String receiver,
                                          @Query("sender") String sender,
                                          @Query("subject") String subject,
                                          @Query("keyword") String keyword,
                                          @Query("combinetype") String combinetype,
                                          @Query("device") String device,
                                          @Query("app") String app,
                                          @Query("ver") String ver);

    /**
     * 信用卡详细信息
     * @param sid
     * @param t
     * @return
     */
    @GET("/cgi-bin/mobile")
    Observable<String> getCreditDetailData(@Query("sid") String sid,
                                           @Query("t") String t);
}
