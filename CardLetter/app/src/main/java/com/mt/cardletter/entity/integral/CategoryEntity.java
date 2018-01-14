package com.mt.cardletter.entity.integral;

import java.util.List;

/**
 * Date:2018/1/5
 * Time:18:42
 * author:demons
 */

public class CategoryEntity {
    /**
     * code : 0
     * msg : 操作成功
     * data : {"seller_category_list":[{"id":1,"name":"健康生活"},{"id":2,"name":"闲趣生活"},{"id":3,"name":"厨卫用具"},{"id":4,"name":"宠物用品"},{"id":5,"name":"家居日用"},{"id":6,"name":"彩妆护肤"},{"id":7,"name":"亲子乐园"},{"id":8,"name":"户外运动"},{"id":9,"name":"手机数码"},{"id":10,"name":"汽车用品"},{"id":11,"name":"箱包皮具"},{"id":12,"name":"其他"}],"bankcard_list":[{"id":1,"name":"工商银行","describe":"中国工商银行，国有四大银行之一","card_icon":"/upload/bank/icon/b1_big.png","card_thumb":"/upload/bank/thumb/card1.png","card_img":"/upload/bank/bank/y1.png"},{"id":2,"name":"招商银行","describe":"招商银行是国内大型银行之一","card_icon":"/upload/bank/icon/b4_big.png","card_thumb":"/upload/bank/thumb/card2.png","card_img":"/upload/bank/bank/y2.png"},{"id":3,"name":"中国银行","describe":"中国银行是国有四大银行之一","card_icon":"/upload/bank/icon/b5_big.png","card_thumb":"/upload/bank/thumb/card3.png","card_img":"/upload/bank/bank/y3.png"},{"id":4,"name":"广发银行","describe":"广东发展银行","card_icon":"/upload/bank/icon/b6_big.png","card_thumb":"/upload/bank/thumb/card4.png","card_img":"/upload/bank/bank/y4.png"},{"id":5,"name":"交通银行","describe":"交通银行","card_icon":"/upload/bank/icon/b3_big.png","card_thumb":"/upload/bank/thumb/card5.png","card_img":"/upload/bank/bank/y5.png"},{"id":6,"name":"华夏银行","describe":"华夏银行是商业银行","card_icon":"/upload/bank/icon/b7_big.png","card_thumb":"/upload/bank/thumb/card6.png","card_img":"/upload/bank/bank/y6.png"},{"id":7,"name":"农业银行","describe":"中国农业银行，国有四大商业银行之一","card_icon":"/upload/bank/icon/b8_big.png","card_thumb":"/upload/bank/thumb/card7.png","card_img":"/upload/bank/bank/y7.png"},{"id":8,"name":"兴业银行","describe":"兴业银行，商业银行之一","card_icon":"/upload/bank/icon/b9_big.png","card_thumb":"/upload/bank/thumb/card8.png","card_img":"/upload/bank/bank/y8.png"},{"id":9,"name":"建设银行","describe":"中国建设银行，国有四大商业银行之一","card_icon":"/upload/bank/icon/b10_big.png","card_thumb":"/upload/bank/thumb/card9.png","card_img":"/upload/bank/bank/y9.png"},{"id":10,"name":"浦发银行","describe":"浦东发展银行","card_icon":"/upload/bank/icon/b11_big.png","card_thumb":"/upload/bank/thumb/card10.png","card_img":"/upload/bank/bank/y10.png"},{"id":11,"name":"民生银行","describe":"中国民生银行，商业银行之一","card_icon":"/upload/bank/icon/b12_big.png","card_thumb":"/upload/bank/thumb/card11.png","card_img":"/upload/bank/bank/y11.png"},{"id":12,"name":"南京银行","describe":"南京银行，商业银行","card_icon":"/upload/bank/icon/b13_big.png","card_thumb":"/upload/bank/thumb/card12.png","card_img":"/upload/bank/bank/y12.png"},{"id":13,"name":"北京银行","describe":"北京商业银行","card_icon":"/upload/bank/icon/b14_big.png","card_thumb":"/upload/bank/thumb/card13.png","card_img":"/upload/bank/bank/y13.png"},{"id":14,"name":"光大银行","describe":"中国光大银行，商业银行","card_icon":"/upload/bank/icon/b15_big.png","card_thumb":"/upload/bank/thumb/card14.png","card_img":"/upload/bank/bank/y14.png"},{"id":15,"name":"平安银行","describe":"中国平安银行，国有商业银行","card_icon":"/upload/bank/icon/b16_big.png","card_thumb":"/upload/bank/thumb/card15.png","card_img":"/upload/bank/bank/y15.png"},{"id":16,"name":"中信银行","describe":"中信银行，商业银行之一","card_icon":"/upload/bank/icon/b17_big.png","card_thumb":"/upload/bank/thumb/card16.png","card_img":"/upload/bank/bank/y16.png"},{"id":17,"name":"上海农商","describe":"上海农商银行","card_icon":"/upload/bank/icon/b18_big.png","card_thumb":"/upload/bank/thumb/card17.png","card_img":"/upload/bank/bank/y17.png"},{"id":18,"name":"杭州银行","describe":"杭州银行，商业银行","card_icon":"/upload/bank/icon/b19_big.png","card_thumb":"/upload/bank/thumb/card18.png","card_img":"/upload/bank/bank/y18.png"},{"id":19,"name":"江苏银行","describe":"江苏银行，商业银行","card_icon":"/upload/bank/icon/b20_big.png","card_thumb":"/upload/bank/thumb/card19.png","card_img":"/upload/bank/bank/y19.png"},{"id":20,"name":"上海银行","describe":"上海商业银行，商业银行","card_icon":"/upload/bank/icon/b21_big.png","card_thumb":"/upload/bank/thumb/card20.png","card_img":"/upload/bank/bank/y20.png"},{"id":21,"name":"花旗银行","describe":"花旗银行，外资银行","card_icon":"/upload/bank/icon/b22_big.png","card_thumb":"/upload/bank/thumb/card21.png","card_img":"/upload/bank/bank/y21.png"},{"id":22,"name":"银联","describe":"银联","card_icon":"/upload/bank/icon/b23_big.png","card_thumb":"/upload/bank/thumb/card22.png","card_img":"/upload/bank/bank/y22.png"},{"id":23,"name":"邮储银行","describe":"邮政储蓄银行","card_icon":"/upload/bank/icon/b24_big.png","card_thumb":"/upload/bank/thumb/card23.png","card_img":"/upload/bank/bank/y23.png"},{"id":24,"name":"天津银行","describe":"天津银行，商业银行","card_icon":"/upload/bank/icon/b25_big.png","card_thumb":"/upload/bank/thumb/card24.png","card_img":"/upload/bank/bank/y24.png"},{"id":25,"name":"广州银行","describe":"广州商业银行","card_icon":"/upload/bank/icon/b26_big.png","card_thumb":"/upload/bank/thumb/card25.png","card_img":"/upload/bank/bank/y25.png"},{"id":26,"name":"渤海银行","describe":"渤海商业银行","card_icon":"/upload/bank/icon/b27_big.png","card_thumb":"/upload/bank/thumb/card26.png","card_img":"/upload/bank/bank/y26.png"},{"id":27,"name":"浙商银行","describe":"浙江商业银行","card_icon":"/upload/bank/icon/b28_big.png","card_thumb":"/upload/bank/thumb/card27.png","card_img":"/upload/bank/bank/y27.png"},{"id":28,"name":"北京农商","describe":"北京农商银行","card_icon":"/upload/bank/icon/b29_big.png","card_thumb":"/upload/bank/thumb/card28.png","card_img":"/upload/bank/bank/y28.png"},{"id":29,"name":"广州农商","describe":"广州农商银行","card_icon":"/upload/bank/icon/b30_big.png","card_thumb":"/upload/bank/thumb/card29.png","card_img":"/upload/bank/bank/y29.png"},{"id":30,"name":"汇丰银行","describe":"商业银行，外资银行","card_icon":"/upload/bank/icon/b31_big.png","card_thumb":"/upload/bank/thumb/card30.png","card_img":"/upload/bank/bank/y30.png"},{"id":31,"name":"东亚银行","describe":"日本商业银行，外资银行","card_icon":"/upload/bank/icon/b32_big.png","card_thumb":"/upload/bank/thumb/card31.png","card_img":"/upload/bank/bank/y31.png"}],"seller_list":{"total":3170,"per_page":"10","current_page":1,"last_page":317,"data":[{"id":1,"name":"6积分抢兑Blueair空气净化器","category_id":"12","describe":"2017年11月1日至11月30日，银联白金卡客户报名且消费达标，可于2017年12月27日0时至12月28日24时6积分抢兑Blueair空气净化器。抢兑礼品限量1000份，礼品编号：6663。详见农行官网。","need_score":6,"bankcard":"7","thumb":"/upload/img/nyyh/6663/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=808&typeName=积分抢兑专区","create_time":"2017-12-26 12:47:42"},{"id":2,"name":"6积分抢兑美的扫地机器人","category_id":"12","describe":"2017年11月1日至11月30日，农行公务卡持卡人报名且消费达标，可于2017年12月21日0时至12月22日24时6积分抢兑美的扫地机器人。礼品限量2000份，抢兑礼品编号：6657。详见农行官网。","need_score":6,"bankcard":"7","thumb":"/upload/img/nyyh/6657/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=807&typeName=积分抢兑专区","create_time":"2017-12-26 12:47:42"},{"id":3,"name":"慕思美臀枕（坐垫）","category_id":"5","describe":"（仅限漂亮升级妈妈信用卡持卡人申请兑换，仅扣减漂亮级妈妈信用卡账户级积分）<\/br>1、凹弧设计，均匀受力，贴合臀部曲线；2、面料柔软细腻，干爽透气。温馨提示：本品为单个装，白色、蓝色随机发放。","need_score":158000,"bankcard":"7","thumb":"/upload/img/nyyh/1722/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=771&typeName=品味健康","create_time":"2017-12-26 12:47:42"},{"id":4,"name":"Blueair家用空气净化器203","category_id":"2","describe":"英文名称：Blueair air cleaner 203,型号：203。<\/br>本品提供予您安全、健康、纯净的室内空气，让您享受每一刻健康洁净的呼吸；三大国际认证：AHAM认证、零臭氧认证、能源之星认证；静致之选，轻松入眠；金属机身，彰显北欧品质；HEPASilent®专利技术，低风阻、低噪音、高效率。","need_score":1610000,"bankcard":"7","thumb":"/upload/img/nyyh/1720/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=781&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":5,"name":"戴森空气净化风扇智能版TP02","category_id":"2","describe":"型号：TP02。本品自动净化99.95%小至PM0.1的有害颗粒物；Air Amplifier技术有效循环室内空气，带来舒适强劲凉风。通过Dyson link应用程序，可以轻松检测家中的空气质量。本品为单台装，有白银色和铁蓝色，随机发放。","need_score":2810000,"bankcard":"7","thumb":"/upload/img/nyyh/1719/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=780&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":6,"name":"戴森空气净化风扇智能版DP01","category_id":"2","describe":"型号：DP01。本品自动净化99.95%小至PM0.1的有害颗粒物；Air Amplifier技术有效循环室内空气，带来舒适强劲凉风。通过Dyson link应用程序，可以轻松检测家中的空气质量。本品为单台装，有白银色和铁蓝色，随机发放。","need_score":2000000,"bankcard":"7","thumb":"/upload/img/nyyh/1718/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=779&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":7,"name":"戴森手持式吸尘器V6 Motorhead","category_id":"2","describe":"型号：V6 Motorhead。本品不限于地板清洁，轻巧设计可以迅速转换长柄至手持模式，便于清洁高处、低处及其他难以触及的中间位置。吸力强劲，有助吸除微尘和过敏原。","need_score":1620000,"bankcard":"7","thumb":"/upload/img/nyyh/1717/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=778&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":8,"name":"戴森加湿器风扇二合一AM10","category_id":"2","describe":"型号：AM10。1、本品拥有专利紫外线杀菌技术，通过短波紫外线处理每一滴水，可有效杀死水中99.9%的细菌，对大肠杆菌同样有效；<\/br>2、水流入压电室，经过第二紫外光照射，最后被雾化成为细腻清洁的水雾；<\/br>3、通过智能湿度控制系统，可均匀湿润室内空间；<\/br>4、本品拥有专利AIR AMPLIFIER气流技术；<\/br>5、本品具有加湿和风扇双重功能，可全年使用；<\/br>6、本品为单个包装，颜色有：银白、铁蓝， 二色随机发放。","need_score":2270000,"bankcard":"7","thumb":"/upload/img/nyyh/1716/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=777&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":9,"name":"戴森空气净化风扇AM11","category_id":"2","describe":"型号：AM11。<\/br>1、净化99.5%的微小颗粒。2、能够清除有毒气体和异味。3、智能APP自动调节净化。4、全新夜间模式，安心睡眠。5、无须维护，只需更换过滤网。6、占地面积小，精巧轻便。7、多个空气监测口，实时监测空气状况。7、气态净化CADR：200-299固态净化CADR：300-3998、噪音（db) （最小风量）低于35分贝-（最大风量）62分贝。","need_score":2540000,"bankcard":"7","thumb":"/upload/img/nyyh/1715/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=776&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":10,"name":"戴森落地式无叶风扇AM08","category_id":"2","describe":"型号：AM08。1、功率：最强气流可达（公升/秒）: 600；<\/br>2、全新Dyson Cool风扇，安全无扇叶，既安静、又强劲；<\/br>3、气流倍增技术，周围空气由环形气孔引入，加速放大后形成舒适而有力的气流；<\/br>4、马达壳采取减震设计，直流马达，更节能，更安静； <\/br>5、不设快速旋转叶片，且低重心设计。","need_score":2050000,"bankcard":"7","thumb":"/upload/img/nyyh/1714/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=775&typeName=时尚人生","create_time":"2017-12-26 12:47:42"}]}}
     * exe_time : 0.011213
     */

    private int code;
    private String msg;
    private DataBeanX data;
    private String exe_time;

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

    public String getExe_time() {
        return exe_time;
    }

    public void setExe_time(String exe_time) {
        this.exe_time = exe_time;
    }

    public static class DataBeanX {
        /**
         * seller_category_list : [{"id":1,"name":"健康生活"},{"id":2,"name":"闲趣生活"},{"id":3,"name":"厨卫用具"},{"id":4,"name":"宠物用品"},{"id":5,"name":"家居日用"},{"id":6,"name":"彩妆护肤"},{"id":7,"name":"亲子乐园"},{"id":8,"name":"户外运动"},{"id":9,"name":"手机数码"},{"id":10,"name":"汽车用品"},{"id":11,"name":"箱包皮具"},{"id":12,"name":"其他"}]
         * bankcard_list : [{"id":1,"name":"工商银行","describe":"中国工商银行，国有四大银行之一","card_icon":"/upload/bank/icon/b1_big.png","card_thumb":"/upload/bank/thumb/card1.png","card_img":"/upload/bank/bank/y1.png"},{"id":2,"name":"招商银行","describe":"招商银行是国内大型银行之一","card_icon":"/upload/bank/icon/b4_big.png","card_thumb":"/upload/bank/thumb/card2.png","card_img":"/upload/bank/bank/y2.png"},{"id":3,"name":"中国银行","describe":"中国银行是国有四大银行之一","card_icon":"/upload/bank/icon/b5_big.png","card_thumb":"/upload/bank/thumb/card3.png","card_img":"/upload/bank/bank/y3.png"},{"id":4,"name":"广发银行","describe":"广东发展银行","card_icon":"/upload/bank/icon/b6_big.png","card_thumb":"/upload/bank/thumb/card4.png","card_img":"/upload/bank/bank/y4.png"},{"id":5,"name":"交通银行","describe":"交通银行","card_icon":"/upload/bank/icon/b3_big.png","card_thumb":"/upload/bank/thumb/card5.png","card_img":"/upload/bank/bank/y5.png"},{"id":6,"name":"华夏银行","describe":"华夏银行是商业银行","card_icon":"/upload/bank/icon/b7_big.png","card_thumb":"/upload/bank/thumb/card6.png","card_img":"/upload/bank/bank/y6.png"},{"id":7,"name":"农业银行","describe":"中国农业银行，国有四大商业银行之一","card_icon":"/upload/bank/icon/b8_big.png","card_thumb":"/upload/bank/thumb/card7.png","card_img":"/upload/bank/bank/y7.png"},{"id":8,"name":"兴业银行","describe":"兴业银行，商业银行之一","card_icon":"/upload/bank/icon/b9_big.png","card_thumb":"/upload/bank/thumb/card8.png","card_img":"/upload/bank/bank/y8.png"},{"id":9,"name":"建设银行","describe":"中国建设银行，国有四大商业银行之一","card_icon":"/upload/bank/icon/b10_big.png","card_thumb":"/upload/bank/thumb/card9.png","card_img":"/upload/bank/bank/y9.png"},{"id":10,"name":"浦发银行","describe":"浦东发展银行","card_icon":"/upload/bank/icon/b11_big.png","card_thumb":"/upload/bank/thumb/card10.png","card_img":"/upload/bank/bank/y10.png"},{"id":11,"name":"民生银行","describe":"中国民生银行，商业银行之一","card_icon":"/upload/bank/icon/b12_big.png","card_thumb":"/upload/bank/thumb/card11.png","card_img":"/upload/bank/bank/y11.png"},{"id":12,"name":"南京银行","describe":"南京银行，商业银行","card_icon":"/upload/bank/icon/b13_big.png","card_thumb":"/upload/bank/thumb/card12.png","card_img":"/upload/bank/bank/y12.png"},{"id":13,"name":"北京银行","describe":"北京商业银行","card_icon":"/upload/bank/icon/b14_big.png","card_thumb":"/upload/bank/thumb/card13.png","card_img":"/upload/bank/bank/y13.png"},{"id":14,"name":"光大银行","describe":"中国光大银行，商业银行","card_icon":"/upload/bank/icon/b15_big.png","card_thumb":"/upload/bank/thumb/card14.png","card_img":"/upload/bank/bank/y14.png"},{"id":15,"name":"平安银行","describe":"中国平安银行，国有商业银行","card_icon":"/upload/bank/icon/b16_big.png","card_thumb":"/upload/bank/thumb/card15.png","card_img":"/upload/bank/bank/y15.png"},{"id":16,"name":"中信银行","describe":"中信银行，商业银行之一","card_icon":"/upload/bank/icon/b17_big.png","card_thumb":"/upload/bank/thumb/card16.png","card_img":"/upload/bank/bank/y16.png"},{"id":17,"name":"上海农商","describe":"上海农商银行","card_icon":"/upload/bank/icon/b18_big.png","card_thumb":"/upload/bank/thumb/card17.png","card_img":"/upload/bank/bank/y17.png"},{"id":18,"name":"杭州银行","describe":"杭州银行，商业银行","card_icon":"/upload/bank/icon/b19_big.png","card_thumb":"/upload/bank/thumb/card18.png","card_img":"/upload/bank/bank/y18.png"},{"id":19,"name":"江苏银行","describe":"江苏银行，商业银行","card_icon":"/upload/bank/icon/b20_big.png","card_thumb":"/upload/bank/thumb/card19.png","card_img":"/upload/bank/bank/y19.png"},{"id":20,"name":"上海银行","describe":"上海商业银行，商业银行","card_icon":"/upload/bank/icon/b21_big.png","card_thumb":"/upload/bank/thumb/card20.png","card_img":"/upload/bank/bank/y20.png"},{"id":21,"name":"花旗银行","describe":"花旗银行，外资银行","card_icon":"/upload/bank/icon/b22_big.png","card_thumb":"/upload/bank/thumb/card21.png","card_img":"/upload/bank/bank/y21.png"},{"id":22,"name":"银联","describe":"银联","card_icon":"/upload/bank/icon/b23_big.png","card_thumb":"/upload/bank/thumb/card22.png","card_img":"/upload/bank/bank/y22.png"},{"id":23,"name":"邮储银行","describe":"邮政储蓄银行","card_icon":"/upload/bank/icon/b24_big.png","card_thumb":"/upload/bank/thumb/card23.png","card_img":"/upload/bank/bank/y23.png"},{"id":24,"name":"天津银行","describe":"天津银行，商业银行","card_icon":"/upload/bank/icon/b25_big.png","card_thumb":"/upload/bank/thumb/card24.png","card_img":"/upload/bank/bank/y24.png"},{"id":25,"name":"广州银行","describe":"广州商业银行","card_icon":"/upload/bank/icon/b26_big.png","card_thumb":"/upload/bank/thumb/card25.png","card_img":"/upload/bank/bank/y25.png"},{"id":26,"name":"渤海银行","describe":"渤海商业银行","card_icon":"/upload/bank/icon/b27_big.png","card_thumb":"/upload/bank/thumb/card26.png","card_img":"/upload/bank/bank/y26.png"},{"id":27,"name":"浙商银行","describe":"浙江商业银行","card_icon":"/upload/bank/icon/b28_big.png","card_thumb":"/upload/bank/thumb/card27.png","card_img":"/upload/bank/bank/y27.png"},{"id":28,"name":"北京农商","describe":"北京农商银行","card_icon":"/upload/bank/icon/b29_big.png","card_thumb":"/upload/bank/thumb/card28.png","card_img":"/upload/bank/bank/y28.png"},{"id":29,"name":"广州农商","describe":"广州农商银行","card_icon":"/upload/bank/icon/b30_big.png","card_thumb":"/upload/bank/thumb/card29.png","card_img":"/upload/bank/bank/y29.png"},{"id":30,"name":"汇丰银行","describe":"商业银行，外资银行","card_icon":"/upload/bank/icon/b31_big.png","card_thumb":"/upload/bank/thumb/card30.png","card_img":"/upload/bank/bank/y30.png"},{"id":31,"name":"东亚银行","describe":"日本商业银行，外资银行","card_icon":"/upload/bank/icon/b32_big.png","card_thumb":"/upload/bank/thumb/card31.png","card_img":"/upload/bank/bank/y31.png"}]
         * seller_list : {"total":3170,"per_page":"10","current_page":1,"last_page":317,"data":[{"id":1,"name":"6积分抢兑Blueair空气净化器","category_id":"12","describe":"2017年11月1日至11月30日，银联白金卡客户报名且消费达标，可于2017年12月27日0时至12月28日24时6积分抢兑Blueair空气净化器。抢兑礼品限量1000份，礼品编号：6663。详见农行官网。","need_score":6,"bankcard":"7","thumb":"/upload/img/nyyh/6663/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=808&typeName=积分抢兑专区","create_time":"2017-12-26 12:47:42"},{"id":2,"name":"6积分抢兑美的扫地机器人","category_id":"12","describe":"2017年11月1日至11月30日，农行公务卡持卡人报名且消费达标，可于2017年12月21日0时至12月22日24时6积分抢兑美的扫地机器人。礼品限量2000份，抢兑礼品编号：6657。详见农行官网。","need_score":6,"bankcard":"7","thumb":"/upload/img/nyyh/6657/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=807&typeName=积分抢兑专区","create_time":"2017-12-26 12:47:42"},{"id":3,"name":"慕思美臀枕（坐垫）","category_id":"5","describe":"（仅限漂亮升级妈妈信用卡持卡人申请兑换，仅扣减漂亮级妈妈信用卡账户级积分）<\/br>1、凹弧设计，均匀受力，贴合臀部曲线；2、面料柔软细腻，干爽透气。温馨提示：本品为单个装，白色、蓝色随机发放。","need_score":158000,"bankcard":"7","thumb":"/upload/img/nyyh/1722/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=771&typeName=品味健康","create_time":"2017-12-26 12:47:42"},{"id":4,"name":"Blueair家用空气净化器203","category_id":"2","describe":"英文名称：Blueair air cleaner 203,型号：203。<\/br>本品提供予您安全、健康、纯净的室内空气，让您享受每一刻健康洁净的呼吸；三大国际认证：AHAM认证、零臭氧认证、能源之星认证；静致之选，轻松入眠；金属机身，彰显北欧品质；HEPASilent®专利技术，低风阻、低噪音、高效率。","need_score":1610000,"bankcard":"7","thumb":"/upload/img/nyyh/1720/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=781&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":5,"name":"戴森空气净化风扇智能版TP02","category_id":"2","describe":"型号：TP02。本品自动净化99.95%小至PM0.1的有害颗粒物；Air Amplifier技术有效循环室内空气，带来舒适强劲凉风。通过Dyson link应用程序，可以轻松检测家中的空气质量。本品为单台装，有白银色和铁蓝色，随机发放。","need_score":2810000,"bankcard":"7","thumb":"/upload/img/nyyh/1719/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=780&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":6,"name":"戴森空气净化风扇智能版DP01","category_id":"2","describe":"型号：DP01。本品自动净化99.95%小至PM0.1的有害颗粒物；Air Amplifier技术有效循环室内空气，带来舒适强劲凉风。通过Dyson link应用程序，可以轻松检测家中的空气质量。本品为单台装，有白银色和铁蓝色，随机发放。","need_score":2000000,"bankcard":"7","thumb":"/upload/img/nyyh/1718/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=779&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":7,"name":"戴森手持式吸尘器V6 Motorhead","category_id":"2","describe":"型号：V6 Motorhead。本品不限于地板清洁，轻巧设计可以迅速转换长柄至手持模式，便于清洁高处、低处及其他难以触及的中间位置。吸力强劲，有助吸除微尘和过敏原。","need_score":1620000,"bankcard":"7","thumb":"/upload/img/nyyh/1717/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=778&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":8,"name":"戴森加湿器风扇二合一AM10","category_id":"2","describe":"型号：AM10。1、本品拥有专利紫外线杀菌技术，通过短波紫外线处理每一滴水，可有效杀死水中99.9%的细菌，对大肠杆菌同样有效；<\/br>2、水流入压电室，经过第二紫外光照射，最后被雾化成为细腻清洁的水雾；<\/br>3、通过智能湿度控制系统，可均匀湿润室内空间；<\/br>4、本品拥有专利AIR AMPLIFIER气流技术；<\/br>5、本品具有加湿和风扇双重功能，可全年使用；<\/br>6、本品为单个包装，颜色有：银白、铁蓝， 二色随机发放。","need_score":2270000,"bankcard":"7","thumb":"/upload/img/nyyh/1716/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=777&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":9,"name":"戴森空气净化风扇AM11","category_id":"2","describe":"型号：AM11。<\/br>1、净化99.5%的微小颗粒。2、能够清除有毒气体和异味。3、智能APP自动调节净化。4、全新夜间模式，安心睡眠。5、无须维护，只需更换过滤网。6、占地面积小，精巧轻便。7、多个空气监测口，实时监测空气状况。7、气态净化CADR：200-299固态净化CADR：300-3998、噪音（db) （最小风量）低于35分贝-（最大风量）62分贝。","need_score":2540000,"bankcard":"7","thumb":"/upload/img/nyyh/1715/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=776&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":10,"name":"戴森落地式无叶风扇AM08","category_id":"2","describe":"型号：AM08。1、功率：最强气流可达（公升/秒）: 600；<\/br>2、全新Dyson Cool风扇，安全无扇叶，既安静、又强劲；<\/br>3、气流倍增技术，周围空气由环形气孔引入，加速放大后形成舒适而有力的气流；<\/br>4、马达壳采取减震设计，直流马达，更节能，更安静； <\/br>5、不设快速旋转叶片，且低重心设计。","need_score":2050000,"bankcard":"7","thumb":"/upload/img/nyyh/1714/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=775&typeName=时尚人生","create_time":"2017-12-26 12:47:42"}]}
         */

        private SellerListBean seller_list;
        private List<SellerCategoryListBean> seller_category_list;
        private List<BankcardListBean> bankcard_list;

        public SellerListBean getSeller_list() {
            return seller_list;
        }

        public void setSeller_list(SellerListBean seller_list) {
            this.seller_list = seller_list;
        }

        public List<SellerCategoryListBean> getSeller_category_list() {
            return seller_category_list;
        }

        public void setSeller_category_list(List<SellerCategoryListBean> seller_category_list) {
            this.seller_category_list = seller_category_list;
        }

        public List<BankcardListBean> getBankcard_list() {
            return bankcard_list;
        }

        public void setBankcard_list(List<BankcardListBean> bankcard_list) {
            this.bankcard_list = bankcard_list;
        }

        public static class SellerListBean {
            /**
             * total : 3170
             * per_page : 10
             * current_page : 1
             * last_page : 317
             * data : [{"id":1,"name":"6积分抢兑Blueair空气净化器","category_id":"12","describe":"2017年11月1日至11月30日，银联白金卡客户报名且消费达标，可于2017年12月27日0时至12月28日24时6积分抢兑Blueair空气净化器。抢兑礼品限量1000份，礼品编号：6663。详见农行官网。","need_score":6,"bankcard":"7","thumb":"/upload/img/nyyh/6663/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=808&typeName=积分抢兑专区","create_time":"2017-12-26 12:47:42"},{"id":2,"name":"6积分抢兑美的扫地机器人","category_id":"12","describe":"2017年11月1日至11月30日，农行公务卡持卡人报名且消费达标，可于2017年12月21日0时至12月22日24时6积分抢兑美的扫地机器人。礼品限量2000份，抢兑礼品编号：6657。详见农行官网。","need_score":6,"bankcard":"7","thumb":"/upload/img/nyyh/6657/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=807&typeName=积分抢兑专区","create_time":"2017-12-26 12:47:42"},{"id":3,"name":"慕思美臀枕（坐垫）","category_id":"5","describe":"（仅限漂亮升级妈妈信用卡持卡人申请兑换，仅扣减漂亮级妈妈信用卡账户级积分）<\/br>1、凹弧设计，均匀受力，贴合臀部曲线；2、面料柔软细腻，干爽透气。温馨提示：本品为单个装，白色、蓝色随机发放。","need_score":158000,"bankcard":"7","thumb":"/upload/img/nyyh/1722/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=771&typeName=品味健康","create_time":"2017-12-26 12:47:42"},{"id":4,"name":"Blueair家用空气净化器203","category_id":"2","describe":"英文名称：Blueair air cleaner 203,型号：203。<\/br>本品提供予您安全、健康、纯净的室内空气，让您享受每一刻健康洁净的呼吸；三大国际认证：AHAM认证、零臭氧认证、能源之星认证；静致之选，轻松入眠；金属机身，彰显北欧品质；HEPASilent®专利技术，低风阻、低噪音、高效率。","need_score":1610000,"bankcard":"7","thumb":"/upload/img/nyyh/1720/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=781&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":5,"name":"戴森空气净化风扇智能版TP02","category_id":"2","describe":"型号：TP02。本品自动净化99.95%小至PM0.1的有害颗粒物；Air Amplifier技术有效循环室内空气，带来舒适强劲凉风。通过Dyson link应用程序，可以轻松检测家中的空气质量。本品为单台装，有白银色和铁蓝色，随机发放。","need_score":2810000,"bankcard":"7","thumb":"/upload/img/nyyh/1719/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=780&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":6,"name":"戴森空气净化风扇智能版DP01","category_id":"2","describe":"型号：DP01。本品自动净化99.95%小至PM0.1的有害颗粒物；Air Amplifier技术有效循环室内空气，带来舒适强劲凉风。通过Dyson link应用程序，可以轻松检测家中的空气质量。本品为单台装，有白银色和铁蓝色，随机发放。","need_score":2000000,"bankcard":"7","thumb":"/upload/img/nyyh/1718/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=779&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":7,"name":"戴森手持式吸尘器V6 Motorhead","category_id":"2","describe":"型号：V6 Motorhead。本品不限于地板清洁，轻巧设计可以迅速转换长柄至手持模式，便于清洁高处、低处及其他难以触及的中间位置。吸力强劲，有助吸除微尘和过敏原。","need_score":1620000,"bankcard":"7","thumb":"/upload/img/nyyh/1717/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=778&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":8,"name":"戴森加湿器风扇二合一AM10","category_id":"2","describe":"型号：AM10。1、本品拥有专利紫外线杀菌技术，通过短波紫外线处理每一滴水，可有效杀死水中99.9%的细菌，对大肠杆菌同样有效；<\/br>2、水流入压电室，经过第二紫外光照射，最后被雾化成为细腻清洁的水雾；<\/br>3、通过智能湿度控制系统，可均匀湿润室内空间；<\/br>4、本品拥有专利AIR AMPLIFIER气流技术；<\/br>5、本品具有加湿和风扇双重功能，可全年使用；<\/br>6、本品为单个包装，颜色有：银白、铁蓝， 二色随机发放。","need_score":2270000,"bankcard":"7","thumb":"/upload/img/nyyh/1716/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=777&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":9,"name":"戴森空气净化风扇AM11","category_id":"2","describe":"型号：AM11。<\/br>1、净化99.5%的微小颗粒。2、能够清除有毒气体和异味。3、智能APP自动调节净化。4、全新夜间模式，安心睡眠。5、无须维护，只需更换过滤网。6、占地面积小，精巧轻便。7、多个空气监测口，实时监测空气状况。7、气态净化CADR：200-299固态净化CADR：300-3998、噪音（db) （最小风量）低于35分贝-（最大风量）62分贝。","need_score":2540000,"bankcard":"7","thumb":"/upload/img/nyyh/1715/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=776&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":10,"name":"戴森落地式无叶风扇AM08","category_id":"2","describe":"型号：AM08。1、功率：最强气流可达（公升/秒）: 600；<\/br>2、全新Dyson Cool风扇，安全无扇叶，既安静、又强劲；<\/br>3、气流倍增技术，周围空气由环形气孔引入，加速放大后形成舒适而有力的气流；<\/br>4、马达壳采取减震设计，直流马达，更节能，更安静； <\/br>5、不设快速旋转叶片，且低重心设计。","need_score":2050000,"bankcard":"7","thumb":"/upload/img/nyyh/1714/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=775&typeName=时尚人生","create_time":"2017-12-26 12:47:42"}]
             */

            private int total;
            private String per_page;
            private int current_page;
            private int last_page;
            private List<DataBean> data;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public String getPer_page() {
                return per_page;
            }

            public void setPer_page(String per_page) {
                this.per_page = per_page;
            }

            public int getCurrent_page() {
                return current_page;
            }

            public void setCurrent_page(int current_page) {
                this.current_page = current_page;
            }

            public int getLast_page() {
                return last_page;
            }

            public void setLast_page(int last_page) {
                this.last_page = last_page;
            }

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public static class DataBean {
                /**
                 * id : 1
                 * name : 6积分抢兑Blueair空气净化器
                 * category_id : 12
                 * describe : 2017年11月1日至11月30日，银联白金卡客户报名且消费达标，可于2017年12月27日0时至12月28日24时6积分抢兑Blueair空气净化器。抢兑礼品限量1000份，礼品编号：6663。详见农行官网。
                 * need_score : 6
                 * bankcard : 7
                 * thumb : /upload/img/nyyh/6663/1.jpg
                 * thumbs : null
                 * b_url : http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=808&typeName=积分抢兑专区
                 * create_time : 2017-12-26 12:47:42
                 */

                private int id;
                private String name;
                private String category_id;
                private String describe;
                private int need_score;
                private String bankcard;
                private String thumb;
                private Object thumbs;
                private String b_url;
                private String create_time;

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

                public String getCategory_id() {
                    return category_id;
                }

                public void setCategory_id(String category_id) {
                    this.category_id = category_id;
                }

                public String getDescribe() {
                    return describe;
                }

                public void setDescribe(String describe) {
                    this.describe = describe;
                }

                public int getNeed_score() {
                    return need_score;
                }

                public void setNeed_score(int need_score) {
                    this.need_score = need_score;
                }

                public String getBankcard() {
                    return bankcard;
                }

                public void setBankcard(String bankcard) {
                    this.bankcard = bankcard;
                }

                public String getThumb() {
                    return thumb;
                }

                public void setThumb(String thumb) {
                    this.thumb = thumb;
                }

                public Object getThumbs() {
                    return thumbs;
                }

                public void setThumbs(Object thumbs) {
                    this.thumbs = thumbs;
                }

                public String getB_url() {
                    return b_url;
                }

                public void setB_url(String b_url) {
                    this.b_url = b_url;
                }

                public String getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(String create_time) {
                    this.create_time = create_time;
                }
            }
        }

        public static class SellerCategoryListBean {
            /**
             * id : 1
             * name : 健康生活
             */

            private int id;
            private String name;

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
        }

        public static class BankcardListBean {
            /**
             * id : 1
             * name : 工商银行
             * describe : 中国工商银行，国有四大银行之一
             * card_icon : /upload/bank/icon/b1_big.png
             * card_thumb : /upload/bank/thumb/card1.png
             * card_img : /upload/bank/bank/y1.png
             */

            private int id;
            private String name;
            private String describe;
            private String card_icon;
            private String card_thumb;
            private String card_img;

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

            public String getCard_icon() {
                return card_icon;
            }

            public void setCard_icon(String card_icon) {
                this.card_icon = card_icon;
            }

            public String getCard_thumb() {
                return card_thumb;
            }

            public void setCard_thumb(String card_thumb) {
                this.card_thumb = card_thumb;
            }

            public String getCard_img() {
                return card_img;
            }

            public void setCard_img(String card_img) {
                this.card_img = card_img;
            }
        }
    }

//    /**
//     * code : 0
//     * msg : 操作成功
//     * data : [{"id":15,"name":"培训"},{"id":14,"name":"宠物"},{"id":13,"name":"爱车"},{"id":12,"name":"医疗健康"},{"id":11,"name":"生活"},{"id":10,"name":"购物"},{"id":9,"name":"运动健身"},{"id":8,"name":"旅游"},{"id":7,"name":"亲子"},{"id":6,"name":"酒店"},{"id":5,"name":"丽人"},{"id":4,"name":"电影演出"},{"id":3,"name":"结婚"},{"id":2,"name":"休闲娱乐"},{"id":1,"name":"美食"}]
//     * exe_time : 0.030002
//     */
//
//    private int code;
//    private String msg;
//    private String exe_time;
//    private List<DataBean> data;
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public String getExe_time() {
//        return exe_time;
//    }
//
//    public void setExe_time(String exe_time) {
//        this.exe_time = exe_time;
//    }
//
//    public List<DataBean> getData() {
//        return data;
//    }
//
//    public void setData(List<DataBean> data) {
//        this.data = data;
//    }
//
//    public static class DataBean {
//        /**
//         * id : 15
//         * name : 培训
//         */
//
//        private int id;
//        private String name;
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }

}
