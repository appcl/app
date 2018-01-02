package com.mt.cardletter.https;


import com.mt.cardletter.entity.data.AirDatas;
import com.mt.cardletter.entity.data.HeWeather;
import com.mt.cardletter.entity.data.ViolateCity;
import com.mt.cardletter.entity.data.ViolateData;
import com.mt.cardletter.entity.user.LoginEntity;

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
}
