package com.example.muhoitem1.model.domain.HomeData;

import java.util.List;

public class HomeTeachData {

    /**
     * data : [{"name":"最新教学","thumb":"https://m.muho.tv/128151_1527671759611_288x420.jpg","type":5},{"name":"季度教学","thumb":"https://m.muho.tv/110232_1518441296642_288x420.jpg","type":1},{"name":"技术教学","thumb":"https://m.muho.tv/110232_1518435372351_288x420.jpg","type":4}]
     * message : SUCCESS
     * stateCode : 200
     */

    private String message;
    private int stateCode;
    private List<DataBean> data;

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
         * name : 最新教学
         * thumb : https://m.muho.tv/128151_1527671759611_288x420.jpg
         * type : 5
         */

        private String name;
        private String thumb;
        private int type;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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
                    "name='" + name + '\'' +
                    ", thumb='" + thumb + '\'' +
                    ", type=" + type +
                    '}';
        }
    }
}
