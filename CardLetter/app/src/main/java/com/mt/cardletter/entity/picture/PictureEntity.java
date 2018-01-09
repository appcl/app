package com.mt.cardletter.entity.picture;

import java.util.List;

/**
 * Date:2018/1/6
 * Time:14:30
 * author:demons
 */

public class PictureEntity {

    /**
     * code : 0
     * msg : 操作成功
     * data : [{"total":1,"per_page":"10","current_page":1,"last_page":1,"data":[{"id":9,"name":"234234","title":"234234","group":3,"cover_id":50,"thumb":"/upload/picture/20180103/a5d0170a246fc90666c7daa1c43b715e.jpg","describe":"234"}]}]
     * exe_time : 0.029002
     */

    private int code;
    private String msg;
    private String exe_time;
    private List<DataBeanX> data;

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

    public String getExe_time() {
        return exe_time;
    }

    public void setExe_time(String exe_time) {
        this.exe_time = exe_time;
    }

    public List<DataBeanX> getData() {
        return data;
    }

    public void setData(List<DataBeanX> data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * total : 1
         * per_page : 10
         * current_page : 1
         * last_page : 1
         * data : [{"id":9,"name":"234234","title":"234234","group":3,"cover_id":50,"thumb":"/upload/picture/20180103/a5d0170a246fc90666c7daa1c43b715e.jpg","describe":"234"}]
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
             * id : 9
             * name : 234234
             * title : 234234
             * group : 3
             * cover_id : 50
             * thumb : /upload/picture/20180103/a5d0170a246fc90666c7daa1c43b715e.jpg
             * describe : 234
             */

            private int id;
            private String name;
            private String title;
            private int group;
            private int cover_id;
            private String thumb;
            private String describe;

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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getGroup() {
                return group;
            }

            public void setGroup(int group) {
                this.group = group;
            }

            public int getCover_id() {
                return cover_id;
            }

            public void setCover_id(int cover_id) {
                this.cover_id = cover_id;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }
        }
    }
}
