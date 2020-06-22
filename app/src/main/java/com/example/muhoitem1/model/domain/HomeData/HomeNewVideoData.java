package com.example.muhoitem1.model.domain.HomeData;

import java.util.List;

public class HomeNewVideoData {

    /**
     * data : [{"cid":51654,"name":"菲尔汉迪 湖人新秀塔克 私人训练","thumb":"https://m.muho.tv/bXVob1RW_1592798024.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","title":"菲尔汉迪 湖人新秀塔克 私人训练","type":3},{"cid":51652,"name":"克里斯.约翰逊 6天双球运球系列教学 第四集","thumb":"https://m.muho.tv/bXVob1RW_1592716324.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","title":"克里斯.约翰逊 6天双球运球系列教学 第四集","type":3},{"cid":51651,"name":"你干什么呢？","thumb":"https://m.muho.tv/bXVob1RW_1592666007.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","title":"你干什么呢？","type":3},{"cid":51650,"name":"Skyy Clark 高光集锦","thumb":"https://m.muho.tv/bXVob1RW_1592663102.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","title":"Skyy Clark 高光集锦","type":3},{"cid":51649,"name":"克里斯.约翰逊 6天双球运球系列教学 第三集","thumb":"https://m.muho.tv/bXVob1RW_1592651386.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","title":"克里斯.约翰逊 6天双球运球系列教学 第三集","type":3},{"cid":51648,"name":"克里斯.约翰逊 6天双球运球系列教学 第二集","thumb":"https://m.muho.tv/bXVob1RW_1592542089.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","title":"克里斯.约翰逊 6天双球运球系列教学 第二集","type":3},{"cid":51647,"name":"注意两点，让你百发百中？","thumb":"https://m.muho.tv/bXVob1RW_1592487479.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","title":"注意两点，让你百发百中？","type":3},{"cid":51646,"name":"克里斯.约翰逊 6天双球运球系列教学 第一集","thumb":"https://m.muho.tv/bXVob1RW_1592453815.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","title":"克里斯.约翰逊 6天双球运球系列教学 第一集","type":3},{"cid":51645,"name":"Rob Mac x 凯索托 训练集锦","thumb":"https://m.muho.tv/bXVob1RW_1592370406.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","title":"Rob Mac x 凯索托 训练集锦","type":3},{"cid":51644,"name":"看我这球","thumb":"https://m.muho.tv/bXVob1RW_1592316703.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","title":"看我这球","type":3}]
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
         * cid : 51654
         * name : 菲尔汉迪 湖人新秀塔克 私人训练
         * thumb : https://m.muho.tv/bXVob1RW_1592798024.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100
         * title : 菲尔汉迪 湖人新秀塔克 私人训练
         * type : 3
         */

        private int cid;
        private String name;
        private String thumb;
        private String title;
        private int type;

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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
                    ", name='" + name + '\'' +
                    ", thumb='" + thumb + '\'' +
                    ", title='" + title + '\'' +
                    ", type=" + type +
                    '}';
        }
    }
}
