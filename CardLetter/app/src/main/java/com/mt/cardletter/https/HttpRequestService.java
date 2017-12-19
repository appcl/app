package com.mt.cardletter.https;


import com.mt.cardletter.entity.data.AirDatas;
import com.mt.cardletter.entity.data.HeWeather;

import retrofit2.http.GET;
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
}
