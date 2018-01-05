package com.mt.cardletter.https;


import com.mt.cardletter.entity.article.ArticleBean;
import com.mt.cardletter.entity.data.AirDatas;
import com.mt.cardletter.entity.merchant.FindCategoryList;
import com.mt.cardletter.entity.merchant.Goods;
import com.mt.cardletter.entity.merchant.GoodsBean;
import com.mt.cardletter.entity.data.HeWeather;
import com.mt.cardletter.entity.data.ViolateCity;
import com.mt.cardletter.entity.data.ViolateData;
import com.mt.cardletter.entity.express.ExpressCom;
import com.mt.cardletter.entity.express.Express_Content;
import com.mt.cardletter.entity.user.LoginEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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
    @POST("/api.php/article/articlelist")
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
    Observable<Goods> getFindMerchant (@Query("access_token") String access_token,
                                       @Query("list_rows") String list_rows,
                                       @Query("page") String page,
                                       @Query("category_id") String category_id);
}
