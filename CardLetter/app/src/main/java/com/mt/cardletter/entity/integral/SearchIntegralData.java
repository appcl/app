package com.mt.cardletter.entity.integral;

import java.util.List;

/**
 * Date:2018/1/15
 * Time:15:31
 * author:demons
 */

public class SearchIntegralData {

    /**
     * code : 0
     * msg : 操作成功
     * data : {"total":2,"per_page":"10","current_page":1,"last_page":1,"data":[{"id":10,"name":"戴森落地式无叶风扇AM08","category_id":"2","describe":"型号：AM08。1、功率：最强气流可达（公升/秒）: 600；<\/br>2、全新Dyson Cool风扇，安全无扇叶，既安静、又强劲；<\/br>3、气流倍增技术，周围空气由环形气孔引入，加速放大后形成舒适而有力的气流；<\/br>4、马达壳采取减震设计，直流马达，更节能，更安静； <\/br>5、不设快速旋转叶片，且低重心设计。","need_score":2050000,"bankcard":"7","thumb":"/upload/img/nyyh/1714/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=775&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":269,"name":"戴森落地式无叶风扇AM08","category_id":"2","describe":"型号：AM08。1、功率：最强气流可达（公升/秒）: 600；<\/br>2、全新Dyson Cool风扇，安全无扇叶，既安静、又强劲；<\/br>3、气流倍增技术，周围空气由环形气孔引入，加速放大后形成舒适而有力的气流；<\/br>4、马达壳采取减震设计，直流马达，更节能，更安静； <\/br>5、不设快速旋转叶片，且低重心设计。","need_score":2050000,"bankcard":"7","thumb":"/upload/img/nyyh/1714/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=775&typeName=时尚人生","create_time":"2017-12-26 12:47:42"}]}
     * exe_time : 0.011301
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
         * total : 2
         * per_page : 10
         * current_page : 1
         * last_page : 1
         * data : [{"id":10,"name":"戴森落地式无叶风扇AM08","category_id":"2","describe":"型号：AM08。1、功率：最强气流可达（公升/秒）: 600；<\/br>2、全新Dyson Cool风扇，安全无扇叶，既安静、又强劲；<\/br>3、气流倍增技术，周围空气由环形气孔引入，加速放大后形成舒适而有力的气流；<\/br>4、马达壳采取减震设计，直流马达，更节能，更安静； <\/br>5、不设快速旋转叶片，且低重心设计。","need_score":2050000,"bankcard":"7","thumb":"/upload/img/nyyh/1714/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=775&typeName=时尚人生","create_time":"2017-12-26 12:47:42"},{"id":269,"name":"戴森落地式无叶风扇AM08","category_id":"2","describe":"型号：AM08。1、功率：最强气流可达（公升/秒）: 600；<\/br>2、全新Dyson Cool风扇，安全无扇叶，既安静、又强劲；<\/br>3、气流倍增技术，周围空气由环形气孔引入，加速放大后形成舒适而有力的气流；<\/br>4、马达壳采取减震设计，直流马达，更节能，更安静； <\/br>5、不设快速旋转叶片，且低重心设计。","need_score":2050000,"bankcard":"7","thumb":"/upload/img/nyyh/1714/1.jpg","thumbs":null,"b_url":"http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=775&typeName=时尚人生","create_time":"2017-12-26 12:47:42"}]
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
             * id : 10
             * name : 戴森落地式无叶风扇AM08
             * category_id : 2
             * describe : 型号：AM08。1、功率：最强气流可达（公升/秒）: 600；</br>2、全新Dyson Cool风扇，安全无扇叶，既安静、又强劲；</br>3、气流倍增技术，周围空气由环形气孔引入，加速放大后形成舒适而有力的气流；</br>4、马达壳采取减震设计，直流马达，更节能，更安静； </br>5、不设快速旋转叶片，且低重心设计。
             * need_score : 2050000
             * bankcard : 7
             * thumb : /upload/img/nyyh/1714/1.jpg
             * thumbs : null
             * b_url : http://www.abchina.com/cn/CreditCard/Gift/jfhl/default.htm?giftId=775&typeName=时尚人生
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
}
