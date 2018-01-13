package com.mt.cardletter.entity.news;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2018/1/9.
 */

public class News {

    /**
     * code : 0
     * msg : 操作成功
     * data : {"total":29,"per_page":15,"current_page":1,"last_page":2,"data":[{"id":51,"name":"2018，京东指定用卡就是这张了！","category_id":12,"thumb":"/upload/picture/20180109/f158f1223f9cfb126c5dc3b716147a59.jpg","cover_id":79,"describe":"最近小编一位经常在京东上剁手的小伙伴向小编吐槽，自从不能用信用卡还白条，以及有一些白条卡联名卡权益过期后，在京东购物，还真找不到一张特别合适的信用卡了。咳咳，今天小编就向大家介绍一下光大银行的『积分百宝箱』活动，这几个月在京东上买东西，大家就不用发愁用哪张卡了!","city":null,"create_time":"2018-01-09 15:26:30"},{"id":50,"name":"浦发万事达无价卡权益介绍，境外血拼返利高达7%！","category_id":12,"thumb":"/upload/picture/20180109/fbf9313fd3b3b6b59ef46575f5405387.jpg","cover_id":78,"describe":"各路卡友看这里，今天小编为大家介绍一张神卡!不仅颜值高，还超级适合适合境外买买买!从来没有拥有过浦发信用卡的小伙伴们，可以无脑获得超过5%的返利，无上限哦~~~","city":null,"create_time":"2018-01-09 15:25:43"},{"id":49,"name":"邮储银联卡福利，健身场馆消费立享20元特惠！","category_id":12,"thumb":"/upload/picture/20180109/3227937077e957191f822d11a8513ec3.jpg","cover_id":77,"describe":"天气越来越冷，怎么做才能让自己暖和起来?答案当然是&amp;mdash;&amp;mdash;运动啊!拥有邮储信用卡的小伙伴们，周二、周六游泳、健身、羽毛球可享20元优惠价!","city":null,"create_time":"2018-01-09 15:24:18"},{"id":48,"name":"交行卡福利|信用卡绑定微信支付，满额就送刷卡金！","category_id":12,"thumb":"/upload/picture/20180109/23d9a751c13ef486304f71bd6bc662dc.jpg","cover_id":76,"describe":"拥有交通银行信用卡的宝宝们看过来!小编有一个好消息要宣布：即日起将信用卡与微信支付绑定，满额就送刷卡金哦!","city":null,"create_time":"2018-01-09 15:23:36"},{"id":47,"name":"必胜客优惠活动精彩来袭，早餐满20元立减10元！","category_id":12,"thumb":"/upload/picture/20180109/00de65ccca016ff5596edde311ec234a.jpg","cover_id":75,"describe":"周末亲子时间，大家打算带孩子去哪里吃大餐呢?哼哼，告诉你们一个好消息：小朋友们都爱吃的必胜客有优惠哦!","city":null,"create_time":"2018-01-09 15:22:37"},{"id":46,"name":"双11的快递都收完了，可双11刷爆的信用卡怎么还？","category_id":7,"thumb":"/upload/picture/20180104/7660ee059a191d22ca7922ce850d18f6.jpg","cover_id":55,"describe":"现在已是11月中旬了，大家双11的快递都收完了吗?emmm......不过今天小编想和大家聊一个现实问题，你双11刷爆的信用卡，该怎么还呢?不知道？那小编告诉大家几个小方法。","city":null,"create_time":"2017-12-29 00:12:41"},{"id":45,"name":"信用卡的7个坑，80%的人都不知道！","category_id":7,"thumb":"/upload/picture/20180107/8f3ffa5617d1731f55a1e399e85307df.jpg","cover_id":70,"describe":"现在几乎人人都有一张或几张信用卡，但是你真的会用信用卡吗?关于信用卡的这些坑，你真的了解吗?","city":null,"create_time":"2017-12-21 02:57:35"},{"id":44,"name":"招行信用卡及积分兑换，各大视频网站等你追剧","category_id":7,"thumb":"/upload/picture/20180107/9e0192aeb38cab4ae2e4df0b40cacee0.jpg","cover_id":65,"describe":"现在的年轻人大部分会选择在视频网站观看最新的影视资源，不用忍受烦人的广告，也不用守着电视等时间。最重要的是资源丰富，如果你是会员的话更可以无障碍享用各种独家资源，大家都知道视频网站的会员是需要购买的，其实使用招行信用卡积分兑换就能拥有。","city":null,"create_time":"2017-12-20 23:09:23"},{"id":43,"name":"招行信用卡不激活收年费吗？","category_id":9,"thumb":"/upload/picture/20180107/5f0caad55733648a75794a625427848b.jpg","cover_id":66,"describe":"我们有时候办信用卡并非是由于有需要，很多时候是由于其他原因，或许是赠品或许是为了给朋友帮忙。这样申请下来的信用卡有可能并不想开卡使用，但是这样的情况会被收取年费吗?","city":null,"create_time":"2017-12-20 23:09:17"},{"id":42,"name":"招商银行信用卡青年额度范围是多少？","category_id":7,"thumb":"/upload/picture/20180107/4bea762202afa0dd73cb1a6e81e857dc.jpg","cover_id":67,"describe":"我们对信用卡最为好奇的就是信用卡的额度到底是怎么确定的呢?不同卡种的额度范围又是怎样的呢?","city":null,"create_time":"2017-12-20 23:08:08"},{"id":41,"name":"招商银行网易新闻联名信用卡值得办理吗？","category_id":9,"thumb":"/upload/picture/20180107/f8dee53a469f4c9577378500ca4c33d8.jpg","cover_id":64,"describe":"招商银行最近与网易新闻联合推出了联名信用卡，这张信用卡有什么特别之处吗?是不是值得办理呢?今天我们就来好好了解一下这张卡。","city":null,"create_time":"2017-12-19 18:30:31"},{"id":40,"name":"工行哪些信用卡可以免年费","category_id":8,"thumb":"/upload/picture/20180107/e3ef6f39af86e2aa9099f4657f3537d9.jpg","cover_id":68,"describe":"工行网点遍布全国，信用卡种类非常丰富，那么你知道工行哪些信用卡可以免年费吗?一般来讲，普通信用卡只要达到一定的刷卡次数就可以获得免年费的待遇。","city":null,"create_time":"2017-12-05 18:53:14"},{"id":39,"name":"招行信用卡账单日如何修改?","category_id":8,"thumb":"/upload/picture/20180107/6ef665df981c83b6f873a627f7f0e71c.jpg","cover_id":69,"describe":"手里的信用卡越办越多，账单日也都不是一天，平时还款总是提心吊胆，总会害怕错过某一张卡片。那么，招商银行信用卡账单能修改吗?如何修改呢?","city":null,"create_time":"2017-12-05 18:51:24"},{"id":38,"name":"招联好期贷上征信吗?如果还不上会有什么影响?","category_id":10,"thumb":"/upload/picture/20180107/e3ef6f39af86e2aa9099f4657f3537d9.jpg","cover_id":68,"describe":"招联好期贷是招联金融推出的一个贷款平台，用户可以在招联好期贷平台上获得一定的信用，然后可以在平台上申请贷款。但是如果到期还不上款，招联好期贷上征信吗?有什么影响呢?","city":null,"create_time":"2017-12-01 10:54:29"},{"id":37,"name":"光大银行信用卡又有新动作 推出移动账单","category_id":8,"thumb":"/upload/picture/20180107/ca23f32e9b8b99cd8ec190e7bb78aab1.jpg","cover_id":71,"describe":"光大银行信用卡账单业务再次做出革新升级，继互动式电子账单后，再次推出了移动账单业务。那么，具体是个什么东东呢，下面跟随小编去了解一下。","city":null,"create_time":"2017-12-01 10:52:55"}]}
     * exe_time : 0.035002
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
         * total : 29
         * per_page : 15
         * current_page : 1
         * last_page : 2
         * data : [{"id":51,"name":"2018，京东指定用卡就是这张了！","category_id":12,"thumb":"/upload/picture/20180109/f158f1223f9cfb126c5dc3b716147a59.jpg","cover_id":79,"describe":"最近小编一位经常在京东上剁手的小伙伴向小编吐槽，自从不能用信用卡还白条，以及有一些白条卡联名卡权益过期后，在京东购物，还真找不到一张特别合适的信用卡了。咳咳，今天小编就向大家介绍一下光大银行的『积分百宝箱』活动，这几个月在京东上买东西，大家就不用发愁用哪张卡了!","city":null,"create_time":"2018-01-09 15:26:30"},{"id":50,"name":"浦发万事达无价卡权益介绍，境外血拼返利高达7%！","category_id":12,"thumb":"/upload/picture/20180109/fbf9313fd3b3b6b59ef46575f5405387.jpg","cover_id":78,"describe":"各路卡友看这里，今天小编为大家介绍一张神卡!不仅颜值高，还超级适合适合境外买买买!从来没有拥有过浦发信用卡的小伙伴们，可以无脑获得超过5%的返利，无上限哦~~~","city":null,"create_time":"2018-01-09 15:25:43"},{"id":49,"name":"邮储银联卡福利，健身场馆消费立享20元特惠！","category_id":12,"thumb":"/upload/picture/20180109/3227937077e957191f822d11a8513ec3.jpg","cover_id":77,"describe":"天气越来越冷，怎么做才能让自己暖和起来?答案当然是&amp;mdash;&amp;mdash;运动啊!拥有邮储信用卡的小伙伴们，周二、周六游泳、健身、羽毛球可享20元优惠价!","city":null,"create_time":"2018-01-09 15:24:18"},{"id":48,"name":"交行卡福利|信用卡绑定微信支付，满额就送刷卡金！","category_id":12,"thumb":"/upload/picture/20180109/23d9a751c13ef486304f71bd6bc662dc.jpg","cover_id":76,"describe":"拥有交通银行信用卡的宝宝们看过来!小编有一个好消息要宣布：即日起将信用卡与微信支付绑定，满额就送刷卡金哦!","city":null,"create_time":"2018-01-09 15:23:36"},{"id":47,"name":"必胜客优惠活动精彩来袭，早餐满20元立减10元！","category_id":12,"thumb":"/upload/picture/20180109/00de65ccca016ff5596edde311ec234a.jpg","cover_id":75,"describe":"周末亲子时间，大家打算带孩子去哪里吃大餐呢?哼哼，告诉你们一个好消息：小朋友们都爱吃的必胜客有优惠哦!","city":null,"create_time":"2018-01-09 15:22:37"},{"id":46,"name":"双11的快递都收完了，可双11刷爆的信用卡怎么还？","category_id":7,"thumb":"/upload/picture/20180104/7660ee059a191d22ca7922ce850d18f6.jpg","cover_id":55,"describe":"现在已是11月中旬了，大家双11的快递都收完了吗?emmm......不过今天小编想和大家聊一个现实问题，你双11刷爆的信用卡，该怎么还呢?不知道？那小编告诉大家几个小方法。","city":null,"create_time":"2017-12-29 00:12:41"},{"id":45,"name":"信用卡的7个坑，80%的人都不知道！","category_id":7,"thumb":"/upload/picture/20180107/8f3ffa5617d1731f55a1e399e85307df.jpg","cover_id":70,"describe":"现在几乎人人都有一张或几张信用卡，但是你真的会用信用卡吗?关于信用卡的这些坑，你真的了解吗?","city":null,"create_time":"2017-12-21 02:57:35"},{"id":44,"name":"招行信用卡及积分兑换，各大视频网站等你追剧","category_id":7,"thumb":"/upload/picture/20180107/9e0192aeb38cab4ae2e4df0b40cacee0.jpg","cover_id":65,"describe":"现在的年轻人大部分会选择在视频网站观看最新的影视资源，不用忍受烦人的广告，也不用守着电视等时间。最重要的是资源丰富，如果你是会员的话更可以无障碍享用各种独家资源，大家都知道视频网站的会员是需要购买的，其实使用招行信用卡积分兑换就能拥有。","city":null,"create_time":"2017-12-20 23:09:23"},{"id":43,"name":"招行信用卡不激活收年费吗？","category_id":9,"thumb":"/upload/picture/20180107/5f0caad55733648a75794a625427848b.jpg","cover_id":66,"describe":"我们有时候办信用卡并非是由于有需要，很多时候是由于其他原因，或许是赠品或许是为了给朋友帮忙。这样申请下来的信用卡有可能并不想开卡使用，但是这样的情况会被收取年费吗?","city":null,"create_time":"2017-12-20 23:09:17"},{"id":42,"name":"招商银行信用卡青年额度范围是多少？","category_id":7,"thumb":"/upload/picture/20180107/4bea762202afa0dd73cb1a6e81e857dc.jpg","cover_id":67,"describe":"我们对信用卡最为好奇的就是信用卡的额度到底是怎么确定的呢?不同卡种的额度范围又是怎样的呢?","city":null,"create_time":"2017-12-20 23:08:08"},{"id":41,"name":"招商银行网易新闻联名信用卡值得办理吗？","category_id":9,"thumb":"/upload/picture/20180107/f8dee53a469f4c9577378500ca4c33d8.jpg","cover_id":64,"describe":"招商银行最近与网易新闻联合推出了联名信用卡，这张信用卡有什么特别之处吗?是不是值得办理呢?今天我们就来好好了解一下这张卡。","city":null,"create_time":"2017-12-19 18:30:31"},{"id":40,"name":"工行哪些信用卡可以免年费","category_id":8,"thumb":"/upload/picture/20180107/e3ef6f39af86e2aa9099f4657f3537d9.jpg","cover_id":68,"describe":"工行网点遍布全国，信用卡种类非常丰富，那么你知道工行哪些信用卡可以免年费吗?一般来讲，普通信用卡只要达到一定的刷卡次数就可以获得免年费的待遇。","city":null,"create_time":"2017-12-05 18:53:14"},{"id":39,"name":"招行信用卡账单日如何修改?","category_id":8,"thumb":"/upload/picture/20180107/6ef665df981c83b6f873a627f7f0e71c.jpg","cover_id":69,"describe":"手里的信用卡越办越多，账单日也都不是一天，平时还款总是提心吊胆，总会害怕错过某一张卡片。那么，招商银行信用卡账单能修改吗?如何修改呢?","city":null,"create_time":"2017-12-05 18:51:24"},{"id":38,"name":"招联好期贷上征信吗?如果还不上会有什么影响?","category_id":10,"thumb":"/upload/picture/20180107/e3ef6f39af86e2aa9099f4657f3537d9.jpg","cover_id":68,"describe":"招联好期贷是招联金融推出的一个贷款平台，用户可以在招联好期贷平台上获得一定的信用，然后可以在平台上申请贷款。但是如果到期还不上款，招联好期贷上征信吗?有什么影响呢?","city":null,"create_time":"2017-12-01 10:54:29"},{"id":37,"name":"光大银行信用卡又有新动作 推出移动账单","category_id":8,"thumb":"/upload/picture/20180107/ca23f32e9b8b99cd8ec190e7bb78aab1.jpg","cover_id":71,"describe":"光大银行信用卡账单业务再次做出革新升级，继互动式电子账单后，再次推出了移动账单业务。那么，具体是个什么东东呢，下面跟随小编去了解一下。","city":null,"create_time":"2017-12-01 10:52:55"}]
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
             * id : 51
             * name : 2018，京东指定用卡就是这张了！
             * category_id : 12
             * thumb : /upload/picture/20180109/f158f1223f9cfb126c5dc3b716147a59.jpg
             * cover_id : 79
             * describe : 最近小编一位经常在京东上剁手的小伙伴向小编吐槽，自从不能用信用卡还白条，以及有一些白条卡联名卡权益过期后，在京东购物，还真找不到一张特别合适的信用卡了。咳咳，今天小编就向大家介绍一下光大银行的『积分百宝箱』活动，这几个月在京东上买东西，大家就不用发愁用哪张卡了!
             * city : null
             * create_time : 2018-01-09 15:26:30
             */

            @SerializedName("id")
            private int id;
            @SerializedName("name")
            private String name;
            @SerializedName("category_id")
            private int categoryId;
            @SerializedName("thumb")
            private String thumb;
            @SerializedName("cover_id")
            private int coverId;
            @SerializedName("describe")
            private String describe;
            @SerializedName("city")
            private Object city;
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

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public int getCoverId() {
                return coverId;
            }

            public void setCoverId(int coverId) {
                this.coverId = coverId;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }

            public Object getCity() {
                return city;
            }

            public void setCity(Object city) {
                this.city = city;
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
