package com.example.muhoitem1.model.domain.HomeData;

import java.util.List;

public class HomePrivateData {

    /**
     * data : [{"cid":848,"sid":81,"skill":59,"tags":"克里斯·约翰逊","thumb":"https://m.muho.tv/bXVob1RW_1570593694.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","tid":1,"title":"西蒙斯，维金斯等NBA球员的野球训练","type":1,"update_time":1570428095,"video":"https://m.muho.tv/bXVob1RW_1570593686.mp4"},{"cid":843,"sid":81,"skill":59,"tags":"凯尔·奥奎因,训练","thumb":"https://m.muho.tv/bXVob1RW_1562053370.png?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","tid":10,"title":"凯尔·奥奎因的私人训练","type":1,"update_time":1562054216,"video":"https://m.muho.tv/bXVob1RW_1562054033.mp4"},{"cid":842,"sid":81,"skill":59,"tags":"克里斯·约翰逊,训练","thumb":"https://m.muho.tv/bXVob1RW_1561797741.png?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","tid":10,"title":"罗德尼·胡德的私人训练","type":1,"update_time":1561799223,"video":"https://m.muho.tv/bXVob1RW_1561798868.mp4"},{"cid":841,"sid":81,"skill":59,"tags":"马库斯·莫里斯","thumb":"https://m.muho.tv/bXVob1RW_1561708834.png?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","tid":10,"title":"马库斯·莫里斯的私人训练","type":1,"update_time":1561709188,"video":"https://m.muho.tv/bXVob1RW_1561709118.mp4"},{"cid":839,"sid":81,"skill":59,"tags":"迪昂·维特斯,训练","thumb":"https://m.muho.tv/bXVob1RW_1561537139.png?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","tid":10,"title":"迪昂·维特斯的私人训练","type":1,"update_time":1561538285,"video":"https://m.muho.tv/bXVob1RW_1561538186.mp4"},{"cid":832,"sid":81,"skill":59,"tags":"凯文·杜兰特,奎因·库克","thumb":"https://m.muho.tv/bXVob1RW_1554804553.png?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","tid":10,"title":"杜兰特，奎因·库克的私人训练！","type":1,"update_time":1554804804,"video":"https://m.muho.tv/bXVob1RW_1554804587.mp4"},{"cid":691,"sid":81,"skill":59,"tags":"ncaa,幕后教学,后卫","thumb":"https://m.muho.tv/0_1528965910.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","tid":1,"title":"JELLYFAM创始人以赛亚.华盛顿的最新夏季私人特训！","type":1,"update_time":1528965975,"video":"https://m.muho.tv/128156_1528965886.mp4"},{"cid":1,"sid":81,"skill":112,"tags":"罗伯托·尼尔森,私人训练","thumb":"https://m.muho.tv/RenoWorkout1_20140529.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","tid":1,"title":"准备NBA各队选秀前的测试,罗斯指导罗伯托·尼尔森做一系列的训练","type":1,"update_time":1514876949,"video":"https://m.muho.tv/RenoWorkout1_20140529.mp4"},{"cid":2,"sid":81,"skill":117,"tags":"罗伯托·尼尔森,私人训练","thumb":"https://m.muho.tv/RenoWorkout2_20140604.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","tid":1,"title":"准备NBA各队选秀前的测试,罗斯指导罗伯托·尼尔森做一系列的训练2","type":1,"update_time":1514876949,"video":"https://m.muho.tv/RenoWorkout2_20140604.mp4"},{"cid":3,"sid":81,"skill":117,"tags":"罗伯托·尼尔森,私人训练","thumb":"https://m.muho.tv/RenoWorkout3_20140606.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100","tid":1,"title":"准备NBA各队选秀前的测试,罗斯指导罗伯托·尼尔森做一系列的训练3","type":1,"update_time":1514876949,"video":"https://m.muho.tv/RenoWorkout3_20140606.mp4"}]
     * data_num : 66
     * has_next : true
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
         * cid : 848
         * sid : 81
         * skill : 59
         * tags : 克里斯·约翰逊
         * thumb : https://m.muho.tv/bXVob1RW_1570593694.jpg?imageView2/1/w/372/h/244/format/jpg/interlace/1/q/100
         * tid : 1
         * title : 西蒙斯，维金斯等NBA球员的野球训练
         * type : 1
         * update_time : 1570428095
         * video : https://m.muho.tv/bXVob1RW_1570593686.mp4
         */

        private int cid;
        private int sid;
        private int skill;
        private String tags;
        private String thumb;
        private int tid;
        private String title;
        private int type;
        private int update_time;
        private String video;

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }

        public int getSkill() {
            return skill;
        }

        public void setSkill(int skill) {
            this.skill = skill;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
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

        public int getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(int update_time) {
            this.update_time = update_time;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "cid=" + cid +
                    ", sid=" + sid +
                    ", skill=" + skill +
                    ", tags='" + tags + '\'' +
                    ", thumb='" + thumb + '\'' +
                    ", tid=" + tid +
                    ", title='" + title + '\'' +
                    ", type=" + type +
                    ", update_time=" + update_time +
                    ", video='" + video + '\'' +
                    '}';
        }
    }
}
