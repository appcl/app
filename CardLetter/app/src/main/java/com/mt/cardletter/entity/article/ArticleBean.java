package com.mt.cardletter.entity.article;

import java.io.Serializable;
import java.util.List;

/**
 * Date:2018/1/2
 * Time:16:26
 * author:demons
 */

public class ArticleBean implements Serializable{

    /**
     * code : 0
     * msg : 操作成功
     * data : {"total":24,"per_page":"10","current_page":1,"last_page":3,"data":[{"id":46,"name":"双11的快递都收完了，可双11刷爆的信用卡怎么还？","category_id":7,"describe":"现在已是11月中旬了，大家双11的快递都收完了吗?emmm......不过今天小编想和大家聊一个现实问题，你双11刷爆的信用卡，该怎么还呢?不知道？那小编告诉大家几个小方法。","create_time":"2017-12-29 00:12:41"},{"id":45,"name":"信用卡的7个坑，80%的人都不知道！","category_id":7,"describe":"现在几乎人人都有一张或几张信用卡，但是你真的会用信用卡吗?关于信用卡的这些坑，你真的了解吗?","create_time":"2017-12-21 02:57:35"},{"id":44,"name":"招行信用卡及积分兑换，各大视频网站等你追剧","category_id":7,"describe":"现在的年轻人大部分会选择在视频网站观看最新的影视资源，不用忍受烦人的广告，也不用守着电视等时间。最重要的是资源丰富，如果你是会员的话更可以无障碍享用各种独家资源，大家都知道视频网站的会员是需要购买的，其实使用招行信用卡积分兑换就能拥有。","create_time":"2017-12-20 23:09:23"},{"id":43,"name":"招行信用卡不激活收年费吗？","category_id":9,"describe":"我们有时候办信用卡并非是由于有需要，很多时候是由于其他原因，或许是赠品或许是为了给朋友帮忙。这样申请下来的信用卡有可能并不想开卡使用，但是这样的情况会被收取年费吗?","create_time":"2017-12-20 23:09:17"},{"id":42,"name":"招商银行信用卡青年额度范围是多少？","category_id":7,"describe":"我们对信用卡最为好奇的就是信用卡的额度到底是怎么确定的呢?不同卡种的额度范围又是怎样的呢?","create_time":"2017-12-20 23:08:08"},{"id":41,"name":"招商银行网易新闻联名信用卡值得办理吗？","category_id":9,"describe":"招商银行最近与网易新闻联合推出了联名信用卡，这张信用卡有什么特别之处吗?是不是值得办理呢?今天我们就来好好了解一下这张卡。","create_time":"2017-12-19 18:30:31"},{"id":40,"name":"工行哪些信用卡可以免年费","category_id":8,"describe":"工行网点遍布全国，信用卡种类非常丰富，那么你知道工行哪些信用卡可以免年费吗?一般来讲，普通信用卡只要达到一定的刷卡次数就可以获得免年费的待遇。","create_time":"2017-12-05 18:53:14"},{"id":39,"name":"招行信用卡账单日如何修改?","category_id":8,"describe":"手里的信用卡越办越多，账单日也都不是一天，平时还款总是提心吊胆，总会害怕错过某一张卡片。那么，招商银行信用卡账单能修改吗?如何修改呢?","create_time":"2017-12-05 18:51:24"},{"id":38,"name":"招联好期贷上征信吗?如果还不上会有什么影响?","category_id":10,"describe":"招联好期贷是招联金融推出的一个贷款平台，用户可以在招联好期贷平台上获得一定的信用，然后可以在平台上申请贷款。但是如果到期还不上款，招联好期贷上征信吗?有什么影响呢?","create_time":"2017-12-01 10:54:29"},{"id":37,"name":"光大银行信用卡又有新动作 推出移动账单","category_id":8,"describe":"光大银行信用卡账单业务再次做出革新升级，继互动式电子账单后，再次推出了移动账单业务。那么，具体是个什么东东呢，下面跟随小编去了解一下。","create_time":"2017-12-01 10:52:55"}]}
     * exe_time : 0.043003
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

    public static class DataBeanX implements Serializable{
        /**
         * total : 24
         * per_page : 10
         * current_page : 1
         * last_page : 3
         * data : [{"id":46,"name":"双11的快递都收完了，可双11刷爆的信用卡怎么还？","category_id":7,"describe":"现在已是11月中旬了，大家双11的快递都收完了吗?emmm......不过今天小编想和大家聊一个现实问题，你双11刷爆的信用卡，该怎么还呢?不知道？那小编告诉大家几个小方法。","create_time":"2017-12-29 00:12:41"},{"id":45,"name":"信用卡的7个坑，80%的人都不知道！","category_id":7,"describe":"现在几乎人人都有一张或几张信用卡，但是你真的会用信用卡吗?关于信用卡的这些坑，你真的了解吗?","create_time":"2017-12-21 02:57:35"},{"id":44,"name":"招行信用卡及积分兑换，各大视频网站等你追剧","category_id":7,"describe":"现在的年轻人大部分会选择在视频网站观看最新的影视资源，不用忍受烦人的广告，也不用守着电视等时间。最重要的是资源丰富，如果你是会员的话更可以无障碍享用各种独家资源，大家都知道视频网站的会员是需要购买的，其实使用招行信用卡积分兑换就能拥有。","create_time":"2017-12-20 23:09:23"},{"id":43,"name":"招行信用卡不激活收年费吗？","category_id":9,"describe":"我们有时候办信用卡并非是由于有需要，很多时候是由于其他原因，或许是赠品或许是为了给朋友帮忙。这样申请下来的信用卡有可能并不想开卡使用，但是这样的情况会被收取年费吗?","create_time":"2017-12-20 23:09:17"},{"id":42,"name":"招商银行信用卡青年额度范围是多少？","category_id":7,"describe":"我们对信用卡最为好奇的就是信用卡的额度到底是怎么确定的呢?不同卡种的额度范围又是怎样的呢?","create_time":"2017-12-20 23:08:08"},{"id":41,"name":"招商银行网易新闻联名信用卡值得办理吗？","category_id":9,"describe":"招商银行最近与网易新闻联合推出了联名信用卡，这张信用卡有什么特别之处吗?是不是值得办理呢?今天我们就来好好了解一下这张卡。","create_time":"2017-12-19 18:30:31"},{"id":40,"name":"工行哪些信用卡可以免年费","category_id":8,"describe":"工行网点遍布全国，信用卡种类非常丰富，那么你知道工行哪些信用卡可以免年费吗?一般来讲，普通信用卡只要达到一定的刷卡次数就可以获得免年费的待遇。","create_time":"2017-12-05 18:53:14"},{"id":39,"name":"招行信用卡账单日如何修改?","category_id":8,"describe":"手里的信用卡越办越多，账单日也都不是一天，平时还款总是提心吊胆，总会害怕错过某一张卡片。那么，招商银行信用卡账单能修改吗?如何修改呢?","create_time":"2017-12-05 18:51:24"},{"id":38,"name":"招联好期贷上征信吗?如果还不上会有什么影响?","category_id":10,"describe":"招联好期贷是招联金融推出的一个贷款平台，用户可以在招联好期贷平台上获得一定的信用，然后可以在平台上申请贷款。但是如果到期还不上款，招联好期贷上征信吗?有什么影响呢?","create_time":"2017-12-01 10:54:29"},{"id":37,"name":"光大银行信用卡又有新动作 推出移动账单","category_id":8,"describe":"光大银行信用卡账单业务再次做出革新升级，继互动式电子账单后，再次推出了移动账单业务。那么，具体是个什么东东呢，下面跟随小编去了解一下。","create_time":"2017-12-01 10:52:55"}]
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

        public static class DataBean implements Serializable{
            /**
             * id : 46
             * name : 双11的快递都收完了，可双11刷爆的信用卡怎么还？
             * category_id : 7
             * describe : 现在已是11月中旬了，大家双11的快递都收完了吗?emmm......不过今天小编想和大家聊一个现实问题，你双11刷爆的信用卡，该怎么还呢?不知道？那小编告诉大家几个小方法。
             * create_time : 2017-12-29 00:12:41
             */

            private int id;
            private String name;
            private int category_id;
            private String describe;
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

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }
        }
    }
}
