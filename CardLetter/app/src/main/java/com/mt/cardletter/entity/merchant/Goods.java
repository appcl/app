package com.mt.cardletter.entity.merchant;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jk on 2018/1/5.
 * 商家优惠列表
 */

public class Goods implements Serializable{


    /**
     * code : 0
     * msg : 操作成功
     * data : {"total":8159,"per_page":15,"current_page":1,"last_page":544,"data":[{"id":11,"name":"月福汽车装饰(北洼路店)","describe":"享受10元洗车一次","tel":"010-68464425","deadline":"2020/12/31","address":"北洼路东里5号","bankcard":"14","city":"110000","lng":39.939,"lat":116.305,"thumb":null,"thumbs":null,"category_id":"11","content":"\n持光大银行信用卡1活动期间，每周日在月福汽车装饰有限公司指定洗车行刷光大银行信用卡即可享受10元洗车一次。每人每周限参与一次。\n2.每店每个活动日10个名额，权益数额有限，额满为止。首都机场T2、T3航站楼两家月福洗车门店不参与活动。\n3.可参与活动车型：五座(含)以下小轿车；车辆规格：车长：5300毫米以内、车宽：2000毫米以内、车高：2200毫米以内、胎宽：275毫米以内。\n\n                ","create_time":"2017-12-26 12:47:42"},{"id":12,"name":"宽途汽车福翔顺发汽车服务中心","describe":"6折","tel":"400-6666-377","deadline":"2020/12/31","address":"赵登禹路114号","bankcard":"1","city":"110000","lng":39.9306,"lat":116.368,"thumb":"/upload/shop_pic/2/12/999.jpg","thumbs":"/upload/shop_pic/2/12/0.jpg,/upload/shop_pic/2/12/1.jpg,/upload/shop_pic/2/12/2.jpg","category_id":"11","content":"\n工银信用卡在我行指定的宽途门店积分兑换宽途储值洗车卡，持卡人可使用宽途洗车卡在去昂过1287家宽途洗车门店结算，并享受市场价6-7折的专业洗车服务;每600信用卡综合积分兑换1宽途积分，持卡人每次可兑换积分数为50、100、200、500的宽途洗车卡\n                ","create_time":"2017-12-26 12:47:42"},{"id":13,"name":"月福汽车装饰(百旺山店)","describe":"享受10元洗车一次","tel":"010-82404951","deadline":"2020/12/31","address":"永丰路269号百望山北侧(中海枫涟册庄南)","bankcard":"14","city":"110000","lng":40.0462,"lat":116.258,"thumb":null,"thumbs":null,"category_id":"11","content":"\n持光大银行信用卡1活动期间，每周日在月福汽车装饰有限公司指定洗车行刷光大银行信用卡即可享受10元洗车一次。每人每周限参与一次。\n2.每店每个活动日10个名额，权益数额有限，额满为止。首都机场T2、T3航站楼两家月福洗车门店不参与活动。\n3.可参与活动车型：五座(含)以下小轿车；车辆规格：车长：5300毫米以内、车宽：2000毫米以内、车高：2200毫米以内、胎宽：275毫米以内。\n\n                ","create_time":"2017-12-26 12:47:42"},{"id":14,"name":"宽途汽车鑫桥汽车美容","describe":"6折","tel":"400-6666-377","deadline":"2020/12/31","address":"朝阳区朝外大街20号中国人寿大厦地面停车场","bankcard":"1","city":"110000","lng":39.924,"lat":116.439,"thumb":null,"thumbs":null,"category_id":"11","content":"\n工银信用卡在我行指定的宽途门店积分兑换宽途储值洗车卡，持卡人可使用宽途洗车卡在去昂过1287家宽途洗车门店结算，并享受市场价6-7折的专业洗车服务;每600信用卡综合积分兑换1宽途积分，持卡人每次可兑换积分数为50、100、200、500的宽途洗车卡\n                ","create_time":"2017-12-26 12:47:42"},{"id":15,"name":"月福汽车装饰(大屯店)","describe":"享受10元洗车一次","tel":"010-84806726","deadline":"2020/12/31","address":"北苑路嘉和超市对面(六塔小区底层)","bankcard":"14","city":"110000","lng":40.0088,"lat":116.415,"thumb":null,"thumbs":null,"category_id":"11","content":"\n持光大银行信用卡1活动期间，每周日在月福汽车装饰有限公司指定洗车行刷光大银行信用卡即可享受10元洗车一次。每人每周限参与一次。\n2.每店每个活动日10个名额，权益数额有限，额满为止。首都机场T2、T3航站楼两家月福洗车门店不参与活动。\n3.可参与活动车型：五座(含)以下小轿车；车辆规格：车长：5300毫米以内、车宽：2000毫米以内、车高：2200毫米以内、胎宽：275毫米以内。\n\n                ","create_time":"2017-12-26 12:47:42"},{"id":16,"name":"宽途汽车3M陆桥汽车美容（幸福大街北）","describe":"6折","tel":"400-6666-377","deadline":"2020/12/31","address":"幸福大街34-2号","bankcard":"1","city":"110000","lng":39.8867,"lat":116.431,"thumb":null,"thumbs":null,"category_id":"11","content":"\n工银信用卡在我行指定的宽途门店积分兑换宽途储值洗车卡，持卡人可使用宽途洗车卡在去昂过1287家宽途洗车门店结算，并享受市场价6-7折的专业洗车服务;每600信用卡综合积分兑换1宽途积分，持卡人每次可兑换积分数为50、100、200、500的宽途洗车卡\n                ","create_time":"2017-12-26 12:47:42"},{"id":17,"name":"卫宇行汽车服务","describe":"8折","tel":"010-63869718","deadline":"2020/12/31","address":"万丰路288号","bankcard":"9","city":"110000","lng":39.8765,"lat":116.295,"thumb":"/upload/shop_pic/2/17/999.jpg","thumbs":"/upload/shop_pic/2/17/0.jpg,/upload/shop_pic/2/17/1.jpg","category_id":"11","content":"\n持建行卡进店保养工时费八折优惠。发动机清洗套餐最高优惠500元(不同车型优惠不同)\n                ","create_time":"2017-12-26 12:47:42"},{"id":18,"name":"月福汽车装饰(定慧寺店)","describe":"享受10元洗车一次","tel":"010-88635319","deadline":"2020/12/31","address":"西四环外定慧桥西阜石路北侧","bankcard":"14","city":"110000","lng":39.9232,"lat":116.273,"thumb":null,"thumbs":null,"category_id":"11","content":"\n持光大银行信用卡1活动期间，每周日在月福汽车装饰有限公司指定洗车行刷光大银行信用卡即可享受10元洗车一次。每人每周限参与一次。\n2.每店每个活动日10个名额，权益数额有限，额满为止。首都机场T2、T3航站楼两家月福洗车门店不参与活动。\n3.可参与活动车型：五座(含)以下小轿车；车辆规格：车长：5300毫米以内、车宽：2000毫米以内、车高：2200毫米以内、胎宽：275毫米以内。\n\n                ","create_time":"2017-12-26 12:47:42"},{"id":19,"name":"月福汽车装饰(成寿寺店)","describe":"享受10元洗车一次","tel":"010-87628729","deadline":"2020/12/31","address":"成寿寺路中街27号","bankcard":"14","city":"110000","lng":39.8505,"lat":116.445,"thumb":"/upload/shop_pic/2/19/999.jpg","thumbs":"/upload/shop_pic/2/19/0.jpg,/upload/shop_pic/2/19/1.jpg,/upload/shop_pic/2/19/2.jpg","category_id":"11","content":"\n持光大银行信用卡1活动期间，每周日在月福汽车装饰有限公司指定洗车行刷光大银行信用卡即可享受10元洗车一次。每人每周限参与一次。\n2.每店每个活动日10个名额，权益数额有限，额满为止。首都机场T2、T3航站楼两家月福洗车门店不参与活动。\n3.可参与活动车型：五座(含)以下小轿车；车辆规格：车长：5300毫米以内、车宽：2000毫米以内、车高：2200毫米以内、胎宽：275毫米以内。\n\n                ","create_time":"2017-12-26 12:47:42"},{"id":20,"name":"宽途汽车龙泉天洗汽车养护会所","describe":"6折","tel":"400-6666-377","deadline":"2020/12/31","address":"丰融园15号楼B2","bankcard":"1","city":"110000","lng":39.917,"lat":116.366,"thumb":null,"thumbs":null,"category_id":"11","content":"\n工银信用卡在我行指定的宽途门店积分兑换宽途储值洗车卡，持卡人可使用宽途洗车卡在去昂过1287家宽途洗车门店结算，并享受市场价6-7折的专业洗车服务;每600信用卡综合积分兑换1宽途积分，持卡人每次可兑换积分数为50、100、200、500的宽途洗车卡\n                ","create_time":"2017-12-26 12:47:42"},{"id":21,"name":"太平洋咖啡（华润大厦店）","describe":"咖啡6.2元","tel":"010-85192997","deadline":"2018/3/31","address":"建国门北大街8号华润大厦一层大堂","bankcard":"23","city":"110000","lng":39.913,"lat":116.434,"thumb":"/upload/shop_pic/2/21/999.jpg","thumbs":"/upload/shop_pic/2/21/0.jpg,/upload/shop_pic/2/21/1.jpg,/upload/shop_pic/2/21/2.jpg","category_id":"2","content":"\n1、每月16、26日，使用邮储银联白金信用卡（卡号以62开头）持卡人购买任意一款挂耳咖啡，可尊享6.2元专享价。2、每周二、六，使用邮储银联信用卡（卡号以62开头）及信用卡云闪付持卡人购买任意手调饮品，可尊享16元特大杯饮品。\n                ","create_time":"2017-12-26 12:47:42"},{"id":22,"name":"太平洋咖啡（万丰路店）","describe":"咖啡6.2元","tel":"无","deadline":"2018/3/31","address":"万丰路68号院和谐广场一层127号","bankcard":"23","city":"110000","lng":39.8826,"lat":116.299,"thumb":"/upload/shop_pic/2/22/999.jpg","thumbs":"/upload/shop_pic/2/22/0.jpg,/upload/shop_pic/2/22/1.jpg,/upload/shop_pic/2/22/2.jpg","category_id":"2","content":"\n1、每月16、26日，使用邮储银联白金信用卡（卡号以62开头）持卡人购买任意一款挂耳咖啡，可尊享6.2元专享价。2、每周二、六，使用邮储银联信用卡（卡号以62开头）及信用卡云闪付持卡人购买任意手调饮品，可尊享16元特大杯饮品。\n                ","create_time":"2017-12-26 12:47:42"},{"id":23,"name":"汉堡王(北京龙湖店)","describe":"15元优惠价享皇堡/天椒皇堡套餐一份","tel":"无","deadline":"2018/2/8","address":"永兴路7号院1号楼龙湖天街BJSDTJSY-2F-19","bankcard":"9","city":"110000","lng":39.6866,"lat":116.323,"thumb":null,"thumbs":null,"category_id":"2","content":"\n活动期间每周六，至汉堡王全国指定门店使用龙卡信用卡消费（含刷卡、云闪付）即可以15元优惠价享皇堡/天椒皇堡套餐一份。客户每活动日限享1次本活动优惠。每活动日优惠名额有限，先到先得。\n                ","create_time":"2017-12-26 12:47:42"},{"id":24,"name":"汉堡王(北京中海地产店)","describe":"15元优惠价享皇堡/天椒皇堡套餐一份","tel":"010-87924368","deadline":"2018/3/11","address":"西滨河路中海地产F1-01A单元","bankcard":"9","city":"110000","lng":39.8705,"lat":116.389,"thumb":"/upload/shop_pic/2/24/999.jpg","thumbs":"/upload/shop_pic/2/24/0.jpg,/upload/shop_pic/2/24/1.jpg,/upload/shop_pic/2/24/2.jpg","category_id":"2","content":"\n活动期间每周六，至汉堡王全国指定门店使用龙卡信用卡消费（含刷卡、云闪付）即可以15元优惠价享皇堡/天椒皇堡套餐一份。客户每活动日限享1次本活动优惠。每活动日优惠名额有限，先到先得。\n                ","create_time":"2017-12-26 12:47:42"},{"id":25,"name":"太平洋咖啡（五彩城1店）","describe":"咖啡6.2元","tel":"010-82815212","deadline":"2018/3/31","address":"清河中街68号五彩城购物中心4层401","bankcard":"23","city":"110000","lng":40.0306,"lat":116.334,"thumb":"/upload/shop_pic/2/25/999.jpg","thumbs":"/upload/shop_pic/2/25/0.jpg,/upload/shop_pic/2/25/1.jpg,/upload/shop_pic/2/25/2.jpg","category_id":"2","content":"\n1、每月16、26日，使用邮储银联白金信用卡（卡号以62开头）持卡人购买任意一款挂耳咖啡，可尊享6.2元专享价。2、每周二、六，使用邮储银联信用卡（卡号以62开头）及信用卡云闪付持卡人购买任意手调饮品，可尊享16元特大杯饮品。\n                ","create_time":"2017-12-26 12:47:42"}]}
     * exe_time : 0.012556
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private DataBeanX data;
    @SerializedName("exe_time")
    private String exeTime;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public String getExeTime() {
        return exeTime;
    }

    public void setExeTime(String exeTime) {
        this.exeTime = exeTime;
    }

    public static class DataBeanX {
        /**
         * total : 8159
         * per_page : 15
         * current_page : 1
         * last_page : 544
         * data : [{"id":11,"name":"月福汽车装饰(北洼路店)","describe":"享受10元洗车一次","tel":"010-68464425","deadline":"2020/12/31","address":"北洼路东里5号","bankcard":"14","city":"110000","lng":39.939,"lat":116.305,"thumb":null,"thumbs":null,"category_id":"11","content":"\n持光大银行信用卡1活动期间，每周日在月福汽车装饰有限公司指定洗车行刷光大银行信用卡即可享受10元洗车一次。每人每周限参与一次。\n2.每店每个活动日10个名额，权益数额有限，额满为止。首都机场T2、T3航站楼两家月福洗车门店不参与活动。\n3.可参与活动车型：五座(含)以下小轿车；车辆规格：车长：5300毫米以内、车宽：2000毫米以内、车高：2200毫米以内、胎宽：275毫米以内。\n\n                ","create_time":"2017-12-26 12:47:42"},{"id":12,"name":"宽途汽车福翔顺发汽车服务中心","describe":"6折","tel":"400-6666-377","deadline":"2020/12/31","address":"赵登禹路114号","bankcard":"1","city":"110000","lng":39.9306,"lat":116.368,"thumb":"/upload/shop_pic/2/12/999.jpg","thumbs":"/upload/shop_pic/2/12/0.jpg,/upload/shop_pic/2/12/1.jpg,/upload/shop_pic/2/12/2.jpg","category_id":"11","content":"\n工银信用卡在我行指定的宽途门店积分兑换宽途储值洗车卡，持卡人可使用宽途洗车卡在去昂过1287家宽途洗车门店结算，并享受市场价6-7折的专业洗车服务;每600信用卡综合积分兑换1宽途积分，持卡人每次可兑换积分数为50、100、200、500的宽途洗车卡\n                ","create_time":"2017-12-26 12:47:42"},{"id":13,"name":"月福汽车装饰(百旺山店)","describe":"享受10元洗车一次","tel":"010-82404951","deadline":"2020/12/31","address":"永丰路269号百望山北侧(中海枫涟册庄南)","bankcard":"14","city":"110000","lng":40.0462,"lat":116.258,"thumb":null,"thumbs":null,"category_id":"11","content":"\n持光大银行信用卡1活动期间，每周日在月福汽车装饰有限公司指定洗车行刷光大银行信用卡即可享受10元洗车一次。每人每周限参与一次。\n2.每店每个活动日10个名额，权益数额有限，额满为止。首都机场T2、T3航站楼两家月福洗车门店不参与活动。\n3.可参与活动车型：五座(含)以下小轿车；车辆规格：车长：5300毫米以内、车宽：2000毫米以内、车高：2200毫米以内、胎宽：275毫米以内。\n\n                ","create_time":"2017-12-26 12:47:42"},{"id":14,"name":"宽途汽车鑫桥汽车美容","describe":"6折","tel":"400-6666-377","deadline":"2020/12/31","address":"朝阳区朝外大街20号中国人寿大厦地面停车场","bankcard":"1","city":"110000","lng":39.924,"lat":116.439,"thumb":null,"thumbs":null,"category_id":"11","content":"\n工银信用卡在我行指定的宽途门店积分兑换宽途储值洗车卡，持卡人可使用宽途洗车卡在去昂过1287家宽途洗车门店结算，并享受市场价6-7折的专业洗车服务;每600信用卡综合积分兑换1宽途积分，持卡人每次可兑换积分数为50、100、200、500的宽途洗车卡\n                ","create_time":"2017-12-26 12:47:42"},{"id":15,"name":"月福汽车装饰(大屯店)","describe":"享受10元洗车一次","tel":"010-84806726","deadline":"2020/12/31","address":"北苑路嘉和超市对面(六塔小区底层)","bankcard":"14","city":"110000","lng":40.0088,"lat":116.415,"thumb":null,"thumbs":null,"category_id":"11","content":"\n持光大银行信用卡1活动期间，每周日在月福汽车装饰有限公司指定洗车行刷光大银行信用卡即可享受10元洗车一次。每人每周限参与一次。\n2.每店每个活动日10个名额，权益数额有限，额满为止。首都机场T2、T3航站楼两家月福洗车门店不参与活动。\n3.可参与活动车型：五座(含)以下小轿车；车辆规格：车长：5300毫米以内、车宽：2000毫米以内、车高：2200毫米以内、胎宽：275毫米以内。\n\n                ","create_time":"2017-12-26 12:47:42"},{"id":16,"name":"宽途汽车3M陆桥汽车美容（幸福大街北）","describe":"6折","tel":"400-6666-377","deadline":"2020/12/31","address":"幸福大街34-2号","bankcard":"1","city":"110000","lng":39.8867,"lat":116.431,"thumb":null,"thumbs":null,"category_id":"11","content":"\n工银信用卡在我行指定的宽途门店积分兑换宽途储值洗车卡，持卡人可使用宽途洗车卡在去昂过1287家宽途洗车门店结算，并享受市场价6-7折的专业洗车服务;每600信用卡综合积分兑换1宽途积分，持卡人每次可兑换积分数为50、100、200、500的宽途洗车卡\n                ","create_time":"2017-12-26 12:47:42"},{"id":17,"name":"卫宇行汽车服务","describe":"8折","tel":"010-63869718","deadline":"2020/12/31","address":"万丰路288号","bankcard":"9","city":"110000","lng":39.8765,"lat":116.295,"thumb":"/upload/shop_pic/2/17/999.jpg","thumbs":"/upload/shop_pic/2/17/0.jpg,/upload/shop_pic/2/17/1.jpg","category_id":"11","content":"\n持建行卡进店保养工时费八折优惠。发动机清洗套餐最高优惠500元(不同车型优惠不同)\n                ","create_time":"2017-12-26 12:47:42"},{"id":18,"name":"月福汽车装饰(定慧寺店)","describe":"享受10元洗车一次","tel":"010-88635319","deadline":"2020/12/31","address":"西四环外定慧桥西阜石路北侧","bankcard":"14","city":"110000","lng":39.9232,"lat":116.273,"thumb":null,"thumbs":null,"category_id":"11","content":"\n持光大银行信用卡1活动期间，每周日在月福汽车装饰有限公司指定洗车行刷光大银行信用卡即可享受10元洗车一次。每人每周限参与一次。\n2.每店每个活动日10个名额，权益数额有限，额满为止。首都机场T2、T3航站楼两家月福洗车门店不参与活动。\n3.可参与活动车型：五座(含)以下小轿车；车辆规格：车长：5300毫米以内、车宽：2000毫米以内、车高：2200毫米以内、胎宽：275毫米以内。\n\n                ","create_time":"2017-12-26 12:47:42"},{"id":19,"name":"月福汽车装饰(成寿寺店)","describe":"享受10元洗车一次","tel":"010-87628729","deadline":"2020/12/31","address":"成寿寺路中街27号","bankcard":"14","city":"110000","lng":39.8505,"lat":116.445,"thumb":"/upload/shop_pic/2/19/999.jpg","thumbs":"/upload/shop_pic/2/19/0.jpg,/upload/shop_pic/2/19/1.jpg,/upload/shop_pic/2/19/2.jpg","category_id":"11","content":"\n持光大银行信用卡1活动期间，每周日在月福汽车装饰有限公司指定洗车行刷光大银行信用卡即可享受10元洗车一次。每人每周限参与一次。\n2.每店每个活动日10个名额，权益数额有限，额满为止。首都机场T2、T3航站楼两家月福洗车门店不参与活动。\n3.可参与活动车型：五座(含)以下小轿车；车辆规格：车长：5300毫米以内、车宽：2000毫米以内、车高：2200毫米以内、胎宽：275毫米以内。\n\n                ","create_time":"2017-12-26 12:47:42"},{"id":20,"name":"宽途汽车龙泉天洗汽车养护会所","describe":"6折","tel":"400-6666-377","deadline":"2020/12/31","address":"丰融园15号楼B2","bankcard":"1","city":"110000","lng":39.917,"lat":116.366,"thumb":null,"thumbs":null,"category_id":"11","content":"\n工银信用卡在我行指定的宽途门店积分兑换宽途储值洗车卡，持卡人可使用宽途洗车卡在去昂过1287家宽途洗车门店结算，并享受市场价6-7折的专业洗车服务;每600信用卡综合积分兑换1宽途积分，持卡人每次可兑换积分数为50、100、200、500的宽途洗车卡\n                ","create_time":"2017-12-26 12:47:42"},{"id":21,"name":"太平洋咖啡（华润大厦店）","describe":"咖啡6.2元","tel":"010-85192997","deadline":"2018/3/31","address":"建国门北大街8号华润大厦一层大堂","bankcard":"23","city":"110000","lng":39.913,"lat":116.434,"thumb":"/upload/shop_pic/2/21/999.jpg","thumbs":"/upload/shop_pic/2/21/0.jpg,/upload/shop_pic/2/21/1.jpg,/upload/shop_pic/2/21/2.jpg","category_id":"2","content":"\n1、每月16、26日，使用邮储银联白金信用卡（卡号以62开头）持卡人购买任意一款挂耳咖啡，可尊享6.2元专享价。2、每周二、六，使用邮储银联信用卡（卡号以62开头）及信用卡云闪付持卡人购买任意手调饮品，可尊享16元特大杯饮品。\n                ","create_time":"2017-12-26 12:47:42"},{"id":22,"name":"太平洋咖啡（万丰路店）","describe":"咖啡6.2元","tel":"无","deadline":"2018/3/31","address":"万丰路68号院和谐广场一层127号","bankcard":"23","city":"110000","lng":39.8826,"lat":116.299,"thumb":"/upload/shop_pic/2/22/999.jpg","thumbs":"/upload/shop_pic/2/22/0.jpg,/upload/shop_pic/2/22/1.jpg,/upload/shop_pic/2/22/2.jpg","category_id":"2","content":"\n1、每月16、26日，使用邮储银联白金信用卡（卡号以62开头）持卡人购买任意一款挂耳咖啡，可尊享6.2元专享价。2、每周二、六，使用邮储银联信用卡（卡号以62开头）及信用卡云闪付持卡人购买任意手调饮品，可尊享16元特大杯饮品。\n                ","create_time":"2017-12-26 12:47:42"},{"id":23,"name":"汉堡王(北京龙湖店)","describe":"15元优惠价享皇堡/天椒皇堡套餐一份","tel":"无","deadline":"2018/2/8","address":"永兴路7号院1号楼龙湖天街BJSDTJSY-2F-19","bankcard":"9","city":"110000","lng":39.6866,"lat":116.323,"thumb":null,"thumbs":null,"category_id":"2","content":"\n活动期间每周六，至汉堡王全国指定门店使用龙卡信用卡消费（含刷卡、云闪付）即可以15元优惠价享皇堡/天椒皇堡套餐一份。客户每活动日限享1次本活动优惠。每活动日优惠名额有限，先到先得。\n                ","create_time":"2017-12-26 12:47:42"},{"id":24,"name":"汉堡王(北京中海地产店)","describe":"15元优惠价享皇堡/天椒皇堡套餐一份","tel":"010-87924368","deadline":"2018/3/11","address":"西滨河路中海地产F1-01A单元","bankcard":"9","city":"110000","lng":39.8705,"lat":116.389,"thumb":"/upload/shop_pic/2/24/999.jpg","thumbs":"/upload/shop_pic/2/24/0.jpg,/upload/shop_pic/2/24/1.jpg,/upload/shop_pic/2/24/2.jpg","category_id":"2","content":"\n活动期间每周六，至汉堡王全国指定门店使用龙卡信用卡消费（含刷卡、云闪付）即可以15元优惠价享皇堡/天椒皇堡套餐一份。客户每活动日限享1次本活动优惠。每活动日优惠名额有限，先到先得。\n                ","create_time":"2017-12-26 12:47:42"},{"id":25,"name":"太平洋咖啡（五彩城1店）","describe":"咖啡6.2元","tel":"010-82815212","deadline":"2018/3/31","address":"清河中街68号五彩城购物中心4层401","bankcard":"23","city":"110000","lng":40.0306,"lat":116.334,"thumb":"/upload/shop_pic/2/25/999.jpg","thumbs":"/upload/shop_pic/2/25/0.jpg,/upload/shop_pic/2/25/1.jpg,/upload/shop_pic/2/25/2.jpg","category_id":"2","content":"\n1、每月16、26日，使用邮储银联白金信用卡（卡号以62开头）持卡人购买任意一款挂耳咖啡，可尊享6.2元专享价。2、每周二、六，使用邮储银联信用卡（卡号以62开头）及信用卡云闪付持卡人购买任意手调饮品，可尊享16元特大杯饮品。\n                ","create_time":"2017-12-26 12:47:42"}]
         */

        @SerializedName("total")
        private int total;
        @SerializedName("per_page")
        private int perPage;
        @SerializedName("current_page")
        private int currentPage;
        @SerializedName("last_page")
        private int lastPage;
        @SerializedName("data")
        private List<DataBean> data;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPerPage() {
            return perPage;
        }

        public void setPerPage(int perPage) {
            this.perPage = perPage;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 11
             * name : 月福汽车装饰(北洼路店)
             * describe : 享受10元洗车一次
             * tel : 010-68464425
             * deadline : 2020/12/31
             * address : 北洼路东里5号
             * bankcard : 14
             * city : 110000
             * lng : 39.939
             * lat : 116.305
             * thumb : null
             * thumbs : null
             * category_id : 11
             * content :
             持光大银行信用卡1活动期间，每周日在月福汽车装饰有限公司指定洗车行刷光大银行信用卡即可享受10元洗车一次。每人每周限参与一次。
             2.每店每个活动日10个名额，权益数额有限，额满为止。首都机场T2、T3航站楼两家月福洗车门店不参与活动。
             3.可参与活动车型：五座(含)以下小轿车；车辆规格：车长：5300毫米以内、车宽：2000毫米以内、车高：2200毫米以内、胎宽：275毫米以内。


             * create_time : 2017-12-26 12:47:42
             */

            @SerializedName("id")
            private int id;
            @SerializedName("name")
            private String name;
            @SerializedName("describe")
            private String describe;
            @SerializedName("tel")
            private String tel;
            @SerializedName("deadline")
            private String deadline;
            @SerializedName("address")
            private String address;
            @SerializedName("bankcard")
            private String bankcard;
            @SerializedName("city")
            private String city;
            @SerializedName("lng")
            private double lng;
            @SerializedName("lat")
            private double lat;
            @SerializedName("thumb")
            private Object thumb;
            @SerializedName("thumbs")
            private Object thumbs;
            @SerializedName("category_id")
            private String categoryId;
            @SerializedName("content")
            private String content;
            @SerializedName("create_time")
            private String createTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public String getDeadline() {
                return deadline;
            }

            public void setDeadline(String deadline) {
                this.deadline = deadline;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getBankcard() {
                return bankcard;
            }

            public void setBankcard(String bankcard) {
                this.bankcard = bankcard;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public Object getThumb() {
                return thumb;
            }

            public void setThumb(Object thumb) {
                this.thumb = thumb;
            }

            public Object getThumbs() {
                return thumbs;
            }

            public void setThumbs(Object thumbs) {
                this.thumbs = thumbs;
            }

            public String getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(String categoryId) {
                this.categoryId = categoryId;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }
    }
}
