package com.example.muhoitem1.model.domain;

import java.util.List;

public class HomePayAlbumListData {

    /**
     * data : [{"coid":3,"cons":6,"name":"克里斯·约翰逊 6天双球运球系列教学","sid":18,"thumb":"https://m.muho.tv/bXVob1RW_1592453386.jpg?imageView2/1/w/340/h/200/interlace/1"},{"coid":1,"cons":8,"name":"菲尔·汉迪 7天运球上篮/投篮教学","sid":17,"thumb":"https://m.muho.tv/bXVob1RW_1591459803.jpg?imageView2/1/w/340/h/200/interlace/1"},{"coid":1,"cons":5,"name":"菲尔·汉迪 5天运球上篮教学","sid":16,"thumb":"https://m.muho.tv/bXVob1RW_1590983452.jpg?imageView2/1/w/340/h/200/interlace/1"},{"coid":1,"cons":6,"name":"菲尔·汉迪 6天运球教学","sid":15,"thumb":"https://m.muho.tv/bXVob1RW_1590381788.jpg?imageView2/1/w/340/h/200/interlace/1"},{"coid":1,"cons":9,"name":"菲尔·汉迪 7天运球教学","sid":14,"thumb":"https://m.muho.tv/bXVob1RW_1589606819.jpg?imageView2/1/w/340/h/200/interlace/1"},{"coid":3,"cons":4,"name":"克里斯.约翰逊直线突破终结系列教学","sid":13,"thumb":"https://m.muho.tv/bXVob1RW_1588047733.jpg?imageView2/1/w/340/h/200/interlace/1"},{"coid":3,"cons":7,"name":"克里斯.约翰逊垫步运球系列教学","sid":12,"thumb":"https://m.muho.tv/bXVob1RW_1587449175.jpg?imageView2/1/w/340/h/200/interlace/1"},{"coid":3,"cons":7,"name":"克里斯.约翰逊内外翻运球系列教学","sid":11,"thumb":"https://m.muho.tv/bXVob1RW_1586835906.jpg?imageView2/1/w/340/h/200/interlace/1"},{"coid":1,"cons":23,"name":"菲尔·汉迪&哈里森·巴恩斯教学","sid":6,"thumb":"https://m.muho.tv/bXVob1RW_1569585283.png?imageView2/1/w/340/h/200/interlace/1"},{"coid":1,"cons":22,"name":"菲尔·汉迪&史蒂夫·纳什教学","sid":4,"thumb":"https://m.muho.tv/0_1567053765.jpg?imageView2/1/w/340/h/200/interlace/1"},{"coid":1,"cons":19,"name":"菲尔·汉迪&马利克·比斯利教学","sid":5,"thumb":"https://m.muho.tv/0_1567139831.jpg?imageView2/1/w/340/h/200/interlace/1"},{"coid":1,"cons":14,"name":"菲尔·汉迪&达蒙·哈特教学","sid":7,"thumb":"https://m.muho.tv/bXVob1RW_1569317867.jpg?imageView2/1/w/340/h/200/interlace/1"},{"coid":1,"cons":21,"name":"菲尔·汉迪&贾旺·埃文斯教学","sid":8,"thumb":"https://m.muho.tv/bXVob1RW_1569317951.jpg?imageView2/1/w/340/h/200/interlace/1"},{"coid":1,"cons":25,"name":"菲尔·汉迪&麦肯·锡摩尔教学","sid":9,"thumb":"https://m.muho.tv/bXVob1RW_1569317876.jpg?imageView2/1/w/340/h/200/interlace/1"},{"coid":1,"cons":21,"name":"菲尔·汉迪&瑞安教学","sid":10,"thumb":"https://m.muho.tv/bXVob1RW_1569317332.jpg?imageView2/1/w/340/h/200/interlace/1"},{"coid":2,"cons":34,"name":"防守悍将","sid":1,"thumb":"https://m.muho.tv/bXVob1RW_1567151209.jpg?imageView2/1/w/340/h/200/interlace/1"},{"coid":2,"cons":38,"name":"精准传球","sid":2,"thumb":"https://m.muho.tv/bXVob1RW_1567151240.jpg?imageView2/1/w/340/h/200/interlace/1"},{"coid":2,"cons":41,"name":"控球大师","sid":3,"thumb":"https://m.muho.tv/bXVob1RW_1567151259.jpg?imageView2/1/w/340/h/200/interlace/1"}]
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
         * coid : 3
         * cons : 6
         * name : 克里斯·约翰逊 6天双球运球系列教学
         * sid : 18
         * thumb : https://m.muho.tv/bXVob1RW_1592453386.jpg?imageView2/1/w/340/h/200/interlace/1
         */

        private int coid;
        private int cons;
        private String name;
        private int sid;
        private String thumb;

        public int getCoid() {
            return coid;
        }

        public void setCoid(int coid) {
            this.coid = coid;
        }

        public int getCons() {
            return cons;
        }

        public void setCons(int cons) {
            this.cons = cons;
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

        @Override
        public String toString() {
            return "DataBean{" +
                    "coid=" + coid +
                    ", cons=" + cons +
                    ", name='" + name + '\'' +
                    ", sid=" + sid +
                    ", thumb='" + thumb + '\'' +
                    '}';
        }
    }
}
