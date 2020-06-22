package com.example.muhoitem1.model.domain;

import java.util.List;

public class HomeGraduateData {

    /**
     * data : [{"cid":0,"count":63,"icon":"https://m.muho.tv/gicon_1520408332752_228x240.jpg","name":"后卫","sid":25,"thumb":"https://m.muho.tv/90764_1541670490342_376x223.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","type":2},{"cid":0,"count":21,"icon":"https://m.muho.tv/gicon_1522137275923_228x240.jpg","name":"前锋","sid":26,"thumb":"https://m.muho.tv/90764_1541670536822_376x223.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","type":2},{"cid":0,"count":4,"icon":"https://m.muho.tv/90764_1552732954400_223x223.jpg","name":"中锋","sid":27,"thumb":"https://m.muho.tv/90764_1541670567794_376x223.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","type":2}]
     * data_num : 3
     * has_next : false
     * message : SUCCESS
     * stateCode : 200
     */

    private int data_num;
    private boolean has_next;
    private String message;
    private int stateCode;
    private List<DataBean> data;

    public int getData_num() {
        return data_num;
    }

    public void setData_num(int data_num) {
        this.data_num = data_num;
    }

    public boolean isHas_next() {
        return has_next;
    }

    public void setHas_next(boolean has_next) {
        this.has_next = has_next;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cid : 0
         * count : 63
         * icon : https://m.muho.tv/gicon_1520408332752_228x240.jpg
         * name : 后卫
         * sid : 25
         * thumb : https://m.muho.tv/90764_1541670490342_376x223.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100
         * type : 2
         */

        private int cid;
        private int count;
        private String icon;
        private String name;
        private int sid;
        private String thumb;
        private int type;

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "cid=" + cid +
                    ", count=" + count +
                    ", icon='" + icon + '\'' +
                    ", name='" + name + '\'' +
                    ", sid=" + sid +
                    ", thumb='" + thumb + '\'' +
                    ", type=" + type +
                    '}';
        }
    }
}
