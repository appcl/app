package com.mt.cardletter.https.test;


import com.mt.cardletter.entity.creditcard.CreditCard;
import com.mt.cardletter.entity.data.Peccant;
import com.mt.cardletter.https.BaseApi;
import com.mt.cardletter.https.HttpRequestService;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by HQ_Demos on 2017/4/27.
 */

public class PeccantRequestApi extends BaseApi {
    public static PeccantRequestApi httpRequestApi;
    public HttpRequestService httpRequestService;

    public PeccantRequestApi() {
        httpRequestService = PeccantMethod.getInstance().createApi(HttpRequestService.class);
    }
    public static PeccantRequestApi getInstance() {
        if (httpRequestApi == null) {
            httpRequestApi = new PeccantRequestApi();
        }
        return httpRequestApi;
    }

    //    public static void main(String[] args) {
//        String host = "http://ddycapi.market.alicloudapi.com";
//        String path = "/violation/query";
//        String method = "POST";
//        String appcode = "你自己的AppCode";
//        Map<String, String> headers = new HashMap<String, String>();
//        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
//        headers.put("Authorization", "APPCODE " + appcode);
//        //根据API的要求，定义相对应的Content-Type
//        headers.put("Content-Type", "application/json; charset=UTF-8");
//        Map<String, String> querys = new HashMap<String, String>();
//        String bodys = "{\"plateNumber\":\"鲁FE5026\"(车牌号，必填),\"vin\":\"167786\"(车架号，视城市规则是否必填),\"engineNo\":\"013166\"(发动机号，视城市规则是否必填),\"carType\":\"02\"(车辆类型01大车02小车,不必填,默认小车),\"city\":\"烟台市\"(查询城市,不必填,默认查归属地)}";
//
//
//        try {
//            /**
//             * 重要提示如下:
//             * HttpUtils请从
//             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
//             * 下载
//             *
//             * 相应的依赖请参照
//             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
//             */
//            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
//            System.out.println(response.toString());
//            //获取response的body
//            //System.out.println(EntityUtils.toString(response.getEntity()));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    public void getCreditCard(String email,String password,String ak,Subscriber<CreditCard> subscriber){
        Observable observable = httpRequestService.getCreditCard(email,password,ak)
                .map(new HttpResultFunc<CreditCard>());
        toSubscribe(observable,subscriber);
    }

    /**
     * (@Header("Authorization") String appkey,
     @Query("plateNumber") String plateNumber,
     @Query("vin") String vin,
     @Query("engineNo") String engineNo,
     @Query("carType") String carType,
     @Query("city") String city);
     */
    public void getPeccant(String appkey,String plateNumber,String vin,String engineNo,String carType,String city,Subscriber<Peccant> subscriber){
        Observable observable = httpRequestService.getPeccant(plateNumber,vin,engineNo,carType,city)
                .map(new HttpResultFunc<Peccant>());
        toSubscribe(observable,subscriber);
    }
}
